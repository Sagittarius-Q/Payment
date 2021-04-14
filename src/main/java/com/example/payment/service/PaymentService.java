package com.example.payment.service;

import com.example.payment.domain.model.PaymentDto;
import com.example.payment.domain.model.XMLResponse;
import com.example.payment.exceptions.PaymentAlreadyExists;
import com.example.payment.exceptions.PaymentNotFoundException;

public interface PaymentService {
    XMLResponse save(PaymentDto paymentDto) throws PaymentAlreadyExists;

    XMLResponse check(PaymentDto paymentDto) throws PaymentNotFoundException;
}
