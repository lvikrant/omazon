package exceptionClass;


@SuppressWarnings("serial")
public class OtherExceptions extends Exception
{
	public OtherExceptions()
	{
		super("Some other exception occurred");
	}
	public OtherExceptions(final String message)
	{
		super(message);
	}
}
