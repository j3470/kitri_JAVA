package cds;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import database.oracle.OracleDatabaseConnector;

public class Guestlist {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private static OracleDatabaseConnector dbConnector = new OracleDatabaseConnector("localhost", 1521, "xe",
			"c##ora_user", "yeo");
	private JTextField search;

	public static String[][] getCustomers() {
		try {
			Connection con = dbConnector.getConnection();
			PreparedStatement statement = con
					.prepareStatement("Select name, gender, year,month,day,admission,grade FROM customer2");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("name"), results.getString("gender"),
						results.getString("year"), results.getString("month"), results.getString("day"),
						results.getString("admission"), results.getString("grade"), });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][8];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guestlist window = new Guestlist();
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

	public Guestlist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel guestpanel = new JPanel();
		String[][] data = getCustomers();
		String[] headers = new String[] { "name", "gender", "year", "month", "day", "admission", "grade" };
		guestpanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setAlignmentX(0);
		// table.setSize(,400);
		table.setPreferredScrollableViewportSize(new Dimension(900, 400));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 67, 919, 340);
		guestpanel.add(scrollPane);
		frame.getContentPane().add(guestpanel);
		guestpanel.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(guestpanel);

		JLabel lblNewLabel = new JLabel("Guest List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Javanese Text", Font.PLAIN, 35));
		lblNewLabel.setBounds(40, 10, 919, 60);
		guestpanel.add(lblNewLabel);

		search = new JTextField();
		search.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		search.setBounds(198, 446, 761, 35);
		guestpanel.add(search);
		search.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("search list");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(52, 448, 134, 33);
		guestpanel.add(lblNewLabel_1);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));

			}
		});
	}
}
