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
public class AssignmentBO {

    @JsonProperty("assign_id")
    private Integer assignID;

    @NotNull
    @JsonProperty("project_id")
    private Integer projectID;

    @JsonProperty("project_name")
    private String projectName;

    @NotNull
    @JsonProperty("emp_id")
    private Integer empID;

    @JsonProperty("emp_last")
    private String empLast;

    @JsonProperty("emp_first")
    private String empFirst;

    @JsonProperty("date_assigned")
    private Timestamp dateAssigned;

    @JsonProperty("date_ended")
    private Timestamp dateEnded;

    @JsonProperty("hours_used")
    private Integer hoursUsed;
}
