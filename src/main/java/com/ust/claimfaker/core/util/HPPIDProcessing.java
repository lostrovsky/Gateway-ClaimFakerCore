package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.text.ChangedCharSetException;

import com.ust.claimfaker.core.Faker;

public class HPPIDProcessing {
	
	public static String medicaidIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$"))  {
			//Medicaid full ID (10 digits) logic
			char checkDigit = idStr.charAt(9);
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(0, idStr.length() - 1),faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, retVal, "MEDICAID");
			retVal = retVal + checkDigit;
		}
		else if (idStr.length() == 9 && idStr.matches("^[0-9]+$"))  {
			//Medicaid Partial ID (9 digits) logic
			char checkDigit = calculateMedicaidCheckDigit(idStr);
			// System.out.println("ID: " + idStr + " Calculated check digit [" + checkDigit + "]");
				
			retVal = DbFakeHPP.findFake("numeric", "String", idStr,faker);
			addToSplitFile(idStr + checkDigit, retVal, retVal + checkDigit, retVal, "MEDICAID");
		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}

	public static String chipIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$") && idStr.startsWith("39"))  {
			//CHIP ID logic
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(1, idStr.length()), faker);
			addToSplitFile(idStr.substring(1, idStr.length()), retVal, "3" + retVal, "3" + retVal, "CHIP");
			retVal = "3" + retVal;

		}
		else if (idStr.length() == 9 && idStr.matches("^[0-9]+$") && idStr.startsWith("9"))  {
			//CHIP Original ID from state (9 digits starts with a 9) logic
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			addToSplitFile(idStr, retVal, "3" + retVal, "3" + retVal, "CHIP");

		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			
		}

		return retVal;

	}

	public static String multiLOBIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$") && idStr.startsWith("39"))  {
			//CHIP ID logic
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(1, idStr.length()), faker);
			addToSplitFile(idStr.substring(1, idStr.length()), retVal, "3" + retVal, "3" + retVal, "CHIP");
			retVal = "3" + retVal;

		}
		else if (idStr.length() == 10 && idStr.matches("^[0-9]+$") && !idStr.startsWith("39"))  {
			//Medicaid full ID (10 digits) logic
			char checkDigit = idStr.charAt(9);
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(0, idStr.length() - 1), faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, retVal, "MEDICAID");
			retVal = retVal + checkDigit;

		}
		else if (idStr.length() == 9 && idStr.matches("^[0-9]+$"))  {
			//Medicaid partial ID (9 digits) logic
			char checkDigit = calculateMedicaidCheckDigit(idStr);
			retVal = DbFakeHPP.findFake("numeric", "String", idStr ,faker);
			addToSplitFile(idStr + checkDigit, retVal, retVal + checkDigit, retVal, "MEDICAID");
			
		}
		else if (idStr.length() == 7 && idStr.matches("^[0-9]+$") && idStr.startsWith("5"))  {
			//Medicare
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			addToSplitFile(idStr, retVal, retVal, retVal, "MEDICARE");

		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			
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

	public static void addToSplitFile (String fieldOrig, String fieldFakePartial, String fieldFakeComplete, String fieldFakeHPPID, String LOB) {

//		System.out.println("In addFake  VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')");
		
		String pssql = "INSERT INTO integration.ids_by_lob (fieldOrig, fieldFakePartial, fieldFakeComplete, fieldFakeHPPID, LOB, targetSystem) VALUES (?,?,?,?,?,?)";

		Connection conn = null;
		
		try {

			dbSource dbi = new dbSource();

			conn = dbi.getConnection();
		
	        java.sql.PreparedStatement ps = conn.prepareStatement(pssql);
	        ps.setString(1, fieldOrig);
	        ps.setString(2, fieldFakePartial);
	        ps.setString(3, fieldFakeComplete);
	        ps.setString(4, fieldFakeHPPID);
	        ps.setString(5, LOB);
	        
	        if (LOB.contentEquals("MEDICAID") || LOB.contentEquals("CHIP")) {
	        	ps.setString(6, "HRP");
	        }
	        else {
	        	ps.setString(6, "MHS");
	        	
	        }
	        
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
