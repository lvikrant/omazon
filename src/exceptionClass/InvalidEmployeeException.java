package exceptionClass;

public class InvalidEmployeeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidEmployeeException()
	{
		super("Invalid Employee ID.");
	}
	public InvalidEmployeeException(final String message)
	{
		super(message);
	}

}
