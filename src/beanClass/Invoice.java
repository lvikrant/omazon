package beanClass;
import java.util.Calendar;

/**
 * This class is for setting and getting the user inputs.
 * @Created on Jun 11, 2009
 * @author Vibhav Chauhan, Infosys Technologies Limited
 * @version 1.0
 */

public class Invoice
{
	/**
	 * 
	 * declaring private data members
	 */
	private int invoiceId;
	private int customerId;
	private Calendar invoiceDate;
	private int invoiceMonth;
	private int invoiceYear;
	private double amount;
	private String description;

	/**
	* Get the value for Invoice ID
	* @param none
	* @return invoiceId
	*/
	public int getInvoiceId()
	{
		return invoiceId;
	}
	
	/**
	* Set the value for Invoice ID
	* @param int invoiceID
	* @return none
	*/
	public void setInvoiceId(int invoiceID)
	{
		invoiceId=invoiceID;
	}
	/**
	* Get the value for Customer ID
	* @param none
	* @return customerId
	*/
	public int getCustomerId()
	{System.out.println(customerId);
		return customerId;
	}
	/**
	* Set the value for Customer ID
	* @param int customerID
	* @return none
	*/
	public void setCustomerId(int customerID)
	{
		customerId=customerID;
	}
	/**
	* Get the value for Invoice Date
	* @param none
	* @return invoiceDate
	*/
	public Calendar getInvoiceDate()
	{
		return invoiceDate;
	}
	/**
	* Set the value for Invoice Date
	* @param Calendar dateOfInvoice
	* @return none
	*/
	public void setInvoiceDate(Calendar dateOfInvoice)
	{
		invoiceDate=dateOfInvoice;
	}
	/**
	* Get the value for Invoice Month
	* @param none
	* @return invoiceMonth
	*/
	public int getInvoiceMonth()
	{
		return invoiceMonth;
	}
	/**
	* Set the value for Invoice Month
	* @param int invoiceMonth
	* @return none
	*/
	public void setInvoiceMonth(int invoiceMonth)
	{
		this.invoiceMonth=invoiceMonth;
	}
	/**
	* Set the value for Invoice Year
	* @param none
	* @return invoiceYear
	*/	
	public int getInvoiceYear()
	{
		return invoiceYear;
	}
	/**
	* Set the value for Invoice Year
	* @param int invoiceYear
	* @return none
	*/
	public void setInvoiceYear(int invoiceYear)
	{
		this.invoiceYear=invoiceYear;
	}
	
	/**
	* Get the value for Amount
	* @param none
	* @return amount
	*/
	public double getAmount()
	{
		return amount;
	}
	
	/**
	* Set the value for Amount
	* @param double amount
	* @return none
	*/
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	
	/**
	* Get the value for Description
	* @param none
	* @return description
	*/
	public String getDescription()
	{
		return description;
	}
	
	/**
	* Set the value for Description
	* @param String description
	* @return none
	*/
	public void setDescription(String description)
	{
		this.description=description;
	}

}