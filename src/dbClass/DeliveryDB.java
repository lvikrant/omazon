package dbClass;
/*package com.omazon.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import beanClasses.Delivery;

import exceptionClass.InvalidOrderException;
*//**
 * @author soumya_chandrasekar
 *
 *//*
public class DeliveryDB {

	
	*//**
	 * @param args
	 *//*
	private Connection connection=null;

	public int saveDelivery(Delivery delivery,char status)
			throws ClassNotFoundException, SQLException,
			InvalidOrderException {
		int status1=0;
		//Delivery delivery1=new Delivery();
		int orderID;
		orderID=delivery.getOrderId();
		Calendar deliveryDate=delivery.getDeliveryDate();
		long time=deliveryDate.getTimeInMillis();
		Date date1=new Date(time);
		String remarks;
		String status2 =status+"";
		remarks=delivery.getRemarks();
		
		//String status1=delivery1.get
		
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:georli01","t126360","t126360");
			CallableStatement callableStatement=connection.prepareCall("{call SP_Delivery(?,?,?,?,?)}");
			callableStatement.setInt(1,orderID);
			callableStatement.setDate(2,date1);
			callableStatement.setString(3,remarks);
			callableStatement.setString(4,status2);
			callableStatement.registerOutParameter(5, Types.INTEGER);
			callableStatement.execute();
			status1=callableStatement.getInt(5);
			connection.close();
		if(status1==1)
		{
			InvalidOrderException io=new InvalidOrderException();
			throw io;
		}
		
		return status1;
		
	}
	
	public List orderIdRecords(int orderid)throws ClassNotFoundException,SQLException,Exception
	{
		//creating reference for LIST class'
				  
	    //loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//making connection with database
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.122.130.40:1521:Georli01","t126360","t126360");
		PreparedStatement preparedstatement = connection.prepareStatement("select orderid,deliverydate,remarks from sterling_delivery where orderid=?");
		preparedstatement.setInt(1,orderid);
		ResultSet resultSet = preparedstatement.executeQuery();
		
		List list = new ArrayList();
		
		while(resultSet.next()){
			
			  Date orderDate=resultSet.getDate(2);
	        
		      //order.setOrderId(result.getInt(1));
			  //order.setEmployeeId(result.getInt(2));
			  //cal.setTime(orderDate);
			  SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy");
			  String dateOfOrder = sdf.format(orderDate);
			  int orderID=resultSet.getInt(1); 
			  String remarks=resultSet.getString(3);
			   
			   list.add(orderID);
			   list.add(dateOfOrder);
			   list.add(remarks);
	  	
		}
	    
			 return list;
	}
	
	
			
	}
*/