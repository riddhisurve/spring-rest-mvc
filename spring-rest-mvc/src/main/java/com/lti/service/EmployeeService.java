package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.Employee;
import com.lti.entity.Project;

@Service
public class EmployeeService {

	@Autowired
	private GenericDao dao;
	
	@Transactional
	public int addEmployee(Employee emp) {
		Employee updatedEmp = (Employee) dao.save(emp);
		return updatedEmp.getEmpno();
	}

	@Transactional
	public int addProject(Project proj) {
		Project updatedProj = (Project) dao.save(proj);
		return updatedProj.getId();
	}
	
	public List<Employee> listAll(){
		return dao.fetchAll(Employee.class);
	}
		
	public List<Project> listAllProj(){
		return dao.fetchAll(Project.class);
	}
	
	@Transactional
	public void assignProjectToEmployee(int projectId, int empno) {
		Project proj = dao.fetchById(Project.class, projectId);
		Employee emp = dao.fetchById(Employee.class, empno);
		proj.setEmployee(emp);
		dao.save(proj);
	}

}
