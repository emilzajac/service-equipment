package com.electronic.warehouse.service.equipment.model.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentForm {

    private Long electronicEquipmentId;

    private String description;

}
