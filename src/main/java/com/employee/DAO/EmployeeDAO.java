package com.employee.DAO;

import java.util.List;
import java.util.Optional;

import com.employee.Repository.EmployeeRepository;
import com.employee.entity.EmployeeDetails;

public interface EmployeeDAO 
{
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails);
	public List<EmployeeDetails> getAllEmployeeDetails();
	public boolean deleteEmployeeByUsingId(int id);
	Optional<EmployeeDetails> findByEmployeeId(int id);
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails);

}
