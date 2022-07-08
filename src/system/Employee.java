package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			if(fname.equalsIgnoreCase("")) { // verificam daca caseta cu username este goala	
				JOptionPane.showMessageDialog(null, "ERROR: First Name filed is empty");
			} else if(fname.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Last Name filed is empty");
			} else if(fname.equals(""))
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
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	

}
