package com.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>
{

}
