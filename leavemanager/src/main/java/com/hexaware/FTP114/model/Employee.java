package com.hexaware.FTP114.model;

import com.hexaware.FTP114.persistence.DbConnection;
import com.hexaware.FTP114.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee Name.
   * empEmail to store employee email.
   * empMob to store employee mobile number.
   * empJoinDate to store Date of joining.
   * empAvlLeaveBal to store Employee's Leave Balance.
   * empDept to store Employee's Department.
   * empMgrId to store Employee's Manager Id.
   */
  private int empId;
  private String empName;
  private String empEmail;
  private String empMob;
  private Date empJoinDate;
  private int empAvlLeaveBal;
  private String empDept;
  private int empMgrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMob, emp.empMob)
        && Objects.equals(empJoinDate, emp.empJoinDate)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empAvlLeaveBal, emp.empAvlLeaveBal)
        && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmail, empMob, empJoinDate, empAvlLeaveBal, empDept, empMgrId);
  }

  /**
   *Default Constructor of employee class.
   */
  public Employee() {
  }

  @Override
  public final String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String doj = sdf.format(empJoinDate);

    return "EmpId " + empId + " EmpName " + empName + " EmpEmail " + empEmail + " EmpMob "
      + empMob + " EmpJoinDate " + doj + " EmpAvlLeaveBal " + empAvlLeaveBal
      + " EmpDept " + empDept + " EmpMgrId " + empMgrId;
  }
  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpMob to initialize employee mobile number.
   * @param argEmpJoinDate to initialize employee joining date.
   * @param argEmpAvlLeaveBal to initialize employee available leave balance.
   * @param argEmpDept to initialize employee department.
   * @param argEmpMgrId to initialize employee managerID.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail,
                 final String argEmpMob, final Date argEmpJoinDate, final int argEmpAvlLeaveBal,
                 final String argEmpDept, final int argEmpMgrId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empMob = argEmpMob;
    this.empJoinDate = argEmpJoinDate;
    this.empAvlLeaveBal = argEmpAvlLeaveBal;
    this.empDept = argEmpDept;
    this.empMgrId = argEmpMgrId;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */

  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
  *Gets the EmployeeName.
  *@return this Employees's Name.
  */
  public final String getEmpName() {
    return empName;
  }

  /**
  *
  *@param argEmpName to set Employee Name.
  */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
  *Gets the EmployeeEmail.
  *@return this Employee's email.
  */
  public final String getEmpEmail() {
    return empEmail;
  }
  /**
  *
  *@param argEmpEmail to set Employee Email.
  */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
  *Gets the EmployeeMob.
  *@return this Employee's mobile number.
  */
  public final String getEmpMob() {
    return empMob;
  }
  /**
  *
  *@param argEmpMob to set Employee mobile number.
  */
  public final void setEmpMob(final String argEmpMob) {
    this.empMob = argEmpMob;
  }
  /**
  *Gets the EmployeeDOJ.
  *@return this Employee's JoinDate.
  */
  public final Date getEmpJoinDate() {
    return empJoinDate;
  }
  /**
  *
  *@param argEmpJoinDate to set Employee JoinDate.
  */
  public final void setEmpJoinDate(final Date argEmpJoinDate) {
    this.empJoinDate = argEmpJoinDate;
  }

  /**
  *Gets the EmployeeDept.
  *@return this Employees's Dept.
  */
  public final String getEmpDept() {
    return empDept;
  }

  /**
  *
  *@param argEmpDept to set Employee Dept.
  */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   * Gets the Employee ManagerId.
   * @return this Employee's MgrId.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee MgrId.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
  /**
   * The dao for employee.
   * @return EmployeeDAO class object connection.
   */
  public static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * Gets the AvailableLeave Balance of days.
   * @return this empAvlLeaveBal.
   */
  public final int getEmpAvlLeaveBal() {
    return empAvlLeaveBal;
  }
  /**
   * @param argEmpAvlLeaveBal to set empAvlLeaveBal.
   */
  public final void setEmpAvlLeaveBal(final int argEmpAvlLeaveBal) {
    this.empAvlLeaveBal = argEmpAvlLeaveBal;
  }
}
