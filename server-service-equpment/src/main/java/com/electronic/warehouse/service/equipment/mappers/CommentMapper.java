package com.electronic.warehouse.service.equipment.mappers;

import com.electronic.warehouse.service.equipment.model.dto.CommentDto;
import com.electronic.warehouse.service.equipment.model.entites.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDto toCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .description(comment.getDescription())
                .build();
    }
}
