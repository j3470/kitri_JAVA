package cds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Customer_App {
	private JFrame frame;
	private JTextField ID;
	private JPasswordField PW;
	private JTextField namevalue;
	private JTextField year;
	private JTextField month;
	private JTextField day;
	private JTextField adyear;
	private JTextField user;
	private JPasswordField password;
	private JTextField username;
	private JTextField phone;
	private JTextField email;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("C:/Users/KITRI/eclipse-workspace/CDS/image/login.png").getImage());
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		ImagePanel joinpanel = new ImagePanel(
				new ImageIcon("C:/Users/KITRI/eclipse-workspace/CDS/image/join.png").getImage());
		joinpanel.setLocation(0, 0);
		// welcomePanel.setBounds(0, 0, 1093, 659);

		frame.setSize(joinpanel.getWidth(), joinpanel.getHeight());
		frame.getContentPane().add(joinpanel);
		joinpanel.setLayout(null);
		
				user = new JTextField();
				user.setFont(new Font("굴림", Font.PLAIN, 20));
				user.setColumns(10);
				user.setBounds(664, 203, 357, 40);
				user.setBorder(new LineBorder(Color.white, 1));
				joinpanel.add(user);
				
						password = new JPasswordField();
						password.setBounds(666, 267, 355, 40);
						password.setBorder(new LineBorder(Color.white, 1));
						joinpanel.add(password);
						
								username = new JTextField();
								username.setFont(new Font("굴림", Font.PLAIN, 20));
								username.setColumns(10);
								username.setBorder(new LineBorder(Color.white, 1));
								username.setBounds(664, 332, 357, 40);
								joinpanel.add(username);
								
										JComboBox<?> usertype = new JComboBox<Object>(new String[] { "select", "instructor", "staff" });
										usertype.setBackground(Color.WHITE);
										usertype.setFont(new Font("굴림", Font.PLAIN, 20));
										// usertype.setModel(new DefaultComboBoxModel(new String[] { "select",
										// "student", "professor" }));
										// JComboBox<?> gradeselect = new JComboBox<Object>(new String[] { "select",
										// "1", "2", "3", "4" });
										usertype.setBounds(664, 392, 357, 47);
										usertype.setUI(new BasicComboBoxUI());
										
												joinpanel.add(usertype);
												
														phone = new JTextField();
														phone.setFont(new Font("굴림", Font.PLAIN, 20));
														phone.setColumns(10);
														phone.setBorder(new LineBorder(Color.white, 1));
														phone.setBounds(664, 460, 357, 40);
														joinpanel.add(phone);
														
																email = new JTextField();
																email.setFont(new Font("굴림", Font.PLAIN, 20));
																email.setColumns(10);
																email.setBorder(new LineBorder(Color.white, 1));
																email.setBounds(664, 524, 357, 40);
																joinpanel.add(email);
																
																		JButton signUp = new JButton("");
																		signUp.setContentAreaFilled(false);
																		signUp.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				// String nameTxt = user.getText();
																				// String passTxt = password.getText();
																				String userID = user.getText();
																				StringBuilder sbf = new StringBuilder("");
																				char[] passTxt = password.getPassword();
																				String userName = username.getText();
																				String userType = usertype.getSelectedItem().toString();
																				String userPhone = phone.getText();
																				String userEmail = email.getText();

																				sbf.append(passTxt);
																				if (userID.equals("") || sbf.toString().equals("") || userType.equals("select") || userName.equals("")
																						|| userEmail.equals("")) {
																					JOptionPane.showMessageDialog(null, "양식에 맞게 작성해주세요");
																				} else {
																					Boolean isCreate = User.createUser(userID, sbf.toString(), userType, userName, userEmail,
																							userPhone);
																					if (isCreate) {
																						JOptionPane.showMessageDialog(null, "가입완료!");
																						System.out.println("success");
																					} else {
																						System.out.println("fail");
																					}

																				}
																			}

																		});
																		signUp.setFont(new Font("굴림", Font.PLAIN, 20));
																		signUp.setBounds(1036, 610, 173, 88);
																		joinpanel.add(signUp);
																		
																				JButton backBtn = new JButton("");
																				backBtn.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						joinpanel.setVisible(false);
																						welcomePanel.setVisible(true);
																					}
																				});
																				backBtn.setIcon(new ImageIcon("C:\\Users\\KITRI\\eclipse-workspace\\CDS\\image\\backicon.PNG"));
																				backBtn.setBounds(93, 32, 77, 61);
																				backBtn.setBorder(new LineBorder(Color.white, 1));
																				joinpanel.add(backBtn);
		JPanel mainpanel = new JPanel();
		
				mainpanel.setBackground(Color.WHITE);
				mainpanel.setBounds(0, 0, 1093, 659);
				frame.getContentPane().add(mainpanel);
				mainpanel.setLayout(null);
				mainpanel.setVisible(false);
				JLabel lblNewLabel_2 = new JLabel("Welcome");
				lblNewLabel_2.setBounds(474, 22, 186, 64);
				lblNewLabel_2.setFont(new Font("Segoe Script", Font.PLAIN, 40));
				mainpanel.add(lblNewLabel_2);
				
						
				
						JLabel name_1 = new JLabel("name");
						name_1.setHorizontalAlignment(SwingConstants.CENTER);
						name_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
						name_1.setBounds(282, 115, 146, 34);
						mainpanel.add(name_1);
						
								namevalue = new JTextField();
								namevalue.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
								namevalue.setBounds(407, 115, 186, 36);
								mainpanel.add(namevalue);
								namevalue.setColumns(10);
								
										JLabel gender = new JLabel("gender");
										gender.setHorizontalAlignment(SwingConstants.CENTER);
										gender.setFont(new Font("Arial Black", Font.PLAIN, 15));
										gender.setBounds(282, 166, 146, 34);
										mainpanel.add(gender);
										
												year = new JTextField();
												year.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
												year.setColumns(10);
												year.setBounds(407, 210, 91, 36);
												mainpanel.add(year);
												
														JLabel birth = new JLabel("birth");
														birth.setHorizontalAlignment(SwingConstants.CENTER);
														birth.setFont(new Font("Arial Black", Font.PLAIN, 15));
														birth.setBounds(282, 210, 146, 34);
														mainpanel.add(birth);
														
																month = new JTextField();
																month.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
																month.setColumns(10);
																month.setBounds(543, 210, 91, 36);
																mainpanel.add(month);
																
																		day = new JTextField();
																		day.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
																		day.setColumns(10);
																		day.setBounds(693, 210, 91, 36);
																		mainpanel.add(day);
																		
																				JLabel lblNewLabel_3_2_1 = new JLabel("year");
																				lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
																				lblNewLabel_3_2_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
																				lblNewLabel_3_2_1.setBounds(447, 210, 146, 34);
																				mainpanel.add(lblNewLabel_3_2_1);
																				
																						JLabel lblNewLabel_3_2_2 = new JLabel("month");
																						lblNewLabel_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
																						lblNewLabel_3_2_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
																						lblNewLabel_3_2_2.setBounds(592, 210, 146, 34);
																						mainpanel.add(lblNewLabel_3_2_2);
																						
																								JLabel lblNewLabel_3_2_3 = new JLabel("day");
																								lblNewLabel_3_2_3.setHorizontalAlignment(SwingConstants.CENTER);
																								lblNewLabel_3_2_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
																								lblNewLabel_3_2_3.setBounds(727, 210, 146, 34);
																								mainpanel.add(lblNewLabel_3_2_3);
																								
																										JLabel grade = new JLabel("grade");
																										grade.setHorizontalAlignment(SwingConstants.CENTER);
																										grade.setFont(new Font("Arial Black", Font.PLAIN, 15));
																										grade.setBounds(282, 302, 146, 34);
																										mainpanel.add(grade);
																										
																												JComboBox<?> gradeselect = new JComboBox<Object>(new String[] { "select", "1", "2", "3", "4" });
																												gradeselect.setBounds(407, 302, 63, 34);
																												mainpanel.add(gradeselect);
																												
																														JLabel admission = new JLabel("admission");
																														admission.setHorizontalAlignment(SwingConstants.CENTER);
																														admission.setFont(new Font("Arial Black", Font.PLAIN, 15));
																														admission.setBounds(282, 256, 146, 34);
																														mainpanel.add(admission);
																														
																																adyear = new JTextField();
																																adyear.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
																																adyear.setColumns(10);
																																adyear.setBounds(407, 256, 186, 36);
																																mainpanel.add(adyear);
																																
																																		JLabel lblNewLabel_3_2_1_1 = new JLabel("year");
																																		lblNewLabel_3_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
																																		lblNewLabel_3_2_1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
																																		lblNewLabel_3_2_1_1.setBounds(553, 256, 146, 34);
																																		mainpanel.add(lblNewLabel_3_2_1_1);
																																		
																																				JComboBox<Object> genderselect = new JComboBox<Object>(new Object[] { "select", "male", "female" });
																																				genderselect.setBounds(407, 168, 91, 34);
																																				mainpanel.add(genderselect);
																																				
																																						JButton btnNewButton_1 = new JButton("submit");
																																						btnNewButton_1.addActionListener(new ActionListener() {
																																							public void actionPerformed(ActionEvent e) {
																																								String nameTxt = namevalue.getText();
																																								String yearTxt = year.getText();
																																								String monthTxt = month.getText();
																																								String dayTxt = day.getText();
																																								String adyearTxt = adyear.getText();
																																								String gradeTxt = gradeselect.getSelectedItem().toString();
																																								String genderTxt = genderselect.getSelectedItem().toString();

																																								Boolean isCreate = Customer.createCustomer(nameTxt, genderTxt, yearTxt, monthTxt, dayTxt, adyearTxt,
																																										gradeTxt);
																																								if (isCreate) {
																																									// 환영인사
																																									// 그 후 다음 페이지
																																									JOptionPane.showMessageDialog(null, "successful");
																																								} else {
																																									// 가입 실패
																																									JOptionPane.showMessageDialog(null, "failed");
																																								}
																																							}
																																						});
																																						btnNewButton_1.setBounds(516, 401, 151, 34);
																																						mainpanel.add(btnNewButton_1);
																																						
																																								JButton btnNewButton_1_1 = new JButton("photo registration");
																																								btnNewButton_1_1.addActionListener(new ActionListener() {
																																									public void actionPerformed(ActionEvent e) {
																																									}
																																								});
																																								btnNewButton_1_1.setBounds(80, 401, 151, 34);
																																								mainpanel.add(btnNewButton_1_1);
																																								
																																										JButton guestlist = new JButton("guest list");
																																										guestlist.addActionListener(new ActionListener() {
																																											public void actionPerformed(ActionEvent e) {
																																												new Guestlist();
																																											}
																																										});
																																										guestlist.setBounds(516, 498, 151, 34);
																																										mainpanel.add(guestlist);
																																										
																																												JButton btnNewButton_4 = new JButton("Log out");
																																												btnNewButton_4.addActionListener(new ActionListener() {
																																													public void actionPerformed(ActionEvent e) {
																																														mainpanel.setVisible(false);
																																														welcomePanel.setVisible(true);
																																														ID.setText(null);
																																														PW.setText(null);
																																													}
																																												});
																																												btnNewButton_4.setBounds(24, 22, 151, 34);
																																												mainpanel.add(btnNewButton_4);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);

		ID = new JTextField();
		ID.setBounds(567, 274, 283, 64);
		ID.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		ID.setToolTipText("");
		welcomePanel.add(ID);
		ID.setColumns(10);
		ID.setBorder(new LineBorder(Color.white, 1));

		PW = new JPasswordField();
		PW.setBounds(567, 370, 283, 64);
		PW.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		PW.setToolTipText("");
		welcomePanel.add(PW);
		PW.setBorder(new LineBorder(Color.white, 1));
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(704, 494, 136, 53);
		welcomePanel.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinpanel.setVisible(true);
				welcomePanel.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("MV Boli", Font.PLAIN, 20));
		btnNewButton_3.setBounds(510, 494, 136, 53);
		welcomePanel.add(btnNewButton_3);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = ID.getText();
				StringBuilder sbf = new StringBuilder("");
				char[] pass = PW.getPassword();
				sbf.append(pass); // char[] -> String

				if (User.CheckUser(name, sbf.toString())) {
					JOptionPane.showMessageDialog(null, "success");
					welcomePanel.setVisible(false);
					mainpanel.setVisible(true);
					joinpanel.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "fail");
				}

			}
		});
		frame.setJMenuBar(menuBar());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");

		bar.add(fileMenu);
		bar.add(aboutMenu);
		JMenuItem haha = new JMenuItem("haha");
		JMenuItem exit = new JMenuItem("exit");
		fileMenu.add(haha);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		{

		}
		return bar;
	}
}

class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
