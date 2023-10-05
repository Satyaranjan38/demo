package com.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Repository.EmployeeRepository;
import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
@Transactional
public class EmployeeServiceimpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	// save employee
	// saving employee details using save method in repository
	public Employee saveEmployee(Employee employee) {
		
		
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	// update salary

	// get all employee

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	// get employee by id
	public Optional<Employee> getId(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	// delete by id
	// delete the id of employee using method deleteById
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee details deleted sucessfully";
	}

	// update the salary of employee using path variable id and salary
	// search the id of employee is exist or not
	// set the salary using method setSalary()
	// save the data to employee repository

	public Employee updateSalary(String id, int salary) {
		// TODO Auto-generated method stub
		Employee em = employeeRepository.findById(id).get();

		em.setSalary(salary);
		return employeeRepository.save(em);

	}

	// update designation
	public Employee updateDesignation(String id, String designation) {
		Employee em = employeeRepository.findById(id).get();

		em.setDesignation(designation);

		return employeeRepository.save(em);

	}
// update address

	public Employee updateAddress(String id, String address) {
		// TODO Auto-generated method stub
		Employee em = employeeRepository.findById(id).get();

		em.setAddress(address);

		return employeeRepository.save(em);

	}

	// export to pdf
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
	// export to excel 

	@Override
	public List<Employee> listAllExcel() {
		return employeeRepository.findAll();
		
	}

	
	
	

}
