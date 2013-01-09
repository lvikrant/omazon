/**
 * This class is bean class used for generating distribution list.
 * Date: 24-Jul-2009
 * @author:Soumya P C
 * @version 1.0
 */
package dbClass;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Calendar;

/* This Class is used to generate the distribution list */
public class distributionDB {

	/* This method is used to call the stored procedure to generate list */
	public int saveDistribution(Calendar dateOfGeneration) throws Exception {
		/* Loading the driver and establish the connection */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection
		("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
		
		long l=dateOfGeneration.getTimeInMillis();
		Date date=new Date(l);
		/*To Call the stored procedure */
		CallableStatement callableStatement = 
			   connection.prepareCall("{call GENERATE_DISTRIBUTION_LIST(?,?)}");
		/* Setting the input parameter */
		callableStatement.setDate(1,date);
		/* Registering the output parameters */
		callableStatement.registerOutParameter(2,Types.INTEGER);
		callableStatement.execute();
		int status=callableStatement.getInt(2);
		connection.close();
		return status;
	}
}
