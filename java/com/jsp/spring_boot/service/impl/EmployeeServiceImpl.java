package com.jsp.spring_boot.service.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring_boot.dto.EmployeeDto;
import com.jsp.spring_boot.entity.Employee;
import com.jsp.spring_boot.exception.ResourceNotFoundException;
import com.jsp.spring_boot.mapper.EmployeeMapper;
import com.jsp.spring_boot.repository.EmployeeReposistory;
import com.jsp.spring_boot.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{
	
public EmployeeServiceImpl(EmployeeReposistory employeeReposistory) {
		super();
		this.employeeReposistory = employeeReposistory;
	}
@Autowired
	private EmployeeReposistory employeeReposistory;
 @Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
          Employee savedEmployee=employeeReposistory.save(employee);
          return EmployeeMapper.mapEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee=employeeReposistory.findById(employeeId)
		.orElseThrow(()-> new ResourceNotFoundException("employueee is not exist with in given id"+employeeId));
		return EmployeeMapper.mapEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
	List<Employee>employees=	employeeReposistory.findAll();
		return employees.stream().map((employee)-> EmployeeMapper.mapEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updtaeEmployee(Long employeeId, EmployeeDto updatedemployee) {
	Employee employee=  employeeReposistory.findById(employeeId).orElseThrow(
			  ()->new ResourceNotFoundException("Employee is not found with given id"+employeeId));
	     employee.setFirstName(updatedemployee.getFirstName());
	     employee.setLastName(updatedemployee.getLastName());
	     employee.setEmail(updatedemployee.getEmail());
	     
	     
	     //save method perform both oparetion insert (primary key not exisat it's save), update 
	    Employee updatedEmployeeobj= employeeReposistory.save(employee);
		return EmployeeMapper.mapEmployeeDto(updatedEmployeeobj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		

		Employee employee=  employeeReposistory.findById(employeeId).orElseThrow(
				  ()->new ResourceNotFoundException("Employee is not found with given id"+employeeId));
		
		employeeReposistory.deleteById(employeeId);
		
	}
	



}
