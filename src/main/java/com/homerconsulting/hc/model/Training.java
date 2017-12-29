package com.homerconsulting.hc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Training {

    @Id
    @GeneratedValue
    @Column(name = "train_id")
    private Integer trainID;

    @ManyToOne
    @JoinColumn(name = "code", foreignKey = @ForeignKey(name = "Training_SkillCode_FK"))
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "Training_EmpNum_FK"))
    private Employee employee;

    @Column(name = "date_acquired", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateAcquired;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "comments")
    private String comments;

    private Training() {

    }
}
