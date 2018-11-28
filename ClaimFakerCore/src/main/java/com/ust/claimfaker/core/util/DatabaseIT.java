package com.ust.claimfaker.core.util;




//import ch.vorburger.mariadb4j.DB;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseIT {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enableDatabaseMySQLTest();

	}


	

       public static void enableDatabaseMySQLTest() {
        try {
          //  final DB database = DB.newEmbeddedDB(3306);
          //  database.start();
//            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=integration&password=integration")) {
//                try (Statement statement = conn.createStatement()) {
//                    statement.executeUpdate("CREATE DATABASE db");
//                }
//            }
            final HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.jdbc.Driver");
            config.setConnectionTestQuery("SELECT 1");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/integration");
            config.setUsername("integration");
            config.setPassword("integration");
            config.setMaxLifetime(60000);
            config.setIdleTimeout(45000);
            config.setMaximumPoolSize(50);
            final HikariDataSource ds = new HikariDataSource(config);
            ds.close();
         //   database.stop();
        } catch (final Exception ex) {
            //Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, "Failed to enable database.", ex);
            //Assert.fail();
//        	System.out.println(ex.getMessage());
        }
    }
}