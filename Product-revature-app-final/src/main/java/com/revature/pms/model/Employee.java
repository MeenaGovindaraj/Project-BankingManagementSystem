package com.revature.pms.model;

public class Employee {

	
	private String name;
	private String address;
	private String branchName;
	private String password;
	private Integer id;
	private Integer branchId;
	
	public Employee()
	{
		
	}

	public Employee(String name, String address, String branchName, String password, Integer id, Integer branchId) {
		super();
		this.name = name;
		this.address = address;
		this.branchName = branchName;
		this.password = password;
		this.id = id;
		this.branchId = branchId;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	@Override
	public String toString() {
		return "Employee: \n [name=" + name + ", address=" + address + ", branchName=" + branchName + ", password="
				+ password + ", id=" + id + ", branchId=" + branchId + "]";
	}

	
}
