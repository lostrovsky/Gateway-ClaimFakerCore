package com.ust.claimfaker.core.util;

import java.util.ArrayList;

import com.ust.claimfaker.core.Faker;


public class getPool {

	public static void main(String[] args) {

		
		ArrayList<location> poolLocation = new ArrayList<location>();
		
		

		for (int i = 0; i < 10000; ++i) {

			poolLocation = CityStatZipPool.getPool();

			System.out.println("PL: " + poolLocation.get(0).Street1);
			System.out.println("PL: " + poolLocation.get(0).Street2);

			System.out.println("PL: " + poolLocation.get(0).City);
			System.out.println("PL: " + poolLocation.get(0).State);
			System.out.println("PL: " + poolLocation.get(0).County);
			System.out.println("PL: " + poolLocation.get(0).Zip);

			System.out.println("PL: " + poolLocation.get(0).Email);
			System.out.println("PL: " + poolLocation.get(0).HomePhone);
			
			
			
			

		}

	}
}
