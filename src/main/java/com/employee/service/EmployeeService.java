package com.employee.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.employee.entities.Employee;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	
	Optional<Employee> getId(String id);
	String deleteEmployee(String id) ; 
	
	Employee updateSalary(String id  , int salary );
	
	Employee updateDesignation(String id , String designation);
	Employee updateAddress(String id , String address );
	
	List<Employee> listAll();
	List<Employee> listAllExcel();
	
	
	
	
	
	
	
    
	
	
}
