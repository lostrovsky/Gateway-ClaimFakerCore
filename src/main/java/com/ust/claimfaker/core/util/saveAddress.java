package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class saveAddress {

	
	
	public static void saveAL(ArrayList<fakes> rec) {
		
		ArrayList<fakes> chunk = new ArrayList<fakes>();
		
		
		String qry = "INSERT INTO integration.fakery (fieldName, fieldType, fieldOrig, fieldFake) " + "VALUES ('"
				+ rec.get(0).fieldName + "', '" + rec.get(0).fieldType + "', '" + rec.get(0).fieldOrig + "', '" + rec.get(0).fieldFake + "')";


		System.out.println(" sql! " + qry + "\n");

		ArrayList<location> placeResult = new ArrayList<location>();
		//ArrayList<location> fakeAddress = loc;

		int x = 9;

		String[] poolPlace = new String[4];
		
		ArrayList<location> locationResult = new ArrayList<location>();

		try {

			// poolPlace[0]=null;

			dbSource dbi = new dbSource();

			Connection conn = dbi.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(qry);
			conn.close();
			// dbi.closeDS();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
