package com.electronic.warehouse.service.equipment.mappers;

import com.electronic.warehouse.service.equipment.model.dto.ParameterValueDto;
import com.electronic.warehouse.service.equipment.model.entites.ElectronicEquipment;
import com.electronic.warehouse.service.equipment.model.entites.ParameterValue;
import com.electronic.warehouse.service.equipment.model.form.ElectronicEquipmentForm;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ParameterValueMapper {

    public Set<ParameterValue> mapParameterValues(ElectronicEquipmentForm electronicEquipmentForm, ElectronicEquipment electronicEquipment) {
        return electronicEquipmentForm.getParameters().stream()
                .map(parameterValueForm -> ParameterValue.builder()
                        .parameter(parameterValueForm.getParameter())
                        .value(parameterValueForm.getValue())
                        .electronicEquipment(electronicEquipment)
                        .build())
                .collect(Collectors.toSet());
    }

    public ParameterValueDto mapParameterValue(ParameterValue parameterValue) {
        return ParameterValueDto.builder()
                .id(parameterValue.getId())
                .parameter(parameterValue.getParameter())
                .value(parameterValue.getValue())
                .build();
    }

}
