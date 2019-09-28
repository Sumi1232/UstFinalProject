package com.ust.beans;

public class Contact_Details {
	private int contact_id;
	private String name;
	private int v_id;
	private String department;
	private String email;
	private String phone;
	private int isActive;
	
	public Contact_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Contact_Details(int contact_id, String name, int v_id,
			String department, String email, String phone, int isActive) {
		super();
		this.contact_id = contact_id;
		this.name = name;
		this.v_id = v_id;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.isActive = isActive;
	}

	public Contact_Details(String name, int v_id, String department,
			String email, String phone, int isActive) {
		super();
		this.name = name;
		this.v_id = v_id;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.isActive = isActive;
	}

	
	

}
