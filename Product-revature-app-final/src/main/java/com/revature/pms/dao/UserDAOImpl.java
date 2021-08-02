package com.revature.pms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.revature.pms.exceptions.AccountException;
import com.revature.pms.model.User;

public class UserDAOImpl implements AccountDAO {

	Logger logger=Logger.getLogger("UserDAOImpl");
	//to store the user details
	ArrayList<User> userList = new ArrayList<User>();
	Scanner sc=new Scanner(System.in);
	
	public Integer createAccount(User user) {
		
		Integer result=1;
		
		for(User userlist:userList){
			
			//to check if Account is already exists
			if(user.getAccountNo().equals(userlist.getAccountNo()))
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
			userList.add(user);
		return result;
	}

	
	public Integer updateAccount(Integer accountNo){

		Integer result=1;
		User us=userList.stream()
				.filter(u-> accountNo.equals(u.getAccountNo()))
				.findAny().orElse(null);
		
		//if account does not found
		if(us==null){
			try {
				throw new AccountException("Account No: "+accountNo + "Doesn't Exsits");
			}
			catch (AccountException e) {
				logger.error(e.getMessage());
			}
			result=0;
		}
		
		//updating account..
		else{
			int index=userList.indexOf(us);
			User user=getUpdate(us,accountNo);
			userList.set(index, user);
		}
		return result;
	
	}

	
	public Integer DeleteAccount(Integer accountNo){
		
		
		Integer result=1;
		User us= userList.stream()
				//to filter the particulars account
				.filter(u -> accountNo.equals(u.getAccountNo()))
				.findAny().orElse(null);
		
		//if account does not found
		if(us==null){
			try {
				throw new AccountException("Account No: "+accountNo + "Doesn't Exsits");
			}
			catch (AccountException e) {
				logger.error(e.getMessage());
			}
			result=0;
		}
		
		//removing account..
		else{
			int index=userList.indexOf(us);
			userList.remove(index);
		}
		return result;
		
		
		
	}

	public List<User> ViewAccount(Integer accountNo) {
		
		
		List<User> userView=userList.stream()
				//to filter the particulars account
				.filter(u -> accountNo.equals(u.getAccountNo()))
				.collect(Collectors.toList());
		if(userView.isEmpty())
		try {
				throw new AccountException("Account No :"+accountNo+ " Doesn't found");
			} 
		catch (AccountException e) {
				logger.error(e.getMessage());
			}
		return userView;
	}

	private User getUpdate(User us,Integer accountNo) {
		
		int choice=0;
		User user = null;
		String name=us.getName();
		String password=us.getPassword();
		String userName=us.getUserName();
		String phoneNo=us.getPhone();
		String address=us.getAddress();
		while(true)
		{
			System.out.println("\nChoose to Update");
			System.out.println("1. NAME");
			System.out.println("2. PASSWORD");
			System.out.println("3. USER NAME");
			System.out.println("4. PHONE NUMBER");
			System.out.println("5. ADDRESS");
			System.out.println("6. Exit");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter NAME to Update");
				name=sc.next();
				break;
			case 2:
				System.out.println("Enter PASSWORD to Update");
				password=sc.next();
				break;
			case 3:
				System.out.println("Enter USERNAME to Update");
				userName=sc.next();
				userName+=sc.nextLine();
				break;
			case 4:
				System.out.println("Enter PHONE NUMBER to Update");
				phoneNo=sc.next();
				break;
			case 5:
				System.out.println("Enter ADDRESS to Update");
				address=sc.next();
				break;
			case 6:
				System.out.println("Updated..");
				user=new User(userName,password,name, address, phoneNo,us.getAccountType(),us.getBalance(), accountNo);
				return user;
			}
		}
		
	}



	/*public void view()
	{
		System.out.println(userList);
	}*/
	

	
}
