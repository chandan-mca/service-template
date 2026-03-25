package com.sugarfit.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExampleResponse {
    private String status;
    private String requestId;
}