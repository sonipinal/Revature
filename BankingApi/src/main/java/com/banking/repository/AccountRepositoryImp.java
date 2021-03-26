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
import com.banking.*;

public class AccountRepositoryImp implements AccountRepository {

	// private Connection connection;

	/*
	 * Let's find all students within the database.
	 */
	@Override
	public List<Account> findAll() {
		/*
		 * Remember that this method should return a List of students. So let's define
		 * one here:
		 */
		ArrayList<Account> accounts = new ArrayList<>();

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
			set = stmt.executeQuery(
					"select * from account  inner join  accountstatus  on account.accountstatus =accountstatus.statusId inner join accounttype on account.accountType = accountType .typeId");

			/*
			 * private int accountId; // primary key private double balance; // not null
			 * private AccountStatus status; private AccountType type; We can move through
			 * each record in a ResultSet and extract the data!
			 */
			while (set.next()) {
				accounts.add(
						new Account(set.getInt(1), set.getDouble(2), new AccountStatus(set.getInt(3), set.getString(6)),
								new AccountType(set.getInt(4), set.getString(8))));

				// new AccountStatus(set.getString(3)),
				// new AccountType(set.getString(5))

				// new AccountStatus(set.getInt(3),
				// new AccountType(set.getInt(4))));

				// new Role(set.getInt(7), set.getString(9))
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
		return accounts;
	}

	public Account findById(int account_id) {
		/*
		 * We need to return a Student!
		 */
		Account account = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from account  inner join  accountstatus  on account.accountstatus =accountstatus.statusId inner join accounttype on account.accountType = accountType .typeId where accountId = "
				+ account_id;

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
				account = new Account(set.getInt(1), set.getDouble(2),
						new AccountStatus(set.getInt(3), set.getString(6)),
						new AccountType(set.getInt(4), set.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return account;
	}

	@Override
	public Account findByUserId(int userId) {
		/*
		 * We need to return a Student!
		 */
		Account account = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from account inner join user_account on account.accountId = user_account.accountid inner join bank_user on bank_user.userId = user_account.userid where bank_user. userId ="
				+ userId;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			/*
			 * We know that the ResultSet only has one record, so we only need to move the
			 * cursor once!
			 * 
			 * As an addendum, the above strategy only works if you are 100% sure that the
			 * user id exists. That said, do check using the while loop!
			 */
			while (set.next()) {
				account = new Account(set.getInt(1), set.getDouble(2),
						new AccountStatus(set.getInt(3), set.getString(6)),
						new AccountType(set.getInt(4), set.getString(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return account;
	}

	@Override
	public Account findByStatus(int statusid) {
		Account account = null;

		Connection conn = null;
		/*
		 * We are taking user input and passing it into our SQL String. That said, there
		 * is some risk of SQL injection. As such, we need to use a PreparedStatement to
		 * protect against that SQL injection.
		 */
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from account  inner join  accountstatus  on account.accountstatus =accountstatus.statusId inner join accounttype on account.accountType = accountType .typeId  where accountstatus = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			/*
			 * We have called "prepareStatement". This does not execute your query. Note
			 * that PreparedStatements work by precompiling your query so that you can
			 * parameterize the "input" passed in by your user (or from any other source).
			 */
			stmt.setInt(1, statusid);
			set = stmt.executeQuery();

			while (set.next()) {
				account = new Account(set.getInt(1), set.getDouble(2),
						new AccountStatus(set.getInt(3), set.getString(6)),
						new AccountType(set.getInt(4), set.getString(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}

		return account;
	}

	@Override
	public void insertAccount(Account account) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Statement stmt1 = null;
		final String sql1="select max(accountId) from account";
		ResultSet rs = null;
		/*
		 * Note that if your primary key is serial, you can just place "default" in the
		 * place of the first question mark.
		 */

		final String SQL = "insert into account values(?,?, ?, ?)";

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
			stmt.setDouble(2, account.getBalance());
			stmt.setInt(3, account.getStatus().getStatusId());
			stmt.setInt(4, account.getType().getTypeId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}

	@Override
	public void updateAccount(int id, double amount) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update account set balance=  ? where accountId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, amount);
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
	

	
	public void deposit(int id, double amount) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update account set balance= balance + ? where accountId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, amount);
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
	
	public void withdrawal(int aid, double wamount) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL1 = "update account set balance =(balance - ?) where accountId =?";
				//+ "update account set balance =( balance - ? ) where accountId = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL1);
			stmt.setDouble(1, wamount);
			stmt.setInt(2, aid);
			stmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	  
	}
	
	public void transfer(int fromaccId, int toaccId, double amount)
    {
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		//Statement stmt1 =null;
		//Statement stmt2 =null;
		
		final String SQL1 = "update account set balance =(balance - ?) where accountId =?";
		final String SQL2 = "update account set balance =(balance + ?) where accountId =?";
		
				
		try {
			conn = ConnectionFactory.getConnection();
			stmt1 = conn.prepareStatement(SQL1);
			stmt2 = conn.prepareStatement(SQL2);
			stmt1.setDouble(1, amount);
			stmt1.setInt(2, fromaccId);
			stmt2.setDouble(1, amount);
			stmt2.setInt(2, toaccId);
			
			stmt1.execute();
			stmt2.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt1);
			ConnectionClosers.closeStatement(stmt2);
		}
        
    }
	
	
	@Override
	public void DeleteAccount(Account account) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//Statement stmt1 = null;
		//final String sql1="select max(accountId) from account";
		//ResultSet rs = null;
		/*
		 * Note that if your primary key is serial, you can just place "default" in the
		 * place of the first question mark.
		 */

		final String SQL = "delete from account where accountId =?;";

		try {
			conn = ConnectionFactory.getConnection();
			
			
			//stmt1 = conn.createStatement();
			//rs = stmt1.executeQuery(sql1);
			//int idValue =0;
			//if(rs.next()) {
				
			//	idValue =rs.getInt(1)+1;
			//}
			//System.out.println("ID value" +idValue);
			stmt = conn.prepareStatement(SQL);
			/*stmt.setInt(1,idValue);
			stmt.setDouble(2, account.getBalance());
			stmt.setInt(3, account.getStatus().getStatusId());
			stmt.setInt(4, account.getType().getTypeId());*/
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}



	

}
