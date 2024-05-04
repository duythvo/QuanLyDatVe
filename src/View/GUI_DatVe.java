package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.event.*;

import Controller.controlDatVe;
import DAO.ChiTietVe_DAO;
import DAO.HoaDon_DAO;
import DAO.LoaiGhe_DAO;
import DAO.PhongChieu_DAO;
import DAO.SuatChieu_DAO;
import DAO.TrangThaiGhe_DAO;
import DAO.Ve_DAO;
import connectDB.ConnectDB;
import entity.ChiTietVe;
import entity.Ghe;
import entity.HoaDon;
import entity.NhanVien;
import entity.Phim;
import entity.SuatChieu;
import entity.TrangThaiGhe;
import entity.Ve;

public class GUI_DatVe extends JPanel {

	private JPanel panel;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox_NgayChieu;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox_GioChieu;
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
	public JButton btns1[] = new JButton[22];
	public JButton btns2[] = new JButton[4];
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_6_2;
	private JPanel panel_2;
	public JLabel label_TenPhim;
	private JSeparator separator;
	public JLabel label_Ghe;
	public JLabel label_TongTien;
	public JLabel label_Time;
	public JButton button_TaoHoaDon;
	public JButton button_Huy;
	private JLabel lblNewLabel_2_1_1_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_PhuongThucTT;
	private JLabel lblNewLabel;
	private SuatChieu_DAO suatChieu_DAO = new SuatChieu_DAO();
	public JLabel label_MaPhim;
	private Phim movie;
	public Ghe[] ghes = new Ghe[25];
	public JLabel label_PhongChieu;
	private TrangThaiGhe_DAO trangThaiGhe_DAO = new TrangThaiGhe_DAO();
	private LoaiGhe_DAO loaiGhe_DAO = new LoaiGhe_DAO();
	private PhongChieu_DAO phongChieu_DAO = new PhongChieu_DAO();
	private ArrayList<SuatChieu> dsSuatChieu;
	public JTextArea textArea;
	private JLabel label_TenPhim1;
	private JLabel label_TongTien1;
	private HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
	private LocalDate currentTime = LocalDate.now();
	private SuatChieu sc = new SuatChieu();
	private Ve_DAO ve_DAO = new Ve_DAO();
	public int soLuong =0;
	private ChiTietVe_DAO chiTietVe_DAO = new ChiTietVe_DAO();

