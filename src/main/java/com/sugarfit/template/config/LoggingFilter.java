package com.sugarfit.template.config;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    private static final String REQUEST_ID = "requestId";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String requestId = UUID.randomUUID().toString();
        
        // Generate unique requestId for tracing logs across the request life-cycle
        MDC.put(REQUEST_ID, requestId);

        long startTime = System.currentTimeMillis();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        String fullUrl = (query == null) ? uri : uri + "?" + query;

        try {
        	log.info("Incoming Request [{}]: {} {}", requestId, request.getMethod(), fullUrl);
            filterChain.doFilter(request, response);

        } finally {
            long duration = System.currentTimeMillis() - startTime;

            log.info("Response [{}]: {} {} | Status: {} | Time: {} ms",
                    requestId,
                    request.getMethod(),
                    fullUrl,
                    response.getStatus(),
                    duration);

            // Clear MDC to prevent memory leaks across threads
            MDC.clear();
        }
    }
}