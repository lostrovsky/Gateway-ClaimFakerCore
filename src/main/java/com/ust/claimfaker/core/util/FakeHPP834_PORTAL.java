package com.ust.claimfaker.core.util;

import java.io.PrintWriter;

import com.ust.claimfaker.core.Faker;

public class FakeHPP834_PORTAL {

	
	
	public static String fakeNM1(String segnm, String segv, Faker faker) {


		// NM1
		if(segv.endsWith("~")) segv = segv.substring(0, segv.length()-1);
		
		String[] segmentArray = segv.split("\\*");

		
		int segz = segmentArray.length;

		if(segmentArray[3] == null)
		{
			int d =0;
		}
		
		String lastName = DbFakeHPP834EDIchp.findFake("lastName", "String", segmentArray[3].toUpperCase(),faker);

		// if(lastName == "") lastName = faker.name().lastName().toUpperCase();

		segmentArray[3] = lastName;
		
		//System.out.println("SEg arr:  " + segmentArray[4]);

		
		
		if(segz >= 5 ) {
			
			
			
			int y = 99;
	
	

		String firstName = segmentArray[4];
		
		if(!segmentArray[4].equals("")) firstName = DbFakeHPP834EDIchp.findFake("firstName", "String", segmentArray[4].toUpperCase(),faker);

		// String firstName = faker.name().firstName().toUpperCase();
		segmentArray[4] = firstName;

		String middleName = "";
		String middleInitial = "";

		if (segmentArray.length > 5) {

			if (segmentArray[5].length() > 1) {
				middleName = DbFakeHPP834EDIchp.findFake("middleName", "String", segmentArray[5].toUpperCase(),faker);
			}

			else if (segmentArray[5].length()  == 1){
				middleInitial = DbFakeHPP834EDIchp.findFake("middleInitial", "String", segmentArray[5].toUpperCase(),faker);
			}
		}
		// else System.out.println("\n\n\nLEN:" + segmentArray.length + "\n\n\n");
		if (segmentArray.length >= 6)
			segmentArray[5] = middleInitial;

		// String middleName = faker.name().firstName().toUpperCase();
		// String middleInitial = middleName.substring(0,1);
		String SSN = null;
		if (segmentArray.length >= 9) SSN = DbFakeHPP834EDIchp.findFake("SSN", "String", segmentArray[9].toUpperCase(),faker);
	
				
				if (segmentArray.length >= 10)

			//Get identdifer
			//if 834 use SSN else user numericX
			
			
			segmentArray[9] = SSN;
		
		
		
		
}

		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}

		segment += "~";

