/*package dbClass;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;
import java.util.Enumeration;

import com.omazon.common.LoadProperty;

public class MysqlConnect {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
	{
		Connection conn = null;
		LoadProperty prop;
		prop = new LoadProperty("logistics");
		String driver = "com.mysql.jdbc.Driver";
		ResultSet rs = null;
		Statement stmt;
		try
		{
			Class.forName(driver).newInstance();
			//conn = DriverManager.getConnection((prop.getElementId("eventsdburl")+prop.getElementId("eventsdbname")),prop.getElementId("eventsdbuserid"),prop.getElementId("eventsdbpass"));

			System.out.println("Connected to the database");
			stmt = conn.createStatement();
			//rs = stmt.executeQuery(prop.getElementId("eventsdbquery"));
			while(rs.next())
			{
			}
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		} catch(IllegalAccessException e){
			e.printStackTrace();
		}		
	}
}*/