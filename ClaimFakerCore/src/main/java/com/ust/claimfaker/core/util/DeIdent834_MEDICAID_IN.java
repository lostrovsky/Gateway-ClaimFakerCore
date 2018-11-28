package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.util.FakeHPP834;

public class DeIdent834_MEDICAID_IN {

	public static void main(String[] args) throws FileNotFoundException {
		HPP834model thisHPP834 = new HPP834model();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

	    
	    String InputFileName = "input.txt";
	    String OutputFileName = "output.txt";
	    
	    PrintWriter outfile = null;
	    
	    if(args.length > 0)  {
	    		    			   
	    	InputFileName = args[0];
	    	OutputFileName = InputFileName + ".fake";
	    	
	    	
	    }
	    else {
	    	System.out.println("Please enter an input file name");
	    	System.exit(0);
	    }

	    FileWriter OutputWriter;
		try {
			OutputWriter = new FileWriter(OutputFileName);
	        outfile = new PrintWriter(OutputWriter, true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Faker faker = new Faker();

	    

		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
		
		//Faker fakerRead = new Faker();
	
		scanner = new Scanner(new BufferedReader(new java.io.FileReader(InputFileName)));
			
			
			while (scanner.hasNext()) {
				
			//	stringBuilder.delete(0, 1024);
				
				String str = scanner.nextLine();
				//System.out.println("XX: " + str);
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
			
			
		    String[] recordArray = stringBuilder.toString().split("\n");
		    
		    int counter=0;
		    String prevSeg = null;


			for(String seg: recordArray  ) {
				

				
				
			//chop up the line
			String segment = null;
			++counter;
			//System.err.println("LINE: " + counter);
			

			
			 if(seg.startsWith("NM1")) prevSeg = seg;		
				

		//	 if(seg.startsWith("NM1*IL") || seg.startsWith("NM1*P3")) { 	
			 
			 //						 seg.startsWith("NM1*P3") || 

				 
				 if(seg.startsWith("NM1*IL") || 
						 seg.startsWith("NM1*7") || 
						 seg.startsWith("NM1*QD")
						 
						 ) { 				 
    		 thisHPP834.setNM1(seg);
    		 segment = FakeHPP834.fakeNM1(thisHPP834.NM1, thisHPP834.NM1, faker);
			 outfile.println(segment);
		 }
		 
			 
			 else if(seg.startsWith("IEA*")) { 			
        		 thisHPP834.setN3(seg);
        		 //segment = FakeHPP834.fakeN3(thisHPP834.IEA, seg);
    			 outfile.println(seg);
			 }
			 
			 
			 else if(seg.startsWith("N3*")) { 			
        		 thisHPP834.setN3(seg);
        		 segment = FakeHPP834.fakeN3(thisHPP834.NM1, seg,faker);
    			 outfile.println(segment);
			 }
			 
			 //  PER*RP**HP*2159101357*WP*2154005075~
			 else if(seg.startsWith("PER*")) { 			
        		 thisHPP834.setPER(seg);
        		 segment = FakeHPP834.fakePER(thisHPP834.PER, seg, faker);
    			 outfile.println(segment);
			 }
			 
			 else if(seg.startsWith("REF*0F*")) {
        		 thisHPP834.setREF0F(seg);
        		 segment = FakeHPP834.fakeREF0f(thisHPP834.REF0F, seg, faker);
    			 outfile.println(segment);


        	 }
			 else if(seg.startsWith("REF*IL*")) {
        		 thisHPP834.setREFIL(seg);
        		 segment = FakeHPP834.fakeREFil(thisHPP834.REFIL, seg, faker);
    			 outfile.println(segment);


        	 }
			 else if(seg.startsWith("REF*ZZ*")) {
        		 thisHPP834.setREFIL(seg);
        		 segment = FakeHPP834.fakeREFzz(thisHPP834.REFzz, seg, faker);
    			 outfile.println(segment);


        	 }
			 
			
			 
			 else 			    outfile.println(seg);
        	 			
			
			}


		
		scanner.close();
	}
	
	private static HPP834model fakierHPP834(HPP834model thisDHSTPL) {
		HPP834model tpl = thisDHSTPL;	
		Faker faker = new Faker();
		
		
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

		public static String XgetHPP834rec(StringBuilder sb ) {
			

			
			String segment = null;

			HPP834model thisHPP834 = new HPP834model();
			HPP834LoopModel thisHPP834LM = new HPP834LoopModel();

			
			ArrayList<String> words = new ArrayList<String>();
		
			String[] wordsArray = sb.toString().split("\n");
			int lcnt = 0;
  
			
			for(String each : wordsArray){
                 if(!"".equals(each)){
                	 if(each == null) {
                		 each="";
                	 }
                	 System.out.println(each);
                	 
                
                	 if(each.startsWith("ISA*")) {
                		 thisHPP834.setISA(each);
                    	 continue;
                	 }
                	 if(each.startsWith("GS*")) {
                		 thisHPP834.setGS(each);
                		 continue;
                	 }                	 
                	 
                	 if(each.startsWith("GE*")) {
                		 thisHPP834.setGE(each);
                		 continue;
                	 }
                	 if(each.startsWith("IEA*")) {
                		 thisHPP834.setIEA(each);
                		 continue;
                	 }
                	 
                	 
                	 if(each.startsWith("ST*")) {

                		 thisHPP834.setST(each);
                		 continue;
                	 }
                		 
                	//	 HPP834
                		 
                	 if(each.startsWith("BGN*")) {
                		 thisHPP834.setBGN(each);
                		 continue;
                	 }
                	 if(each.startsWith("REF*")) {
                		 thisHPP834.setREF(each);
                		 continue;
                	 }
                	 if(each.startsWith("DTP*")) {
                		 thisHPP834.setDTP(each);
                		 continue;

                	 }
                	 if(each.startsWith("N1*IN*")) {
                		 thisHPP834.setN1IN(each);
                		 continue;

                	 }
                	 if(each.startsWith("N1*P5*")) {
                		 thisHPP834.setN1P5(each);
                		 continue;

                	 }
                	 if(each.startsWith("INS*")) {
                		 thisHPP834.setINS(each);
                		 continue;

                	 }
                	 if(each.startsWith("REF*0F*")) {
                		 thisHPP834.setREF0F(each);
                		 continue;

                	 }
                	 if(each.startsWith("REF*IL*")) {
                		 thisHPP834.setREFIL(each);
                		 continue;

                	 }

                	 if(each.startsWith("NM1*")) {
                		 thisHPP834.setNM1(each);
                		 //segment = FakeHPP834.fakeNM1(thisHPP834.NM1, each);

                		 continue;

                	 }
                	 
                	 if(each.startsWith("N3*")) {
                		 thisHPP834.setN3(each);
                		 continue;

                	 }
                	
                	 if(each.startsWith("N4*")) {
                		 thisHPP834.setN4(each);
                		 //fakeHPP834(thisHPP834);
                		 continue;

                	 }

                           	 
                     words.add(each);
                     
                     ++lcnt;
                 }
                 
                 int x = 9;
        			
        			
		}
			return segment;
		

		}}
