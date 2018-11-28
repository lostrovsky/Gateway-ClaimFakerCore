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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ust.claimfaker.core.Faker;

public class FileReaderDHSTPL {

	public static void main(String[] args) throws FileNotFoundException {
		DHSTPLmodel thisDHSTPL = new DHSTPLmodel();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    
	    Faker faker = new Faker();

		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
	
		
//		scanner = new Scanner(new BufferedReader(new java.io.FileReader("DHSTPL.dat")));
		scanner = new Scanner(new BufferedReader(new java.io.FileReader("45TPL766.dat")));
			
			
			
			while (scanner.hasNext()) {
				
				
				
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
			thisDHSTPL = getHMSTLPrec(stringBuilder, faker);
			
			outputFakery(thisDHSTPL, "WTF-GA-FAKED-DHSTPL" + strDate + ".dat");
			stringBuilder.delete(0, stringBuilder.length());

			
			//DHSTPLmodel xTPL = thisDHSTPL;
			//fakierDHSTPL(xTPL);

			
			//outputFakery(thisDHSTPL, "FAKED-DHSTPL" + strDate + ".dat");

			
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
		

		private static void outputFakery(DHSTPLmodel thisDHSTPL, String fn) {
			
			
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fn),true /* append = true */)); 
				

				    
				    
