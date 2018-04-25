package dal;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Employee {

	public Employee()
	{
		
	}
	public Employee(int employeeId)
	{
		this.employeeId = employeeId;
	}
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private int salary;
	private BigDecimal commissionPCT;
	private String jobId;
	private int managerId;
	private int departmentId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		 this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPCT() {
		return commissionPCT;
	}

	public void setCommissionPCT(BigDecimal commissionPCT) {
		this.commissionPCT = commissionPCT;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String string) {
		this.jobId = string;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
}
