package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.AssignmentBO;
import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.model.Employee;

import java.text.ParseException;
import java.util.Collection;

public interface HomerConsultingService {

    ProjectBO createProject(ProjectBO projectBO) throws IllegalArgumentException;
    ProjectBO updateProject(int id, double totalCost);

    Collection<AssignmentBO> getEmployeeAssignments(int id) throws IllegalArgumentException;
}
