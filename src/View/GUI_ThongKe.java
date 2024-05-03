package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.control_ThongKe;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import connectDB.ConnectDB;
import DAO.HoaDon_DAO;

import com.raven.event.EventTimePicker;
import com.raven.swing.TimePicker;
import calender.DateChooser;
import calender.SelectedDate;

public class GUI_ThongKe extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTuNgay;
	private JTextField txt_NhanVien;
	private JTable table;
    private JPanel panel_ThongKe;
	private JLabel label_Logo;
	private JLabel label_Title;
    private JLabel label_tuNgay;
	private JLabel label_maNV;
    private JButton btn_ThongKe;
    private JButton btn_TimNV;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private JTextField txt_DenNgay;
	private control_ThongKe control_tk;
	private JButton btn_LamMoi;
	private JButton btn_DenNgay;
	private JButton btn_TuNgay;
	boolean flat1 = false;
    boolean flat2 = false;
	DateChooser dateChooser = new DateChooser();


	/**
	 * Create the panel.
	 */
	public GUI_ThongKe() {
		setSize(1350,900);
		setLayout(null);
		
		panel_ThongKe = new JPanel();
		panel_ThongKe.setLocation(0, 0);
		panel_ThongKe.setSize(1350,900);
		panel_ThongKe.setBackground(new Color(24, 28, 44));
		add(panel_ThongKe);
		panel_ThongKe.setLayout(null);
		
		label_Logo = new JLabel("");
		label_Logo.setIcon(new ImageIcon(GUI_ThongKe.class.getResource("/img/graph-bar-increase--up-product-performance-increase-arrow-graph-business-chart.png")));
		label_Logo.setBounds(617, 49, 47, 56);
		panel_ThongKe.add(label_Logo);
		
		label_Title = new JLabel("THỐNG KÊ");
		label_Title.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_Title.setForeground(new Color(255, 255, 255));
		label_Title.setBounds(676, 49, 147, 65);
		panel_ThongKe.add(label_Title);
		
		label_tuNgay = new JLabel("Từ Ngày :");
		label_tuNgay.setForeground(new Color(255, 255, 255));
		label_tuNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_tuNgay.setBounds(196, 179, 102, 25);
		panel_ThongKe.add(label_tuNgay);
		
		txtTuNgay = new JTextField();
		txtTuNgay.setBackground(new Color(102, 51, 153));
		txtTuNgay.setForeground(new Color(255, 255, 255));
		txtTuNgay.setBounds(310, 181, 180, 24);
		panel_ThongKe.add(txtTuNgay);
		txtTuNgay.setColumns(10);
		
		label_maNV = new JLabel("Mã Nhân Viên:");
		label_maNV.setForeground(Color.WHITE);
		label_maNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_maNV.setBounds(751, 200, 122, 25);
		panel_ThongKe.add(label_maNV);
		
		txt_NhanVien = new JTextField();
		txt_NhanVien.setForeground(new Color(255, 255, 255));
		txt_NhanVien.setColumns(10);
		txt_NhanVien.setBackground(new Color(102, 51, 153));
		txt_NhanVien.setBounds(880, 200, 180, 24);
		panel_ThongKe.add(txt_NhanVien);
		
		btn_ThongKe = new JButton("Thống kê theo ngày");
		btn_ThongKe.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ThongKe.setForeground(new Color(0, 0, 0));
		btn_ThongKe.setBackground(new Color(255, 165, 0));
		btn_ThongKe.setBounds(202, 280, 163, 34);
		panel_ThongKe.add(btn_ThongKe);
		
		btn_TimNV = new JButton("Tìm nhân viên theo mã");
		btn_TimNV.setForeground(Color.BLACK);
		btn_TimNV.setBackground(new Color(255, 165, 0));
		btn_TimNV.setBounds(803, 280, 217, 34);
		panel_ThongKe.add(btn_TimNV);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 380, 1270, 500);
		panel_ThongKe.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD t\u00EAn NV", "Ng\u00E0y l\u00E0m", "S\u1ED1 v\u00E9", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		txt_DenNgay = new JTextField();
		txt_DenNgay.setForeground(new Color(255, 255, 255));
		txt_DenNgay.setColumns(10);
		txt_DenNgay.setBackground(new Color(102, 51, 153));
		txt_DenNgay.setBounds(310, 225, 180, 24);
		panel_ThongKe.add(txt_DenNgay);
		
		JLabel label_DenNgay = new JLabel("Đến ngày :");
		label_DenNgay.setForeground(Color.WHITE);
		label_DenNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_DenNgay.setBounds(196, 224, 102, 25);
		panel_ThongKe.add(label_DenNgay);

		
		btn_LamMoi = new JButton("Làm mới");
		btn_LamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_LamMoi.setForeground(Color.BLACK);
		btn_LamMoi.setBackground(new Color(255, 165, 0));
		btn_LamMoi.setBounds(386, 280, 91, 34);
		panel_ThongKe.add(btn_LamMoi);

		btn_TuNgay = new JButton("");
		btn_TuNgay.setBackground(new Color(102, 51, 150));
		btn_TuNgay.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/icons8-date-26.png")));
		btn_TuNgay.setBounds(512, 179, 28, 28);
		btn_TuNgay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!flat1) { 
					showDate(txtTuNgay);
					flat1 = true;
				}else {
					dateChooser.hidePopup();
					flat1 = false;
				}
			}
		});
		panel_ThongKe.add(btn_TuNgay);
		
		btn_DenNgay = new JButton("");
		btn_DenNgay.setBackground(new Color(102, 51, 150));
		btn_DenNgay.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/icons8-date-26.png")));
		btn_DenNgay.setBounds(512, 226, 28, 28);
		btn_DenNgay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!flat2) { 
					showDate(txt_DenNgay);
					flat2 = true;
				}else {
					dateChooser.hidePopup();
					flat2 = false;
				}
			}
		});
		panel_ThongKe.add(btn_DenNgay);

		control_tk = new control_ThongKe( table, btn_ThongKe, btn_TimNV,btn_LamMoi, txtTuNgay, txt_DenNgay, txt_NhanVien);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Events
		btn_ThongKe.addActionListener(this);
		btn_TimNV.addActionListener(this);
		btn_LamMoi.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_ThongKe)) {
			control_tk.layDanhSachThongKe();
		}else if (o.equals(btn_TimNV)) {
			control_tk.timNhanVien();
		} else if (o.equals(btn_LamMoi)) {
			control_tk.lamMoi();
		}
	}

	public void showDate(JTextField txt) {
		dateChooser.showPopup(this, (getWidth() - dateChooser.getPreferredSize().width) / 2, (getHeight() - dateChooser.getPreferredSize().height) / 2);
		if(dateChooser.isFocusable()) {
			dateChooser.setDateFormat("yyyy/MM/dd");
			dateChooser.setTextRefernce(txt);
		}
		
	}


}