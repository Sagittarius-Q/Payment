package com.example.payment.exceptions;

import com.example.payment.domain.model.XMLErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({PaymentNotFoundException.class, PaymentAlreadyExists.class})
    @ResponseBody
    public XMLErrorResponse handleExceptions(Throwable e) {
        XMLErrorResponse xmlResponse = new XMLErrorResponse();

        Throwable throwable = e;

        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        xmlResponse.setMessage(throwable.getMessage());
        xmlResponse.setDetails("try again");
        return xmlResponse;
    }

}
