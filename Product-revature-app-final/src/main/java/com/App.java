package com;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.UserService;


public class App 
{
    public static void main( String[] args )
    {
    	
    	startApp();
    	
    }

public static void startApp()
{
	Logger logger=Logger.getLogger("EmployeeApp");
	Scanner sc=new Scanner(System.in);
	
	
	logger.info("Enter Type ( USER -U/ EMPLOYEE- E)");
	String type;
	type=sc.next();
	
	
	if(type.equals("U")){
		UserService userApp=new UserService();
		userApp.startUserApp();
	}
	
	
	else if(type.equals("E"))
	{
		EmployeeService employeeApp=new EmployeeService();
		employeeApp.startEmployeeApp();
	}
	
	else
	{
		System.out.println("Invalid Type");
	}
}
}