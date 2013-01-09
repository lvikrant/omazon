/**
 * 
 */
package exceptionClass;

/**
 * @author vibhav_chauhan
 *
 */
public class InvalidOrderIDException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrderIDException()
	{
		super("Invalid Order ID");
	}

}
