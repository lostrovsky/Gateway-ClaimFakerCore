package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ust.claimfaker.core.Faker;
import com.ust.claimfaker.core.util.insertSQL;
import com.ust.claimfaker.core.util.personModel;

public class makafaka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String newThing = null;
		
		personModel fakePerson = insertSQL.getPerson();

		String fakeAddress[] = insertSQL.getAddress();
		
		dbSource dbi = new dbSource();
		
		try {
			Connection conn = dbi.getConnection();
			//conn.createStatement("SELECT * FROM integration.us_postal_codes");
								
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM integration.us_postal_codes");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(3)+"  "+rs.getString(4));  
			conn.close();  
			dbi.closeDS();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		for (int x = 0; x < 10; ++x) {
			Faker faker = new Faker();

			String name = faker.name().fullName();
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String middleName = faker.name().firstName();
			String middleInitial = middleName.substring(0, 1).toUpperCase();
			String ssN = faker.idNumber().ssnValid();

			String streetAddress = faker.address().streetAddress();
			String streetAddress2 = faker.address().secondaryAddress();
			String City = faker.address().cityName();
			String State = faker.address().stateAbbr();

			String zipCode = faker.address().zipCode();
			String homePhone = faker.phoneNumber().phoneNumber();
			String cellPhone = faker.phoneNumber().cellPhone();

			String emailAddress = faker.internet().emailAddress();
			System.out.println(firstName + " " + middleInitial + " " + lastName + "(" + middleName + ")" + "," + ssN + "\n"
					+ streetAddress + ",\n" + streetAddress2 + ",\n" + City + ", " + State + "\n" + zipCode + "\n"

					+ homePhone + ",\n" + cellPhone + ",\n"

					+ emailAddress);
			
			
			//String xx = storeDB("eeeeek");
			
			newThing = insertSQL.fakeField("firstName", "String", firstName);
			System.out.println("Oldthing: " + firstName + " NewThing: " + newThing);

		}

	}
	
public static String selectDB(String qry)  {

	
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/integration","integration","integration");  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from account_delta");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(3)+"  "+rs.getString(4));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}
	return "xyzzy";  
	
}
	/*
	 * protected void execute(final ExecutionContext ec) { Faker faker = new
	 * Faker();
	 * 
	 * name = defaultParam("name", ec, faker.name().firstName()); gender =
	 * defaultParam("gender", ec, Gender.values()[new
	 * Random().nextInt(Gender.values().length)]); birthdate =
	 * defaultParam("birthdate", ec, LocalDate.fromDateFields( faker.date().between(
	 * clockService.now().minusYears(30).toDate(), clockService.now().toDate())));
	 * parent = defaultParam("parent", ec, userRepository.listAll().get( new
	 * Random().nextInt(userRepository.listAll().size())));
	 * 
	 * child = childRepository.findOrCreate(name(), gender(), birthdate(),
	 * parent());
	 * 
	 * ec.addResult(this, child()); }
	 * 
	 */
	
	
	
	

}
