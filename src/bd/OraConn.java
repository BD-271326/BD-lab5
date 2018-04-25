package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraConn {

	private static int ErrorCode;
	private static String ErrorMessage;
	private static Connection connection;

	public static Connection open() {
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf",
					"molechno", "molechno");
			System.out.println("Polaczenie jest otwarte");
			return connection;
		} catch (SQLException ex) {
			ErrorCode = ex.getErrorCode();
			ErrorMessage = ex.getMessage();
			//System.out.println("Nie mozna otworzyc polaczenia! Error Code: " + ErrorCode + "; " + ErrorMessage);
			return null;
		}
	}

	public static void close(Connection connection) {
		try {
			connection.close();
			System.out.println("Polaczenie jest zamkniete");
		} catch (SQLException ex) {
			ErrorCode = ex.getErrorCode();
			ErrorMessage = ex.getMessage();
			//System.out.println("Nie mozna zamknac polaczenia! Error code: " + ErrorCode + "; " + ErrorMessage);

		}
	}
	public static String GetErrorMessage()
	{
		return ErrorMessage;
	}
	public static int GetErrorCode()
	{
		return ErrorCode;
	}
	public static Connection GetConnection()
	{
		return connection;
	}


}
