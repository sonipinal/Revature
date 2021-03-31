package com.revature.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.exception.UserNameTaken;
import com.revature.pojo.Dept;
import com.revature.pojo.User;

public class DeptDaoImpl implements DeptDao {

	public static List<Dept> deptList;

	@Override
	public void createDept(Dept dept) {
		if (dept.getDeptId() != 0 && dept.getDeptName() != null) {

			Iterator<Dept> iter = deptList.iterator();

			while (iter.hasNext()) {
				//if (iter.next().getUsername().equals(user.getUsername())) {
					//throw new UserNameTaken("sorry! This username is already taken taken");
				//}
			//}

			// If username not taken, add user
			deptList.add(dept);

			}}

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

	public DeptDaoImpl() {
		super();
		deptList = new ArrayList<>();
		deptList.add(new Dept(1, "IT"));
		deptList.add(new Dept(2, "CS"));
	}

}
