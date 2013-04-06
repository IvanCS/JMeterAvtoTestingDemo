package com.tsystems.JMeterAvtoTestingDemo.ejbs.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:com/tsystems/jmeteravtotestingdemo/db/employees_db");
		if (connection == null)
		{
		System.out.println("Ololo!");
		}
		Statement statement = connection.createStatement();
		statement.executeQuery("select * from ");
		connection.close();

	}

}
