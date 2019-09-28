package com.ust.beans;

public class UST_Login {
	
	private String userId;
	private String userName;
	private String passWord;
	
	
	
	public UST_Login() {
		super();
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UST_Login(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public UST_Login(String userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "UST_Login [userId=" + userId + ", userName=" + userName
				+ ", passWord=" + passWord + "]";
	}
	
	
	
}
