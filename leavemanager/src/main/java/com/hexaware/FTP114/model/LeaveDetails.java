package com.hexaware.FTP114.model;

import com.hexaware.FTP114.persistence.DbConnection;
import com.hexaware.FTP114.persistence.EmployeeDAO;
import com.hexaware.FTP114.persistence.LeaveDetailsDAO;

import java.util.Calendar;
import java.util.Objects;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class LeaveDetails {
  /**
   * levId to store leave id.
   * levNoOfDays to store Leave number of days.
   * levStartDate to store leave StartDate.
   * levEndDate to store laeve EndDate.
   * levType to store LeaveType.
   * levStatus to store LeaveStatus.
   * levSslStatus to store SslStatus.
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
  private SslStatus levSslStatus;
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
        && Objects.equals(levSslStatus, lev.levSslStatus)
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
    levStatus, levSslStatus, levReason, levApplyDate, levMgrComments, empId);
  }

  @Override
  public final String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String sd = sdf.format(levStartDate);
    String ed = sdf.format(levEndDate);
    String ad = sdf.format(levApplyDate);
    return " LevId:" + levId + " Leave No. of days:" + levNoOfDays
             + " Leave StartDate:" + sd + " Leave EndDate:" + ed
             + " Leave Type:" + levType + " Leave Status:" + levStatus + " Leave SSL Status:" + levSslStatus
             + " Leave Reason:" + levReason + " Leave Apply Date:" + ad
             + " Leave Manager Comments:" + levMgrComments + " empId:" + empId;
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
  * @param argLevSslStatus to initialize Leave SSL Status.
  * @param argLevReason to initialize Leave Reason.
  * @param argLevApplyDate to initialize Leave Apply Date.
  * @param argLevMgrComments to initialize Leave Manager Comments.
  * @param argEmpId to initialize Leave ID
  */

  public LeaveDetails(final int argLevId, final int argLevNoOfDays, final Date argLevStartDate,
                     final Date argLevEndDate, final LeaveType argLevType,
                     final LeaveStatus argLevStatus, final SslStatus argLevSslStatus,
                     final String argLevReason, final Date argLevApplyDate,
                     final String argLevMgrComments, final int argEmpId) {
    this.levId = argLevId;
    this.levNoOfDays = argLevNoOfDays;
    this.levStartDate = argLevStartDate;
    this.levEndDate = argLevEndDate;
    this.levType = argLevType;
    this.levStatus = argLevStatus;
    this.levSslStatus = argLevSslStatus;
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
   *Gets the Leave SSL Status.
   *@return this Leave SSL Status.
   */
  public final SslStatus getLevSslStatus() {
    return levSslStatus;
  }

  /**
   *
   *@param argLevSslStatus to set Employee Leave SSL Status.
   */
  public final void setLevSslStatus(final SslStatus argLevSslStatus) {
    this.levSslStatus = argLevSslStatus;
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

  /**
   * The dao for LeaveDetails.
   * @return the LeaveDetailsDAO class object.
   */
  public static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * The dao for Employee.
   * @return the EmployeeDAO class object.
   */
  public static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * The dao for Employee.
   * @param startDate to get leave start date.
   * @param endDate to get leave end date.
   * @return the number of days of leave.
   * @throws ParseException for date issues.
   */

  public static int getWeekend(final Date startDate, final Date endDate) throws ParseException {
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(startDate);

    Calendar endCal = Calendar.getInstance();
    endCal.setTime(endDate);
    int weekendDays = 0;

    //Return 0 if start and end are the same
    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
      return 0;
    }

    do {
      if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        ++weekendDays;
      }
      startCal.add(Calendar.DAY_OF_MONTH, 1);
    } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); //including end date

    return weekendDays;
  }

  /**
   * @param startDate to get leave start date.
   * @param endDate to get leave end date.
   * @return the number of days of leave.
   * @throws ParseException for date issues.
   */
  public static int getOffice(final Date startDate, final Date endDate) throws ParseException {
    Calendar startCal = Calendar.getInstance();
    startCal.setTime(startDate);

    Calendar endCal = Calendar.getInstance();
    endCal.setTime(endDate);

    String[] ofDates = {"2019-06-15", "2019-09-13", "2019-10-19", "2019-12-25"};
    int officeDays = 0;
    Calendar ofCal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    do {
      if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
          && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
        for (int i = 0; i < 4; i++) {
          Date offDate = sdf.parse(ofDates[i]);
          ofCal.setTime(offDate);
          if (startCal.equals(ofCal)) {
            ++officeDays;
          }
        }
      }
      startCal.add(Calendar.DAY_OF_MONTH, 1);
    } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

    return officeDays;
  }

  /**
   * list record by LevId.
   * @param levId to get leave details.
   * @return all leave details.
   */
  public static LeaveDetails listById(final int levId) {
    LeaveDetails es = dao().objectById(levId);
    return es;
  }
  /**
   * list all LeaveHistory details.
   * @param empId to get leave details.
   * @return all leave details.
   */
  public static LeaveDetails[] listAll(final int empId) {
    List<LeaveDetails> es = dao().leaveHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
    *list pending leave details.
    * @param empId to get pending lev details.
    * @return all pending details.
   */
  public static LeaveDetails[] listPending(final int empId) {
    List<LeaveDetails> es = dao().pending(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * @param argLevId to set leave id.
   * @param argEmpMgrId to set ManagerId.
   * @param argStatus to set Approve or Deny.
   * @param argMgrComment to set Manager Responce.
   * @return leave applied statement.
   */
  public static String approveDeny(final int argLevId,
      final int argEmpMgrId,
      final String argStatus,
      final String argMgrComment) {
    String res = "";
    LeaveDetails ld = LeaveDetails.listById(argLevId);
    if (ld == null) {
      res = "Leave Details not found";
      return res;
    } else {
      LeaveStatus levStatus = ld.getLevStatus();
      Date sdate = ld.getLevStartDate();
      Date cur = new Date();
      String leavStatus = "";
      int noDays = ld.getLevNoOfDays();
      int empId = ld.getEmpId();
      Employee ed = Employee.listById(empId);
      int levAvail = ed.getEmpAvlLeaveBal();
      int mgrId = ed.getEmpMgrId();
      System.out.println("Mgr ID  " + mgrId);
      System.out.println(argStatus + " " + sdate + " " + cur);
      if (sdate.compareTo(cur) < 0) {
        res = "Cannot approve or Deny for Past Days";
      } else if (mgrId != argEmpMgrId) {
        res = "You're not authorised to approve/deny the Leave";
      } else if (levStatus == LeaveStatus.APPROVED) {
        if (argStatus.equals("NO")) {
          levAvail = levAvail + noDays;
          res = "ApprovedLeave Rejected Successfully...";
          leavStatus = "DENIED";
          dao().approveDeny(argLevId, leavStatus, argMgrComment);
          edao().update(levAvail, empId);
        } else {
          res = "Already Approved";
        }
      } else if (levStatus == LeaveStatus.DENIED) {
        if (argStatus.equals("YES")) {
          res = "DeniedLeave Approved Successfully...";
          leavStatus = "APPROVED";
          levAvail = levAvail - noDays;
          dao().approveDeny(argLevId, leavStatus, argMgrComment);
          edao().update(levAvail, empId);
        } else {
          res = "Already rejected";
        }
      } else {
        if (argStatus.equals("YES")) {
          res = "Leave Approved Successfully...";
          leavStatus = "APPROVED";
        } else {
          levAvail = levAvail + noDays;
          res = "Leave Rejected";
          leavStatus = "DENIED";
        }
        dao().approveDeny(argLevId, leavStatus, argMgrComment);
        edao().update(levAvail, empId);
      }
      return res;
    }
  }


  /**
   * @param argEmpId to set employee id
   * @param argLevStartDate to set leave start date
   * @param argLevEndDate to set leave end date
   * @param argLevNoOfDays to set leave number of days
   * @param argLevType to set Leave type
   * @param argLevReason to set Leave Reason
   * @return string from apply Leave
   * @throws ParseException in case there is an error in converting data
   */

  public static String applyLeave(final int argEmpId,
                                  final String argLevStartDate,
                                  final String argLevEndDate,
                                  final int argLevNoOfDays,
                                  final LeaveType argLevType,
                                  final String argLevReason,
                                  final String argResponse) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date sdate = sdf.parse(argLevStartDate);
    Date edate = sdf.parse(argLevEndDate);
    int weekend = getWeekend(sdate, edate);
    int officehol = getOffice(sdate, edate);
    Date cur = new Date();
    Calendar calObj = Calendar.getInstance();
    calObj.setTime(edate);
    String appliedOn = sdf.format(cur);
    Date cdate = sdf.parse(appliedOn);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(sdate);
    long ms = edate.getTime() - sdate.getTime();
    long m = ms / (1000 * 24 * 60 * 60);
    int count = dao().count(argEmpId, argLevStartDate, argLevEndDate);
    int days = (int) m;
    String[] ofDates = {"2019-06-15", "2019-09-13", "2019-10-19", "2019-12-25"};
    Calendar ofCal = Calendar.getInstance();
    days = days + 1;
    LeaveStatus leaveStatus;
    String res = "";
    boolean office = true;
    for (int i = 0; i < 4; i++) {
      Date ofDate = sdf.parse(ofDates[i]);
      ofCal.setTime(ofDate);
      if (calObj.equals(ofCal) && calendar.equals(ofCal)) {
        office = false;
        break;
      }
    }
    Employee e = Employee.listById(argEmpId);
    if (e == null) {
      res = "Such employee not found..";
      return res;
    } else if (!office) {
      res = "It is already an office leave.";
      return res;
    } else {
      int levAvail = e.getEmpAvlLeaveBal();
      int lEmpId = e.getEmpId();
      int mgrID = e.getEmpMgrId();
      int dif = levAvail - argLevNoOfDays;
      if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        res = "StartDate cannot be Saturday or Sunday";
      } else if (calObj.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || calObj.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        res = "EndDate cannot be Saturday or Sunday......";
      } else if (days < 0) {
        res = "EndDate Must be Greater Than StartDate...";
      } else if (dif < 0) {
        if (argResponse.equals("YES")) {
        Date doj = e.getEmpJoinDate();
        String dj = sdf.format(doj);
        String cd = sdf.format(cur);
        int mdiff = dao().diffInMonths(cd,dj) / 30;
        int sslCount = dao().sslCount(argEmpId);
        if(mdiff>=6 && sslCount==0) {
          if( mgrID == 0 ) {
            leaveStatus = LeaveStatus.APPROVED;
          res = "Leave approved automatically for " + days + " day(s) with SSL suppport.";
          edao().updateSslBal(argEmpId);
          } else {
          leaveStatus = LeaveStatus.PENDING;
          res = "Leave Applied Successfully for " + days + " day(s) with SSL suppport";
          edao().updateSslBal(argEmpId);
          }
          SslStatus sslSt = SslStatus.YES;
          dao().insertSsl(argEmpId, argLevStartDate, argLevEndDate,
            argLevNoOfDays, argLevType, leaveStatus, sslSt, argLevReason, appliedOn);
        } else {
          res = "Sorry. Either your tenure is less than 6 months or you've already availed SSL in past";
        }
        } else {
        res = "Insufficient Leave Balance...";
        }
      } else if (argLevNoOfDays != days) {
        res = "Enter correct Number of Days as " + days;
      } else if (sdate.compareTo(cdate) < 0) {
        res = " Startdate is less than CurrentDate";
      } else if (count == 1) {
        res = "Already applied on particular date";
      } else {
        days = days - weekend - officehol;
        if (mgrID == 0) {
          leaveStatus = LeaveStatus.APPROVED;
          res = "Leave approved automatically for " + days + " day(s)";
          edao().updateSslBal(argEmpId);
        } else {
          leaveStatus = LeaveStatus.PENDING;
          res = "Leave Applied Successfully for " + days + " day(s)";
        }
        dao().insert(argEmpId, argLevStartDate, argLevEndDate,
            argLevNoOfDays, argLevType, leaveStatus, argLevReason, appliedOn);
        levAvail = levAvail - days;
        // System.out.println("w" + weekend + "  days=" + days);
        edao().update(levAvail, lEmpId);
      }
      return res;
    }
  }
  /**
   * @param argLevId to set employee id
   * @param argLevStartDate to set leave start date
   * @param argLevEndDate to set leave end date
   * @param argLevNoOfDays to set leave number of days
   * @param argLevType to set Leave type
   * @param argLevReason to set Leave Reason
   * @return string from edit Leave
   * @throws ParseException in case there is an error in converting data
   */

  public static String editLeave(final int argLevId,
                                  final String argLevStartDate,
                                  final String argLevEndDate,
                                  final int argLevNoOfDays,
                                  final LeaveType argLevType,
                                  final String argLevReason) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld = LeaveDetails.listById(argLevId);
    String res = "";
    if (ld == null) {
      res = "Leave Details not found";
      return res;
    } else if (ld.getLevStatus() != LeaveStatus.PENDING) {
      res = "You can't edit this leave";
      return res;
    } else {
      int days = ld.getLevNoOfDays();
      int lEmpId1 = ld.getEmpId();
      Date sdate1 = sdf.parse(argLevStartDate);
      Date edate1 = sdf.parse(argLevEndDate);
      int weekend1 = getWeekend(sdate1, edate1);
      int officehol1 = getOffice(sdate1, edate1);
      Date cur1 = new Date();
      Calendar calObj1 = Calendar.getInstance();
      calObj1.setTime(edate1);
      String appliedOn1 = sdf.format(cur1);
      Date cdate1 = sdf.parse(appliedOn1);
      Calendar calendar1 = Calendar.getInstance();
      calendar1.setTime(sdate1);
      long ms1 = edate1.getTime() - sdate1.getTime();
      long m1 = ms1 / (1000 * 24 * 60 * 60);
      int count1 = dao().countEdit(lEmpId1, argLevId, argLevStartDate, argLevEndDate);
      int days1 = (int) m1;
      String[] ofDates1 = {"2019-06-15", "2019-09-13", "2019-10-19", "2019-12-25"};
      Calendar ofCal1 = Calendar.getInstance();
      LeaveStatus leaveStatus1 = LeaveStatus.PENDING;

      boolean office1 = true;
      for (int i = 0; i < 4; i++) {
        Date ofDate1 = sdf.parse(ofDates1[i]);
        ofCal1.setTime(ofDate1);
        if (calObj1.equals(ofCal1) && calendar1.equals(ofCal1)) {
          office1 = false;
          break;
        }
      }
      Employee e1 = Employee.listById(lEmpId1);
      int levAvail1 = e1.getEmpAvlLeaveBal();
      int dif1 = levAvail1 - argLevNoOfDays;
      days1 = days1 + 1;
      // System.out.println("weekend=" + weekend1 + " days=" + days + " days1=" + days1 + " avl=" + levAvail1);
      if (!office1) {
        res = "It is already an office leave.";
        return res;
      } else if (calendar1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || calendar1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        res = "StartDate cannot be Saturday or Sunday";
      } else if (calObj1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || calObj1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        res = "EndDate cannot be Saturday or Sunday......";
      } else if (days1 < 0) {
        res = "EndDate Must be Greater Than StartDate...";
      } else if (dif1 < 0) {
        res = "Insufficient Leave Balance...";
      } else if (argLevNoOfDays != days1) {
        res = "Enter correct Number of Days as " + days1;
      } else if (sdate1.compareTo(cdate1) < 0) {
        res = "Startdate is less than CurrentDate";
      } else if (count1 == 1) {
        res = "Already applied on particular date";
      } else {
        days1 = days1 - weekend1 - officehol1;
        leaveStatus1 = LeaveStatus.PENDING;
        res = "Leave Edited Successfully and applied for " + days1 + " day(s)";
        dao().updateLev(argLevId, argLevStartDate, argLevEndDate,
            argLevNoOfDays, argLevType, leaveStatus1, argLevReason, appliedOn1);
        levAvail1 = levAvail1 - days1 + days;
        edao().update(levAvail1, lEmpId1);
      }
    }
    return res;
  }
}
