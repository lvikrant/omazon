package exceptionClass;
/****************************************************************************************************************************
 * Description: This class will catch  exception coming from db class and display the required result
 * @author Poornima_Gadad
 * Date:24-Jul-2009.
 ***************************************************************************************************************************/
public class noOrderException extends Exception
{
	private static final long serialVersionUID = 1L;

	public noOrderException()
	{
		super("No Order Placed in given Month & Year!!!!");
	}

}
