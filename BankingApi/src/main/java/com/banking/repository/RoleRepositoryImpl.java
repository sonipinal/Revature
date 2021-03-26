package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Role;
//import com.model.User;
import com.banking.util.ConnectionClosers;
import com.banking.util.ConnectionFactory;

public class RoleRepositoryImpl implements RoleRepository {

	// private Connection connection;

	/*
	 * Let's find all students within the database.
	 */
	@Override
	public List<Role> findAll() {
		/*
		 * Remember that this method should return a List of students. So let's define
		 * one here:
		 */
		ArrayList<Role> roles = new ArrayList<>();

		/*
		 * The first thing we always need to do is establish a connection to our
		 * database by providing our credentials.
		 */
		Connection conn = null;
		/*
		 * After we have established a connection to the DB, we can execute SQL
		 * statements.
		 */
		Statement stmt = null;
		/*
		 * After we've executed our statement, we want to store and access the result
		 * set.
		 */
		ResultSet set = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery("select * from bank_role ");

			/*
			 * We can move through each record in a ResultSet and extract the data!
			 */
			while (set.next()) {
				roles.add(new Role(set.getInt(1), set.getString(2)));			
						
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*
			 * No matter what, always close your database connections!
			 */
			try {
				stmt.close();
				set.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return roles;
	}

	/*
	 * This method will find a student by their id (which is the primary key). This
	 * means that this method is guaranteed to return a single student.
	 */
	@Override
	public Role findById(int id) {
		/*
		 * We need to return a Student!
		 */
		Role role = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from bank_role where roleId ="+ id;
				

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			/*
			 * We know that the ResultSet only has one record, so we only need to move the
			 * cursor once!
			 * 
			 * As an addendum, the above strategy only works if you are 100% sure that the
			 * student id exists. That said, do check using the while loop!
			 */
			while (set.next()) {
				role = new Role(set.getInt(1), set.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return role;
	}

	

}
