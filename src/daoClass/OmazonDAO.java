package daoClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

//import com.sun.rowset.CachedRowSetImpl;

import beanClass.Customer;
import beanClass.Delivery;
import beanClass.Employee;
import beanClass.Invoice;
import beanClass.Order;
import dbClass.CustomerPaymentReportDB;
import dbClass.CustomerDB;
//import com.omazon.db.DeliveryDB;
//import dbClass.EmployeeDB;
//import com.omazon.db.InvoiceDB;
import dbClass.LoginDB;
import dbClass.OrderDB;
import dbClass.PaymentDB;
//import dbClass.ReportDB;
import dbClass.distributionDB;
import exceptionClass.InvalidEmployeeException;
import exceptionClass.OrderNotAssignedException;
import exceptionClass.invalidMonthYearException;
import exceptionClass.InsertionFailed;
import exceptionClass.InvalidCityException;
import exceptionClass.InvalidCustName;
import exceptionClass.InvalidCustomer;
import exceptionClass.InvalidCustomerException;
import exceptionClass.InvalidCustomerIDException;
import exceptionClass.InvalidDataException;
import exceptionClass.InvalidOrderException;
import exceptionClass.InvalidOrderIDException;
import exceptionClass.NoRecordsAvailableException;
import exceptionClass.OtherExceptions;
import exceptionClass.invoiceGenAlreadyException;
import exceptionClass.noOrderException;

public class OmazonDAO
{
	// This method is used to save the customer details 
	public int saveCustomer(Customer customer) throws SQLException,ClassNotFoundException,InvalidCustName,InsertionFailed,OtherExceptions
	{	CustomerDB cdb=new CustomerDB();
		int ret=cdb.saveCustomer(customer);
		System.out.println("\n\t\t\tData Saved Successfully");
		return ret;
	}
	
	// This method is used to retrieve the saved customer details 
	public Customer retrieveCustomer(int custid) throws InvalidCustomer,SQLException,ClassNotFoundException
	{
		Customer customer=new Customer();
		CustomerDB customerdb=new CustomerDB();
		customer=customerdb.retrieveCustomer(custid);
		return customer;
	}
	public int saveOrder(Order order) throws InvalidCustomerException, InvalidCityException, SQLException, ClassNotFoundException
	{
		OrderDB orderdb=new OrderDB();
		int iRet=orderdb.saveOrder(order);
		System.out.println("\n\t\t\tData Saved Successfully");
		return iRet;
	}
	/**
	* This method is used to retrieves the order details
	* @param integer orderID
	* @return object
	* @throws InvalidOrderException,SQLException,ClassNotFoundException 
	*/
	public Order retrieveOrder(int orderid)throws InvalidOrderException,SQLException,ClassNotFoundException
	{  
		int OID=orderid;
		OrderDB odb=new OrderDB();
		Order o=odb.retrieveOrder(OID);
		return o;
	}  
	/**
	* This method is used to return the username of the particular userid.
	* @param String
	* @return String
	* @throws Exception
	*/
	public  int retCustomerid(String userId)throws Exception
	{  
		CustomerPaymentReportDB custpaymentdb= new CustomerPaymentReportDB ();
	 int custid=custpaymentdb.customerPaymentReport(userId);
	 return custid;
	}
	
	/**
	* This method is used retrieve list of all order ID's 
	*  that are not cancelled and related to the same customer.
	* @param integer
	* @return object 
	* @throws InvalidEmployeeException,OrderNotAssignedException,ClassNotFoundException,SQLException
	*/
		@SuppressWarnings("unchecked")
	/*public List retrieveOrderId_report(int custid)throws ClassNotFoundException,SQLException,Exception
	{
	 List<Integer> list1 = new ArrayList<Integer>();
	 ReportDB reportdb= new ReportDB();
	 list1=reportdb.retrieveOrderIds(custid);
	 return list1;
	}
	*/
		/**
		* This method is used retrieve order status of the given order ID.
		* @param integer
		* @return char 
		* @throws ClassNotFoundException,SQLException,InvalidOrderException
		*/
		public char retrieveOrderStatus(int OrderId)throws ClassNotFoundException,SQLException,InvalidOrderException
		{
			   OrderDB orderdb= new OrderDB();
			   char status=orderdb.retrieveOrderStatus(OrderId);
			   return status;
		}
		
