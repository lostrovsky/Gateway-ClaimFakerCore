package com.ust.claimfaker.core.util;

import com.ust.claimfaker.core.Faker;

public class FakeHPPEAC {

	
	public static String fakeLastName(String segv, Faker faker) {
	String lastName = DbFakeHPP834EDIchp.findFake("lastName", "String", segv ,faker);
	return lastName;
	}
	
	public static String fakeFirstName(String segv, Faker faker) {		
	String lastName = DbFakeHPP834EDIchp.findFake("firstName", "String", segv ,faker);
	return lastName;
	}
	
	public static String fakeMiddleInitial(String segv, Faker faker) {
	String middleInitial = DbFakeHPP834EDIchp.findFake("middleInitial", "String", segv ,faker);
	return middleInitial;
	}
		
	public static String fakePhone(String segv, Faker faker) {
	String phone = DbFakeHPP834EDIchp.findFake("phone", "String", segv ,faker);
	return phone;
	}
	

	public static String fakeAddressLine1(String segv, Faker faker) {
		String addressLine1 = DbFakeHPP834EDIchp.findFake("addressLine1", "String", segv ,faker);
		return addressLine1;
		}

	
	public static String fakeAddressLine2(String segv, Faker faker) {
		String addressLine1 = DbFakeHPP834EDIchp.findFake("addressLine2", "String", segv ,faker);
		return addressLine1;
		}
	public static String fakeZipExt(String segv, Faker faker) {
		String zipExt = DbFakeHPP834EDIchp.findFake("zipExt", "String", segv ,faker);
		return zipExt;
		}
					
			
		
	public static String fakeNM1(String segnm, String segv, Faker faker) {


		// NM1
		if(segv.endsWith("~")) segv = segv.substring(0, segv.length()-1);
		
		String[] segmentArray = segv.split("\\*");

		if (segmentArray.length > 1000) {

			String dummy = segmentArray[0] + "*" + segmentArray[1] + "*" + segmentArray[2] + "*"
					+ "JOJO*DOE***99*000000000~";
			segmentArray = segv.split("\\*");

		}

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

		segmentArray[1] = faker.address().streetAddress().toUpperCase();
		
		
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

		if (segmentArray.length > 1000) {

			String dummy = segmentArray[0] + "*" + segmentArray[1] + "*" + segmentArray[2] + "*"
					+ "JOJO*DOE***99*000000000~";
			segmentArray = segv.split("\\*");

		}

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

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		
		String refVal = DbFakeHPP834EDIchp.findFake("ref0f", "String", segmentArray[2],faker);
		
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
		
		String refVal = DbFakeHPP834EDIchp.findFake("ref3h", "String", segmentArray[2], faker);
		
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
public static String fakeREFil(String segnm, String segv,Faker faker) {
		

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		
		String refVal = DbFakeHPP834EDIchp.findFake("refil", "String", segmentArray[2], faker);
		
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
	

public static String fakeNumerics(String segv, Faker faker) {
		
	
	//REF ZZ starts with S + 9 chars  
	//KEEP the S mask 

		String tilda = segv.substring(segv.length()-1);
		if((int) tilda.toCharArray()[0] == 126) segv = segv.substring(0,segv.length()-1);
						
		String[] segmentArray = segv.split("\\*");
		String actualREF = segmentArray[0];

		
		if(segmentArray.length > 1) actualREF = segmentArray[2];
		

		String  refVal = null;
		String elementType = null;
		
		if(segmentArray[0].startsWith("S")) {
			
			//System.out.println("ZZ: " + segmentArray[2]);

			 actualREF = segmentArray[2].substring(1, 9); 
			
			//Numerics logging
			//
			elementType = "numeric" +  actualREF.length();		
			refVal = "S" + DbFakeHPP834EDIchp.findFake(elementType, "String", actualREF, faker);
		}
		else {
			
			elementType = "numeric" +  actualREF.length();			
			refVal = DbFakeHPP834EDIchp.findFake(elementType, "String", actualREF, faker);
			
		}
				
		
		return refVal;
	}
}
