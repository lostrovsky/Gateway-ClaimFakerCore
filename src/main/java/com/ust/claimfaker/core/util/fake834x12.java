package com.ust.claimfaker.core.util;

import java.text.SimpleDateFormat;

import com.ust.claimfaker.core.Faker;

public class fake834x12 {

	public static void main(String[] args) {
		
		Faker fake = new Faker();
		SimpleDateFormat YMD = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat HM = new SimpleDateFormat("hhmm");
		
		System.out.println("ISA*00*          *00*          *ZZ*" + Long.toString(fake.number().randomNumber(15, false))
				+ "*ZZ*" + Long.toString(fake.number().randomNumber(15, false)) + "*"
				+ YMD.format(fake.date().birthday(1, 5)) + "*" + YMD.format(fake.date().birthday(-2, -1)) + "*>*"
				+ "00501*" + Integer.toString(fake.number().numberBetween(811111111, 910777777)) + "*0*T~");

		System.out.println("GS*BE*" + Long.toString(fake.number().randomNumber(10, false)) + "*"
				+ Long.toString(fake.number().randomNumber(10, false)) + "*"
				+ Long.toString(fake.number().randomNumber(10, false)) + "*"
				+ Integer.toString(fake.number().numberBetween(811111111, 910777777)) + "*" + "20080503" + "*" + "1705"
				+ "*20213*X*005010X220A1~");
		System.out.println("ST*834*" + Long.toString(fake.number().randomNumber(5, false)) + "*005010X220A1~");

		System.out.println("BGN*00*" + Long.toString(fake.number().randomNumber(6, false)) + "*"
				+ YMD.format(fake.date().birthday(2, 93)) + "*" + HM.format(fake.date().birthday(2, 93)) + "****2~");

		System.out.println("N1*P5**FI*" + Long.toString(fake.number().randomNumber(9, false)) + "~");

		System.out.println("N1*IN**FI*" + Long.toString(fake.number().randomNumber(9, false)) + "~");

		System.out.println("INS*Y*18*021*20*A***FT~");

		System.out.println("REF*0F*202443307~");

		System.out.println("REF*1L*123456001~");

		System.out.println("DTP*356*D8*" + YMD.format(fake.date().birthday(-2, 5)) + "~");

		System.out.println("NM1*IL*1*" + fake.name().lastName().toUpperCase() + "*"
				+ fake.name().firstName().toUpperCase() + "****34*202443307~");
		System.out.println("PER*IP**HP*7172343334*WP*7172341240~");

		System.out.println("N3*" + Long.toString(fake.number().randomNumber(4, false)) + " "
				+ fake.address().streetName().toUpperCase() + "~");

		System.out.println("N4*" + fake.address().city().toUpperCase() + "*PA*171110000~");

		System.out.println("DMG*D8*19700614*M~");
		System.out.println("HD*021**HMO~");
		System.out.println("DTP*348*D8*19960601~");
		System.out.println("LX*01~");
		System.out.println("NM1*P3*1*" + fake.name().lastName().toUpperCase() + "*"
				+ fake.name().firstName().toUpperCase() + "**DR**SV*143766*25~");
		System.out.println("SE*18*12345~");
		System.out.println("GE*1*20213~");
		System.out.println("IEA*1*000010216~");

	}

}
