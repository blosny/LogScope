package com.blosny.logscope.application.dto;

import lombok.Data;

@Data
public class ErrorLogRequest {
    private String message; // Hata mesajı (Örn: NullPointerException)
    private String stackTrace; // Hata detayları (Stacktrace)
    private String source; // Hata nereden geldi? (Frontend mi Backend mi?)
}

// DTO: Data Transfer Object (Veri Aktarım Nesnesi)