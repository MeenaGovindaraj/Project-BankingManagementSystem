package com.revature.pms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.App;
import com.revature.pms.dao.UserDAOImpl;
import com.revature.pms.exceptions.*;
import com.revature.pms.model.User;
public class UserService {

	Scanner sc = new Scanner(System.in);
	UserDAOImpl userAccount = new UserDAOImpl();

	public void startUserApp() {

		Outer: while (true) {
			System.out.println("\n    U S E R   M E N U   \n");
			System.out.println("1. Create Account");
			System.out.println("2. Update Account");
			System.out.println("3. View Account");
			System.out.println("4. Logout");
			System.out.println("5. Exit");
			
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			User user = new User();
			int result = 0;
			switch (choice) {

			case 1:
				
				System.out.println("Welcome to Create Account Section");
				try {
					user = userDetails();
					if(user!=null){
						result = userAccount.createAccount(user);
						if (result == 1)
							System.out.println("Account No " + user.getAccountNo() + " with User Name as " + user.getName()
									+ " created successfully!");
						}
						else
						{
							System.out.println("# sorry , Account Not created");
						}
				} 
				catch (MinimumAmount e1) {
					System.out.println(e1.getMessage());
				}
				break;
			
			case 2:
				
				System.out.println("Welocme to Update Account section");
				System.out.print("Enter Account Number");
				int accountNo = sc.nextInt();
				result = userAccount.updateAccount(accountNo);
				if (result == 1)
					System.out.println("Account" + " Updated Successfully");
				
				break;
			
			case 3:
				
				System.out.println("Welcome to View Account Section");
				accountNo = sc.nextInt();
				List<User> viewUser = null;
				viewUser = userAccount.ViewAccount(accountNo);
				System.out.println(viewUser);
				break;
				
			case 4:
				App app=new App();
			   app.startApp();
			case 5:
				//userAccount.view();
				System.out.println("Thank You for using app :)");
				System.exit(0);
			}
		}
	}

	

	



	public User userDetails() throws MinimumAmount {
		
		User user=null;
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter address:");
		String address = sc.next();
		System.out.println("Enter phone Number:");
		String phoneNo = sc.next();
		System.out.println("Enter User Name:");
		String userName = sc.next();
		userName += sc.nextLine();
		System.out.println("Enter Account No");
		int accountNo = sc.nextInt();
		System.out.println("Set a password [ Minimum 6 chars with upper, lower and digts and special charcters ]");
		String  password = sc.next();
		while (!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{6,}")))) {
			System.out.println("Invalid password condition. Set again :");
			password = sc.next();
		}
		
		System.out.println("Enter Account Type:");
		String accountType = sc.next();
		
		System.out.print("Enter initial deposit : ");
		Double amount = sc.nextDouble();

		if(accountType.equals("CA")){
		while((amount<1000))
		{
			
			throw new MinimumAmount(
					"Please make sure Your 	Minimum amount for Current Account should be more than 1000");
			
		}
		}
		user = new User(userName, password, userName, address, phoneNo, accountType, amount, accountNo);
		return user;
	}
}
