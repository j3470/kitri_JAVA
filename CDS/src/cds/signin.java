package cds;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signin {

	private JFrame frame;
	private JTextField user;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin window = new signin();
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
	public signin() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		//frame.setBounds(100, 100, 811, 242);
		//frame.setSize(new Dimension(811,242));
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImagePanel joinpanel = new ImagePanel(
				new ImageIcon("C:/Users/KITRI/eclipse-workspace/CDS/image/join.png").getImage());
		frame.setSize(joinpanel.getWidth(), joinpanel.getHeight());
		frame.getContentPane().add(joinpanel);
		joinpanel.setLayout(null);
		frame.setLocationRelativeTo(null);
		//joinpanel.setLayout(null);
		///frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		//frame.getContentPane().add(joinpanel);
		
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
				//String nameTxt = user.getText();
				//String passTxt = password.getText();
				String nameTxt = user.getText();
				StringBuilder sbf = new StringBuilder("");
				char[] passTxt = password.getPassword();
				sbf.append(passTxt);
				if(nameTxt.equals("") || sbf.toString().equals("")) {
					JOptionPane.showMessageDialog(null, "뭐라도 좀 쳐라");
				}
				else {
				Boolean isCreate = true;/*User.createUser(nameTxt, sbf.toString());*/
				
				if(isCreate) {
					System.out.println("create account");
					JOptionPane.showMessageDialog(null, "가입완료!");
				}
				else {
					System.out.println("fail");
				}
				}
			}

		});
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_2.setBounds(1024, 641, 127, 33);
		joinpanel.add(btnNewButton_2);
	}
}