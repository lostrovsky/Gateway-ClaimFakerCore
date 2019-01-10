package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.ust.claimfaker.core.Faker;

public class IDProcessing {
	
	public static String medicaidIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.matches("^[0-9]+$"))  {
			//Medicaid full ID (10 digits) logic
			char checkDigit = idStr.charAt(9);
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(0, idStr.length() - 1),faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, "MEDICAID");
			retVal = retVal + checkDigit;

		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr,faker);
			
		}

		return retVal;

	}

	public static String chipIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 9 && idStr.matches("^[0-9]+$") && idStr.startsWith("9"))  {
			//CHIP Original ID from state (9 digits starts with a 9) logic
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			addToSplitFile(idStr, retVal, "3" + retVal, "CHIP");

		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			
		}

		return retVal;

	}

	public static String multiLOBIDFake (String idStr, Faker faker) {

		String retVal = null;
		
		if (idStr.length() == 10 && idStr.startsWith("3") && idStr.matches("^[0-9]+$"))  {
			//CHIP ID logic
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(1, idStr.length()), faker);
			addToSplitFile(idStr, retVal, "3" + retVal, "CHIP");
			retVal = "3" + retVal;

		}
		else if (idStr.length() == 10 && !idStr.startsWith("3") && idStr.matches("^[0-9]+$"))  {
			//Medicaid full ID (10 digits) logic
			char checkDigit = idStr.charAt(9);
			retVal = DbFakeHPP.findFake("numeric", "String", idStr.substring(0, idStr.length() - 1), faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, "MEDICAID");
			retVal = retVal + checkDigit;

		}
		else if (idStr.length() == 9 && idStr.matches("^[0-9]+$"))  {
			//Medicaid partial ID (9 digits) logic
			char checkDigit = 'X';
			retVal = DbFakeHPP.findFake("numeric", "String", idStr ,faker);
			addToSplitFile(idStr, retVal, retVal + checkDigit, "MEDICAID");
			retVal = retVal + checkDigit;

		}
		else if (idStr.length() == 7 && idStr.startsWith("5") && idStr.matches("^[0-9]+$"))  {
			//Medicare
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			addToSplitFile(idStr, retVal, retVal, "MEDICARE");

		}
		else  {
			retVal = DbFakeHPP.findFake("numeric", "String", idStr, faker);
			
		}

		return retVal;

	}

	public static void addToSplitFile (String fieldOrig, String fieldFakePartial, String fieldFakeComplete, String LOB) {

//		System.out.println("In addFake  VALUES ('" + fieldName + "', '" + fieldType + "', '" + fieldOrig + "', '" + fieldFake + "')");
		
		String pssql = "INSERT INTO integration.claim_split_file (fieldOrig, fieldFakePartial, fieldFakeComplete, LOB, targetSystem) VALUES (?,?,?,?,?)";

		Connection conn = null;
		
		try {

			dbSource dbi = new dbSource();

			conn = dbi.getConnection();
		
	        java.sql.PreparedStatement ps = conn.prepareStatement(pssql);
	        ps.setString(1, fieldOrig);
	        ps.setString(2, fieldFakePartial);
	        ps.setString(3, fieldFakeComplete);
	        ps.setString(4, LOB);
	        
	        if (LOB.contentEquals("MEDICAID") || LOB.contentEquals("CHIP")) {
	        	ps.setString(5, "HRP");
	        }
	        else {
	        	ps.setString(5, "MHS");
	        	
	        }
	        
	        
			ps.executeUpdate();

			conn.close();


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
			
			//System.exit(0);

		} finally {
			
		}

	}		

}
