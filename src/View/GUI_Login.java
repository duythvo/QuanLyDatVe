package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public GUI_Login() {
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		
		lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(173, 47, 112, 37);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GUI_Login.class.getResource("/img/user-multiple-group--close-geometric-human-multiple-person-up-user.png")));
		lblNewLabel_1.setBounds(123, 42, 47, 42);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Tài Khoản :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 156, 118, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 51, 153));
		textField.setBounds(44, 181, 318, 37);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2_1 = new JLabel("Mật khẩu :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(23, 256, 118, 22);
		add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(102, 51, 153));
		textField_1.setBounds(44, 289, 318, 37);
		add(textField_1);
		
		btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBounds(266, 400, 96, 37);
		add(btnNewButton);

	}
}