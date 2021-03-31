package com.revature.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.revature.exception.TeacherNotFound;
import com.revature.exception.UserNotFound;

import com.revature.pojo.Dept;
import com.revature.pojo.Teacher;
import com.revature.pojo.User;


public class TeacherDaoImpl implements TeacherDao {
	public static List<Teacher> teacherList;

	@Override
	public void createTeacher(Teacher teacher) {
		
		teacherList.add(teacher);
		
	}

	@Override
	public Teacher getTeacherByname(String teachername) throws TeacherNotFound {
		Iterator<Teacher> iter = teacherList.iterator();
		
		while (iter.hasNext()) {
			
			Teacher existingTeacher = iter.next();
			if (existingTeacher.getTeacherName().equalsIgnoreCase(teachername)) {
				return existingTeacher;
			}
		}
		
		throw new TeacherNotFound();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	public TeacherDaoImpl() {
		super();
	
		teacherList = new ArrayList<>();
		teacherList.add(new Teacher(1, "test","test@dummy.com","aaaa","IT","Web Designing"));
		
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}
	

}
