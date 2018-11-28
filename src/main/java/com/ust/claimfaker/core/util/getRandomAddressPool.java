package com.ust.claimfaker.core.util;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;



public class getRandomAddressPool {
	static Connection conn = null;

	public static String[] cityZip(int lim) throws Exception {

		String[] csv = new String[lim];
		ResultSetMetaData rsmd = null;

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/integration?" + "user=integration&password=integration");

			Statement stmt = conn.createStatement();

			String qry = "SELECT CITY,ST,upper(COUNTY),ZIP,Latitude,Longitude FROM integration.us_postal_codes " + 
					"WHERE ((Latitude > 39 AND Latitude < 40 AND Longitude > -76 AND Longitude < -73) " + 
					"OR COUNTY = \"Philadelphia\") " + 
					"AND ST=\"PA\"" + 
					" order by RAND()"; 
					
			String dbopts = " LIMIT " + lim;
			ResultSet rs = stmt.executeQuery(qry + dbopts);
			while (rs.next()) {

	//			System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
				csv[0] =  rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4);
				
			//	csv += rs2csvr.convertIGPToCsv(rs) + "\n";

			}
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}

		conn.close();

		return csv;

	}
	
	public static String getCSVpractioner(int lim) throws Exception {

		String csv = "";
		ResultSetMetaData rsmd = null;
		List ThisOne;

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/integration?" + "user=integration&password=integration");

			Statement stmt = conn.createStatement();

			String qry = "SELECT PRACTITIONER_ID, PRACT_KEY,FIRST_NAME,MIDDLE_NAME,LAST_NAME, NPI,PCP,OBGYN, SPECIALIST, PRACTITIONER_ROLE_NAME, PRACTITIONER_ROLE_STATUS, PRIMARY_LANGUAGE, NAME_PREFIX, SUFFIX_NAME, GENDER, FIRST_ACTIVE_DATE, ADDRESS_LINE, ADDRESS_LINE_2, ADDRESS_LINE_3, COUNTRY, COUNTY, STATE, CITY, ZIPCODE, ZIPCODE4, PRIMARY_SPECIALTY, SECONDARY_SPECIALTY, PHONE, PHONE_EXTENSION, ETHNICITY"
					+ " FROM integration.practitioner_delta ";
					
			String ORDER = " ORDER BY PRACTITIONER_ID";
		
			
			String LIMIT = " LIMIT " + lim;
			System.out.println(qry + ORDER + LIMIT);
			ResultSet rs = stmt.executeQuery(qry + ORDER + LIMIT);
			ResultSetMetaData meta = rs.getMetaData();

			int numberOfColumns = meta.getColumnCount();
					     
		     
		     List<LinkedHashMap<String, Object>> xyz = convertResultSetToList(rs);
		     
		     
		     
		     


int x=0;
			while(!xyz.isEmpty()) {
				
				//csv += convertPractitionerToCsv(xyz) + "\n";
				
				System.out.println("hey " + xyz.toString());



				
			}
			
			while (rs.next()) {
				int z=0;

			}
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}

		conn.close();

		System.out.println("bye\n");
		return csv;

	}
	
	public static List<LinkedHashMap<String, Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    //HashMap<String,Object> row = new HashMap<String,Object>();
	    List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
	    
	    
	    
        LinkedHashMap<String,Object> row = new LinkedHashMap<String, Object>(columns);


	    while (rs.next()) {
	        for(int i=1; i<=columns; ++i) {
	           row.put(md.getColumnName(i),rs.getObject(i));
	        }
	        list.add(row);
	    }

	    return list;
	}
	
	
	public static List resultSetToArrayList(ResultSet rs) throws SQLException{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  ArrayList list = new ArrayList(50);
		  while (rs.next()){
		     HashMap row = new HashMap(columns);
		     for(int i=1; i<=columns; ++i){           
		      row.put(md.getColumnName(i),rs.getObject(i));
		     }
		      list.add(row);
		  }

		 return list;
		}

}