		/**
		* This method is used retrieve list of all order ID's 
		*  that are not cancelled.
		* @param integer
		* @return object 
		* @throws InvalidEmployeeException,OrderNotAssignedException,ClassNotFoundException,SQLException
		*/
			@SuppressWarnings("unchecked")
		/*public List retrieveOrderId_reports()throws ClassNotFoundException,SQLException,Exception
		{
		 List<Integer> list1 = new ArrayList<Integer>();
		 ReportDB reportdb= new ReportDB();
		 list1=reportdb.retrieveOrderId1();
		 return list1;
		}
			*/
			/**
			 * This method is used to generate order status report.
			 * Accepts the status,start date and end date from the user and invokes the appropriate getCustomerReport
			 * method of the ReportDB class.
			 * @param String, String, String
			 * @return list object
			 * @throws Exception
			 */
			/*public List orderStatusReport(String Status,String start,String end) throws NoRecordsAvailableException,Exception
			{
				    
				    List list = new ArrayList();
			        // Creating the reportDB object.
				   	ReportDB report = new ReportDB();
				   	//call to the getCustomerReport method of ReportDB.
				    list=report.getOrderStatusReport(Status,start,end); 
				    return list;
			}
		*/
			
			/**
			 * This method is used to generate order status report.
			 * Accepts the status from the user and invokes the appropriate getCustomerReport
			 * method of the ReportDB class.
			 * @param String
			 * @return list object
			 * @throws Exception
			 */
			/*public List orderStatusReport(String Status) throws NoRecordsAvailableException,Exception
			{
				    
				    List list = new ArrayList();
			        // Creating the reportDB object.
				   	ReportDB report = new ReportDB();
				   	//call to the getCustomerReport method of ReportDB.
				    list=report.getOrderStatusReport(Status); 
				    return list;
			}*/

			
			/**
			 * This method is used to generate order status report.
			 * Accepts the start date and end date from the user and invokes the appropriate getCustomerReport
			 * method of the ReportDB class.
			 * @param String, String
			 * @return list object
			 * @throws Exception
			 */
			/*public List orderStatusReport(String start,String end) throws NoRecordsAvailableException,Exception
			{
				    
				    List list = new ArrayList();
			        // Creating the reportDB object.
				   	ReportDB report = new ReportDB();
				   	//call to the getCustomerReport method of ReportDB.
				   	
				    list=report.getOrderStatusReport(start,end); 
				    return list;
			}
	
	public int saveDelivery(Delivery delivery, char status) throws 
	InvalidOrderException,Exception
	{
		DeliveryDB deliveryDB=new DeliveryDB();
		int value=deliveryDB.saveDelivery(delivery,status);
		return value;
	}*/
	/**
	Name				: retrieveCustomerId
	Description 		: This method will call retrieveCustomerId of PaymentDB 
	@param  			: NA
	@return 			: List
	@author 			: Poornima Gadad , Infosys Technologies ltd.
	@Created 			: July 27, 2009
	*/
	public List<Integer> retrieveCustId()throws Exception{

	    List<Integer> list;
	   // Creating PaymentDB object 
	    PaymentDB invForm= new PaymentDB();
	//    Calling function 
	    list =invForm.retrieveCustId();
	    return list;
	}
	