		return segment;

	}
	
	
	public static String fakeNM1old(String segnm, String segv, Faker faker) {


		// NM1
		if(segv.endsWith("~")) segv = segv.substring(0, segv.length()-1);
		
		String[] segmentArray = segv.split("\\*");
		
		/*

		if (segmentArray.length > 1000) {

			String dummy = segmentArray[0] + "*" + segmentArray[1] + "*" + segmentArray[2] + "*"
					+ "JOJO*DOE***99*000000000~";
			segmentArray = segv.split("\\*");

		}
		
		*/

		// String tail = "**34*180645344~";

		// tpl.setN1P5((Integer.toString(faker.number().numberBetween(711111111,
		// 977777777))));

		String lastName = DbFakeHPP834EDIchp.findFake("lastName", "String", segmentArray[3].toUpperCase(),faker);

		// if(lastName == "") lastName = faker.name().lastName().toUpperCase();

		segmentArray[3] = lastName;

		String firstName = DbFakeHPP834EDIchp.findFake("firstName", "String", segmentArray[4].toUpperCase(),faker);

		// String firstName = faker.name().firstName().toUpperCase();
		segmentArray[4] = firstName;

		String middleName = null;
		String middleInitial = null;

		if (segmentArray.length > 5) {

			if (segmentArray[5].length() > 1) {
				middleName = DbFakeHPP834EDIchp.findFake("middleName", "String", segmentArray[5].toUpperCase(),faker);
			}

			else {
				middleInitial = DbFakeHPP834EDIchp.findFake("middleInitial", "String", segmentArray[5].toUpperCase(),faker);
			}
		}
		// else System.out.println("\n\n\nLEN:" + segmentArray.length + "\n\n\n");
		if (segmentArray.length >= 6)
			segmentArray[5] = middleInitial;

		// String middleName = faker.name().firstName().toUpperCase();
		// String middleInitial = middleName.substring(0,1);

		String SSN = faker.idNumber().ssnValid().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "")
				.replaceAll("\\)", "").replaceAll(" ", "");
		if (segmentArray.length >= 10)
			segmentArray[9] = SSN;

		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}

		segment += "~";

		return segment;

	}

	public static String fakeN3(String segnm, String segv, Faker faker) {


		// N3
		
		if(segv.endsWith("~")) segv = segv.substring(0, segv.length()-1);
		String[] segmentArray = segv.split("\\*");

		String Street1 = null;
		if (segmentArray.length >= 1) Street1 = DbFakeHPP834EDIchp.findFake("Street1", "String", segmentArray[1].toUpperCase(),faker);

		segmentArray[1] = Street1;
		//segmentArray[1] = faker.address().streetAddress().toUpperCase();
		
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}

		segment += "~";

		return segment;

	}
	public static String fakeN4(String segnm, String segv, Faker faker) {


		// N4  Check # stars
		//
		
		String[] cityPool = null;
		
		if(segv.endsWith("~")) segv = segv.substring(0, segv.length()-1);
		String[] segmentArray = segv.split("\\*");

		try {
			cityPool = getRandomAddressPool.cityZip(1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] CITY = cityPool[0].split("\\|");

		segmentArray[1] = CITY[0].toUpperCase();
		segmentArray[2] = CITY[1];
		segmentArray[3] = CITY[3] + faker.number().randomNumber(4, true);

		
		String segment = "";
		
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}

		segment += "~";

		return segment;

	}

	public static String fakePER(String segnm, String segv, Faker faker) {


		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);

	
				
			// PER
		String[] segmentArray = segv.split("\\*");

		
		/*
		if (segmentArray.length > 1000) {

			String dummy = segmentArray[0] + "*" + segmentArray[1] + "*" + segmentArray[2] + "*"
					+ "JOJO*DOE***99*000000000~";
			segmentArray = segv.split("\\*");

		}
*/
		// String tail = "**34*180645344~";

		// tpl.setN1P5((Integer.toString(faker.number().numberBetween(711111111,
		// 977777777))));

		String homePhone = DbFakeHPP834EDIchp.findFake("phone", "String", segmentArray[4].toUpperCase(),faker);
		
		if(segmentArray.length > 5)  {

			String workPhone = DbFakeHPP834EDIchp.findFake("phone", "String", segmentArray[6].toUpperCase(),faker);

		segmentArray[6] = workPhone;
	}
		segmentArray[4] = homePhone;

	
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}

		// System.out.println(segment + "~");
		segment += "~";

		return segment;

	}

	
	public static String fakeREF0f(String segnm, String segv,Faker faker) {
		
		
		//ID FILE 834  (they are all 9 digit)
		//

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		
	
		//If numeric10 do numeric9 and passthrought check digit
		String check = null;
		String body = null;
		if(segmentArray[2].length() == 10) {
			body =   segmentArray[2].substring(0, 9);
			check = segmentArray[2].substring(9, segmentArray[2].length());
		}
		else body = segmentArray[2];
			
		
		
		String refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", body,faker);
		
		if(check != null) segmentArray[2] = refVal + check;
		else  segmentArray[2] = refVal;

		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
				
		return segment;
	}
	
	public static String fakeREFil(String segnm, String segv,Faker faker) {
		

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		
		String refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", segmentArray[2], faker);
		
		segmentArray[2] = refVal;
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
				
		return segment;
	}
	
public static String fakeREF23(String segnm, String segv,Faker faker) {
		

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		
		String refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", segmentArray[2], faker);
		
		segmentArray[2] = refVal;
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
				
		return segment;
	}

public static String fakeREF3h(String segnm, String segv,Faker faker) {
	

	String tilda = segv.substring(segv.length()-1);
	if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
					
	String[] segmentArray = segv.split("\\*");
	
	String refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", segmentArray[2], faker);
	
	segmentArray[2] = refVal;
	
	String segment = "";
	int x = 0;
	for (String seg : segmentArray) {
		++x;
		segment += seg;
		if(x < segmentArray.length) segment +=  "*";
	}
	segment += "~";
			
	return segment;
}

public static String fakeREFzz(String segnm, String segv,Faker faker) {
		
	
	//REF ZZ starts with S + 9 chars  
	//KEEP the S mask 

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);						
		String[] segmentArray = segv.split("\\*");
				
		String  refVal = null;
		
		if(segmentArray[2].startsWith("S")) {
			
			
			//System.out.println("ZZ: " + segmentArray[2]);

			String actualREF = segmentArray[2].substring(1, (segmentArray[2].length()));
			refVal = "S" + DbFakeHPP834EDIchp.findFake("numeric", "String", actualREF, faker);

			
		}
		else {
			
			refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", segmentArray[2], faker);

			
		}
		
		
		segmentArray[2] = refVal;
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
				
		return segment;
	}


public static String fakeREFzzAll9(String segnm, String segv,Faker faker) {
		
	
	//REF ZZ starts with S + 9 chars  
	//KEEP the S mask 

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);						
		String[] segmentArray = segv.split("\\*");
				
		String  refVal = null;

		if(segmentArray[2].startsWith("S")) {
			
			
			//System.out.println("ZZ: " + segmentArray[2]);

			String actualREF = segmentArray[2].substring(1, 9);
			refVal = "S" + DbFakeHPP834EDIchp.findFake("numeric", "String", actualREF, faker);

			
		}
		else {
			
			refVal = DbFakeHPP834EDIchp.findFake("numeric", "String", segmentArray[2], faker);

			
		}
		
		
		segmentArray[2] = refVal;
		
		String segment = "";
		int x = 0;
		for (String seg : segmentArray) {
			++x;
			segment += seg;
			if(x < segmentArray.length) segment +=  "*";
		}
		segment += "~";
				
		return segment;
	}



}
