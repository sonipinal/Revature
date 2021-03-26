package com.banking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Account;
import com.model.AccountStatus;
import com.model.AccountType;
import com.model.Role;
import com.model.User;

import com.banking.util.ConnectionClosers;
import com.banking.util.ConnectionFactory;

public class UserRepositoryImpl implements UserRepository {

	// private Connection connection;

	/*
	 * Let's find all students within the database.
	 */
	@Override
	public List<User> findAll() {
		/*
		 * Remember that this method should return a List of students. So let's define
		 * one here:
		 */
		ArrayList<User> users = new ArrayList<>();

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
			set = stmt
					.executeQuery("select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid");

			/*
			 * We can move through each record in a ResultSet and extract the data!
			 */
			while (set.next()) {
				users.add(new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6),
						new Role(set.getInt(7), set.getString(9))));
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
		return users;
	}

	/*
	 * This method will find a student by their id (which is the primary key). This
	 * means that this method is guaranteed to return a single student.
	 */
	@Override
	public User findById(int id) {
		/*
		 * We need to return a Student!
		 */
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid where userId ="
				+ id;

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
				user = new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), new Role(set.getInt(7), set.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return user;
	}
	
	@Override
	public User findByPassword(String password) {
		User user = null;

		Connection conn = null;
		/*
		 * We are taking user input and passing it into our SQL String. That said, there
		 * is some risk of SQL injection. As such, we need to use a PreparedStatement to
		 * protect against that SQL injection.
		 */
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid where upassword = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			/*
			 * We have called "prepareStatement". This does not execute your query. Note
			 * that PreparedStatements work by precompiling your query so that you can
			 * parameterize the "input" passed in by your user (or from any other source).
			 */
			stmt.setString(1, password);
			set = stmt.executeQuery();

			while (set.next()) {
				user = new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), new Role(set.getInt(7), set.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}

		return user;
	}

	@Override
	public User findByUserName(String name) {
		User user = null;

		Connection conn = null;
		/*
		 * We are taking user input and passing it into our SQL String. That said, there
		 * is some risk of SQL injection. As such, we need to use a PreparedStatement to
		 * protect against that SQL injection.
		 */
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from bank_user inner join bank_role on bank_user.urole =bank_role.roleid where userName = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			/*
			 * We have called "prepareStatement". This does not execute your query. Note
			 * that PreparedStatements work by precompiling your query so that you can
			 * parameterize the "input" passed in by your user (or from any other source).
			 */
			stmt.setString(1, name);
			set = stmt.executeQuery();

			while (set.next()) {
				user = new User(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), new Role(set.getInt(7), set.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}

		return user;
	}

	@Override
	public void insert(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//PreparedStatement stmt2 = null;
		Statement stmt1 = null;
		final String sql1="select max(userId) from bank_user";
		ResultSet rs = null;
		
		
		
		/*
		 * Note that if your primary key is serial, you can just place "default" in the
		 * place of the first question mark.*/
		 
		//long id=0;
		final String SQL = "insert into bank_user values(?, ?, ?,?,?,?,?)";

		try {
			
			conn = ConnectionFactory.getConnection();
			stmt1 = conn.createStatement();
			rs = stmt1.executeQuery(sql1);
			int idValue =0;
			if(rs.next()) {
				
				idValue =rs.getInt(1)+1;
			}
			System.out.println("ID value" +idValue);
			
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1,idValue);
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setString(6, user.getEmail());
			stmt.setInt(7, user.getRole().getRoleId());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		//return id;

	}
	@Override
	public boolean delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean  CheckUserAndPassword(String username,String password) {
		
		 // User user = null;
		  String usernm= "",userpass="";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet set = null;
			final String SQL = "select username, upassword from bank_user  where username = ?";
			
			try {
				conn = ConnectionFactory.getConnection();
				stmt = conn.prepareStatement(SQL);
				stmt.setString(1, username);
				set = stmt.executeQuery();
				
				
				while(set.next()) {
				 
							usernm=set.getString(1);
									userpass=set.getString(2);
					         
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeResultSet(set);
				ConnectionClosers.closeStatement(stmt);
			}
			if (!usernm.equals(username)&& !userpass.equals(password)){
				return false;
			}
			else {
				return true;
			}
			
		 
	  }

	
	@Override
	public void update(int id, String email) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update bank_user set uemail= ? where userID=?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, email);
			stmt.setInt(2, id);
			stmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	  
	}
	

}
