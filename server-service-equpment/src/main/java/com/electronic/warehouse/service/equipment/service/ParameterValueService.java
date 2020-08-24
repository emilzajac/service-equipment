package com.electronic.warehouse.service.equipment.service;

import com.electronic.warehouse.service.equipment.mappers.ParameterValueMapper;
import com.electronic.warehouse.service.equipment.model.dto.ParameterValueDto;
import com.electronic.warehouse.service.equipment.repository.ParameterValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParameterValueService {

    private final ParameterValueRepository parameterValueRepository;
    private final ParameterValueMapper parameterValueMapper;

    public Set<ParameterValueDto> getByElectronicIdentifier(String identifier) {
        return parameterValueRepository.findAllByElectronicEquipment_IdentifierOrderByIdAsc(identifier).stream()
                .map(parameterValueMapper::mapParameterValue)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
