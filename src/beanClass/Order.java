package beanClass;
import java.util.Calendar;
public class Order
{
	private int orderId;
	private int customerId;
	private Calendar orderDate;
	private String recipientName;
	private String recipientAddress;
	private char recipientCity;
	private float courierWeight;
	private char courierStatus;
	private String description;

	
	public void setOrderId(int orderId)
	{
		this.orderId=orderId;
	}
	public int getOrderId()
	{
		return orderId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	public Calendar getOrderDate()
	{
		System.out.println(orderDate);
		return orderDate;
	}
	public void setOrderDate(Calendar orderDate)
	{
		this.orderDate=orderDate;
	}
	
	public String getRecipientName()
	{
		return recipientName;
	}
	public void setRecipientName(String recipientName)
	{
		this.recipientName=recipientName;
	}
	public String getRecipientAddress()
	{
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress)
	{
		this.recipientAddress=recipientAddress;
	}
	public char getRecipientCity()
	{
		return recipientCity;
	}
	public void setRecipientCity(char recipientCity)
	{
		this.recipientCity=recipientCity;
	}
	public float getCourierWeight()
	{
		return courierWeight;
	}
	public void setCourierWeight(float courierWeight)
	{
		this.courierWeight=courierWeight;
	}
	public char getCourierStatus()
	{
		return courierStatus;
	}
	public void setCourierStatus(char courierStatus)
	{
		this.courierStatus=courierStatus;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
}


