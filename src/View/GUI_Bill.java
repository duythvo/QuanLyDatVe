package View;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import DAO.Phim_DAO;
import DAO.SuatChieu_DAO;
import DAO.TrangThaiGhe_DAO;
import DAO.Ve_DAO;
import entity.HoaDonDTO;
import entity.Phim;
import entity.SuatChieu;
import entity.TrangThaiGhe;
import entity.Ve;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;

public class GUI_Bill extends JPanel {

	private JTextArea textArea;
	private String text_TenPhim;
	private String text_MaVe;
	private String text_Ghe="";
	private String text_ThoiGianChieu;
	private String text_PhongChieu;
	private String text_ThoiGianDat;
	private String text_TongTien;
	private SuatChieu_DAO suatChieu_DAO = new SuatChieu_DAO();
	private Ve_DAO ve_DAO = new Ve_DAO();
	private Phim_DAO phim_DAO = new Phim_DAO();
	private TrangThaiGhe_DAO trangThaiGhe_DAO = new TrangThaiGhe_DAO();
	private JPanel panel_Main;


	/**
	 * Create the panel.
	 */
	public GUI_Bill(HoaDonDTO hDonDTO) {
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		
		panel_Main = new JPanel();
		panel_Main.setLocation(259, 125);
		panel_Main.setBackground(Color.white);
		add(panel_Main);
		panel_Main.setSize(619,444);
		panel_Main.setLayout(null);
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.BOLD, 12));
		textArea.setBounds(69, 107, 533, 277);
		textArea.setBackground(Color.white);
		panel_Main.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Vé Phim");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(210, 45, 116, 37);
		panel_Main.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Xuất Vé");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setBounds(334, 643, 132, 37);
		add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(255, 165, 0));
		btnHy.setBounds(679, 643, 132, 37);
		add(btnHy);
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					removeAll();
					GUI_VePhim viewVePhim = new GUI_VePhim();
					add(viewVePhim);
					repaint();
					revalidate();
				}
		});
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inbill();
			}
			
		});

		text_MaVe = hDonDTO.getMaVe();
		System.out.println(text_MaVe);
		Ve ve = ve_DAO.getVeBangMa(text_MaVe);
		System.out.println(ve);
		
		SuatChieu sc = suatChieu_DAO.getSuatChieuBangMa(ve.getSuatChieu().getMaSuatChieu());
		text_ThoiGianChieu = sc.getNgayChieu().toString()+" " + sc.getGioChieu().toString();
		text_PhongChieu = sc.getPhongChieu().getMaPhongChieu();

		Phim phim = phim_DAO.getPhimBangMaPhim(sc.getPhim().getMaPhim());
		text_TenPhim = phim.getTenPhim();

		ArrayList<TrangThaiGhe> dsTrangThaiGhes =trangThaiGhe_DAO.getDSGheBangMaVe(text_MaVe);
		for (TrangThaiGhe trangThaiGhe : dsTrangThaiGhes) {
			text_Ghe += trangThaiGhe.getGhe().getMaGhe()+" ";
		} 

		text_ThoiGianDat = hDonDTO.getNgayLap().toString();
		text_TongTien = hDonDTO.getGiaHoaDon()+" ";
		
		setHeaderBill();
		setBodyBill();
		setFooterBill();
	}
	
	
	public void setHeaderBill() {
		textArea.setText("\tRạp Chiếu Phim KDHD Xin Kính Chào!\n"
                        +"Địa chỉ:416/19 Dương Quảng Hàm Phường 5 Quận Gò Vấp Tp Hồ Chí Minh\n"
                        +"SĐT:0397538105\n"
						+"*****************************************************************************************\n"
        );

	}

	public void setBodyBill(){
		textArea.setText(textArea.getText()
						+"\n\t\tTên Phim:"+text_TenPhim
						+"\nMã Vé:"+text_MaVe
						+"\nGhế:"+text_Ghe
						+"\nThời Gian Chiếu:"+text_ThoiGianChieu
						+"\nPhòng Chiếu:"+text_PhongChieu
						+"\n\n*****************************************************************************************"
						+"\n\nThời Gian Đặt:"+text_ThoiGianDat
						+"\nTổng Tiền:"+text_TongTien);
	}

	public void setFooterBill(){
		textArea.setText(textArea.getText()
						+"\n\n*****************************************************************************************"
						+"\n\n\tRạp Chiếu Phim KDHD Xin Cảm Ơn Quý Khách!");
	}

	public void inbill(){
		try {
			textArea.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
