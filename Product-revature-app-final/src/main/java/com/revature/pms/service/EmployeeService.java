package com.revature.pms.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.App;
import com.revature.pms.dao.EmployeeDAOImpl;
import com.revature.pms.dao.UserDAOImpl;
import com.revature.pms.exceptions.AccountException;
import com.revature.pms.exceptions.MinimumAmount;
import com.revature.pms.exceptions.AccountException;
import com.revature.pms.exceptions.AccountException;
import com.revature.pms.model.Employee;
import com.revature.pms.model.User;


public class EmployeeService {

	Logger logger=Logger.getLogger("EmployeeApp");
	Scanner sc = new Scanner(System.in);
	EmployeeDAOImpl employeeAccount=new EmployeeDAOImpl();

	public void startEmployeeApp()  {

		Outer: while (true) {
			System.out.println("\n    EMPLOYEER MENU   \n");
			System.out.println("1. Create Account");
			System.out.println("2. Update Account");
			System.out.println("3. Delete Account");
			System.out.println("4. View Account");
			System.out.println("5. Logout");
			System.out.println("6. Exit");
			
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			Employee employee=new Employee();
			
		
			int result = 0;
			
			try{
			switch (choice) {

			case 1:
				
				logger.info("Welcome to Create Account Section");
				try {
					employee=employeeDetails();
					if(employee!=null){
						
						result = employeeAccount.createAccount(employee);
						if (result == 1)
							logger.info(" Employee Id " + employee.getid() + " with employee Name as " + employee.getName()
									+ " created successfully!");
						else
						{
							logger.error("# sorry Account Not created");
						}	
					}
						
				} 
				catch (MinimumAmount e1) {
					logger.error(e1.getMessage());
				}
			
				break;
			
			case 2:
				
				logger.info("Welocme to Update Account section");
				System.out.print("Enter employee Id");
				int employeeId = sc.nextInt();
				result = employeeAccount.updateAccount(employeeId);
				if (result == 1)
					logger.info("Your Employee Account" + " Updated Successfully");
			
				break;
			
			case 3:
				
				logger.info("Welocme to Delete Account section");
				System.out.print("Enter Employee Id");
				employeeId= sc.nextInt();
				result = employeeAccount.DeleteAccount(employeeId);
				if (result == 1)
					logger.info("Account :" + employeeId + " deleted Successfully");
				break;
			
			case 4:
				
				logger.info("Welcome to View Account Section");
				employeeId = sc.nextInt();
				List<Employee> viewEmployee = null;
				viewEmployee = employeeAccount.ViewAccount(employeeId);
				if(viewEmployee.isEmpty()==false)
					System.out.println(viewEmployee);
				break;
				
			
			case 5:
				App app=new App();
				   app.startApp();
			case 6:
				//employeeAccount.view();
				logger.info("Thank You for using app :)");
				System.exit(0);
			}
			}
			catch(InputMismatchException e)
			{
				System.err.println("Input Mismatch! , Enter correct type of value ");
				startEmployeeApp();
				
			}
		}
	}
	
	public Employee employeeDetails() throws MinimumAmount,InputMismatchException {
		
		Employee employee=null;
		try{
		System.out.println("Enter Employee Id");
		int employeeId= sc.nextInt();
		System.out.println("Enter employee Name:");
		String name = sc.next();
		System.out.println("Enter address:");
		String address = sc.next();
		System.out.println("Enter Branch Id");
		int branchId= sc.nextInt();
		System.out.println("Enter Branch name:");
		String branchName = sc.next();
		
		System.out.println("Set a password [ Minimum 6 chars with upper, lower and digts and special charcters ]");
		String  password = sc.next();
		while (!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{6,}")))) {
			System.out.println("Invalid password condition. Set again :");
			password = sc.next();
		}

		employee=new Employee(name, address, branchName, password, employeeId, branchId);
		return employee;
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input Mismatch !!, Enter correct type of value");
			
		}
			
		return employee;
}
}

