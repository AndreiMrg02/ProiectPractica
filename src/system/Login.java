package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.MainMenu;
import connection.MyConnection;

public class Login {
	
	private String uname;
	private String pass;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public Login()
	{
		conn =  MyConnection.getInstance().getConnection();
	}
	
	
	public void loginConnection(JPasswordField passField,JTextField usernField,JFrame frame )
	{
		
		uname =  usernField.getText();
	    pass =  String.valueOf(passField.getPassword());
	    
		if(uname.equalsIgnoreCase("")) { 
			JOptionPane.showMessageDialog(null, "Username filed is empty");
		} else if(pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Password filed is empty");
		} else
		{
			String query = "SELECT * FROM `user` WHERE `uname`=? AND `pass`=?";
			String firstAndLastName;
			String designation;
			 
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, uname);
				ps.setString(2, pass);
				
				rs = ps.executeQuery();
				if(rs.next())
				{
					
					JOptionPane.showMessageDialog(null, "Login Succsessful !");
					passField.setText("");
					usernField.setText("");
					
					firstAndLastName =  rs.getString(3) + " " + rs.getString(4) ;
					designation  =  rs.getString(5);
					
					@SuppressWarnings("unused")
					MainMenu menu =  new MainMenu(firstAndLastName,designation);
					frame.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login Failed");
					passField.setText("");
					usernField.setText("");
					
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
}
