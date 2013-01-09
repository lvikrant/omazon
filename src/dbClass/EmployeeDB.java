/*package dbClass;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.sql.rowset.CachedRowSet;

import beanClass.Employee;

//import com.sun.rowset.CachedRowSetImpl;

public class EmployeeDB {
	
	Connection connection = null;

	*//**
	* This method saves the Employee details of the Sterling_Courier
	* in the database and returns the result back to the DAO class.
	* @author Vinit Kumar
	* @param employee The object of class Employee bean.
	* @return int EmployeeId from the sequence sq_Employee
	* @throws Exception,SQLException,ClassNotFoundException,InvalidOrderException
	*//*
	public int addEmployee(Employee employee)throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@" + "10.122.130.40:1521:Georli01","t126360", "t126360");
		 validate customer id
		Statement stm=connection.createStatement();
		ResultSet rs=stm.executeQuery("select sq_Employee.nextval from dual");
		rs.next();
		int empid=rs.getInt(1);
		String name=employee.getEmployeeName();
		String userId=name.substring(0,4);
		String userid=userId+empid;
		System.out.print(userid);
		employee.setUserId(userid);
		String paswrd=userId+1234;
		
		PreparedStatement preparedstatement1 = connection.
		prepareStatement("insert into sterling_login values(?,?)");
		preparedstatement1.setString(1,userid);
		preparedstatement1.setString(2,paswrd);
		preparedstatement1.executeUpdate();
		
		PreparedStatement preparedstatement = connection.prepareStatement("insert into sterling_employee values(?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setInt(1,empid);
		preparedstatement.setString(2,employee.getUserId());
		preparedstatement.setString(3, employee.getEmployeeName());
		Calendar calendar=employee.getDateOfBirth();
		Date date=new Date(calendar.getTimeInMillis());
		preparedstatement.setDate(4,date);
		preparedstatement.setString(5,Character.toString(employee.getDesignation()));
		preparedstatement.setString(6, employee.getAddress());
		preparedstatement.setString(7, employee.getPin());
		preparedstatement.setString(8,employee.getTelephoneNo());
		preparedstatement.setString(9,employee.getEmail());
		preparedstatement.setString(10,Character.toString(employee.getRegion()));
		int rowCount = preparedstatement.executeUpdate();
		if(rowCount==1)
		{
		return rs.getInt(1);
		}
		else
		{
		throw new Exception("Insertion Failed");	
		}
		}
	public ResultSet getUserId(String userType)throws Exception{
		
		CachedRowSet cachedRowSet= new CachedRowSetImpl();
		
		
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360");
			if((userType.equalsIgnoreCase("C"))||(userType.equalsIgnoreCase("D")))
			{
						
			PreparedStatement preparedStatement=connection.prepareStatement("select employeeId,employeeName,userId from Sterling_employee where designation=?");
			
			preparedStatement.setString(1,userType);
			ResultSet resultset=preparedStatement.executeQuery();
			
			cachedRowSet.populate(resultset);
			return cachedRowSet;
			}
			else if(userType.equalsIgnoreCase("Customer"))
			{
				PreparedStatement preparedStatement=connection.prepareStatement("select customerId,customerName,userId from Sterling_customer");
				
				ResultSet resultset=preparedStatement.executeQuery();
				
				cachedRowSet.populate(resultset);
				return cachedRowSet;
			}
			
			return cachedRowSet;
	}
		catch(Exception e)
		{
			return cachedRowSet;
		}
		finally{
			connection.close();
		}
}
	
	public String resetPassword(String name,String userId) throws SQLException
	{
		
		String newPsw=null;
		try{
			
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360");
	
		PreparedStatement preparedStatement=connection.prepareStatement("update Sterling_login set Password=? where userId=?");
		
		String name1=name.toLowerCase();
		name1=name1.substring(0, 4);
		PreparedStatement preparedStatement1=connection.prepareStatement("select employeeId from Sterling_employee where userId=?");
		preparedStatement1.setString(1,userId);
		ResultSet resultset1=preparedStatement1.executeQuery();
		if( resultset1.isBeforeFirst()==false){
			PreparedStatement preparedStatement2=connection.prepareStatement("select CustomerId from Sterling_customer where userId=?");
			preparedStatement2.setString(1,userId);
			 resultset1=preparedStatement2.executeQuery();
			}
		resultset1.next();
		int temp=resultset1.getInt(1);
		newPsw=name1+temp;
		
		preparedStatement.setString(1, newPsw);
		preparedStatement.setString(2, userId);
		int result=0;
		result=preparedStatement.executeUpdate();
		if(result==1){
			return newPsw;
		}
		else if(result==0){
			System.out.println("Error !! ");
			return newPsw;
		}
		return newPsw;
		}
		catch(Exception e){
			return newPsw;
		}
                finally{
			connection.close();
		}
	}
	
	public int getEmpid(String userId) throws SQLException, ClassNotFoundException
	{
		int retEmpID=0;
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@10.122.130.40:1521:georli01",
							"t126360", "t126360");
			PreparedStatement preparedStatementEmp = connection.prepareStatement
						("SELECT employeeid FROM sterling_employee WHERE userid=?");
			preparedStatementEmp.setString(1, userId);
			ResultSet resultSetEmp = preparedStatementEmp.executeQuery();
			while(resultSetEmp.next())
			{
				retEmpID=resultSetEmp.getInt(1);
				return retEmpID;
			}
			
		}
		
		finally
		{
			connection.close();
		}
		return retEmpID;
		
	}
}



*/