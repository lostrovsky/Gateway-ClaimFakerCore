package com.ust.claimfaker.core.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class dbSource {


	 
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
 
    static {
    	config.setDriverClassName("com.mysql.jdbc.Driver");
    	config.setConnectionTestQuery("SELECT 1");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/integration");
        config.setUsername( "integration" );
        config.setPassword( "integration" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.addDataSourceProperty( "useSSL" , "false" );
        ds = new HikariDataSource( config );
    }
 
    public dbSource() {}
 
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public void closeDS() {
    	
    	
   ds.close(); 	
    }
}