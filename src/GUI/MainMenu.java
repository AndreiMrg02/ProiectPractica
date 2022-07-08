package GUI;
import resources.ButtonGradient;
import resources.GradientPanel;
import system.Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;


import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import connection.MyConnection;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panelLeft;
	static JFrame frame = null;
	private int mouseX, mouseY;
	private Employee employee_list;
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private JTextField srNoField;
	private JTextField fnField;
	private JTextField lnField;
	private JTextField contactField;
	private JTextField addressField;
	private JTextField basicSalaryField;
	private JTextField srNoUpdateField;
	private JTextField fnUpdateField;
	private JTextField lnUpdateField;
	private JTextField contactUpdateField;
	private JTextField addressUpdateField;
	private JTextField departamentBoxUpdate;
	private JTextField gradeBoxUpdate;
	private JTextField fnDeleteField;
	private JTextField lnDeleteField;
	private JTextField contactDeleteField;
	private JTextField addressDeleteField;
	private JTextField srNoDeleteField;
	private JTextField departamentDeleteField;
	private JTextField designationDeleteField;
	private JComboBox<String> departamentBox;
	private JComboBox<String> gradeBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					@SuppressWarnings("unused")
					MainMenu menu = new MainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	
	public MainMenu()
	{
		panelLeft = new JPanel();
		conn = MyConnection.getInstance().getConnection();
		employee_list =  new Employee();
		initializare();
	}
	public void initializare() {
		
		
		frame =  new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
	    frame.setSize(1000, 650);
		frame.setLocationByPlatform(false);
	    frame.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		panelLeft.setBounds(0, 33, 222, 617);

		panelLeft.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLeft.setBackground(new Color(0, 0, 51));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		GradientPanel Panels = new GradientPanel();
		Panels.setBounds(222, 33, 778, 617);
		contentPane.add(Panels);
		Panels.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));
		Panels.setBackground(Color.BLACK);
		Panels.setLayout(new CardLayout(0, 0));
		
		GradientPanel addPanel = new GradientPanel();
		addPanel.setLayout(null);
		addPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));
		addPanel.setBackground(Color.BLACK);
		Panels.add(addPanel, "name_21359803485800");
		
		srNoField = new JTextField();
		srNoField.setText("                                                              This will be generated automatically");
		srNoField.setSelectedTextColor(Color.WHITE);
		srNoField.setOpaque(false);
		srNoField.setEditable(false);
		srNoField.setColumns(10);
		srNoField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoField.setBounds(138, 152, 543, 30);
		addPanel.add(srNoField);
		
		fnField = new JTextField();
		fnField.setSelectedTextColor(Color.WHITE);
		fnField.setOpaque(false);
		fnField.setColumns(10);
		fnField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnField.setBounds(138, 216, 251, 30);
		addPanel.add(fnField);
		
		lnField = new JTextField();
		lnField.setSelectedTextColor(Color.WHITE);
		lnField.setOpaque(false);
		lnField.setColumns(10);
		lnField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnField.setBounds(420, 216, 261, 30);
		addPanel.add(lnField);
		
		gradeBox = new JComboBox<String>();
		gradeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Designation"}));
		gradeBox.setBounds(420, 292, 261, 30);
		addPanel.add(gradeBox);
		
		departamentBox = new JComboBox<String>();
		departamentBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				employee_list.selectDesignation(departamentBox, gradeBox);
			}
		});
		departamentBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select departament", "Departament1", "Departament2", "Departament3", "Departament4"}));
		departamentBox.setBounds(138, 292, 251, 30);
		addPanel.add(departamentBox);
		
	
		
		contactField = new JTextField();
		contactField.setSelectedTextColor(Color.WHITE);
		contactField.setOpaque(false);
		contactField.setColumns(10);
		contactField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactField.setBounds(138, 363, 543, 30);
		addPanel.add(contactField);
		
		addressField = new JTextField();
		addressField.setSelectedTextColor(Color.WHITE);
		addressField.setOpaque(false);
		addressField.setColumns(10);
		addressField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressField.setBounds(138, 429, 543, 30);
		addPanel.add(addressField);
		
		basicSalaryField = new JTextField();
		basicSalaryField.setSelectedTextColor(Color.WHITE);
		basicSalaryField.setOpaque(false);
		basicSalaryField.setColumns(10);
		basicSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		basicSalaryField.setBounds(138, 489, 543, 30);
		addPanel.add(basicSalaryField);
		
		JTextPane txtpnSrNo = new JTextPane();
		txtpnSrNo.setText("Sr No:\r\n");
		txtpnSrNo.setOpaque(false);
		txtpnSrNo.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo.setEditable(false);
		txtpnSrNo.setCaretColor(Color.CYAN);
		txtpnSrNo.setBounds(138, 129, 67, 20);
		addPanel.add(txtpnSrNo);
		
		JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setText("First Name");
		txtpnFirstName.setOpaque(false);
		txtpnFirstName.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName.setEditable(false);
		txtpnFirstName.setBounds(138, 199, 67, 20);
		addPanel.add(txtpnFirstName);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setText("Last Name");
		txtpnLastName.setOpaque(false);
		txtpnLastName.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName.setEditable(false);
		txtpnLastName.setBounds(420, 199, 67, 20);
		addPanel.add(txtpnLastName);
		
		JTextPane txtpnDepartament = new JTextPane();
		txtpnDepartament.setText("Departament");
		txtpnDepartament.setOpaque(false);
		txtpnDepartament.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament.setEditable(false);
		txtpnDepartament.setBounds(138, 271, 78, 20);
		addPanel.add(txtpnDepartament);
		
		JTextPane txtpnDesignation = new JTextPane();
		txtpnDesignation.setText("Designation");
		txtpnDesignation.setOpaque(false);
		txtpnDesignation.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation.setEditable(false);
		txtpnDesignation.setBounds(420, 271, 78, 20);
		addPanel.add(txtpnDesignation);
		
		JTextPane txtpnContactNumber = new JTextPane();
		txtpnContactNumber.setText("Contact number");
		txtpnContactNumber.setOpaque(false);
		txtpnContactNumber.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber.setEditable(false);
		txtpnContactNumber.setBounds(138, 345, 94, 20);
		addPanel.add(txtpnContactNumber);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setText("Address");
		txtpnAddress.setOpaque(false);
		txtpnAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress.setEditable(false);
		txtpnAddress.setBounds(138, 411, 67, 20);
		addPanel.add(txtpnAddress);
		
		JTextPane txtpnBasicSalary = new JTextPane();
		txtpnBasicSalary.setText("Basic Salary");
		txtpnBasicSalary.setOpaque(false);
		txtpnBasicSalary.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnBasicSalary.setEditable(false);
		txtpnBasicSalary.setBounds(138, 470, 110, 20);
		addPanel.add(txtpnBasicSalary);
		
		JTextPane txtpnAddEmployeeMenu = new JTextPane();
		txtpnAddEmployeeMenu.setText("ADD EMPLOYEE\r\n");
		txtpnAddEmployeeMenu.setOpaque(false);
		txtpnAddEmployeeMenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu.setEditable(false);
		txtpnAddEmployeeMenu.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu.setBounds(324, 38, 214, 44);
		addPanel.add(txtpnAddEmployeeMenu);
		
		ButtonGradient addBttnPanel = new ButtonGradient();
		addBttnPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employee_list.addEmployee(fnField, lnField, contactField, addressField, basicSalaryField, departamentBox, gradeBox);
			}
		});
		addBttnPanel.setText("Add Employee");
		addBttnPanel.setSizeSpeed(5.0f);
		addBttnPanel.setForeground(Color.WHITE);
		addBttnPanel.setFocusPainted(false);
		addBttnPanel.setColor2(new Color(0, 0, 51));
		addBttnPanel.setColor1(Color.GRAY);
		addBttnPanel.setBorder(null);
		addBttnPanel.setBackground(SystemColor.menu);
		addBttnPanel.setBounds(294, 530, 204, 55);
		addPanel.add(addBttnPanel);
		
		GradientPanel updatePanel = new GradientPanel();
		updatePanel.setLayout(null);
		updatePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));
		updatePanel.setBackground(Color.BLACK);
		Panels.add(updatePanel, "name_21373459515600");
		
		
		
		fnUpdateField = new JTextField();
		fnUpdateField.setSelectedTextColor(Color.WHITE);
		fnUpdateField.setOpaque(false);
		fnUpdateField.setColumns(10);
		fnUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnUpdateField.setBounds(138, 216, 251, 30);
		updatePanel.add(fnUpdateField);
		
		lnUpdateField = new JTextField();
		lnUpdateField.setSelectedTextColor(Color.WHITE);
		lnUpdateField.setOpaque(false);
		lnUpdateField.setColumns(10);
		lnUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnUpdateField.setBounds(420, 216, 261, 30);
		updatePanel.add(lnUpdateField);
		
		contactUpdateField = new JTextField();
		contactUpdateField.setSelectedTextColor(Color.WHITE);
		contactUpdateField.setOpaque(false);
		contactUpdateField.setColumns(10);
		contactUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactUpdateField.setBounds(138, 363, 543, 30);
		updatePanel.add(contactUpdateField);
		
		addressUpdateField = new JTextField();
		addressUpdateField.setSelectedTextColor(Color.WHITE);
		addressUpdateField.setOpaque(false);
		addressUpdateField.setColumns(10);
		addressUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressUpdateField.setBounds(138, 429, 543, 30);
		updatePanel.add(addressUpdateField);
		
		JTextPane txtpnSrNo_1 = new JTextPane();
		txtpnSrNo_1.setText("Sr No:\r\n");
		txtpnSrNo_1.setOpaque(false);
		txtpnSrNo_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1.setEditable(false);
		txtpnSrNo_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1.setBounds(138, 129, 67, 20);
		updatePanel.add(txtpnSrNo_1);
		
		JTextPane txtpnFirstName_1 = new JTextPane();
		txtpnFirstName_1.setText("First Name");
		txtpnFirstName_1.setOpaque(false);
		txtpnFirstName_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName_1.setEditable(false);
		txtpnFirstName_1.setBounds(138, 199, 67, 20);
		updatePanel.add(txtpnFirstName_1);
		
		JTextPane txtpnLastName_1 = new JTextPane();
		txtpnLastName_1.setText("Last Name");
		txtpnLastName_1.setOpaque(false);
		txtpnLastName_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName_1.setEditable(false);
		txtpnLastName_1.setBounds(420, 199, 67, 20);
		updatePanel.add(txtpnLastName_1);
		
		JTextPane txtpnDepartament_1 = new JTextPane();
		txtpnDepartament_1.setText("Departament");
		txtpnDepartament_1.setOpaque(false);
		txtpnDepartament_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament_1.setEditable(false);
		txtpnDepartament_1.setBounds(138, 271, 78, 20);
		updatePanel.add(txtpnDepartament_1);
		
		JTextPane txtpnDesignation_1 = new JTextPane();
		txtpnDesignation_1.setText("Designation");
		txtpnDesignation_1.setOpaque(false);
		txtpnDesignation_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation_1.setEditable(false);
		txtpnDesignation_1.setBounds(420, 271, 78, 20);
		updatePanel.add(txtpnDesignation_1);
		
		JTextPane txtpnContactNumber_1 = new JTextPane();
		txtpnContactNumber_1.setText("Contact number");
		txtpnContactNumber_1.setOpaque(false);
		txtpnContactNumber_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber_1.setEditable(false);
		txtpnContactNumber_1.setBounds(138, 345, 94, 20);
		updatePanel.add(txtpnContactNumber_1);
		
		JTextPane txtpnAddress_1 = new JTextPane();
		txtpnAddress_1.setText("Address");
		txtpnAddress_1.setOpaque(false);
		txtpnAddress_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress_1.setEditable(false);
		txtpnAddress_1.setBounds(138, 411, 67, 20);
		updatePanel.add(txtpnAddress_1);
		
		JTextPane txtpnAddEmployeeMenu_1 = new JTextPane();
		txtpnAddEmployeeMenu_1.setText("UPDATE EMPLOYEE\r\n");
		txtpnAddEmployeeMenu_1.setOpaque(false);
		txtpnAddEmployeeMenu_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1.setEditable(false);
		txtpnAddEmployeeMenu_1.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1.setBounds(324, 38, 214, 44);
		updatePanel.add(txtpnAddEmployeeMenu_1);
		
		ButtonGradient bttnUpdateEmployee = new ButtonGradient();
		bttnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value1 = srNoUpdateField.getText();
				String value2 = fnUpdateField.getText();
				String value3 = lnUpdateField.getText();
				String value4 = departamentBoxUpdate.getText();
				String value5 = gradeBoxUpdate.getText();
				String value6 = contactUpdateField.getText();;
				String value7 = addressUpdateField.getText();
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure to update this record?", "Update Record", JOptionPane.YES_NO_OPTION);
				
				if(p == 0)
				{
					String sql = "UPDATE `employee_list` SET `srno`='"+value1+"',`fname`='"+value2+"',`lname`='"+value3+"',`departament`='"+value4+"',`designation`='"+value5+"',`number`='"+value6+"',`address`='"+value7+"' WHERE `srno`='"+value1+"'";
					try {
						ps = conn.prepareStatement(sql);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Data updated succesfully!");
					} catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		bttnUpdateEmployee.setText("Update Employee");
		bttnUpdateEmployee.setSizeSpeed(5.0f);
		bttnUpdateEmployee.setForeground(Color.WHITE);
		bttnUpdateEmployee.setFocusPainted(false);
		bttnUpdateEmployee.setColor2(new Color(0, 0, 51));
		bttnUpdateEmployee.setColor1(Color.GRAY);
		bttnUpdateEmployee.setBorder(null);
		bttnUpdateEmployee.setBackground(SystemColor.menu);
		bttnUpdateEmployee.setBounds(294, 487, 204, 55);
		updatePanel.add(bttnUpdateEmployee);
		
		srNoUpdateField = new JTextField();
		srNoUpdateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) // DACA APASA enter se completeaza automat randurile
				{
					
					try {
						String sql = "select * from employee_list where srno = ?";
						
						ps = conn.prepareStatement(sql);
						ps.setString(1, srNoUpdateField.getText());
						rs = ps.executeQuery();
						
						if(rs.next() )
						{
							fnUpdateField.setText(rs.getString(2));
							lnUpdateField.setText(rs.getString(3));
							departamentBoxUpdate.setText(rs.getString(4));
							gradeBoxUpdate.setText(rs.getString(5));
							contactUpdateField.setText(rs.getString(6));
							addressUpdateField.setText(rs.getString(7));
							
							
						}
						
					} catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, ex);
						
					}
				}
				
			}
		});
		srNoUpdateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(srNoUpdateField.getText().trim().equals("Enter Employee ID to search"))
				{
					srNoUpdateField.setText("");
				}
				srNoUpdateField.setForeground(Color.black);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(srNoUpdateField.getText().trim().equals(""))
				{
					srNoUpdateField.setText("                                                                Enter Employee ID to search");
					lnUpdateField.setText("");
					fnUpdateField.setText("");
					departamentBoxUpdate.setText("");
					gradeBoxUpdate.setText("");
					contactUpdateField.setText("");
					addressUpdateField.setText("");
				}
				srNoUpdateField.setForeground(new Color(153,153,153));
			}
		});
		srNoUpdateField.setText("                                                                Enter Employee ID to search");
		srNoUpdateField.setSelectedTextColor(Color.WHITE);
		srNoUpdateField.setOpaque(false);
		srNoUpdateField.setEditable(true);
		srNoUpdateField.setColumns(10);
		srNoUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoUpdateField.setBounds(138, 152, 543, 30);
		updatePanel.add(srNoUpdateField);
		
		departamentBoxUpdate = new JTextField();
		departamentBoxUpdate.setSelectedTextColor(Color.WHITE);
		departamentBoxUpdate.setOpaque(false);
		departamentBoxUpdate.setColumns(10);
		departamentBoxUpdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentBoxUpdate.setBounds(138, 292, 251, 30);
		updatePanel.add(departamentBoxUpdate);
		
		gradeBoxUpdate = new JTextField();
		gradeBoxUpdate.setSelectedTextColor(Color.WHITE);
		gradeBoxUpdate.setOpaque(false);
		gradeBoxUpdate.setColumns(10);
		gradeBoxUpdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		gradeBoxUpdate.setBounds(430, 292, 251, 30);
		updatePanel.add(gradeBoxUpdate);
		
		GradientPanel generatePanel = new GradientPanel();
		generatePanel.setLayout(null);
		Panels.add(generatePanel, "name_21390220791400");
		
		GradientPanel updateSalaryPanel = new GradientPanel();
		updateSalaryPanel.setLayout(null);
		Panels.add(updateSalaryPanel, "name_21420245280400");
		
		GradientPanel deletePanel = new GradientPanel();
		deletePanel.setLayout(null);
		deletePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));
		deletePanel.setBackground(Color.BLACK);
		Panels.add(deletePanel, "name_271489301300");
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.LIGHT_GRAY);
		panelHeader.setForeground(Color.WHITE);
		panelHeader.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHeader.setBounds(0, 0, 1000, 34);
		contentPane.add(panelHeader);
		
		JLabel x_Bttn = new JLabel("");
		x_Bttn.setBounds(964, 0, 36, 37);
		panelHeader.add(x_Bttn);
		x_Bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		x_Bttn.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-close-32.png"));
		x_Bttn.setVisible(true);
		move_windows( panelHeader);
		

		ButtonGradient bttnAdd =  new ButtonGradient();
		bttnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisiblePanel( addPanel, updatePanel, generatePanel, updateSalaryPanel,deletePanel);
			
			}
		});
		bttnAdd.setFont(new Font("Segoe UI", bttnAdd.getFont().getStyle(), bttnAdd.getFont().getSize()));
		bttnAdd.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-add-30.png"));
		bttnAdd.setBounds(10, 222, 204, 55);
		bttnAdd.setFocusPainted(false);
		bttnAdd.setSizeSpeed(5.0f);
		bttnAdd.setForeground(Color.WHITE);
		panelLeft.add(bttnAdd);
		bttnAdd.setText("Add Employee");
		bttnAdd.setColor2(new Color(0, 0, 51));
		bttnAdd.setColor1(Color.GRAY);
		bttnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bttnAdd.setBorder(null);
		bttnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bttnAdd.setBackground(SystemColor.control);
		
		ButtonGradient bttnUpdate = new ButtonGradient();
		bttnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisiblePanel( updatePanel, addPanel, generatePanel, updateSalaryPanel,deletePanel);
			}
		});
		bttnUpdate.setSizeSpeed(5.0f);
		bttnUpdate.setFont(new Font("Segoe UI", bttnUpdate.getFont().getStyle(), bttnUpdate.getFont().getSize()));
		bttnUpdate.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-approval-30.png"));
		bttnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bttnUpdate.setBounds(10, 287, 204, 55);
		bttnUpdate.setFocusPainted(false);
		bttnUpdate.setText("Update Employee");
		bttnUpdate.setColor2(new Color(0, 0, 51));
		bttnUpdate.setColor1(Color.GRAY);
		bttnUpdate.setBorder(null);
		bttnUpdate.setBackground(SystemColor.menu);
		panelLeft.add(bttnUpdate);
		
		ButtonGradient bttnGenerate = new ButtonGradient();
		bttnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisiblePanel( generatePanel, addPanel, updatePanel, updateSalaryPanel,deletePanel);
			}
		});
		bttnGenerate.setSizeSpeed(5.0f);
		bttnGenerate.setFont(new Font("Segoe UI", bttnGenerate.getFont().getStyle(), bttnGenerate.getFont().getSize()));
		bttnGenerate.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-salary-female-30.png"));
		bttnGenerate.setBounds(10, 353, 204, 55);
		bttnGenerate.setFocusPainted(false);
		bttnGenerate.setText("Generate Salary");
		bttnGenerate.setColor2(new Color(0, 0, 51));
		bttnGenerate.setColor1(Color.GRAY);
		bttnGenerate.setBorder(null);
		bttnGenerate.setBackground(SystemColor.menu);
		panelLeft.add(bttnGenerate);
		
		ButtonGradient bttnSalaryUpdate = new ButtonGradient();
		bttnSalaryUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisiblePanel( updateSalaryPanel, addPanel, updatePanel, generatePanel,deletePanel);
			}
		});
		bttnSalaryUpdate.setSizeSpeed(5.0f);
		bttnSalaryUpdate.setFont(new Font("Segoe UI", bttnSalaryUpdate.getFont().getStyle(), bttnSalaryUpdate.getFont().getSize()));
		bttnSalaryUpdate.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-employee-64.png"));
		bttnSalaryUpdate.setBounds(10, 419, 204, 55);
		bttnSalaryUpdate.setFocusPainted(false);
		bttnSalaryUpdate.setText("Update Salary\r\n");
		bttnSalaryUpdate.setColor2(new Color(0, 0, 51));
		bttnSalaryUpdate.setColor1(Color.GRAY);
		bttnSalaryUpdate.setBorder(null);
		bttnSalaryUpdate.setBackground(SystemColor.menu);
		panelLeft.add(bttnSalaryUpdate);
		
		ButtonGradient bttnDeleteEmployee = new ButtonGradient();
		bttnDeleteEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisiblePanel( deletePanel, addPanel, updatePanel, generatePanel,updateSalaryPanel);
				
			}
		});
		bttnDeleteEmployee.setSizeSpeed(5.0f);
		bttnDeleteEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		bttnDeleteEmployee.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-remove-administrator-50.png"));
		bttnDeleteEmployee.setBounds(10, 485, 204, 55);
		bttnDeleteEmployee.setFocusPainted(false);
		bttnDeleteEmployee.setText("Delete Employee");
		bttnDeleteEmployee.setColor2(new Color(0, 0, 51));
		bttnDeleteEmployee.setColor1(Color.GRAY);
		bttnDeleteEmployee.setBorder(null);
		bttnDeleteEmployee.setBackground(SystemColor.menu);
		panelLeft.add(bttnDeleteEmployee);
		
		ButtonGradient logoutBttn = new ButtonGradient();
		logoutBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				Login login = new Login();
				frame.dispose();
				
				
			}
		});
		logoutBttn.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-logout-30.png"));
		logoutBttn.setText("LOG OUT");
		logoutBttn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		logoutBttn.setFocusPainted(false);
		logoutBttn.setColor2(new Color(0, 0, 51));
		logoutBttn.setColor1(Color.GRAY);
		logoutBttn.setBorder(null);
		logoutBttn.setBackground(SystemColor.menu);
		logoutBttn.setBounds(55, 573, 115, 33);
		panelLeft.add(logoutBttn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-person-96.png"));
		lblNewLabel.setBounds(61, 11, 109, 100);
		panelLeft.add(lblNewLabel);
		
		ButtonGradient profileBttn = new ButtonGradient();
		profileBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileBttn.setText("Profile");
		profileBttn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		profileBttn.setFocusPainted(false);
		profileBttn.setColor2(new Color(0, 0, 51));
		profileBttn.setColor1(Color.GRAY);
		profileBttn.setBorder(null);
		profileBttn.setBackground(SystemColor.menu);
		profileBttn.setBounds(55, 178, 115, 33);
		panelLeft.add(profileBttn);
		
		
		
	
		
		fnDeleteField = new JTextField();
		fnDeleteField.setEditable(false);
		fnDeleteField.setSelectedTextColor(Color.WHITE);
		fnDeleteField.setOpaque(false);
		fnDeleteField.setColumns(10);
		fnDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnDeleteField.setBounds(138, 216, 251, 30);
		deletePanel.add(fnDeleteField);
		
		lnDeleteField = new JTextField();
		lnDeleteField.setEditable(false);
		lnDeleteField.setSelectedTextColor(Color.WHITE);
		lnDeleteField.setOpaque(false);
		lnDeleteField.setColumns(10);
		lnDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnDeleteField.setBounds(420, 216, 261, 30);
		deletePanel.add(lnDeleteField);
		
		contactDeleteField = new JTextField();
		contactDeleteField.setEditable(false);
		contactDeleteField.setSelectedTextColor(Color.WHITE);
		contactDeleteField.setOpaque(false);
		contactDeleteField.setColumns(10);
		contactDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactDeleteField.setBounds(138, 363, 543, 30);
		deletePanel.add(contactDeleteField);
		
		addressDeleteField = new JTextField();
		addressDeleteField.setEditable(false);
		addressDeleteField.setSelectedTextColor(Color.WHITE);
		addressDeleteField.setOpaque(false);
		addressDeleteField.setColumns(10);
		addressDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressDeleteField.setBounds(138, 429, 543, 30);
		deletePanel.add(addressDeleteField);
		
		JTextPane txtpnSrNo_1_1 = new JTextPane();
		txtpnSrNo_1_1.setText("Sr No:\r\n");
		txtpnSrNo_1_1.setOpaque(false);
		txtpnSrNo_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_1.setEditable(false);
		txtpnSrNo_1_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_1.setBounds(138, 129, 67, 20);
		deletePanel.add(txtpnSrNo_1_1);
		
		JTextPane txtpnFirstName_1_1 = new JTextPane();
		txtpnFirstName_1_1.setText("First Name");
		txtpnFirstName_1_1.setOpaque(false);
		txtpnFirstName_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName_1_1.setEditable(false);
		txtpnFirstName_1_1.setBounds(138, 199, 67, 20);
		deletePanel.add(txtpnFirstName_1_1);
		
		JTextPane txtpnLastName_1_1 = new JTextPane();
		txtpnLastName_1_1.setText("Last Name");
		txtpnLastName_1_1.setOpaque(false);
		txtpnLastName_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName_1_1.setEditable(false);
		txtpnLastName_1_1.setBounds(420, 199, 67, 20);
		deletePanel.add(txtpnLastName_1_1);
		
		JTextPane txtpnDepartament_1_1 = new JTextPane();
		txtpnDepartament_1_1.setText("Departament");
		txtpnDepartament_1_1.setOpaque(false);
		txtpnDepartament_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament_1_1.setEditable(false);
		txtpnDepartament_1_1.setBounds(138, 271, 78, 20);
		deletePanel.add(txtpnDepartament_1_1);
		
		JTextPane txtpnDesignation_1_1 = new JTextPane();
		txtpnDesignation_1_1.setText("Designation");
		txtpnDesignation_1_1.setOpaque(false);
		txtpnDesignation_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation_1_1.setEditable(false);
		txtpnDesignation_1_1.setBounds(420, 271, 78, 20);
		deletePanel.add(txtpnDesignation_1_1);
		
		JTextPane txtpnContactNumber_1_1 = new JTextPane();
		txtpnContactNumber_1_1.setText("Contact number");
		txtpnContactNumber_1_1.setOpaque(false);
		txtpnContactNumber_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber_1_1.setEditable(false);
		txtpnContactNumber_1_1.setBounds(138, 345, 94, 20);
		deletePanel.add(txtpnContactNumber_1_1);
		
		JTextPane txtpnAddress_1_1 = new JTextPane();
		txtpnAddress_1_1.setText("Address");
		txtpnAddress_1_1.setOpaque(false);
		txtpnAddress_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress_1_1.setEditable(false);
		txtpnAddress_1_1.setBounds(138, 411, 67, 20);
		deletePanel.add(txtpnAddress_1_1);
		
		JTextPane txtpnAddEmployeeMenu_1_1 = new JTextPane();
		txtpnAddEmployeeMenu_1_1.setText("DELETE EMPLOYEE\r\n");
		txtpnAddEmployeeMenu_1_1.setOpaque(false);
		txtpnAddEmployeeMenu_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1_1.setEditable(false);
		txtpnAddEmployeeMenu_1_1.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1_1.setBounds(324, 38, 214, 44);
		deletePanel.add(txtpnAddEmployeeMenu_1_1);
		
		ButtonGradient bttnDeleteEmployee_1 = new ButtonGradient();
		bttnDeleteEmployee_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION);
				
				if(p == 0)
				{
					String sql = "delete from employee_list where srno = ?";
					try {
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
					} catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				
				
			}
		});
		bttnDeleteEmployee_1.setText("Delete Employee");
		bttnDeleteEmployee_1.setSizeSpeed(5.0f);
		bttnDeleteEmployee_1.setForeground(Color.WHITE);
		bttnDeleteEmployee_1.setFocusPainted(false);
		bttnDeleteEmployee_1.setColor2(new Color(0, 0, 51));
		bttnDeleteEmployee_1.setColor1(Color.GRAY);
		bttnDeleteEmployee_1.setBorder(null);
		bttnDeleteEmployee_1.setBackground(SystemColor.menu);
		bttnDeleteEmployee_1.setBounds(294, 487, 204, 55);
		deletePanel.add(bttnDeleteEmployee_1);
		
		srNoDeleteField = new JTextField();
		srNoDeleteField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) // DACA APASA enter se completeaza automat randurile
				{
					
					try {
						String sql = "select * from employee_list where srno = ?";
						
						ps = conn.prepareStatement(sql);
						ps.setString(1, srNoDeleteField.getText());
						rs = ps.executeQuery();
						
						if(rs.next() )
						{
							fnDeleteField.setText(rs.getString(2));
							lnDeleteField.setText(rs.getString(3));
							departamentDeleteField.setText(rs.getString(4));
							designationDeleteField.setText(rs.getString(5));
							contactDeleteField.setText(rs.getString(6));
							addressDeleteField.setText(rs.getString(7));
							
							
						}
						
					} catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, ex);
						
					}
				}
				
			}
		});
		srNoDeleteField.setText("                                                                Enter Employee ID to search");
		srNoDeleteField.setSelectedTextColor(Color.WHITE);
		srNoDeleteField.setOpaque(false);
		srNoDeleteField.setEditable(true);
		srNoDeleteField.setColumns(10);
		srNoDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoDeleteField.setBounds(138, 152, 543, 30);
		deletePanel.add(srNoDeleteField);
		
		departamentDeleteField = new JTextField();
		departamentDeleteField.setEditable(false);
		departamentDeleteField.setSelectedTextColor(Color.WHITE);
		departamentDeleteField.setOpaque(false);
		departamentDeleteField.setColumns(10);
		departamentDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentDeleteField.setBounds(138, 292, 251, 30);
		deletePanel.add(departamentDeleteField);
		
		designationDeleteField = new JTextField();
		designationDeleteField.setEditable(false);
		designationDeleteField.setSelectedTextColor(Color.WHITE);
		designationDeleteField.setOpaque(false);
		designationDeleteField.setColumns(10);
		designationDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		designationDeleteField.setBounds(430, 292, 251, 30);
		deletePanel.add(designationDeleteField);
		
		
		srNoDeleteField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(srNoDeleteField.getText().trim().equals("Enter Employee ID to search"))
				{
					srNoDeleteField.setText("");
				}
				srNoDeleteField.setForeground(Color.black);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(srNoDeleteField.getText().trim().equals(""))
				{
					srNoDeleteField.setText("                                                                Enter Employee ID to search");
					lnDeleteField.setText("");
					fnDeleteField.setText("");
					departamentDeleteField.setText("");
					designationDeleteField.setText("");
					contactDeleteField.setText("");
					addressDeleteField.setText("");
				}
				srNoDeleteField.setForeground(new Color(153,153,153));
			}
		});
	
		
		
		

	}

	void reset()
	{
		
	}
	
	private void reset_Update()
	{
		srNoUpdateField.setText("                                                                Enter Employee ID to search");
		lnUpdateField.setText("");
		fnUpdateField.setText("");
		departamentBoxUpdate.setText("");
		gradeBoxUpdate.setText("");
		contactUpdateField.setText("");
		addressUpdateField.setText("");
	}
	@SuppressWarnings("unused")
	private void setVisiblePanel(GradientPanel visiblePanel,GradientPanel invisiblePanel1,GradientPanel invisiblePanel2,GradientPanel invisiblePanel3,GradientPanel invisiblePanel4)
	{
		visiblePanel.setVisible(true);
		invisiblePanel1.setVisible(false);
		invisiblePanel2.setVisible(false);
		invisiblePanel3.setVisible(false);
		invisiblePanel4.setVisible(false);
	}
	
	private void move_windows(JPanel panelHeader) {
		panelHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		panelHeader.setLayout(null);
	}
}

