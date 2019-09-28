package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.UST_Login;

public class UST_LoginDao {
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertUser(UST_Login ustlog){
		String sql="insert into UST_Login values('"+ustlog.getUserId()+"',"
				                           + "'"+ustlog.getUserName()+"',"
						                   + "'"+ustlog.getPassWord()+"')";
		return jdbcTemplate.update(sql);
	}
   
	public int updateUser(UST_Login ustlog){
		String sql="update table UST_Login set password= '"+ustlog.getPassWord()+"'"
				   + ",username= '"+ustlog.getUserName()+"'where userId = '" 
	               +ustlog.getUserId()+"'";
		return jdbcTemplate.update(sql);
	}
	
	public UST_Login findAll(String uid,String pw){
		 String sql="select userid from UST_Login where username='"+uid
				 +"'and password='"+pw+"'";
			
		 return jdbcTemplate.queryForObject(sql, new Object[]{},new BeanPropertyRowMapper<UST_Login>(UST_Login.class) {
			
		 });
	}
	
	
	
}
