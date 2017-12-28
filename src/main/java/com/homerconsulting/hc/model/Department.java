package com.homerconsulting.hc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@AllArgsConstructor
public class Department implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "dept_code")
    private Integer deptCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "emp_id", foreignKey = @ForeignKey( name = "Department_ManagerID_FK"))
    private Employee manager;

    private Department(){

    }
}
