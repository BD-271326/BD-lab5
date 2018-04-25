package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import bd.OraConn;

public class EmployeesDAL {

	private static SQLException exception;

	public static ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employeesList = new ArrayList<Employee>();
		try (Statement statement = OraConn.GetConnection().createStatement()) {

			String query = "SELECT * FROM molechno.EMPLOYEES";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				employeesList.add(rs2Employee(resultSet));
			}
		} catch (SQLException ex) {
			System.out.println("getList " + ex);
		}
		return employeesList;
	}

	public static Employee getEmployeeByEmployeeId(int id) {
		Employee emp = new Employee();
		try (Statement statement = OraConn.GetConnection().createStatement()) {
			String query = String.format("SELECT * FROM molechno.EMPLOYEES WHERE Employee_Id= %d", id);
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			emp = (rs2Employee(resultSet));
		} catch (SQLException ex) {
			System.out.println("getEMP " + ex);
		}
		return emp;
	}

	public static void instertEmployee(Employee emp) {

		try (Statement statement = OraConn.GetConnection().createStatement()) {
			String query1 = "SELECT MAX(EMPLOYEE_ID) FROM molechno.EMPLOYEES";
			ResultSet resultSet = statement.executeQuery(query1);
			resultSet.next();
			emp.setEmployeeId((resultSet.getInt(1)) + 1);
			String query = "INSERT INTO molechno.EMPLOYEES(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)"
					+ "VALUES(" + emp.getEmployeeId() + ", '" + emp.getFirstName() + "', '" + emp.getLastName() + "', '"
					+ emp.getEmail() + "', '" + emp.getPhoneNumber() + "'," + "to_date('" + emp.getHireDate() + "'), '"
					+ emp.getJobId() + "'," + emp.getSalary() + "," + emp.getCommissionPCT() + "," + emp.getManagerId()
					+ "," + emp.getDepartmentId() + " )";
			statement.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("insert " + ex);
		}

	}

	public static int updateEmployee(Employee emp) {

		try (Statement statement = OraConn.GetConnection().createStatement()) {
			String query = String.format("UPDATE molechno.EMPLOYEES SET FIRST_NAME= '" + emp.getFirstName()
					+ "', LAST_NAME= '" + emp.getLastName() + "', EMAIL= '" + emp.getEmail() + "', PHONE_NUMBER= '"
					+ emp.getPhoneNumber() + "', HIRE_DATE=to_date('" + emp.getHireDate() + "'), JOB_ID= '" + emp.getJobId()
					+ "', SALARY= " + emp.getSalary() + ", COMMISSION_PCT=" + emp.getCommissionPCT()
					+ ", MANAGER_ID= " + emp.getManagerId() + ", DEPARTMENT_ID= " + emp.getDepartmentId()
					+ " WHERE Employee_Id= %d", emp.getEmployeeId());

			statement.executeQuery(query);

		} catch (SQLException ex) {
			System.out.println("Update " + ex);
		}
		return 1;
	}

	public static void deleteEmployee(int id) {

		try (Statement statement = OraConn.GetConnection().createStatement()) {
			String query = String.format("DELETE FROM molechno.EMPLOYEES WHERE Employee_Id= %d", id);
			statement.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("delete " + ex);
		} catch (Exception ex) {
			System.out.println("delete " + ex);
		}
	}

	private static Employee rs2Employee(ResultSet resultSet) {
		Employee emp = null;
		try {
			int col = 1;
			emp = new Employee(resultSet.getInt(col++));
			emp.setFirstName(resultSet.getNString(col++));
			emp.setLastName(resultSet.getNString(col++));
			emp.setEmail(resultSet.getNString(col++));
			emp.setPhoneNumber(resultSet.getNString(col++));
			emp.setHireDate(resultSet.getDate(col++).toLocalDate());
			emp.setJobId(resultSet.getNString(col++));
			emp.setSalary(resultSet.getInt(col++));
			emp.setCommissionPCT(resultSet.getBigDecimal(col++));
			emp.setManagerId(resultSet.getInt(col++));
			emp.setDepartmentId(resultSet.getInt(col++));

		} catch (SQLException ex) {
			EmployeesDAL.exception = ex;
		}
		return emp;

	}

	public SQLException getException() {
		return exception;
	}

}
