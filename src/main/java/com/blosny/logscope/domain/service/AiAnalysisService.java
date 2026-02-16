package com.blosny.logscope.domain.service;

public interface AiAnalysisService {
    String analyzeError(String message, String stackTrace);
}