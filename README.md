# LogScope - Yapay Zeka Destekli Log Analiz Sistemi

LogScope, yazılım geliştirme süreçlerinde karşılaşılan karmaşık hata mesajlarını (logs) merkezi bir noktada toplayan ve **Google Gemini AI** entegrasyonu ile bu hataları analiz edip çözüm önerileri sunan modern bir backend projesidir. Spring Boot öğrenme sürecinin bir parçası olarak geliştirilen bu proje, hataların kök nedenini analiz ederek geliştiricilere zaman kazandırır.

## Temel Özellikler
- **AI Analizi**: Gelen Stacktrace verilerini **Gemini AI (2.5 Flash)** kullanarak analiz eder ve kısa, net çözüm önerileri üretir.
- **RESTful API Mimarisi**: Herhangi bir mikroservis veya frontend uygulamasından JSON formatında hata kaydı kabul eder.
- **İzole Mimari**: Kodun sürdürülebilirliği için iş mantığı (Core), dış servisler (Infrastructure) ve uygulama senaryoları (Application) katmanlı bir yapıda tasarlanmıştır.
- **Görsel Kontrol Paneli**: Hataları ve AI analizlerini görselleştiren modern, **Tailwind CSS** destekli, responsive bir kullanıcı arayüzü sunar.
- **Dosya Analizi**: Farklı log formatlarındaki dosyaları yükleme ve içeriklerinde arama/filtreleme imkanı.

## Teknoloji Yığını
- **Backend**: Java 17+, Spring Boot 3.x
- **Veritabanı**: Spring Data JPA, H2 (In-Memory)
- **AI Entegrasyonu**: Google Gemini AI API
- **Frontend**: HTML5, Tailwind CSS, JavaScript (Fetch API)
- **Araçlar**: Lombok, Maven

## Kurulum ve Çalıştırma

1. **Repoyu klonlayın**:
   ```bash
   git clone https://github.com/blosny/LogScope.git
   cd LogScope
   ```

2. **API Anahtarı Tanımlama**:
   `src/main/resources/application.properties` dosyasına gidin ve kendi Gemini API anahtarınızı ekleyin:
   ```properties
   gemini.api.key=YOUR_API_KEY_HERE
   ```

3. **Uygulamayı Başlatın**:
   Maven kullanarak projeyi ayağa kaldırın:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Erişim**:
   Tarayıcınızdan `http://localhost:8080` adresine giderek LogScope panelini kullanmaya başlayabilirsiniz.

## Kullanım
1. Uygulamanızdan LogScope API'sine bir hata (stacktrace) gönderin.
2. Panel üzerinden ilgili hatayı bulun ve "AI Analizi" butonuna tıklayın.
3. Gemini AI tarafından oluşturulan hata nedeni ve çözüm önerisini inceleyerek sorunu hızlıca çözün.

---
*Geliştirici: [blosny](https://github.com/blosny)*
