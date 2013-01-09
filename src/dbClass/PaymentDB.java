package dbClass;
/**
 * 
 */
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import exceptionClass.AlreadyPaidException;

/**
 * @author Poornima_Gadad
 *
 */
public class PaymentDB {
	
	public List<Integer> retrieveCustId()throws Exception{

	Connection connection =null;
	List<Integer> list;
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");

	connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");

	Statement statement = connection.createStatement();

	ResultSet resultSet = statement.executeQuery("select DISTINCT customerid from sterling_order order by customerid asc ");

	list = new ArrayList<Integer>();

	while (resultSet.next())
	{
	      list.add(resultSet.getInt("customerid"));
	}
	}
	finally 
	{
	      connection.close();
	}

	return list; 


	}
	
	public List<Integer> retrieveInvoiceId()throws Exception{

		Connection connection =null;
		List<Integer> list;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360", "t126360");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select invoiceid from sterling_invoice order by invoiceid asc ");
			
			list = new ArrayList<Integer>();
			while (resultSet.next())
			{
				list.add(resultSet.getInt("invoiceid"));
			}
		}
		finally 
		{
		      connection.close();
		}
		return list; 
	}
	
	public List savePayment(int invoiceId, String description) throws Exception
	{
		Connection connection = null;
		List list;
		list = new ArrayList();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
			Statement statement = connection.createStatement();
			ResultSet resultset =  statement.executeQuery("select count(*) from Sterling_Payment where InvoiceId=" + invoiceId);
			resultset.next();
			int flag = resultset.getInt(1);
			if(flag!=0){
				throw new AlreadyPaidException();
			}
			else{
				statement.executeUpdate("insert into Sterling_Payment values("+ invoiceId +",sysdate ,'" + description+ "')");
				ResultSet resultset1 =  statement.executeQuery("select InvoiceId, DateOfPayment, Description from Sterling_Payment where InvoiceId= " + invoiceId);
				list = new ArrayList();
				while (resultset1.next())
				{
					list.add(resultset1.getString("invoiceId"));
					Date sdate = resultset1.getDate("dateofpayment");
					SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
					String printDate = sd.format(sdate);
					list.add(printDate);
					list.add(resultset1.getString("description"));
				}
			}
		}
		finally
		{
			connection.close();
		}
		return list;
	}
	

}
