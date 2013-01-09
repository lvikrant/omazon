package exceptionClass;

public class OrderNotAssignedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotAssignedException()
	{
		super("EmployeeID does not have any order!!!");
	}

}
