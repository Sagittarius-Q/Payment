package com.example.payment.controller;

import com.example.payment.domain.model.PaymentDto;
import com.example.payment.domain.model.XMLResponse;
import com.example.payment.exceptions.PaymentAlreadyExists;
import com.example.payment.exceptions.PaymentNotFoundException;
import com.example.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public XMLResponse pay(@Valid @RequestBody PaymentDto paymentDto) throws PaymentAlreadyExists {
        log.info("/demo/pay  -  calling pay() method ");
        return this.paymentService.save(paymentDto);
    }

    @GetMapping(path = "/check", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public XMLResponse chek(@Valid @RequestBody PaymentDto paymentDto) throws PaymentNotFoundException {
        log.info("/demo/pay  -  calling check() method ");
        return this.paymentService.check(paymentDto);

    }

}
