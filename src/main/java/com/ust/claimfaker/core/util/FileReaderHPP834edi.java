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

public class FileReaderHPP834edi {

	public static void main(String[] args) throws FileNotFoundException {
		HPP834model thisHPP834 = new HPP834model();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
	
		
			scanner = new Scanner(new BufferedReader(new java.io.FileReader("20180220193416_CAPS2HPP_834_Out.edi")));
			
			
			
			while (scanner.hasNext()) {
				
			//	stringBuilder.delete(0, 1024);
				
				String str = scanner.nextLine();
				char[] myChar = str.toCharArray();

				for (char c : myChar) {
					if(c == '~') {
					stringBuilder.append("~\n");
					}
					else {
					stringBuilder.append(c);
					count++;
					rowcount++;
					}

				}

			
			}		
			//chop up the line
			thisHPP834 = getHMSTLPrec(stringBuilder);
			

			
			HPP834model xTPL = thisHPP834;
			fakierHPP834(xTPL);

			
			outputFakery(thisHPP834, "FAKED-HPP834" + strDate + ".edi");

	
//	}
			
		
		
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
	
	private static HPP834model fakierHPP834(HPP834model thisDHSTPL) {
		HPP834model tpl = thisDHSTPL;	
		Faker faker = new Faker();
		
		/*
		String temp = DbFake.findFake("CISRID","String", tpl.CISRID);
		tpl.setCISRID(temp);
		
		
		
		temp = DbFake.findFake("LastName", "String", tpl.PolicyholderLastName);
		tpl.setPolicyholderLastName(temp);
		
		temp = DbFake.findFake("FirstName", "String", tpl.PolicyholderFirstName);
		tpl.setPolicyholderFirstName(temp);
		
		
		temp = DbFake.findFake("SSN", "String", tpl.PolicyholderSSN);
		tpl.setPolicyholderSSN(temp);
		
		temp = DbFake.findFake("Street1", "String", tpl.PolicyholderStreet);
		tpl.setPolicyholderStreet(temp);
		
		
		
		
		
		
		if(temp == null) {
			
		//tpl.setCISRID((Integer.toString(faker.number().numberBetween(711111111, 977777777))));		
		//DbFake.addFake("CSIRID","String",temp,tpl.CISRID);

		}

		
		/*String padded = String.format("%-14s", faker.name().lastName().toUpperCase()); 
		tpl.setPolicyholderLastName(padded);
		
		padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
		tpl.setPolicyholderFirstName(padded);
		
		
		tpl.setPolicyholderSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));

		*/
		
		
		
		
		
		/*
		
		if(!tpl.EmployerName.startsWith(" ")) {
		String padded = String.format("%s", faker.company().name().toUpperCase()); 
		tpl.setEmployerName(padded);
		}

		if(!tpl.EmployerStreet.startsWith(" ")) {
		String padded = String.format("%s", faker.address().streetAddress().toUpperCase()); 
		tpl.setEmployerStreet(padded);
		}
		
		if(!tpl.EmployerCity.startsWith(" ")) {
		String padded = String.format("%s", faker.address().city().toUpperCase()); 
		tpl.setEmployerCity(padded);
		}

		if(!tpl.EmployerTelephone.startsWith(" ")) {
		tpl.setEmployerTelephone(faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
		}
		
		//tpl.setCarrierCode(Integer.toString(faker.number().numberBetween(111111111, 777777777)));
		
		*/
		
	return tpl;
}

	
	
	
	
		

		private static HPP834model fakeDHSTPL(HPP834model thisDHSTPL) {
			HPP834model tpl = thisDHSTPL;	
			Faker faker = new Faker();
			
/*			
			tpl.setCISRID((Integer.toString(faker.number().numberBetween(711111111, 977777777))));			

			
			String padded = String.format("%-14s", faker.name().lastName().toUpperCase()); 
			tpl.setPolicyholderLastName(padded);
			
			padded = String.format("%-11s", faker.name().firstName().toUpperCase()); 
			tpl.setPolicyholderFirstName(padded);
			
			
			tpl.setPolicyholderSSN(faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));

			
			if(!tpl.EmployerName.startsWith(" ")) {
			padded = String.format("%s", faker.company().name().toUpperCase()); 
			tpl.setEmployerName(padded);
			}

			if(!tpl.EmployerStreet.startsWith(" ")) {
			padded = String.format("%s", faker.address().streetAddress().toUpperCase()); 
			tpl.setEmployerStreet(padded);
			}
			
			if(!tpl.EmployerCity.startsWith(" ")) {
			padded = String.format("%s", faker.address().city().toUpperCase()); 
			tpl.setEmployerCity(padded);
			}

			if(!tpl.EmployerTelephone.startsWith(" ")) {
			tpl.setEmployerTelephone(faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", ""));
			}
			
			//tpl.setCarrierCode(Integer.toString(faker.number().numberBetween(111111111, 777777777)));
	*/		
			
		return tpl;
	}

		private static void outputFakery(HPP834model thisDHSTPL, String fn) {
			
			
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fn),true /* append = true */)); 
				

				    
			/*	    
				    printWriter.println(thisDHSTPL.CISRID +
						thisDHSTPL.MCOCode +
						thisDHSTPL.TypeofInsurance + 
						thisDHSTPL.CarrierName +
						thisDHSTPL.CarrierStreet +
						thisDHSTPL.CarrierCity +
						thisDHSTPL.CarrierState +
						thisDHSTPL.CarrierZip + 
						thisDHSTPL.CarrierZipExt +
						thisDHSTPL.PolicyNumber +
						thisDHSTPL.GroupName +
						thisDHSTPL.CoverageBegin +
						thisDHSTPL.CoverageEnd +									
						thisDHSTPL.PolicyholderLastName +
						thisDHSTPL.PolicyholderFirstName +
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
						thisDHSTPL.PolicyholderLine						
						//thisDHSTPL.LineFeed  + '\t' 
					);
					
					*/
						
