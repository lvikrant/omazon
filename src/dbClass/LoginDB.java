package dbClass;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class LoginDB {
	//Connection connection = null;
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	/*public static void main(String[] args) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			//resultSet = statement.executeQuery("select * from FEEDBACK.COMMENTS");
			// writeResultSet(resultSet);
			preparedStatement = connect
					.prepareStatement("SELECT * from login");
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("The columns in the table are: ");
		    
		    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
		      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		    }
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}*/
	
	public String getPswd(String userId) throws Exception
	{
		String password=null;
		try{

			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");
			PreparedStatement preparedStatement2=connect.prepareStatement("select password from login where userId=?");
			preparedStatement2.setString(1, userId);
			ResultSet resultset2=preparedStatement2.executeQuery();
			resultset2.next();
			password=resultset2.getString(1);
			return password;
		}
		catch(Exception e){
			return password;
		}
		finally{
			close();
		}
	}
	 

	public int changePsw(String userId,String newPsw)throws Exception
	{
		try{

			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");
			PreparedStatement preparedStatement=connect.prepareStatement("update login set password=? where userId=?");
			preparedStatement.setString(1, newPsw);
			preparedStatement.setString(2,userId);
			ResultSet resultset=preparedStatement.executeQuery();
			if(resultset.next())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			return -1;
		}
		finally{
			close();
		}

	}

	/**
	 * @param args
	 */
	public int checkDesignation(String userId) throws Exception
	{
		/*****************Declaring the refernce variable of Connection interface and initializing it to NULL********************/
		int iFlag1=0;
		String designation=null;
		char desig;
		/***********************************Try Catch Block for the for handling the exceptions**********************************/
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");

			PreparedStatement preparedStatement1=connect.prepareStatement(" select * from customer where user_id=?");

			preparedStatement1.setString(1,userId );
			ResultSet resultSet1=preparedStatement1.executeQuery();
			if(resultSet1.next()){
				iFlag1=1;
				return iFlag1;
			}

			PreparedStatement preparedStatement2=connect.prepareStatement(" select * from employee where user_id=??");

			preparedStatement2.setString(1,userId );
			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next()){
				designation=resultSet2.getString("Designation");
				desig=designation.charAt(0);
				if(desig=='M')
				{
					iFlag1=2;
				}
				else if(desig=='C')
				{
					iFlag1=3;
				}
				else if(desig=='D')
				{
					iFlag1=4;
				}


			}
			return iFlag1;


		}
		catch(Exception e){
			return iFlag1;
		}
		finally{
			close();
		}
	}

	public int getCustId(String userID) throws Exception
	{
		int custId=0;

		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");

			PreparedStatement preparedStatement=connect.prepareStatement(" select customerId from Sterling_Customer where UserId=?");

			preparedStatement.setString(1,userID );
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				custId=resultSet.getInt(1);
				return custId;
			}
			return custId;
		}
		catch(Exception e){
			return custId;
		}
		finally{
			close();
		}
	}
	
	private static void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	
}
/*******************************************************/
