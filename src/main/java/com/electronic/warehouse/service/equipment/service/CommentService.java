package com.electronic.warehouse.service.equipment.service;

import com.electronic.warehouse.service.equipment.mappers.CommentMapper;
import com.electronic.warehouse.service.equipment.model.dto.CommentDto;
import com.electronic.warehouse.service.equipment.model.entites.Comment;
import com.electronic.warehouse.service.equipment.model.form.CommentForm;
import com.electronic.warehouse.service.equipment.repository.CommentRepository;
import com.electronic.warehouse.service.equipment.repository.ElectronicEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ElectronicEquipmentRepository electronicEquipmentRepository;
    private final CommentMapper commentMapper;

    @Transactional
    public Comment create(CommentForm commentForm) {
        return commentRepository.save(Comment.builder()
                .description(commentForm.getDescription())
                .electronicEquipment(electronicEquipmentRepository.getOne(commentForm.getElectronicEquipmentId()))
                .build());
    }

    @Transactional
    public CommentDto update(CommentDto commentDto) {
        Comment comment = commentRepository.getOne(commentDto.getId());
        comment.setDescription(commentDto.getDescription());
        return commentMapper.toCommentDto(comment);
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public Set<CommentDto> getByElectronicIdentifier(String identifier) {
        return commentRepository.findAllByElectronicEquipment_IdentifierOrderByIdAsc(identifier).stream()
                .map(commentMapper::toCommentDto)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
