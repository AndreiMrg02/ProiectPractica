package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connection.MyConnection;

public class Employee {
	
	private String srNo;
	private String fname;
	private String lname;
	private String departament;
	private String designation;
	private String contact;
	private String address;
	private String salary;

	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public Employee()
	{
		conn =  MyConnection.getInstance().getConnection();
	}
	
	

	public void addEmployee(JTextField fn,JTextField ln,JTextField contact_f, JTextField address_f, JTextField salaryField , JComboBox<String> departament_b, JComboBox<String> designation_b )
	{
		int p = JOptionPane.showConfirmDialog(null, "Are you sure to add this record?","Add Record", JOptionPane.YES_NO_OPTION);
		
		if(p == 0)
		{
			String sql = "INSERT INTO `employee_list`(`fname`, `lname`, `departament`, `designation`, `number`, `address`, `salary`) VALUES (?,?,?,?,?,?,?)";
			
			 fname = fn.getText();
			 lname = ln.getText();
			 contact = contact_f.getText();
			 address = address_f.getText();
			 salary = salaryField.getText();
			
			if(fname.equalsIgnoreCase("")) { 
				JOptionPane.showMessageDialog(null, "ERROR: First Name filed is empty");
			} else if(fname.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Last Name filed is empty");
			} else if(contact.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Number filed is empty");
			}else if(address.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Address filed is empty");
			}else if(salary.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Salary filed is empty");
			}else if(departament_b.getSelectedItem().equals("Select departament"))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Select departament");
			}
			else {
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, fn.getText());
				ps.setString(2, ln.getText());
				ps.setString(3, departament_b.getSelectedItem().toString());
				ps.setString(4, designation_b.getSelectedItem().toString());
				ps.setString(5, contact_f.getText());
				ps.setString(6, address_f.getText());
				ps.setString(7, salaryField.getText());
				
				ps.execute();
				JOptionPane.showMessageDialog(null, "Data stored successfully");
			} 
			catch (Exception ex) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, ex);
				 
			}
			
		  }
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Error! Check the information again !");		
			
		}
	}
	
	public void updateEmployee(JTextField srNoUpdateField, JTextField fnUpdateField, JTextField lnUpdateField, JTextField departamentBoxUpdate, JTextField designationBoxUpdate, JTextField contactUpdateField, JTextField addressUpdateField )
	{
		srNo = srNoUpdateField.getText();
		fname = fnUpdateField.getText();
		lname = lnUpdateField.getText();
		departament = departamentBoxUpdate.getText();
		designation = designationBoxUpdate.getText();
		contact = contactUpdateField.getText();;
		address = addressUpdateField.getText();
		
		int p = JOptionPane.showConfirmDialog(null, "Are you sure to update this record?", "Update Record", JOptionPane.YES_NO_OPTION);
		if(fname.equalsIgnoreCase("")) { 
			JOptionPane.showMessageDialog(null, "ERROR: First Name filed is empty");
		} else if(fname.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: Last Name filed is empty");
		} else if(contact.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: Number filed is empty");
		}else if(address.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: Address filed is empty");
		}else if(departament.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: Departament filed is empty");
		}else if(designation.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: Designation filed is empty");
		}else if(srNo.equals(""))
		{
			JOptionPane.showMessageDialog(null, "ERROR: SrNo filed is empty");
		} else {
		if(p == 0)
		{
			String sql = "UPDATE `employee_list` SET `srno`='"+srNo+"',`fname`='"+fname+"',`lname`='"+lname+"',`departament`='"+departament+"',`designation`='"+designation+"',`number`='"+contact+"',`address`='"+address+"' WHERE `srno`='"+srNo+"'";
			try {
				ps = conn.prepareStatement(sql);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Data updated succesfully!");
				
				srNoUpdateField.setText("");
				fnUpdateField.setText("");
				lnUpdateField.setText("");
				departamentBoxUpdate.setText("");
				designationBoxUpdate.setText("");
				contactUpdateField.setText("");
				addressUpdateField.setText("");
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null, ex);
			}
		}
		}
	
	}
	
	public void updateEmployeeSalary(JTextField srNoUpdateField, JTextField grossSalary)
	{
		srNo = srNoUpdateField.getText();
		String gross =  grossSalary.getText();
		String sql = "UPDATE `employee_list` SET `srno`='"+srNo+"',`salary`='"+gross+"' WHERE `srno`='"+srNo+"'";
			try {
				ps = conn.prepareStatement(sql);
				ps.execute();
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null, ex);
			}
		
	
	}
	
	
	public void deleteEmployee(JTextField srNoDeleteField, JTextField fnDeleteField, JTextField lnDeleteField, JTextField departamentDeleteField, JTextField designationDeleteField, JTextField contactDeleteField, JTextField addressDeleteField )
	{
		int p = JOptionPane.showConfirmDialog(null, "Are you sure to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION);
		String srNoVerify = srNoDeleteField.getText();
		String fnameVerify = fnDeleteField.getText();
		if(srNoVerify.equalsIgnoreCase("")) { 
			JOptionPane.showMessageDialog(null, "ERROR: SrNo filed is empty");
		}else if(fnameVerify.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "ERROR: Check information again!");
		}
		else { 
		try {
		if(p == 0)
		{
			String sql = "delete from employee_list where srno = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, srNoDeleteField.getText());
				ps.execute();
				
				
				JOptionPane.showMessageDialog(null, "Data deleted from database succesfully!");
				srNoDeleteField.setText("                                                                Enter Employee ID to search");
				
				lnDeleteField.setText("");
				fnDeleteField.setText("");
				departamentDeleteField.setText("");
				designationDeleteField.setText("");
				contactDeleteField.setText("");
				addressDeleteField.setText("");
			}
			} catch (Exception ex) {
				
				JOptionPane.showMessageDialog(null, ex);
			}
		}
	}
	public void selectDesignation(JComboBox<String> departament_b, JComboBox<String> designation_b)
	{
		
		Iterator<String> iterator;
		ArrayList<String> array =  new ArrayList<String>();
		if(departament_b.getSelectedItem().equals("Departament1"))
		{
			designation_b.removeAllItems();
			array.add("a");
			array.add("b");
			array.add("c");
			array.add("d");
			iterator = array.iterator();
			
			while(iterator.hasNext())
			{
				designation_b.addItem(iterator.next());
			}
		}else if(departament_b.getSelectedItem().equals("Departament2"))
		{
			designation_b.removeAllItems();
			array.add("e");
			array.add("f");
			array.add("g");
			array.add("h");
			iterator = array.iterator();
			
			while(iterator.hasNext())
			{
				designation_b.addItem(iterator.next());
			}
		}else if(departament_b.getSelectedItem().equals("Departament3"))
		{
			designation_b.removeAllItems();
			array.add("i");
			array.add("j");
			array.add("k");
			array.add("l");
			iterator = array.iterator();
			
			while(iterator.hasNext())
			{
				designation_b.addItem(iterator.next());
			}
		}else if(departament_b.getSelectedItem().equals("Departament4"))
		{
			designation_b.removeAllItems();
			array.add("m");
			array.add("n");
			array.add("o");
			array.add("p");
			iterator = array.iterator();
			
			while(iterator.hasNext())
			{
				designation_b.addItem(iterator.next());
			}
		}else if(departament_b.getSelectedItem().equals("Select departament"))
		{
			designation_b.removeAllItems();
		}
	}
	
	public boolean verifySrNo(String srno, JTextField srNoEmployee)
	{
			String query = "SELECT * FROM `employee_list` WHERE `srno`=?";
			
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, srno);
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					return false;
				}
				else
				{
						
					return true;
					
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			return false;
	}

}
