package beanClass;
import java.sql.*;

public class OmazonUserLogin {
	private String userName;
	private String password;
	private int role;
	
	public String getPassword(String user){
		
		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
        {           
			Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection ("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");
            statement = connect.createStatement();
            //System.out.println(user);
            preparedStatement = connect.prepareStatement ("select password from login where user_id = ?");
            preparedStatement.setString (1, user);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {            	
            	password = resultSet.getString(1);
            }
            resultSet.close();
        }
		catch (Exception e)
        {
			System.out.println("111"+e);
        }
		return password;
	}
	
	public int checkRole(String user){
		
		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try
        {
			Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection ("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");
            statement = connect.createStatement();
            //System.out.println(user);
            preparedStatement = connect.prepareStatement ("select role from login where user_id = ?");
            preparedStatement.setString (1, user);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {            	
            	role = resultSet.getInt(1);
            }
            resultSet.close();
        }
		catch(Exception e)
		{
			System.out.println("222"+e);
		}
		return role;
	}
/*public static void main(String []args)
{
	try
	{
	 OmazonUserLogin log = new OmazonUserLogin();
	 String pwd  = log.getPassword("asdas");
	 System.out.println(pwd);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}*/
}