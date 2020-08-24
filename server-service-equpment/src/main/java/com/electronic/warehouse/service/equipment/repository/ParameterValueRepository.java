package com.electronic.warehouse.service.equipment.repository;

import com.electronic.warehouse.service.equipment.model.entites.ParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ParameterValueRepository extends JpaRepository<ParameterValue, Long> {
    Set<ParameterValue> findAllByElectronicEquipment_IdentifierOrderByIdAsc(String identifier);
}
