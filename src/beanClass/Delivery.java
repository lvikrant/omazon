package beanClass;
import java.util.Calendar;
public class Delivery
{
	/**
				  declaring private data members
	    */
	int orderId;
	private Calendar dateOfDelivery;
	String remarks;
	String status;
	public  int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId=orderId;
	}
	public Calendar getDeliveryDate()
	{
		return dateOfDelivery;
	}
	public void setDeliveryDate(Calendar dateOfDelivery)
	{
		this.dateOfDelivery=dateOfDelivery;
	}
	public  String getRemarks()
	{
		return remarks;
	}
	public  void setRemarks(String remarks)
	{
		this.remarks=remarks;
	}
}