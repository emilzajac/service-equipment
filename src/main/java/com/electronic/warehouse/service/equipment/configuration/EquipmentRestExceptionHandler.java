package com.electronic.warehouse.service.equipment.configuration;

import com.electronic.warehouse.service.equipment.exceptions.EquipmentException;
import com.electronic.warehouse.service.equipment.model.RestApiError;
import com.electronic.warehouse.service.equipment.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RequiredArgsConstructor
public class EquipmentRestExceptionHandler {

    private final ExceptionsUtils exceptionsUtils;

    @ExceptionHandler({EquipmentException.class})
    public ResponseEntity<RestApiError> createApiResponse(EquipmentException exception) {
        RestApiError restApiError = exceptionsUtils.createApiError(exception.getStatusCode(),
                "Equipment error occur",
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
        return new ResponseEntity<>(restApiError, new HttpHeaders(), restApiError.getStatus());
    }

}
