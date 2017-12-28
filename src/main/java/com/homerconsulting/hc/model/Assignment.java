package com.homerconsulting.hc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue
    @Column(name = "assign_id")
    private Integer assignID;

    @ManyToOne
    @JoinColumn(name = "proj_id", foreignKey = @ForeignKey(name = "Assignment_ProjNumber_FK"))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "Assignment_EmpNum_FK"))
    private Employee employee;

    @Column(name = "date_assigned", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateAssigned;

    @Column(name = "date_ended")
    private Timestamp dateEnded;

    @Column(name = "hours_used")
    private Integer hoursUsed;

    private Assignment(){}
}