// TODO Auto-generated method stub
				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static HPP834model getHMSTLPrec(StringBuilder sb ) {
			

			

			HPP834model thisHPP834 = new HPP834model();
			HPP834LoopModel thisHPP834LM = new HPP834LoopModel();

			
			ArrayList<String> words = new ArrayList<>();
		
			String[] wordsArray = sb.toString().split("\n");
			int lcnt = 0;
  
			
			for(String each : wordsArray){
                 if(!"".equals(each)){
                	 if(each == null) {
                		 each="";
                	 }
                	 System.out.println(each);
                	 
                
                	 if(each.startsWith("ISA*")) thisHPP834.setISA(each);
                	 if(each.startsWith("GS*")) thisHPP834.setGS(each);
                	 
                	 
                	 if(each.startsWith("GE*")) thisHPP834.setGE(each);
                	 if(each.startsWith("IEA*")) thisHPP834.setIEA(each);
                	 
                	 
                	 if(each.startsWith("ST*")) {

                		 thisHPP834.setST(each);
                		 
                	//	 HPP834
                	 if(each.startsWith("BGN*")) thisHPP834.setBGN(each);
                	 if(each.startsWith("REF*")) thisHPP834.setREF(each);
                	 if(each.startsWith("DTP*")) thisHPP834.setDTP(each);
                	 if(each.startsWith("N1*IN*")) thisHPP834.setN1IN(each);
                	 if(each.startsWith("N1*P5*")) thisHPP834.setN1P5(each);
                	 if(each.startsWith("INS*")) thisHPP834.setINS(each);
                	 if(each.startsWith("REF*0F*")) thisHPP834.setREF0F(each);
                	 if(each.startsWith("REF*IL*")) thisHPP834.setREFIL(each);

                	 }

                           	 
                     words.add(each);
                     
                     ++lcnt;
                 }
                 
                 int x = 9;
        			
        			
		}
			return thisHPP834;
		

		}}
