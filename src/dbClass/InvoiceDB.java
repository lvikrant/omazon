package dbClass;
/**
 * 
 *//*
package com.omazon.db;

import beanClasses.Invoice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;



*//**
 * @author Poornima_Gadad
 *
 *//*
public class InvoiceDB {
	
	public int saveInvoice(Invoice invoice) throws SQLException{
		Connection connection = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360");
		CallableStatement callablestatement = connection.prepareCall("{call Gen_Invoice(?,?,?,?,?)}");
		
		callablestatement.setInt(1,invoice.getCustomerId());
		callablestatement.setInt(2,invoice.getInvoiceMonth());
		callablestatement.setInt(3,invoice.getInvoiceYear());
		callablestatement.setString(4,invoice.getDescription());
		
		callablestatement.registerOutParameter(5,Types.NUMERIC);
	

		callablestatement.execute();
		int ret=callablestatement.getInt(5);
	    return ret;
		
		
	}catch(Exception e) {
		return 1;
	}
	finally {
		if(connection!=null) {
			try {
				connection.close();
			}catch (SQLException e) {
				throw new SQLException();
			}
		}
	}
		
	}

}
*/