package bd;

import java.util.ArrayList;
import java.sql.Connection;
import dal.Employee;

public class Test {
	public static void testCRUD()
	{
		ArrayList<Employee> empList= new ArrayList<Employee>();
		empList=dal.EmployeesDAL.getEmployees();
		wypiszListe(empList);
		
		Employee emp=dal.EmployeesDAL.getEmployeeByEmployeeId(193);
		emp.setFirstName("NEW");
		emp.setLastName("CREATED");
		dal.EmployeesDAL.instertEmployee(emp);
		empList=dal.EmployeesDAL.getEmployees();
		wypiszListe(empList);
		
		emp.setFirstName("NEW");
		emp.setLastName("UPDATED");
		dal.EmployeesDAL.updateEmployee(emp);
		empList=dal.EmployeesDAL.getEmployees();
		wypiszListe(empList);
		
		dal.EmployeesDAL.deleteEmployee(emp.getEmployeeId());
		empList=dal.EmployeesDAL.getEmployees();
		wypiszListe(empList);

	}
	private static void wypiszListe(ArrayList<Employee> empList)
	{
		for(Employee e : empList)
		{
			System.out.println(e.getEmployeeId() + " "+ e.getFirstName()+" "+ e.getLastName()+ " "+ e.getCommissionPCT());
		}
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println();
	}
}
