package GUI;
import resources.ButtonGradient;
import resources.GradientPanel;
import system.Employee;
import system.Salary;

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



import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import connection.MyConnection;

import javax.swing.border.BevelBorder;
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
import javax.swing.border.MatteBorder;

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
	private Salary salary_employee;
	
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
	private JTextField srNoGenerateSalary;
	private JTextField fnGenerateSalaryField;
	private JTextField lnGenerateSalaryField;
	private JTextField departamentGenerateSalaryField;
	private JTextField basicSalaryGenerateSalaryField;
	private JTextField overTimeField;
	private JTextField socialInsuranceField;
	private JTextField healthInsuranceField;
	private JTextField peopleField;
	private JTextField personalDeductionField;
	private JTextField netSalaryField;
	private JTextField overTimeHourField;
	private JTextField totalMoneyOvertime;
	private JTextField incomeTaxField;
	private JTextField empNameField;
	private JTextField desField;
	private JTextField fnUpdateSalary;
	private JTextField lnUpdateSalary;
	private JTextField departamentUpdateSalary;
	private JTextField grossSalaryUpdateSalary;
	private JTextField overtimeUpdateSalary;
	private JTextField socialInsuranceUpdateSalary;
	private JTextField healthInsuranceUpdateSalary;
	private JTextField peopleUpdateSalary;
	private JTextField personalDeductionUpdateSalary;
	private JTextField netSalaryUpdateSalary;
	private JTextField overtimeHourUpdateSalary;
	private JTextField overtimeTotalUpdateSalary;
	private JTextField incomeUpdateSalary;
	private JTextField srNoUpdateSalary;
	
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

	@SuppressWarnings({ })
	
	
	public MainMenu()
	{
		panelLeft = new JPanel();
		panelLeft.setForeground(Color.WHITE);
		panelLeft.setOpaque(true);
		conn = MyConnection.getInstance().getConnection();
		employee_list =  new Employee();
		salary_employee = new Salary();
		initializare();
	}
	public MainMenu(String name, String designation)
	{
		panelLeft = new JPanel();
		conn = MyConnection.getInstance().getConnection();
		employee_list =  new Employee();
		salary_employee = new Salary();
		initializare();
		empNameField.setText(name.toUpperCase());
		desField.setText(designation.toUpperCase());
	}
	public void initializare() {
		
		
		frame =  new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
	    frame.setSize(1000, 650);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		
	    
	    
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		panelLeft.setBounds(0, 0, 222, 650);

		panelLeft.setBorder(null);
		panelLeft.setBackground(new Color(0, 0, 51));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		GradientPanel panels = new GradientPanel();
		panels.setBounds(217, 0, 783, 650);
		contentPane.add(panels);
		panels.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, null, null));
		panels.setBackground(Color.BLACK);
		panels.setLayout(new CardLayout(0, 0));
		
		GradientPanel addPanel = new GradientPanel();
		addPanel.setLayout(null);
		addPanel.setBorder(null);
		addPanel.setBackground(Color.BLACK);
		panels.add(addPanel, "name_21359803485800");
		
		header(addPanel);
		
		srNoField = new JTextField();
		srNoField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		srNoField.setForeground(Color.BLACK);
		srNoField.setText("                                                              This will be generated automatically");
		srNoField.setSelectedTextColor(Color.WHITE);
		srNoField.setOpaque(false);
		srNoField.setEditable(false);
		srNoField.setColumns(10);
		srNoField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoField.setBounds(138, 152, 543, 30);
		addPanel.add(srNoField);
		
		fnField = new JTextField();
		fnField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fnField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		fnField.setForeground(Color.BLACK);
		fnField.setSelectedTextColor(Color.WHITE);
		fnField.setOpaque(false);
		fnField.setColumns(10);
		fnField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnField.setBounds(138, 216, 251, 30);
		addPanel.add(fnField);
		
		lnField = new JTextField();
		lnField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		lnField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lnField.setForeground(Color.BLACK);
		lnField.setSelectedTextColor(Color.WHITE);
		lnField.setOpaque(false);
		lnField.setColumns(10);
		lnField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnField.setBounds(420, 216, 261, 30);
		addPanel.add(lnField);
		
		gradeBox = new JComboBox<String>();
		gradeBox.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		gradeBox.setForeground(Color.BLACK);
		gradeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Designation"}));
		gradeBox.setBounds(420, 292, 261, 30);
		addPanel.add(gradeBox);
		
		departamentBox = new JComboBox<String>();
		departamentBox.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		departamentBox.setForeground(Color.BLACK);
		departamentBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				employee_list.selectDesignation(departamentBox, gradeBox);
			}
		});
		departamentBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Select departament", "Departament1", "Departament2", "Departament3", "Departament4"}));
		departamentBox.setBounds(138, 292, 251, 30);
		addPanel.add(departamentBox);
		
		contactField = new JTextField();
		contactField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		contactField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		contactField.setForeground(Color.BLACK);
		contactField.setSelectedTextColor(Color.WHITE);
		contactField.setOpaque(false);
		contactField.setColumns(10);
		contactField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactField.setBounds(138, 363, 543, 30);
		addPanel.add(contactField);
		
		addressField = new JTextField();
		addressField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		addressField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		addressField.setForeground(Color.BLACK);
		addressField.setSelectedTextColor(Color.WHITE);
		addressField.setOpaque(false);
		addressField.setColumns(10);
		addressField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressField.setBounds(138, 429, 543, 30);
		addPanel.add(addressField);
		
		basicSalaryField = new JTextField();
		basicSalaryField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		basicSalaryField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		basicSalaryField.setForeground(Color.BLACK);
		basicSalaryField.setSelectedTextColor(Color.WHITE);
		basicSalaryField.setOpaque(false);
		basicSalaryField.setColumns(10);
		basicSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		basicSalaryField.setBounds(138, 489, 543, 30);
		addPanel.add(basicSalaryField);
		
		
		
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
		addBttnPanel.setBounds(294, 559, 204, 55);
		addPanel.add(addBttnPanel);
		
		
		///////////////////////////////////
		init_text_add_panel(addPanel);
		///////////////////////////////////
		
		
		GradientPanel updatePanel = new GradientPanel();
		updatePanel.setLayout(null);
		updatePanel.setBorder(null);
		updatePanel.setBackground(Color.BLACK);
		panels.add(updatePanel, "name_21373459515600");
		header(updatePanel);
		/////////////////////////////////////
		init_text_update_panel( updatePanel);
		/////////////////////////////////////
		
		fnUpdateField = new JTextField();
		fnUpdateField.setForeground(Color.BLACK);
		fnUpdateField.setSelectedTextColor(Color.WHITE);
		fnUpdateField.setOpaque(false);
		fnUpdateField.setColumns(10);
		fnUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnUpdateField.setBounds(138, 216, 251, 30);
		updatePanel.add(fnUpdateField);
		
		lnUpdateField = new JTextField();
		lnUpdateField.setForeground(Color.BLACK);
		lnUpdateField.setSelectedTextColor(Color.WHITE);
		lnUpdateField.setOpaque(false);
		lnUpdateField.setColumns(10);
		lnUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnUpdateField.setBounds(420, 216, 261, 30);
		updatePanel.add(lnUpdateField);
		
		contactUpdateField = new JTextField();
		contactUpdateField.setForeground(Color.BLACK);
		contactUpdateField.setSelectedTextColor(Color.WHITE);
		contactUpdateField.setOpaque(false);
		contactUpdateField.setColumns(10);
		contactUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactUpdateField.setBounds(138, 363, 543, 30);
		updatePanel.add(contactUpdateField);
		
		addressUpdateField = new JTextField();
		addressUpdateField.setForeground(Color.BLACK);
		addressUpdateField.setSelectedTextColor(Color.WHITE);
		addressUpdateField.setOpaque(false);
		addressUpdateField.setColumns(10);
		addressUpdateField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressUpdateField.setBounds(138, 429, 543, 30);
		updatePanel.add(addressUpdateField);
		
		
		
		ButtonGradient bttnUpdateEmployee = new ButtonGradient();
		bttnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee_list.updateEmployee(srNoUpdateField, fnUpdateField, lnUpdateField, departamentBoxUpdate, gradeBoxUpdate, contactUpdateField, addressUpdateField);
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
		bttnUpdateEmployee.setBounds(294, 540, 204, 55);
		updatePanel.add(bttnUpdateEmployee);
		
		srNoUpdateField = new JTextField();
		srNoUpdateField.setForeground(Color.BLACK);
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
		departamentBoxUpdate.setForeground(Color.BLACK);
		departamentBoxUpdate.setSelectedTextColor(Color.WHITE);
		departamentBoxUpdate.setOpaque(false);
		departamentBoxUpdate.setColumns(10);
		departamentBoxUpdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentBoxUpdate.setBounds(138, 292, 251, 30);
		updatePanel.add(departamentBoxUpdate);
		
		gradeBoxUpdate = new JTextField();
		gradeBoxUpdate.setForeground(Color.BLACK);
		gradeBoxUpdate.setSelectedTextColor(Color.WHITE);
		gradeBoxUpdate.setOpaque(false);
		gradeBoxUpdate.setColumns(10);
		gradeBoxUpdate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		gradeBoxUpdate.setBounds(430, 292, 251, 30);
		updatePanel.add(gradeBoxUpdate);
		
		GradientPanel generatePanel = new GradientPanel();
		generatePanel.setBackground(Color.BLACK);
		generatePanel.setBorder(null);
		generatePanel.setLayout(null);
		panels.add(generatePanel, "name_21390220791400");
		header(generatePanel);

		GradientPanel updateSalaryPanel = new GradientPanel();
		updateSalaryPanel.setBackground(Color.BLACK);
		updateSalaryPanel.setBorder(null);
		updateSalaryPanel.setLayout(null);
		panels.add(updateSalaryPanel, "name_15035986967600");
		header(updateSalaryPanel);
		////////////////////////////////////////////
		init_text_generate_panel( generatePanel);
		/////////////////////////////////////////////
		
		
		fnGenerateSalaryField = new JTextField();
		fnGenerateSalaryField.setForeground(Color.BLACK);
		fnGenerateSalaryField.setSelectedTextColor(Color.WHITE);
		fnGenerateSalaryField.setOpaque(false);
		fnGenerateSalaryField.setEditable(false);
		fnGenerateSalaryField.setColumns(10);
		fnGenerateSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnGenerateSalaryField.setBounds(39, 243, 166, 30);
		generatePanel.add(fnGenerateSalaryField);
		
		
		
		lnGenerateSalaryField = new JTextField();
		lnGenerateSalaryField.setForeground(Color.BLACK);
		lnGenerateSalaryField.setSelectedTextColor(Color.WHITE);
		lnGenerateSalaryField.setOpaque(false);
		lnGenerateSalaryField.setEditable(false);
		lnGenerateSalaryField.setColumns(10);
		lnGenerateSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnGenerateSalaryField.setBounds(39, 302, 166, 30);
		generatePanel.add(lnGenerateSalaryField);
		
		
		
		departamentGenerateSalaryField = new JTextField();
		departamentGenerateSalaryField.setForeground(Color.BLACK);
		departamentGenerateSalaryField.setSelectedTextColor(Color.WHITE);
		departamentGenerateSalaryField.setOpaque(false);
		departamentGenerateSalaryField.setEditable(false);
		departamentGenerateSalaryField.setColumns(10);
		departamentGenerateSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentGenerateSalaryField.setBounds(39, 368, 166, 30);
		generatePanel.add(departamentGenerateSalaryField);
		
	
		basicSalaryGenerateSalaryField = new JTextField();
		basicSalaryGenerateSalaryField.setForeground(Color.BLACK);
		basicSalaryGenerateSalaryField.setSelectedTextColor(Color.WHITE);
		basicSalaryGenerateSalaryField.setOpaque(false);
		basicSalaryGenerateSalaryField.setEditable(false);
		basicSalaryGenerateSalaryField.setColumns(10);
		basicSalaryGenerateSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		basicSalaryGenerateSalaryField.setBounds(39, 432, 166, 30);
		generatePanel.add(basicSalaryGenerateSalaryField);
		

		
		overTimeField = new JTextField();
		overTimeField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overTimeField.setForeground(Color.BLACK);
		overTimeField.setDisabledTextColor(Color.WHITE);
		overTimeField.setBackground(Color.ORANGE);
		overTimeField.setSelectedTextColor(Color.WHITE);
		overTimeField.setOpaque(false);
		overTimeField.setEditable(true);
		overTimeField.setColumns(10);
		overTimeField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overTimeField.setBounds(569, 243, 172, 30);
		generatePanel.add(overTimeField);
		
		
		
		socialInsuranceField = new JTextField();
		socialInsuranceField.setForeground(Color.BLACK);
		socialInsuranceField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		socialInsuranceField.setSelectedTextColor(Color.WHITE);
		socialInsuranceField.setOpaque(false);
		socialInsuranceField.setEditable(false);
		socialInsuranceField.setColumns(10);
		socialInsuranceField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		socialInsuranceField.setBounds(364, 432, 172, 30);
		generatePanel.add(socialInsuranceField);
		
	
		
		healthInsuranceField = new JTextField();
		healthInsuranceField.setForeground(Color.BLACK);
		healthInsuranceField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		healthInsuranceField.setEditable(false);
		healthInsuranceField.setSelectedTextColor(Color.WHITE);
		healthInsuranceField.setOpaque(false);
		healthInsuranceField.setColumns(10);
		healthInsuranceField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthInsuranceField.setBounds(364, 368, 172, 30);
		generatePanel.add(healthInsuranceField);
		
	
		
		peopleField = new JTextField();
		peopleField.setBackground(Color.ORANGE);
		peopleField.setDisabledTextColor(Color.ORANGE);
		peopleField.setCaretColor(Color.RED);
		peopleField.setForeground(Color.BLACK);
		peopleField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		peopleField.setSelectedTextColor(Color.WHITE);
		peopleField.setOpaque(false);
		peopleField.setEditable(true);
		peopleField.setColumns(10);
		peopleField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		peopleField.setBounds(364, 243, 172, 30);
		generatePanel.add(peopleField);
		
		personalDeductionField = new JTextField();
		personalDeductionField.setForeground(Color.BLACK);
		personalDeductionField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		personalDeductionField.setSelectedTextColor(Color.WHITE);
		personalDeductionField.setOpaque(false);
		personalDeductionField.setEditable(false);
		personalDeductionField.setColumns(10);
		personalDeductionField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		personalDeductionField.setBounds(364, 302, 172, 30);
		generatePanel.add(personalDeductionField);
		
		
		netSalaryField = new JTextField();
		netSalaryField.setForeground(Color.BLACK);
		netSalaryField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		netSalaryField.setEditable(false);
		netSalaryField.setSelectedTextColor(Color.WHITE);
		netSalaryField.setOpaque(false);
		netSalaryField.setColumns(10);
		netSalaryField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		netSalaryField.setBounds(364, 492, 377, 30);
		generatePanel.add(netSalaryField);
		
		overTimeHourField = new JTextField();
		overTimeHourField.setBackground(Color.ORANGE);
		overTimeHourField.setSelectedTextColor(Color.WHITE);
		overTimeHourField.setOpaque(false);
		overTimeHourField.setForeground(Color.BLACK);
		overTimeHourField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overTimeHourField.setColumns(10);
		overTimeHourField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overTimeHourField.setBounds(569, 302, 172, 30);
		generatePanel.add(overTimeHourField);
		
		
		ButtonGradient generateSalaryBttn = new ButtonGradient();
		generateSalaryBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//salary_employee.calculateSalary(basicSalaryGenerateSalaryField, socialInsuranceField, healthInsuranceField, peopleField, personalDeductionField, overTimeField, netSalaryField);
				salary_employee.calculateSalary(basicSalaryGenerateSalaryField, socialInsuranceField, healthInsuranceField, peopleField, personalDeductionField, overTimeField, netSalaryField, overTimeHourField, totalMoneyOvertime, incomeTaxField);
			}
		});
		generateSalaryBttn.setText("Generate");
		generateSalaryBttn.setSizeSpeed(5.0f);
		generateSalaryBttn.setForeground(Color.WHITE);
		generateSalaryBttn.setFocusPainted(false);
		generateSalaryBttn.setColor2(new Color(0, 0, 51));
		generateSalaryBttn.setColor1(Color.GRAY);
		generateSalaryBttn.setBorder(null);
		generateSalaryBttn.setBackground(SystemColor.menu);
		generateSalaryBttn.setBounds(138, 545, 204, 55);
		generatePanel.add(generateSalaryBttn);
		

		
		
		
		totalMoneyOvertime = new JTextField();
		totalMoneyOvertime.setSelectedTextColor(Color.WHITE);
		totalMoneyOvertime.setOpaque(false);
		totalMoneyOvertime.setForeground(Color.BLACK);
		totalMoneyOvertime.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		totalMoneyOvertime.setEditable(false);
		totalMoneyOvertime.setColumns(10);
		totalMoneyOvertime.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalMoneyOvertime.setBounds(569, 368, 172, 30);
		generatePanel.add(totalMoneyOvertime);
		

		
		incomeTaxField = new JTextField();
		incomeTaxField.setSelectedTextColor(Color.WHITE);
		incomeTaxField.setOpaque(false);
		incomeTaxField.setForeground(Color.BLACK);
		incomeTaxField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		incomeTaxField.setEditable(false);
		incomeTaxField.setColumns(10);
		incomeTaxField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		incomeTaxField.setBounds(569, 432, 172, 30);
		generatePanel.add(incomeTaxField);
		
		
		
		GradientPanel deletePanel = new GradientPanel();
		deletePanel.setLayout(null);
		deletePanel.setBorder(null);
		deletePanel.setBackground(Color.BLACK);
		panels.add(deletePanel, "name_271489301300");
		

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
				LoginMenu login = new LoginMenu();
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
		lblNewLabel.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\icons8-client-management-101.png"));
		lblNewLabel.setBounds(55, 27, 128, 102);
		panelLeft.add(lblNewLabel);
		
		empNameField = new JTextField();
		empNameField.setBorder(null);
		empNameField.setFont(new Font("Segoe UI", Font.BOLD, 11));
		empNameField.setForeground(Color.LIGHT_GRAY);
		empNameField.setOpaque(false);
		empNameField.setEditable(false);
		empNameField.setText("empName");
		empNameField.setBounds(65, 11, 115, 33);
		panelLeft.add(empNameField);
		empNameField.setColumns(10);
		
		desField = new JTextField();
		desField.setText("                  designation");
		desField.setOpaque(false);
		desField.setForeground(Color.LIGHT_GRAY);
		desField.setFont(new Font("Segoe UI", Font.BOLD, 11));
		desField.setEditable(false);
		desField.setColumns(10);
		desField.setBorder(null);
		desField.setBounds(55, 119, 138, 20);
		panelLeft.add(desField);
		
		
		////////////////////////////////////
		init_text_delete_panel( deletePanel);
		////////////////////////////////////
		
		fnDeleteField = new JTextField();
		fnDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		fnDeleteField.setForeground(Color.BLACK);
		fnDeleteField.setEditable(false);
		fnDeleteField.setSelectedTextColor(Color.WHITE);
		fnDeleteField.setOpaque(false);
		fnDeleteField.setColumns(10);
		fnDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnDeleteField.setBounds(138, 216, 251, 30);
		deletePanel.add(fnDeleteField);
		
		lnDeleteField = new JTextField();
		lnDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lnDeleteField.setForeground(Color.BLACK);
		lnDeleteField.setEditable(false);
		lnDeleteField.setSelectedTextColor(Color.WHITE);
		lnDeleteField.setOpaque(false);
		lnDeleteField.setColumns(10);
		lnDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnDeleteField.setBounds(420, 216, 261, 30);
		deletePanel.add(lnDeleteField);
		
		contactDeleteField = new JTextField();
		contactDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		contactDeleteField.setForeground(Color.BLACK);
		contactDeleteField.setEditable(false);
		contactDeleteField.setSelectedTextColor(Color.WHITE);
		contactDeleteField.setOpaque(false);
		contactDeleteField.setColumns(10);
		contactDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contactDeleteField.setBounds(138, 363, 543, 30);
		deletePanel.add(contactDeleteField);
		
		addressDeleteField = new JTextField();
		addressDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		addressDeleteField.setForeground(Color.BLACK);
		addressDeleteField.setEditable(false);
		addressDeleteField.setSelectedTextColor(Color.WHITE);
		addressDeleteField.setOpaque(false);
		addressDeleteField.setColumns(10);
		addressDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addressDeleteField.setBounds(138, 429, 543, 30);
		deletePanel.add(addressDeleteField);
		
		
		
		ButtonGradient bttnDeleteEmployee_1 = new ButtonGradient();
		bttnDeleteEmployee_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee_list.deleteEmployee(srNoDeleteField, fnDeleteField, lnDeleteField, departamentDeleteField, designationDeleteField, contactDeleteField, addressDeleteField);		
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
		bttnDeleteEmployee_1.setBounds(312, 534, 204, 55);
		deletePanel.add(bttnDeleteEmployee_1);
		
		
		srNoDeleteField = new JTextField();
		srNoDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		srNoDeleteField.setForeground(Color.BLACK);
		srNoDeleteField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) 
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
		departamentDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		departamentDeleteField.setForeground(Color.BLACK);
		departamentDeleteField.setEditable(false);
		departamentDeleteField.setSelectedTextColor(Color.WHITE);
		departamentDeleteField.setOpaque(false);
		departamentDeleteField.setColumns(10);
		departamentDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentDeleteField.setBounds(138, 292, 251, 30);
		deletePanel.add(departamentDeleteField);
		
		designationDeleteField = new JTextField();
		designationDeleteField.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		designationDeleteField.setForeground(Color.BLACK);
		designationDeleteField.setEditable(false);
		designationDeleteField.setSelectedTextColor(Color.WHITE);
		designationDeleteField.setOpaque(false);
		designationDeleteField.setColumns(10);
		designationDeleteField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		designationDeleteField.setBounds(430, 292, 251, 30);
		deletePanel.add(designationDeleteField);
		header(deletePanel);
	
		
		
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
		
		srNoGenerateSalary = new JTextField();
		srNoGenerateSalary.setForeground(Color.BLACK);
		srNoGenerateSalary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{	
					
					salary_employee.completeWithEnter(srNoGenerateSalary, fnGenerateSalaryField, lnGenerateSalaryField, departamentGenerateSalaryField, basicSalaryGenerateSalaryField, srNoField, employee_list);
				
				}
				
				
				
			}
		});
		srNoGenerateSalary.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(srNoGenerateSalary.getText().trim().equals("Enter Employee ID to search"))
				{
					srNoGenerateSalary.setText("");
				} 
				srNoGenerateSalary.setForeground(Color.black);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(srNoGenerateSalary.getText().trim().equals(""))
				{
					srNoGenerateSalary.setText("                                                                Enter Employee ID to search");
					lnGenerateSalaryField.setText("");
					fnGenerateSalaryField.setText("");
					departamentGenerateSalaryField.setText("");
					basicSalaryGenerateSalaryField.setText("");
					
				}
				srNoGenerateSalary.setForeground(new Color(153,153,153));
			}
		});
		srNoGenerateSalary.setText("                                                                Enter Employee ID to search");
		srNoGenerateSalary.setSelectedTextColor(Color.WHITE);
		srNoGenerateSalary.setOpaque(false);
		srNoGenerateSalary.setEditable(true);
		srNoGenerateSalary.setColumns(10);
		srNoGenerateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoGenerateSalary.setBounds(101, 126, 543, 30);
		generatePanel.add(srNoGenerateSalary);
		
		
		ButtonGradient StoreDBBttn = new ButtonGradient();
		StoreDBBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salary_employee.addEmployee(srNoGenerateSalary, basicSalaryGenerateSalaryField, socialInsuranceField, healthInsuranceField, peopleField, personalDeductionField, overTimeField, netSalaryField, overTimeHourField, totalMoneyOvertime, incomeTaxField );
			}
		});
		StoreDBBttn.setText("Store in database");
		StoreDBBttn.setSizeSpeed(5.0f);
		StoreDBBttn.setForeground(Color.WHITE);
		StoreDBBttn.setFocusPainted(false);
		StoreDBBttn.setColor2(new Color(0, 0, 51));
		StoreDBBttn.setColor1(Color.GRAY);
		StoreDBBttn.setBorder(null);
		StoreDBBttn.setBackground(SystemColor.menu);
		StoreDBBttn.setBounds(402, 545, 204, 55);
		generatePanel.add(StoreDBBttn);
		

		
		
		///////////////////////////////////////////////////////////
		int_text_update_salary_panel( updateSalaryPanel);
		//////////////////////////////////////////////////////////
		
		
		fnUpdateSalary = new JTextField();
		fnUpdateSalary.setSelectedTextColor(Color.WHITE);
		fnUpdateSalary.setOpaque(false);
		fnUpdateSalary.setForeground(Color.BLACK);
		fnUpdateSalary.setEditable(false);
		fnUpdateSalary.setColumns(10);
		fnUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fnUpdateSalary.setBounds(39, 243, 166, 30);
		updateSalaryPanel.add(fnUpdateSalary);
		
	
		
		lnUpdateSalary = new JTextField();
		lnUpdateSalary.setSelectedTextColor(Color.WHITE);
		lnUpdateSalary.setOpaque(false);
		lnUpdateSalary.setForeground(Color.BLACK);
		lnUpdateSalary.setEditable(false);
		lnUpdateSalary.setColumns(10);
		lnUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lnUpdateSalary.setBounds(39, 302, 166, 30);
		updateSalaryPanel.add(lnUpdateSalary);
		

		
		departamentUpdateSalary = new JTextField();
		departamentUpdateSalary.setSelectedTextColor(Color.WHITE);
		departamentUpdateSalary.setOpaque(false);
		departamentUpdateSalary.setForeground(Color.BLACK);
		departamentUpdateSalary.setEditable(false);
		departamentUpdateSalary.setColumns(10);
		departamentUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departamentUpdateSalary.setBounds(39, 368, 166, 30);
		updateSalaryPanel.add(departamentUpdateSalary);
		
		
		
		grossSalaryUpdateSalary = new JTextField();
		grossSalaryUpdateSalary.setBackground(Color.ORANGE);
		grossSalaryUpdateSalary.setSelectedTextColor(Color.WHITE);
		grossSalaryUpdateSalary.setOpaque(false);
		grossSalaryUpdateSalary.setForeground(Color.BLACK);
		grossSalaryUpdateSalary.setColumns(10);
		grossSalaryUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		grossSalaryUpdateSalary.setBounds(39, 432, 166, 30);
		updateSalaryPanel.add(grossSalaryUpdateSalary);
		
	
		
		overtimeUpdateSalary = new JTextField();
		overtimeUpdateSalary.setSelectedTextColor(Color.WHITE);
		overtimeUpdateSalary.setOpaque(false);
		overtimeUpdateSalary.setForeground(Color.BLACK);
		overtimeUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overtimeUpdateSalary.setEditable(true);
		overtimeUpdateSalary.setDisabledTextColor(Color.WHITE);
		overtimeUpdateSalary.setColumns(10);
		overtimeUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overtimeUpdateSalary.setBackground(Color.ORANGE);
		overtimeUpdateSalary.setBounds(569, 243, 172, 30);
		updateSalaryPanel.add(overtimeUpdateSalary);
		
	
		
		socialInsuranceUpdateSalary = new JTextField();
		socialInsuranceUpdateSalary.setSelectedTextColor(Color.WHITE);
		socialInsuranceUpdateSalary.setOpaque(false);
		socialInsuranceUpdateSalary.setForeground(Color.BLACK);
		socialInsuranceUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		socialInsuranceUpdateSalary.setEditable(false);
		socialInsuranceUpdateSalary.setColumns(10);
		socialInsuranceUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		socialInsuranceUpdateSalary.setBounds(364, 432, 172, 30);
		updateSalaryPanel.add(socialInsuranceUpdateSalary);
		
	
		
		healthInsuranceUpdateSalary = new JTextField();
		healthInsuranceUpdateSalary.setSelectedTextColor(Color.WHITE);
		healthInsuranceUpdateSalary.setOpaque(false);
		healthInsuranceUpdateSalary.setForeground(Color.BLACK);
		healthInsuranceUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		healthInsuranceUpdateSalary.setEditable(false);
		healthInsuranceUpdateSalary.setColumns(10);
		healthInsuranceUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthInsuranceUpdateSalary.setBounds(364, 368, 172, 30);
		updateSalaryPanel.add(healthInsuranceUpdateSalary);
		
	
		peopleUpdateSalary = new JTextField();
		peopleUpdateSalary.setSelectedTextColor(Color.WHITE);
		peopleUpdateSalary.setOpaque(false);
		peopleUpdateSalary.setForeground(Color.BLACK);
		peopleUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		peopleUpdateSalary.setEditable(true);
		peopleUpdateSalary.setDisabledTextColor(Color.ORANGE);
		peopleUpdateSalary.setColumns(10);
		peopleUpdateSalary.setCaretColor(Color.RED);
		peopleUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		peopleUpdateSalary.setBackground(Color.ORANGE);
		peopleUpdateSalary.setBounds(364, 243, 172, 30);
		updateSalaryPanel.add(peopleUpdateSalary);
		

		
		personalDeductionUpdateSalary = new JTextField();
		personalDeductionUpdateSalary.setSelectedTextColor(Color.WHITE);
		personalDeductionUpdateSalary.setOpaque(false);
		personalDeductionUpdateSalary.setForeground(Color.BLACK);
		personalDeductionUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		personalDeductionUpdateSalary.setEditable(false);
		personalDeductionUpdateSalary.setColumns(10);
		personalDeductionUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		personalDeductionUpdateSalary.setBounds(364, 302, 172, 30);
		updateSalaryPanel.add(personalDeductionUpdateSalary);
		
	
		
		netSalaryUpdateSalary = new JTextField();
		netSalaryUpdateSalary.setSelectedTextColor(Color.WHITE);
		netSalaryUpdateSalary.setOpaque(false);
		netSalaryUpdateSalary.setForeground(Color.BLACK);
		netSalaryUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		netSalaryUpdateSalary.setEditable(false);
		netSalaryUpdateSalary.setColumns(10);
		netSalaryUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		netSalaryUpdateSalary.setBounds(364, 492, 377, 30);
		updateSalaryPanel.add(netSalaryUpdateSalary);
		

		
		ButtonGradient generateSalaryBttnUpdate = new ButtonGradient();
		generateSalaryBttnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salary_employee.calculateSalary(grossSalaryUpdateSalary, socialInsuranceUpdateSalary, healthInsuranceUpdateSalary, peopleUpdateSalary, personalDeductionUpdateSalary, overtimeUpdateSalary, netSalaryUpdateSalary, overtimeHourUpdateSalary, overtimeTotalUpdateSalary, incomeUpdateSalary);
			}
		});
		generateSalaryBttnUpdate.setText("Generate");
		generateSalaryBttnUpdate.setSizeSpeed(5.0f);
		generateSalaryBttnUpdate.setForeground(Color.WHITE);
		generateSalaryBttnUpdate.setFocusPainted(false);
		generateSalaryBttnUpdate.setColor2(new Color(0, 0, 51));
		generateSalaryBttnUpdate.setColor1(Color.GRAY);
		generateSalaryBttnUpdate.setBorder(null);
		generateSalaryBttnUpdate.setBackground(SystemColor.menu);
		generateSalaryBttnUpdate.setBounds(138, 545, 204, 55);
		updateSalaryPanel.add(generateSalaryBttnUpdate);
		
		overtimeHourUpdateSalary = new JTextField();
		overtimeHourUpdateSalary.setSelectedTextColor(Color.WHITE);
		overtimeHourUpdateSalary.setOpaque(false);
		overtimeHourUpdateSalary.setForeground(Color.BLACK);
		overtimeHourUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overtimeHourUpdateSalary.setColumns(10);
		overtimeHourUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overtimeHourUpdateSalary.setBackground(Color.ORANGE);
		overtimeHourUpdateSalary.setBounds(569, 302, 172, 30);
		updateSalaryPanel.add(overtimeHourUpdateSalary);
		
	
		
		overtimeTotalUpdateSalary = new JTextField();
		overtimeTotalUpdateSalary.setSelectedTextColor(Color.WHITE);
		overtimeTotalUpdateSalary.setOpaque(false);
		overtimeTotalUpdateSalary.setForeground(Color.BLACK);
		overtimeTotalUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overtimeTotalUpdateSalary.setEditable(false);
		overtimeTotalUpdateSalary.setColumns(10);
		overtimeTotalUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		overtimeTotalUpdateSalary.setBounds(569, 368, 172, 30);
		updateSalaryPanel.add(overtimeTotalUpdateSalary);
		
		
		
		incomeUpdateSalary = new JTextField();
		incomeUpdateSalary.setSelectedTextColor(Color.WHITE);
		incomeUpdateSalary.setOpaque(false);
		incomeUpdateSalary.setForeground(Color.BLACK);
		incomeUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		incomeUpdateSalary.setEditable(false);
		incomeUpdateSalary.setColumns(10);
		incomeUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		incomeUpdateSalary.setBounds(569, 432, 172, 30);
		updateSalaryPanel.add(incomeUpdateSalary);
		
		
		
		srNoUpdateSalary = new JTextField();
		srNoUpdateSalary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					salary_employee.completeWithEnter(srNoUpdateSalary, fnUpdateSalary, lnUpdateSalary, departamentUpdateSalary, grossSalaryUpdateSalary, srNoField, employee_list);
				}
				
				
			}
		});
		srNoUpdateSalary.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				
				if(srNoUpdateSalary.getText().trim().equals("Enter Employee ID to search"))
				{
					srNoUpdateSalary.setText("");
				}
				srNoUpdateSalary.setForeground(Color.black);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(srNoUpdateSalary.getText().trim().equals("") )
				{
					srNoUpdateSalary.setText("                                                                Enter Employee ID to search");
					lnUpdateSalary.setText("");
					fnUpdateSalary.setText("");
					departamentUpdateSalary.setText("");
					grossSalaryUpdateSalary.setText("");
				}
				srNoUpdateSalary.setForeground(new Color(153,153,153));
			}
		});
		srNoUpdateSalary.setText("                                                                Enter Employee ID to search");
		srNoUpdateSalary.setSelectedTextColor(Color.WHITE);
		srNoUpdateSalary.setOpaque(false);
		srNoUpdateSalary.setForeground(Color.BLACK);
		srNoUpdateSalary.setEditable(true);
		srNoUpdateSalary.setColumns(10);
		srNoUpdateSalary.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		srNoUpdateSalary.setBounds(101, 126, 543, 30);
		updateSalaryPanel.add(srNoUpdateSalary);
		
		ButtonGradient updateSalaryBttn = new ButtonGradient();
		updateSalaryBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salary_employee.updateSalary(srNoUpdateSalary, grossSalaryUpdateSalary, socialInsuranceUpdateSalary, healthInsuranceUpdateSalary, peopleUpdateSalary, personalDeductionUpdateSalary, overtimeUpdateSalary, netSalaryUpdateSalary, overtimeHourUpdateSalary, overtimeTotalUpdateSalary, incomeUpdateSalary);
						
			}
		});
		updateSalaryBttn.setText("Update in database");
		updateSalaryBttn.setSizeSpeed(5.0f);
		updateSalaryBttn.setForeground(Color.WHITE);
		updateSalaryBttn.setFocusPainted(false);
		updateSalaryBttn.setColor2(new Color(0, 0, 51));
		updateSalaryBttn.setColor1(Color.GRAY);
		updateSalaryBttn.setBorder(null);
		updateSalaryBttn.setBackground(SystemColor.menu);
		updateSalaryBttn.setBounds(402, 545, 204, 55);
		updateSalaryPanel.add(updateSalaryBttn);
		
		JTextPane txtpnAddEmployeeMenu_1_2_1 = new JTextPane();
		txtpnAddEmployeeMenu_1_2_1.setText("UPDATE SALARY");
		txtpnAddEmployeeMenu_1_2_1.setOpaque(false);
		txtpnAddEmployeeMenu_1_2_1.setForeground(Color.BLACK);
		txtpnAddEmployeeMenu_1_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1_2_1.setEditable(false);
		txtpnAddEmployeeMenu_1_2_1.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1_2_1.setBounds(299, 23, 214, 44);
		updateSalaryPanel.add(txtpnAddEmployeeMenu_1_2_1);
		
		
	}
	private void init_text_add_panel(JPanel addPanel)
	{
		JTextPane txtpnSrNo = new JTextPane();
		txtpnSrNo.setForeground(Color.BLACK);
		txtpnSrNo.setText("Sr No:\r\n");
		txtpnSrNo.setOpaque(false);
		txtpnSrNo.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo.setEditable(false);
		txtpnSrNo.setCaretColor(Color.CYAN);
		txtpnSrNo.setBounds(138, 129, 67, 20);
		addPanel.add(txtpnSrNo);
		
		JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setForeground(Color.BLACK);
		txtpnFirstName.setText("First Name");
		txtpnFirstName.setOpaque(false);
		txtpnFirstName.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName.setEditable(false);
		txtpnFirstName.setBounds(138, 199, 67, 20);
		addPanel.add(txtpnFirstName);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setForeground(Color.BLACK);
		txtpnLastName.setText("Last Name");
		txtpnLastName.setOpaque(false);
		txtpnLastName.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName.setEditable(false);
		txtpnLastName.setBounds(420, 199, 67, 20);
		addPanel.add(txtpnLastName);
		
		JTextPane txtpnDepartament = new JTextPane();
		txtpnDepartament.setForeground(Color.BLACK);
		txtpnDepartament.setText("Departament");
		txtpnDepartament.setOpaque(false);
		txtpnDepartament.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament.setEditable(false);
		txtpnDepartament.setBounds(138, 271, 78, 20);
		addPanel.add(txtpnDepartament);
		
		JTextPane txtpnDesignation = new JTextPane();
		txtpnDesignation.setForeground(Color.BLACK);
		txtpnDesignation.setText("Designation");
		txtpnDesignation.setOpaque(false);
		txtpnDesignation.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation.setEditable(false);
		txtpnDesignation.setBounds(420, 271, 78, 20);
		addPanel.add(txtpnDesignation);
		
		JTextPane txtpnContactNumber = new JTextPane();
		txtpnContactNumber.setForeground(Color.BLACK);
		txtpnContactNumber.setText("Contact number");
		txtpnContactNumber.setOpaque(false);
		txtpnContactNumber.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber.setEditable(false);
		txtpnContactNumber.setBounds(138, 345, 94, 20);
		addPanel.add(txtpnContactNumber);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setForeground(Color.BLACK);
		txtpnAddress.setText("Address");
		txtpnAddress.setOpaque(false);
		txtpnAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress.setEditable(false);
		txtpnAddress.setBounds(138, 411, 67, 20);
		addPanel.add(txtpnAddress);
		
		JTextPane txtpnBasicSalary = new JTextPane();
		txtpnBasicSalary.setForeground(Color.BLACK);
		txtpnBasicSalary.setText("Gross salary(LEI)");
		txtpnBasicSalary.setOpaque(false);
		txtpnBasicSalary.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnBasicSalary.setEditable(false);
		txtpnBasicSalary.setBounds(138, 470, 110, 20);
		addPanel.add(txtpnBasicSalary);
		
		JTextPane txtpnAddEmployeeMenu = new JTextPane();
		txtpnAddEmployeeMenu.setForeground(Color.BLACK);
		txtpnAddEmployeeMenu.setText("ADD EMPLOYEE\r\n");
		txtpnAddEmployeeMenu.setOpaque(false);
		txtpnAddEmployeeMenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu.setEditable(false);
		txtpnAddEmployeeMenu.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu.setBounds(324, 38, 214, 44);
		addPanel.add(txtpnAddEmployeeMenu);
		
	}
	private void int_text_update_salary_panel(JPanel updateSalaryPanel)
	{
		JTextPane srNoTxtUpdateSalary = new JTextPane();
		srNoTxtUpdateSalary.setText("Sr No:\r\n");
		srNoTxtUpdateSalary.setOpaque(false);
		srNoTxtUpdateSalary.setForeground(Color.BLACK);
		srNoTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		srNoTxtUpdateSalary.setEditable(false);
		srNoTxtUpdateSalary.setCaretColor(Color.CYAN);
		srNoTxtUpdateSalary.setBounds(101, 105, 67, 20);
		updateSalaryPanel.add(srNoTxtUpdateSalary);
		
		JTextPane fnTxtUpdateSalary = new JTextPane();
		fnTxtUpdateSalary.setText("First name");
		fnTxtUpdateSalary.setOpaque(false);
		fnTxtUpdateSalary.setForeground(Color.BLACK);
		fnTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		fnTxtUpdateSalary.setEditable(false);
		fnTxtUpdateSalary.setCaretColor(Color.CYAN);
		fnTxtUpdateSalary.setBounds(39, 224, 67, 20);
		updateSalaryPanel.add(fnTxtUpdateSalary);
		
		
		JTextPane lnTxtUpdateSalary = new JTextPane();
		lnTxtUpdateSalary.setText("Last name");
		lnTxtUpdateSalary.setOpaque(false);
		lnTxtUpdateSalary.setForeground(Color.BLACK);
		lnTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lnTxtUpdateSalary.setEditable(false);
		lnTxtUpdateSalary.setCaretColor(Color.CYAN);
		lnTxtUpdateSalary.setBounds(39, 283, 67, 20);
		updateSalaryPanel.add(lnTxtUpdateSalary);
		
		JTextPane departamentTxtUpdateSalary = new JTextPane();
		departamentTxtUpdateSalary.setText("Departament");
		departamentTxtUpdateSalary.setOpaque(false);
		departamentTxtUpdateSalary.setForeground(Color.BLACK);
		departamentTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		departamentTxtUpdateSalary.setEditable(false);
		departamentTxtUpdateSalary.setCaretColor(Color.CYAN);
		departamentTxtUpdateSalary.setBounds(39, 349, 82, 20);
		updateSalaryPanel.add(departamentTxtUpdateSalary);
		
		JTextPane grossSalaryTxtUpdateSalary = new JTextPane();
		grossSalaryTxtUpdateSalary.setText("Gross Salary(Lei)");
		grossSalaryTxtUpdateSalary.setOpaque(false);
		grossSalaryTxtUpdateSalary.setForeground(Color.BLACK);
		grossSalaryTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		grossSalaryTxtUpdateSalary.setEditable(false);
		grossSalaryTxtUpdateSalary.setCaretColor(Color.CYAN);
		grossSalaryTxtUpdateSalary.setBounds(39, 413, 103, 20);
		updateSalaryPanel.add(grossSalaryTxtUpdateSalary);
		
		JTextPane txtpnEmployeeInformation_1 = new JTextPane();
		txtpnEmployeeInformation_1.setText("Employee information");
		txtpnEmployeeInformation_1.setOpaque(false);
		txtpnEmployeeInformation_1.setForeground(new Color(0, 0, 102));
		txtpnEmployeeInformation_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtpnEmployeeInformation_1.setEditable(false);
		txtpnEmployeeInformation_1.setBounds(39, 190, 180, 23);
		updateSalaryPanel.add(txtpnEmployeeInformation_1);
		
		JTextPane txtpnIntroduceData_1 = new JTextPane();
		txtpnIntroduceData_1.setText("Enter the data");
		txtpnIntroduceData_1.setOpaque(false);
		txtpnIntroduceData_1.setForeground(new Color(0, 0, 102));
		txtpnIntroduceData_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtpnIntroduceData_1.setEditable(false);
		txtpnIntroduceData_1.setBounds(500, 183, 114, 30);
		updateSalaryPanel.add(txtpnIntroduceData_1);
		
		JTextPane overtimeTxtUpdateSalary = new JTextPane();
		overtimeTxtUpdateSalary.setText("Overtime(Lei)*:\r\n");
		overtimeTxtUpdateSalary.setOpaque(false);
		overtimeTxtUpdateSalary.setForeground(Color.BLACK);
		overtimeTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		overtimeTxtUpdateSalary.setEditable(false);
		overtimeTxtUpdateSalary.setCaretColor(Color.CYAN);
		overtimeTxtUpdateSalary.setBounds(569, 224, 172, 20);
		updateSalaryPanel.add(overtimeTxtUpdateSalary);
		
		JTextPane siTxtUpdateSalary = new JTextPane();
		siTxtUpdateSalary.setText("Social Insurance(25%)\r\n");
		siTxtUpdateSalary.setOpaque(false);
		siTxtUpdateSalary.setForeground(Color.BLACK);
		siTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		siTxtUpdateSalary.setEditable(false);
		siTxtUpdateSalary.setCaretColor(Color.CYAN);
		siTxtUpdateSalary.setBounds(364, 413, 172, 20);
		updateSalaryPanel.add(siTxtUpdateSalary);
		
		JTextPane hiTxtUpdateSalary = new JTextPane();
		hiTxtUpdateSalary.setText("Health Insurance(10%)");
		hiTxtUpdateSalary.setOpaque(false);
		hiTxtUpdateSalary.setForeground(Color.BLACK);
		hiTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		hiTxtUpdateSalary.setEditable(false);
		hiTxtUpdateSalary.setCaretColor(Color.CYAN);
		hiTxtUpdateSalary.setBounds(364, 349, 172, 20);
		updateSalaryPanel.add(hiTxtUpdateSalary);
		
		
		JTextPane peopleTxtUpdateSalary = new JTextPane();
		peopleTxtUpdateSalary.setText("People for deduction\r\n*");
		peopleTxtUpdateSalary.setOpaque(false);
		peopleTxtUpdateSalary.setForeground(Color.BLACK);
		peopleTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		peopleTxtUpdateSalary.setEditable(false);
		peopleTxtUpdateSalary.setCaretColor(Color.CYAN);
		peopleTxtUpdateSalary.setBounds(364, 224, 132, 20);
		updateSalaryPanel.add(peopleTxtUpdateSalary);
		
		JTextPane dpTxtUpdateSalary = new JTextPane();
		dpTxtUpdateSalary.setText("Personal Deduction");
		dpTxtUpdateSalary.setOpaque(false);
		dpTxtUpdateSalary.setForeground(Color.BLACK);
		dpTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		dpTxtUpdateSalary.setEditable(false);
		dpTxtUpdateSalary.setCaretColor(Color.CYAN);
		dpTxtUpdateSalary.setBounds(368, 283, 172, 20);
		updateSalaryPanel.add(dpTxtUpdateSalary);
		
		JTextPane hourOvertimeTxtUpdateSalary = new JTextPane();
		hourOvertimeTxtUpdateSalary.setText("Overtime worked(enter hour)");
		hourOvertimeTxtUpdateSalary.setOpaque(false);
		hourOvertimeTxtUpdateSalary.setForeground(Color.BLACK);
		hourOvertimeTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		hourOvertimeTxtUpdateSalary.setEditable(false);
		hourOvertimeTxtUpdateSalary.setCaretColor(Color.CYAN);
		hourOvertimeTxtUpdateSalary.setBounds(569, 283, 194, 20);
		updateSalaryPanel.add(hourOvertimeTxtUpdateSalary);
		
		JTextPane netTxtUpdateSalary = new JTextPane();
		netTxtUpdateSalary.setText("Net salary(Lei):\r\n");
		netTxtUpdateSalary.setOpaque(false);
		netTxtUpdateSalary.setForeground(Color.BLACK);
		netTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		netTxtUpdateSalary.setEditable(false);
		netTxtUpdateSalary.setCaretColor(Color.CYAN);
		netTxtUpdateSalary.setBounds(364, 473, 377, 20);
		updateSalaryPanel.add(netTxtUpdateSalary);
		
		JTextPane incomeTxtUpdateSalary = new JTextPane();
		incomeTxtUpdateSalary.setText("Income tax(10%)");
		incomeTxtUpdateSalary.setOpaque(false);
		incomeTxtUpdateSalary.setForeground(Color.BLACK);
		incomeTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		incomeTxtUpdateSalary.setEditable(false);
		incomeTxtUpdateSalary.setCaretColor(Color.CYAN);
		incomeTxtUpdateSalary.setBounds(569, 413, 172, 20);
		updateSalaryPanel.add(incomeTxtUpdateSalary);
		
		JTextPane totalOvertimeTxtUpdateSalary = new JTextPane();
		totalOvertimeTxtUpdateSalary.setText("Total money for overtime");
		totalOvertimeTxtUpdateSalary.setOpaque(false);
		totalOvertimeTxtUpdateSalary.setForeground(Color.BLACK);
		totalOvertimeTxtUpdateSalary.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		totalOvertimeTxtUpdateSalary.setEditable(false);
		totalOvertimeTxtUpdateSalary.setCaretColor(Color.CYAN);
		totalOvertimeTxtUpdateSalary.setBounds(569, 349, 172, 20);
		updateSalaryPanel.add(totalOvertimeTxtUpdateSalary);
		
		
	}
	private void init_text_update_panel(GradientPanel updatePanel)
	{
		JTextPane txtpnSrNo_1 = new JTextPane();
		txtpnSrNo_1.setForeground(Color.BLACK);
		txtpnSrNo_1.setText("Sr No:\r\n");
		txtpnSrNo_1.setOpaque(false);
		txtpnSrNo_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1.setEditable(false);
		txtpnSrNo_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1.setBounds(138, 129, 67, 20);
		updatePanel.add(txtpnSrNo_1);
		
		JTextPane txtpnFirstName_1 = new JTextPane();
		txtpnFirstName_1.setForeground(Color.BLACK);
		txtpnFirstName_1.setText("First Name");
		txtpnFirstName_1.setOpaque(false);
		txtpnFirstName_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName_1.setEditable(false);
		txtpnFirstName_1.setBounds(138, 199, 67, 20);
		updatePanel.add(txtpnFirstName_1);
		
		JTextPane txtpnLastName_1 = new JTextPane();
		txtpnLastName_1.setForeground(Color.BLACK);
		txtpnLastName_1.setText("Last Name");
		txtpnLastName_1.setOpaque(false);
		txtpnLastName_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName_1.setEditable(false);
		txtpnLastName_1.setBounds(420, 199, 67, 20);
		updatePanel.add(txtpnLastName_1);
		
		JTextPane txtpnDepartament_1 = new JTextPane();
		txtpnDepartament_1.setForeground(Color.BLACK);
		txtpnDepartament_1.setText("Departament");
		txtpnDepartament_1.setOpaque(false);
		txtpnDepartament_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament_1.setEditable(false);
		txtpnDepartament_1.setBounds(138, 271, 78, 20);
		updatePanel.add(txtpnDepartament_1);
		
		JTextPane txtpnDesignation_1 = new JTextPane();
		txtpnDesignation_1.setForeground(Color.BLACK);
		txtpnDesignation_1.setText("Designation");
		txtpnDesignation_1.setOpaque(false);
		txtpnDesignation_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation_1.setEditable(false);
		txtpnDesignation_1.setBounds(420, 271, 78, 20);
		updatePanel.add(txtpnDesignation_1);
		
		JTextPane txtpnContactNumber_1 = new JTextPane();
		txtpnContactNumber_1.setForeground(Color.BLACK);
		txtpnContactNumber_1.setText("Contact number");
		txtpnContactNumber_1.setOpaque(false);
		txtpnContactNumber_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber_1.setEditable(false);
		txtpnContactNumber_1.setBounds(138, 345, 94, 20);
		updatePanel.add(txtpnContactNumber_1);
		
		JTextPane txtpnAddress_1 = new JTextPane();
		txtpnAddress_1.setForeground(Color.BLACK);
		txtpnAddress_1.setText("Address");
		txtpnAddress_1.setOpaque(false);
		txtpnAddress_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress_1.setEditable(false);
		txtpnAddress_1.setBounds(138, 411, 67, 20);
		updatePanel.add(txtpnAddress_1);
		
		JTextPane txtpnAddEmployeeMenu_1 = new JTextPane();
		txtpnAddEmployeeMenu_1.setForeground(Color.BLACK);
		txtpnAddEmployeeMenu_1.setText("UPDATE EMPLOYEE\r\n");
		txtpnAddEmployeeMenu_1.setOpaque(false);
		txtpnAddEmployeeMenu_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1.setEditable(false);
		txtpnAddEmployeeMenu_1.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1.setBounds(324, 38, 214, 44);
		updatePanel.add(txtpnAddEmployeeMenu_1);
	}

	private void init_text_generate_panel(GradientPanel generatePanel)
	{
		JTextPane txtpnAddEmployeeMenu_1_2 = new JTextPane();
		txtpnAddEmployeeMenu_1_2.setText("GENERATE SALARY");
		txtpnAddEmployeeMenu_1_2.setOpaque(false);
		txtpnAddEmployeeMenu_1_2.setForeground(Color.BLACK);
		txtpnAddEmployeeMenu_1_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1_2.setEditable(false);
		txtpnAddEmployeeMenu_1_2.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1_2.setBounds(299, 23, 214, 44);
		generatePanel.add(txtpnAddEmployeeMenu_1_2);
		
		JTextPane txtpnSrNo_1_2 = new JTextPane();
		txtpnSrNo_1_2.setForeground(Color.BLACK);
		txtpnSrNo_1_2.setText("Sr No:\r\n");
		txtpnSrNo_1_2.setOpaque(false);
		txtpnSrNo_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2.setEditable(false);
		txtpnSrNo_1_2.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2.setBounds(101, 104, 67, 20);
		generatePanel.add(txtpnSrNo_1_2);
		
		JTextPane txtpnSrNo_1_2_1 = new JTextPane();
		txtpnSrNo_1_2_1.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1.setText("First name");
		txtpnSrNo_1_2_1.setOpaque(false);
		txtpnSrNo_1_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1.setEditable(false);
		txtpnSrNo_1_2_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1.setBounds(39, 224, 67, 20);
		generatePanel.add(txtpnSrNo_1_2_1);
		
		JTextPane txtpnSrNo_1_2_1_1 = new JTextPane();
		txtpnSrNo_1_2_1_1.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_1.setText("Last name");
		txtpnSrNo_1_2_1_1.setOpaque(false);
		txtpnSrNo_1_2_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_1.setEditable(false);
		txtpnSrNo_1_2_1_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_1.setBounds(39, 283, 67, 20);
		generatePanel.add(txtpnSrNo_1_2_1_1);
		
		
		JTextPane txtpnEmployeeInformation = new JTextPane();
		txtpnEmployeeInformation.setForeground(new Color(0, 0, 102));
		txtpnEmployeeInformation.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtpnEmployeeInformation.setOpaque(false);
		txtpnEmployeeInformation.setEditable(false);
		txtpnEmployeeInformation.setText("Employee information");
		txtpnEmployeeInformation.setBounds(39, 190, 180, 23);
		generatePanel.add(txtpnEmployeeInformation);
		
		
		JTextPane txtpnSrNo_1_2_1_2 = new JTextPane();
		txtpnSrNo_1_2_1_2.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_2.setText("Departament");
		txtpnSrNo_1_2_1_2.setOpaque(false);
		txtpnSrNo_1_2_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_2.setEditable(false);
		txtpnSrNo_1_2_1_2.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_2.setBounds(39, 349, 82, 20);
		generatePanel.add(txtpnSrNo_1_2_1_2);
		
		
		JTextPane txtpnIntroduceData = new JTextPane();
		txtpnIntroduceData.setText("Enter the data");
		txtpnIntroduceData.setOpaque(false);
		txtpnIntroduceData.setForeground(new Color(0, 0, 102));
		txtpnIntroduceData.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		txtpnIntroduceData.setEditable(false);
		txtpnIntroduceData.setBounds(500, 183, 114, 30);
		generatePanel.add(txtpnIntroduceData);
		
		JTextPane txtpnSrNo_1_2_1_2_1 = new JTextPane();
		txtpnSrNo_1_2_1_2_1.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_2_1.setText("Gross Salary(Lei)");
		txtpnSrNo_1_2_1_2_1.setOpaque(false);
		txtpnSrNo_1_2_1_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_2_1.setEditable(false);
		txtpnSrNo_1_2_1_2_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_2_1.setBounds(39, 413, 103, 20);
		generatePanel.add(txtpnSrNo_1_2_1_2_1);
		
		JTextPane txtpnPeopleForDeduction = new JTextPane();
		txtpnPeopleForDeduction.setForeground(Color.BLACK);
		txtpnPeopleForDeduction.setText("People for deduction\r\n*");
		txtpnPeopleForDeduction.setOpaque(false);
		txtpnPeopleForDeduction.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnPeopleForDeduction.setEditable(false);
		txtpnPeopleForDeduction.setCaretColor(Color.CYAN);
		txtpnPeopleForDeduction.setBounds(364, 224, 132, 20);
		generatePanel.add(txtpnPeopleForDeduction);
		

		
		JTextPane txtpnPersonalDeduction = new JTextPane();
		txtpnPersonalDeduction.setForeground(Color.BLACK);
		txtpnPersonalDeduction.setText("Personal Deduction");
		txtpnPersonalDeduction.setOpaque(false);
		txtpnPersonalDeduction.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnPersonalDeduction.setEditable(false);
		txtpnPersonalDeduction.setCaretColor(Color.CYAN);
		txtpnPersonalDeduction.setBounds(368, 283, 172, 20);
		generatePanel.add(txtpnPersonalDeduction);

		
		JTextPane txtpnSrNo_1_2_1_3_2 = new JTextPane();
		txtpnSrNo_1_2_1_3_2.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_3_2.setText("Net salary(Lei):\r\n");
		txtpnSrNo_1_2_1_3_2.setOpaque(false);
		txtpnSrNo_1_2_1_3_2.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_3_2.setEditable(false);
		txtpnSrNo_1_2_1_3_2.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_3_2.setBounds(364, 473, 377, 20);
		generatePanel.add(txtpnSrNo_1_2_1_3_2);
		
		JTextPane txtpnWorkHours = new JTextPane();
		txtpnWorkHours.setForeground(Color.BLACK);
		txtpnWorkHours.setText("Overtime worked(enter hour)");
		txtpnWorkHours.setOpaque(false);
		txtpnWorkHours.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnWorkHours.setEditable(false);
		txtpnWorkHours.setCaretColor(Color.CYAN);
		txtpnWorkHours.setBounds(569, 283, 194, 20);
		generatePanel.add(txtpnWorkHours);
		
		JTextPane txtpnTotalMoneyFor = new JTextPane();
		txtpnTotalMoneyFor.setForeground(Color.BLACK);
		txtpnTotalMoneyFor.setText("Total money for overtime");
		txtpnTotalMoneyFor.setOpaque(false);
		txtpnTotalMoneyFor.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnTotalMoneyFor.setEditable(false);
		txtpnTotalMoneyFor.setCaretColor(Color.CYAN);
		txtpnTotalMoneyFor.setBounds(569, 349, 172, 20);
		generatePanel.add(txtpnTotalMoneyFor);
		
		
		JTextPane txtpnIncomeTax = new JTextPane();
		txtpnIncomeTax.setForeground(Color.BLACK);
		txtpnIncomeTax.setText("Income tax(10%)");
		txtpnIncomeTax.setOpaque(false);
		txtpnIncomeTax.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnIncomeTax.setEditable(false);
		txtpnIncomeTax.setCaretColor(Color.CYAN);
		txtpnIncomeTax.setBounds(569, 413, 172, 20);
		generatePanel.add(txtpnIncomeTax);
		
		JTextPane txtpnSrNo_1_2_1_3 = new JTextPane();
		txtpnSrNo_1_2_1_3.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_3.setText("Overtime(Lei)*:\r\n");
		txtpnSrNo_1_2_1_3.setOpaque(false);
		txtpnSrNo_1_2_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_3.setEditable(false);
		txtpnSrNo_1_2_1_3.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_3.setBounds(569, 224, 172, 20);
		generatePanel.add(txtpnSrNo_1_2_1_3);
		
		JTextPane txtpnSrNo_1_2_1_3_1 = new JTextPane();
		txtpnSrNo_1_2_1_3_1.setForeground(Color.BLACK);
		txtpnSrNo_1_2_1_3_1.setText("Social Insurance(25%)\r\n");
		txtpnSrNo_1_2_1_3_1.setOpaque(false);
		txtpnSrNo_1_2_1_3_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_2_1_3_1.setEditable(false);
		txtpnSrNo_1_2_1_3_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_2_1_3_1.setBounds(364, 413, 172, 20);
		generatePanel.add(txtpnSrNo_1_2_1_3_1);
		
		JTextPane healthInsuranceTxt = new JTextPane();
		healthInsuranceTxt.setForeground(Color.BLACK);
		healthInsuranceTxt.setText("Health Insurance(10%)");
		healthInsuranceTxt.setOpaque(false);
		healthInsuranceTxt.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		healthInsuranceTxt.setEditable(false);
		healthInsuranceTxt.setCaretColor(Color.CYAN);
		healthInsuranceTxt.setBounds(364, 349, 172, 20);
		generatePanel.add(healthInsuranceTxt);
		
		
	}
	private void init_text_delete_panel(GradientPanel deletePanel)
	{
		JTextPane txtpnSrNo_1_1 = new JTextPane();
		txtpnSrNo_1_1.setForeground(Color.BLACK);
		txtpnSrNo_1_1.setText("Sr No:\r\n");
		txtpnSrNo_1_1.setOpaque(false);
		txtpnSrNo_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		txtpnSrNo_1_1.setEditable(false);
		txtpnSrNo_1_1.setCaretColor(Color.CYAN);
		txtpnSrNo_1_1.setBounds(138, 129, 67, 20);
		deletePanel.add(txtpnSrNo_1_1);
		
		JTextPane txtpnFirstName_1_1 = new JTextPane();
		txtpnFirstName_1_1.setForeground(Color.BLACK);
		txtpnFirstName_1_1.setText("First Name");
		txtpnFirstName_1_1.setOpaque(false);
		txtpnFirstName_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnFirstName_1_1.setEditable(false);
		txtpnFirstName_1_1.setBounds(138, 199, 67, 20);
		deletePanel.add(txtpnFirstName_1_1);
		
		JTextPane txtpnLastName_1_1 = new JTextPane();
		txtpnLastName_1_1.setForeground(Color.BLACK);
		txtpnLastName_1_1.setText("Last Name");
		txtpnLastName_1_1.setOpaque(false);
		txtpnLastName_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnLastName_1_1.setEditable(false);
		txtpnLastName_1_1.setBounds(420, 199, 67, 20);
		deletePanel.add(txtpnLastName_1_1);
		
		JTextPane txtpnDepartament_1_1 = new JTextPane();
		txtpnDepartament_1_1.setForeground(Color.BLACK);
		txtpnDepartament_1_1.setText("Departament");
		txtpnDepartament_1_1.setOpaque(false);
		txtpnDepartament_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDepartament_1_1.setEditable(false);
		txtpnDepartament_1_1.setBounds(138, 271, 78, 20);
		deletePanel.add(txtpnDepartament_1_1);
		
		JTextPane txtpnDesignation_1_1 = new JTextPane();
		txtpnDesignation_1_1.setForeground(Color.BLACK);
		txtpnDesignation_1_1.setText("Designation");
		txtpnDesignation_1_1.setOpaque(false);
		txtpnDesignation_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnDesignation_1_1.setEditable(false);
		txtpnDesignation_1_1.setBounds(420, 271, 78, 20);
		deletePanel.add(txtpnDesignation_1_1);
		
		JTextPane txtpnContactNumber_1_1 = new JTextPane();
		txtpnContactNumber_1_1.setForeground(Color.BLACK);
		txtpnContactNumber_1_1.setText("Contact number");
		txtpnContactNumber_1_1.setOpaque(false);
		txtpnContactNumber_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnContactNumber_1_1.setEditable(false);
		txtpnContactNumber_1_1.setBounds(138, 345, 94, 20);
		deletePanel.add(txtpnContactNumber_1_1);
		
		JTextPane txtpnAddress_1_1 = new JTextPane();
		txtpnAddress_1_1.setForeground(Color.BLACK);
		txtpnAddress_1_1.setText("Address");
		txtpnAddress_1_1.setOpaque(false);
		txtpnAddress_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtpnAddress_1_1.setEditable(false);
		txtpnAddress_1_1.setBounds(138, 411, 67, 20);
		deletePanel.add(txtpnAddress_1_1);
		
		JTextPane txtpnAddEmployeeMenu_1_1 = new JTextPane();
		txtpnAddEmployeeMenu_1_1.setForeground(Color.BLACK);
		txtpnAddEmployeeMenu_1_1.setText("DELETE EMPLOYEE\r\n");
		txtpnAddEmployeeMenu_1_1.setOpaque(false);
		txtpnAddEmployeeMenu_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		txtpnAddEmployeeMenu_1_1.setEditable(false);
		txtpnAddEmployeeMenu_1_1.setDisabledTextColor(Color.BLACK);
		txtpnAddEmployeeMenu_1_1.setBounds(324, 38, 214, 44);
		deletePanel.add(txtpnAddEmployeeMenu_1_1);
	}
	
	private void setVisiblePanel(GradientPanel visiblePanel,GradientPanel invisiblePanel1,GradientPanel invisiblePanel2,GradientPanel invisiblePanel3,GradientPanel invisiblePanel4)
	{
		visiblePanel.setVisible(true);
		invisiblePanel1.setVisible(false);
		invisiblePanel2.setVisible(false);
		invisiblePanel3.setVisible(false);
		invisiblePanel4.setVisible(false);
	}
	private void header(GradientPanel destinatie)
	{
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(-220, 0, 997, 27);
		destinatie.add(panel);
		panel.setLayout(null);
		
		move_windows(panel); 
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(972, 0, 25, 25);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\x-icon-png-17.png"));
		panel.add(lblNewLabel_1);
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
	}
}

