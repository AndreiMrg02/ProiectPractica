package GUI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.MatteBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Insets;

import javax.swing.border.SoftBevelBorder;

import connection.MyConnection;

import java.sql.*;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField usernField;
	private JPanel mainPanel = new JPanel();
	private JPasswordField passField;
	
	private int mouseX, mouseY;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conn = MyConnection.getInstance().getConnection();
	    textPane();
		backgroundLogin();

	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		//frame.getContentPane().setLayout(null);
		
	    
	
		mainPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 799, 750, 1);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		usernField = new JTextField();
		usernField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		usernField.setMargin(new Insets(3, 5, 1, 2));
		usernField.setOpaque(false);
		usernField.setBackground(new Color(204, 204, 204));
		usernField.setForeground(new Color(0, 0, 0));
		usernField.setBounds(186, 151, 161, 31);
		mainPanel.add(usernField);
		usernField.setColumns(10);
		
		
		passField = new JPasswordField();
		passField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		passField.setOpaque(false);
		passField.setBounds(186, 217, 161, 31);
		mainPanel.add(passField);
		
		JPanel headerMainPanel = new JPanel();

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
		
		headerMainPanel.setBackground(SystemColor.activeCaption);
		headerMainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerMainPanel.setBounds(23, 11, 506, 46);
		mainPanel.add(headerMainPanel);
		headerMainPanel.setLayout(null);
		
		JLabel x_Bttn = new JLabel("");
		x_Bttn.setBounds(470, 0, 36, 54);
		headerMainPanel.add(x_Bttn);
		x_Bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		x_Bttn.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\x-icon-png-17.png"));
		x_Bttn.setVisible(true);
		
		JTextPane txtForgot = new JTextPane();
		txtForgot.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtForgot.setOpaque(false);
		txtForgot.setText("forgot");
		txtForgot.setBounds(220, 259, 37, 20);
		mainPanel.add(txtForgot);
		
		
		JLabel lblPassUser = new JLabel("Password ?");
		lblPassUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotMenu forgot  = new ForgotMenu();
				frame.dispose();
			}
		});
		lblPassUser.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblPassUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPassUser.setForeground(SystemColor.textHighlight);
		lblPassUser.setBounds(254, 259, 172, 20);
		mainPanel.add(lblPassUser);
		
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				@SuppressWarnings("unused")
				SignUp sign =  new SignUp();
			}
		});
		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSignUp.setForeground(SystemColor.textHighlight);
		lblSignUp.setBounds(220, 357, 77, 20);
		mainPanel.add(lblSignUp);
		
		JButton loginBttn = new JButton("LOGIN");
		loginBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String uname =  usernField.getText();
				 String pass =  String.valueOf(passField.getPassword());
				 loginConnection( uname,  pass);
			
			}
		});
		loginBttn.setFont(new Font("Cooper Black", Font.PLAIN, 11));
		loginBttn.setBackground(SystemColor.controlShadow);
		loginBttn.setForeground(new Color(0, 0, 255));
		loginBttn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginBttn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		loginBttn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		loginBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginBttn.setBounds(178, 290, 196, 37);
		mainPanel.add(loginBttn);
		
		
		
		
	}
	public void textPane()
	{
		JTextPane txtUsername_1 = new JTextPane();
		txtUsername_1.setForeground(SystemColor.textHighlight);
		txtUsername_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		txtUsername_1.setEditable(false);
		txtUsername_1.setOpaque(false);
		txtUsername_1.setText("Username");
		txtUsername_1.setBounds(186, 123, 83, 31);
		mainPanel.add(txtUsername_1);
		
		JTextPane passwordTxt = new JTextPane();
		passwordTxt.setOpaque(false);
		passwordTxt.setForeground(SystemColor.textHighlight);
		passwordTxt.setText("Password");
		passwordTxt.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		passwordTxt.setEditable(false);
		passwordTxt.setBounds(186, 188, 83, 31);
		mainPanel.add(passwordTxt);
		
		JTextPane txtDontHaveAccount = new JTextPane();
		txtDontHaveAccount.setText("Don't have an account? ");
		txtDontHaveAccount.setOpaque(false);
		txtDontHaveAccount.setBounds(188, 338, 196, 20);
		mainPanel.add(txtDontHaveAccount);
		
		
	}

	public void backgroundLogin()
	{
		JLabel bkgLogin = new JLabel("bkgIconLogin");
		bkgLogin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		bkgLogin.setIcon(new ImageIcon("E:\\FACULTATE\\ProiectPractica\\icon\\login-whisp.png"));
		bkgLogin.setBounds(23, 48, 537, 342);
		mainPanel.add(bkgLogin);			
	}
	
	public void loginConnection(String uname, String pass)
	{
		
		if(uname.equalsIgnoreCase("")) { 
			JOptionPane.showMessageDialog(null, "Username filed is empty");
		} else if(pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Password filed is empty");
		} else
		{
			String query = "SELECT * FROM `user` WHERE `uname`=? AND `pass`=?";
			
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
					
					MainMenu menu =  new MainMenu();
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

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

    
 }

