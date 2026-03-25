package com.sugarfit.template.service;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleService {

    public ExampleResponse process(ExampleRequest request) {

        String requestId = MDC.get("requestId");
        requestId = (requestId != null) ? requestId : "N/A";

        log.info("Processing request for userId: {}", request.getUserId());

        return new ExampleResponse("SUCCESS", requestId);
    }
}