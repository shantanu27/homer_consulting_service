package com.homerconsulting.hc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private Integer empID;

    @Column(name = "emp_last", nullable = false)
    private String empLast;

    @Column(name = "emp_first", nullable = false)
    private String empFirst;

    @Column(name = "dob", nullable = false)
    private Timestamp dob;

    @Column(name = "hire_date", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Timestamp hireDate;

    @ManyToOne
    @JoinColumn(name = "super_id", referencedColumnName = "emp_id", foreignKey = @ForeignKey(name = "Employee_SuperID_FK"))
    private Employee supervisor;

    @ManyToOne
    @JoinColumn(name = "dept_code", foreignKey = @ForeignKey(name = "Employee_DeptID_FK"))
    private Department department;

    private Employee(){

    }
}
