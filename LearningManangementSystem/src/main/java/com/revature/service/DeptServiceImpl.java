package com.revature.service;
import com.revature.dao.DeptDao;
import com.revature.dao.UserDao;
import com.revature.pojo.Dept;

public class DeptServiceImpl implements DeptService {
	
	private DeptDao deptDao;
	

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}


	@Override
	public Dept AddDept(Dept dept) {
		//dept=null;
		deptDao.createDept(dept);
		return dept;
	}

	public DeptServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeptServiceImpl(DeptDao deptDao) {
		super();
		this.deptDao = deptDao;
	}
	

}
