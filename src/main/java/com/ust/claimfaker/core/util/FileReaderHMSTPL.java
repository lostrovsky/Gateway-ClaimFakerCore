package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;

public class FileReaderHMSTPL {

	public static void main(String[] args) throws FileNotFoundException {
		HMSTPLmodel thisHMSTPL = new HMSTPLmodel();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

	
		
		
		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
	
		
//		try {


			scanner = new Scanner(new BufferedReader(new java.io.FileReader("HMSTPL.dat")));
			
			
			
			while (scanner.hasNext()) {
				
				stringBuilder.delete(0, 1024);
				
				String str = scanner.nextLine();
				char[] myChar = str.toCharArray();

				for (char c : myChar) {
					//if(c != '\t') {
					stringBuilder.append(c);
					count++;
					rowcount++;
				//	}

				}

			
			
			//chop up the line
			thisHMSTPL = getHMSTLPrec(stringBuilder);
			

			
			HMSTPLmodel xTPL = thisHMSTPL;
			fakeHMSTPL(xTPL);

			
			outputFakery(thisHMSTPL, "FAKEHMSTPL" + strDate + ".dat");

			
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
		
		scanner.close();
	}
	
		private static HMSTPLmodel fakeHMSTPL(HMSTPLmodel thisHMSTPL) {
		// TODO Auto-generated method stub
			HMSTPLmodel tpl = thisHMSTPL;	
			Faker faker = new Faker();
			
			
			tpl.setRecipMANumber(Integer.toString(faker.number().numberBetween(811111111, 1107777777)));			

			
			String padded = String.format("%s", faker.name().lastName().toUpperCase()); 
			tpl.setRecipLastName(padded);
			
			padded = String.format("%s", faker.name().firstName().toUpperCase()); 
			tpl.setRecipFirstName(padded);
			
			
			tpl.setRecipSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));

			
			tpl.setPHSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));

			
			padded = String.format("%s", faker.name().lastName().toUpperCase()); 
			tpl.setPHLastName(padded);
			
			padded = String.format("%s", faker.name().firstName().toUpperCase()); 
			tpl.setPHFirstName(padded);
			
			//tpl.setCarrierCode(Integer.toString(faker.number().numberBetween(111111111, 777777777)));
			
			
			

			

			
			
/*
			String padded = String.format("%-14s", faker.name().lastName().toUpperCase()); 
			tlp.setLastName(padded);
			
			padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
			tlp.setFirstName(padded);
			
			tlp.setSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
			
			padded = String.format("%-20s",faker.number().numberBetween(822222222, 1933333333)); 
			tlp.setPolicyNumber(faker.numerify(padded));
					
			padded = tlp.getPolicyholdersSSN().replaceAll(" ", "");
			if(padded.length()!=0) tlp.setPolicyholdersSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
*/
			
		return tpl;
	}

		private static void outputFakery(HMSTPLmodel thisHMSTPL, String fn) {
			
			
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fn),true /* append = true */)); 
				

				    
				    
				    printWriter.println(thisHMSTPL.HMSClientID + '\t' +
						thisHMSTPL.ReportDate + '\t' +
						thisHMSTPL.RecipMANumber +  '\t' +
						thisHMSTPL.RecipSSN + '\t' +
						thisHMSTPL.RecipLastName + '\t' +
						thisHMSTPL.RecipFirstName + '\t' +
						thisHMSTPL.RecipMiddleInitial + '\t' +
						thisHMSTPL.RecipSex + '\t' + 
						thisHMSTPL.RecipBirthDate + '\t' +
						thisHMSTPL.getRelationshipCode() + '\t' +
						thisHMSTPL.getPolicyNumber() + '\t' +
						thisHMSTPL.PHSSN + '\t' +
						thisHMSTPL.PHFirstName + '\t' +
						thisHMSTPL.PHLastName + '\t' +
						thisHMSTPL.PHMiddleInitial + '\t' +
						thisHMSTPL.PHBirthDate + '\t' +
						thisHMSTPL.CarrierCode + '\t' +
						thisHMSTPL.GroupNumber + '\t' +
						thisHMSTPL.HospitalCoverageFlag + '\t' +
						thisHMSTPL.PhysicianCoverageFlag + '\t' +
						thisHMSTPL.PharmacyCoverageFlag + '\t' +
						thisHMSTPL.getDentalCoverageFlag() + '\t' +
						thisHMSTPL.VisionCoverageFlag + '\t' +
						thisHMSTPL.PolicyEffectiveDate + '\t' +
						thisHMSTPL.PolicyTermDate + '\t' +
						thisHMSTPL.VerificationConfirmationDate + '\t' +
						thisHMSTPL.TermAddUpdateIndicator + '\t' +
						thisHMSTPL.LOBIndicator + '\t' +
						thisHMSTPL.INSName + '\t' +
						thisHMSTPL.INSAddressLine1 + '\t' +
						thisHMSTPL.INSAddressLine2 + '\t' +
						thisHMSTPL.INSCity + '\t' +
						thisHMSTPL.INSState + '\t' +
						thisHMSTPL.INSZip  + '\t' 
					);
						
