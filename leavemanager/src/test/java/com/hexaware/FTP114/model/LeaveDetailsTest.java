package com.hexaware.FTP114.model;

import com.hexaware.FTP114.persistence.LeaveDetailsDAO;
import com.hexaware.FTP114.persistence.EmployeeDAO;

//import com.hexaware.FTP114.model.LeaveDetails;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for LeaveDetails.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException in case there is an error in constuctor.
   */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // LeaveDetails l100 = new LeaveDetails(100);
    // LeaveDetails l101 = new LeaveDetails(101);
    // assertNotEquals(l100, null);
    // assertNotEquals(l100, new Integer(100));
    // assertEquals(l100, new LeaveDetails(100));
    // assertNotEquals(l101, new LeaveDetails(100));
    // assertEquals(l100.hashCode(), new LeaveDetails(100).hashCode());
    // assertEquals(l100.getLevId(), new LeaveDetails(100).getEmpId());
    // l101.setLevId(100);
    // assertEquals(l101, new LeaveDetails(100));
    LeaveDetails l100 = null;
    LeaveDetails l101 = new LeaveDetails();
    assertNull(l100);
    assertNotNull(l101);
    String s1 = "2019-02-09";
    Date sd = sdf.parse(s1);
    String s2 = "2019-02-10";
    Date ed = sdf.parse(s2);
    String s3 = "2019-02-06";
    Date ad = sdf.parse(s3);
    LeaveType lt1 = LeaveType.valueOf("EL");
    LeaveStatus ls1 = LeaveStatus.valueOf("PENDING");
    LeaveDetails l103 = new LeaveDetails(103, 2, sd, ed, lt1, ls1, "sick", ad, "cool", 2000);
    LeaveDetails l103a = new LeaveDetails(103, 2, sd, ed, lt1, ls1, "sick", ad, "cool", 2000);
    assertEquals(l103.hashCode(), l103a.hashCode());
    assertEquals(103, l103.getLevId());
    assertEquals(2, l103.getLevNoOfDays());
    assertEquals(sd, l103.getLevStartDate());
    assertEquals(ed, l103.getLevEndDate());
    assertEquals(lt1, l103.getLevType());
    assertEquals(ls1, l103.getLevStatus());
    assertEquals("sick", l103.getLevReason());
    assertEquals(ad, l103.getLevApplyDate());
    assertEquals("cool", l103.getLevMgrComments());
    assertEquals(2000, l103.getEmpId());
    LeaveDetails l104 = new LeaveDetails();
    Date sd1 = sdf.parse("2019-02-10");
    Date ed1 = sdf.parse("2019-02-12");
    Date ad1 = sdf.parse("2019-02-08");
    l104.setLevId(104);
    l104.setLevNoOfDays(3);
    l104.setLevStartDate(sd1);
    l104.setLevEndDate(ed1);
    l104.setLevType(lt1);
    l104.setLevStatus(ls1);
    l104.setLevReason("sick");
    l104.setLevApplyDate(ad1);
    l104.setLevMgrComments("YoBro");
    l104.setEmpId(3000);
    assertEquals(104, l104.getLevId());
    assertEquals(3, l104.getLevNoOfDays());
    assertEquals(sd1, l104.getLevStartDate());
    assertEquals(ed1, l104.getLevEndDate());
    assertEquals(lt1, l104.getLevType());
    assertEquals(ls1, l104.getLevStatus());
    assertEquals("sick", l104.getLevReason());
    assertEquals(ad1, l104.getLevApplyDate());
    assertEquals("YoBro", l104.getLevMgrComments());
    assertEquals(3000, l104.getEmpId());
    String res = " LevId:104 Leave No. of days:3 Leave StartDate:2019-02-10"
                +
                " Leave EndDate:2019-02-12 Leave Type:EL Leave Status:PENDING"
                +
                " Leave Reason:sick Leave Apply Date:2019-02-08"
                +
                " Leave Manager Comments:YoBro empId:3000";
    assertEquals(res, l104.toString());
    LeaveDetailsDAO ldao = LeaveDetails.dao();
    assertNotNull(ldao);
    EmployeeDAO ledao = LeaveDetails.edao();
    assertNotNull(ledao);
    assertEquals(l103, l103a);
    assertNotEquals(l103, l104);
    assertNotEquals(l103, l100);
    assertNotEquals(l103, l100);
    Employee e1 = new Employee();
    assertNotEquals(l103, e1);

  }

  /**
  * testing for listall.
  * @param ldao for listall.
  * @throws ParseException when exception occurs.
  */
  @Test
    public final void listAllval(@Mocked final LeaveDetailsDAO ldao) throws ParseException {
    new Expectations() {
        {
          ArrayList<LeaveDetails> ls1 = new ArrayList<LeaveDetails>();
          ArrayList<LeaveDetails> ls2 = new ArrayList<LeaveDetails>();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String s0 = "2019-02-02";
          String s1 = "2019-02-13";
          String s2 = "2019-02-20";
          Date sobj = sdf.parse(s0);
          Date sobj1 = sdf.parse(s1);
          Date sobj2 = sdf.parse(s2);
          Date sobj3 = sdf.parse(s1);
          Date sobj4 = sdf.parse(s0);
          String e0 = "2019-02-03";
          String e1 = "2019-02-13";
          String e2 = "2019-02-22";
          Date eobj = sdf.parse(e0);
          Date eobj1 = sdf.parse(e1);
          Date eobj2 = sdf.parse(e2);
          Date eobj3 = sdf.parse(e1);
          Date eobj4 = sdf.parse(e0);

          LeaveType lt = LeaveType.EL;
          LeaveStatus s = LeaveStatus.PENDING;
          ls1.add(new LeaveDetails(10, 2, sobj, eobj, lt, s, "sick", sobj, "tc", 1));
          ls1.add(new LeaveDetails(12, 1, sobj1, eobj1, lt, s, "Funcn", sobj, "yooo", 1));
          ls1.add(new LeaveDetails(15, 3, sobj2, eobj2, lt, s, "sick", sobj, "ok", 1));
          ls2.add(new LeaveDetails(11, 1, sobj3, eobj3, lt, s, "fgs", sobj, "hg", 2));
          ls2.add(new LeaveDetails(16, 2, sobj4, eobj4, lt, s, "ghh", sobj, "gfu", 2));
          ldao.leaveHistory(1); result = ls1;
          ldao.leaveHistory(2); result = ls2;
        }
      };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };

    LeaveDetails[] lsr1 = LeaveDetails.listAll(1);
    assertEquals(3, lsr1.length);
    LeaveDetails[] lsr2 = LeaveDetails.listAll(2);
    assertEquals(2, lsr2.length);
  }
  /**
  * testing for testApplyLev.
  * @param ldao for LeaveDetailsDAO.
  * @param edao for EmployeeDAO.
  * @throws ParseException when date exception occurs.
  */
  @Test
    public final void testApplyLev(@Mocked final LeaveDetailsDAO ldao, @Mocked final EmployeeDAO edao)
    throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "2020-02-12";
    final Date doj = sdf.parse(s1);
    Date cur = new Date();
    final String today = sdf.format(cur);
    final Employee e100 = new Employee(100, "Sahil", "sahil@gmail.com", "7028365639", doj, 12, "FTP", 0);
    final Employee e105 = new Employee(105, "Shahil", "shahil@gmail.com", "7038365639", doj, 32, "FTP", 100);


    new Expectations() {
      {
        ldao.count(100, "2020-03-05", "2020-03-05"); result = 1;
        ldao.count(100, "2020-02-20", "2020-02-20"); result = 0;
        ldao.count(100, "2019-06-15", "2019-06-15"); result = 0;
        ldao.count(100, "2019-06-14", "2019-06-17"); result = 0;
        // ldao.count(100, "2019-09-11", "2019-09-16"); result = 0;
      }
    };
    new Expectations() {
      {
        ldao.insert(100, "2020-02-18", "2020-02-20", 3, LeaveType.EL, LeaveStatus.APPROVED, "sick", today);
      }
    };
    new Expectations() {
      {
        edao.find(100); result = e100;
        edao.find(105); result = e105;

        edao.find(103); result = null;


      }
    };

    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    String res1 = LeaveDetails.applyLeave(100, "2020-02-18", "2020-02-20", 3, LeaveType.EL, "sick");
    assertEquals(res1, "Leave approved automatically for 3 day(s)");
    String res2 = LeaveDetails.applyLeave(100, "2020-03-05", "2020-03-05", 1, LeaveType.EL, "sick");
    assertEquals(res2, "Already applied on particular date");
    String res3 = LeaveDetails.applyLeave(100, "2020-02-20", "2020-02-20", 1, LeaveType.EL, "sick");
    assertEquals(res3, "Leave approved automatically for 1 day(s)");
    String res4 = LeaveDetails.applyLeave(103, "2020-02-20", "2020-02-20", 1, LeaveType.EL, "sick");
    assertEquals(res4, "Such employee not found..");
    String res5 = LeaveDetails.applyLeave(100, "2020-02-24", "2020-02-20", 5, LeaveType.EL, "sick");
    assertEquals(res5, "EndDate Must be Greater Than StartDate...");
    String res6 = LeaveDetails.applyLeave(100, "2019-02-04", "2019-02-07", 4, LeaveType.EL, "sick");
    assertEquals(res6, " Startdate is less than CurrentDate");
    String res7 = LeaveDetails.applyLeave(100, "2019-04-08", "2019-04-22", 15, LeaveType.EL, "sick");
    assertEquals(res7, "Insufficient Leave Balance...");
    String res8 = LeaveDetails.applyLeave(100, "2020-02-20", "2020-02-20", 3, LeaveType.EL, "sick");
    assertEquals(res8, "Enter correct Number of Days as 1");
    String res9 = LeaveDetails.applyLeave(105, "2020-03-10", "2020-03-10", 1, LeaveType.EL, "sick");
    assertEquals(res9, "Leave Applied Successfully for 1 day(s)");
    String res10 = LeaveDetails.applyLeave(105, "2020-02-08", "2020-02-10", 3, LeaveType.EL, "sick");
    assertEquals(res10, "StartDate cannot be Saturday or Sunday");
    String res11 = LeaveDetails.applyLeave(105, "2020-02-14", "2020-02-15", 2, LeaveType.EL, "sick");
    assertEquals(res11, "EndDate cannot be Saturday or Sunday......");
    String res12 = LeaveDetails.applyLeave(100, "2019-06-15", "2019-06-15", 1, LeaveType.EL, "sick");
    assertEquals(res12, "It is already an office leave.");
    String res13 = LeaveDetails.applyLeave(100, "2019-06-14", "2019-06-17", 4, LeaveType.EL, "sick");
    assertEquals(res13, "Leave approved automatically for 2 day(s)");
    String res14 = LeaveDetails.applyLeave(100, "2019-09-13", "2019-09-13", 1, LeaveType.EL, "sick");
    assertEquals(res14, "It is already an office leave.");
  }

  /**
  * testing for testEditLev.
  * @param ldao for LeaveDetailsDAO.
  * @param edao for EmployeeDAO.
  * @throws ParseException when date exception occurs.
  */
  @Test
    public final void testEditLev(@Mocked final LeaveDetailsDAO ldao, @Mocked final EmployeeDAO edao)
    throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "2020-02-12";
    final Date doj = sdf.parse(s1);
    final String s2 = "2020-02-13";
    final Date sd = sdf.parse(s2);
    final String s3 = "2020-02-14";
    final Date ed = sdf.parse(s3);
    LeaveType lt = LeaveType.EL;
    LeaveStatus ls = LeaveStatus.PENDING;
    LeaveStatus ld = LeaveStatus.DENIED;
    Date cur = new Date();
    String appliedOn = sdf.format(cur);
    Date cdate = sdf.parse(appliedOn);
    final String today = sdf.format(cur);
    final Employee e100 = new Employee(100, "Sahil", "sahil@gmail.com", "7028365639", doj, 12, "FTP", 0);
    final Employee e105 = new Employee(105, "Shahil", "shahil@gmail.com", "7038365639", doj, 10, "FTP", 100);
    final LeaveDetails l1 = new LeaveDetails(1, 2, sd, ed, lt, ls, "sick", doj, "TC", 105);
    final LeaveDetails l2 = new LeaveDetails(2, 2, sd, ed, lt, ld, "sick", doj, "TC", 105);


    new Expectations() {
      {
        ldao.countEdit(105, 1, "2020-03-05", "2020-03-05"); result = 0;
        ldao.countEdit(105, 1, "2020-03-04", "2020-03-04"); result = 1;
      }
    };
    new Expectations() {
      {
        ldao.updateLev(1, "2020-02-18", "2020-02-20", 3, LeaveType.EL, LeaveStatus.PENDING, "sick", today);
      }
    };
    new Expectations() {
      {
        ldao.objectById(1); result = l1;
        ldao.objectById(2); result = l2;
        edao.find(105); result = e105;
        ldao.objectById(5); result = null;
        // edao.find(103); result = null;


      }
    };

    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    String res1 = LeaveDetails.editLeave(1, "2020-02-18", "2020-02-20", 3, LeaveType.EL, "sick");
    assertEquals(res1, "Leave Edited Successfully and applied for 3 day(s)");
    String res2 = LeaveDetails.editLeave(1, "2020-03-05", "2020-03-05", 1, LeaveType.EL, "sick");
    assertEquals(res2, "Leave Edited Successfully and applied for 1 day(s)");
    String res3 = LeaveDetails.editLeave(5, "2020-02-18", "2020-02-20", 3, LeaveType.EL, "sick");
    assertEquals(res3, "Leave Details not found");
    String res5 = LeaveDetails.editLeave(1, "2020-02-20", "2020-02-18", 3, LeaveType.EL, "sick");
    assertEquals(res5, "EndDate Must be Greater Than StartDate...");
    String res6 = LeaveDetails.editLeave(1, "2019-02-04", "2019-02-07", 4, LeaveType.EL, "sick");
    assertEquals(res6, " Startdate is less than CurrentDate");
    String res7 = LeaveDetails.editLeave(1, "2019-04-08", "2019-04-22", 11, LeaveType.EL, "sick");
    assertEquals(res7, "Insufficient Leave Balance...");
    String res8 = LeaveDetails.editLeave(1, "2020-02-20", "2020-02-20", 3, LeaveType.EL, "sick");
    assertEquals(res8, "Enter correct Number of Days as 1");
    String res9 = LeaveDetails.editLeave(2, "2020-03-10", "2020-03-10", 1, LeaveType.EL, "sick");
    assertEquals(res9, "You can't edit this leave");
    String res10 = LeaveDetails.editLeave(1, "2020-02-08", "2020-02-10", 3, LeaveType.EL, "sick");
    assertEquals(res10, "StartDate cannot be Saturday or Sunday");
    String res11 = LeaveDetails.editLeave(1, "2020-02-14", "2020-02-15", 2, LeaveType.EL, "sick");
    assertEquals(res11, "EndDate cannot be Saturday or Sunday......");
    String res12 = LeaveDetails.editLeave(1, "2020-03-04", "2020-03-04", 1, LeaveType.EL, "sick");
    assertEquals(res12, "Already applied on particular date");
    String res14 = LeaveDetails.editLeave(1, "2019-09-13", "2019-09-13", 1, LeaveType.EL, "sick");
    assertEquals(res14, "It is already an office leave.");
  }

