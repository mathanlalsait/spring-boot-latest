package com.candidjava.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidjava.springboot.entity.Employee;
import com.candidjava.springboot.repository.EmployeeRepository;
import com.candidjava.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setId(0);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
        	employee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findByEmail(String email) {
		List<Employee> employees = new ArrayList<>();
		employees = employeeRepository.findAll();
		Employee employee = null;
		Optional<Employee> result = employees.stream().filter(emp -> emp.getEmail().equals(email)).findFirst();
		if (result.isPresent()) {
			employee = result.get();
		}
        else {
            throw new RuntimeException("Did not find employee - " + email);
        }
		return employee;
	}

}
