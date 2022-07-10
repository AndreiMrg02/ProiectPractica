package system;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connection.MyConnection;

public class Salary {
	
	String srNo;
	Double people; 
	BigDecimal overTime;
	BigDecimal netSalary; // NET
	BigDecimal grossSalary; // BRUT
	BigDecimal socialInsurance; // CAS
	BigDecimal healthInsurance;// CASS
	BigDecimal incomeTax; // IC
	BigDecimal persoanlDeducion; // PD
	BigDecimal overTimeHour; 
	BigDecimal totalMoneyOverTime; 
	
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	
	public Salary()
	{
		conn = MyConnection.getInstance().getConnection();
	}
	
	public void calculateSalary(JTextField grossField, JTextField socialInsuranceField,JTextField healthInsuranceField,
								JTextField peopleField, JTextField persoanlDeducionField, JTextField overTimeField,
								JTextField netSalaryField, JTextField overTimeHourField , JTextField totalMoneyOverTimeField,
								JTextField incomeTaxField)
	
	{
		String grosscheck = grossField.getText();
		String peoplecheck = peopleField.getText();
		String overtimecheck = overTimeField.getText();
		String overtimehourcheck = overTimeHourField.getText();
		
		if(grosscheck.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Gross Field is empty!");
			
		}else if(peoplecheck.equals(""))
		{
			JOptionPane.showMessageDialog(null, "People Field is empty!");
		} else if(overtimecheck.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Overtime Field is empty!");
		} else if(overtimehourcheck.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Overtime Hour Field is empty!");
		} else
		{
			BigDecimal result =  divdeBigDecimal(new BigDecimal("10"),new BigDecimal("100"));
			grossSalary = new BigDecimal(grossField.getText());
			BigDecimal incomeFinal;
			
			//  --------------------  socialInsurance  -------------------- 
			socialInsurance = result.multiply(grossSalary);
			socialInsuranceField.setText(socialInsurance.toString());

			//  --------------------  healthInsurance  -------------------- 
			result =  divdeBigDecimal(new BigDecimal("25"),new BigDecimal("100"));
			healthInsurance = result.multiply(grossSalary);
			healthInsuranceField.setText(healthInsurance.toString());
			// ---------------------- Personal Deduction -------------------
			persoanlDeducion = personalDeductionCalculate(peopleField, persoanlDeducionField);
			persoanlDeducionField.setText(persoanlDeducion.toString());
			// -------------------- OverTime ----------------
			overTimeHour = new BigDecimal(overTimeHourField.getText());
			overTime = new BigDecimal(overTimeField.getText());
			totalMoneyOverTime =  overTimeHour.multiply(overTime);
			totalMoneyOverTimeField.setText(totalMoneyOverTime.toString());
			
			// --------------------- Income Tax -------------------
			result =  divdeBigDecimal(new BigDecimal("10"),new BigDecimal("100"));
			incomeFinal =  persoanlDeducion.add(totalMoneyOverTime).add(healthInsurance).add(socialInsurance);
			incomeTax = (grossSalary.subtract(incomeFinal)).multiply(result);
			
			if(incomeTax.compareTo(BigDecimal.ZERO) < 0)
			{
				incomeTax =  new BigDecimal("0");
			}
			incomeTaxField.setText(incomeTax.toString());
			
			
			
			//                                              -------------------- netSalary --------------------------
			netSalary =  grossSalary.add(overTime).subtract(socialInsurance.add(healthInsurance).add(incomeTax));
			netSalaryField.setText(netSalary.toString());
		}
		
		
		
		
	}
	public BigDecimal divdeBigDecimal(BigDecimal a, BigDecimal b)
	{
		BigDecimal result = a.divide(b);
		
		return result;
	}
	public void overTimeCalculate(JTextField grossField, JTextField socialInsuranceField,JTextField healthInsuranceField,
			JTextField peopleField, JTextField persoanlDeducionField, JTextField overTimeField,
			JTextField netSalaryField)
	{
	
		
		
	}
	
	public BigDecimal personalDeductionCalculate( JTextField peopleField, JTextField persoanlDeducionField)
	{
		people =  Double.parseDouble(peopleField.getText());
		if(people == 0)
		{
			persoanlDeducion = new BigDecimal("510");
		}
		else if(people == 1)
		{
			persoanlDeducion =  new BigDecimal("670");
		}else if(people == 2)
		{
			persoanlDeducion =  new BigDecimal("830");
		}else if(people == 3)
		{
			persoanlDeducion = new BigDecimal("990");
		} else if(people >= 4)
		{
			persoanlDeducion =  new BigDecimal("1310");
		}
		
		return persoanlDeducion;
	}
	
