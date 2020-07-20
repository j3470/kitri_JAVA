package cds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		frame.getContentPane().setLayout(null);
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("C:/Users/KITRI/eclipse-workspace/CDS/image/login.png").getImage());
		// welcomePanel.setBounds(0, 0, 1093, 659);
		ImagePanel joinpanel = new ImagePanel(
				new ImageIcon("C:/Users/KITRI/eclipse-workspace/CDS/image/join.png").getImage());
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

		frame.setSize(joinpanel.getWidth(), joinpanel.getHeight());
		frame.getContentPane().add(joinpanel);
		joinpanel.setLayout(null);

		user = new JTextField();
		user.setFont(new Font("굴림", Font.PLAIN, 20));
		user.setColumns(10);
		user.setBounds(664, 203, 236, 40);
		joinpanel.add(user);

		password = new JPasswordField();
		password.setBounds(666, 267, 251, 40);
		joinpanel.add(password);

		JButton btnNewButton_2 = new JButton("SIGN IN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String nameTxt = user.getText();
				// String passTxt = password.getText();
				String nameTxt = user.getText();
				StringBuilder sbf = new StringBuilder("");
				char[] passTxt = password.getPassword();
				sbf.append(passTxt);
				if (nameTxt.equals("") || sbf.toString().equals("")) {
					JOptionPane.showMessageDialog(null, "뭐라도 좀 쳐라");
				} else {
					Boolean isCreate = User.createUser(nameTxt, sbf.toString());

					if (isCreate) {
						System.out.println("create account");
						JOptionPane.showMessageDialog(null, "가입완료!");
					} else {
						System.out.println("fail");
					}
				}
			}

		});
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_2.setBounds(1024, 641, 127, 33);
		joinpanel.add(btnNewButton_2);

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

		JComboBox<?> genderselect = new JComboBox<Object>(new Object[] { "select", "male", "female" });
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
		frame.setResizable(false);
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
