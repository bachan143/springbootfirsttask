package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRespository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRespository employeeRespository;
	
	  

	public List<Employee> findAll() {
		
		return    employeeRespository.findAll();
	}



	public Employee findById(int id) {
	
		return   employeeRespository.findById(id).
				orElseThrow(()->new EmployeeNotFoundException(id));
	}



	public Employee save(Employee newEmployee) {
		  
		
		return   employeeRespository.save(newEmployee);
	}



	public Employee updateEmployee(Employee updateEmployee, int id) {
		
	         return employeeRespository.findById(id)
	        		 .map(employee->{
	        			   employee.setFirstName(updateEmployee.getFirstName());
	        			   employee.setLastName(updateEmployee.getLastName());
	        			   employee.setEmail(updateEmployee.getEmail());
	        			   return employeeRespository.save(employee);
	        		 })
	        		 .orElseGet(()->{
	        			   updateEmployee.setId(id);
	        			   return employeeRespository.save(updateEmployee);
	        		 });
	}



	public void deleteById(int id) {
		
		
		employeeRespository.deleteById(id);
		
	}

}