    /**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public GUI_DatVe(Phim phim,NhanVien nv) {
		try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		movie=phim;

		controlDatVe ac = new controlDatVe(this);
		dsSuatChieu = suatChieu_DAO.getdsSuatChieuBangMaPhim(phim.getMaPhim());

		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		panel = new JPanel();
		panel.setBounds(40, 102, 829, 157);
		add(panel);
		panel.setLayout(null);
		
		
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
		panel_2.setBounds(891, 172, 365, 542);
		add(panel_2);
		panel_2.setLayout(null);

		label_TenPhim1 = new JLabel("Tên Phim");
		label_TenPhim1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim1.setBounds(29, 82, 89, 22);
		panel_2.add(label_TenPhim1);
		
		label_TenPhim = new JLabel(movie.getTenPhim());
		label_TenPhim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim.setBounds(145, 82, 210, 22);
		panel_2.add(label_TenPhim);
		
		label_Time = new JLabel("Ngày/Giờ");
		label_Time.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Time.setBounds(29, 174, 300, 22);
		panel_2.add(label_Time);
		
		label_Ghe = new JLabel("Ghế:");
		label_Ghe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_Ghe.setBounds(29, 206, 311, 56);
		panel_2.add(label_Ghe);

		textArea = new JTextArea();
		textArea.setBounds(86, 218, 254, 44);
		panel_2.add(textArea);
		textArea.setLineWrap(true);
		
		separator = new JSeparator();
		separator.setBounds(0, 272, 362, 2);
		panel_2.add(separator);

		label_TongTien1 = new JLabel("Tổng tiền:");
		label_TongTien1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TongTien1.setBounds(40, 405, 89, 22);
		panel_2.add(label_TongTien1);
		
		label_TongTien = new JLabel("");
		label_TongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TongTien.setBounds(145, 405, 197, 22);
		panel_2.add(label_TongTien);
		
		button_TaoHoaDon = new JButton("Tạo Hóa Đơn");
		button_TaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_TaoHoaDon.setBounds(40, 469, 131, 44);
		button_TaoHoaDon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<HoaDon> dsHoaDon = hoaDon_DAO.getDSHoaDon();
				int stt = dsHoaDon.size()+1;
				String gia[] = label_TongTien.getText().split(" ");
				HoaDon hd = new HoaDon(stt>=10?"HD"+stt:"HD0"+stt, nv, 0, currentTime, Double.parseDouble(gia[0]));
				hoaDon_DAO.themHoaDon(hd);
				sc = new SuatChieu(dsSuatChieu.stream().filter(i->i.getNgayChieu().toString().equals(comboBox_NgayChieu.getSelectedItem().toString()) && i.getGioChieu().toString().equals(comboBox_GioChieu.getSelectedItem().toString())).findFirst().orElse(null).getMaSuatChieu());
				ArrayList<Ve> dsVe = ve_DAO.getDSVe();
				stt = dsVe.size()+1;
				Ve ve = new Ve(stt>=10?"V"+stt:"V0"+stt, sc);
				ve_DAO.themVe(ve);
				LocalDateTime currentDate = LocalDateTime.now();
				ChiTietVe ctv = new ChiTietVe(ve, hd, soLuong, currentDate);
				chiTietVe_DAO.themChiTietVe(ctv);

				ImageIcon img = new ImageIcon("src/img/ghedangchon.png");
				ImageIcon img1 = new ImageIcon("src/img/ghedoivang.png");
				JButton btn = new JButton(img);
				JButton btn1 = new JButton(img1);

				for(int i=0;i<24;i++){
					if(i<21){
						if(btns1[i].getIcon().toString().equals(btn.getIcon().toString())){
							trangThaiGhe_DAO.setTrangThaiGhe(ghes[i].getMaGhe(),sc.getMaSuatChieu(),true,ve.getMaVe());
						}
					}else{
						if(btns2[i-20].getIcon().toString().equals(btn1.getIcon().toString())){
							trangThaiGhe_DAO.setTrangThaiGhe(ghes[i].getMaGhe(),sc.getMaSuatChieu(),true,ve.getMaVe());
						}
					}
				}
				removeAll();
				GUI_VePhim viewVePhim = new GUI_VePhim();
				add(viewVePhim);
				repaint();
				revalidate();
			}
			
		});
		panel_2.add(button_TaoHoaDon);
		
		button_Huy = new JButton("Hủy");
		button_Huy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_Huy.setBounds(209, 469, 131, 44);
		button_Huy.addActionListener(ac);
		panel_2.add(button_Huy);

		JLabel label_TenPhim_1 = new JLabel("Mã Phim:");
		label_TenPhim_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_TenPhim_1.setBounds(29, 28, 89, 22);
		panel_2.add(label_TenPhim_1);
		
		label_MaPhim = new JLabel(phim.getMaPhim());
		label_MaPhim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_MaPhim.setBounds(142, 34, 198, 22);
		panel_2.add(label_MaPhim);

		JLabel label_PhongChieu1 = new JLabel("Phòng Chiếu:");
		label_PhongChieu1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_PhongChieu1.setBounds(29, 127, 109, 22);
		panel_2.add(label_PhongChieu1);
		
		label_PhongChieu = new JLabel("Phòng Chiếu:");
		label_PhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_PhongChieu.setBounds(155, 127, 197, 22);
		panel_2.add(label_PhongChieu);
		
		lblNewLabel = new JLabel("ĐẶT VÉ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(GUI_DatVe.class.getResource("/img/film-regular-24_1.png")));
		lblNewLabel.setBounds(491, 29, 130, 51);
		add(lblNewLabel);


		comboBox_NgayChieu = new JComboBox(dsNgayChieu(dsSuatChieu).toArray());
		comboBox_NgayChieu.setBounds(198, 22, 527, 38);
		comboBox_NgayChieu.addActionListener(ac);
		panel.add(comboBox_NgayChieu);

		List<String> dsGioChieu = getGioChieu(dsSuatChieu);
		comboBox_GioChieu = new JComboBox(dsGioChieu.toArray());
		comboBox_GioChieu.setBounds(198, 85, 527, 38);
		comboBox_GioChieu.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					label_Time.setText("Ngày/Giờ: "+comboBox_NgayChieu.getSelectedItem().toString() + " " + comboBox_GioChieu.getSelectedItem().toString());
					setPhongChieu(dsSuatChieu);
					setGhe();
				}
			}
		});
		panel.add(comboBox_GioChieu);

		label_Time.setText("Ngày/Giờ: "+comboBox_NgayChieu.getSelectedItem().toString() + " " + comboBox_GioChieu.getSelectedItem().toString());
		setPhongChieu(dsSuatChieu);

		for(int i=0;i<21;i++) {
			btns1[i] = new JButton();
			btns1[i].setBackground(new Color(236, 236, 236));
			btns1[i].setBorderPainted(false);
			btns1[i].addActionListener(ac);
			if(i<7){
				ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"A"+"1"+"."+(i+1):"A"+"2"+"."+(i+1),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
			}else{
				if(i>=7 && i<14){
					ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"B"+"1"+"."+(i-6):"B"+"2"+"."+(i-6),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
				}else{
					ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"C"+"1"+"."+(i-13):"C"+"2"+"."+(i-13),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
				}
			}
			panel_GheDon.add(btns1[i]);
		}


		
		for(int i=21;i<24;i++) {
			btns2[i-20] = new JButton();
			btns2[i-20].setBackground(new Color(236, 236, 236));
			btns2[i-20].setBorderPainted(false);
			btns2[i-20].addActionListener(ac);
			ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"D"+"1"+"."+(i-20):"D"+"2"+"."+(i-20),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(2));
			panel_5.add(btns2[i-20]);
		}

		for(int i=0;i<24;i++){		
			if(checkGhe(ghes[i].getMaGhe())){
				if(i<21){
					btns1[i].setIcon(new ImageIcon("src/img/ghedachon.png"));
					btns1[i].setDisabledIcon(new ImageIcon("src/img/ghedachon.png"));
					btns1[i].setEnabled(false);
				}else{
					btns2[i-20].setIcon(new ImageIcon("src/img/ghedoido.png"));
					btns2[i-20].setDisabledIcon(new ImageIcon("src/img/ghedoido.png"));
					btns2[i-20].setEnabled(false);
				}
			}else{
				if(i<21){
					btns1[i].setIcon(new ImageIcon("src/img/ghetrong.png"));
				}else{
					btns2[i-20].setIcon(new ImageIcon("src/img/ghedoitrang.png"));
				}
			}
		}
	}



		public List<String> dsNgayChieu (ArrayList<SuatChieu> dsSuatChieu){
			List<String> listNgayChieu = new ArrayList<>();
			for (SuatChieu suatChieu : dsSuatChieu) {
				if(listNgayChieu.stream().allMatch(i->!i.equals(suatChieu.getNgayChieu().toString()))){
					listNgayChieu.add(suatChieu.getNgayChieu().toString());
				}
			}
			return listNgayChieu;
		}

		public void setPhongChieu(ArrayList<SuatChieu> dsSuatChieu){
			for (SuatChieu suatChieu : dsSuatChieu) {
				if(suatChieu.getGioChieu().toString().equals(comboBox_GioChieu.getSelectedItem().toString()) && suatChieu.getNgayChieu().toString().equals(comboBox_NgayChieu.getSelectedItem().toString())){
					label_PhongChieu.setText(suatChieu.getPhongChieu().getMaPhongChieu());
				}
			}
		}

		public List<String> getGioChieu(ArrayList<SuatChieu> dsSuatChieu){
			List<String> dsGioChieu = new  ArrayList<>();
			for (SuatChieu suatChieu : dsSuatChieu) {
				if(suatChieu.getNgayChieu().toString().equals(comboBox_NgayChieu.getSelectedItem().toString())){
					dsGioChieu.add(suatChieu.getGioChieu().toString());
				}
			}
			return dsGioChieu;
		}

		public void setGhe(){
			for(int i=0;i<21;i++) {
				btns1[i].setBackground(new Color(236, 236, 236));
				btns1[i].setBorderPainted(false);
				if(i<7){
					ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"A"+"1"+"."+(i+1):"A"+"2"+"."+(i+1),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
				}else{
					if(i>=7 && i<14){
						ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"B"+"1"+"."+(i-6):"B"+"2"+"."+(i-6),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
					}else{
						ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"C"+"1"+"."+(i-13):"C"+"2"+"."+(i-13),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(1));
					}
				}
			}

			for(int i=21;i<24;i++) {
				btns2[i-20].setBackground(new Color(236, 236, 236));
				btns2[i-20].setBorderPainted(false);
				ghes[i] = new Ghe(label_PhongChieu.getText().equals("PC01")?"D"+"1"+"."+(i-20):"D"+"2"+"."+(i-20),phongChieu_DAO.getPhongChieuBangMaPhongChieu(label_PhongChieu.getText()) , loaiGhe_DAO.getLoaiGheBangMaLoaiGhe(2));
				panel_5.add(btns2[i-20]);
			}

			//System.out.println(checkGhe(ghes[1].getMaGhe()));
			for(int i=0;i<24;i++){	
				if(checkGhe(ghes[i].getMaGhe())){
					if(i<21){
						
						btns1[i].setIcon(new ImageIcon("src/img/ghedachon.png"));
						btns1[i].setDisabledIcon(new ImageIcon("src/img/ghedachon.png"));
						btns1[i].setEnabled(false);
					}else{
						btns2[i-20].setIcon(new ImageIcon("src/img/ghedoido.png"));
						btns2[i-20].setDisabledIcon(new ImageIcon("src/img/ghedoido.png"));
						btns2[i-20].setEnabled(false);
					}
				}else{
					if(i<21){
						btns1[i].setIcon(new ImageIcon("src/img/ghetrong.png"));
						btns1[i].setDisabledIcon(new ImageIcon("src/img/ghetrong.png"));
						btns1[i].setEnabled(true);
					}else{
						btns2[i-20].setIcon(new ImageIcon("src/img/ghedoitrang.png"));
						btns2[i-20].setDisabledIcon(new ImageIcon("src/img/ghedoitrang.png"));
						btns2[i-20].setEnabled(true);
					}
				}
			}
		}

		public boolean checkGhe(String maGhe){
			SuatChieu sc = dsSuatChieu.stream().filter(i->i.getNgayChieu().toString().equals(comboBox_NgayChieu.getSelectedItem().toString()) && i.getGioChieu().toString().equals(comboBox_GioChieu.getSelectedItem().toString())).findFirst().orElse(null);
			TrangThaiGhe trangThaiGhe = trangThaiGhe_DAO.getTrangThaiGhe(maGhe, sc.getMaSuatChieu());
			if(trangThaiGhe.isTrangThai()){
				return true;
			}
			return false;
		}

}
