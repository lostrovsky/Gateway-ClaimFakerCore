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
import com.ust.claimfaker.core.util.FakeHPP837;

public class DeIdent837_IN {

	public static void main(String[] args) throws FileNotFoundException {
		HPP837model thisHPP837 = new HPP837model();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

	    String InputFileName = "P837_1330522_ID_20180417_166420.edi";
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
		
		
		scanner = new Scanner(new BufferedReader(new java.io.FileReader(InputFileName)));
			
			
			while (scanner.hasNext()) {
				
				
				String str = scanner.nextLine();
	//			System.out.println("XX: " + str);
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

			 if(seg.startsWith("NM1")) prevSeg = seg;		
			

				 if(seg.startsWith("NM1*IL") || seg.startsWith("NM1*P3")) { 			
        		 thisHPP837.setNM1(seg);
        		 segment = FakeHPP837.fakeNM1(thisHPP837.NM1, seg, faker);
    			 outfile.println(segment);
			 }
			 
			 else if(seg.startsWith("IEA*")) { 			
        		 thisHPP837.setN3(seg);
        		 //segment = FakeHPP837.fakeN3(thisHPP837.IEA, seg);
    			 outfile.println(seg);
			 }
			 
			 else if(seg.startsWith("N3*")) { 			
        		 thisHPP837.setN3(seg);
        		 if(prevSeg.startsWith("NM1*IL") || seg.startsWith("NM1*P3")) segment = FakeHPP837.fakeN3(thisHPP837.NM1, seg,faker);
        		 else segment = seg;
    			 outfile.println(segment);
			 }
			 else if(seg.startsWith("N4*")) { 			
        		 thisHPP837.setN3(seg);
        		 if(prevSeg.startsWith("NM1*IL") || seg.startsWith("NM1*P3")) segment = FakeHPP837.fakeN4(thisHPP837.NM1, seg,faker);
        		 else segment = seg;
        		 prevSeg = null;
    			 outfile.println(segment);
			 }
			 
			 
			 //  PER*RP**HP*2159101357*WP*2154005075~
			 else if(seg.startsWith("PER*")) { 			
        		 thisHPP837.setPER(seg);
        		 segment = FakeHPP837.fakePER(thisHPP837.PER, seg, faker);
    			 outfile.println(segment);
			 }
				 
			 else if(seg.startsWith("REF*EA*")) {
        		 thisHPP837.setREF0F(seg);
        		 segment = FakeHPP837.fakeREFea(thisHPP837.REF0F, seg, faker);
    			 outfile.println(segment);

        	 }

			 else if(seg.startsWith("REF*0F*")) {
        		 thisHPP837.setREF0F(seg);
        		 segment = FakeHPP837.fakeREF0f(thisHPP837.REF0F, seg, faker);
    			 outfile.println(segment);

        	 }
        	 else if(seg.startsWith("REF*IL*")) {
        		 thisHPP837.setREFIL(seg);
        		 segment = FakeHPP837.fakeREFil(thisHPP837.REFIL, seg, faker);
    			 outfile.println(segment);

        	 }
        	 else if(seg.startsWith("REF*ZZ*")) {
        		 thisHPP837.setREFIL(seg);
        		 segment = FakeHPP837.fakeREFzz(thisHPP837.REFzz, seg, faker);
    			 outfile.println(segment);
        	 }

			 
			 else outfile.println(seg);
        	 			
			
			}

			
		
		scanner.close();
	}
	
	private static HPP837model fakierHPP837(HPP837model thisDHSTPL) {
		HPP837model tpl = thisDHSTPL;	
		//Faker faker = new Faker();
		
	
	return tpl;
}

	

		private static void outputFakery(HPP837model thisDHSTPL, String fn) {
			
			
			
			try {
				PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fn),true /* append = true */)); 
				

				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static String getHPP837rec(StringBuilder sb ) {
			

			
			String segment = null;

			HPP837model thisHPP837 = new HPP837model();
			
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
                		 thisHPP837.setISA(each);
                    	 continue;
                	 }
                	 if(each.startsWith("GS*")) {
                		 thisHPP837.setGS(each);
                		 continue;
                	 }                	 
                	 
                	 if(each.startsWith("GE*")) {
                		 thisHPP837.setGE(each);
                		 continue;
                	 }
                	 if(each.startsWith("IEA*")) {
                		 thisHPP837.setIEA(each);
                		 continue;
                	 }
                	 
                	 
                	 if(each.startsWith("ST*")) {

                		 thisHPP837.setST(each);
                		 continue;
                	 }
                		 
                	//	 HPP837
                		 
                	 if(each.startsWith("BGN*")) {
                		 thisHPP837.setBGN(each);
                		 continue;
                	 }
                	 if(each.startsWith("REF*")) {
                		 thisHPP837.setREF(each);
                		 continue;
                	 }
                	 if(each.startsWith("DTP*")) {
                		 thisHPP837.setDTP(each);
                		 continue;

                	 }
                	 if(each.startsWith("N1*IN*")) {
                		 thisHPP837.setN1IN(each);
                		 continue;

                	 }
                	 if(each.startsWith("N1*P5*")) {
                		 thisHPP837.setN1P5(each);
                		 continue;

                	 }
                	 if(each.startsWith("INS*")) {
                		 thisHPP837.setINS(each);
                		 continue;

                	 }
                	 if(each.startsWith("REF*0F*")) {
                		 thisHPP837.setREF0F(each);
                		 continue;

                	 }
                	 if(each.startsWith("REF*IL*")) {
                		 thisHPP837.setREFIL(each);
                		 continue;

                	 }

                	 if(each.startsWith("NM1*")) {
                		 thisHPP837.setNM1(each);
                		 //segment = FakeHPP837.fakeNM1(thisHPP837.NM1, each);

                		 continue;

                	 }
                	 
                	 if(each.startsWith("N3*")) {
                		 thisHPP837.setN3(each);
                		 continue;

                	 }
                	
                	 if(each.startsWith("N4*")) {
                		 thisHPP837.setN4(each);
                		 //fakeHPP837(thisHPP837);
                		 continue;

                	 }

                           	 
                     words.add(each);
                     
                     ++lcnt;
                 }
                 
                 int x = 9;
        			
        			
		}
			return segment;
		

		}}
