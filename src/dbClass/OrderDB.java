package dbClass;

import exceptionClass.InvalidCityException;
import exceptionClass.InvalidCustomerException;
import exceptionClass.InvalidOrderException;
import exceptionClass.InvalidEmployeeException;
import exceptionClass.OrderNotAssignedException;
//import java.io.IOException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.List;
//import java.util.ArrayList;

//import java.sql.SQLException;

import beanClass.Order;

public class OrderDB {

	
	/**
	 * @param args
	 */
	Connection connection=null;
	Statement statement=null;
	public static void main(String[] args) {}
	public int saveOrder(Order order) throws InvalidCustomerException,InvalidCityException, SQLException, ClassNotFoundException
	{
		//int CustomerId=beanClasses.Customer.getCustomerId();
		int CustomerId=order.getCustomerId();
		char recipientCity=order.getRecipientCity();
		float courierweight=order.getCourierWeight();
		System.out.println("hello" + order.getOrderDate() );
		Calendar orderdate=null;
		orderdate=order.getOrderDate();
		long datereg=orderdate.getTimeInMillis();
		//System.out.println(datereg);
		
		Date dateoforder=new Date(datereg);
		String recipientname=order.getRecipientName();
		String recipientAddress=order.getRecipientAddress();
		String description=order.getDescription();
		int orderid = 0;
		  			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");
		statement =connection.createStatement();
		ResultSet resultSet =statement.executeQuery("select count(*) from Sterling_Order where customerid="+CustomerId +"");
		resultSet.next();
		int count=resultSet.getInt(1);
		if(count==0)
		{
			throw new InvalidCustomerException();
		}
		//statement=connection.createStatement();GET_EMPLOYEE
		//ResultSet resultSet1=statement.executeQuery(select count(*) from )
		CallableStatement callablestatement=connection.prepareCall("{call get_employee(?,?,?)}");
		callablestatement.setString(1,Character.toString(recipientCity)); 	
		callablestatement.registerOutParameter(2,Types.NUMERIC);
		//OUT parameter is registered
		callablestatement.registerOutParameter(3,Types.NUMERIC);
		callablestatement.execute();
		int empid=callablestatement.getInt(2);
		//Return value from fuction is rscity 
		int city=callablestatement.getInt(3);
	  	
		if((city==1)||(city==2))
		{  
			throw new InvalidCityException();
		}
      		
		else
		{
			if((courierweight >5.0 || courierweight <=0.0))
				
			{
			  System.out.println("Courier Weight should be between 0.0 to 5.0");
			}
			else
			{
				//create sequence OrderID start with 7013 increment by 1;     
		        Statement statement1=connection.createStatement();
		        // Getting OrderID from sequence
			ResultSet resultSet1=statement1.executeQuery("select OrderID.nextval  from dual ");
			resultSet1.next();
				
			//storing orderid into another variable
			orderid=resultSet1.getInt(1);
			PreparedStatement preparedstatement1=connection.prepareStatement("insert into Sterling_Order values(?,?,?,?,?,?,?,?,'A',?)");
			preparedstatement1.setInt(1,orderid);
			preparedstatement1.setInt(2,CustomerId);
			preparedstatement1.setInt(3,empid);
			//ps.setInt(3,retcity);
			preparedstatement1.setDate(4,dateoforder);
			preparedstatement1.setString(5,recipientname);
			preparedstatement1.setString(6,recipientAddress);
			preparedstatement1.setString(7,Character.toString(recipientCity));
			preparedstatement1.setFloat(8,courierweight);
			
			preparedstatement1.setString(9,description);
			preparedstatement1.executeQuery();
			//Connection is closed 
			
			
			}
		connection.commit();
		}
			connection.close();
				
	return orderid;	
	}
	
	public char retrieveOrderStatus(int orderId) throws ClassNotFoundException, SQLException,InvalidOrderException
	
	{
		String status;
		char courierstatus;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");
		CallableStatement callablestatement=connection.prepareCall("{call sp_check_status(?,?)}");
		callablestatement.setInt(1,orderId);
		//OUT parameter is registered
		callablestatement.registerOutParameter(2,Types.CHAR);
		callablestatement.execute();
		status=callablestatement.getString(2);
		 courierstatus=status.charAt(0);
		 
		 //checking courierstatus
		  if(courierstatus=='N')
		  {
			  throw new InvalidOrderException(); 
		  }
		  
		  //closing connection
		 connection.close();
	    		return courierstatus;
}
	
	public List<Integer> retrieveOrderNotClosed(int employeeId)throws ClassNotFoundException, SQLException,InvalidEmployeeException,OrderNotAssignedException
	  {
		//List list=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");
		PreparedStatement preparedstatement=connection.prepareStatement("select employeeid from Sterling_employee where employeeid=?");
		 preparedstatement.setInt(1,employeeId);
		 ResultSet result= preparedstatement.executeQuery();
		 if(!result.next())
		  {
			 throw new InvalidEmployeeException();
		  }
		 PreparedStatement preparedstatement1=connection.prepareStatement("select employeeid from Sterling_order where employeeid=?");
		 preparedstatement1.setInt(1,employeeId);
		 ResultSet result1= preparedstatement1.executeQuery();
		 if(!result1.next())
		  {
			 throw new OrderNotAssignedException();
		  }
		 
		 List<Integer> l = new ArrayList<Integer>();
		 PreparedStatement preparedStatement2 = connection.prepareStatement("select * from sterling_order where employeeid=? and courierstatus in('A','P')");
		 preparedStatement2.setInt(1,employeeId);
		 ResultSet resultSet= preparedStatement2.executeQuery();
		 while(resultSet.next())
		   {
			 l.add(resultSet.getInt(1));
			 		 
		   }
	      connection.close();
	      return l;
		 
	   }
	
