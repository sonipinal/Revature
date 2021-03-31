package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import com.revature.exception.TeacherNotFound;
import com.revature.pojo.Teacher;
import com.revature.pojo.User;


public class TeacherDaokryo implements TeacherDao {
	private Kryo kryo = new Kryo();

	private Logger log = Logger.getRootLogger();

	private static final String FOLDER_NAME = "teachers\\";

	private static final String FILE_EXTENSION = ".txt";

	@Override
	public void createTeacher(Teacher teacher) {
		log.info("Starting to create Teacher");

		try (FileOutputStream outputStream = new FileOutputStream(FOLDER_NAME + teacher.getTeacherName() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, teacher);
			output.close();
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Teacher getTeacherByname(String teachername) throws TeacherNotFound {
		String fileName = FOLDER_NAME + teachername + FILE_EXTENSION;
		File file = new File(fileName);
		if(!file.exists())
		{
			return null;
		}

		try (FileInputStream inputStream = new FileInputStream(fileName)) {
			Input input = new Input(inputStream);
			Teacher teacher = kryo.readObject(input, Teacher.class);
			input.close();
			System.out.println(teacher);
			return teacher;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub

	}

	public TeacherDaokryo() {
		super();
		kryo.register(Teacher.class);
	}
	

}
