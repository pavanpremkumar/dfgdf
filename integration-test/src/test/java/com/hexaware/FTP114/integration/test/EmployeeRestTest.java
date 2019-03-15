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

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = "2018-12-20";
        Date doj = sdf.parse(s1);
		String s2 = "2017-10-15";
		Date doj1 = sdf.parse(s2);
		String s3 = "2018-06-10";
		Date doj2 = sdf.parse(s3);
		String s4 = "2019-01-05";
		Date doj3 = sdf.parse(s4);
		String s5 = "2018-08-25";
		Date doj4 = sdf.parse(s5);

		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		Employee e1000 = new Employee(1000, "SAHIL MATLANI", "SAHIL@GMAIL.COM", "7028365639", doj, 4, "HEXAVARSITY", 0);
		Employee e2000 = new Employee(2000, "KALPANA K", "KALPANA@GMAIL.COM", "9587456125", doj1, 9, "INNOVATION", 1000);
		Employee e3000 = new Employee(3000, "NIREESHA GUPTA", "NIREESHA@GMAIL.COM", "7845123698", doj2, 5, "HEXAVARSITY", 1000);
		Employee e4000 = new Employee(4000, "TAMIL MALAR", "MALAR@GMAIL.COM", "9865321245", doj3, 5, "HEXAVARSITY", 2000);
		Employee e5000 = new Employee(5000, "NIVEDHA", "NIVEDHA@GMAIL.COM", "7845562315", doj4, 10, "HEXAVARSITY", 3000);
		for (Employee e: res) {
			switch (e.getEmpId()) {
				case 1000:
					assertEquals(res[0], e1000);
					break;
				case 2000:
					assertEquals(res[1], e2000);
					break;				
				case 3000:
					assertEquals(res[2], e3000);
					break;				
				case 4000:
					assertEquals(res[3], e4000);
					break;
				case 5000:
					assertEquals(res[4], e5000);
					break;						
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = "2018-12-20";
        Date doj = sdf.parse(s1);
		String s2 = "2017-10-15";
		Date doj1 = sdf.parse(s2);
		String s3 = "2018-06-10";
		Date doj2 = sdf.parse(s3);
		String s4 = "2019-01-05";
		Date doj3 = sdf.parse(s4);
		String s5 = "2018-08-25";
		Date doj4 = sdf.parse(s5);
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		Employee e1000 = new Employee(1000, "SAHIL MATLANI", "SAHIL@GMAIL.COM", "7028365639", doj, 4, "HEXAVARSITY", 0);
		assertEquals(e1000, res);

		Employee res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/2000")).getBody().as(Employee.class);
		Employee e2000 = new Employee(2000, "KALPANA K", "KALPANA@GMAIL.COM", "9587456125", doj1, 9, "INNOVATION", 1000);
		assertEquals(e2000, res1);

		Employee res2 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/3000")).getBody().as(Employee.class);
		Employee e3000 = new Employee(3000, "NIREESHA GUPTA", "NIREESHA@GMAIL.COM", "7845123698", doj2, 5, "HEXAVARSITY", 1000);
		assertEquals(e3000, res2);

		Employee res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/4000")).getBody().as(Employee.class);
		Employee e4000 = new Employee(4000, "TAMIL MALAR", "MALAR@GMAIL.COM", "9865321245", doj3, 5, "HEXAVARSITY", 2000);
		assertEquals(e4000, res3);

		Employee res4 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/5000")).getBody().as(Employee.class);
		Employee e5000 = new Employee(5000, "NIVEDHA", "NIVEDHA@GMAIL.COM", "7845562315", doj4, 10, "HEXAVARSITY", 3000);
		assertEquals(e5000, res4);
  }

  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}
