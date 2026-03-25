package com.sugarfit.template.controller;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import com.sugarfit.template.service.ExampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of("status", "UP"));
    }

    @PostMapping("/example")
    public ResponseEntity<ExampleResponse> process(@RequestBody @Valid ExampleRequest request) {
        return ResponseEntity.ok(exampleService.process(request));
    }
}
