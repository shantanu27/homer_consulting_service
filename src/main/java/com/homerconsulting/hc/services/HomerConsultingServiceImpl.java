package com.homerconsulting.hc.services;

import com.homerconsulting.hc.bo.AssignmentBO;
import com.homerconsulting.hc.bo.EmployeeBO;
import com.homerconsulting.hc.bo.ProjectBO;
import com.homerconsulting.hc.dao.AssignmentDao;
import com.homerconsulting.hc.dao.ClientDao;
import com.homerconsulting.hc.dao.DepartmentDao;
import com.homerconsulting.hc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomerConsultingServiceImpl implements HomerConsultingService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AssignmentDao assignmentDao;

    @Override
    public ProjectBO createProject(ProjectBO projectBO) throws IllegalArgumentException{
        Department department = Optional.of(departmentDao.findOne(projectBO.getDeptCode()))
                .orElseThrow(() -> new IllegalArgumentException("Create Project: " +
                        "Invalid department code - " + projectBO.getDeptCode()));
        Client client = Optional.of(clientDao.findOne(projectBO.getClientID()))
                .orElseThrow(() -> new IllegalArgumentException("Create Project: " +
                        "Invalid project id - " + projectBO.getClientID()));
        Timestamp startDate = Optional.ofNullable(projectBO.getStartDate()).orElse(new Timestamp(System.currentTimeMillis()));
        return projectService.saveProject(new Project(projectBO.getProjID(),
                                                      projectBO.getName(),
                                                      startDate,
                                                      projectBO.getTotalCost(),
                                                      department,
                                                      client));
    }

    @Override
    public ProjectBO updateProject(int id, double totalCost) throws IllegalArgumentException{
        return projectService.updateProject(id, totalCost);
    }

    @Override
    public Collection<AssignmentBO> getEmployeeAssignments(int id) throws IllegalArgumentException {
        Optional<Employee> employeeEntity = employeeService.getEmployeeEntity(id);
        return employeeEntity.map(employee -> assignmentDao.findByEmployee(employee)
                                                        .stream()
                                                        .map(this::convertToBO  )
                                                        .collect(Collectors.toList()))
                            .orElseThrow(() ->new IllegalArgumentException("No employee with id '" + id + "'"));
    }

    @Override
    public Collection<EmployeeBO> getEmployeesInProject(int id) throws IllegalArgumentException {
        Optional<Project> projectEntity = projectService.getProjectEntity(id);
        return projectEntity.map(project -> assignmentDao.findByProject(project)
                                                    .stream()
                                                    .map(assignment -> employeeService.convertToBO(assignment.getEmployee()))
                                                    .distinct()
                                                    .collect(Collectors.toList()))
                        .orElseThrow(() -> new IllegalArgumentException("No project with id '" + id + "'"));
    }

    @Override
    public Collection<EmployeeBO> getEmployeesForDepartment(int id) {
        Optional<Department> departmentEntity = Optional.ofNullable(departmentDao.findOne(id));
        return departmentEntity.map(department -> employeeService.getEmployees(department))
                .orElseThrow(() -> new IllegalArgumentException("No department with id '" + id + "'"));
    }

    private AssignmentBO convertToBO(Assignment assignment) {
        return AssignmentBO.builder()
                .assignID(assignment.getAssignID())
                .empID(assignment.getEmployee().getEmpID())
                .empLast(assignment.getEmployee().getEmpLast())
                .empFirst(assignment.getEmployee().getEmpFirst())
                .projectID(assignment.getProject().getProjID())
                .projectName(assignment.getProject().getName())
                .dateAssigned(assignment.getDateAssigned())
                .dateEnded(assignment.getDateEnded())
                .hoursUsed(assignment.getHoursUsed())
                .build();
    }
}
