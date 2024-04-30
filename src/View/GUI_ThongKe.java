package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
    private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
    private JButton btnNewButton;
    private JButton btnTmNhnVin;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public GUI_ThongKe() {
		setSize(1350,900);
		setLayout(null);
		
		panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(1350,900);
		panel.setBackground(new Color(24, 28, 44));
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_ThongKe.class.getResource("/img/graph-bar-increase--up-product-performance-increase-arrow-graph-business-chart.png")));
		lblNewLabel.setBounds(617, 49, 47, 56);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("THỐNG KÊ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(676, 49, 147, 65);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nhập ngày :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(196, 179, 102, 25);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 51, 153));
		textField.setForeground(new Color(102, 51, 153));
		textField.setBounds(308, 181, 180, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(751, 179, 122, 25);
		panel.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(102, 51, 153));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(102, 51, 153));
		textField_1.setBounds(880, 181, 180, 24);
		panel.add(textField_1);
		
		btnNewButton = new JButton("Thống kê theo ngày");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBounds(242, 237, 217, 34);
		panel.add(btnNewButton);
		
		btnTmNhnVin = new JButton("Tìm nhân viên theo mã");
		btnTmNhnVin.setForeground(Color.BLACK);
		btnTmNhnVin.setBackground(new Color(255, 165, 0));
		btnTmNhnVin.setBounds(803, 237, 217, 34);
		panel.add(btnTmNhnVin);
		
		

		dtm = new DefaultTableModel();
		dtm.addColumn("Tên Nhân Viên");
		dtm.addColumn("Tổng doanh thu");

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 380, 1270, 500);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(32, 44, 92));
		table.setBackground(new Color(32, 44, 92));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD t\u00EAn NV", "Ng\u00E0y l\u00E0m", "S\u1ED1 v\u00E9", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
	}
}