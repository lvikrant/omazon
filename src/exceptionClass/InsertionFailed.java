package exceptionClass;




public class InsertionFailed extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InsertionFailed()
	{
		super("Insertion failed because userid cannot be generated!!");
	}
	public InsertionFailed(final String message)
	{
		super(message);
	}
}

