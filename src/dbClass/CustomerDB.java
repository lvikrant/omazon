/**
 * This class is bean class used for customer tester.
 * Date: 24-Jul-2009
 * @author:Soumya P C
 * @version 1.0
 */

package dbClass;

import exceptionClass.InsertionFailed;
import exceptionClass.InvalidCustName;
import exceptionClass.InvalidCustomer;
import exceptionClass.OtherExceptions;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Statement;
import beanClass.Customer;

 //This method is used to insert the customer details into the table 

public class CustomerDB 
{
	private  Connection connect = null;
	private  Statement statement = null;
	private  PreparedStatement preparedStatement = null;
	private  ResultSet resultSet = null;

	public int saveCustomer(Customer customer) throws SQLException,
	ClassNotFoundException, InvalidCustName, InsertionFailed,
	OtherExceptions {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://localhost/test_log?"+"user=root&password=qwerty");

		 //This is used to call the stored procedure 
		CallableStatement callableStatement = connect.prepareCall("{call Add_Customer(?,?,?,?,?,?,?,?)}");

		 //Used to set the input parameters 
		callableStatement.setString(1, customer.getCustomerName());
//
	//	 Used to convert the date to string 
		Calendar dateOfRegistration = customer.getDateofRegistration();
		String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		String date = dateOfRegistration.get(Calendar.DATE) + "-"
				+ month[dateOfRegistration.get(Calendar.MONTH)] + "-"
				+ dateOfRegistration.get(Calendar.YEAR);

		callableStatement.setString(2, date);
		callableStatement.setString(3, customer.getAddress());
		callableStatement.setString(4, customer.getCity());
		callableStatement.setString(5, customer.getPin());
		callableStatement.setString(6, customer.getTelephoneNo());
		callableStatement.setString(7, customer.getEmailId());

		// Registering of the out parameters 
		callableStatement.registerOutParameter(8, Types.INTEGER);
		callableStatement.execute();
		callableStatement.close();

		// The return value is checked and the appropriate exceptions are thrown 
		int ret = callableStatement.getInt(8);

		if (ret == 1) {
			throw new InvalidCustName();
		} else if (ret == 2) {
			throw new InsertionFailed();
		} else if (ret == 0) {
			throw new OtherExceptions();
		} else {
			
			return ret;
		}
	}

	// This function is used to retrieve the customer details 

	public Customer retrieveCustomer(int customerId) throws InvalidCustomer,
	SQLException, ClassNotFoundException {

		Customer customer = new Customer();
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// The connection is established using the connection statement 

		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.122.130.40:1521:Georli01", "t126360",
				"t126360");

		
		 
		 
		PreparedStatement preparedStatement = connection
				.prepareStatement("Select CustomerID,UserID,CustomerName, DateOfRegistration,Address, City,Pin,TelephoneNo, Email from Sterling_Customer where CustomerID=?");
		
		 
		preparedStatement.setInt(1, customerId);
		ResultSet resultset = preparedStatement.executeQuery();

		if (resultset.next() == false) {
			throw new InvalidCustomer();
		}

		else {
			// Used to set the values retrieved using the result set 
			customer.setCustomerId(resultset.getInt(1));
			customer.setUserId(resultset.getString(2));
			customer.setCustomerName(resultset.getString(3));
			Calendar cal = Calendar.getInstance();
			cal.setTime(resultset.getDate(4));
			customer.setDateofRegistration(cal);
			customer.setAddress(resultset.getString(5));
			customer.setCity(resultset.getString(6));
			customer.setPin(resultset.getString(7));
			customer.setTelephoneNo(resultset.getString(8));
			customer.setEmail(resultset.getString(9));

		}
		// The transactions are committed 
		connection.commit();
		// The connection is closed 
		connection.close();
		// The values are returned to the calling function 
		return customer;
	}

	// This function is used to edit the customer details for a particular customer id 
	public int editCustomer(Customer customer) throws SQLException,
	ClassNotFoundException, Exception

	{

		int customerId = 0;
		Connection connection = null;

		customerId = customer.getCustomerId();

		
		String customerName = customer.getCustomerName();

		// To get Recipient Address 
		String customerAddress = customer.getAddress();

		// To get Recipient City 
		String customerCity = customer.getCity();

		// To get the Pin 
		String customerPin = customer.getPin();

		// To get Telephone number 
		String customerTelephone = customer.getTelephoneNo();

		// To get email ID 
		String customerEmail = customer.getEmailId();

		try {

			// Load The driver and establish the connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.122.130.40:1521:Georli01", "t126360",
					"t126360 ");

			// Update the customer table with new values 

			PreparedStatement preparedStatement = connection
					.prepareStatement("Update Sterling_Customer set customername=?,address=?,city=?,pin=?,telephoneno=?,email=? where customerid=? ");
			preparedStatement.setString(1, customerName);
			preparedStatement.setString(2, customerAddress);
			preparedStatement.setString(3, customerCity);
			preparedStatement.setString(4, customerPin);
			preparedStatement.setString(5, customerTelephone);
			preparedStatement.setString(6, customerEmail);
			preparedStatement.setInt(7, customerId);
			preparedStatement.executeQuery();
		}

		catch (SQLException e) {
			System.out.println("Error :" + e);
		} catch (ClassNotFoundException e1) {
			System.out.println("Error :" + e1);
		} catch (Exception e2) {
			System.out.println("Error :" + e2);
		}
		return customerId;

	}

	 //This method is used to retrieve the list of customer ID's 

	public List<Integer> generatecustomerId() throws SQLException {
		Connection connection = null;
		try {
			// Load the driver and establish the connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.122.130.40:1521:georli01", "t126360",
					"t126360");
			Statement statement = connection.createStatement();
			// Select the customer id from the table 
			ResultSet resultSet = statement
					.executeQuery("select customerid from sterling_customer where defaulter='N'");
			List<Integer> customerIdList = new ArrayList<Integer>();
			while (resultSet.next()) {
				// Add the retrieved ID's to the list 
				customerIdList.add(resultSet.getInt(1));

			}
			// Return the customerId list to the calling method 
			return customerIdList;

		}

		catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return null;
	}
	public List<Integer> deleteIdList() throws SQLException {
		Connection connection = null;
		try {
			// Load the driver and establish the connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.122.130.40:1521:georli01", "t126360",
					"t126360");
			Statement statement = connection.createStatement();
			// Select the customer id from the table 
			ResultSet resultSet = statement
					.executeQuery("select customerid from sterling_customer where defaulter='N'");
			List<Integer> customerIdList = new ArrayList<Integer>();
			while (resultSet.next()) {
				// Add the retrieved ID's to the list 
				customerIdList.add(resultSet.getInt(1));

			}
			// Return the customerId list to the calling method 
			return customerIdList;

		}

		catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return null;
	}

	public int deleteCustomer(Customer customer)throws SQLException,
	ClassNotFoundException, Exception
	{
		int iCustId=0;
		Connection connection=null;
		iCustId=customer.getCustomerId();
		try {

			// Load The driver and establish the connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.122.130.40:1521:Georli01", "t126360",
					"t126360 ");

			// Update the customer table with new values 

			PreparedStatement preparedStatement = connection
					.prepareStatement("Update Sterling_Customer set defaulter='Y' where customerid=? ");
			preparedStatement.setInt(1,iCustId);
			preparedStatement.executeQuery();
		}
		catch (SQLException e) {
			System.out.println("Error :" + e);
		} catch (ClassNotFoundException e1) {
			System.out.println("Error :" + e1);
		} catch (Exception e2) {
			System.out.println("Error :" + e2);
		}
		return iCustId;
	}



}
