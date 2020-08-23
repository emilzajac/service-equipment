package com.electronic.warehouse.service.equipment.service;

import com.electronic.warehouse.service.equipment.exceptions.EquipmentException;
import com.electronic.warehouse.service.equipment.mappers.ElectronicEquipmentMapper;
import com.electronic.warehouse.service.equipment.model.dto.ElectronicEquipmentDto;
import com.electronic.warehouse.service.equipment.model.entites.ElectronicEquipment;
import com.electronic.warehouse.service.equipment.model.form.ElectronicEquipmentForm;
import com.electronic.warehouse.service.equipment.repository.ElectronicEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectronicEquipmentService {

    private final ElectronicEquipmentRepository electronicEquipmentRepository;

    private final ElectronicEquipmentMapper electronicEquipmentMapper;

    @Transactional
    public ElectronicEquipmentDto create(ElectronicEquipmentForm electronicEquipmentForm) {
        return electronicEquipmentMapper.toElectronicEquipmentDto(electronicEquipmentRepository.save(electronicEquipmentMapper.toElectronicEquipment(electronicEquipmentForm)));
    }

    @Transactional
    public ElectronicEquipmentDto update(ElectronicEquipmentDto electronicEquipmentDto) {
        ElectronicEquipment electronicEquipment = electronicEquipmentRepository.getOne(electronicEquipmentDto.getId());
        electronicEquipment.setName(electronicEquipmentDto.getName());
        electronicEquipment.setCategoryEnum(electronicEquipmentDto.getCategoryEnum());
        electronicEquipment.setIdentifier(electronicEquipmentDto.getIdentifier());
        electronicEquipment.setRepairStatusEnum(electronicEquipmentDto.getRepairStatusEnum());
        electronicEquipment.setProducer(electronicEquipmentDto.getProducer());
        return electronicEquipmentMapper.toElectronicEquipmentDto(electronicEquipment);
    }

    @Transactional
    public void delete(String identifier) {
        electronicEquipmentRepository.deleteByIdentifier(identifier);
    }

    public Set<ElectronicEquipmentDto> getAll() {
        return electronicEquipmentRepository.findAllByOrderByIdAsc().stream()
                .map(electronicEquipmentMapper::toElectronicEquipmentDto)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public ElectronicEquipmentDto findByIdentifier(String identifier) {
        return electronicEquipmentMapper.toElectronicEquipmentDto(electronicEquipmentRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new EquipmentException(String.format("Not found electronic with identifier: %s", identifier), HttpStatus.NOT_FOUND)));
    }
}
