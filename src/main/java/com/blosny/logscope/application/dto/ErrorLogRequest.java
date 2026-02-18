package com.blosny.logscope.application.dto;

import lombok.Data;

@Data
public class ErrorLogRequest {
    private String message;
    private String stackTrace;
    private String source;
}
