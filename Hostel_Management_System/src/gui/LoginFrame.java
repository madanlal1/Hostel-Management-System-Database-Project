package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dbconnection.DBConnection;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginFrame extends JFrame {
	
	
	//223, 225, 225 Light White
	//25, 94, 176 BLUE

		Connection con = DBConnection.getConnection();
		private JPanel contentPane;
		private JTextField txtUsername;
		private JPasswordField txtPassword;
		private JLabel lblCredentials;
		private JLabel lblStatus;
		private JComboBox comboBox;
		private JLabel lblShowpass;
		private int count=0;

		
		public static String USER_LOGIN =""; 
		public static String USER_TYPE = "";
		public static String UNIQUE_ID = "";
		private JTextField txtId;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginFrame frame = new LoginFrame();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						frame.setResizable(false);
						frame.setTitle("Login");
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public LoginFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 740, 622);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(25, 94, 176));
			panel.setForeground(Color.WHITE);
			panel.setBorder(null);
			panel.setBounds(0, 0, 349, 583);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Your Hostel");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(223, 225, 225));
			lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 21));
			lblNewLabel.setBounds(30, 461, 268, 40);
			panel.add(lblNewLabel);
			
			JLabel lblSystem = new JLabel("Our Responsibility");
			lblSystem.setForeground(new Color(223, 225, 225));
			lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
			lblSystem.setFont(new Font("Segoe Script", Font.BOLD, 21));
			lblSystem.setBounds(30, 501, 268, 40);
			panel.add(lblSystem);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/student1.png")));
			lblNewLabel_1.setBounds(126, 215, 80, 80);
			panel.add(lblNewLabel_1);
			
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/hostel.png")));
			label.setBounds(190, 306, 60, 67);
			panel.add(label);
			
			
			JLabel label_1 = new JLabel();
			label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/hostelbed.png")));
			label_1.setBounds(78, 306, 69, 67);
			panel.add(label_1);
			
			lblStatus = new JLabel("");
			lblStatus.setForeground(Color.WHITE);
			lblStatus.setFont(new Font("Segoe UI Emoji", Font.BOLD | Font.ITALIC, 13));
			lblStatus.setBounds(10, 552, 159, 20);
			panel.add(lblStatus);
			
			JLabel lblHealthCareSystem = new JLabel("Hostel Mangement");
			lblHealthCareSystem.setHorizontalAlignment(SwingConstants.CENTER);
			lblHealthCareSystem.setForeground(new Color(223, 225, 225));
			lblHealthCareSystem.setFont(new Font("Segoe Script", Font.BOLD, 29));
			lblHealthCareSystem.setBounds(30, 48, 309, 40);
			panel.add(lblHealthCareSystem);
			
			JLabel lblSystem_1 = new JLabel("System");
			lblSystem_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblSystem_1.setForeground(new Color(223, 225, 225));
			lblSystem_1.setFont(new Font("Segoe Script", Font.BOLD, 29));
			lblSystem_1.setBounds(40, 84, 278, 40);
			panel.add(lblSystem_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.WHITE);
			panel_1.setBorder(null);
			panel_1.setBackground(new Color(223, 225, 225));
			panel_1.setBounds(347, 0, 377, 583);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			
			
			lblShowpass = new JLabel("");
			lblShowpass.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent event) {
					lblShowpass.setForeground(new Color(247,131,63));
					lblShowpass.setBorder(new LineBorder(new Color(247,131,63)));
					
					if(count%2==0) {
					     txtPassword.setEchoChar((char)0); //password = JPasswordField
					}else {
						txtPassword.setEchoChar('*');
					}
					count++;
				}
				@Override
				public void mouseReleased(MouseEvent event) {
					lblShowpass.setForeground(new Color( 25, 94, 176));
					lblShowpass.setBorder(new LineBorder(new Color(25, 94, 176)));
				}
			});
			
			lblShowpass.addMouseListener(new MouseAdapter() {
				
			});
			lblShowpass.setBounds(325, 392, 30, 20);
			panel_1.add(lblShowpass);
			lblShowpass.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/show.png")));
			
			JLabel lblLogin = new JLabel("Sign in");
			lblLogin.setFont(new Font("Segoe Print", Font.BOLD, 26));
			lblLogin.setForeground(new Color(25, 94, 176));
			lblLogin.setBounds(35, 44, 159, 37);
			panel_1.add(lblLogin);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setForeground(new Color(25, 94, 176));
			lblUsername.setFont(new Font("Segoe Script", Font.BOLD, 20));
			lblUsername.setBounds(35, 252, 106, 20);
			panel_1.add(lblUsername);
			
			txtUsername = new JTextField();
			txtUsername.setForeground(Color.DARK_GRAY);
			txtUsername.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent evt) {
					if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
						login();
					}
					
				}
			});
			txtUsername.setOpaque(false);
			txtUsername.setBorder(null);
			txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtUsername.setBounds(35, 301, 320, 20);
			panel_1.add(txtUsername);
			txtUsername.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setBackground(new Color(25, 94, 176));
			separator.setBounds(35, 328, 320, 2);
			panel_1.add(separator);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(25, 94, 176));
			lblPassword.setFont(new Font("Segoe Script", Font.BOLD, 20));
			lblPassword.setBounds(35, 352, 106, 20);
			panel_1.add(lblPassword);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(35, 423, 320, 2);
			separator_1.setBackground(new Color(25, 94, 176));
			panel_1.add(separator_1);
			
			txtPassword = new JPasswordField();
			txtPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent evt) {
					if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
						login();
					}
				}
			});
			txtPassword.setForeground(Color.DARK_GRAY);
			txtPassword.setOpaque(false);
			txtPassword.setBorder(null);
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtPassword.setBounds(35, 392, 320, 20);
			panel_1.add(txtPassword);
			
			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Segoe Script", Font.PLAIN, 14));
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					mouseClickedEffect(btnLogin);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					mouseReleasedEffect(btnLogin);
				}
			});
			btnLogin.setForeground(new Color(25, 94, 176));
			// For Transpareting the Button
			btnLogin.setOpaque(false);
			btnLogin.setContentAreaFilled(false);
			btnLogin.setBorder(new LineBorder(new Color(25, 94, 176)));

			btnLogin.setBounds(35, 519, 106, 28);
			panel_1.add(btnLogin);
			
			lblCredentials = new JLabel("");
			lblCredentials.setForeground(new Color(255,124,124));
			lblCredentials.setFont(new Font("Segoe UI Emoji", Font.BOLD | Font.ITALIC, 13));
			lblCredentials.setBounds(177, 527, 159, 20);
			panel_1.add(lblCredentials);
			
			JLabel lblUsertype = new JLabel("UserType");
			lblUsertype.setForeground(new Color(25, 94, 176));
			lblUsertype.setFont(new Font("Segoe Script", Font.BOLD, 20));
			lblUsertype.setBounds(35, 463, 106, 20);
			panel_1.add(lblUsertype);
			
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Segoe Script", Font.BOLD, 18));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
			comboBox.setBounds(159, 465, 196, 20);
			panel_1.add(comboBox);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBackground(new Color(25, 94, 176));
			separator_2.setBounds(35, 228, 320, 2);
			panel_1.add(separator_2);
			
			txtId = new JTextField();
			txtId.setOpaque(false);
			txtId.setForeground(Color.DARK_GRAY);
			txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtId.setColumns(10);
			txtId.setBorder(null);
			txtId.setBounds(35, 201, 320, 20);
			panel_1.add(txtId);
			
			JLabel lblStudentId = new JLabel("ID");
			lblStudentId.setForeground(new Color(25, 94, 176));
			lblStudentId.setFont(new Font("Segoe Script", Font.BOLD, 20));
			lblStudentId.setBounds(35, 152, 136, 20);
			panel_1.add(lblStudentId);
			
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					login();
				}
			});
			if(con != null) {
				lblStatus.setText("Connected");
			}else {
				lblStatus.setText("Not Connected");
			}
			
			//setUndecorated(true);
		}
		
		// Click Effect
		public void mouseClickedEffect(JButton button) {
			button.setForeground(new Color(247,131,63));
			button.setBorder(new LineBorder(new Color(247,131,63)));
		}
		public void mouseReleasedEffect(JButton button) {
			button.setForeground(new Color( 25, 94, 176));
			button.setBorder(new LineBorder(new Color(25, 94, 176)));
		}
		
		public void login() {
			if(!(txtUsername.getText().toString().isEmpty() || 
					txtPassword.getText().toString().isEmpty() || txtId.getText().toString().isEmpty())){
				
				String username = txtUsername.getText().toString().trim();
				String password = txtPassword.getText().toString().trim();
				String usertype = comboBox.getSelectedItem().toString();
				String id = txtId.getText().toString();
				
				boolean check =  letLoginin(username, password, usertype , id);
				
				if(check == true) {
					USER_LOGIN = username;
					USER_TYPE = usertype;
					UNIQUE_ID = id;
					
					JOptionPane.showMessageDialog(LoginFrame.this, "Login Successful","Login Screen",
							JOptionPane.INFORMATION_MESSAGE);
					MainFrame mainFrame = new MainFrame(); 
					LoginFrame loginFrame = new LoginFrame(); 
					mainFrame.setTitle("Dashboard");
					loginFrame.setVisible(false);
					mainFrame.setVisible(true);
					dispose();
					
				}else {
					lblCredentials.setText("Invalid Credentials");
				}
				
			}else {
				lblCredentials.setText("Please Fill the Fields");
			}
		}
		
		public boolean letLoginin(String username , String password , String usertype , String id) {
			PreparedStatement ps = null;
			String sql = "Select * from login where username=? and password=? and usertype=? and st_id=?";
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, usertype);
				ps.setString(4, id);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
