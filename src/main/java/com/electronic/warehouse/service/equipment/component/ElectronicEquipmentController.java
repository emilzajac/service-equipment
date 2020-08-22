package com.electronic.warehouse.service.equipment.component;

import com.electronic.warehouse.service.equipment.model.dto.ElectronicEquipmentDto;
import com.electronic.warehouse.service.equipment.model.form.ElectronicEquipmentForm;
import com.electronic.warehouse.service.equipment.service.ElectronicEquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/electronics")
public class ElectronicEquipmentController {

    private final ElectronicEquipmentService electronicEquipmentService;

    @PostMapping
    public ResponseEntity<ElectronicEquipmentDto> create(@RequestBody ElectronicEquipmentForm electronicEquipmentForm) {
        return new ResponseEntity<>(electronicEquipmentService.create(electronicEquipmentForm), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Set<ElectronicEquipmentDto>> getAll() {
        return ResponseEntity.ok(electronicEquipmentService.getAll());
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<ElectronicEquipmentDto> findByIdentifier(@PathVariable String identifier) {
        return ResponseEntity.ok(electronicEquipmentService.findByIdentifier(identifier));
    }

    @PutMapping
    public ResponseEntity<ElectronicEquipmentDto> update(@RequestBody ElectronicEquipmentDto electronicEquipmentDto) {
        return new ResponseEntity<>(electronicEquipmentService.update(electronicEquipmentDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{identifier}")
    public ResponseEntity<Void> delete(@PathVariable String identifier) {
        electronicEquipmentService.delete(identifier);
        return ResponseEntity.ok().build();
    }

}

