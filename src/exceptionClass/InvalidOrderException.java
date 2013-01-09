package exceptionClass;

public class InvalidOrderException extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public InvalidOrderException()
 {
	 super("Invalid OrderId!! Please enter a valid Order ID");
 }
}
