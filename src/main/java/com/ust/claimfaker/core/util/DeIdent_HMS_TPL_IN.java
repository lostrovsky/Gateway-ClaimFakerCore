package com.ust.claimfaker.core.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ust.claimfaker.core.Faker;

public class DeIdent_HMS_TPL_IN {

//	public static void main(String[] args) {
		
		public static void main(String[] args) throws FileNotFoundException {
			HPP834model thisHPP834 = new HPP834model();
			HPP820model thisHPP820 = new HPP820model();
			
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
		/*
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
*/
		Faker faker = new Faker();

	    

		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new java.io.FileReader(InputFileName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			int counter=0;
			
			
			while (scanner.hasNext()) {
				
				String str = "";
				
				if(counter==0) {
					String header = scanner.nextLine();
					outfile.print(header);
				}
				
				else {
					 str = scanner.nextLine();
				}
				
				++counter;

				
				//System.out.println("#: " + counter + "  " + str);
				
				
					 String[] lineArray = str.split("\\t");
					    int x = 0;
					    String alphanum = "^[a-zA-Z0-9]+$";	
					    String alpha = "^[a-zA-Z]+$";	
					    String numer = "^[0-9]+$";	
					    
//						Pattern patalphanum = Pattern.compile(alphanum);
//						Pattern patalpha = Pattern.compile(alpha);
						Pattern patnumer = Pattern.compile(numer);
						 
					    
						for(String field: lineArray) {
							++x;
							if(x==3)
							{	String ft = null;
								  Matcher matcher = patnumer.matcher(field);
								  //System.out.println(matcher.matches());
								  if(matcher.matches()) ft = "numeric" + field.length();
								  else ft = "alpha" + field.length();
								  								 
								  field = DbFakeHPP834EDIchp.findFake(ft, "String", field.toUpperCase(),faker);							 
									
							}

							if(x==4)
							{
								if(field.trim().length()>0) field = DbFakeHPP834EDIchp.findFake("SSN", "String", field.toUpperCase(),faker);								
							}
							else if(x==5)
							{
								field = DbFakeHPP834EDIchp.findFake("lastName", "String", field.toUpperCase(),faker);								
							}
							else if(x==6)
							{
								field = DbFakeHPP834EDIchp.findFake("firstName", "String", field.toUpperCase(),faker);								
							}
							else if(x==7)
							{
								if(field.trim().length()>0) field = DbFakeHPP834EDIchp.findFake("middleInitial", "String", field.toUpperCase(),faker);								
							}
							else if(x==9)
							{
							//	field = DbFakeHPP834EDIchp.findFake("birthDate", "String", field.toUpperCase(),faker);								
							}
							
							//part 2
							
							if(x==11)
							{	String ft = null;
								  Matcher matcher = patnumer.matcher(field);
								  //System.out.println(matcher.matches());
								  if(matcher.matches()) ft = "numeric" + field.length();
								  else ft = "alpha" + field.length();
								  								 
								  field = DbFakeHPP834EDIchp.findFake(ft, "String", field.toUpperCase(),faker);							 
									
							}

							if(x==12)
							{
								field = DbFakeHPP834EDIchp.findFake("SSN", "String", field.toUpperCase(),faker);								
							}
							else if(x==13)
							{
								field = DbFakeHPP834EDIchp.findFake("lastName", "String", field.toUpperCase(),faker);								
							}
							else if(x==14)
							{
								field = DbFakeHPP834EDIchp.findFake("firstName", "String", field.toUpperCase(),faker);								
							}
							else if(x==15)
							{
								if(field.trim().length()>0) {
									int xy = field.trim().length();
									field = DbFakeHPP834EDIchp.findFake("middleInitial", "String", field.toUpperCase(),faker);								
								}
							}
													
							//System.out.print(field + "\t");
							outfile.print(field + "\t");
						}

						//System.out.print("\n");
						outfile.print("\n");


			
			}		
			
			outfile.close();
			
			
		  
	}

}
