package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraConn {

	private static int ErrorCode;
	private static String ErrorMessage;

	public static Connection open() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf",
					"molechno", "molechno");
			System.out.println("Polaczenie jest otwarte");
			return connection;
		} catch (SQLException ex) {
<<<<<<< HEAD
			System.out.println("Nie mozna otworzyc polaczenia! Error Code: " + ex.getErrorCode() + "; " + ex.getMessage());
=======
			ErrorCode = ex.getErrorCode();
			ErrorMessage = ex.getMessage();
			System.out.println("Nie mozna otworzyc polaczenia! Error Code: " + ErrorCode + "; " + ErrorMessage);
>>>>>>> lab_5
			return null;
		}
	}

	public static void close(Connection connection) {
		try {
			connection.close();
			System.out.println("Polaczenie jest zamkniête");
		} catch (SQLException ex) {
<<<<<<< HEAD
			System.out.println("Nie mozna zamknac polaczenia! Error code: " + ex.getErrorCode() + "; " + ex.getMessage());
=======
			ErrorCode = ex.getErrorCode();
			ErrorMessage = ex.getMessage();
			System.out.println("Nie mozna zamknac polaczenia! Error code: " + ErrorCode + "; " + ErrorMessage);
>>>>>>> lab_5
		}
	}

}
