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

public class DeIdent278_IN {

	public static void main(String[] args) throws FileNotFoundException {
		HPP278model thisHPP278 = new HPP278model();
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
				

				 
				  if(seg.startsWith("NM1*IL")) {
		    		 thisHPP278.setNM1(seg);
		    		 segment = FakeHPP278.fakeNM1IL(thisHPP278.NM1, thisHPP278.NM1, faker);
					 outfile.println(segment);					 
				 }
				  
				  else if(seg.startsWith("N3*")) { 			
		        		 thisHPP278.setN3(seg);
		        		 if(prevSeg.startsWith("NM1*IL")) segment = FakeHPP278.fakeN3(thisHPP278.NM1, seg,faker);
		        		 else segment = seg;
		    			 outfile.println(segment);
					 }	  
	
			 
			 else 			    outfile.println(seg);
        	 			
			
			}


		
		scanner.close();
	}
		
}