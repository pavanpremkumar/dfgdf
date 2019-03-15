package com.hexaware.FTP114.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {

	@Test
	public void testLeaveDetailsList() throws AssertionError, URISyntaxException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = "2019-02-03";
        Date doj = sdf.parse(s1);
		String s2 = "2019-02-03";
		Date doj1 = sdf.parse(s2);
		String s3 = "2019-02-01";
		Date doj2 = sdf.parse(s3);
		String s4 = "2019-01-05";
		Date doj3 = sdf.parse(s4);
		String s5 = "2018-08-25";
		Date doj4 = sdf.parse(s5);
        

		LeaveDetails res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leave/1")).getBody().as(LeaveDetails.class);
        LeaveDetails l1 = new LeaveDetails(1, 1, doj, doj2, LeaveType.EL, LeaveStatus.PENDING, "", doj2, null, 1000);
			switch (l1.getLevId()) {
				case 1000:
					assertEquals(res, l1);
					break;
		
			}
    }

    @Test 
    public void testLeaveHistory() throws AssertionError, URISyntaxException,ParseException { 
              
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
    final String s1 = "2019-03-03";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-03";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-01";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/history/1000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(2, 1, s, e, LeaveType.EL, LeaveStatus.PENDING, "sick", l, null, 1000);
           assertEquals(res[1].getLevId(), l2.getLevId());
    }

    @Test
	public void testPendingLeaves() throws AssertionError, URISyntaxException,ParseException { 
              
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
    final String s1 = "2019-03-29";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-29";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-03-07";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/pending/1000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(4, 1, s, e, LeaveType.PL, LeaveStatus.PENDING, "njk", l, null, 2000);
           assertEquals(res[0].getLevId(), l2.getLevId());
    }

    @Test
	public void testLeaveDetailsById() throws AssertionError, URISyntaxException,ParseException { 
        LeaveDetails res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leave/1")).getBody().as(LeaveDetails.class);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-02-03";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-02-03";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-01";
    final Date l = sdf.parse(s3);

    LeaveDetails l1 = new LeaveDetails(1, 1, s, e, LeaveType.EL, LeaveStatus.PENDING, "", l, null, 1000);
    assertEquals(l1.getLevId(), res.getLevId());
     assertEquals(l1.getEmpId(), res.getEmpId());
      assertEquals(l1.getLevNoOfDays(), res.getLevNoOfDays());
         assertEquals(l1.getLevType(), res.getLevType());
          assertEquals(l1.getLevStatus(), res.getLevStatus());
           assertEquals(l1.getLevReason(), res.getLevReason());
             assertEquals(l1.getLevMgrComments(), res.getLevMgrComments());

        LeaveDetails res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leave/2")).getBody().as(LeaveDetails.class);
        
          final String s11 = "2019-03-03";
    final Date sd1 = sdf.parse(s11);
    final String s21 = "2019-03-03";
    final Date ed1 = sdf.parse(s21);
    final String s31 = "2019-02-01";
    final Date ld1 = sdf.parse(s31);

    LeaveDetails l2 = new LeaveDetails(2, 1, sd1, ed1, LeaveType.EL, LeaveStatus.PENDING, "sick", ld1, null, 1000);
    assertEquals(l2.getLevId(), res1.getLevId());
     assertEquals(l2.getEmpId(), res1.getEmpId());
      assertEquals(l2.getLevNoOfDays(), res1.getLevNoOfDays());
         assertEquals(l2.getLevType(), res1.getLevType());
          assertEquals(l2.getLevStatus(), res1.getLevStatus());
           assertEquals(l2.getLevReason(), res1.getLevReason());
             assertEquals(l2.getLevMgrComments(), res1.getLevMgrComments());

            LeaveDetails res2 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leave/3")).getBody().as(LeaveDetails.class);
        
          final String s12 = "2019-04-04";
    final Date sd2 = sdf.parse(s12);
    final String s22 = "2019-04-04";
    final Date ed2 = sdf.parse(s22);
    final String s32 = "2019-02-01";
    final Date ld2 = sdf.parse(s32);

    LeaveDetails l3 = new LeaveDetails(3, 1, sd2, ed2, LeaveType.EL, LeaveStatus.DENIED, "sick", ld2, "gc", 2000);
    assertEquals(l3.getLevId(), res2.getLevId());
     assertEquals(l3.getEmpId(), res2.getEmpId());
      assertEquals(l3.getLevNoOfDays(), res2.getLevNoOfDays());
         assertEquals(l3.getLevType(), res2.getLevType());
          assertEquals(l3.getLevStatus(), res2.getLevStatus());
           assertEquals(l3.getLevReason(), res2.getLevReason());
             assertEquals(l3.getLevMgrComments(), res2.getLevMgrComments());
            
            LeaveDetails res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leave/6")).getBody().as(LeaveDetails.class);
        
          final String s13 = "2019-12-12";
    final Date sd3 = sdf.parse(s13);
    final String s23 = "2019-12-12";
    final Date ed3 = sdf.parse(s23);
    final String s33 = "2019-02-01";
    final Date ld3 = sdf.parse(s33);

    LeaveDetails l4 = new LeaveDetails(6, 1, sd3, ed3, LeaveType.EL, LeaveStatus.APPROVED, "sick", ld2, "ygug", 2000);
    assertEquals(l4.getLevId(), res3.getLevId());
     assertEquals(l4.getEmpId(), res3.getEmpId());
      assertEquals(l4.getLevNoOfDays(), res3.getLevNoOfDays());
         assertEquals(l4.getLevType(), res3.getLevType());
          assertEquals(l4.getLevStatus(), res3.getLevStatus());
           assertEquals(l4.getLevReason(), res3.getLevReason());
             assertEquals(l4.getLevMgrComments(), res3.getLevMgrComments());

    }

    @Test
    public void testApproveDeny() throws AssertionError, URISyntaxException {
        // String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"levId\":\"9\",\"levMgrComments\":\"Enjoy\"}").
        // when().post(CommonUtil.getURI("/api/leavedetails/approveDeny/1000/YES")).getBody().asString();
        // assertEquals("Already Approved", res1);

        String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"levId\":\"4\",\"levMgrComments\":\"Enjoy\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/approveDeny/2000/YES")).getBody().asString();
        assertEquals("You're not authorised to approve/deny the Leave", res2);
    }

    @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {

        
     String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"1\",\"levStartDate\":\"2019-12-04\",\"levEndDate\":\"2019-12-05\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/3000")).getBody().asString();
     assertEquals("Enter correct Number of Days as 2", res1);

     String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"1\",\"levStartDate\":\"2019-10-04\",\"levEndDate\":\"2019-10-02\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals("EndDate Must be Greater Than StartDate...", res2);

     String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"2\",\"levStartDate\":\"2019-03-22\",\"levEndDate\":\"2019-03-23\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals("EndDate cannot be Saturday or Sunday......", res3);

     String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"2\",\"levStartDate\":\"2019-03-24\",\"levEndDate\":\"2019-03-25\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals("StartDate cannot be Saturday or Sunday", res4);

     String res5=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"1\",\"levStartDate\":\"2019-03-29\",\"levEndDate\":\"2019-03-29\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals("Already applied on particular date", res5);

     String res6=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"5\",\"levStartDate\":\"2019-03-11\",\"levEndDate\":\"2019-03-15\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals(" Startdate is less than CurrentDate", res6);

     String res7=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"15\",\"levStartDate\":\"2019-03-15\",\"levEndDate\":\"2019-03-29\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/2000")).getBody().asString();
     assertEquals("Insufficient Leave Balance...", res7);

     String res8=given().accept(ContentType.JSON).contentType("application/json").body("{\"levNoOfDays\":\"1\",\"levStartDate\":\"2019-09-13\",\"levEndDate\":\"2019-09-13\",\"levType\":\"EL\",\"levReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/appLeave/5000")).getBody().asString();
     assertEquals("It is already an office leave.", res8);
    }
}