				    printWriter.println(thisDHSTPL.CISRID +
						thisDHSTPL.MCOCode +
						thisDHSTPL.MCOValCode +
						thisDHSTPL.LastName +
						thisDHSTPL.FirstName +
						thisDHSTPL.MiddleInitial +
						thisDHSTPL.SSN +
						thisDHSTPL.CarrierInsurance +
						thisDHSTPL.TypeofInsurance +
						thisDHSTPL.CourtOrderedInsurance +
						thisDHSTPL.CarrierName +
						thisDHSTPL.CarrierStreet +
						thisDHSTPL.CarrierCity +
						thisDHSTPL.CarrierState +
						thisDHSTPL.CarrierZip + 
						thisDHSTPL.CarrierZipExt +
						thisDHSTPL.PolicyNumber +
						thisDHSTPL.GroupNumber +
						thisDHSTPL.CoverageBegin +
						thisDHSTPL.CoverageEnd +									
						thisDHSTPL.PolicyholderLastName +
						thisDHSTPL.PolicyholderFirstName +
						thisDHSTPL.PolicyHolderMiddleInitial +
						thisDHSTPL.PolicyholderStreet +
						thisDHSTPL.PolicyholderCity +
						thisDHSTPL.PolicyholderState +
						thisDHSTPL.PolicyholderZip +
						thisDHSTPL.PolicyholderZipExt +
						thisDHSTPL.PolicyholderSSN +											
						thisDHSTPL.EmployerName +
						thisDHSTPL.EmployerStreet +
						thisDHSTPL.EmployerCity +
						thisDHSTPL.EmployerState +
						thisDHSTPL.EmployerZip +
						thisDHSTPL.EmployerZipExt +											
						thisDHSTPL.EmployerTelephone +
//						"                                                                    " +
//						"                     "  +
						thisDHSTPL.AuditTrailSysTime +
						thisDHSTPL.AuditTrailSysDate +
						thisDHSTPL.AuditTrailSysClerkID +
						thisDHSTPL.AuditTrailTransType +
						thisDHSTPL.RecipCaseRecno +
						thisDHSTPL.RecipCaseRecCategory +
						thisDHSTPL.RecipCaseRecordGrantGroup +
						thisDHSTPL.RecipCaseRecCtl +
						thisDHSTPL.RecipCaseRecLineNo +
						thisDHSTPL.Filler
//						thisDHSTPL.PolicyholderLine						
						//thisDHSTPL.LineFeed  + '\t' 
					);
						
// TODO Auto-generated method stub
				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static DHSTPLmodel getHMSTLPrec(StringBuilder sb, Faker faker ) {
			

			//Faker faker = new Faker();

			DHSTPLmodel thisDHSTPL = new DHSTPLmodel();
			
			ArrayList<String> words = new ArrayList<String>();
		
			String[] wordsArray = sb.toString().split("\t");
             for(String each : wordsArray){
                 if(!"".equals(each)){
                	 if(each == null) {
                		 each="";
                	 }
                     words.add(each);
                 }
                 
                 
                 
         			thisDHSTPL.setCISRID(sb.substring(0, 4));
         			
         			
         			
				
					String field = sb.substring(4, 13);
					int x = 0;
				    String alphanum = "^[a-zA-Z0-9]+$";	
				    String alpha = "^[a-zA-Z]+$";	
				    String numer = "^[0-9]+$";	
				    
					Pattern patnumer = Pattern.compile(numer);
					 
					String ft = null;
						  Matcher matcher = patnumer.matcher(field);
						  //System.out.println(matcher.matches());
						  if(matcher.matches()) ft = "numeric" + field.length();
						  else ft = "alpha" + field.length();
						  								 
						  field = DbFakeHPP834EDIchp.findFake(ft, "String", field.toUpperCase(),faker);							 
				    			thisDHSTPL.setMCOCode(field);
    			
    			
    			
    			
        			thisDHSTPL.setMCOValCode(sb.substring(13, 14));
        			
    
        			if(sb.substring(14, 28).trim().length()>0) {	     			
        			field = String.format("%-14s", DbFakeHPP834EDIchp.findFake("lastName", "String", sb.substring(14, 28).toUpperCase(),faker)).substring(0, 14); 
        			thisDHSTPL.setLastName(field);
        			}
        			else thisDHSTPL.setLastName(sb.substring(14, 28));

        			if(sb.substring(28, 39).trim().length()>0) {	     			

        			field = String.format("%-11s", DbFakeHPP834EDIchp.findFake("firstName", "String", sb.substring(28, 39).toUpperCase(),faker)).substring(0,11); 
        		  thisDHSTPL.setFirstName(field);
        			}
        			else thisDHSTPL.setFirstName(sb.substring(28, 39));
        			
        			
        			
        			if(sb.substring(39, 40).trim().length()>0) {	     			

				  field = DbFakeHPP834EDIchp.findFake("middleInitial", "String", sb.substring(39, 40).toUpperCase(),faker);							 
        		  thisDHSTPL.setMiddleInitial(field);
        			}
        			else thisDHSTPL.setMiddleInitial(sb.substring(39, 40));


        			if(sb.substring(40, 49).trim().length()>0) {	     			
				  field = DbFakeHPP834EDIchp.findFake("SSN", "String", sb.substring(40, 49).toUpperCase(),faker);							 
        			thisDHSTPL.setSSN(field);
        			}
        			else   thisDHSTPL.setSSN(sb.substring(40, 49).toUpperCase());

        			
        			thisDHSTPL.setCarrierInsurance(sb.substring(49, 52));
        			thisDHSTPL.setTypeofInsurance(sb.substring(52, 53));
        			thisDHSTPL.setCourtOrderedInsurance(sb.substring(53, 54));
        			        			       			
        			
        			thisDHSTPL.setCarrierName(sb.substring(54, 84));        			     			
        			thisDHSTPL.setCarrierStreet(sb.substring(84, 110));

        			
        			thisDHSTPL.setCarrierCity(sb.substring(110, 126));
        			thisDHSTPL.setCarrierState(sb.substring(126, 128));      			
        			thisDHSTPL.setCarrierZip(sb.substring(128, 133));        			        		
        			thisDHSTPL.setCarrierZipExt(sb.substring(133, 137));
        			

        			
        			if(sb.substring(137, 157).trim().length()>0) {
        				field = sb.substring(137, 157);
        			 matcher = patnumer.matcher(field);
					  if(matcher.matches()) ft = "numeric" + field.length();
					
					  else ft = "alpha" + field.trim().length();	
					  
					  
	        			field = String.format("%-20s", DbFakeHPP834EDIchp.findFake(ft, "String", sb.substring(137, 157).trim().toUpperCase(),faker)).substring(0,20); 
//System.out.println("LL " + field.length());
					thisDHSTPL.setPolicyNumber(field);
        			}
        			else thisDHSTPL.setPolicyNumber(sb.substring(137, 157));

   
        			
        			thisDHSTPL.setGroupNumber(sb.substring(157, 177));
        			
        			thisDHSTPL.setCoverageBegin(sb.substring(177, 185));
        			thisDHSTPL.setCoverageEnd(sb.substring(185, 193));        			        		
        			
        			if(sb.substring(193, 207).trim().length()>0) {	     			

        			field = String.format("%-14s", DbFakeHPP834EDIchp.findFake("lastName", "String", sb.substring(193, 207).toUpperCase(),faker)).substring(0,14); 
        			thisDHSTPL.setPolicyholderLastName(field);
        			}
        			else thisDHSTPL.setPolicyholderLastName(sb.substring(193, 207));

        			if(sb.substring(207, 218).trim().length()>0) {	     			

        			field = String.format("%-11s", DbFakeHPP834EDIchp.findFake("firstName", "String", sb.substring(207, 218).toUpperCase(),faker)).substring(0,11); 
        			thisDHSTPL.setPolicyholderFirstName(field);
        			}
        			else         			thisDHSTPL.setPolicyholderFirstName(sb.substring(207, 218));
        			
        			
        			
        			if(sb.substring(218, 219).trim().length()>0) {	     			
@SuppressWarnings("unused")
String thisone = sb.substring(218, 219);
					field = DbFakeHPP834EDIchp.findFake("middleInitial", "String", sb.substring(218, 219).toUpperCase(),faker);							         			
        			thisDHSTPL.setPolicyHolderMiddleInitial(field);
        			}
        			else thisDHSTPL.setPolicyHolderMiddleInitial(sb.substring(218, 219));

        			        			        			

        			if(sb.substring(219, 245).trim().length()>0) {	     			
        			
        			field = String.format("%-26s", DbFakeHPP834EDIchp.findFake("addressLine1", "String", sb.substring(219, 245).toUpperCase(),faker)).substring(0,26); 
         			thisDHSTPL.setPolicyholderStreet(field);
        			}
        			else thisDHSTPL.setPolicyholderStreet(sb.substring(219, 245));

        			
        			
        			 //  field = String.format("%-16s", DbFakeHPP834EDIchp.findFake("City", "String", sb.substring(245, 261).toUpperCase(),faker)).substring(0,16); 
        			//    thisDHSTPL.setPolicyholderCity(field);
         			thisDHSTPL.setPolicyholderCity(sb.substring(245, 261));
        			
        			thisDHSTPL.setPolicyholderState(sb.substring(261, 263));
        			
        			thisDHSTPL.setPolicyholderZip(sb.substring(263, 268));
        			thisDHSTPL.setPolicyholderZipExt(sb.substring(268, 272));
        			
        			if(sb.substring(272, 281).trim().length()>0) {	     			

      			  field = DbFakeHPP834EDIchp.findFake("SSN", "String", sb.substring(272, 281),faker);							         			

        			thisDHSTPL.setPolicyholderSSN(field);
        			}
        			else thisDHSTPL.setPolicyholderSSN(sb.substring(272, 281));
        			
        			
        			
        			thisDHSTPL.setEmployerName(sb.substring(281, 311));
        			
        			
        			thisDHSTPL.setEmployerStreet(sb.substring(311, 337));
        			thisDHSTPL.setEmployerCity(sb.substring(337, 353));
        			thisDHSTPL.setEmployerState(sb.substring(353, 355));
        			
        			thisDHSTPL.setEmployerZip(sb.substring(355, 360));
        			thisDHSTPL.setEmployerZipExt(sb.substring(360, 364));        			     		
        			
        			thisDHSTPL.setEmployerTelephone(sb.substring(364, 374));
        			

        			thisDHSTPL.setAuditTrailSysTime(sb.substring(374, 380));
        			thisDHSTPL.setAuditTrailSysDate(sb.substring(380, 388));
        			thisDHSTPL.setAuditTrailSysClerkID(sb.substring(388, 392));
        			thisDHSTPL.setAuditTrailTransType(sb.substring(392, 393));
        			
        			
        			thisDHSTPL.setRecipCaseRecno(sb.substring(393, 402));
        			thisDHSTPL.setRecipCaseRecCategory(sb.substring(402, 405));
        			thisDHSTPL.setRecipCaseRecordGrantGroup(sb.substring(405, 406));
        			thisDHSTPL.setRecipCaseRecCtl(sb.substring(406, 407));
        			thisDHSTPL.setRecipCaseRecLineNo(sb.substring(407, 409));
        			thisDHSTPL.setFiller(sb.substring(409, 412));
        			

  
        			
		}
             
			return thisDHSTPL;
		

		}}
