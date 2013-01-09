package exceptionClass;

public class NoRecordsAvailableException extends Exception
{
	public NoRecordsAvailableException()
	{
		super("No records are available");
	}
	public NoRecordsAvailableException(final String message)
	{
		super(message);
	}
}
