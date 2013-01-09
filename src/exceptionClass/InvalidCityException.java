package exceptionClass;

public class InvalidCityException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCityException()
	{
		super("Invalid City Entered.Should be in('D','P','B','C')!!");
	}

}
