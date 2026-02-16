package com.blosny.logscope.infrastructure.adapters.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.blosny.logscope.domain.service.AiAnalysisService;

@Component
public class GeminiAiAdapter implements AiAnalysisService {

    private final RestClient restClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    public GeminiAiAdapter() {
        this.restClient = RestClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com")
                .build();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String analyzeError(String message, String stackTrace) {

        System.out.println("DEBUG: AI Analizi başlatılıyor...");

        String prompt = """
                Aşağıdaki yazılım hatasını analiz et.
                Çok kısa ve net bir açıklama yap (maksimum 2 cümle).
                Hemen uygulanabilecek tek bir kod satırı veya yöntem öner.
                Laubali olma, sadece teknik gerçekleri söyle.

                Hata: %s
                Detay: %s
                """.formatted(message, stackTrace);

        try {
            Map<String, Object> requestBody = Map.of(
                    "contents", List.of(
                            Map.of("parts", List.of(
                                    Map.of("text", prompt)))));

            Map<String, Object> response = restClient.post()
                    .uri(uriBuilder -> uriBuilder
                            .path("/v1beta/models/gemini-2.5-flash:generateContent")
                            .queryParam("key", apiKey)
                            .build())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestBody)
                    .retrieve()
                    .body(Map.class);

            if (response != null && response.containsKey("candidates")) {
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                Map<String, Object> firstCandidate = candidates.get(0);
                Map<String, Object> content = (Map<String, Object>) firstCandidate.get("content");
                List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                Map<String, Object> firstPart = parts.get(0);

                return (String) firstPart.get("text");
            }

            return "AI cevabı beklenen formatta gelmedi.";

        } catch (Exception e) {

            if (e.getMessage().contains("429")) {
                return "AI şu an çok meşgul (Kota hatası). Lütfen 30 saniye sonra tekrar dene.";
            }
            return "Analiz hatası: " + e.getMessage();
        }
    }
}