package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import com.revature.pojo.Dept;

public class DeptDaoKryo implements DeptDao {
	private Kryo kryo = new Kryo();

	private Logger log = Logger.getRootLogger();
	
	private static final String FOLDER_NAME = "departments\\";
	
	private static final String FILE_EXTENSION = ".txt";
	
	

	@Override
	public void createDept(Dept dept) {
		// TODO Auto-generated method stub
		log.info("Starting to Add new Department");
		
		try(FileOutputStream outputStream = new FileOutputStream(FOLDER_NAME + dept.getDeptName() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, dept);
			output.close();
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Dept> getAlldepts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public DeptDaoKryo() {
		super();
		kryo.register(Dept.class);

	}

}
