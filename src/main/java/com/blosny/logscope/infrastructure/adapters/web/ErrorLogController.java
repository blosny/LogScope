package com.blosny.logscope.infrastructure.adapters.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blosny.logscope.application.dto.ErrorLogRequest;
import com.blosny.logscope.application.dto.service.LogScopeService;
import com.blosny.logscope.domain.model.ErrorLog;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/errors")
@RequiredArgsConstructor
public class ErrorLogController {

    private final LogScopeService service;

    @PostMapping
    public ErrorLog createErrorLog(@RequestBody ErrorLogRequest request) {
        return service.processErrorLog(request);
    }

    @GetMapping
    public List<ErrorLog> getAllErrors() {
        return service.getAllLogs();
    }
}