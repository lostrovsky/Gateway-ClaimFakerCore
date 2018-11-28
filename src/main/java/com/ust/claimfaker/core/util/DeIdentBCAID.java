package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.ust.claimfaker.core.Faker;

public class DeIdentBCAID {

	public static void main(String[] args) {
	    String InputFileName = "P834_1330522_ID_20180417_166420.edi";
	    String OutputFileName = "output.txt";
	    
	    if(args.length > 0)  {
	    		    			   
	    	InputFileName = args[0];
	    	OutputFileName = InputFileName + ".fake";
	    	
	    	
	    }
	    else {
	    	System.out.println("Please enter an input file name");
	    	System.exit(0);
	    }

	    FileWriter OutputWriter = null;
		try {
			OutputWriter = new FileWriter(OutputFileName);
PrintWriter pw = new PrintWriter(OutputWriter);
		} catch (IOException e) {

			
			
			
			
			e.printStackTrace();
		}

		Faker faker = new Faker();

	    

		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new java.io.FileReader(InputFileName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			
			while (scanner.hasNext()) {
				
				
				String str = scanner.nextLine();
				//System.out.println("XX: " + str);
				
				
					 String[] lineArray = str.split("\\t");
					    int x = 0;
						for(String field: lineArray) {
							++x;
							if(x==5) {
								String numer = "numeric" + field.length();
								field = DbFakeHPP834EDIchp.findFake(numer, "String", field.toUpperCase(),faker);
							}
							System.out.print(field + "|");
						}
						System.out.print("\n");


			
			}		
			
			
		  
	}

}
