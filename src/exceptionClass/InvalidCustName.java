package exceptionClass;



@SuppressWarnings("serial")
public class InvalidCustName extends Exception
{
	public InvalidCustName()
	{
		super("Invalid Customer Name!! Please enter a valid Customer Name");
	}
	public  InvalidCustName(final String message)
	{
		super(message);
	}

}

