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
		ImagePanel mainpanel = new ImagePanel(
				new ImageIcon("C:\\Users\\KITRI\\git\\repository\\CDS\\image\\03_main.png").getImage());
		ImagePanel joinpanel = new ImagePanel(
				new ImageIcon("C:\\Users\\KITRI\\git\\repository\\CDS\\image\\join.png").getImage());
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

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setBounds(1043, 202, 119, 46);
		joinpanel.add(btnNewButton_1);
		frame.getContentPane().add(mainpanel);
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("C:\\Users\\KITRI\\git\\repository\\CDS\\image\\login.png").getImage());
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
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
								
										// JPanel mainpanel = new JPanel();
										// mainpanel.setBounds(0, 0, 10, 10);
										// frame.getContentPane().add(mainpanel);
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
													joinpanel.setVisible(false);
													mainpanel.setVisible(true);
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
class check extends Guestlist{
	
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
