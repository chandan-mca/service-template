package com.sugarfit.template.service;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ExampleService {

    public ExampleResponse process(ExampleRequest request) {

        String requestId = UUID.randomUUID().toString();

        log.info("Processing request for userId: {}", request.getUserId());

        // simulate processing
        return new ExampleResponse("SUCCESS", requestId);
    }
}