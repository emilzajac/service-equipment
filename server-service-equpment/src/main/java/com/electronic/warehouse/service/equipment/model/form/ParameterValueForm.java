package com.electronic.warehouse.service.equipment.model.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParameterValueForm {

    String parameter;

    String value;

}
