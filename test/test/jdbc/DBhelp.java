package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBhelp {

	private final String url = "jdbc:mysql://localhost:3306/googlemail";
	private final String name = "root";
	private final String password = "jigejige";
	private final String forname = "com.mysql.jdbc.Driver";
	
	
	
	private static DBhelp dbhelp = null;

	private DBhelp() throws Exception  {
			Class.forName(forname);
	}
 
	public Connection getConnection() throws Exception {
		return  DriverManager.getConnection(url, name, password);
	}

	public static DBhelp GetInstance() throws Exception  {
		if (dbhelp == null) 
			 dbhelp=new DBhelp();
		return dbhelp ;
	}


}
