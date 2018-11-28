package com.ust.claimfaker.core.util;

import com.ust.claimfaker.core.Faker;

public class a {

	public static void main(String[] args) {
		
		
		Faker faker = new Faker();
		String ID ="723456789";
		int c = 1959;
		c=2884;
		
		//check this out
		++c;
		System.out.println(c);

		
		String news = DbFake.findFake("CSIRID","String",ID);
		System.out.println(news);
		
		
		String padded = String.format("%-14s", faker.name().lastName().toUpperCase()); 
		
		for(int i = 0, j = 10;i<100;++i, ++j) {
			
		padded = String.format("%-14s", faker.name().lastName());
		
		news = DbFake.findFake("LastName","String",padded);			
		System.out.println(news);		
		
		
		
			
		}
		// TODO Auto-generated method stub

	}

}
