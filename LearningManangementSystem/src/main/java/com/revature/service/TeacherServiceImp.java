package com.revature.service;

import com.revature.dao.TeacherDao;
import com.revature.dao.UserDao;
import com.revature.pojo.Teacher;

public class TeacherServiceImp implements TeacherService {
	private TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public Teacher registerTeacher(Teacher teacher) {
		teacherDao.createTeacher(teacher);
		return teacher;
	}

	public TeacherServiceImp() {
		super();
		
	}

	public TeacherServiceImp(TeacherDao teacherDao) {
		super();
		this.teacherDao = teacherDao;
	}
	

}
