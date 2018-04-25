package bd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import dal.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OK");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: " + ex.getMessage() + " not found");
		}
		
		Connection connection = OraConn.open();
		Test.testCRUD();
		OraConn.close(connection);
		
	}

}
