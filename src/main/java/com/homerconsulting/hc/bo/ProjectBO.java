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
public class ProjectBO {

    @JsonProperty("proj_id")
    private Integer projID;

    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("start_date")
    private Timestamp startDate;

    @JsonProperty("total_cost")
    private Double totalCost;

    @NotNull
    @JsonProperty("dept_code")
    private Integer deptCode;

    @JsonProperty("dept_name")
    private String deptName;

    @NotNull
    @JsonProperty("client_id")
    private Integer clientID;

    @JsonProperty("client_name")
    private String clientName;
}
