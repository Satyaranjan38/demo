package com.employee.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;
import com.lowagie.text.DocumentException;

import PdfExporter.UserExcelExporter;
import PdfExporter.UserPDFExporter;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService ;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/saveEmployee")
	Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee); 
	}
	
	@GetMapping("/home")
	String homePage() {
		return "Welcome to employee registration home page";
	}
	@GetMapping("/homepage")
	String homePage1() {
		return "Hello candidate welcome to incture registration portal";
	}
	// update salary 
	@PutMapping("/updateSalary/{id}/{salary}")
	public Employee updateSalary(@PathVariable String id   , @PathVariable  int salary) {
		return employeeService.updateSalary(id, salary);
	}
	
	// get all employee
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	
	
	// delete employee details 
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id ) {
		return employeeService.deleteEmployee(id);
	}
	
	// update designation 
	@PutMapping("/updateDesignation/{id}/{designation}")
	public Employee updateDesignation(@PathVariable String id , @PathVariable String designation) {
		return employeeService.updateDesignation(id, designation);
	}
	
	// update address 
	
	@PutMapping("/updateAddress/{id}/{address}")
	public Employee updateAddress(@PathVariable String id , @PathVariable String address) {
		return employeeService.updateAddress(id, address);
	}
	
	// export pdf format
	
	@GetMapping("/pdf")
	 public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Employee_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Employee> listUsers = employeeService.listAll();
         
        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);
         
    }
	
	// export to excel sheet
	 @GetMapping("/excel")
	    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Employee_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Employee> listUsers = employeeService.listAll();
	         
	        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
	         
	        excelExporter.export(response);    
	    }  
}
	
	
	
		


