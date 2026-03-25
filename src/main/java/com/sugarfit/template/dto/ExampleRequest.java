package com.sugarfit.template.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExampleRequest {

    @NotBlank(message = "userId is required")
    private String userId;

    @NotNull(message = "value is required")
    private Integer value;
}