package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeControler {
	
	@Autowired
	private EmployeeService employeeService;
	//All Item
	 //localhost:9876/employees
	   @GetMapping("/employees")
	   public List<Employee> allEmployees()
	   {   
		    return employeeService.findAll();
	   }
	   //Save Data Employee
	   @PostMapping("/employees")
	     Employee newEmployee(@RequestBody Employee newEmployee)
	     {
	    	   return employeeService.save(newEmployee);
	     }
	   
	   //single Item
	   ////localhost:9876/employees/1
	   @GetMapping("/employees/{id}")
	   Employee getOneEmployeeRecord(@PathVariable int id)
	   {
		      return employeeService.findById(id);
	   }
	   //update Data
	 //localhost:9876/employees/1
	   @PutMapping("/employees/{id}")
	   Employee updateEmployee( @RequestBody Employee updateEmployee,  @PathVariable int id)
	   {
		     return employeeService.updateEmployee(updateEmployee,id);
	   }
	   //delete data
	 //localhost:9876/employees/1
	    @DeleteMapping("/employees/{id}")
	     void deleteEmployee(@PathVariable int id)
	     {
	    	   employeeService.deleteById(id);
	    	 
	     }

}
