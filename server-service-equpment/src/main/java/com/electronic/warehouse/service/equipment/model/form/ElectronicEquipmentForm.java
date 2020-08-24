package com.electronic.warehouse.service.equipment.model.form;

import com.electronic.warehouse.service.equipment.model.enums.CategoryEnum;
import com.electronic.warehouse.service.equipment.model.enums.RepairStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ElectronicEquipmentForm {

    private String name;

    private String identifier;

    private CategoryEnum categoryEnum;

    private String producer;

    private String color;

    private RepairStatusEnum repairStatusEnum;

    private Set<ParameterValueForm> parameters;

}
