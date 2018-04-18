package bd;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OK");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: " + ex.getMessage() + " not found");
		}
		Connection connection = OraConn.open();
		OraConn.close(connection);
	}

}
