package com.blosny.logscope.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data // Getter, Setter gibi metodları otomatik oluşturur
@Builder // Nesne oluştururken .builder() dememizi sağlar (Okunabilirlik!)
public class ErrorLog {
    private String id;
    private String message;
    private String stackTrace;
    private String source; // Frontend mi Backend mi?
    private LocalDateTime timestamp;
    private String aiAnalysis; // AI'dan gelecek olan cevap
}