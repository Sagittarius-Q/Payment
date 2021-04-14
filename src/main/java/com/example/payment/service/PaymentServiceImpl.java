package com.example.payment.service;

import com.example.payment.domain.model.PaymentDto;
import com.example.payment.domain.model.XMLResponse;
import com.example.payment.domain.entity.Payment;
import com.example.payment.exceptions.PaymentAlreadyExists;
import com.example.payment.exceptions.PaymentNotFoundException;
import com.example.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final ModelMapper modelMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public XMLResponse save(PaymentDto paymentDto) throws PaymentAlreadyExists {
        if (paymentRepository.existsById(paymentDto.getId()))
            throw new PaymentAlreadyExists(paymentDto.getId() + " : already exists");

        Payment payment = this.modelMapper.map(paymentDto, Payment.class);
        payment.setDate(new Date());
        paymentRepository.save(payment);
        XMLResponse xmlResponse = this.modelMapper.map(payment, XMLResponse.class);
        xmlResponse.setDate(payment.getDate().toString());
        xmlResponse.setStatus(1);
        xmlResponse.setMessage("PAYMENT CONFIRMED");

        return xmlResponse;
    }

    @Override
    public XMLResponse check(PaymentDto paymentDto) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentDto.getId())
                .orElseThrow(() -> new PaymentNotFoundException("payment not found"));
        XMLResponse xmlResponse = new XMLResponse();
        xmlResponse.setDate(payment.getDate().toString());
        xmlResponse.setMessage("EXISTS");
        xmlResponse.setId(payment.getId());
        xmlResponse.setStatus(0);
        return xmlResponse;
    }
}
