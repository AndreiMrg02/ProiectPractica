package connection;

import java.sql.*;

import javax.swing.JOptionPane;


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
			JOptionPane.showMessageDialog(null, "Database is not connected !");
			System.out.println(ex.getMessage());
		}
		return con;
	}

}