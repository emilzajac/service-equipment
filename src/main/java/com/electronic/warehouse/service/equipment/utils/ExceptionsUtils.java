package com.electronic.warehouse.service.equipment.utils;

import com.electronic.warehouse.service.equipment.model.RestApiError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ExceptionsUtils {

    public RestApiError createApiError(Exception exception, List<String> errors) {
        return RestApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Error")
                .message(exception.getMessage())
                .errors(errors)
                .build();
    }

    public RestApiError createApiError(HttpStatus httpStatus, String title, String message, List<String> errors) {
        return RestApiError.builder()
                .status(httpStatus)
                .timeStamp(LocalDateTime.now())
                .code(httpStatus.value())
                .title(title)
                .message(message)
                .errors(errors)
                .build();
    }

}
