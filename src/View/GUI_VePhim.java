package View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI_VePhim extends JPanel {
	private JTable table;
	private JTable table_1;
	private DefaultTableModel dtm;
	private JTable table_VePhim;
    private JLabel lblNewLabel;
	private JPanel panel;
    private JButton btnNewButton;
	private JButton btnLcChaThanh;
    private JButton btnXaHan;
	private DefaultTableModel model;
    private JScrollPane sc;

	/**
	 * Create the panel.
	 */
	public GUI_VePhim() {
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		
		lblNewLabel = new JLabel("  VÉ PHIM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(GUI_VePhim.class.getResource("/img/ticket-1--hobby-ticket-event-entertainment-stub-theater-entertainment-culture_3.png")));
		lblNewLabel.setBounds(588, 37, 166, 58);
		add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(24, 28, 44));
		panel.setBounds(44, 105, 797, 99);
		add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Cập nhật trạng thái");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(35, 23, 183, 53);
		panel.add(btnNewButton);
		
		btnLcChaThanh = new JButton("Lọc chưa thanh toán");
		btnLcChaThanh.setBackground(new Color(255, 165, 0));
		btnLcChaThanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLcChaThanh.setBounds(241, 23, 193, 53);
		panel.add(btnLcChaThanh);
		
		btnXaHan = new JButton("Xóa hóa đơn");
		btnXaHan.setBackground(new Color(255, 165, 0));
		btnXaHan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXaHan.setBounds(460, 23, 163, 53);
		panel.add(btnXaHan);
		
		model = new DefaultTableModel();
		model.addColumn("Mã Vé");
		model.addColumn("Tên Phim");
		model.addColumn("Thời Gian Đặt");
		model.addColumn("Giá Tiền");
		model.addColumn("Trạng Thái");
		table_VePhim = new JTable(model);
		sc = new JScrollPane(table_VePhim);
		sc.setBounds(61, 280, 1180, 348);
		table_VePhim.getTableHeader().setBackground(new Color(102,51,153));
		table_VePhim.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
		table_VePhim.getTableHeader().setForeground(Color.WHITE);
		add(sc);
		sc.setPreferredSize(new Dimension(1180,300));
		
	}
}
