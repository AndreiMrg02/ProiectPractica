package GUI;


import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import connection.MyConnection;
import resources.ButtonGradient;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ForgotMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel mainPanel = new JPanel();
	
	private int mouseX, mouseY;
	private JTextField userField;
	private JTextField nameField;
	private JTextField securityField;
	private JTextField ansField;
	private JTextField passField;
	private JTextField txtUserId;
	private JTextField txtName;
	private JTextField txtSecurityQuestion;
	private JTextField txtAnswer;
	private JTextField txtPassword;
	private ButtonGradient bttnBack;
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public ForgotMenu() {
		
		initializare();
		conn =  MyConnection.getInstance().getConnection();
		mainPanel.setFocusable(true);
		
		
	}
	private void initializare()
	{
		frame =  new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		double x = 25;
		double y = 25;
		frame.setShape(new RoundRectangle2D.Double(x, y, 500, 360, x, y));
	    frame.setSize(600, 460);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		
	
		mainPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 799, 750, 1);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		
		JPanel headerMainPanel = new JPanel();
		headerMainPanel.setBackground(new Color(169, 169, 169));
		headerMainPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		headerMainPanel.setBounds(23, 11, 503, 48);
		mainPanel.add(headerMainPanel);
		headerMainPanel.setLayout(null);
		
		headerMainPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		headerMainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
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
		userField = new JTextField();
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					try {
					String sql = "SELECT * FROM `user` WHERE `uname` =?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, userField.getText());
					
					
					rs = ps.executeQuery();
					if(rs.next())
					{
						 nameField.setText(rs.getString("fname"));
						 securityField.setText(rs.getString("question"));
						 
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username not found in database");
					}
					
					} catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
				}
				
			}
		});
		userField.setText("         Enter username to search");
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(userField.getText().trim().equals("Enter username to search"))
				{
					userField.setText("");
				}
				userField.setForeground(Color.black);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userField.getText().trim().equals(""))
				{
					userField.setText("         Enter username to search");
					nameField.setText("");
					securityField.setText("");
					ansField.setText("");
					passField.setText("");
				}
				userField.setForeground(new Color(153,153,153));
			}
		});
		userField.setOpaque(false);
		userField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		userField.setBounds(185, 83, 187, 28);
		mainPanel.add(userField);
		userField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setOpaque(false);
		nameField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		nameField.setColumns(10);
		nameField.setBounds(185, 131, 187, 28);
		mainPanel.add(nameField);
		
		securityField = new JTextField();
		securityField.setEditable(false);
		securityField.setOpaque(false);
		securityField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		securityField.setColumns(10);
		securityField.setBounds(185, 192, 187, 28);
		mainPanel.add(securityField);
		
		ansField = new JTextField();
		ansField.setOpaque(false);
		ansField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ansField.setColumns(10);
		ansField.setBounds(185, 248, 187, 28);
		mainPanel.add(ansField);
		
		passField = new JTextField();
		passField.setEditable(false);
		passField.setOpaque(false);
		passField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		passField.setColumns(10);
		passField.setBounds(185, 303, 187, 28);
		mainPanel.add(passField);
		
		
		txtUserId = new JTextField();
		txtUserId.setFont(new Font("Segoe UI Black", txtUserId.getFont().getStyle(), txtUserId.getFont().getSize()));
		txtUserId.setForeground(SystemColor.textHighlight);
		txtUserId.setEditable(false);
		txtUserId.setBorder(null);
		txtUserId.setOpaque(false);
		txtUserId.setText("User ID");
		txtUserId.setBounds(185, 63, 86, 20);
		mainPanel.add(txtUserId);
		txtUserId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		txtName.setForeground(Color.RED);
		txtName.setEditable(false);
		txtName.setBorder(null);
		txtName.setOpaque(false);
		txtName.setText("Name");
		txtName.setColumns(10);
		txtName.setBounds(185, 113, 86, 20);
		mainPanel.add(txtName);
		
		txtSecurityQuestion = new JTextField();
		txtSecurityQuestion.setFont(new Font("Segoe UI Black", txtSecurityQuestion.getFont().getStyle(), txtSecurityQuestion.getFont().getSize()));
		txtSecurityQuestion.setForeground(Color.RED);
		txtSecurityQuestion.setDisabledTextColor(Color.WHITE);
		txtSecurityQuestion.setEditable(false);
		txtSecurityQuestion.setBorder(null);
		txtSecurityQuestion.setOpaque(false);
		txtSecurityQuestion.setText("Security Question");
		txtSecurityQuestion.setColumns(10);
		txtSecurityQuestion.setBounds(185, 170, 130, 20);
		mainPanel.add(txtSecurityQuestion);
		
		txtAnswer = new JTextField();
		txtAnswer.setFont(new Font("Segoe UI Black", txtAnswer.getFont().getStyle(), txtAnswer.getFont().getSize()));
		txtAnswer.setForeground(SystemColor.textHighlight);
		txtAnswer.setEditable(false);
		txtAnswer.setBorder(null);
		txtAnswer.setOpaque(false);
		txtAnswer.setText("Answer:");
		txtAnswer.setColumns(10);
		txtAnswer.setBounds(185, 231, 86, 20);
		mainPanel.add(txtAnswer);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Segoe UI Black", txtPassword.getFont().getStyle(), txtPassword.getFont().getSize()));
		txtPassword.setForeground(Color.RED);
		txtPassword.setEditable(false);
		txtPassword.setBorder(null);
		txtPassword.setOpaque(false);
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(185, 287, 86, 20);
		mainPanel.add(txtPassword);
		
		ButtonGradient bttnRecovery = new ButtonGradient();
		bttnRecovery.setColor2(new Color(128, 128, 128));
		bttnRecovery.setColor1(new Color(112, 128, 144));
		bttnRecovery.setText("Recovery");
		bttnRecovery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ans = ansField.getText();
				if(ans.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill the answer to retrive Password");
					
				}
				else
					
				{
					try {
					String sq = "SELECT * FROM `user` WHERE `ans`='"+ans+"'";
					ps = conn.prepareStatement(sq);
					rs = ps.executeQuery();
					if(rs.next())
					{
						String answer = rs.getString(2);
						passField.setText("Your Password is " + answer);
					} else
					{
						JOptionPane.showMessageDialog(null, "Incorrect data!");
						passField.setText("");
						
					}
				 }catch(SQLException ex)
					{
					 JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		bttnRecovery.setBackground(Color.WHITE);
		bttnRecovery.setForeground(new Color(0, 0, 0));
		bttnRecovery.setBorder(null);
		bttnRecovery.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bttnRecovery.setBounds(103, 342, 130, 34);
		mainPanel.add(bttnRecovery);
		
		bttnBack = new ButtonGradient();
		bttnBack.setColor2(new Color(128, 128, 128));
		bttnBack.setColor1(new Color(112, 128, 144));
		bttnBack.setText("BACK");
		bttnBack.setBackground(Color.WHITE);
		bttnBack.setForeground(new Color(0, 0, 0));
		bttnBack.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginMenu login =  new LoginMenu();
				frame.dispose();
			}
		});
		bttnBack.setBorder(null);
		bttnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bttnBack.setBounds(307, 342, 130, 34);
		mainPanel.add(bttnBack);
		
		backgorundSignUp();
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
}
