package com.electronic.warehouse.service.equipment.mappers;

import com.electronic.warehouse.service.equipment.model.dto.ElectronicEquipmentDto;
import com.electronic.warehouse.service.equipment.model.entites.ElectronicEquipment;
import com.electronic.warehouse.service.equipment.model.form.ElectronicEquipmentForm;
import org.springframework.stereotype.Component;

@Component
public class ElectronicEquipmentMapper {

    public ElectronicEquipment toElectronicEquipment(ElectronicEquipmentForm electronicEquipmentForm) {
        return ElectronicEquipment.builder()
                .name(electronicEquipmentForm.getName())
                .identifier(electronicEquipmentForm.getIdentifier())
                .producer(electronicEquipmentForm.getProducer())
                .categoryEnum(electronicEquipmentForm.getCategoryEnum())
                .color(electronicEquipmentForm.getColor())
                .repairStatusEnum(electronicEquipmentForm.getRepairStatusEnum())
                .build();
    }

    public ElectronicEquipmentDto toElectronicEquipmentDto(ElectronicEquipment electronicEquipment) {
        return ElectronicEquipmentDto.builder()
                .id(electronicEquipment.getId())
                .name(electronicEquipment.getName())
                .identifier(electronicEquipment.getIdentifier())
                .producer(electronicEquipment.getProducer())
                .categoryEnum(electronicEquipment.getCategoryEnum())
                .color(electronicEquipment.getColor())
                .repairStatusEnum(electronicEquipment.getRepairStatusEnum())
                .build();
    }

}
