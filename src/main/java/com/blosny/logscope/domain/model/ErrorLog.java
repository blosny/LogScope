package com.blosny.logscope.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Spring'e "Bu sınıftan bir veritabanı tablosu yap" diyoruz.
@Data   // Lombok sayesinde Getter ve Setter (getSet) yazmaktan kurtuluyoruz.
@Builder // Nesne oluştururken ErrorLog.builder().message("Hata").build() dememizi sağlar.
@NoArgsConstructor // Veritabanı (JPA) arka planda boş bir ErrorLog yaratabilmek için buna ihtiyaç duyar.
@AllArgsConstructor // Builder özelliğinin çalışması için tüm alanların olduğu bir constructor lazım.
public class ErrorLog {

    @Id // Bu değişkenin tablodaki "Primary Key" (benzersiz kimlik) olduğunu söyler.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID'yi biz değil, veritabanı 1, 2, 3 diye otomatik versin.
    private Long id;

    private String message; // Hata mesajı (Örn: NullPointerException)

    @Lob // Veritabanına "Bu metin çok uzun olabilir (Stacktrace), ona göre yer ayır" der.
    private String stackTrace; 

    private String source; // Hata nereden geldi? (Frontend mi Backend mi?)
    
    private LocalDateTime timestamp; // Hatanın oluşma saati

    @Lob
    private String aiAnalysis; // İleride yapay zekanın yapacağı açıklama buraya yazılacak.
}