package com.hexaware.FTP114.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP114new");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {

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
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String doj = sdf.format(empJoinDate);
        String doj1 = sdf.format(emp.empJoinDate);
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMob, emp.empMob)
        && Objects.equals(doj, doj1)
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
    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

  class LeaveDetails {
  /**
   * levId to store leave id.
   * levNoOfDays to store Leave number of days.
   * levStartDate to store leave StartDate.
   * levEndDate to store laeve EndDate.
   * levType to store LeaveType.
   * levStatus to store LeaveStatus.
   * levReason to store leave Reason.
   * levApplyDate to store leave ApplyDate.
   * levMgrComments to store leave Manager Comments.
   * empId to store employee Id.
   */
  private int levId;
  private int levNoOfDays;
  private Date levStartDate;
  private Date levEndDate;
  private LeaveType levType;
  private LeaveStatus levStatus;
  private String levReason;
  private Date levApplyDate;
  private String levMgrComments;
  private int empId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lev = (LeaveDetails) obj;
    if (Objects.equals(levId, lev.levId)
        && Objects.equals(levNoOfDays, lev.levNoOfDays)
        && Objects.equals(levStartDate, lev.levStartDate)
        && Objects.equals(levEndDate, lev.levEndDate)
        && Objects.equals(levType, lev.levType)
        && Objects.equals(levStatus, lev.levStatus)
        && Objects.equals(levReason, lev.levReason)
        && Objects.equals(levApplyDate, lev.levApplyDate)
        && Objects.equals(levMgrComments, lev.levMgrComments)
        && Objects.equals(empId, lev.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(levId, levNoOfDays, levStartDate, levEndDate, levType,
    levStatus, levReason, levApplyDate, levMgrComments, empId);
  }

  /**
  * Default Constructor for leaveDetails class.
   */
  public LeaveDetails() {
  }
  /**
  * @param argLevId to initialize Leave ID.
  * @param argLevNoOfDays to initialize Leave Number of days.
  * @param argLevStartDate to initialize Leave Start Date.
  * @param argLevEndDate to initialize Leave End Date.
  * @param argLevType to initialize Leave Type.
  * @param argLevStatus to initialize Leave Status.
  * @param argLevReason to initialize Leave Reason.
  * @param argLevApplyDate to initialize Leave Apply Date.
  * @param argLevMgrComments to initialize Leave Manager Comments.
  * @param argEmpId to initialize Leave ID
  */

  public LeaveDetails(final int argLevId, final int argLevNoOfDays, final Date argLevStartDate,
                     final Date argLevEndDate, final LeaveType argLevType,
                     final LeaveStatus argLevStatus, final String argLevReason,
                     final Date argLevApplyDate,
                     final String argLevMgrComments, final int argEmpId) {
    this.levId = argLevId;
    this.levNoOfDays = argLevNoOfDays;
    this.levStartDate = argLevStartDate;
    this.levEndDate = argLevEndDate;
    this.levType = argLevType;
    this.levStatus = argLevStatus;
    this.levReason = argLevReason;
    this.levApplyDate = argLevApplyDate;
    this.levMgrComments = argLevMgrComments;
    this.empId = argEmpId;
  }

  /**
   * Gets the Leave Id.
   * @return this Leave ID.
   */
  public final int getLevId() {
    return levId;
  }

  /**
   *
   * @param argLevId to set leave id.
   */
  public final void setLevId(final int argLevId) {
    this.levId = argLevId;
  }

  /**
   * Gets the Leave number of days.
   * @return this LeaveNoOfDays.
   */
  public final int getLevNoOfDays() {
    return levNoOfDays;
  }
  /**
   * @param argLevNoOfDays to set LevNoOfDays.
   */
  public final void setLevNoOfDays(final int argLevNoOfDays) {
    this.levNoOfDays = argLevNoOfDays;
  }

  /**
   * Gets the LeaveStartDate.
   * @return this levStartDate.
   */
  public final Date getLevStartDate() {
    return levStartDate;
  }
  /**
   *
   *@param argLevStartDate to set Leave StartDate.
   */
  public final void setLevStartDate(final Date argLevStartDate) {
    this.levStartDate = argLevStartDate;
  }
  /**
   *Gets the LeaveEndDate.
   *@return this LeaveEndDate.
   */
  public final Date getLevEndDate() {
    return levEndDate;
  }
  /**
   *
   *@param argLevEndDate to set Leave EndDate.
   */
  public final void setLevEndDate(final Date argLevEndDate) {
    this.levEndDate = argLevEndDate;
  }
  /**
   * Gets the Leave type.
   * @return this Leave type.
   */
  public final LeaveType getLevType() {
    return levType;
  }
  /**
   *
   * @param argLevType to set LeaveType.
   */
  public final void setLevType(final LeaveType argLevType) {
    this.levType = argLevType;
  }
  /**
   *Gets the Leave Status.
   *@return this Leave Status.
   */
  public final LeaveStatus getLevStatus() {
    return levStatus;
  }

  /**
   *
   *@param argLevStatus to set Employee Leave Status.
   */
  public final void setLevStatus(final LeaveStatus argLevStatus) {
    this.levStatus = argLevStatus;
  }
  /**
   *Gets the Leave Reason.
   *@return this Leave Reason.
   */
  public final String getLevReason() {
    return levReason;
  }

  /**
   *
   *@param argLevReason to set Employee Leave Reason.
   */
  public final void setLevReason(final String argLevReason) {
    this.levReason = argLevReason;
  }
  /**
   *Gets the LeaveApplyDate.
   *@return this LeaveApplyDate.
   */
  public final Date getLevApplyDate() {
    return levApplyDate;
  }
  /**
   *
   *@param argLevApplyDate to set Leave ApplyDate.
   */
  public final void setLevApplyDate(final Date argLevApplyDate) {
    this.levApplyDate = argLevApplyDate;
  }
  /**
   *Gets the Leave Manager Comments.
   *@return this Leave Manager Comments.
   */
  public final String getLevMgrComments() {
    return levMgrComments;
  }

  /**
   *
   *@param argLevMgrComments to set Employee Manager Comments.
   */
  public final void setLevMgrComments(final String argLevMgrComments) {
    this.levMgrComments = argLevMgrComments;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }

  }

  enum LeaveStatus {
  /**
  *leaveStatus to store APPROVED.
  */
  APPROVED,

  /**
  * leaveStatus to store DENIED.
  */
  DENIED,

  /**
  * leaveStatus to store PENDING.
  */
  PENDING;

}

enum LeaveType {
  /**
  *leaveType to store EL.
  */
  EL,

  /**
  * leaveType to store PL.
  */
  PL,

  /**
  * leaveType to store ML.
  */
  ML;

}

