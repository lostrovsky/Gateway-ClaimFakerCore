package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;

public class FileReaderTPL {

	public static void main(String[] args) throws FileNotFoundException {
		TPLmodel thisTPL = new TPLmodel();
		HMSTPLmodel thisHMSTPL = new HMSTPLmodel();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

	
		
		
		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
	
		
//		try {


			scanner = new Scanner(new BufferedReader(new java.io.FileReader("TPL.dat")));
			
			
			
			while (scanner.hasNext()) {
				
				stringBuilder.delete(0, 1024);
				
				String str = scanner.nextLine();
				char[] myChar = str.toCharArray();

				for (char c : myChar) {
					stringBuilder.append(c);
					count++;
					rowcount++;

				}

			
			
			//chop up the line
			thisTPL = getTLPrec(stringBuilder);
			

			
			TPLmodel xTPL = thisTPL;
			fakeTPL(xTPL);

			
			outputFakery(thisTPL, "FakeTPL-"+ strDate + ".DAT");

			
		//	fakeTPL(xTPL);
			
		//	outputFakery(xTPL);

	}
			
		
		
			// System.out.println(stringBuilder.toString());

/*		} finally {
			if (scanner != null && scanner.hasNext()) {
				scanner.close();
				int yy=1;
			}
		}
		*/
		
		
	}
	
		private static TPLmodel fakeTPL(TPLmodel thisTPL) {
		// TODO Auto-generated method stub
			TPLmodel tlp = thisTPL;	
			Faker faker = new Faker();
			
			tlp.setRecipientIndividualNumber(Integer.toString(faker.number().numberBetween(111111111, 777777777)));		
		

			String padded = String.format("%-14s", faker.name().lastName().toUpperCase()); 
			tlp.setLastName(padded);
			
			padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
			tlp.setFirstName(padded);
			
			tlp.setSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
			
			padded = String.format("%-20s",faker.number().numberBetween(822222222, 1933333333)); 
			tlp.setPolicyNumber(faker.numerify(padded));
					
			padded = tlp.getPolicyholdersSSN().replaceAll(" ", "");
			if(padded.length()!=0) tlp.setPolicyholdersSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));

			
		return null;
	}

		private static void outputFakery(TPLmodel tpl, String fn) {
			
			
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fn),true /* append = true */)); 
				

				    
				    
				    printWriter.println(tpl.MCOCode + 
						tpl.CountyCode +
						tpl.RecipientIndividualNumber +
						tpl.ValidationDigit +
						tpl.LastName +
						tpl.FirstName +
						tpl.MiddleInitial +
						tpl.SSN + 
						tpl.CarrierInsurance +
						tpl.TypeofInsurance +
						tpl.CourtOrderedInsurance +
						tpl.CarrierName +
						tpl.CarrierAddressStreet +
						tpl.CarrierAddressCity +
						tpl.CarrierAddressState +
						tpl.CarrierAddressZipCode +
						tpl.CarrierAddressZipExt +
						tpl.PolicyNumber +
						tpl.GroupNumber +
						tpl.BeginCoverageDate +
						tpl.EndCoverageDate +
						tpl.PolicyholdersLastName +
						tpl.PolicyholdersFirstName +
						tpl.PolicyholdersMiddleInitial +
						tpl.PolicyholdersAddressStreet +
						tpl.PolicyholdersAddressCity +
						tpl.PolicyholdersAddressState +
						tpl.PolicyholdersAddressZipCode +
						tpl.PolicyholdersAddressZipExt +
						tpl.PolicyholdersSSN +
						tpl.EmployersName +
						tpl.EmployersAddressStreet +
						tpl.EmployersAddressCity +
						tpl.EmployersAddressState +
						tpl.EmployersAddressZipCode +
						tpl.EmployersAddressZipExt +
						tpl.EmployersTelephoneNumber +
						tpl.AuditTrailSystemTime +
						tpl.AuditTrailSystemDate +
						tpl.AuditTrailSystemClerkID +
						tpl.AuditTrailTransactionType +
						tpl.RecipientCaseRecordNumber +
						tpl.RecipientCaseRecordCategory +
						tpl.RecipientCaseRecordGrantGroup +
						tpl.RecipientCaseRecordControlDigit +
						tpl.RecipientCaseRecordLineNumber +
						tpl.Filler);
						
