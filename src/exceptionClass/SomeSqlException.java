package exceptionClass;

@SuppressWarnings("serial")
public class SomeSqlException extends Exception
{
	public SomeSqlException()
	{
		super("Insertion failed because some Sql error occured!!");
	}
	public SomeSqlException(final String message)
	{
		super(message);
	}
}
