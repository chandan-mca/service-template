package com.sugarfit.template.controller;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import com.sugarfit.template.service.ExampleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {

        String requestId = MDC.get("requestId");
        requestId = (requestId != null) ? requestId : "N/A";

        return ResponseEntity.ok(Map.of(
            "status", "SUCCESS",
            "requestId", requestId
        ));
    }

    @PostMapping("/example")
    public ResponseEntity<ExampleResponse> process(@RequestBody @Valid ExampleRequest request) {
        return ResponseEntity.ok(exampleService.process(request));
    }
}
