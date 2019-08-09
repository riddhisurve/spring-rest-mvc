package com.lti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Employee;
import com.lti.entity.Project;
import com.lti.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee.lti")
	public Status add(@RequestBody Employee emp) {
	 	int empno=employeeService.addEmployee(emp);
		Status status = new Status();
		status.setMessage("Employee added!");
		status.setGeneratedId(empno);
		return status;
		}
	
	@PostMapping("/addProject.lti")
	public Status addProj(@RequestBody Project proj) {
	 	int projno=employeeService.addProject(proj);
		Status status = new Status();
		status.setMessage("Project added!");
		status.setGeneratedId(projno);
		return status;
		}
	
	@PostMapping("/listAll.lti")
	public List<Employee> listAll() {
		return employeeService.listAll();
		}
	
	@PostMapping("/listAllProj.lti")
	public List<Project> listAllProj() {
		return employeeService.listAllProj();
		}
	
	@GetMapping("/assignProjToEmp.lti")
	public Status assign(@RequestParam("id")int id,@RequestParam("empno") int empno) {
		employeeService.assignProjectToEmployee(id, empno);
		Status status = new Status();
		status.setMessage("Project assigned!");
		status.setGeneratedId(id);
		return status;
	}
	
}
