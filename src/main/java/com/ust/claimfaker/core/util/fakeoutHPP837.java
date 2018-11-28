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
import com.ust.claimfaker.core.util.FakeHPP834;

public class fakeoutHPP837 {

	public static void main(String[] args) throws FileNotFoundException {
		HPP834model thisHPP834 = new HPP834model();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd-HHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);

		StringBuilder stringBuilder = new StringBuilder();

		Scanner scanner = null;
		int count = 0, rowcount = 0;
		
		Faker faker = new Faker();
	
		
			scanner = new Scanner(new BufferedReader(new java.io.FileReader("petes837.txt")));
			
			
			
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
			
			
		    String[] recordArray = stringBuilder.toString().split("\n");

			for(String seg: recordArray  ) {
				

				
				
			//chop up the line
			String segment = null;
			
			 if(seg.startsWith("NM1*") && !seg.startsWith("NM1*P3") ) { 			
        		 thisHPP834.setNM1(seg);
        		 segment = FakeHPP834.fakeNM1(thisHPP834.NM1, seg, faker);
    			 System.out.println(segment);
    			 //System.out.println("O:" + seg);
			 }
			 
			 else if(seg.startsWith("N3*")) { 			
        		 thisHPP834.setN3(seg);
        		 segment = FakeHPP834.fakeN3(thisHPP834.NM1, seg, faker);
    			 System.out.println(segment);
			 }
			 
			 //  PER*RP**HP*2159101357*WP*2154005075~
			 else if(seg.startsWith("PER*")) { 			
        		 thisHPP834.setPER(seg);
        		 segment = FakeHPP834.fakePER(thisHPP834.PER, seg, faker);
    			 System.out.println(segment);
			 }

			 
			 else 			 System.out.println(seg);
        	 			
			//thisHPP834 = getHPP834rec(stringBuilder);
			
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
				

				    
		
						
				    printWriter.close ();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
			    
			    
			
	}

		public static String getHPP834rec(StringBuilder sb ) {
			

			
			String segment = null;

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
