package com.jsp.spring_boot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_boot.dto.EmployeeDto;
import com.jsp.spring_boot.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//build Add Employee RESt API
	
	//http://localhost:8080/api/employees
	@PostMapping
	
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		
		
	} 
	//Build get empl  http://localhost:8080/api/employees
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id")Long  employeeId){
		EmployeeDto employeeDto=  employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build get all empll all restapi
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
	List<EmployeeDto>employees=	employeeService.getAllEmployees();
	
	return ResponseEntity.ok(employees);
	}
	
	//Build update Employee REST API  http://localhost:8080/api/employees/2
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto>updatedEmployee(@PathVariable("id") Long employeeeId,@RequestBody EmployeeDto updatedEmployee){
	EmployeeDto employeeDto=	employeeService.updtaeEmployee(employeeeId, updatedEmployee);
		
		return ResponseEntity.ok(employeeDto);
	}

	
	//build delete Employee method
	@DeleteMapping("{id}") 
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
	{
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully");
	}
	
	@GetMapping("/test")
    public String testCors() {
        return "CORS is working!";
    }
	
}  

