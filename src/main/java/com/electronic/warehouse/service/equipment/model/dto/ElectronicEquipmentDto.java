package com.electronic.warehouse.service.equipment.model.dto;

import com.electronic.warehouse.service.equipment.model.enums.CategoryEnum;
import com.electronic.warehouse.service.equipment.model.enums.RepairStatusEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ElectronicEquipmentDto {

    Long id;

    String name;

    String identifier;

    CategoryEnum categoryEnum;

    String producer;

    String color;

    RepairStatusEnum repairStatusEnum;

}
