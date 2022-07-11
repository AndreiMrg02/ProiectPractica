package GUI;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.MatteBorder;

import javax.swing.border.SoftBevelBorder;

import connection.MyConnection;


import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel mainPanel = new JPanel();
	private JTextField fnField;
	private JTextField lnField;
	private JTextField userField;
	private JPasswordField passField;
	private JTextField ansField;
	
	
	private int mouseX, mouseY;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private JTextField mailField;
	private JTextField txtSecurityQuestion;

	private JTextField txtAnswer;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					SignUp frame = new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp() {
	
	     initialize();
	     conn = MyConnection.getInstance().getConnection();
		 backgorundSignUp();
	    
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {

		frame =  new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		double x = 25;
		double y = 25;
		frame.setShape(new RoundRectangle2D.Double(x, y, 500, 360, x, y));
	    frame.setSize(600, 460);
		frame.setLocationByPlatform(false);
	    frame.setVisible(true);
		
	
		mainPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 799, 750, 1);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel headerMainPanel = new JPanel();
		headerMainPanel.setBackground(SystemColor.activeCaption);
		headerMainPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		headerMainPanel.setBounds(23, 11, 503, 48);
		mainPanel.add(headerMainPanel);
		headerMainPanel.setLayout(null);
		
		move_windows(headerMainPanel);
		
		JLabel x_Bttn = new JLabel("");
		x_Bttn.setBounds(467, 0, 36, 54);
		headerMainPanel.add(x_Bttn);
		x_Bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		x_Bttn.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\x-icon-png-17.png"));
		x_Bttn.setVisible(true);
		
		fnField = new JTextField();
		fnField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		fnField.setOpaque(false);
		fnField.setBounds(92, 80, 154, 25);
		mainPanel.add(fnField);
		fnField.setColumns(10);
		
		lnField = new JTextField();
		lnField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lnField.setOpaque(false);
		lnField.setColumns(10);
		lnField.setBounds(286, 80, 154, 25);
		mainPanel.add(lnField);
		
		JComboBox comboField = new JComboBox();
		comboField.setOpaque(false);
		comboField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		comboField.setModel(new DefaultComboBoxModel(new String[] {"Application development", "Technical support", "IT network", "Network contingencies"}));
		comboField.setBounds(92, 193, 154, 31);
		mainPanel.add(comboField);
		
		JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setEditable(false);
		txtpnFirstName.setForeground(SystemColor.textHighlight);
		txtpnFirstName.setFont(new Font("Segoe UI Black", txtpnFirstName.getFont().getStyle(), txtpnFirstName.getFont().getSize()));
		txtpnFirstName.setOpaque(false);
		txtpnFirstName.setText("First Name");
		txtpnFirstName.setBounds(92, 61, 140, 20);
		mainPanel.add(txtpnFirstName);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setEditable(false);
		txtpnLastName.setForeground(SystemColor.textHighlight);
		txtpnLastName.setFont(new Font("Segoe UI Black", txtpnLastName.getFont().getStyle(), txtpnLastName.getFont().getSize()));
		txtpnLastName.setOpaque(false);
		txtpnLastName.setText("Last Name");
		txtpnLastName.setBounds(286, 61, 140, 20);
		mainPanel.add(txtpnLastName);
		
		JTextPane txtpnGrade = new JTextPane();
		txtpnGrade.setEditable(false);
		txtpnGrade.setForeground(SystemColor.textHighlight);
		txtpnGrade.setFont(new Font("Segoe UI Black", txtpnGrade.getFont().getStyle(), txtpnGrade.getFont().getSize()));
		txtpnGrade.setOpaque(false);
		txtpnGrade.setText("Departament\r\n");
		txtpnGrade.setBounds(92, 171, 140, 20);
		mainPanel.add(txtpnGrade);
		
		userField = new JTextField();
		userField.setOpaque(false);
		userField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		userField.setColumns(10);
		userField.setBounds(92, 135, 154, 25);
		mainPanel.add(userField);
		
		JTextPane userTxt;
		userTxt = new JTextPane();
		userTxt.setEditable(false);
		userTxt.setForeground(SystemColor.textHighlight);
		userTxt.setFont(new Font("Segoe UI Black", userTxt.getFont().getStyle(), userTxt.getFont().getSize()));
		userTxt.setText("User id");
		userTxt.setOpaque(false);
		userTxt.setBounds(92, 116, 140, 20);
		mainPanel.add(userTxt);
		
		
		passField = new JPasswordField();
		passField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		passField.setOpaque(false);
		passField.setBounds(92, 253, 154, 25);
		mainPanel.add(passField);
		
		JTextPane txtPass = new JTextPane();
		txtPass.setEditable(false);
		txtPass.setForeground(SystemColor.textHighlight);
		txtPass.setFont(new Font("Segoe UI Black", txtPass.getFont().getStyle(), txtPass.getFont().getSize()));
		txtPass.setText("Password");
		txtPass.setOpaque(false);
		txtPass.setBounds(92, 235, 140, 20);
		mainPanel.add(txtPass);
		
		JComboBox questionField;
		questionField = new JComboBox();
		questionField.setModel(new DefaultComboBoxModel(new String[] {"Numele mamei?", "Data mamei de nastere?", "Data tatalui de nasere?"}));
		questionField.setOpaque(false);
		questionField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		questionField.setBounds(286, 193, 154, 31);
		mainPanel.add(questionField);
		
		
		JButton signupBttn = new JButton("Sign Up");
		signupBttn.setForeground(SystemColor.textHighlight);
		signupBttn.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null,"Are you sure to add this record?","Add Record",JOptionPane.YES_NO_OPTION);
				if(p == 0)
				{
					String query = "INSERT INTO `user`(`uname`, `pass`, `fname`, `lname`, `designation`, `question`, `ans`, `mail`) VALUES (?,?,?,?,?,?,?,?)";
					
					String username = userField.getText();
					String firstname = fnField.getText();
					String lastname = lnField.getText();
					String pass = String.valueOf(passField.getPassword());
					String mail =  mailField.getText();
					String ans =  ansField.getText();
					
					
					if(firstname.equalsIgnoreCase("")) { 
						JOptionPane.showMessageDialog(null, "First Name filed is empty");
					} else if(lastname.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Last Name filed is empty");
					} else if(username.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Username filed is empty");
					}
					else if(pass.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Password filed is empty");
					}else if(mail.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Mail filed is empty");
					}
					else if(ans.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Answer filed is empty");
					}
					else
					{
					
					try{
					
				
					if(verifyUsername(username) ==  true)
					{
						ps = conn.prepareStatement(query);
						
						ps.setString(1, username);	
						ps.setString(2, String.valueOf(passField.getPassword()));
						ps.setString(3, fnField.getText());
						ps.setString(4, lnField.getText());
						ps.setString(5,(String)comboField.getSelectedItem());
						ps.setString(6,(String)questionField.getSelectedItem());
						ps.setString(7, ansField.getText());
						ps.setString(8, mailField.getText());
						ps.execute();
						
						LoginMenu l = new LoginMenu();
						frame.dispose();
					
						JOptionPane.showMessageDialog(null, "Successfully!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username-ul exista in baza de date!");
					}
					
					
					} catch(SQLException ex)
					{
					 JOptionPane.showMessageDialog(null, ex);	
					 
					}
					}
				}else
				{
					JOptionPane.showMessageDialog(null,"Error! Check the information again !");
				}
			
			
			}
		});
		signupBttn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		signupBttn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signupBttn.setBounds(186, 289, 153, 38);
		mainPanel.add(signupBttn);
		
		JButton backBttn = new JButton("Back");
		backBttn.setForeground(SystemColor.textHighlight);
		backBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				@SuppressWarnings("unused")
				LoginMenu login =  new LoginMenu();
			}
		});
		backBttn.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		backBttn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBttn.setBounds(210, 338, 111, 38);
		mainPanel.add(backBttn);
		
		
		mailField = new JTextField();
		mailField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mailField.setOpaque(false);
		mailField.setBounds(286, 135, 154, 25);
		mainPanel.add(mailField);
		mailField.setColumns(10);
		
		JTextPane txtpnMail = new JTextPane();
		txtpnMail.setEditable(false);
		txtpnMail.setFont(new Font("Segoe UI Black", txtpnMail.getFont().getStyle(), txtpnMail.getFont().getSize()));
		txtpnMail.setOpaque(false);
		txtpnMail.setForeground(SystemColor.textHighlight);
		txtpnMail.setText("Mail\r\n");
		txtpnMail.setBounds(286, 116, 35, 20);
		mainPanel.add(txtpnMail);
		
		
		
		ansField = new JTextField();
		ansField.setOpaque(false);
		ansField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ansField.setBounds(286, 253, 154, 25);
		mainPanel.add(ansField);
		ansField.setColumns(10);
		
		txtSecurityQuestion = new JTextField();
		txtSecurityQuestion.setEditable(false);
		txtSecurityQuestion.setBorder(null);
		txtSecurityQuestion.setForeground(SystemColor.textHighlight);
		txtSecurityQuestion.setFont(new Font("Segoe UI Black", txtSecurityQuestion.getFont().getStyle(), txtSecurityQuestion.getFont().getSize()));
		txtSecurityQuestion.setOpaque(false);
		txtSecurityQuestion.setText("Security question");
		txtSecurityQuestion.setBounds(286, 171, 119, 20);
		mainPanel.add(txtSecurityQuestion);
		txtSecurityQuestion.setColumns(10);
		
		txtAnswer = new JTextField();
		txtAnswer.setEditable(false);
		txtAnswer.setBorder(null);
		txtAnswer.setFont(new Font("Segoe UI Black", txtAnswer.getFont().getStyle(), txtAnswer.getFont().getSize()));
		txtAnswer.setForeground(SystemColor.textHighlight);
		txtAnswer.setText("Answer");
		txtAnswer.setOpaque(false);
		txtAnswer.setBounds(286, 235, 73, 20);
		mainPanel.add(txtAnswer);
		txtAnswer.setColumns(10);
		
		
	}
	public boolean verifyUsername(String uname)
	{
			String query = "SELECT * FROM `user` WHERE `uname`=?";
			
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, uname);
				
				rs = ps.executeQuery();
				if(rs.next())
				{
					userField.setText("");	 //exsita in baza de date return FALSE
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
	
	public void backgorundSignUp()
	{
		JLabel bkgLogin = new JLabel("bkgIconLogin");
		bkgLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), Color.BLACK, null));
		bkgLogin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		bkgLogin.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\login-whisp.png"));
		bkgLogin.setBounds(23, 58, 537, 341);
		mainPanel.add(bkgLogin);	
	
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
