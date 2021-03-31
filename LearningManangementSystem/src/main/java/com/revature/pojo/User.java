package com.revature.pojo;

public class User {

	private String uname;
	
	private String password;

	public String getUsername() {
		return uname;
	}

	public void setUsername(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.uname = username;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "Welcome " + uname ;
		//return "User [username=" + uname + ", password=" + password + "]";
	}
	
}
