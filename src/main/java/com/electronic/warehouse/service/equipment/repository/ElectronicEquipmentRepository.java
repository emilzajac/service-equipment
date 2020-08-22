package com.electronic.warehouse.service.equipment.repository;

import com.electronic.warehouse.service.equipment.model.entites.ElectronicEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ElectronicEquipmentRepository extends JpaRepository<ElectronicEquipment, Long> {

    void deleteByIdentifier(String identifier);

    Optional<ElectronicEquipment> findByIdentifier(@Param("identifier") String identifier);
}