// TODO Auto-generated method stub
				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static HMSTPLmodel getHMSTLPrec(StringBuilder sb ) {
			

			
			HMSTPLmodel thisHMSTPL = new HMSTPLmodel();
			
			ArrayList<String> words = new ArrayList<>();
		
			String[] wordsArray = sb.toString().split("\t");
             for(String each : wordsArray){
                 if(!"".equals(each)){
                	 if(each == null) {
                		 each="";
                	 }
                     words.add(each);
                 }
                 
         			thisHMSTPL.setHMSClientID(wordsArray[0]);
        			thisHMSTPL.setReportDate(wordsArray[1]);
        			thisHMSTPL.setRecipMANumber(wordsArray[2]);
        			thisHMSTPL.setRecipSSN(wordsArray[3]);
        			thisHMSTPL.setRecipLastName(wordsArray[4]);
        			thisHMSTPL.setRecipFirstName(wordsArray[5]);
        			thisHMSTPL.setRecipMiddleInitial(wordsArray[6]);

        			
        			thisHMSTPL.setRecipSex(wordsArray[7]);
        			thisHMSTPL.setRecipBirthDate(wordsArray[8]);
        			thisHMSTPL.setRelationshipCode(wordsArray[9]);
        			
        			
        			thisHMSTPL.setPolicyNumber(wordsArray[10]);
        			
        			thisHMSTPL.setPHSSN(wordsArray[11]);
        			thisHMSTPL.setPHLastName(wordsArray[12]);
        			thisHMSTPL.setPHFirstName(wordsArray[13]);
        			thisHMSTPL.setPHMiddleInitial(wordsArray[14]);
        			thisHMSTPL.setPHBirthDate(wordsArray[15]);
        			
        			
        			thisHMSTPL.setCarrierCode(wordsArray[16]);
        			thisHMSTPL.setGroupNumber(wordsArray[17]);
        			thisHMSTPL.setHospitalCoverageFlag(wordsArray[18]);
        			thisHMSTPL.setPhysicianCoverageFlag(wordsArray[19]);
        			thisHMSTPL.setPharmacyCoverageFlag(wordsArray[20]);
        			thisHMSTPL.setDentalCoverageFlag(wordsArray[21]);
        			thisHMSTPL.setVisionCoverageFlag(wordsArray[22]);
        			thisHMSTPL.setPolicyEffectiveDate(wordsArray[23]);
        			
        			thisHMSTPL.setPolicyTermDate(wordsArray[24]);
        			thisHMSTPL.setVerificationConfirmationDate(wordsArray[25]);
        			
        			thisHMSTPL.setTermAddUpdateIndicator(wordsArray[26]);
        			thisHMSTPL.setLOBIndicator(wordsArray[27]);
        			thisHMSTPL.setINSName(wordsArray[28]);
        			thisHMSTPL.setINSAddressLine1(wordsArray[29]);
        			thisHMSTPL.setINSAddressLine2(wordsArray[30]);
        			thisHMSTPL.setINSCity(wordsArray[31]);
        			thisHMSTPL.setINSState(wordsArray[32]);
        			thisHMSTPL.setINSZip(wordsArray[33]);

		}
			return thisHMSTPL;
		

		}}
