# LogScope

LogScope, yazılım geliştirme süreçlerinde karşılaşılan karmaşık hata mesajlarını (logs) merkezi bir noktada toplayan ve **Google Gemini AI** entegrasyonu ile bu hataları analiz edip çözüm önerileri sunan modern bir backend projesidir.

Spring Boot öğrenme sürecinin bir parçası olarak geliştirilen bu proje, sadece hata kaydetmekle kalmaz; hataların kök nedenini analiz ederek geliştiricilere zaman kazandırır.

## Özellikler

-   **RESTful API Mimarisi:** Herhangi bir mikroservis veya frontend uygulamasından JSON formatında hata kabul eder.
-   **AI Analizi:** Gelen Stacktrace verilerini Gemini AI (2.5 Flash) kullanarak analiz eder ve kısa, net çözüm önerileri üretir.
-   **Mimari:** Kodun sürdürülebilirliği için iş mantığı (Core), dış servisler (Infrastructure) ve uygulama senaryoları (Application) birbirinden izole edilmiştir.
-   **Panel:** Hataları ve AI analizlerini görselleştiren modern, Tailwind CSS destekli bir arayüz sunar.

## Teknoloji Yığını

-   **Backend:** Java 17+, Spring Boot 3.x
-   **Veritabanı:** Spring Data JPA, H2 (In-Memory)
-   **AI:** Google Gemini AI API
-   **Frontend:** HTML5, Tailwind CSS, JavaScript (Fetch API)
-   **Araçlar:** Lombok, Maven

## Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyin:

1.  **Repoyu klonlayın:**
    ```bash
    git clone https://github.com/blosny/LogScope.git
    ```

2.  **API Anahtarı:**
    `src/main/resources/application.properties` dosyasına gidin ve kendi Gemini API anahtarınızı ekleyin:
    ```properties
    gemini.api.key=YOUR_API_KEY_HERE
    ```

3.  **Uygulamayı çalıştırın:**
    Terminal üzerinden proje dizininde şu komutu çalıştırın:
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Erişim:**
    Tarayıcınızdan `http://localhost:8080` adresine giderek uygulamayı kullanmaya başlayabilirsiniz.
