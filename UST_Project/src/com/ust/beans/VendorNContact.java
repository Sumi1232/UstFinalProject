package com.ust.beans;

public class VendorNContact {
	
	private int contact_id;
	private String name;
	private String department;
	private String email;
	private String phone;
	private int isActiveContact;
	
	private int vendorId;
	private String vendorName;
	private String vendorAddr;
	private int pincode;
	private String vendorLoc;
	private String service;
	private int isActiveVendor;
	
	public VendorNContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getContactId() {
		return contact_id;
	}

	public void setContactId(int contactId) {
		this.contact_id = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getIsActiveContact() {
		return isActiveContact;
	}

	public void setIsActiveContact(int isActiveContact) {
		this.isActiveContact = isActiveContact;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddr() {
		return vendorAddr;
	}

	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getVendorLoc() {
		return vendorLoc;
	}

	public void setVendorLoc(String vendorLoc) {
		this.vendorLoc = vendorLoc;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getIsActiveVendor() {
		return isActiveVendor;
	}

	public void setIsActiveVendor(int isActiveVendor) {
		this.isActiveVendor = isActiveVendor;
	}

	public VendorNContact(int contactId, String name, String department,
			String email, String phone, int isActiveContact, int vendorId,
			String vendorName, String vendorAddr, int pincode,
			String vendorLoc, String service, int isActiveVendor) {
		super();
		this.contact_id = contactId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.isActiveContact = isActiveContact;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddr = vendorAddr;
		this.pincode = pincode;
		this.vendorLoc = vendorLoc;
		this.service = service;
		this.isActiveVendor = isActiveVendor;
	}

	@Override
	public String toString() {
		return "VendorNContact [contactId=" + contact_id + ", name=" + name
				+ ", department=" + department + ", email=" + email
				+ ", phone=" + phone + ", isActiveContact=" + isActiveContact
				+ ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", vendorAddr=" + vendorAddr + ", pincode=" + pincode
				+ ", vendorLoc=" + vendorLoc + ", service=" + service
				+ ", isActiveVendor=" + isActiveVendor + "]";
	}
	
	

}
