package exceptionClass;

public class AlreadyPaidException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AlreadyPaidException()
		{
			super("Already Paid..!!!!!!");
		}

}
