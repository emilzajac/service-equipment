package com.electronic.warehouse.service.equipment.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EquipmentException extends RuntimeException {

    private final HttpStatus statusCode;

    public EquipmentException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
