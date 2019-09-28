package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Contact_Details;



public class Contact_DetailsDao {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//display list of contacts
	public List<Contact_Details> findAll(int vendorId){
		 String sql="select * from Contact_Details where isActive=1 and v_id="+vendorId;
			
		 return jdbcTemplate.query(sql, new RowMapper<Contact_Details>() {
			 public Contact_Details mapRow(ResultSet rs,int row) throws SQLException{
				 Contact_Details contact=new Contact_Details();
				 contact.setContact_id(rs.getInt("contact_id"));
				 contact.setName(rs.getString("name"));;
				 contact.setEmail(rs.getString("email"));
				 contact.setPhone(rs.getString("phone"));
				 contact.setDepartment(rs.getString("department"));
				 contact.setV_id(rs.getInt("v_id"));
				 contact.setIsActive(rs.getInt("isActive"));
				 return contact;
			 }
		 });
	}
	//inserting a new contact..
    public int insertContact(Contact_Details contactdetails) {
    	String sql="insert into Contact_Details(name,email,department,phone,v_id,isActive) "
    			+ "values('"+contactdetails.getName()+"','"+contactdetails.getEmail()+"','"
    			+contactdetails.getDepartment()+"','"+contactdetails.getPhone()+"',"+contactdetails.getV_id()+",1)";
    	return jdbcTemplate.update(sql);
		
	}
    
    //search by contact id
    public Contact_Details getById(int id)
	{
		String sql="select * from Contact_Details where contact_id=?";
		return (Contact_Details) jdbcTemplate.queryForObject(sql, new Object[]{id}, 
				new BeanPropertyRowMapper<Contact_Details>(Contact_Details.class));
	}
    
    //updating contact's details
    
    public int updateContact(Contact_Details contactDetails){
    	String sql="update Contact_Details set name='"+contactDetails.getName()
    			+"',email='"+contactDetails.getEmail()+"',department='"+contactDetails.getDepartment()+
    			"',phone='"+contactDetails.getPhone()+"',v_id="+contactDetails.getV_id()
    					+ " where contact_id="+contactDetails.getContact_id();
		return jdbcTemplate.update(sql);
    }
    
	//disable contact
    
    public int disableContact(int contactId){
    	String sql="update Contact_Details set isActive=0 where contact_id="+contactId;
    	return jdbcTemplate.update(sql);
    }
	
	

}
