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

public class DbFakeHPP834EDIchp {
	
	static SimpleDateFormat MDY = new SimpleDateFormat("MM/dd/yyyy");


	public static String findFake(String fieldName, String fieldType, String fieldOrig, Faker faker) {
		
		
		
		//Faker faker = new Faker();
		
		
		String alphanum = "^[a-zA-Z0-9]+$";	
	    String alpha = "^[a-zA-Z]+$";	
	    String numer = "^[0-9]+$";	
	    
		Pattern patnumer = Pattern.compile(numer);
		
		if(fieldName.contentEquals("numeric") || fieldName.contentEquals("alpha")) {
			
			
		int x = 0;

			  Matcher matcher = patnumer.matcher(fieldOrig);
			  //System.out.println(matcher.matches());
			  if(matcher.matches()) fieldName = "numeric" + fieldOrig.length();
			  else fieldName = "alpha" + fieldOrig.length();
	
			  
			  
		}
	/*	if(fieldName.contentEquals("numeric")) {
			fieldName=fieldName + fieldOrig;
		
		}
		if(fieldName.contentEquals("alpha")) {
			fieldName=fieldName + fieldOrig;
		
		}
*/
		
		
		
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
/*
 				System.out.println(rs.getString(1).toUpperCase() + "|" + rs.getString(2).toUpperCase() + "|"
						+ rs.getString(3).toUpperCase() + "|" + rs.getString(4).toUpperCase());
*/				
				retVal = rs.getString(4).toUpperCase();
			}

			conn.close();
			// dbi.closeDS();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(retVal == null) {	
//	Make some fakes
			
//cross map EAC and EDI 
			
			if(fieldName.startsWith("alpha")) {
				
				int fSz = fieldOrig.length();
				
				int fieldSize =  Integer.parseInt(fieldName.substring(5, fieldName.length()));

						String newFake = faker.lorem().fixedString(fSz).replace(' ', '6').replace('.','X').toUpperCase().substring(0, fieldOrig.length());
				
				
//						System.out.println("IN:  " + fieldOrig + "\n   OUT: " + newFake +  " LENGTH " + fSz + ':' + newFake.length());
						
						
						addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;	
			}
		
			if(fieldName.startsWith("numeric")) {
							
				//String newFake = faker.idNumber().validSvSeSsn().toUpperCase().substring(0, Integer.parseInt(fieldName.substring(7, 8)));
				
	//			String newFake = faker.number().digits(Integer.parseInt(fieldName.substring(7, fieldName.length())));
				
				String newFake = faker.number().digits(fieldOrig.length());
				
				//System.out.println("IN: " + fieldOrig + "   OUT: " + newFake +  " LENGTH " + Integer.parseInt(fieldName.substring(7, fieldName.length())));
				
				addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;	
			}

			/*
			if (fieldName.equals("numeric5")) {
				String newFake = Integer.toString(faker.number().numberBetween(7000000, 7999999));
				addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;
			}
			
			if (fieldName.equals("numeric7")) {
				String newFake = Integer.toString(faker.number().numberBetween(7000000, 7999999));
				addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;
			}
			if (fieldName.equals("numeric9")) {
				String newFake = Integer.toString(faker.number().numberBetween(900000000, 999999999));
				addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;
			}
			if (fieldName.equals("numeric10")) {
				String newFake = Integer.toString(faker.number().numberBetween(111111111, 177777777));
				addFake(fieldName, fieldType, fieldOrig, newFake);
				return newFake;
			}
			*/
				
			if (fieldName == "zipExt") {
				String zipExt = Long.toString(faker.number().randomNumber(4, true));
//				addFake(fieldName, fieldType, fieldOrig, newFake);
				return zipExt;
			}
				
			
	//		zipExt
			

/*			
				
	if(fieldName == "CISRID" || fieldName == "numeric7 | numeric9 | numeric10") {	
	String newFake = Integer.toString(faker.number().numberBetween(711111111, 977777777));
	addFake(fieldName, fieldType, fieldOrig, newFake);
	return newFake;
	}
	
*/
			
	if(fieldName == "phone")  {
		
		Random random = new Random();
		String NNX = String.format("%03d", random.nextInt(1000));
		String EXT = String.format("%04d", random.nextInt(10000));

		
		String[] NPAlist = {"215","267","445","610","484","717","223"};
		
		int min=0, max=NPAlist.length-1;
		int ac = random.nextInt((max - min) + 1) + min;
		
		String NPA = NPAlist[ac];
		String phone_number = NPA + NNX + EXT;
		
		//System.out.println(phone_number);
				
//		String NNX = String.valueOf(faker().number().randomDouble(4, 0111, 9876))   ;
//		Double EXT =  ParseDouble(faker().number().randomDouble(4, 0111, 9876));
//		String padded = String.format("%10s",  faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
//if(padded.startsWith("1")) padded = padded.substring(1,10);
//else padded = padded.substring(0,10);
		addFake(fieldName, fieldType, fieldOrig, phone_number);
		return phone_number;

	}
	
	if(fieldName == "lastName")  {
		
		String padded = String.format("%s", faker.name().lastName().toUpperCase());
		addFake(fieldName, fieldType, fieldOrig, padded);
		return padded;

	}
	
if(fieldName == "firstName")  {
		
	String padded = String.format("%s", faker.name().firstName().toUpperCase()); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "middleInitial")  {
	
	String padded = fieldOrig;
	while(padded == fieldOrig) padded = faker.name().firstName().toUpperCase().substring(0,1); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "SSN")  {
	if(fieldOrig.contentEquals("000000000")) return "000000000";
	if(fieldOrig.contentEquals("         ")) return "         ";
	String padded = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

if(fieldName == "addressLine1")  {	
	String padded = faker.address().streetAddress().toUpperCase(); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;
	}
	
if(fieldName == "addressLine2")  {	
	String padded = faker.address().secondaryAddress().toUpperCase(); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;
	}
	
if(fieldName == "City")  {	
	String padded = faker.address().city().toUpperCase(); 
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;
	}
	


if(fieldName == "EmployerName")  {
	
	String padded = String.format("%-14s", faker.name().lastName().toUpperCase());
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

}

/*
  
if(fieldName == "ref0f" )  {
	
	String padded = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}
if(fieldName == "ref3h")  {
	
	String padded = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}
if(fieldName == "refzz")  {
	
	String padded = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
	addFake(fieldName, fieldType, fieldOrig, padded);
	return padded;

	}

*/

if(fieldName == "Street1")  {
	
	String padded = String.format("%-18s", faker.address().streetAddress().toUpperCase()); 
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


