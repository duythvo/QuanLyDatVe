package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class GUI_TaiKhoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
    private JPanel panel;
    private JSeparator separator;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
    private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public GUI_TaiKhoan() {
		setSize(1350,900);
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		
		lblNewLabel = new JLabel("TÀI KHOẢN");
		lblNewLabel.setIcon(new ImageIcon(GUI_TaiKhoan.class.getResource("/img/user-multiple-group--close-geometric-human-multiple-person-up-user.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(592, 29, 165, 43);
		add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(32, 44, 92));
		panel.setBounds(241, 119, 852, 390);
		add(panel);
		panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(0, 38, 1279, 2);
		panel.add(separator);
		
		lblNewLabel_2 = new JLabel("Thông tin cá nhân");
		lblNewLabel_2.setBounds(306, 11, 247, 22);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Họ tên:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(72, 75, 125, 22);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Số điện thoại:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(72, 130, 136, 49);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_4_1 = new JLabel("Ngày sinh:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(72, 191, 136, 49);
		panel.add(lblNewLabel_4_1);
		
		lblNewLabel_5 = new JLabel("Giới tính:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(72, 265, 111, 32);
		panel.add(lblNewLabel_5);
		
		btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(603, 560, 123, 63);
		add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Thời gian hiện tại:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(264, 78, 147, 26);
		add(lblNewLabel_1);

	}
}