	public void addEmployee(JTextField srNoField ,JTextField grossField, JTextField socialInsuranceField,JTextField healthInsuranceField,
			JTextField peopleField, JTextField persoanlDeducionField, JTextField overTimeField,
			JTextField netSalaryField, JTextField overTimeHourField , JTextField totalMoneyOverTimeField,
			JTextField incomeTaxField )
	{
		int p = JOptionPane.showConfirmDialog(null, "Are you sure to add this record?","Add Record", JOptionPane.YES_NO_OPTION);
		
		if(p == 0)
		{
			String sql = "INSERT INTO `salary_list`(`srno`, `grossSalary`, `deductionPeople`, `personalDeduction`, `healthInsurance`, `socialInsurance`, `overtime`, `overtimeHour`, `overtimeTotal`, `incomeTax`, `netSalary`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			 srNo = srNoField.getText();
			 String grosscheck = grossField.getText();
			String peoplecheck = peopleField.getText();
			String overtimecheck = overTimeField.getText();
			String overtimehourcheck = overTimeHourField.getText();
			String totalMoneyOverTimeCheck =  totalMoneyOverTimeField.getText();
				if(grosscheck.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Gross Field is empty!");
					
				}else if(peoplecheck.equals(""))
				{
					JOptionPane.showMessageDialog(null, "People Field is empty!");
				} else if(overtimecheck.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Overtime Field is empty!");
				} else if(overtimehourcheck.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Overtime Hour Field is empty!");
				} else if(srNo.equalsIgnoreCase("")) { // verificam daca caseta cu username este goala	
				JOptionPane.showMessageDialog(null, "ERROR: SrNo filed is empty");
			}else if(totalMoneyOverTimeCheck.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR: Data error! ");
			}
				else {
			
			try {
				
				if( verifySrNoSalary( srNo,  srNoField) ==  true)
					{
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, srNo);
					ps.setString(2, grossField.getText());
					ps.setString(3, peopleField.getText());
					ps.setString(4, persoanlDeducionField.getText());
					ps.setString(5, healthInsuranceField.getText());
					ps.setString(6, socialInsuranceField.getText());
					ps.setString(7, overTimeField.getText());
					ps.setString(8, overTimeHourField.getText());
					ps.setString(9, totalMoneyOverTimeField.getText());
					ps.setString(10, incomeTaxField.getText());
					ps.setString(11, netSalaryField.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data stored successfully");
					
					resetField( srNoField , grossField,  socialInsuranceField, healthInsuranceField,
							 peopleField,  persoanlDeducionField,  overTimeField,
							 netSalaryField,  overTimeHourField ,  totalMoneyOverTimeField,
							 incomeTaxField);
							
				    }
				else {
					resetField( srNoField , grossField,  socialInsuranceField, healthInsuranceField,
							 peopleField,  persoanlDeducionField,  overTimeField,
							 netSalaryField,  overTimeHourField ,  totalMoneyOverTimeField,
							 incomeTaxField);
					JOptionPane.showMessageDialog(null, "ERROR: SrNo exist");
					}
				
				
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
	
	public boolean verifySrNoSalary(String srno, JTextField srNoGenerateField)
	{
			String query = "SELECT * FROM `salary_list` WHERE `srno`=?";
			
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
	
	
	public void resetField(JTextField srNoField ,JTextField grossField, JTextField socialInsuranceField,JTextField healthInsuranceField,
			JTextField peopleField, JTextField persoanlDeducionField, JTextField overTimeField,
			JTextField netSalaryField, JTextField overTimeHourField , JTextField totalMoneyOverTimeField,
			JTextField incomeTaxField ){
		
		srNoField.setText("");
		grossField.setText("");
		socialInsuranceField.setText("");
		healthInsuranceField.setText("");
		peopleField.setText("");
		persoanlDeducionField.setText("");
		overTimeField.setText("");
		netSalaryField.setText("");
		overTimeHourField.setText("");
		totalMoneyOverTimeField.setText("");
		incomeTaxField.setText("");

		
		
	}
	
}
