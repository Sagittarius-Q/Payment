package com.example.payment.exceptions;

import com.example.payment.domain.model.XMLErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomBindingErrorHandler extends ResponseEntityExceptionHandler {


    @NonNull
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status, WebRequest request) {
        XMLErrorResponse xmlErrorResponse = new XMLErrorResponse();
        xmlErrorResponse.setDetails(ex.getBindingResult().toString());
        xmlErrorResponse.setMessage("ELEMENT IS NOT CORRECT");
        return new ResponseEntity<>(xmlErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
