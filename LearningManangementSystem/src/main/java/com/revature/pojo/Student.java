package com.revature.pojo;

public class Student {
	private  int sId;
	private String fname;
	private String lname;
	private String course;
	private String teacherName;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Student(int sId, String fname, String lname, String course, String teacherName) {
		super();
		this.sId = sId;
		this.fname = fname;
		this.lname = lname;
		this.course = course;
		this.teacherName = teacherName;
	}
	public Student() {
		super();
		
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", fname=" + fname + ", lname=" + lname + ", course=" + course + ", teacherName="
				+ teacherName + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
