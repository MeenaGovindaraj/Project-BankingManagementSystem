package com.revature.pms.model;

public class User {

	private String name;
	private String userName;
	private String password;
	private String address;
	private String phone;
	private String accountType;
	private Double balance;
	private Integer accountNo;
	
	

	public User()
	{
		
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public User(String userName, String password, String name, String address, String phone, String accountType,
			Double balance, Integer accountNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.accountType = accountType;
		this.balance = balance;
		this.accountNo = accountNo;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "\nUser [AccountNo=" + accountNo + ", UserName=" + userName + ", AccountType=" + accountType + ", Address="
				+ address + ", PhoneNumber=" + phone + ", Balance=" + balance + "]";
	}

	
	
}
