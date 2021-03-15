package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.ust.claimfaker.core.Faker;

public class GHPIDProcessing {
	
	public static String medicaidRecepientIDFake (String idStr, Faker faker) {

		String retVal = null;
		
//		idStr = idStr.trim();
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$"))  {
			//Medicaid full ID (10 digits) fake logic
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			addToSplitFile("Medicaid_Recepient_ID", idStr, retVal, "MEDICAID");
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}

	public static String medicaidRecepientIDAddCheckDigitFake (String idStr, Faker faker) {

		String retVal = null;
		char checkDigit;
		
		if (idStr.length() == 9 && idStr.matches("^[0-9]+$")  && !idStr.matches("^(.)\\1+$"))  {
			//Medicaid ID add check digit logic and fake logic
			checkDigit = calculateMedicaidCheckDigit(idStr);
			idStr =  idStr.concat(String.valueOf(checkDigit));
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			addToSplitFile("Medicaid_Recepient_ID", idStr, retVal, "MEDICAID");
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}
	
	public static char calculateMedicaidCheckDigit (String idStr)
	{
		String checkDigitString = "";
		double checkDigitSum = 0;
		char checkDigit = '0';
		int i = 0;
				
		for (i = 0; i <= 8; i++) {
			
			if (i % 2 == 0) {
				checkDigitString=checkDigitString.concat(Integer.toString(2*Character.getNumericValue(idStr.charAt(i))));
			}
			else {
				checkDigitString=checkDigitString.concat(Integer.toString(Character.getNumericValue(idStr.charAt(i))));
			}
		}

		for (i = 0; i < checkDigitString.length(); i++) {
			checkDigitSum += (double)Character.getNumericValue(checkDigitString.charAt(i));
		}
		
		checkDigit = Character.forDigit((int)(Math.ceil(checkDigitSum/10)*10-checkDigitSum),10);
		
		return checkDigit;
	}

/* --- Old member id fake method
	public static String gatweayMemberIDFake (String idStr, Faker faker) {

		String retVal = null;

		idStr = idStr.trim();

		if (idStr.length() == 8 && idStr.matches("^[0-9]+$"))  {
			//Gateway (8 digits) fake logic
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			addToSplitFile("Gateway_Member_ID", idStr, retVal, "ANY");
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}
*/	
	
	public static String gatweayMemberIDFake (String idStr, Faker faker) {

		String retVal = null;

		idStr = idStr.trim();

		if (idStr.length() == 8 && idStr.matches("^[0-9]+$") && idStr.startsWith("7"))  {
			//Gateway (8 digits) fake logic most likely to be medicare id
			retVal = gatweayMedicareMemberIDFake (idStr, faker);
		}
		else if (idStr.length() == 8 && idStr.matches("^[0-9]+$") && (idStr.startsWith("2") || idStr.startsWith("1") || idStr.startsWith("0")))  {
			//Gateway (8 digits) fake logic likely to be medicaid id
			retVal = gatweayMedicaidMemberIDFake(idStr, faker);
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}	
	
	
	public static String gatweayMedicareMemberIDFake (String idStr, Faker faker) {

		String retVal = null;

		idStr = idStr.trim();

		if (idStr.length() == 8 && idStr.matches("^[0-9]+$"))  {
//			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			retVal = DbFakeGHP.findFakeGatewayMemberId(idStr, faker, 70000001, 70999999);
			addToSplitFile("Gateway_Member_ID", idStr, retVal, "MEDICARE");
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}
	
	public static String gatweayMedicaidMemberIDFake (String idStr, Faker faker) {

		String retVal = null;

		idStr = idStr.trim();

		if (idStr.length() == 8 && idStr.matches("^[0-9]+$"))  {
//			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			retVal = DbFakeGHP.findFakeGatewayMemberId(idStr, faker, 30000001, 39999999);
			addToSplitFile("Gateway_Member_ID", idStr, retVal, "MEDICAID");
		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}
	
	
	
	
/*
	public static String multiLOBIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$") && idStr.startsWith("39"))  {
			//CHIP ID logic
			retVal = DbFakeGHP.findFake("numeric", "String", idStr.substring(1, idStr.length()), faker);
			addToSplitFile(idStr.substring(1, idStr.length()), retVal, "3" + retVal, "3" + retVal, "CHIP");
			retVal = "3" + retVal;

		}
		else if (idStr.length() == 10 && idStr.matches("^[0-9]+$") && !idStr.startsWith("39"))  {
			//Medicaid full ID (10 digits) logic
			char checkDigit = idStr.charAt(9);
			retVal = DbFakeGHP.findFake("numeric", "String", idStr.substring(0, idStr.length() - 1), faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, retVal, "MEDICAID");
			retVal = retVal + checkDigit;

		}
		else if (idStr.length() == 9 && idStr.matches("^[0-9]+$"))  {
			//Medicaid partial ID (9 digits) logic
			char checkDigit = calculateMedicaidCheckDigit(idStr);
			retVal = DbFakeGHP.findFake("numeric", "String", idStr ,faker);
			addToSplitFile(idStr + checkDigit, retVal, retVal + checkDigit, retVal, "MEDICAID");
			
		}
		else if (idStr.length() == 7 && idStr.matches("^[0-9]+$") && idStr.startsWith("5"))  {
			//Medicare
			retVal = DbFakeGHP.findFake("numeric", "String", idStr, faker);
			addToSplitFile(idStr, retVal, retVal, retVal, "MEDICARE");

		}
		else  {
			retVal = DbFakeGHP.findFake("numeric", "String", idStr, faker);
			
		}

		return retVal;

	}
	
	public static char calculateMedicaidCheckDigit (String idStr)
	{
		String checkDigitString = "";
		double checkDigitSum = 0;
		char checkDigit = '0';
		int i = 0;
				
		for (i = 0; i <= 8; i++) {
			
			if (i % 2 == 0) {
				checkDigitString=checkDigitString.concat(Integer.toString(2*Character.getNumericValue(idStr.charAt(i))));
			}
			else {
				checkDigitString=checkDigitString.concat(Integer.toString(Character.getNumericValue(idStr.charAt(i))));
			}
		}

		for (i = 0; i < checkDigitString.length(); i++) {
			checkDigitSum += (double)Character.getNumericValue(checkDigitString.charAt(i));
		}
		
		checkDigit = Character.forDigit((int)(Math.ceil(checkDigitSum/10)*10-checkDigitSum),10);
		
		return checkDigit;
	}
*/
	
	public static void addToSplitFile (String idType, String fieldOrig, String fieldFake, String LOB) {

//		System.out.println("In addFake  VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')");
		
		String pssql = "INSERT INTO integration.ids_by_lob (idType, fieldOrig, fieldFake, LOB, targetSystem) VALUES (?,?,?,?,?)";

		Connection conn = null;
		
		try {

			dbSource dbi = new dbSource();

			conn = dbi.getConnection();
		
	        java.sql.PreparedStatement ps = conn.prepareStatement(pssql);
	        ps.setString(1, idType);
	        ps.setString(2, fieldOrig);
	        ps.setString(3, fieldFake);
	        ps.setString(4, LOB);
	        
	        ps.setString(5, "HRP");
/*	        
	        if (LOB.contentEquals("MEDICAID")) {
	        	ps.setString(5, "HRP");
	        }
	        else {
	        	ps.setString(5, "DST");
	        }
*/	        
			ps.executeUpdate();

			conn.close();


		} catch (SQLException e) {
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
			
			//System.exit(0);

		} finally {
			
		}

	}		

}
