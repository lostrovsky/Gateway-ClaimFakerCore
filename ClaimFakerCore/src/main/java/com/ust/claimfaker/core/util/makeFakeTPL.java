package com.ust.claimfaker.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;


public class makeFakeTPL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cityPool = null;

		try {
			cityPool = getRandomAddressPool.cityZip(1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] CITY = cityPool[0].split("\\|");

		TPLmodel thisTPL = new TPLmodel();

//		InputStream in = new FileInputStream("faketpl.txt");
//		Reader r = new InputStreamReader(in, "US-ASCII");

		String holder = "";
		int intch = 0;
		char[] cholder = null;

		int i = 0;

		int lines = 0;

		while (true) {
			++lines;

			Faker faker = new Faker();

			try {
				cityPool = getRandomAddressPool.cityZip(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			CITY = cityPool[0].split("\\|");
			
//			Start TPL Record

			 try {
				 
				 // faketpl.dat  HPPACAV_032218 - Monthly TPL from HMS.txt
				 
				 
				   System.out.println("faketpl.dat as HPPACAV_032218 - Monthly TPL from HMS.txt");
				   
				   //File file = new File("HPPACAV_032218 - Monthly TPL from HMS.txt");
				   
				   
				   File file = new File("faketpl.dat");
				   Scanner scanner = new Scanner(file);
				   while (scanner.hasNext()) {
				    System.out.println(scanner.next());
				   }
				   scanner.close();
				  } catch (FileNotFoundException e) {
				   e.printStackTrace();
				  } 
			
			
//			holder = 
					while (i < thisTPL._szMCOCode) {
				char ch = (char) intch;
				holder += ch;
				++i;
			}
			

		}
	}
}


/*
thisTPL.setMCOCode(stringBuilder.substring(0, 2));
thisTPL.setCountyCode(stringBuilder.substring(2, 4));
thisTPL.setRecipientIndividualNumber(stringBuilder.substring(4, 13));
thisTPL.setValidationDigit(stringBuilder.substring(13, 14));
thisTPL.setLastName(stringBuilder.substring(14, 28));
thisTPL.setFirstName(stringBuilder.substring(28, 39));
thisTPL.setMiddleInitial(stringBuilder.substring(39, 40));
thisTPL.setSSN(stringBuilder.substring(40, 49));
thisTPL.setCarrierInsurance(stringBuilder.substring(49, 52));
thisTPL.setTypeofInsurance(stringBuilder.substring(52, 53));
thisTPL.setCourtOrderedInsurance(stringBuilder.substring(53, 54));
thisTPL.setCarrierName(stringBuilder.substring(54, 84));
thisTPL.setCarrierAddressStreet(stringBuilder.substring(84, 110));
thisTPL.setCarrierAddressCity(stringBuilder.substring(110, 125));
thisTPL.setCarrierAddressState(stringBuilder.substring(126, 128));
thisTPL.setCarrierAddressZipCode(stringBuilder.substring(128, 133));
thisTPL.setCarrierAddressZipExt(stringBuilder.substring(133, 137));
thisTPL.setPolicyNumber(stringBuilder.substring(137, 157));
thisTPL.setGroupNumber(stringBuilder.substring(157, 177));
thisTPL.setBeginCoverageDate(stringBuilder.substring(177, 185));
thisTPL.setEndCoverageDate(stringBuilder.substring(185, 193));
thisTPL.setPolicyholdersLastName(stringBuilder.substring(193, 207));
thisTPL.setPolicyholdersFirstName(stringBuilder.substring(207, 218));
thisTPL.setPolicyholdersMiddleInitial(stringBuilder.substring(218, 219));
thisTPL.setPolicyholdersAddressStreet(stringBuilder.substring(219, 245));
thisTPL.setPolicyholdersAddressCity(stringBuilder.substring(245, 261));
thisTPL.setPolicyholdersAddressState(stringBuilder.substring(261, 263));
thisTPL.setPolicyholdersAddressZipCode(stringBuilder.substring(263, 268));
thisTPL.setPolicyholdersAddressZipExt(stringBuilder.substring(268, 272));
thisTPL.setPolicyholdersSSN(stringBuilder.substring(272, 281));
thisTPL.setEmployersName(stringBuilder.substring(281, 311));
thisTPL.setEmployersAddressStreet(stringBuilder.substring(311, 337));
thisTPL.setEmployersAddressCity(stringBuilder.substring(337, 353));
thisTPL.setEmployersAddressState(stringBuilder.substring(353, 355));
thisTPL.setEmployersAddressZipCode(stringBuilder.substring(355, 360));
thisTPL.setEmployersAddressZipExt(stringBuilder.substring(360, 364));
thisTPL.setEmployersTelephoneNumber(stringBuilder.substring(364, 374));
thisTPL.setAuditTrailSystemTime(stringBuilder.substring(364, 380));
thisTPL.setAuditTrailSystemDate(stringBuilder.substring(380, 388));
thisTPL.setAuditTrailSystemClerkID(stringBuilder.substring(388, 392));
thisTPL.setAuditTrailTransactionType(stringBuilder.substring(392, 393));
thisTPL.setRecipientCaseRecordNumber(stringBuilder.substring(393, 402));
thisTPL.setRecipientCaseRecordCategory(stringBuilder.substring(402, 405));
thisTPL.setRecipientCaseRecordGrantGroup(stringBuilder.substring(405, 406));
thisTPL.setRecipientCaseRecordControlDigit(stringBuilder.substring(406, 407));
thisTPL.setRecipientCaseRecordLineNumber(stringBuilder.substring(407, 409));
thisTPL.setFiller(stringBuilder.substring(409, 412));
*/

