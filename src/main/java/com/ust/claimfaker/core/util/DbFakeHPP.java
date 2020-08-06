package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ust.claimfaker.core.Faker;

public class DbFakeHPP {
	
	static SimpleDateFormat MDY = new SimpleDateFormat("MM/dd/yyyy");


	public static String findFake(String fieldName, String fieldType, String fieldOrig, Faker faker) {
		
//		String alphanum = "^[a-zA-Z0-9]+$";	
//	    String alpha = "^[a-zA-Z]+$";	
	    String numer = "^[0-9]+$";
	    String zerosAndSpacesOnly = "^[0 ]+$";
	    String repeatedChars = "^(.)\\1+$";
	    
		Pattern patnumer = Pattern.compile(numer);
		String retVal = null;
		String existingFake = null;
		String newFake = null;
		
		int MaxFakeTries = 10;
		int numTries=0;
		
		if (fieldOrig.isEmpty() || fieldOrig.toUpperCase().contentEquals("UNKNOWN") || fieldOrig.toUpperCase().contentEquals("NULL") || fieldOrig.matches(zerosAndSpacesOnly) || fieldOrig.matches(repeatedChars) ) {
//			System.out.println("[" + fieldOrig + "]");
			return fieldOrig;
		}
		
		if (!fieldOrig.trim().contentEquals(fieldOrig)) {
//			System.out.print("Original Field - [" + fieldOrig + "]");
			fieldOrig = fieldOrig.trim();
//			System.out.println("Trimmed Field - [" + fieldOrig + "]");
		}
		
		if(fieldName.contentEquals("numeric") || fieldName.contentEquals("alpha")) {
			
			Matcher matcher = patnumer.matcher(fieldOrig);
			//System.out.println(matcher.matches());
			if(matcher.matches()) {
				fieldName = "numeric" + fieldOrig.length();
			}
			else {
				fieldName = "alpha" + fieldOrig.length();
			}
		
		}
		

		try { // Check database for exiting fake value

			String sql = "SELECT fieldName, fieldType, fieldOrig, fieldFake FROM integration.fakery "
					+ "WHERE fieldName = \"" + fieldName + "\"  AND fieldOrig = \"" + fieldOrig + "\"";

			//System.out.println(" sql! " + sql + "\n");

			dbSource dbi = new dbSource();

			Connection conn = dbi.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				existingFake = rs.getString(4).toUpperCase();
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(existingFake != null)
		{ // Return fake value found in database
			return existingFake;
		}
		else
		{ // Make new fake value
			
			if(fieldName.startsWith("alpha")) {
				
//				int fSz = fieldOrig.length();

				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = faker.bothify(fieldOrig.replaceAll("\\d", "#").replaceAll("[^#]", "?"), true);
//					newFake = faker.lorem().fixedString(fSz).replace(' ', '6').replace('.','X').toUpperCase().substring(0, fieldOrig.length());
					
					if (numTries>1) {
//						System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
					}

				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			}
		
			else if(fieldName.startsWith("numeric")) {
				
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = faker.number().digits(fieldOrig.length());
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );

				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
								
				return newFake;	
				
			}

			else if(fieldName.contentEquals("phone"))  {
				
				Random random = new Random();
				String[] NPAlist = {"215","267","445","610","484","717","223"};
		
				int min=0, ac=0, max=NPAlist.length-1;
		
				String NNX, EXT, NPA;
		
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					NNX = String.format("%03d", random.nextInt(1000));
					EXT = String.format("%04d", random.nextInt(10000));
		
					ac = random.nextInt((max - min) + 1) + min;
					
					NPA = NPAlist[ac];
					newFake = NPA + NNX + EXT;
					
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
		
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
								
				return newFake;	
		
			}
		
			else if(fieldName.contentEquals("lastName"))  {
		
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = String.format("%s", faker.name().lastName().toUpperCase());
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
		
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
		
			}
		
			else if(fieldName.contentEquals("firstName"))  {
				
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = String.format("%s", faker.name().firstName().toUpperCase());
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
			
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			
				}

			else if(fieldName.contentEquals("middleInitial"))  {
				
				return fieldOrig.substring(0,1);
			//	String padded = fieldOrig;
			//	while(padded == fieldOrig) padded = faker.name().firstName().toUpperCase().substring(0,1); 
			//	addFake(fieldName, fieldType, fieldOrig, padded);
			//	return padded;
			
				}


			else if(fieldName.contentEquals("SSN"))  {
			
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					int ssnTries = 0;
					do {
						if (++ssnTries>MaxFakeTries)
						{
							System.out.println("Could not make valid SSN for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
							System.exit(0);
						}
						newFake = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
					} while (!IsValidSSN(newFake));
					
					// System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
			
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			
			}

			else if(fieldName.contentEquals("Street1"))  {
				
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = faker.address().streetAddress().toUpperCase();
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
			
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			
				}

			else if(fieldName.contentEquals("Street2"))  {
				
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = faker.address().secondaryAddress().toUpperCase(); 
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
			
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			
				}
			
			else if(fieldName.contentEquals("City"))  {
				
				do 
				{ 
					if (++numTries>MaxFakeTries)
					{
						System.out.println("Could not make fake for " + fieldName + " : " + fieldOrig + "\nToo many tries! Terminating...");
						System.exit(0);
					}
					
					newFake = faker.address().city().toUpperCase(); 
//					System.out.println("Try " + numTries + ", addding fake for " + fieldName + " : " + fieldOrig + " > " + newFake );
			
				}while (!addFake(fieldName, fieldType, fieldOrig, newFake));
				
				return newFake;	
			
				}
			else 
			{
				System.out.println("Unexpected feild name: " + fieldName + " with value " + fieldOrig + "\nTerminating...");
				System.exit(0);
			}
			
			

/*
if (fieldName == "zipExt") {
String zipExt = Long.toString(faker.number().randomNumber(4, true));
addFake(fieldName, fieldType, fieldOrig, newFake);
return zipExt;
}

if(fieldName == "EmployerName")  {
	
	String padded = String.format("%-14s", faker.name().lastName().toUpperCase());
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

}

if(fieldName == "birthDate")  {
	
	
	  long date = new Date().parse(fieldOrig);  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
	
	DateTimeFormatter formatterx = DateTimeFormat.forPattern("dd/MM/yyyy");
	DateTime dt = formatterx.parseDateTime(fieldOrig);
	
	
//	Date dat = formatter.parseDateTime(fieldOrig);
	
  //  LocalDate dob = LocalDate.parse(fieldOrig, formatter);
    
	//, fieldOrig.substring(3, 2), fieldOrig.substring(0, 2))));      //Birth date
	LocalDate now = new LocalDate();                        //Today's date
	 
//	Period period = new Period(dob, now, PeriodType.yearMonthDay());
	 
//Date age = System.now()-Date.valueOf(fieldOrig);
	
	//java.util.Date FakeDate = faker.date().birthday(period.getYears()-2,  period.getYears()+3 );

// String padded = String.format("%-10s",FakeDate.getDay(),FakeDate.getMonth(),FakeDate.getMinutes());
//addFake(fieldName, fieldType, fieldOrig, padded);
// return padded;
}
*/	
	
		}
		
		return retVal;

	}

	public static Boolean addFake(String fieldName, String fieldType, String fieldOrig, String fieldFake) {

//		System.out.println("In addFake  VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')");
		
		String pssql = "INSERT INTO integration.fakery (fieldName, fieldType, fieldOrig, fieldFake) VALUES (?,?,?,?)";
	
		Connection conn = null;
		
		try {

			dbSource dbi = new dbSource();

			conn = dbi.getConnection();
		
	        java.sql.PreparedStatement ps = conn.prepareStatement(pssql);
	        ps.setString(1, fieldName);
	        ps.setString(2, fieldType);
	        ps.setString(3, fieldOrig);
	        ps.setString(4, fieldFake);
	        
			ps.executeUpdate();

			conn.close();
			
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
//			System.out.println(e.getErrorCode() + " : " + e.getMessage() + "\n");
			
			if (e.getErrorCode() != 1062)
			{
				e.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return false;

			//System.exit(0);

		} finally {
			

			
		}


	}		

	public static Boolean IsValidSSN (String ssn) {
		
		Boolean retVal = false;
		
		if (ssn.length() == 9 && ssn.matches("^[0-9]+$"))  {
			if (!ssn.substring(0,3).contentEquals("000") && !ssn.substring(3,5).contentEquals("00") && !ssn.substring(5,9).contentEquals("0000")) {
				retVal = true;
			}
		}
		return retVal;

	}

}


