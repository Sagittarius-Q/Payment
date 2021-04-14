package com.example.payment.domain.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PaymentDto {
    @NotNull(message = "id can not be null")
    private Long id;
    @NotNull(message = "can not be null")
    private Long supplier_id;
    @NotNull(message = "can no be null")
    private Long account;
    @NotNull(message = "can not be null")
    private Double amount;
}
