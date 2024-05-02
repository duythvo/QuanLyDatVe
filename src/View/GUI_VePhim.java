package View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import Controller.control_VePhim;
import Test.GUI_Bill;
import connectDB.ConnectDB;
import entity.HoaDonDTO;

public class GUI_VePhim extends JPanel implements ActionListener , MouseListener {
	private JTable table_VePhim;
    private JLabel label_VePhim;
	private JPanel panel_Button;
    private JButton btn_CapNhat;
	private JButton btn_ThanhToan;
    private JButton btn_XoaHD;
	private DefaultTableModel model;
    private JScrollPane sc;
	private JButton btn_InHD;
    private JButton btn_TimVe;
    private JTextField txt_MaVe;
    private JLabel label_MaVe;
	private control_VePhim controller_VP;
	HoaDonDTO hdto = new HoaDonDTO();

	public GUI_VePhim() 
	{
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		setSize(1350,900);
		
		label_VePhim = new JLabel("  VÉ PHIM");
		label_VePhim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_VePhim.setForeground(new Color(255, 255, 255));
		label_VePhim.setIcon(new ImageIcon(GUI_VePhim.class.getResource("/img/ticket-1--hobby-ticket-event-entertainment-stub-theater-entertainment-culture_3.png")));
		label_VePhim.setBounds(588, 37, 166, 58);
		add(label_VePhim);
		
		panel_Button = new JPanel();
		panel_Button.setBackground(new Color(24, 28, 44));
		panel_Button.setBounds(44, 105, 1100, 99);
		add(panel_Button);
		panel_Button.setLayout(null);
		
		btn_CapNhat = new JButton("Cập nhật trạng thái");
		btn_CapNhat.setBackground(new Color(255, 165, 0));
		btn_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_CapNhat.setBounds(35, 23, 183, 53);
		panel_Button.add(btn_CapNhat);
		
		btn_ThanhToan = new JButton("Lọc chưa thanh toán");
		btn_ThanhToan.setBackground(new Color(255, 165, 0));
		btn_ThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_ThanhToan.setBounds(241, 23, 193, 53);
		panel_Button.add(btn_ThanhToan);
		
		btn_XoaHD = new JButton("Xóa hóa đơn");
		btn_XoaHD.setBackground(new Color(255, 165, 0));
		btn_XoaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_XoaHD.setBounds(460, 23, 163, 53);
		panel_Button.add(btn_XoaHD);
		

		btn_TimVe = new JButton("Tìm Theo Mã Vé");
		btn_TimVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_TimVe.setBackground(new Color(255, 165, 0));
		btn_TimVe.setBounds(653, 23, 163, 53);
		panel_Button.add(btn_TimVe);
		
		txt_MaVe = new JTextField();
		txt_MaVe.setForeground(new Color(255, 255, 255));
txt_MaVe.setBackground(new Color(102, 51, 153));
		txt_MaVe.setBounds(846, 53, 140, 23);
		panel_Button.add(txt_MaVe);
		txt_MaVe.setColumns(10);
		
		label_MaVe = new JLabel("Nhập Mã Vé :");
		label_MaVe.setForeground(new Color(255, 255, 255));
		label_MaVe.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_MaVe.setBounds(846, 24, 150, 30);
		panel_Button.add(label_MaVe);


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


		btn_InHD = new JButton("In Hóa Đơn");
		btn_InHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_InHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_InHD.setBackground(new Color(255, 165, 0));
		btn_InHD.setBounds(936, 700, 163, 53);
		add(btn_InHD);

		controller_VP = new control_VePhim(model, table_VePhim, btn_CapNhat, btn_ThanhToan, btn_XoaHD, btn_TimVe, btn_InHD, txt_MaVe);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		controller_VP.hienThiDSHoaDon();

		//Event
		btn_CapNhat.addActionListener(this);
		btn_ThanhToan.addActionListener(this);
		btn_XoaHD.addActionListener(this);
		btn_TimVe.addActionListener(this);
		btn_InHD.addActionListener(this);
		table_VePhim.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();

		if(o.equals(btn_CapNhat)) {
			controller_VP.capNhatTrangThai();
		} else if (o.equals(btn_ThanhToan)) {
			controller_VP.locThanhToan();
		} else if (o.equals(btn_XoaHD)) {
			controller_VP.xoaHoaDon();
		} else if (o.equals(btn_TimVe)) {
			controller_VP.timMaVe();
		} else if (o.equals(btn_InHD)) {
				this.removeAll();
				GUI_Bill view_Bill = new GUI_Bill(hdto);
				this.add(view_Bill);
				this.repaint();
				this.revalidate();
		}

	}



	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_VePhim.getSelectedRow();

		hdto.setMaVe(model.getValueAt(row, 0).toString());

		hdto.setTenPhim(model.getValueAt(row, 1).toString());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = model.getValueAt(row, 2).toString();
		LocalDate ngayLap = LocalDate.parse(date, formatter);

		hdto.setNgayLap(ngayLap);

		double giaTien = Double.parseDouble( model.getValueAt(row, 3).toString());
		hdto.setGiaHoaDon(giaTien);
		
		int tt;
		String trangThai;
trangThai = model.getValueAt(row, 4).toString();
		if(trangThai.equalsIgnoreCase("Chưa Thanh Toán")) {
			tt = 0;
		} else {
			tt = 1;
		}
		hdto.setTrangThai(tt);


	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}