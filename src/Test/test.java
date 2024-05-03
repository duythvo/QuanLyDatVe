package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import DAO.SuatChieu_DAO;
import connectDB.ConnectDB;
import entity.SuatChieu;
import javax.swing.JTextArea;

public class test extends JPanel {

	private JPanel panel;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_NgayChieu;
	@SuppressWarnings("rawtypes")
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
	public JLabel label_TenPhim;
	private JSeparator separator;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel label_Time;
	private JButton btnNewButton_2_3;
	private JButton btnNewButton_2_3_1;
	private JLabel lblNewLabel_2_1_1_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_2;
	private JLabel lblNewLabel;
	private SuatChieu_DAO suatChieu_DAO = new SuatChieu_DAO();
	public String maPhim;


	public String getMaPhim() {
        return maPhim;
    }


    public void setMaPhim(String maPhim) {
        this.maPhim = maPhim;
    }


    /**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public test() {
		try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		panel = new JPanel();
		panel.setBounds(40, 102, 829, 157);
		add(panel);
		panel.setLayout(null);
		
		ArrayList<SuatChieu> dsSuatChieu = suatChieu_DAO.getDSSuatChieu();

		List<String> dsNgayChieu = getNgayChieu(dsSuatChieu);
		// String [] str = dsNgayChieu.toArray(new String[0]);
		comboBox_NgayChieu = new JComboBox(dsNgayChieu.toArray());
		comboBox_NgayChieu.setBounds(198, 22, 527, 38);
		panel.add(comboBox_NgayChieu);

		List<String> dsGioChieu = getGioChieu(dsSuatChieu);
		comboBox_1 = new JComboBox(dsGioChieu.toArray());
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
		lblNewLabel_6.setIcon(new ImageIcon(test.class.getResource("/img/ghetrong.png")));
		lblNewLabel_6.setBounds(103, 765, 130, 32);
		add(lblNewLabel_6);
		
		lblNewLabel_6_1 = new JLabel("Ghế đang chọn");
		lblNewLabel_6_1.setIcon(new ImageIcon(test.class.getResource("/img/ghedangchon.png")));
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(537, 764, 172, 34);
		add(lblNewLabel_6_1);
		
		lblNewLabel_6_2 = new JLabel("Ghế đã chọn");
		lblNewLabel_6_2.setIcon(new ImageIcon(test.class.getResource("/img/ghedachon.png")));
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(316, 765, 151, 33);
		add(lblNewLabel_6_2);
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(891, 172, 365, 542);
		add(panel_2);
		panel_2.setLayout(null);
		
		label_TenPhim = new JLabel("Tên Phim");
		label_TenPhim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim.setBounds(29, 82, 89, 22);
		panel_2.add(label_TenPhim);
		
		label_Time = new JLabel("Ngày/Giờ");
		label_Time.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Time.setBounds(29, 174, 89, 22);
		panel_2.add(label_Time);
		
		lblNewLabel_2_1 = new JLabel("Ghế");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(29, 218, 47, 44);
		panel_2.add(lblNewLabel_2_1);
		
		separator = new JSeparator();
		separator.setBounds(0, 272, 362, 2);
		panel_2.add(separator);
		
		lblNewLabel_2_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(40, 405, 89, 22);
		panel_2.add(lblNewLabel_2_1_1);
		
		btnNewButton_2_3 = new JButton("Tạo Hóa Đơn");
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3.setBounds(40, 469, 131, 44);
		panel_2.add(btnNewButton_2_3);
		
		btnNewButton_2_3_1 = new JButton("Hủy");
		btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3_1.setBounds(209, 469, 131, 44);
		panel_2.add(btnNewButton_2_3_1);
		
		lblNewLabel_2_1_1_1 = new JLabel("Phương thức thanh toán");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(40, 284, 235, 31);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(40, 348, 312, 31);
		panel_2.add(comboBox_2);
		
		JLabel label_TenPhim_1 = new JLabel("MaPhim");
		label_TenPhim_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim_1.setBounds(29, 34, 89, 22);
		panel_2.add(label_TenPhim_1);
		
		JLabel label_PhongChieu = new JLabel("Phòng Chiếu:");
		label_PhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_PhongChieu.setBounds(29, 127, 109, 22);
		panel_2.add(label_PhongChieu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(86, 218, 269, 44);
		panel_2.add(textArea);
		
		JLabel label_MaPhim = new JLabel("MaPhim");
		label_MaPhim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_MaPhim.setBounds(142, 34, 198, 22);
		panel_2.add(label_MaPhim);
		
		JLabel label_TenPhim_2 = new JLabel("Tên Phim");
		label_TenPhim_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim_2.setBounds(145, 82, 210, 22);
		panel_2.add(label_TenPhim_2);
		
		JLabel label_PhongChieu_1 = new JLabel("Phòng Chiếu:");
		label_PhongChieu_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_PhongChieu_1.setBounds(155, 127, 197, 22);
		panel_2.add(label_PhongChieu_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(155, 405, 200, 22);
		panel_2.add(lblNewLabel_2_1_1_2);
		
		lblNewLabel = new JLabel("ĐẶT VÉ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(test.class.getResource("/img/film-regular-24_1.png")));
		lblNewLabel.setBounds(491, 29, 130, 51);
		add(lblNewLabel);
	}


		public List<String> getNgayChieu(ArrayList<SuatChieu> dsSuatChieu){
			List<String> dsNgayChieu = new  ArrayList<>();
			System.out.println(maPhim);
			for (SuatChieu suatChieu : dsSuatChieu) {
				if(suatChieu.getPhim().getMaPhim().equals(maPhim)){
					String date[] = suatChieu.getNgayChieu().toString().split("-");
					String ngayChieu = date[2] + "/" + date[1];
					if(dsNgayChieu.stream().allMatch(i->!i.equals(ngayChieu))){
						dsNgayChieu.add(ngayChieu);
					}
				}
			}
			return dsNgayChieu;
		}

		public List<String> getGioChieu(ArrayList<SuatChieu> dsSuatChieu){
			List<String> dsGioChieu = new  ArrayList<>();
			for (SuatChieu suatChieu : dsSuatChieu) {
				String date = suatChieu.getGioChieu().toString();
				dsGioChieu.add(date);
			}
			return dsGioChieu;
		}
}
