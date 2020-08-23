package com.electronic.warehouse.service.equipment.controller;

import com.electronic.warehouse.service.equipment.model.dto.CommentDto;
import com.electronic.warehouse.service.equipment.model.form.CommentForm;
import com.electronic.warehouse.service.equipment.service.CommentService;
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
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CommentForm commentForm) {
        return new ResponseEntity<>(commentService.create(commentForm).getId(), HttpStatus.CREATED);
    }

    @GetMapping("/electronic/{identifier}")
    public ResponseEntity<Set<CommentDto>> getByElectronicIdentifier(@PathVariable String identifier) {
        return ResponseEntity.ok(commentService.getByElectronicIdentifier(identifier));
    }

    @PutMapping
    public ResponseEntity<CommentDto> update(@RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.update(commentDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
