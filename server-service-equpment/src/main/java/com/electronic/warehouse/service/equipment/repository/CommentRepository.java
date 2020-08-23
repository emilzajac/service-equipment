package com.electronic.warehouse.service.equipment.repository;

import com.electronic.warehouse.service.equipment.model.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Set<Comment> findAllByElectronicEquipment_IdentifierOrderByIdAsc(String identifier);

}
