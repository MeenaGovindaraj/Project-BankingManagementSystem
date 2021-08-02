package com.revature.pms.dao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.revature.pms.exceptions.AccountException;
import com.revature.pms.model.Employee;
import com.revature.pms.model.User;

public class EmployeeDAOImpl implements AccountDAO {

	Logger logger=Logger.getLogger("EmployeeDAOImpl");
	
	//to store the employee details
	private ArrayList<Employee> employeesList = new ArrayList<Employee>();
	Scanner sc=new Scanner(System.in);
	
	public Integer createAccount(Employee employee) {
		
		Integer result=1;
		
		for(Employee employeeList:employeesList){
			
			//to check if Account is already exists
				if(employee.getid().equals(employeeList.getid()))
				{
					try {
						throw new AccountException("User Account Already Exists");
						} 
					
				catch (AccountException e) {
					logger.error(e.getMessage());
					
				}
					result=0;
				}
		}
		
		if(result==1)
			employeesList.add(employee);
		
		return result;
	}

	@Override
	public Integer updateAccount(Integer employeeId) {

		Integer result=1;
		
		Employee ey=employeesList.stream()
				.filter(u-> employeeId.equals(u.getid()))
				.findAny().orElse(null);
		
		//if account does not found
		if(ey==null)
		{
			try {
				throw new AccountException("Account No: "+employeeId+ " Doesn't Exsits");
			} 
			catch (AccountException e) {
				logger.error(e.getMessage());
			}
			result=0;
		}
		
		//updating account..
		else{
			int index=employeesList.indexOf(ey);
			Employee employee=getUpdate(ey,employeeId);
			employeesList.set(index, employee);
		}
		return result;
	
	}

	@Override
	public Integer DeleteAccount(Integer employeeId) {
		
		Integer result=1;

		Employee us= employeesList.stream()
				//to filter the particulars account
				.filter(u -> employeeId.equals(u.getid()))
				.findAny().orElse(null);
		
		//if account does not found
		if(us==null)
		{
			try {
				throw new AccountException("Account No: "+employeeId+ " Doesn't Exsits");
			} 
			catch (AccountException e) {
				logger.error(e.getMessage());
			}
			result=0;
		}
		
		//removing account..
		else{
			int index=employeesList.indexOf(us);
			employeesList.remove(index);
		}
		return result;
		
		
		
	}
	
	@Override
	public List<Employee> ViewAccount(Integer employeeId) {
		
		List<Employee> employee=employeesList.stream()
				//to filter the particulars account
				.filter(u -> employeeId.equals(u.getid()))
				.collect(Collectors.toList());
		if(employee.isEmpty())
		{
			try {
				throw new AccountException("Account No :"+employeeId+ " Doesn't found");
				}
			catch (AccountException e) {
					logger.error(e.getMessage());
				}
		}
		
		return employee;
	}

	

	private Employee getUpdate(Employee employee,Integer employeeId) {
		
		Integer choice=0;
		String name=employee.getName();
		String password=employee.getPassword();
		String branchName=employee.getBranchName();
		String address=employee.getAddress();
	
		while(true)
		{
			System.out.println("\nChoose to Update");
			System.out.println("1. NAME");
			System.out.println("2. PASSWORD");
			System.out.println("3. BRANCHNAME");
			System.out.println("4. ADSRESSS");
			System.out.println("5. Exit");
			choice=sc.nextInt();
		try{
			switch(choice)
			{
			case 1:
				System.out.println("Enter NAME to Update");
				name=sc.next();
				name+=sc.nextLine();
				break;
			case 2:
				System.out.println("Enter PASSWORD to Update");
				password=sc.next();
				break;
			case 3:
				System.out.println("Enter BRANCH NAME to Update");
				branchName=sc.next();
				branchName+=sc.nextLine();
				break;
			case 4:
				System.out.println("Enter ADDRESS to Update");
				address=sc.next();
				break;
			case 5:
				System.out.println("Updated..");
				employee=new Employee(name, address, branchName, password, employeeId, employee.getBranchId());
				return employee;
			}
			}
			catch(InputMismatchException e)
			{
				System.err.println("Input Mismatch !!, Enter correct type of value");
				getUpdate(employee,employeeId);
			}
		}	
	}


	
	/*public void view()
	{
		System.out.println(employeesList);
	}*/
	

	
}
