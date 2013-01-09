package exceptionClass;


public class InvalidCustomer extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidCustomer()
	{
		super("Invalid Customer ID!! Please enter a valid Customer ID");
	}
	public InvalidCustomer(final String message)
	{
		super(message);
	}
}