	/**
	 * This method is used to retrive the order details of givent order Id
	 * @Param Integer OrderId
	 * @return Order
	 * @throws ClassNotFoundException,SQLException,InvalidOrderException
	 * @author Vinit Kumar
	 */
	@SuppressWarnings("deprecation")
	public Order retrieveOrder(int orderId) throws InvalidOrderException,ClassNotFoundException,SQLException{
		Order order=new Order();
		//Loading the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creating the connectiopn Object
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
		PreparedStatement ps=connection.prepareStatement("select * from sterling_order where orderId=?");
		ps.setInt(1, orderId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			//creating new order bean object
			order.setOrderId(rs.getInt(1));
			order.setCustomerId(rs.getInt(2));
			Date orddate = rs.getDate(4);
			Calendar calendarDate=Calendar.getInstance();
			calendarDate.setTime(orddate);
			//calendarDate.set(orddate.getYear(), orddate.getMonth(),orddate.getDay());
			order.setOrderDate(calendarDate);
			order.setRecipientName(rs.getString(5));
			order.setRecipientAddress(rs.getString(6));
			String temp=rs.getString(7);
			char City=temp.charAt(0);
			order.setRecipientCity(City);
			order.setCourierWeight(rs.getFloat(8));
			String temp1=rs.getString(9);
			char courierStatus=temp1.charAt(0);
			order.setCourierStatus(courierStatus);
			order.setDescription(rs.getString(10));
			//closing the connection and returning the object
			connection.close();
			return order;
			
		}
		else
		{
			throw new InvalidOrderException();
		}
		
	}
	
/**
 * This Method is used generate the OrderId for Dynamic drop down in modify Order. 
 * @Param Integer parameter
 * @return Object of  Order 
 * @author Vinit Kumar
 * @throws ClassNotFoundException 
 * @throws SQLException 
 */
public ResultSet getOrderId() throws ClassNotFoundException, SQLException
{
	//Loading the Driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Creating the connectiopn Object
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
	String query="select orderId from Sterling_order where employeeId is null and courierStatus!='C'";
	Statement stmt=connection.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	return rs;

}
	
/**
 * This Method is used to modify Order. 
 * @Param  Object of type order bean class
 * @return Integer parameter
 * @author Vinit Kumar
 * @throws SQLException 
	 * @throws SQLException 
 */
public int updateOrder(Order order) throws ClassNotFoundException, SQLException
{
	int updateOrderId=order.getOrderId();
	String recName=order.getRecipientName();
	String recAddress=order.getRecipientAddress();
	String description=order.getDescription();
	char city=order.getRecipientCity();
	String strCity=Character.toString(city);
	float cWeight=order.getCourierWeight();
	int cstId=order.getCustomerId();
	//Loading the Driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Creating the connection Object
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
	PreparedStatement stmt=connection.prepareStatement("update sterling_order set recipientName=?,recipientAddress=?,description=?,courierweight=?,recipientcity=? where orderId=?");
	stmt.setString(1, recName);
	stmt.setString(2,recAddress);
	stmt.setString(3,description);
	stmt.setFloat(4, cWeight);
	stmt.setString(5,strCity);
	stmt.setInt(6, updateOrderId);
	int retStat=stmt.executeUpdate();
	return retStat;
	
}

/**
 * This Method is used to Cancel Order. 
 * @Param  Integer parameter
 * @return Integer parameter
 * @author Vinit Kumar 
 * @throws ClassNotFoundException 
 * @throws SQLException 
 
 */
public int cancelOrder(int orderId) throws ClassNotFoundException, SQLException 
{
	//Loading the Driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Creating the connection Object
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
	PreparedStatement stmt=connection.prepareStatement("update sterling_order set courierStatus='C' where orderId=?");
	stmt.setInt(1,orderId);
	int retStatus=stmt.executeUpdate();
	return retStatus;
}
public List retrieveOrdersNotClosed(int empid) throws  OrderNotAssignedException,Exception
{
	try{
		List<Integer> list=null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
    
    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");
        
    PreparedStatement preparedStatementE = connection.prepareStatement("select employeeid from sterling_Employee where Employeeid= ?");
    preparedStatementE.setInt(1,empid);

    ResultSet resultSetE = preparedStatementE.executeQuery();
    if(resultSetE.next()==false)
    {
   	 throw new InvalidOrderException();
    }
    
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT orderid FROM Sterling_order where CourierStatus IN ('P','R') and EmployeeId=?");
    preparedStatement.setInt(1,empid);

    ResultSet resultSet = preparedStatement.executeQuery();
    
    if(resultSet.next()==false)
    {
   	 throw new OrderNotAssignedException();
    }
    else
    {
	
	list = new ArrayList<Integer>();
	 
	 int Check=0;
	 while( resultSet.next())
	 {
		 Check=1;
		 list.add(resultSet.getInt(1)); 
		 
	 }
	 if(Check==0)
	 {
		 throw new InvalidOrderException(); 	 
	 }
    }
	 return list;	 
}
	finally{
		connection.close();
	}
}

}
	
	


