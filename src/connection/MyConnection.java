package connection;

import java.sql.*;


public class MyConnection {
	private static MyConnection instance = null;
	private static Connection con = null;
	
	private MyConnection()
	{
		con = null;
	}
	  public static MyConnection getInstance()
	  {
		 if(instance  == null) {
			  return new MyConnection();
		  }
		return instance;
	  }
	public Connection getConnection()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dbEmployee_test","root","");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}

}