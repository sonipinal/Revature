package com.revature.dao;

import java.util.List;

import com.revature.exception.TeacherNotFound;

import com.revature.pojo.Teacher;

public interface TeacherDao {
	
	public void createTeacher(Teacher teacher);

	public Teacher getTeacherByname(String teachername) throws TeacherNotFound;;

	public List<Teacher> getAllTeachers();

	public void updateTeacher(Teacher teacher);

	public void removeTeacher(Teacher teacher);

}
