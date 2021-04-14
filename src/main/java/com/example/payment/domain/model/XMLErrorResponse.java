package com.example.payment.domain.model;

import lombok.Data;

@Data
public class XMLErrorResponse {
    private String message;
    private String details;
}
