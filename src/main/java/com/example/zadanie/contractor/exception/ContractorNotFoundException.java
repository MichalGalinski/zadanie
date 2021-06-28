package com.example.zadanie.contractor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContractorNotFoundException extends RuntimeException {
    public ContractorNotFoundException(){
        super("Nie znaleziono kontrahenta o podanym ID");
    }
}
