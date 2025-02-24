package com.jsp.spring_boot.service;

import java.util.List;

import com.jsp.spring_boot.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
  EmployeeDto getEmployeeById(Long employeeId);
  
  List<EmployeeDto>getAllEmployees();
  EmployeeDto  updtaeEmployee(Long employeeId,EmployeeDto updatedemployee);
  
  void deleteEmployee(Long employeeId);
}
