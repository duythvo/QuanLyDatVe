package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import Test.Main;
import entity.NhanVien;
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
	private NhanVien nhanVienLogIn;
	GUI_Login gui_Login = new GUI_Login();
	GUI_Main gui_Main;


	/**
	 * Create the panel.
	 */
	public GUI_TaiKhoan(NhanVien nv) {
		setSize(1350,900);
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		gui_Login.setVisible(false);
		nhanVienLogIn = nv;


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
		
		lblNewLabel_3 = new JLabel("Họ tên: "+ nhanVienLogIn.getTenNV());
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(72, 75, 350, 22);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Số điện thoại: " + nhanVienLogIn.getSdt());
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(72, 130, 350, 49);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_4_1 = new JLabel("Ngày sinh: " + nhanVienLogIn.getNgaySinh());
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(72, 191, 350, 49);
		panel.add(lblNewLabel_4_1);
		
		lblNewLabel_5 = new JLabel("CCCD: "+ nhanVienLogIn.getCccd());
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(72, 265, 350, 32);
panel.add(lblNewLabel_5);
		
		btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GUI_TaiKhoan.this);
				frame.dispose();
				new GUI_Login();
			}
		});
		btnNewButton.setBounds(603, 560, 123, 63);
		add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Thời gian hiện tại:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(264, 78, 350, 26);
		add(lblNewLabel_1);
		updateCurrentTime();
	}

	public void hienThiDanhSach() {

	}
	private void updateCurrentTime() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    LocalDateTime currentTime = LocalDateTime.now();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formattedTime = currentTime.format(formatter);

                    // Cập nhật giá trị của nhãn
                    lblNewLabel_1.setText("Thời gian hiện tại: " + formattedTime);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}