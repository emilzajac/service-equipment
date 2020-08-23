package com.electronic.warehouse.service.equipment.configuration;

import com.electronic.warehouse.service.equipment.model.RestApiError;
import com.electronic.warehouse.service.equipment.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
@RequiredArgsConstructor
public class GeneralRestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ExceptionsUtils exceptionsUtils;

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        return super.handleExceptionInternal(exception, exceptionsUtils.createApiError(exception, Collections.singletonList(exception.getCause().getMessage())), headers, status, request);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<RestApiError> createApiUndefinedError(Exception exception) {
        RestApiError controllerError = exceptionsUtils.createApiError(exception, Collections.singletonList(exception.getCause().getMessage()));
        return new ResponseEntity<>(controllerError, new HttpHeaders(), controllerError.getStatus());
    }

}
