package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.util.insertSQL;
import com.ust.claimfaker.core.util.personModel;

public class CityStatZipPool {

	static String oqry = "SELECT upper(CITY),upper(ST),upper(COUNTY),ZIP,Latitude,Longitude FROM integration.us_postal_codes "
			+ "WHERE ((Latitude > 39 AND Latitude < 40 AND Longitude > -76 AND Longitude < -73) "
			+ "OR COUNTY = \"Philadelphia\") " + "AND ST=\"PA\"" + " order by RAND() Limit 1";

	static String qry = "SELECT upper(CITY),upper(ST),upper(COUNTY),ZIP FROM integration.us_postal_codes "
			+ "WHERE ((Latitude > 39 AND Latitude < 40 AND Longitude > -76 AND Longitude < -73) "
			+ "OR COUNTY = \"Philadelphia\") " + "AND ST=\"PA\"" + " order by RAND() Limit 1";

		
	public static ArrayList<location>  getPool() {
		
		
	personModel fakePerson = insertSQL.getPerson();
	
	String[] poolPlace = new String[4];;
	ArrayList<location> locationResult = new ArrayList<location>();


	try
	{	
		
		//poolPlace[0]=null;

		dbSource dbi = new dbSource();

		Connection conn = dbi.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(qry);
		locationResult = getAL(rs);


		
		
		
		
while (rs.next())
			
 	System.out.println("xxxx" + rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
		conn.close();
		//dbi.closeDS();

	}catch(
	SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return locationResult;
	
	
	
	
	//return poolPlace;

}


public static String[] getAddress() {
	
	
	
	//fakes recs = new fakes();			

	
    Random rn = new Random();

	
	Faker faker = new Faker();
	
	
	
	String[] fakeAddress = new String[8];
	fakeAddress[0] = faker.address().streetAddress();
	if(rn.nextInt() % 2 == 0) fakeAddress[1] =  faker.address().secondaryAddress();
	else {
		fakeAddress[1] = faker.address().secondaryAddress().replaceAll("[a-zA-Z0-9.,#]", " ");
	}
	fakeAddress[2] = faker.address().cityName();
	fakeAddress[3] = faker.address().stateAbbr();
	fakeAddress[4] = faker.address().zipCodeByState(fakeAddress[3]);
	fakeAddress[5] = faker.number().digits(4);
	String homePhone = 
			faker.phoneNumber().cellPhone().replaceAll("\\.", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");

	if(homePhone.startsWith("1")) homePhone = homePhone.substring(1, 10);	
	else homePhone = homePhone.substring(0, 10);		
	
	fakeAddress[6] = homePhone;
	fakeAddress[7] = faker.internet().emailAddress();

	
	//for(int i = 0;i < fakeAddress.length;++i) System.out.println(fakeAddress[i]);		
		
	return fakeAddress;
	
}

public static ArrayList<location> getAL(ResultSet rs) {
	
	 ArrayList<location> placeResult = new ArrayList<location>();
		String fakeAddress[] = getAddress();
		

	try {
		while(rs.next()) {			
		//System.out.println(fakeAddress[0].toUpperCase() + "|" +  fakeAddress[1].toUpperCase() + "|" +  rs.getString(1).toUpperCase() + "|" +  rs.getString(3).toUpperCase() + "|" +  rs.getString(2).toUpperCase() + "|" +  rs.getString(4).toUpperCase() + "|" +  fakeAddress[5].toUpperCase() + "|" +  fakeAddress[7].toUpperCase() + "|" +  fakeAddress[6].toUpperCase());
			placeResult.add(new location(fakeAddress[0].toUpperCase(), fakeAddress[1].toUpperCase(), rs.getString(1).toUpperCase(), rs.getString(3).toUpperCase(), rs.getString(2).toUpperCase(), rs.getString(4).toUpperCase(), fakeAddress[5].toUpperCase(), fakeAddress[7].toUpperCase(), fakeAddress[6].toUpperCase()));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
//	String[] pool = CityStatZipPool.getPool();


	
	
	return placeResult;
	



}
}