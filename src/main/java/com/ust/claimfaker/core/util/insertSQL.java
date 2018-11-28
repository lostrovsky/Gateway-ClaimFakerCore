package com.ust.claimfaker.core.util;
import java.sql.*;
import java.util.*;

import com.ust.claimfaker.core.Address;
import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.util.personModel;




public class insertSQL {


//STEP 1: Import required packages

//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost:3306/integration"; 
//Database credentials
static final String USER = "integration";
static final String PASS = "integration";

public static String fakeField(String fieldName, String fieldType, String fieldOrig ) {
 Connection conn = null;
 Statement stmt = null;
 
 
	Faker faker = new Faker();

	String name = faker.name().fullName();
	String fakeFirstName = faker.name().firstName();
	String fieldFake=fakeFirstName;

	
 // fieldName = null, fieldType = null, fieldOrig = null, fieldFake=null;

 try {
     // STEP 2: Register JDBC driver
     Class.forName("com.mysql.jdbc.Driver");

     // STEP 3: Open a connection
     System.out.print("\nConnecting to database...");
     conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println(" SUCCESS!\n");

       System.out.print("\nInserting records into table...");
     stmt = conn.createStatement();
     
     //Add person
     String sql = "INSERT INTO integration.fakery (fieldName, fieldType, fieldOrig, fieldFake) " +
         "VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')";
     System.out.println(" sql! " + sql + "\n");

     stmt.executeUpdate(sql);

     System.out.println(" SUCCESS!\n");

 } catch(SQLException se) {
     se.printStackTrace();
 } catch(Exception e) {
     e.printStackTrace();
 } finally {
     try {
         if(stmt != null)
             conn.close();
     } catch(SQLException se) {
     }
     try {
         if(conn != null)
             conn.close();
     } catch(SQLException se) {
         se.printStackTrace();
     }
 }
 System.out.println("RecordSaved");
 return fieldFake;
}

public static String[] getAddress() {
	
	Faker faker = new Faker();
	
	String[] fakeAddress = new String[7];
	fakeAddress[0] = faker.address().streetAddress();
	fakeAddress[1] =  faker.address().secondaryAddress();
	fakeAddress[2] = faker.address().cityName();
	fakeAddress[3] = faker.address().stateAbbr();
	fakeAddress[4] = faker.address().zipCodeByState(fakeAddress[3]);
	fakeAddress[5] = faker.number().digits(4);
	String homePhone = faker.phoneNumber().phoneNumber();
	fakeAddress[6] = homePhone;

	
	for(int i = 0;i < fakeAddress.length;++i)
		{
System.out.println(fakeAddress[i]);		
}

	
	/*
	
	String streetAddress = thisAddress.streetAddress();
	String streetAddress2 = thisAddress.secondaryAddress();
	String City = thisAddress.cityName();
	String State = thisAddress.stateAbbr();

	String zipCode = faker.address().zipCode();
	String homePhone = faker.phoneNumber().phoneNumber();
	String cellPhone = faker.phoneNumber().cellPhone();
	
	*/

	//String emailAddress = faker.internet().emailAddress();
	
//System.out.println(firstName + " " + middleInitial + " " + lastName + "(" + middleName + ")" + "," + ssN + "\n"
//	+ streetAddress + ",\n" + streetAddress2 + ",\n" + City + ", " + State + "\n" + zipCode + "\n"
//
//			+ homePhone + ",\n" + cellPhone + ",\n"

//			+ emailAddress);
	
	
	//String xx = storeDB("eeeeek");
	
//	newThing = insertSQL.fakeField("firstName", "String", firstName);
//	System.out.println("Oldthing: " + firstName + " NewThing: " + newThing);
	
	return fakeAddress;


	

}

public static personModel getPerson() {
	
	Faker faker = new Faker();
	
	personModel thisOne = new personModel();
	
	thisOne.name = faker.name().fullName();
	thisOne.firstName = faker.name().firstName();
	thisOne.lastName = faker.name().lastName();
	thisOne.middleName = faker.name().firstName();
	thisOne.middleInitial = thisOne.middleName.substring(0, 1).toUpperCase();
	thisOne.ssN = faker.idNumber().ssnValid();
	thisOne.cellPhone = faker.phoneNumber().cellPhone();
	thisOne.emailAddress = faker.internet().emailAddress();

	
	return thisOne;

	
}

}