package com.candidjava.springboot.service;

import java.util.List;

import com.candidjava.springboot.entity.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee user);

	public Employee updateEmployee(Employee user);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(int id);

	public void deleteEmployee(int id);
	
	public Employee findByEmail(String email);

}
