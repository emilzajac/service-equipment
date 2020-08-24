package com.electronic.warehouse.service.equipment.model.entites;

import com.electronic.warehouse.service.equipment.model.enums.CategoryEnum;
import com.electronic.warehouse.service.equipment.model.enums.RepairStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "electronic_equipment")
public class ElectronicEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum categoryEnum;

    @Column(name = "producer")
    private String producer;

    @Column(name = "color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair_status")
    private RepairStatusEnum repairStatusEnum;

    @OneToMany(mappedBy = "electronicEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "electronicEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<ParameterValue> parameters = new HashSet<>();

}
