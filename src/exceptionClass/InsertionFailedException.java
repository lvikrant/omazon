package exceptionClass;

@SuppressWarnings("serial")
public class InsertionFailedException extends Exception
{
	public InsertionFailedException()
	{
		super("Insertion failed because userid cannot be generated!!");
	}
	public InsertionFailedException(final String message)
	{
		super(message);
	}
}
