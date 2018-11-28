package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.ust.claimfaker.core.Faker;

public class DbFake {

	public static String findFake(String fieldName, String fieldType, String fieldOrig) {
		
		Faker faker = new Faker();

		String sql = "SELECT fieldName, fieldType, fieldOrig, fieldFake FROM integration.fakery "
				+ "WHERE fieldName = \"" + fieldName + "\"  AND fieldOrig = \"" + fieldOrig + "\"";

		String retVal = null;

		//System.out.println(" sql! " + sql + "\n");

		try {

			dbSource dbi = new dbSource();

			Connection conn = dbi.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
/*				System.out.println(rs.getString(1).toUpperCase() + "|" + rs.getString(2).toUpperCase() + "|"
						+ rs.getString(3).toUpperCase() + "|" + rs.getString(4).toUpperCase());
*/				retVal = rs.getString(4).toUpperCase();
			}

			conn.close();
			// dbi.closeDS();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(retVal == null) {	
//	Make some fakes
	
	if(fieldName == "CISRID") {	
	String newFake = Integer.toString(faker.number().numberBetween(711111111, 977777777));
	addFake(fieldName, fieldType, fieldOrig, newFake);
	return newFake;
	}
	
	if(fieldName == "LastName")  {
		
		String padded = String.format("%-14s", faker.name().lastName().toUpperCase());
		addFake(fieldName, fieldType, fieldOrig, padded);
		return padded;

	}
	
if(fieldName == "FirstName")  {
		
	String padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "MiddleName")  {
	
	String padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "SSN")  {
	
	String padded = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "EmployerName")  {
	
	String padded = String.format("%-14s", faker.name().lastName().toUpperCase());
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

}

if(fieldName == "Street1")  {
	
	String padded = String.format("%-18s", faker.address().streetAddress().toUpperCase()); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}
	
	
	}
		return retVal;

	}

	public static void addFake(String fieldName, String fieldType, String fieldOrig, String fieldFake) {
		
		
		 String sql = "INSERT INTO integration.fakery (fieldName, fieldType, fieldOrig, fieldFake) " +
		         "VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')";
		 
			//System.out.println(" sql! " + sql + "\n");


		 String pssql = "INSERT INTO integration.fakery (fieldName, fieldType, fieldOrig, fieldFake) VALUES (?,?,?,?)";

		 

		

		try {

			dbSource dbi = new dbSource();

			Connection conn = dbi.getConnection();
			//Statement stmt = conn.createStatement();
			
	        java.sql.PreparedStatement ps = conn.prepareStatement(pssql);
	        ps.setString(1, fieldName);
	        ps.setString(2, fieldType);
	        ps.setString(3, fieldOrig);
	        ps.setString(4,fieldFake);	        
	        
	        
			ps.executeUpdate();


		    //stmt.executeUpdate(sql);

			conn.close();
			// dbi.closeDS();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.exit(0);

		} finally {
			

			
		}


	}		
	}


