package exceptionClass;

/**
 * @author vibhav_chauhan
 *
 */
public class InvalidCustomerIDException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCustomerIDException()
	{
		super("Invalid Customer ID");
	}

}
