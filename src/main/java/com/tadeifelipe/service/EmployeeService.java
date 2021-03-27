package com.tadeifelipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tadeifelipe.model.Employee;
import com.tadeifelipe.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public void saveEmployee(Employee employee ) {
		employeeRepository.save(employee);
	}
	
	public Employee findById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		
		if (optional.isPresent())
			employee = optional.get();
		else
			throw new RuntimeException("Employee not found " + id);
			
		return employee;
	}
	
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}
}