	/*public Invoice saveInvoice(Invoice invoice) throws InvalidCustomerIDException, invalidMonthYearException,
													noOrderException, invoiceGenAlreadyException, Exception{
		InvoiceDB invoicedb = new InvoiceDB();
		int i= invoicedb.saveInvoice(invoice);
		if (i == -1) {
			System.out.println("invalidCustomerIDException");
			throw new InvalidCustomerIDException();
		}
		if (i == -2) {
			System.out.println("invalidMonthYearException");
			throw new invalidMonthYearException();
		}
		if (i == -3) {
			System.out.println("noOrderException");
			throw new noOrderException();
		}
		if (i == -4) {
			System.out.println("invoiceGenAlreadyException");
			throw new invoiceGenAlreadyException();
		}
		if (i == 0 || i == 1) {
			System.out.println("Exception");
			throw new Exception();
		}
		if (i>1){
			System.out.println("Invoice is saved");
			invoice.setAmount(i);
		}
		return invoice;
	}
	public List retrieveInvoiceId()throws Exception{
	    
		Creating List object 
	    List list;
	    Creating PaymentDB object 
	    PaymentDB pForm= new PaymentDB();
	    Calling function 
	    list = pForm.retrieveInvoiceId();
	    return list;
	}
	public List savePayment(int invoiceId, String description) throws Exception
	{
	    Creating PaymentDB object 
		PaymentDB payment = new PaymentDB();
		Creating List object 
		List list = new ArrayList();
		Calling function 
		list= payment.savePayment(invoiceId, description);
		return list;
	}

	*//**
	 * Name:	InvoiceStatusReport
	 * Description :This method will call InvoiceStatusReport of ReportDB 
	 * @param  String spCustomerid , String spToDate , String spFromDate
	 * @return CachedRowSet
	 * @author Poornima Gadad, Infosys Technologies ltd.
	 * @Created July 28, 2009.
	 *//*
	public CachedRowSet InvoiceStatusReport(String spCustomerid , String spFromDate , String spToDate )throws Exception
	{   
	Creating Order object 
		CachedRowSet invoiceDetails = new CachedRowSetImpl();
		Creating OrderDB object 
		ReportDB invoiceStatusReport= new ReportDB();
		
		
		Calling function 
		invoiceDetails=invoiceStatusReport.InvoiceStatusReport(spCustomerid,  spFromDate , spToDate);
		
		return invoiceDetails;
	}

	*//********************* End of InvoiceStatusReport ****************************************//*	
	public int getCustId(String userID) throws Exception

	{

	      LoginDB login=new LoginDB();

	      int retVal=login.getCustId(userID);

	      return retVal;

	}
*/	/**
	 * Name:retrieveCustomerId
	 * Description :This method will call retrieveCustomerId of ReportDB 
	 * @param  NA
	 * @return List
	 * @author Poornima Gadad , Infosys Technologies ltd.
	 * @Created July 28, 2009.
	 */
	/*public List retrieveCustomerId()throws Exception{
		
   
	//Creating Order object 
		List list;
		//Creating OrderDB object 
		ReportDB customerReport= new ReportDB();
	//	Calling function 
		list =customerReport.retrieveCustomerId();
		
		return list;
	}*/

	/********************* End of retrieveCustomerId ****************************************/	

	public int editCustomer(Customer customer)throws Exception

	{      	
		   CustomerDB customerDB=new CustomerDB();
		   int iRet=customerDB.editCustomer(customer);
		   return iRet;
	}
	public int deleteCustomer(Customer customer)throws Exception

	{      	
		   CustomerDB customerDB=new CustomerDB();
		   int iRet=customerDB.deleteCustomer(customer);
		   return iRet;
	}
	public List<Integer> generatecustomerId()throws InvalidCustomerException,ClassNotFoundException,SQLException

	{      	
		 List<Integer> list = new ArrayList<Integer>();
		 CustomerDB customerDB= new CustomerDB();
		 list=customerDB.generatecustomerId();
		 return list;
	}
	public List<Integer> deleteIdList()throws InvalidCustomerException,ClassNotFoundException,SQLException

