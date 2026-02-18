package com.blosny.logscope.application.dto.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blosny.logscope.application.dto.ErrorLogRequest;
import com.blosny.logscope.domain.model.ErrorLog;
import com.blosny.logscope.domain.repository.ErrorLogRepository;
import com.blosny.logscope.domain.service.AiAnalysisService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogScopeService {

    private final ErrorLogRepository repository;
    private final AiAnalysisService aiAnalysisService;

    public ErrorLog processErrorLog(ErrorLogRequest request) {

        String aiResult = aiAnalysisService.analyzeError(
                request.getMessage(),
                request.getStackTrace());

        ErrorLog errorLog = ErrorLog.builder()
                .message(request.getMessage())
                .stackTrace(request.getStackTrace())
                .source(request.getSource())
                .timestamp(LocalDateTime.now())
                .aiAnalysis(aiResult)
                .build();

        return repository.save(errorLog);
    }

    public List<ErrorLog> getAllLogs() {
        return repository.findAll();
    }
}