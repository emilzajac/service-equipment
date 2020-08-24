package com.electronic.warehouse.service.equipment.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParameterValueDto {

    Long id;

    String parameter;

    String value;

}
