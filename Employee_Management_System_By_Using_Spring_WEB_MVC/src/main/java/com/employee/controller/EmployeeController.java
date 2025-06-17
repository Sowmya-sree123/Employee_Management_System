package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.DAO.EmployeeDAO;
import com.employee.entity.EmployeeDetails;

@Controller //creating the bean by seeing @Controller
public class EmployeeController 
{
	/*All Employee Related Request
	 * Registration
	 * Login
	 * Updation
	 * Deletion
	 */
	
//	@RequestMapping("/empregistration")//It is used to create the end point we are going to make this @RequestMapping
//	public void employeeRegistration(@RequestParam("empname") String name,String emailid,String password,double salary,int deptno) 
//	{ 
//		System.out.println("Employee Name:"+name);
//		System.out.println("Employee Emailid:"+emailid);
//		System.out.println("Employee password:"+password);
//		System.out.println("Employee Salary:"+salary);
//		System.out.println("Employee Deptno:"+deptno);
//		System.out.println("Registration Successfull....");
//	}
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@RequestMapping("/empregistration")
	public String employeeRegistration(EmployeeDetails employeeDetails)
	{
		System.out.println(employeeDetails);
		EmployeeDetails details=employeeDAO.insertEmployeeDetails(employeeDetails);
		if(details!=null)
		{
			return "redirect:/teca34/allemployeedetails";
		}
		else
		{
			return "redirect:/teca34/registrationpage";
		}	
	}
	
	@RequestMapping("/emplogin")
	@ResponseBody //to show the output on the web page
	public String employeeLogin()
	{
		System.out.println("Employee Login Successfull....");
		return "Employee Login Successfull....";
	}
	
	@RequestMapping("/registrationpage")
	//@ResponseBody
	public String employeeRegistrationPage() 
	{
		return "EmployeeRegistration";
	}
	
	@RequestMapping("/allemployeedetails")
	//@ResponseBody
	public String allEmployeeDetails(Model model)
	{
		List<EmployeeDetails> allEmployeeDetails =employeeDAO.getAllEmployeeDetails();
		//System.out.println(allEmployeeDetails());
		model.addAttribute("listofemployeedetails",allEmployeeDetails);
		return "AllEmployeeDetails";
	}
	@RequestMapping("/deletebyid")
	public String deleteUserDetailsByUsingId(@RequestParam("empid")int id)
	{
		System.out.println(id);
		if(employeeDAO.deleteEmployeeByUsingId(id))
		{
			return "redirect:/teca34/allemployeedetails";
		}
		else
		{
			return "";
		}
	}
	@RequestMapping("/update")
	public String updateUserDetailsByUsingId(int id,Model model)
	{
		Optional<EmployeeDetails> findByEmployeeId=employeeDAO.findByEmployeeId(id);
		EmployeeDetails employeeDetails=findByEmployeeId.get();
		model.addAttribute("update",employeeDetails);
		return "UpdateEmployee";
	}
	@RequestMapping("/updateddetails")
	public void UpdatedEmployeeDetails(EmployeeDetails employeeDetails)
	{
		System.out.println(employeeDetails);
		EmployeeDetails details= employeeDAO.updateEmployeeDetails(employeeDetails);
		System.out.println(details);
	}
}
