package com.ust.beans;

public class Vendor_Details {
	
	private int vendor_id;
	private String vendor_name;
	private String vendor_Addr;
	private int pincode;
	private String vendor_loc;
	private String service;
	private int isActive;
	
	public Vendor_Details() {
		super();
	}

	public int getVendorId() {
		return vendor_id;
	}

	public void setVendorId(int vendorId) {
		this.vendor_id = vendorId;
	}

	public String getVendorName() {
		return vendor_name;
	}

	public void setVendorName(String vendorName) {
		this.vendor_name = vendorName;
	}

	public String getVendorAddr() {
		return vendor_Addr;
	}

	public void setVendorAddr(String vendorAddr) {
		this.vendor_Addr = vendorAddr;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getVendorLoc() {
		return vendor_loc;
	}

	public void setVendorLoc(String vendorLoc) {
		this.vendor_loc = vendorLoc;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Vendor_Details(int vendorId, String vendorName, String vendorAddr,
			int pincode, String vendorLoc, String service, int isActive) {
		super();
		this.vendor_id = vendorId;
		this.vendor_name = vendorName;
		this.vendor_Addr = vendorAddr;
		this.pincode = pincode;
		this.vendor_loc = vendorLoc;
		this.service = service;
		this.isActive = isActive;
	}

	public Vendor_Details(String vendorName, String vendorAddr, int pincode,
			String vendorLoc, String service, int isActive) {
		super();
		this.vendor_name = vendorName;
		this.vendor_Addr = vendorAddr;
		this.pincode = pincode;
		this.vendor_loc = vendorLoc;
		this.service = service;
		this.isActive = isActive;
	}

	public Vendor_Details(int vendorId, String vendorName, String vendorAddr,
			int pincode, String vendorLoc, String service) {
		super();
		this.vendor_id = vendorId;
		this.vendor_name = vendorName;
		this.vendor_Addr = vendorAddr;
		this.pincode = pincode;
		this.vendor_loc = vendorLoc;
		this.service = service;
	}

	@Override
	public String toString() {
		return "Vendor_Details [vendor_id=" + vendor_id + ", vendor_name="
				+ vendor_name + ", vendor_Addr=" + vendor_Addr + ", pincode="
				+ pincode + ", vendor_loc=" + vendor_loc + ", service="
				+ service + ", isActive=" + isActive + "]";
	}

	
	
	
	
	
	
	
	

}