	{      	
		 List<Integer> list = new ArrayList<Integer>();
		 CustomerDB customerDB= new CustomerDB();
		 list=customerDB.deleteIdList();
		 return list;
	}
	/*public ResultSet getUserId(String userType)throws Exception{
		EmployeeDB emp=new EmployeeDB();
		ResultSet resultSet=emp.getUserId(userType);
		return resultSet;
					
		}	
		public String getPassword(String userID)throws Exception
		{
			LoginDB login=new LoginDB();
			String newPsw=login.getPswd(userID);
			return newPsw;
		}
			
		public int changePsw(String userID,String newPsw)throws Exception
		{
			LoginDB login=new LoginDB();
			int retVal=login.changePsw(userID,newPsw);
			return retVal;
		}
		public String resetPassword(String name,String userid) throws SQLException
		{
			EmployeeDB emp=new EmployeeDB();
			String newPassword=emp.resetPassword(name, userid);
			return newPassword;
		}
		public int checkDesignation(String userId)throws Exception{
			LoginDB log=new LoginDB();
			int retVal=log.checkDesignation(userId);
			return retVal;
		}
		public List orderIdRecords(int orderid)throws ClassNotFoundException,SQLException,Exception
		{
		 System.out.println("Start of sterling dao " +orderid);
		 List list1 = new ArrayList();
		 DeliveryDB deliverydb= new DeliveryDB();
		 list1=deliverydb.orderIdRecords(orderid);
		 System.out.println("end of sterling dao" +orderid);
		 return list1;
		}
		public int getEmpid(String userid)throws Exception{
			EmployeeDB emp=new EmployeeDB();
			int retEmpId=emp.getEmpid(userid);
			return retEmpId;
		}
		
		public  List retrieveEmployeeId()throws ClassNotFoundException,InvalidEmployeeException,SQLException,InvalidOrderException
		{
			List<Integer> list = new ArrayList<Integer>();
			 ReportDB reportdb= new ReportDB();
			 list=reportdb.retrieveEmployeeId();
			 return list;
		}
		
		public List orderAssignedReport(int employeeID,String startDate,String endDate) throws NoRecordsAvailableException,Exception
		{
			    
			    List list = new ArrayList();
		       // Creating the reportDB object.
			   	ReportDB report = new ReportDB();
			   	//call to the getOrderAssignedReport method of ReportDB.
			    list=report.getorderAssignedReport(employeeID,startDate,endDate); 
			    return list;
		}
		
		public ArrayList retrieveOrdersNotClosed(int employeeId)throws InvalidEmployeeException, OrderNotAssignedException, 
					ClassNotFoundException, SQLException, Exception {
			 creating a list of object and an object of orderDB type then calling
			 * the RetrieveOrdersNotClosed method returning order list
			ArrayList list;
			OrderDB orderdb=new OrderDB();
			list=(ArrayList) orderdb.retrieveOrdersNotClosed(employeeId);
			return list;
		}*/
		public int saveDistribution(Calendar dateOfGeneration) throws Exception 
		{		
			distributionDB distributionDB = new distributionDB();
			int returnValue = distributionDB.saveDistribution(dateOfGeneration);
			return returnValue;
			
		}
		/**
		 * This method is used to generate the customer report.
		 * Accepts the customerId,start date and end date from the user and invokes the getCustomerReport
		 * method of the ReportDB class.
		 * @param integer, String
		 * @return list object
		 * @throws InvalidCustomerException
		 */
		/*public List customerReport(int customerID,String start,String end) throws InvalidCustomerException,Exception
		{
			    
			    List list = new ArrayList();
		        // Creating the reportDB object.
			   	ReportDB report = new ReportDB();
			   	//call to the getCustomerReport method of ReportDB.
			    list=report.getCustomerReport(customerID,start,end); 
			    return list;
		}

		*//**
		* This method is used to generate the list of customer ids from sterling_order table.
		* @param None
		* @return List
		* @throws InvalidCustomerException,ClassNotFoundException,SQLException
		*//*
		public List generatecustomerId_report()throws InvalidCustomerException,ClassNotFoundException,SQLException

		{      	
			 List<Integer> list1 = new ArrayList<Integer>();
			 ReportDB report= new ReportDB();
			 list1=report.generatecustomerId();
			 return list1;
		}
		public int saveEmployee(Employee newEmployee)throws Exception{
		      EmployeeDB emp=new EmployeeDB();
		      int status=emp.addEmployee(newEmployee);
		      return status;
		      
		}

		public CachedRowSet PaymentStatusReport(String Customerid , String FromDate, String ToDate  )throws Exception
		{   
		Creating Order object 
			CachedRowSet paymentStatus = new CachedRowSetImpl();
			Creating OrderDB object 
			ReportDB paymentstatusreport= new ReportDB();
			
			
			Calling function 
			paymentStatus=paymentstatusreport.PaymentStatusReport(Customerid, FromDate ,ToDate );
			
			return paymentStatus;
		}

		public CachedRowSet PendingPaymentStatusReport(String spCustomerid ,  String spFromDate ,String spToDate )throws Exception
		{   
		Creating Order object 
			CachedRowSet pendingPayment = new CachedRowSetImpl();
			Creating OrderDB object 
			ReportDB pendingpaymentreport= new ReportDB();
			
			
			Calling function 
			pendingPayment=pendingpaymentreport.PendingPaymentStatusReport(spCustomerid,  spFromDate ,spToDate);
			
			return pendingPayment;
		}*/

	}