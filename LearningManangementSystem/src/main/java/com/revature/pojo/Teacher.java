package com.revature.pojo;

public class Teacher {
	private int TeacherID;
	private String TeacherName;
	private String email;
	private String address;
	private String deptName;
	private String cname;
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Teacher(int teacherID, String teacherName, String email, String address, String deptName, String cname) {
		super();
		TeacherID = teacherID;
		TeacherName = teacherName;
		this.email = email;
		this.address = address;
		this.deptName = deptName;
		this.cname = cname;
	}
	public Teacher() {
		super();
		
	}
	@Override
	public String toString() {
		return "Teacher [TeacherID=" + TeacherID + ", TeacherName=" + TeacherName + ", email=" + email + ", address="
				+ address + ", deptName=" + deptName + ", cname=" + cname + "]";
	}
	
	

}
