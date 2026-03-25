package com.sugarfit.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private String requestId;
    private Map<String, String> errors;
}