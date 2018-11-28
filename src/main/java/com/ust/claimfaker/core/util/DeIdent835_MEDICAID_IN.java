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

public class DeIdent835_MEDICAID_IN {

	public static void main(String[] args) throws FileNotFoundException {
		HPP835model thisHPP835 = new HPP835model();
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
//			System.err.println("LINE: " + counter);
			

			
			 if(seg.startsWith("NM1")) prevSeg = seg;		
				

		//	 if(seg.startsWith("NM1*IL") || seg.startsWith("NM1*P3")) { 	
			 
			 //						 seg.startsWith("NM1*P3") || 

				 
		/*		 if(seg.startsWith("NM1*IL") || 
						 seg.startsWith("NM1*7") || 
						 seg.startsWith("NM1*QD")
						 
						 ) { 				 
    		 thisHPP835.setNM1(seg);
    		 segment = FakeHPP834.fakeNM1(thisHPP835.NM1, thisHPP835.NM1, faker);
			 outfile.println(segment);
		 }
		 */
				 
				  if(seg.startsWith("NM1*QC")) {
		    		 thisHPP835.setNM1(seg);
		    		 segment = FakeHPP835.fakeNM1QC(thisHPP835.NM1, thisHPP835.NM1, faker);
					 outfile.println(segment);					 
				 }
	/*		 
			 else if(seg.startsWith("IEA*")) { 			
        		 thisHPP835.setN3(seg);
        		 //segment = FakeHPP834.fakeN3(thisHPP835.IEA, seg);
    			 outfile.println(seg);
			 }
			 
			 
			 else if(seg.startsWith("N3*")) { 			
        		 thisHPP835.setN3(seg);
        		 segment = FakeHPP834.fakeN3(thisHPP835.NM1, seg,faker);
    			 outfile.println(segment);
			 }
			 
			 //  PER*RP**HP*2159101357*WP*2154005075~
			 else if(seg.startsWith("PER*")) { 			
        		 thisHPP835.setPER(seg);
        		 segment = FakeHPP834.fakePER(thisHPP835.PER, seg, faker);
    			 outfile.println(segment);
			 }
			 
			 else if(seg.startsWith("REF*0F*")) {
        		 thisHPP835.setREF0F(seg);
        		 segment = FakeHPP834.fakeREF0f(thisHPP835.REF0F, seg, faker);
    			 outfile.println(segment);


        	 }
			 else if(seg.startsWith("REF*IL*")) {
        		 thisHPP835.setREFIL(seg);
        		 segment = FakeHPP834.fakeREFil(thisHPP835.REFIL, seg, faker);
    			 outfile.println(segment);


        	 }
        	 */
			 else if(seg.startsWith("REF*EA*")) {
        		 thisHPP835.setREFIL(seg);
        		 segment = FakeHPP835.fakeREFea(thisHPP835.REFea, seg, faker);
    			 outfile.println(segment);
        	 }
			 else if(seg.startsWith("REF*SY*")) {
        		 thisHPP835.setREFIL(seg);
        		 segment = FakeHPP835.fakeREFsy(thisHPP835.REFsy, seg, faker);
    			 outfile.println(segment);
        	 }
			 
			/* else if(seg.startsWith("REF*ZZ*")) {
        		 thisHPP835.setREFIL(seg);
        		 segment = FakeHPP834.fakeREFzz(thisHPP835.REFzz, seg, faker);
    			 outfile.println(segment);


        	 }*/

			 
			 else 			    outfile.println(seg);
        	 			
			//thisHPP835 = getHPP834rec(stringBuilder);
			
			}


		
		scanner.close();
	}
		
}