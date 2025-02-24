package com.jsp.spring_boot.mapper;

import com.jsp.spring_boot.dto.EmployeeDto;
import com.jsp.spring_boot.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapEmployeeDto(Employee employee) {
		
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
	}
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				
				);
	}


}
