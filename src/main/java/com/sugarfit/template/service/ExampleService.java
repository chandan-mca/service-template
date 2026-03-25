package com.sugarfit.template.service;

import com.sugarfit.template.dto.ExampleRequest;
import com.sugarfit.template.dto.ExampleResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleService {

    public ExampleResponse process(ExampleRequest request) {

        String requestId = MDC.get("requestId"); // ✅ get from MDC

        log.info("Processing request for userId: {}", request.getUserId());

        return new ExampleResponse("SUCCESS", requestId);
    }
}