// TODO Auto-generated method stub
				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static TPLmodel getTLPrec(StringBuilder sb ) {
			
			TPLmodel thisTPL = new TPLmodel();
			
			thisTPL.setMCOCode(sb.substring(0, 2));
			thisTPL.setCountyCode(sb.substring(2, 4));
			thisTPL.setRecipientIndividualNumber(sb.substring(4, 13));
			thisTPL.setValidationDigit(sb.substring(13, 14));
			thisTPL.setLastName(sb.substring(14, 28));
			thisTPL.setFirstName(sb.substring(28, 39));
			thisTPL.setMiddleInitial(sb.substring(39, 40));
			thisTPL.setSSN(sb.substring(40, 49));
			thisTPL.setCarrierInsurance(sb.substring(49, 52));
			thisTPL.setTypeofInsurance(sb.substring(52, 53));
			thisTPL.setCourtOrderedInsurance(sb.substring(53, 54));
			thisTPL.setCarrierName(sb.substring(54, 84));
			thisTPL.setCarrierAddressStreet(sb.substring(84, 110));
			thisTPL.setCarrierAddressCity(sb.substring(110, 126));
			thisTPL.setCarrierAddressState(sb.substring(126, 128));
			thisTPL.setCarrierAddressZipCode(sb.substring(128, 133));
			thisTPL.setCarrierAddressZipExt(sb.substring(133, 137));
			thisTPL.setPolicyNumber(sb.substring(137, 157));
			thisTPL.setGroupNumber(sb.substring(157, 177));
			thisTPL.setBeginCoverageDate(sb.substring(177, 185));
			thisTPL.setEndCoverageDate(sb.substring(185, 193));
			thisTPL.setPolicyholdersLastName(sb.substring(193, 207));
			thisTPL.setPolicyholdersFirstName(sb.substring(207, 218));
			thisTPL.setPolicyholdersMiddleInitial(sb.substring(218, 219));
			thisTPL.setPolicyholdersAddressStreet(sb.substring(219, 245));
			thisTPL.setPolicyholdersAddressCity(sb.substring(245, 261));
			thisTPL.setPolicyholdersAddressState(sb.substring(261, 263));
			thisTPL.setPolicyholdersAddressZipCode(sb.substring(263, 268));
			thisTPL.setPolicyholdersAddressZipExt(sb.substring(268, 272));
			thisTPL.setPolicyholdersSSN(sb.substring(272, 281));
			thisTPL.setEmployersName(sb.substring(281, 311));
			thisTPL.setEmployersAddressStreet(sb.substring(311, 337));
			thisTPL.setEmployersAddressCity(sb.substring(337, 353));
			thisTPL.setEmployersAddressState(sb.substring(353, 355));
			thisTPL.setEmployersAddressZipCode(sb.substring(355, 360));
			thisTPL.setEmployersAddressZipExt(sb.substring(360, 364));
			thisTPL.setEmployersTelephoneNumber(sb.substring(364, 374));
			thisTPL.setAuditTrailSystemTime(sb.substring(374, 380));
			thisTPL.setAuditTrailSystemDate(sb.substring(380, 388));
			thisTPL.setAuditTrailSystemClerkID(sb.substring(388, 392));
			thisTPL.setAuditTrailTransactionType(sb.substring(392, 393));
			thisTPL.setRecipientCaseRecordNumber(sb.substring(393, 402));
			thisTPL.setRecipientCaseRecordCategory(sb.substring(402, 405));
			thisTPL.setRecipientCaseRecordGrantGroup(sb.substring(405, 406));
			thisTPL.setRecipientCaseRecordControlDigit(sb.substring(406, 407));
			thisTPL.setRecipientCaseRecordLineNumber(sb.substring(407, 409));
			thisTPL.setFiller(sb.substring(409, 412));

			
			
			return thisTPL;
			
		}
		

}
