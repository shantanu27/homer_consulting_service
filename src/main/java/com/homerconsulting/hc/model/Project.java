package com.homerconsulting.hc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "proj_id")
    private Integer projID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp startDate;

    @Column(name = "total_cost")
    private Double totalCost;

    @ManyToOne
    @JoinColumn(name = "dept_code", foreignKey = @ForeignKey(name = "Project_DeptCode_FK"))
    private Department department;

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "Project_ClientID_FK"))
    private Client client;

    private Project() {}
}
