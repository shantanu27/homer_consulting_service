package com.homerconsulting.hc.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeBO {

    @JsonProperty("emp_id")
    private Integer empID;

    @NotNull
    @JsonProperty("emp_last")
    private String empLast;

    @NotNull
    @JsonProperty("emp_first")
    private String empFirst;

    @NotNull
    @JsonProperty("DOB")
    private Timestamp dob;

    @JsonProperty("hire_date")
    private Timestamp hireDate;

    @JsonProperty("supervisor_id")
    private Integer supervisorId;

    @JsonProperty("supervisor_name")
    private String supervisorName;

    @NotNull
    @JsonProperty("department_id")
    private Integer departmentId;

    @JsonProperty("department_name")
    private String departmentName;
}
