package com.example.payment.domain.model;

import lombok.Data;


@Data
public class XMLResponse {
    private Long id;
    private Long supplier_id;
    private int status;
    private String message;
    private String date;

}