/**
 * Test class for LeaveDetails pending function.
 * @param dao mocking the dao class.
 */
  @Test
  public final void testPending(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.pending(100);
        result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
    LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listPending(100);
    assertEquals(0, es.length);
  }
 /**
  * Tests that a list with some LeaveDetails is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException when Exception occcurs.
  */
  @Test
 public final void testListAllPending(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s4 = "2020-02-02";
    final Date doj = sdf.parse(s4);
    final String s1 = "2020-02-09";
    final Date sd = sdf.parse(s1);
    final String s2 = "2020-02-10";
    final Date ed = sdf.parse(s2);
    final String s3 = "2020-02-01";
    final Date ad = sdf.parse(s3);
    final ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
    LeaveType lt1 = LeaveType.valueOf("EL");
    LeaveStatus ls1 = LeaveStatus.valueOf("PENDING");
    es.add(new LeaveDetails(1, 5, doj, doj, lt1, ls1, "sick", ad, "TC", 100));
    es.add(new LeaveDetails(2, 10, sd, ed, lt1, ls1, "sick", ad, "TC", 100));
    es.add(new LeaveDetails(3, 15, doj, sd, lt1, ls1, "sick", ad, "TC", 100));
    new Expectations() {
      {
        dao.pending(100);
        result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    final LeaveDetails[] es1 = LeaveDetails.listPending(100);
    assertEquals(3, es1.length);
    assertEquals(new LeaveDetails(1, 5, doj, doj, lt1, ls1, "sick", ad, "TC", 100), es1[0]);
    assertEquals(new LeaveDetails(2, 10, sd, ed, lt1, ls1, "sick", ad, "TC", 100), es1[1]);
    assertEquals(new LeaveDetails(3, 15, doj, sd, lt1, ls1, "sick", ad, "TC", 100), es1[2]);
  }

  /**
  * testing for testApprovedeny.
  * @param ldao for LeaveDetailsDAO.
  * @param edao for EmployeeDAO.
  * @throws ParseException when date exception occurs.
  */
  @Test
    public final void testApprovedeny(@Mocked final LeaveDetailsDAO ldao, @Mocked final EmployeeDAO edao)
    throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "2020-02-01";
    final Date doj = sdf.parse(s1);
    final String s0 = "2020-02-03";
    final Date sobj = sdf.parse(s0);
    final LeaveType lt = LeaveType.EL;
    LeaveStatus s = LeaveStatus.PENDING;
    LeaveStatus sa = LeaveStatus.APPROVED;
    LeaveStatus sd = LeaveStatus.DENIED;
    final String sc0 = "2019-02-03";
    final Date scobj = sdf.parse(sc0);
    final Employee e100 = new Employee(100, "Sahil", "sahil@gmail.com", "7028365639", doj, 12, "FTP", 1);
    final LeaveDetails l100 = new LeaveDetails(10, 1, sobj, sobj, lt, s, "sick", sobj, "tc", 100);
    final LeaveDetails l101 = new LeaveDetails(11, 1, sobj, sobj, lt, sa, "sick", sobj, "tc", 100);
    final LeaveDetails l102 = new LeaveDetails(12, 1, sobj, sobj, lt, sd, "sick", sobj, "tc", 100);
    // final LeaveDetails l103 = new LeaveDetails(13, 1, sobj, sobj, lt, sa, "sick", sobj, "tc", 100);
    // final LeaveDetails l104 = new LeaveDetails(14, 1, sobj, sobj, lt, sd, "sick", sobj, "tc", 100);

    new Expectations() {
      {
        ldao.objectById(10); result = l100;
        ldao.objectById(17); result = null;
        ldao.objectById(11); result = l101;
        ldao.objectById(12); result = l102;
        // ldao.objectById(13); result = l103;
        // ldao.objectById(14); result = l104;
      }
    };
    new Expectations() {
      {
        edao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        ldao.approveDeny(10, "APPROVED", "happy");
        ldao.approveDeny(11, "DENIED", "Sorry");
        // ldao.approveDeny(13, "APPROVED", "En");
      }
    };
    new Expectations() {
      {
        ldao.approveDeny(10, "DENIED", "happy");
        ldao.approveDeny(12, "APPROVED", "Enjoy");
        // ldao.approveDeny(14, "DENIED", "happy");
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return ldao;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    String res1 = LeaveDetails.approveDeny(10, 1, "YES", "happy");
    assertEquals(res1, "Leave Approved Successfully...");
    String res2 = LeaveDetails.approveDeny(17, 1, "YES", "happy");
    assertEquals(res2, "Leave Details not found");
    String res3 = LeaveDetails.approveDeny(10, 1, "NO", "happy");
    assertEquals(res3, "Leave Rejected");
    String res4 = LeaveDetails.approveDeny(10, 78, "YES", "happy");
    assertEquals(res4, "You're not authorised to approve/deny the Leave");
    String res5 = LeaveDetails.approveDeny(10, 1, "YES", "happy");
    assertEquals(res5, "Leave Approved Successfully...");
    String res6 = LeaveDetails.approveDeny(11, 1, "NO", "Sorry");
    assertEquals(res6, "ApprovedLeave Rejected Successfully...");
    // String res33 = LeaveDetails.approveDeny(130, 1, "NO", "Sorry");
    // assertEquals(res33, "Cannot approve or Deny for Past Days");
    String res7 = LeaveDetails.approveDeny(12, 1, "YES", "Enjoy");
    assertEquals(res7, "DeniedLeave Approved Successfully...");
    // String res9 = LeaveDetails.approveDeny(13, 1, "YES", "En");
    // assertEquals(res9, "Already Approved");
    // String res8 = LeaveDetails.approveDeny(14, 1, "NO", "happy");
    // assertEquals(res8, "Already rejected");
  }
}
