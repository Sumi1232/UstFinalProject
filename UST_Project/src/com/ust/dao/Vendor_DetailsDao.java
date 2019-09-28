package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.VendorNContact;
import com.ust.beans.Vendor_Details;

public class Vendor_DetailsDao {
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//display list of vendors
	public List<Vendor_Details> findAll(){
		 String sql="select * from Vendor_Details where isActive=1";
			
		 return jdbcTemplate.query(sql, new RowMapper<Vendor_Details>() {
			 public Vendor_Details mapRow(ResultSet rs,int row) throws SQLException{
				 Vendor_Details vendor=new Vendor_Details();
				 vendor.setVendorId(rs.getInt("vendor_id"));
				 vendor.setVendorName(rs.getString("vendor_name"));
				 vendor.setVendorLoc(rs.getString("vendor_loc"));
				 vendor.setVendorAddr(rs.getString("vendor_addr"));
				 vendor.setService(rs.getString("vendor_serv"));
				 vendor.setPincode(rs.getInt("pincode"));
				 vendor.setIsActive(rs.getInt("isActive"));
				 return vendor;
			 }
		 });
	}
	//inserting a new vendor..
    public int insertVendor(Vendor_Details vendordetails) {
    	String sql="insert into vendor_details(vendor_name,vendor_loc,vendor_addr,vendor_serv,pincode,isActive) "
    			+ "values('"+vendordetails.getVendorName()+"','"+vendordetails.getVendorLoc()+"','"
    			+vendordetails.getVendorAddr()+"','"+vendordetails.getService()+"',"+vendordetails.getPincode()+",1)";
    	return jdbcTemplate.update(sql);
		
	}
    
    //search by vendor id
    public Vendor_Details getById(int id)
	{
		String sql="select * from Vendor_Details where vendor_id=?";
		return (Vendor_Details) jdbcTemplate.queryForObject(sql, new Object[]{id}, 
				new BeanPropertyRowMapper<Vendor_Details>(Vendor_Details.class));
	}
    
    //updating vendor's details
    
    public int updateVendor(Vendor_Details vendorDetails){
    	String sql="update Vendor_Details set vendor_name='"+vendorDetails.getVendorName()
    			+"',vendor_loc='"+vendorDetails.getVendorLoc()+"',vendor_addr='"+vendorDetails.getVendorAddr()+
    			"',vendor_serv='"+vendorDetails.getService()+"',pincode="+vendorDetails.getPincode()
    					+ " where vendor_id="+vendorDetails.getVendorId();
		return jdbcTemplate.update(sql);
    }
    
	//disable vendor
    
    public int disableVendor(int vendorId){
    	String sql="update Vendor_Details set isActive=0 where vendor_Id="+vendorId;
    	return jdbcTemplate.update(sql);
    }
    
    //inserting contact and vendor details
    
    public int insertContactVendor(VendorNContact vc){
    	String sql1="insert into vendor_details(vendor_name,vendor_loc,vendor_addr,vendor_serv,pincode,isActive) "
    			+ "values('"+vc.getVendorName()+"','"+vc.getVendorLoc()+"','"
    			+vc.getVendorAddr()+"','"+vc.getService()+"',"+vc.getPincode()+","+1+")";
    	    jdbcTemplate.update(sql1);
    	    
    	    Integer maxId = getSequence();
    	    System.out.println(sql1);
    	   
    	String sql="insert into Contact_Details(name,email,department,phone,v_id,isActive) "
    			+ "values('"+vc.getName()+"','"+vc.getEmail()+"','"
    			+vc.getDepartment()+"','"+vc.getPhone()+"',"+maxId+","+1+")";
    	System.out.println(sql);
    	return jdbcTemplate.update(sql);
    }
    
    private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendor_id)from vendor_details";
		seq = jdbcTemplate.queryForObject(sql, new Object[] {},Integer.class);
		return seq;
	}
    
    //editing vendor and contact details
    
    public int updateVendorNContact(int vendor_id, VendorNContact vc) {

		String sql = "update vendor_details set vendor_name=" + vc.getName()
				+ " ,vendor_addr='" + vc.getVendorAddr() + "' , vendor_loc ='"
				+ vc.getVendorLoc() + "',vendor_serv='" + vc.getService() + "',pincode='" + vc.getPincode() + "',isActive=" + vc.getIsActiveVendor() + " "
				+ "where vendor_id =" + vendor_id;
		jdbcTemplate.update(sql);

		// Integer maxId = getSequence();

		String sql1 = "update contact_details set v_id=" + vendor_id + "',name='"
				+ vc.getName() + "',department='"
				+ vc.getDepartment() + "',email='"
				+ vc.getEmail() + "',phone='" + vc.getPhone() + "'where contact_id = " + vc.getContactId();

		return jdbcTemplate.update(sql1);
	}
    //get vendor and contact by id
    public VendorNContact selectAll(int vendor_id){
    	String sql="select * from vendor_details vc join contact_details cd"
    			+ " on vc.vendor_id=cd.v_id where vc.vendor_id="+vendor_id+"";
    	System.out.println(sql);
    	return jdbcTemplate.queryForObject(sql, new Object[] {},
    			new BeanPropertyRowMapper<VendorNContact>(VendorNContact.class));
    }
}
