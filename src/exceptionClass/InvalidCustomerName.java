package exceptionClass;

@SuppressWarnings("serial")
public class InvalidCustomerName extends Exception
{
	public InvalidCustomerName()
	{
		super("Invalid Customer Name!! Please enter a valid Customer Name");
	}
	public  InvalidCustomerName(final String message)
	{
		super(message);
	}

}
