package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dbconnection.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {
	
	// Color Coding
	//223, 225, 225 Light White
	//25, 94, 176 BLUE

	Connection con = DBConnection.getConnection();
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JTextField txtFName;
	private JTextField txtEmail;
	private JTextField txtMobile;
	private JTextField txtCity;
	private JTextField txtPayment;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JComboBox cmboHostel;
	private JButton btnDelete;
	
	private JComboBox cmboRoom;
	private JLabel lblYourPayment;
	
	String hostelId = "";
	private JTextField txtID;
	private JTextField txtSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 259, 692);
		panel.setBackground(new Color(25, 94, 176));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 217, 30);
		lblNewLabel.setForeground(new Color(223, 225, 225));
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("");
		lblUser.setForeground(new Color(223, 225, 225));
		lblUser.setFont(new Font("Segoe Script", Font.BOLD, 23));
		lblUser.setBounds(91, 93, 158, 30);
		panel.add(lblUser);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setForeground(new Color(223, 225, 225));
		lblImage.setFont(new Font("Segoe Script", Font.BOLD, 16));
		lblImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/admin1.png")));
		lblImage.setBounds(10, 66, 71, 75);
		panel.add(lblImage);
		
		JLabel lblKeepNeatAnd = new JLabel("Keep Your Hostel");
		lblKeepNeatAnd.setForeground(new Color(223, 225, 225));
		lblKeepNeatAnd.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblKeepNeatAnd.setBounds(34, 259, 193, 44);
		panel.add(lblKeepNeatAnd);
		
		JLabel lblNeatAndClean = new JLabel("Neat And Clean");
		lblNeatAndClean.setForeground(new Color(223, 225, 225));
		lblNeatAndClean.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNeatAndClean.setBounds(34, 306, 193, 44);
		panel.add(lblNeatAndClean);
		
		JLabel lblAsYouKepp = new JLabel("As you Keep yourself");
		lblAsYouKepp.setForeground(new Color(223, 225, 225));
		lblAsYouKepp.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblAsYouKepp.setBounds(10, 349, 239, 44);
		panel.add(lblAsYouKepp);
		
		JLabel lblPayment = new JLabel("Hostel is a Second");
		lblPayment.setForeground(new Color(223, 225, 225));
		lblPayment.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblPayment.setBounds(34, 557, 193, 44);
		panel.add(lblPayment);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(new Color(223, 225, 225));
		lblHome.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblHome.setBounds(34, 600, 193, 44);
		panel.add(lblHome);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(LoginFrame.USER_TYPE.equalsIgnoreCase("admin")) {
					btnAdd.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
					clear();
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(223, 225, 225));
		panel_1.setBounds(256, 0, 1114, 692);
		contentPane.add(panel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(25, 94, 176));
		separator.setBounds(752, 191, 244, 2);
		panel_1.add(separator);
		
		JLabel label = new JLabel("Dashboard");
		label.setForeground(new Color(223, 225, 225));
		label.setFont(new Font("Segoe Script", Font.BOLD, 22));
		label.setBounds(39, 34, 158, 30);
		panel_1.add(label);
		
		JLabel lblHostelDetails = new JLabel("Hostel Details");
		lblHostelDetails.setForeground(new Color(25, 94, 176));
		lblHostelDetails.setFont(new Font("Segoe Script", Font.BOLD, 22));
		lblHostelDetails.setBounds(318, 14, 201, 30);
		panel_1.add(lblHostelDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 154, 711, 407);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				table.setSelectionForeground(new Color(223, 225, 225));

				if(LoginFrame.USER_TYPE.equalsIgnoreCase("admin")) {
					btnAdd.setEnabled(false);
					btnDelete.setEnabled(true);
					btnUpdate.setEnabled(true);
	
					Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
	
					String sname = (String) table.getValueAt(table.getSelectedRow(), 1);
					String fname = (String) table.getValueAt(table.getSelectedRow(), 2);
					String email = (String) table.getValueAt(table.getSelectedRow(), 3);
					String mobile = (String) table.getValueAt(table.getSelectedRow(), 4);
					String city = (String) table.getValueAt(table.getSelectedRow(), 5);
	
					String room_no = (String) table.getValueAt(table.getSelectedRow(), 6);
					String hostel = (String) table.getValueAt(table.getSelectedRow(), 8);
					
					txtName.setText(sname);
					txtFName.setText(fname);
					txtEmail.setText(email);
					txtMobile.setText(mobile);
					txtCity.setText(city);
					
					cmboRoom.setSelectedItem(room_no);
					cmboHostel.setSelectedItem(hostel);
				}
				
				
			
				
			}
		});
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.getTableHeader().setForeground(new Color(25, 94, 176));
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(25, 94, 176));
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Validation here
				if(txtName.getText().toString().isEmpty() || 
						txtFName.getText().toString().isEmpty() ||
						txtEmail.getText().toString().isEmpty() ||
						txtMobile.getText().toString().isEmpty() ||
						txtCity.getText().toString().isEmpty() ||
						txtPayment.getText().toString().isEmpty() ||
						txtID.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(MainFrame.this, "Please Fill the Fields","Dashboard",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					String sname = txtName.getText().toString();
					String fname = txtFName.getText().toString();
					String email = txtEmail.getText().toString();
					String mobile = txtMobile.getText().toString();
					String city = txtCity.getText().toString();
					String payment = txtPayment.getText().toString();
					String id = txtID.getText().toString();
							
							
					boolean nameCheck =  Pattern.matches("[a-zA-Z[^0-9]]{1,30}",sname);
					boolean fnameCheck =  Pattern.matches("[a-zA-Z[^0-9]]{1,30}",fname);
					boolean emailCheck =  Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email);
					boolean contactCheck = Pattern.matches("[0-9]{11}",mobile );
					boolean cityCheck = Pattern.matches("[a-zA-Z[^0-9]]{1,30}",city );
					
					boolean numcheck = Pattern.matches("[0-9]{1,20}",payment);
					boolean checkID = Pattern.matches("[0-9]{1,20}",id);
					
					
					
					if(nameCheck == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "Name is Invalid","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(fnameCheck == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "Father's Name is Invalid","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(emailCheck == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "Email is Invalid","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(contactCheck == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "Mobile Number is Invalid","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(cityCheck == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "City Name is Invalid","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(checkID == false) {
						JOptionPane.showMessageDialog(MainFrame.this, "ID Must be a Numeric Digit","Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						String room_no = cmboRoom.getSelectedItem().toString();
						String room_id = getRoomIdByRoomNo(room_no);
						
						boolean checkRoom = checkRoomIsVacant(room_no);
						
						if(checkRoom) {
							int rowStatus = allotRoomToStudent(sname, fname, email, mobile, city, room_id);
							
							if(rowStatus == 1) {
								int row = addToLogin(sname , sname+"123");
								JOptionPane.showMessageDialog(MainFrame.this, "Room is Alloted Successfully","Message",
										JOptionPane.INFORMATION_MESSAGE);
								populateTable(LoginFrame.UNIQUE_ID);
								clear();
							}else {
								JOptionPane.showMessageDialog(MainFrame.this, "Room can not be Alloted","Message",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(MainFrame.this, room_no+" Room is Already Reserved/Alloted to somone","Message",
									JOptionPane.INFORMATION_MESSAGE);
						}
						
						
					
					}
					
					
				}
				
				
				
				
				
//				if()
//				allotRoomToStudent(String Sname, String Fname, String email , String mobile ,String city , String room_no );
			}
		});
		btnAdd.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseClickedEffect(btnAdd);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseReleasedEffect(btnAdd);
			}
		});
		btnAdd.setForeground(new Color(25, 94, 176));
		// For Transpareting the Button
		btnAdd.setOpaque(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(new LineBorder(new Color(25, 94, 176)));

		btnAdd.setBounds(20, 103, 106, 28);
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				
				String sname = txtName.getText().toString();
				String fname = txtFName.getText().toString();
				String email = txtEmail.getText().toString();
				String mobile = txtMobile.getText().toString();
				String city = txtCity.getText().toString();
				String payment = txtPayment.getText().toString();
				
				String room_no = cmboRoom.getSelectedItem().toString();
				String room_id = getRoomIdByRoomNo(room_no);
				
				String UID = txtID.getText().toString();
				
				
				
				int row = updateStudent(sname, fname, email, mobile, city, room_id, id , UID);
				
				if(row==1) {
					JOptionPane.showMessageDialog(MainFrame.this, "Student Updated Successfully", "Message", JOptionPane.DEFAULT_OPTION);
					clear();
				}else {
					JOptionPane.showMessageDialog(MainFrame.this, "Student Not Updated", "Message", JOptionPane.ERROR_MESSAGE);
				}
	
				populateTable(LoginFrame.UNIQUE_ID);
			}
			
		});
		
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseClickedEffect(btnUpdate);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseReleasedEffect(btnUpdate);
			}
		});
		
		btnUpdate.setOpaque(false);
		btnUpdate.setForeground(new Color(25, 94, 176));
		btnUpdate.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(new LineBorder(new Color(25, 94, 176)));
		btnUpdate.setBounds(150, 103, 106, 28);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				
				int row = deleteStudent(id);
				
				if(row ==1) {
					JOptionPane.showMessageDialog(MainFrame.this, "Student Deleted Successful", "Message", JOptionPane.DEFAULT_OPTION);
					clear();
				}
				else {
					JOptionPane.showMessageDialog(MainFrame.this, "Student Not Deleted", "Message", JOptionPane.ERROR_MESSAGE);
				}
			
				populateTable(LoginFrame.UNIQUE_ID);
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseClickedEffect(btnDelete);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseReleasedEffect(btnDelete);
			}
		});
		
		btnDelete.setOpaque(false);
		btnDelete.setForeground(new Color(25, 94, 176));
		btnDelete.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorder(new LineBorder(new Color(25, 94, 176)));
		btnDelete.setBounds(286, 103, 106, 28);
		panel_1.add(btnDelete);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame(); 
				LoginFrame loginFrame = new LoginFrame(); 
				mainFrame.setTitle("Login");
				loginFrame.setVisible(true);
				mainFrame.setVisible(false);
				dispose();
			}
		});
		
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseClickedEffect(btnLogOut);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseReleasedEffect(btnLogOut);
			}
		});
		
		btnLogOut.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/logout.png")));
		btnLogOut.setOpaque(false);
		btnLogOut.setForeground(new Color(25, 94, 176));
		btnLogOut.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorder(new LineBorder(new Color(25, 94, 176)));
		btnLogOut.setBounds(890, 11, 106, 40);
		panel_1.add(btnLogOut);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setForeground(Color.DARK_GRAY);
		txtName.setOpaque(false);
		txtName.setBorder(null);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(752, 165, 244, 28);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(25, 94, 176));
		lblName.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblName.setBounds(751, 128, 64, 30);
		panel_1.add(lblName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(25, 94, 176));
		separator_1.setBounds(752, 267, 244, 2);
		panel_1.add(separator_1);
		
		txtFName = new JTextField();
		txtFName.setOpaque(false);
		txtFName.setForeground(Color.DARK_GRAY);
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFName.setColumns(10);
		txtFName.setBorder(null);
		txtFName.setBounds(752, 241, 244, 28);
		panel_1.add(txtFName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(25, 94, 176));
		lblFathersName.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblFathersName.setBounds(751, 204, 150, 30);
		panel_1.add(lblFathersName);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(25, 94, 176));
		separator_2.setBounds(753, 343, 244, 2);
		panel_1.add(separator_2);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(753, 317, 244, 28);
		panel_1.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(25, 94, 176));
		lblEmail.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblEmail.setBounds(752, 280, 64, 30);
		panel_1.add(lblEmail);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(25, 94, 176));
		separator_3.setBounds(752, 419, 244, 2);
		panel_1.add(separator_3);
		
		txtMobile = new JTextField();
		txtMobile.setOpaque(false);
		txtMobile.setForeground(Color.DARK_GRAY);
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMobile.setColumns(10);
		txtMobile.setBorder(null);
		txtMobile.setBounds(752, 393, 244, 28);
		panel_1.add(txtMobile);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(new Color(25, 94, 176));
		lblMobile.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblMobile.setBounds(751, 356, 64, 30);
		panel_1.add(lblMobile);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(new Color(25, 94, 176));
		separator_4.setBounds(752, 495, 244, 2);
		panel_1.add(separator_4);
		
		txtCity = new JTextField();
		txtCity.setOpaque(false);
		txtCity.setForeground(Color.DARK_GRAY);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCity.setColumns(10);
		txtCity.setBorder(null);
		txtCity.setBounds(752, 469, 244, 28);
		panel_1.add(txtCity);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(25, 94, 176));
		lblCity.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblCity.setBounds(751, 432, 64, 30);
		panel_1.add(lblCity);
		
		JLabel lblHostel = new JLabel("Hostel");
		lblHostel.setForeground(new Color(25, 94, 176));
		lblHostel.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblHostel.setBounds(751, 506, 64, 30);
		panel_1.add(lblHostel);
		
		cmboHostel = new JComboBox();
		cmboHostel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cmboRoom.removeAllItems();
				
				if(cmboHostel.getSelectedItem().toString().equalsIgnoreCase("Jatio")) {
					hostelId="1";
				}else {
					hostelId="2";
				}
				
				populateRooms(hostelId);
			}
		});
		
		cmboHostel.setBounds(825, 511, 171, 20);
		panel_1.add(cmboHostel);
		
		
		cmboRoom = new JComboBox();
		cmboRoom.setBounds(825, 553, 171, 20);
		panel_1.add(cmboRoom);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setForeground(new Color(25, 94, 176));
		lblRoom.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblRoom.setBounds(751, 548, 64, 30);
		panel_1.add(lblRoom);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(new Color(25, 94, 176));
		separator_5.setBounds(753, 646, 244, 2);
		panel_1.add(separator_5);
		
		txtPayment = new JTextField();
		txtPayment.setOpaque(false);
		txtPayment.setForeground(Color.DARK_GRAY);
		txtPayment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPayment.setColumns(10);
		txtPayment.setBorder(null);
		txtPayment.setBounds(753, 620, 244, 28);
		panel_1.add(txtPayment);
		
		JLabel LabelPayment = new JLabel("Payment");
		LabelPayment.setForeground(new Color(25, 94, 176));
		LabelPayment.setFont(new Font("Segoe Script", Font.BOLD, 14));
		LabelPayment.setBounds(752, 583, 96, 30);
		panel_1.add(LabelPayment);
		
		lblYourPayment = new JLabel("Your Payment is Done");
		lblYourPayment.setForeground(new Color(25, 94, 176));
		lblYourPayment.setFont(new Font("Segoe Script", Font.BOLD, 22));
		lblYourPayment.setBounds(20, 618, 324, 30);
		panel_1.add(lblYourPayment);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(new Color(25, 94, 176));
		separator_6.setBounds(752, 125, 244, 2);
		panel_1.add(separator_6);
		
		txtID = new JTextField();
		txtID.setOpaque(false);
		txtID.setForeground(Color.DARK_GRAY);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setColumns(10);
		txtID.setBorder(null);
		txtID.setBounds(752, 99, 244, 28);
		panel_1.add(txtID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(25, 94, 176));
		lblId.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblId.setBounds(751, 62, 64, 30);
		panel_1.add(lblId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(new Color(25, 94, 176));
		separator_7.setBounds(456, 129, 214, 2);
		panel_1.add(separator_7);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setOpaque(false);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DefaultTableModel myTable = (DefaultTableModel) table.getModel();
				String search = txtSearch.getText().toString();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(myTable);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		txtSearch.setForeground(Color.DARK_GRAY);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSearch.setColumns(10);
		txtSearch.setBorder(null);
		txtSearch.setBounds(456, 103, 214, 28);
		panel_1.add(txtSearch);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(25, 94, 176));
		label_1.setFont(new Font("Segoe Script", Font.BOLD, 14));
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/search.png")));
		label_1.setBounds(428, 103, 33, 30);
		panel_1.add(label_1);
		
		if(LoginFrame.USER_TYPE.equalsIgnoreCase("admin")) {
			lblUser.setText(LoginFrame.USER_TYPE);	
			lblImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/admin1.png")));
			lblYourPayment.setText("You are Admin");
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}else {
			lblUser.setText(LoginFrame.USER_LOGIN);	
			lblImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/imgs/user.png")));
			btnAdd.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
			
			
			txtName.setEnabled(false);
			txtFName.setEnabled(false);
			txtEmail.setEnabled(false);
			txtMobile.setEnabled(false);
			txtCity.setEnabled(false);
			txtPayment.setEnabled(false);
			
			cmboHostel.setEnabled(false);
			cmboRoom.setEnabled(false);
			
			txtSearch.setEnabled(false);
			txtID.setEnabled(false);
			String student_id = getStudentIdByName(LoginFrame.USER_LOGIN);
			
			// check the id exist in the payment table or not
			
			if(checkPaymentDone(student_id)) {
				lblYourPayment.setText("Your Payment is Done");
			}else {
				lblYourPayment.setText("Your Payment is not Paid");
			}
		}
		
		populateTable(LoginFrame.UNIQUE_ID);
		populateHostels();
		
		if(cmboHostel.getSelectedItem().toString().equalsIgnoreCase("Jatio")) {
			hostelId="1";
		}else {
			hostelId="2";
		}
		
		populateRooms(hostelId);
		
	}
	
	public void mouseClickedEffect(JButton button) {
		button.setForeground(new Color(247,131,63));
		button.setBorder(new LineBorder(new Color(247,131,63)));
	}
	
	public void mouseReleasedEffect(JButton button) {
		button.setForeground(new Color( 25, 94, 176));
		button.setBorder(new LineBorder(new Color(25, 94, 176)));
	}
	
	
	private void populateTable(String id) {
		
		ResultSet rs = getDataResultSet(id);

		table.setModel(buildTableModel(rs));
		table.getColumnModel().getColumn(0).setHeaderValue("ID");
		table.getColumnModel().getColumn(1).setHeaderValue("Studewnt Name");
		table.getColumnModel().getColumn(2).setHeaderValue("Father's Name");
		table.getColumnModel().getColumn(3).setHeaderValue("Email");
		table.getColumnModel().getColumn(4).setHeaderValue("Mobile");
		table.getColumnModel().getColumn(5).setHeaderValue("City");
		table.getColumnModel().getColumn(6).setHeaderValue("Room No");
		table.getColumnModel().getColumn(7).setHeaderValue("Room Capacity");
		table.getColumnModel().getColumn(8).setHeaderValue("Hostel");
		
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs) {
		Vector <String> colNames=null;
		Vector <Vector<Object>> data = null;
		try {
			ResultSetMetaData metadata = rs.getMetaData();
			colNames = new Vector<String>();
			int colcount = metadata.getColumnCount();
			
			for(int col=1;col<=colcount;col++) {
				colNames.add(metadata.getColumnName(col));
			}
			data = new Vector <Vector<Object>>();
			
			while(rs.next()) {
				Vector<Object>vector = new Vector();
				for(int colindex = 1; colindex<=colcount;colindex++) {
					vector.add( rs.getObject(colindex));
				}
				data.add(vector);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data,colNames);
	}
	
	public ResultSet getDataResultSet(String st_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "";
		try {
			if(st_id.equals("222")) {
				sql = "SELECT s.id , s.Sname , s.fname , s.email , s.mobile , s.city , r.room_no , r.capacity , h.hname \r\n" + 
						"FROM student s \r\n" + 
						"INNER JOIN rooms r ON r.id = s.room_id \r\n" + 
						"INNER JOIN hostel h ON h.id = r.hostel_id";
				ps = con.prepareStatement(sql);
			}else {
				sql = "SELECT s.id , s.Sname , s.fname , s.email , s.mobile , s.city , r.room_no , r.capacity , h.hname \r\n" + 
						"FROM student s \r\n" + 
						"INNER JOIN rooms r ON r.id = s.room_id \r\n" + 
						"INNER JOIN hostel h ON h.id = r.hostel_id where s.st_id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, st_id);
			}
			
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return rs;
	}
	
	public List<String> getAllHostels() {
		List<String> hostelList = new ArrayList<>(); 
		try {
			String sql="SELECT Hname from hostel;" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hostelList.add(rs.getString("hname"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hostelList;

	}
	
	public void clear() {
		txtName.setText("");
		txtFName.setText("");
		txtEmail.setText("");
		txtMobile.setText("");
		txtCity.setText("");
		txtPayment.setText("");
	}
	
	public void populateHostels() {
		List <String> names = getAllHostels();
		for(String n: names) {
			cmboHostel.addItem(n);
		}
	}
	
	public List<String> getAllRoomsByHostelId(String id) {
		List<String> hostelList = new ArrayList<>(); 
		try {
			String sql="SELECT room_no from rooms where hostel_id=?" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hostelList.add(rs.getString("room_no"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hostelList;

	}
	
	public void populateRooms(String id) {
		List <String> names = getAllRoomsByHostelId(id);
		for(String n: names) {
			cmboRoom.addItem(n);
		}
	}
	
	
	public Integer addToLogin(String username , String password) {
		String sql = "INSERT INTO login(username,password,usertype) values(?,?,?);";
		PreparedStatement ps = null;
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, "user");
			
			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public Integer allotRoomToStudent(String Sname, String Fname, String email , String mobile ,String city , String room_id ) {
		String sql = "INSERT INTO student(sname,fname,email,mobile,city,room_id) values(?,?,?,?,?,?);";
		PreparedStatement ps = null;
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Sname);
			ps.setString(2, Fname);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, city);
			ps.setString(6, room_id);
			
			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public String  getRoomIdByRoomNo(String room_no) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id from rooms where room_no=?";
		String id="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, room_no);
			rs =ps.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public String  getStudentIdByName(String sname) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id from student where sname=?";
		String id="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			rs =ps.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public boolean  checkPaymentDone(String student_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from payment where student_id=?";
		String id="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, student_id);
			rs =ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Integer deleteStudent(Integer id) {
		PreparedStatement ps = null;
		String sql ="delete from student where id=?";
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public Integer updateStudent(String sname, String fname, String email , String mobile ,String city , String room_id,Integer id , String uid) {
		PreparedStatement ps = null;
		String sql = "update student set sname=?,fname=?,email=?,mobile=?,city=? , room_id=? , st_id=? where id = ?";
		
		int row=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, fname);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, city);
			ps.setString(6, room_id);
			ps.setString(7, uid);
			ps.setInt(8, id);
			
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public boolean checkRoomIsVacant(String room_No) {
			for (int i = 1; i < table.getRowCount(); i++) {
				if(room_No.equals(table.getValueAt(i, 6).toString())){
					return false;
				}
			}
			return true;
		}
}

