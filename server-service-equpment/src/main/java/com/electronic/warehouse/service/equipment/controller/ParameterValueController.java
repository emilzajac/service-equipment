package com.electronic.warehouse.service.equipment.controller;

import com.electronic.warehouse.service.equipment.model.dto.ParameterValueDto;
import com.electronic.warehouse.service.equipment.service.ParameterValueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/parameters")
public class ParameterValueController {

    private final ParameterValueService parameterValueService;

    @GetMapping("/electronic/{identifier}")
    public ResponseEntity<Set<ParameterValueDto>> getByElectronicIdentifier(@PathVariable String identifier) {
        return ResponseEntity.ok(parameterValueService.getByElectronicIdentifier(identifier));
    }

}
