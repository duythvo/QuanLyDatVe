package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GUI_DatVe extends JPanel {

	private JPanel panel;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JPanel panel_1;
    private JLabel label_SuatChieu;
    private JLabel label_NgayChieu;
    private JPanel panel_3;
	private JLabel label_ManHinh;
    private JLabel label_DayA;
	private JLabel label_DayB;
	private JLabel label_DayD;
	private JLabel label_DayC;
	private JPanel panel_GheDon;
	private JPanel panel_5;
	private JButton btns[] = new JButton[24];
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_6_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2_3;
	private JButton btnNewButton_2_3_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JComboBox comboBox_2;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public GUI_DatVe() {
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		panel = new JPanel();
		panel.setBounds(40, 102, 829, 157);
		add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(198, 22, 527, 38);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(198, 85, 527, 38);
		panel.add(comboBox_1);
		
		label_NgayChieu = new JLabel("Ngày chiếu");
		label_NgayChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_NgayChieu.setBounds(46, 27, 119, 22);
		panel.add(label_NgayChieu);
		
		label_SuatChieu = new JLabel("Suất chiếu");
		label_SuatChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_SuatChieu.setBounds(46, 90, 119, 22);
		panel.add(label_SuatChieu);
		
		panel_1 = new JPanel();
		panel_1.setBounds(40, 295, 829, 419);
		add(panel_1);
		panel_1.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(31, 10, 741, 39);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		label_ManHinh = new JLabel("Màn hình");
		label_ManHinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_ManHinh.setBounds(323, 10, 139, 19);
		panel_3.add(label_ManHinh);
		
		label_DayA = new JLabel("Dãy A");
		label_DayA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_DayA.setBounds(10, 126, 77, 22);
		panel_1.add(label_DayA);
		
		label_DayB = new JLabel("Dãy B");
		label_DayB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_DayB.setBounds(10, 177, 77, 22);
		panel_1.add(label_DayB);
		
		label_DayC = new JLabel("Dãy C");
		label_DayC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_DayC.setBounds(10, 234, 77, 22);
		panel_1.add(label_DayC);
		
		label_DayD = new JLabel("Dãy D");
		label_DayD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_DayD.setBounds(10, 293, 77, 22);
		panel_1.add(label_DayD);
		
		panel_GheDon = new JPanel();
		panel_GheDon.setBounds(97, 117, 675, 150);
		panel_1.add(panel_GheDon);
		panel_GheDon.setLayout(new GridLayout(3, 7, 20, 10));
		
		panel_5 = new JPanel();
		panel_5.setBounds(97, 277, 675, 45);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3, 0, 0));
		
		for(int i=0;i<21;i++) {
			btns[i] = new JButton();
			btns[i].setIcon(new ImageIcon("src/img/ghetrong.png"));
			btns[i].setBackground(new Color(236, 236, 236));
			btns[i].setBorderPainted(false);
			panel_GheDon.add(btns[i]);
		}
		
		for(int i=21;i<24;i++) {
			btns[i] = new JButton();
			btns[i].setIcon(new ImageIcon("src/img/ghedoitrang.png"));
			btns[i].setBackground(new Color(236, 236, 236));
			btns[i].setBorderPainted(false);
			panel_5.add(btns[i]);
		}
		
		lblNewLabel_6 = new JLabel("Ghế trống");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/ghetrong.png")));
		lblNewLabel_6.setBounds(103, 765, 130, 32);
		add(lblNewLabel_6);
		
		lblNewLabel_6_1 = new JLabel("Ghế đang chọn");
		lblNewLabel_6_1.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/ghedangchon.png")));
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(537, 764, 172, 34);
		add(lblNewLabel_6_1);
		
		lblNewLabel_6_2 = new JLabel("Ghế đã chọn");
		lblNewLabel_6_2.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/ghedachon.png")));
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(316, 765, 151, 33);
		add(lblNewLabel_6_2);
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(891, 295, 365, 419);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Tên Phim");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(40, 21, 89, 22);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ngày/Giờ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(40, 73, 89, 22);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("Ghế");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(40, 127, 89, 22);
		panel_2.add(lblNewLabel_2_1);
		
		separator = new JSeparator();
		separator.setBounds(0, 197, 362, 2);
		panel_2.add(separator);
		
		lblNewLabel_2_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(40, 300, 89, 22);
		panel_2.add(lblNewLabel_2_1_1);
		
		btnNewButton_2_3 = new JButton("Tạo Hóa Đơn");
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3.setBounds(42, 332, 131, 44);
		panel_2.add(btnNewButton_2_3);
		
		btnNewButton_2_3_1 = new JButton("Hủy");
		btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3_1.setBounds(205, 332, 131, 44);
		panel_2.add(btnNewButton_2_3_1);
		
		lblNewLabel_2_1_1_1 = new JLabel("Phương thức thanh toán");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(40, 209, 235, 31);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(40, 250, 312, 31);
		panel_2.add(comboBox_2);
		
		lblNewLabel = new JLabel("PHIM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(GUI_DatVe.class.getResource("/img/film-regular-24_1.png")));
		lblNewLabel.setBounds(491, 29, 130, 51);
		add(lblNewLabel);
	}

}
