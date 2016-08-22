package com.hotodoinjava.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionPool {

	private String llegoAdb;
	
	public String getLlegoAdb() {
		return llegoAdb;
	}

	public void setLlegoAdb(String llegoAdb) {
		this.llegoAdb = llegoAdb;
	}

	public ConnectionPool(){
		llegoAdb = "";
	}
	
	
	/**
	 * Metodo de conexion
	 */
   public  String conect(){
	System.out.println("-------- MySQL "
			+ "JDBC Connection Testing ------------");

	try {
		 String driver = "com.mysql.jdbc.Driver";
	    String connectionString = "jdbc:mysql://localhost:3306/loreirodb";
	    String user = "root";
	    String password = "tech1234";
	    
		Class.forName(driver);
		
	    Connection con = DriverManager.getConnection(connectionString, user, password);
		
	    if (!con.isClosed()) {
	    	System.out.println("Connection OPEN:"+con.toString());
	    	setLlegoAdb(user);
	      con.close();
	      System.out.println("Connection CLOSE:"+con.toString());
	    }

	    return con.getCatalog();
	} catch (SQLException e) {

		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return e.getMessage();

	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	return llegoAdb;


   }
   
//   public static void main(String[] args){
//	   conect();
//   }
}
