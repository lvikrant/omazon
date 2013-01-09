package exceptionClass;

public class InvalidCustomerException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidCustomerException()
	{
		super("Invalid Customer ID!! Please enter a valid Customer ID");
	}
	public InvalidCustomerException(final String message)
	{
		super(message);
	}

}
