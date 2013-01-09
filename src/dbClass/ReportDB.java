/*package dbClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

import exceptionClass.InvalidEmployeeException;
import exceptionClass.NoRecordsAvailableException;

public class ReportDB {

	*//**
	 * This method is used to retrieves the order details
	 * @param integer orderID
	 * @return object
	 * @throws InvalidOrderException,SQLException,ClassNotFoundException 
	 *//*

	public List retrieveOrderIds(int custid)throws ClassNotFoundException,Exception
	{
//		creating reference for LIST class'

		List list1=null;
		int Orderid=0;

		//loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//making connection with database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360 ");
		PreparedStatement preparedstatement = connection.prepareStatement
		("select orderid from sterling_order where customerid=?");
		
		preparedstatement.setInt(1,custid);
	    ResultSet resultSet = preparedstatement.executeQuery();
		
		List<Integer> list = new ArrayList<Integer>();
		//getting orderid whose status is not 'C'	
		while(resultSet.next())
		{
			list.add(resultSet.getInt(1));//addding to arraylist
		}
		connection.close();//closing connection
		list1= list;
		//return object of List class	  
		return list1;
	}
	
	
	*//**
	 * This method is used to retrieves the order details
	 * @param integer orderID
	 * @return object
	 * @throws InvalidOrderException,SQLException,ClassNotFoundException 
	 *//*

	public List retrieveOrderId()throws ClassNotFoundException,Exception
	{
//		creating reference for LIST class'

		List list1=null;
		int Orderid=0;

		//loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//making connection with database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360 ");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select orderid from sterling_order");

		List<Integer> list = new ArrayList<Integer>();
		//getting orderid whose status is not 'C'	
		while(resultSet.next())
		{
			list.add(resultSet.getInt(1));//addding to arraylist
		}
		connection.close();//closing connection
		list1= list;
		//return object of List class	  
		return list1;
	}
	
	
	public List getOrderStatusReport(String Status,String start,String end)throws NoRecordsAvailableException, Exception
	{
		
		GregorianCalendar cal=new GregorianCalendar();
		List list = new ArrayList();
		
		//Declaring local variables
		int orderID=0, employeeID=0;
		String recipientName=null,recipientAddress=null,recipientCity=null;
		String courierWeight=null,courierStatus=null,description=null;
		Date orderDate=null;


		//Loads the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Establishing connection to the database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");


			PreparedStatement prepareStatement = connection.prepareStatement("Select orderID,employeeID,orderDate,recipientName,recipientAddress,recipientCity,courierWeight,courierStatus,description from Sterling_order where courierStatus=? and orderDate>=? and orderDate<=?");

			//Setting customer ID
			prepareStatement.setString(1,Status);


			//Converting string to SQL date
			GregorianCalendar gc=new GregorianCalendar();//creating object for this class
			Date Startdate= new Date(start);
			gc.setTime(Startdate);

			java.util.Date StartDate= gc.getTime();
			long time =StartDate.getTime();
			java.sql.Date startdate= new java.sql.Date(time);

			//Setting start date
			prepareStatement.setDate(2, startdate);



			//  Converting string to SQL date
			GregorianCalendar gc1=new GregorianCalendar();//creating object for this class
			Date Enddate= new Date(end);
			gc.setTime(Enddate);

			java.util.Date EndDate= gc.getTime();
			long time1 =EndDate.getTime();
			java.sql.Date enddate= new java.sql.Date(time1);

			//	Setting end date
			prepareStatement.setDate(3, enddate);



			//Executing the SQL statement
			ResultSet result=prepareStatement.executeQuery();

			if(result.next()==false)
			{

				throw new NoRecordsAvailableException();
			}


			else
			{

				// If the customer ID is present then retrieve the values in variables.

				
				while(result.next())
				{


					orderDate=result.getDate(3);

					//Converting SQL date to string format
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
					String dateOfOrder = sdf.format(orderDate);

					//Adding elements to the list
					list.add(result.getInt(1));
					list.add(result.getInt(2));
					list.add(dateOfOrder);
					list.add(result.getString(4));
					list.add(result.getString(5));
					list.add(result.getString(6));
					list.add(result.getDouble(7));
					list.add(result.getString(8));
					list.add(result.getString(9));


				}


				//Closing the connection.
				connection.close();

				
			}

		

		
       //Returning list
		return list;
	}
	
	
	
	public List getOrderStatusReport(String Status)throws NoRecordsAvailableException, Exception
	{
		
		GregorianCalendar cal=new GregorianCalendar();
		List list = new ArrayList();
		
		//Declaring local variables
		int orderID=0, employeeID=0;
		String recipientName=null,recipientAddress=null,recipientCity=null;
		String courierWeight=null,courierStatus=null,description=null;
		Date orderDate=null;


		//Loads the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Establishing connection to the database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");


			PreparedStatement prepareStatement = connection.prepareStatement("Select orderID,employeeID,orderDate,recipientName,recipientAddress,recipientCity,courierWeight,courierStatus,description from Sterling_order where courierStatus=?");

			//Setting customer ID
			prepareStatement.setString(1,Status);

			//Executing the SQL statement
			ResultSet result=prepareStatement.executeQuery();

			if(result.next()==false)
			{

				throw new NoRecordsAvailableException();
			}


			else
			{

				// If the customer ID is present then retrieve the values in variables.

				
				while(result.next())
				{


					orderDate=result.getDate(3);

					//Converting SQL date to string format
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
					String dateOfOrder = sdf.format(orderDate);

					//Adding elements to the list
					list.add(result.getInt(1));
					list.add(result.getInt(2));
					list.add(dateOfOrder);
					list.add(result.getString(4));
					list.add(result.getString(5));
					list.add(result.getString(6));
					list.add(result.getDouble(7));
					list.add(result.getString(8));
					list.add(result.getString(9));


				}


				//Closing the connection.
				connection.close();

				
			}

		

		
       //Returning list
		return list;
	}
	
	
	public List getOrderStatusReport(String start,String end)throws NoRecordsAvailableException, Exception
	{
		
		GregorianCalendar cal=new GregorianCalendar();
		List list = new ArrayList();
		
		//Declaring local variables
		int orderID=0, employeeID=0;
		String recipientName=null,recipientAddress=null,recipientCity=null;
		String courierWeight=null,courierStatus=null,description=null;
		Date orderDate=null;


		//Loads the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Establishing connection to the database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");


			PreparedStatement prepareStatement = connection.prepareStatement("Select orderID,employeeID,orderDate,recipientName,recipientAddress,recipientCity,courierWeight,courierStatus,description from Sterling_order where orderDate>=? and orderDate<=?");

//			Converting string to SQL date
			GregorianCalendar gc=new GregorianCalendar();//creating object for this class
			Date Startdate= new Date(start);
			gc.setTime(Startdate);

			java.util.Date StartDate= gc.getTime();
			long time =StartDate.getTime();
			java.sql.Date startdate= new java.sql.Date(time);

			//Setting start date
			prepareStatement.setDate(1, startdate);



			//  Converting string to SQL date
			GregorianCalendar gc1=new GregorianCalendar();//creating object for this class
			Date Enddate= new Date(end);
			gc.setTime(Enddate);

			java.util.Date EndDate= gc.getTime();
			long time1 =EndDate.getTime();
			java.sql.Date enddate= new java.sql.Date(time1);

			//	Setting end date
			prepareStatement.setDate(2, enddate);

			//Executing the SQL statement
			ResultSet result=prepareStatement.executeQuery();
			

			if(result.next()==false)
			{

				throw new NoRecordsAvailableException();
			}


			else
			{

				// If the customer ID is present then retrieve the values in variables.

				
				while(result.next())
				{


					orderDate=result.getDate(3);

					//Converting SQL date to string format
					SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
					String dateOfOrder = sdf.format(orderDate);

					//Adding elements to the list
					list.add(result.getInt(1));
					list.add(result.getInt(2));
					list.add(dateOfOrder);
					list.add(result.getString(4));
					list.add(result.getString(5));
					list.add(result.getString(6));
					list.add(result.getDouble(7));
					list.add(result.getString(8));
					list.add(result.getString(9));


				}


				//Closing the connection.
				connection.close();

				
			}

		

		
       //Returning list
		return list;
	}
	*//************************************************************************************************************
	* Function Name		:	InvoiceStatusReport																	*	
	* Author	   		:	Poornima_Gadad																		*		
	* Date		   		:	29-07-2009																			*
	* Description	   	:	The function is to generate the report that can be used by Manager & Clerk			* 
	* 							to check the details of pending payment of a specifc customer and in specific 
	* 							duration 
	* 							 by specifying all the values 
	* 							  	a) Customer Id 
									b) Duration (From Date and To Date)
	* Input Parameters :	String spCustomerid , String spToDate , String spFromDate.							*
	* Return Type      :	CachedRowSet																		*
	*																											*
	************************************************************************************************************//*

	public CachedRowSet InvoiceStatusReport(String spCustomerid , String spFromDate ,String spToDate )throws Exception
	{
		 Declaration of variables 
		String sCustomerid = spCustomerid ;
		String sToDate = spToDate ;
		String sFromDate = spFromDate ;

		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;


		 Setting the connection variable 

		Connection connection = null;
		try
		{    Loading the Driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			 Setting the connection 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");

			 Throwing the query to DB
			

	preparedStatement = connection.prepareStatement("select * from sterling_invoice where  customerid = ? AND invoicedate between ? AND ? order by invoiceid asc");

	preparedStatement.setString(1,sCustomerid);
	preparedStatement.setString(2,sFromDate);
	preparedStatement.setString(3,sToDate);
	resultSet = preparedStatement.executeQuery();
	CachedRowSet crset = new CachedRowSetImpl();
	crset.populate(resultSet);
	 If orderID is found 
	return crset;
		}
		finally
		{
			*//**************************************Closing the connection in finally Block*******************************************//*
			connection.close();

			*//****************************************Making the connection object free for garbage Collection************************//*
			connection=null;
		}
		*//*********************************************Closing Finally Block*****************************************************//*

	}

	*//************************************************************************************************************
	* Function Name		:	retrieveCustomerId																			*	
	* Author	   		:	Poornima Gadad																		*		
	* Date		   	    :	29-07-2009																			*
	* Description	   	:	The function is to generate the list of Customeer ID.
	* Input Parameters 	:	NA.																	*
	* Return Type      	:	list																				*
	*																											*
	************************************************************************************************************//*

	public List retrieveCustomerId()throws Exception{

	Connection connection =null;
	List list;
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");

	connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");

	Statement statement = connection.createStatement();

	ResultSet resultSet = statement.executeQuery("select customerid from sterling_customer order by customerid asc ");

	 list = new ArrayList();

	while (resultSet.next())
	{

	      list.add((resultSet.getString("customerid") ) );
	}
	}
	finally 
	{
	      connection.close();
	}

	return list; 


	}

	*//************************************************************************************************************
	*				End of InvoiceStatusReport method
	*************************************************************************************************************//*
*//**
 * This method is used to retrieves the order details
 * @param integer orderID
 * @return object
 * @throws InvalidOrderException,SQLException,ClassNotFoundException 
 *//*

public List retrieveOrderId1()throws ClassNotFoundException,Exception
{
//	creating reference for LIST class'

	List list1=null;
	int Orderid=0;

	//loading driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//making connection with database
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360 ");
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select distinct orderid from sterling_delivery");

	List<Integer> list = new ArrayList<Integer>();
	//getting orderid whose status is not 'C'	
	while(resultSet.next())
	{
		list.add(resultSet.getInt(1));//addding to arraylist
	}
	connection.close();//closing connection
	list1= list;
	//return object of List class	  
	return list1;
}



*//**
 * This method is used to retrieves the order details
 * @param integer orderID
 * @return object
 * @throws InvalidOrderException,SQLException,ClassNotFoundException 
 *//*

public List retrieveOrderIds1(int custid)throws ClassNotFoundException,Exception
{
//	creating reference for LIST class'

	List list1=null;
	int Orderid=0;

	//loading driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//making connection with database
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360 ");
	PreparedStatement preparedstatement = connection.prepareStatement
	("select orderid from sterling_order where customerid=? where courierstatus not in 'C'");
	
	preparedstatement.setInt(1,custid);
    ResultSet resultSet = preparedstatement.executeQuery();
	
	List<Integer> list = new ArrayList<Integer>();
	//getting orderid whose status is not 'C'	
	while(resultSet.next())
	{
		list.add(resultSet.getInt(1));//addding to arraylist
	}
	connection.close();//closing connection
	list1= list;
	//return object of List class	  
	return list1;
}




public List getorderAssignedReport(int employeeID,String startDate,String endDate)throws NoRecordsAvailableException, Exception
{
//Order order = new Order();
GregorianCalendar cal=new GregorianCalendar();

//Declaring local variables
// int orderID=0, employeeID=0;
//String recipientName=null,recipientAddress=null,recipientCity=null;
// String courierWeight=null,courierStatus=null,description=null;
 Date orderDate=null;
  //Converting string to SQL date
	GregorianCalendar gc=new GregorianCalendar();//creating object for this class
	Date Startdate= new Date(startDate);
	gc.setTime(Startdate);
	 
	java.util.Date StartDate= gc.getTime();
	long time =StartDate.getTime();
	java.sql.Date startdate= new java.sql.Date(time);
	
    //Converting string to SQL date
	GregorianCalendar gc1=new GregorianCalendar();//creating object for this class
	Date Enddate= new Date(endDate);
	gc.setTime(Enddate);
	 
	java.util.Date EndDate= gc.getTime();
	long time1 =EndDate.getTime();
	java.sql.Date enddate= new java.sql.Date(time1);
	 
	
//Loads the driver
Class.forName("oracle.jdbc.driver.OracleDriver");
   
//Establishing connection to the database
Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
   
PreparedStatement prepareStatement = connection.prepareStatement("Select count(orderid) from Sterling_Order where EmployeeId=? and orderDate>=? and orderDate<=?");

//Setting employee ID
prepareStatement.setInt(1,employeeID);
//Setting start date
prepareStatement.setDate(2, startdate);
 //	Setting end date
prepareStatement.setDate(3, enddate);
//Executing the SQL statement
ResultSet resultset=prepareStatement.executeQuery();
resultset.next();
if(resultset.getInt(1)==0)
  {
	  throw new NoRecordsAvailableException();
  }
  else
  { 
   //			 If the orderid is present then retrieve the values in variables.
   PreparedStatement prepareStatement1 = connection.prepareStatement("Select orderID from Sterling_order where EmployeeId=? and orderDate>=? and orderDate<=?");

//Setting employee ID
prepareStatement1.setInt(1,employeeID);
//Setting start date
prepareStatement1.setDate(2, startdate);
 //	Setting end date
prepareStatement1.setDate(3, enddate);
//Executing the SQL statement
ResultSet resultset1=prepareStatement1.executeQuery();	
		  
        // If the orderid is present then retrieve the values in variables.
		
		List list = new ArrayList();
		
	
		while(resultset1.next())
	     {
           		          			      
	      //Adding elements to the list
		  list.add(resultset1.getInt(1));
		  
		
	      
	     }
//		Closing the connection.
	    connection.close();
//		Returning list
		return list;
  }
		
       
	
	
	 
   }
*//**
* This method is used retrieve list of open order ID's
* @param integer
* @return object 
* @throws InvalidEmployeeException,OrderNotAssignedException,ClassNotFoundException,SQLException
*//*	
  
public List retrieveEmployeeId()throws InvalidEmployeeException,ClassNotFoundException,SQLException
{
	//creating reference for LIST class
    List list1=null;
    List<Integer> list = new ArrayList<Integer>();
    //loading driver
    
	   Creating Connection with database 
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
	  PreparedStatement prepareStatement=connection.prepareStatement("Select count(employeeid) from Sterling_Employee where designation='D'");
	  ResultSet resultSet=prepareStatement.executeQuery(); 
	  resultSet.next();
	  if(resultSet.getInt(1)==0)
	  {
		  throw new InvalidEmployeeException();
	  }
	  else
	  {
	  PreparedStatement prepareStatement1=connection.prepareStatement("Select employeeid from Sterling_Employee where designation='D'");
	  ResultSet resultSet1=prepareStatement1.executeQuery();
	 		  
	  while(resultSet1.next())
	     {
		  list.add(resultSet1.getInt(1));//addding to arraylist
	     }
	  }
	   connection.close();//closing connection
	   list1= list;
			
		 //return object of List class	  
	   return list1;
	   Closing the database connection  
	   
}

public List generatecustomerId() throws SQLException
{
	Connection connection=null;
	try{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
		Statement Stat= connection.createStatement();
		ResultSet rs=Stat.executeQuery("select distinct customerid from sterling_Order");
		List<Integer>customerIdList=new ArrayList<Integer>(); 
		while(rs.next())
		{
			customerIdList.add(rs.getInt(1));

		}
		return customerIdList;

	}

	catch(Exception e)
	{
		System.out.println("Error :"+e);
	}


	return null;

}

public List getCustomerReport(int customerID,String start,String end)throws NoRecordsAvailableException, Exception
{
	//Order order = new Order();
	GregorianCalendar cal=new GregorianCalendar();

	//Declaring local variables
	int orderID=0, employeeID=0;
	String recipientName=null,recipientAddress=null,recipientCity=null;
	String courierWeight=null,courierStatus=null,description=null;
	Date orderDate=null;


	//Loads the driver
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//Establishing connection to the database
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");

	PreparedStatement prepareStatement = connection.prepareStatement("Select orderID,employeeID,orderDate,recipientName,recipientAddress,recipientCity,courierWeight,courierStatus,description from Sterling_order where CustomerId=? and orderDate>=? and orderDate<=?");

	//Setting customer ID
	prepareStatement.setInt(1,customerID);


	//Converting string to SQL date
	GregorianCalendar gc=new GregorianCalendar();//creating object for this class
	Date Startdate= new Date(start);
	gc.setTime(Startdate);

	java.util.Date StartDate= gc.getTime();
	long time =StartDate.getTime();
	java.sql.Date startdate= new java.sql.Date(time);

	//Setting start date
	prepareStatement.setDate(2, startdate);



	//  Converting string to SQL date
	GregorianCalendar gc1=new GregorianCalendar();//creating object for this class
	Date Enddate= new Date(end);
	gc.setTime(Enddate);

	java.util.Date EndDate= gc.getTime();
	long time1 =EndDate.getTime();
	java.sql.Date enddate= new java.sql.Date(time1);

	//	Setting end date
	prepareStatement.setDate(3, enddate);

	

	//Executing the SQL statement
	ResultSet result=prepareStatement.executeQuery();
	
	if(result.next()==false)
	{

		throw new NoRecordsAvailableException();
	}


	else
	{

		// If the customer ID is present then retrieve the values in variables.

		List list = new ArrayList();


		while(result.next())
		{


			orderDate=result.getDate(3);

			//Converting SQL date to string format
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
			String dateOfOrder = sdf.format(orderDate);

			//Adding elements to the list
			list.add(result.getInt(1));
			list.add(result.getInt(2));
			list.add(dateOfOrder);
			list.add(result.getString(4));
			list.add(result.getString(5));
			list.add(result.getString(6));
			list.add(result.getDouble(7));
			list.add(result.getString(8));
			list.add(result.getString(9));


		}


		//Closing the connection.
		connection.close();

		//Returning list
		return list;
	}

}
public ResultSet customerPendingPaymentReport(int customerId) throws Exception
{
	Connection connection=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
		
		Statement statement = connection.createStatement();
		CachedRowSet customerPendingPaymentReportCrset = new CachedRowSetImpl();
		String query = "select * from sterling_invoice where invoiceid NOT IN (select invoiceid from sterling_payment ) AND CustomerID="+customerId;
		
		ResultSet resultSet = statement.executeQuery(query);
		customerPendingPaymentReportCrset.populate(resultSet);
		
		return customerPendingPaymentReportCrset;
		
		
		
	}
	finally
	{
			connection.close();
		
			connection=null;
	}
		
}

public CachedRowSet PaymentStatusReport(String Customerid , String FromDate, String ToDate )throws Exception
{
	 Declaration of variables 
	String custId = Customerid ;
	String toDate = ToDate ;
	String fromDate = FromDate ;

	
	PreparedStatement preparedStatement;
	ResultSet resultSet = null;
	 Setting the connection variable 

	Connection connection = null;
	try
	{    Loading the Driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");

		 Setting the connection 
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");

		 Throwing the query to DB
preparedStatement = connection.prepareStatement("select * from sterling_payment where Invoiceid IN (select invoiceid from sterling_invoice where customerid = ? AND invoicedate between ? AND ? ) order by invoiceid asc");
preparedStatement.setString(1,custId);
preparedStatement.setString(2,fromDate);
preparedStatement.setString(3,toDate);
resultSet = preparedStatement.executeQuery();



CachedRowSet crset = new CachedRowSetImpl();

crset.populate(resultSet);

 If orderID is found 
return crset;


	}
	finally
	{
		connection.close();

		connection=null;
	}
	
}


public CachedRowSet PendingPaymentStatusReport(String Customerid , String FromDate , String ToDate )throws Exception
{
	 Declaration of variables 
	String custId = Customerid ;
	String toDate = ToDate ;
	String fromDate = FromDate ;

	
	PreparedStatement preparedStatement;
	ResultSet resultSet = null;


	 Setting the connection variable 

	Connection connection = null;
	try
	{    Loading the Driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");

		 Setting the connection 
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");

		 Throwing the query to DB




preparedStatement = connection.prepareStatement("select * from sterling_invoice where Invoiceid NOT IN (select invoiceid from sterling_payment ) AND  customerid = ? AND invoicedate between ? AND ? order by invoiceid asc");

preparedStatement.setString(1,custId);
preparedStatement.setString(2,fromDate );
preparedStatement.setString(3,toDate);
resultSet = preparedStatement.executeQuery();



CachedRowSet crset = new CachedRowSetImpl();

crset.populate(resultSet);

 If orderID is found 
return crset;


	}
	finally
	{
		connection.close();

		connection=null;
	}
}
End of file ReportDB




}
*/