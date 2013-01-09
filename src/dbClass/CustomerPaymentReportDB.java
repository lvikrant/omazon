package dbClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerPaymentReportDB 

{
	public int customerPaymentReport(String userid) throws SQLException
	{
	
		
		Connection connection=null;
		int custid=0;
		try
		   {
		   	
		   	String userID=userid;
		   	Class.forName("oracle.jdbc.driver.OracleDriver");
		     connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360");
		      PreparedStatement preparedStatement= connection.prepareStatement("select customerid from sterling_customer where userid=?");
		      preparedStatement.setString(1,userID);
		     ResultSet resultSet = preparedStatement.executeQuery();
		       resultSet.next();
		   custid=resultSet.getInt(1);
		       
		   }
		       
		   catch(Exception e)
		   {
		    System.out.println(e);
		   }
		   finally{
		   	if(null!=connection)
		   	{
		   		connection.close();
		   	}
		    }
		   return custid;

	}

}
