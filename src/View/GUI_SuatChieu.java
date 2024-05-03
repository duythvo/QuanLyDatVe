package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.raven.event.EventTimePicker;
import com.raven.swing.TimePicker;
import calender.DateChooser;
import calender.SelectedDate;

import Controller.control_XuatChieu;
import DAO.Phim_DAO;
import DAO.PhongChieu_DAO;
import DAO.SuatChieu_DAO;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class GUI_SuatChieu extends JPanel implements MouseListener{
	private JTextField textFieldTim;
	private JTextField textFieldNgayChieu;
	private JTextField textFieldPhim;
	private JTextField textFieldThoiGian;
	private TimePicker timePicker = new TimePicker();
	TimePicker timePicker_1 = new TimePicker();
	DateChooser dateChooser = new DateChooser();
	SuatChieu_DAO suatChieu_DAO = new SuatChieu_DAO();
	Phim_DAO phim_DAO = new Phim_DAO();
	PhongChieu_DAO phongChieu_DAO = new PhongChieu_DAO(); 
	ArrayList<SuatChieu> listSuatChieus = new ArrayList<>();
	ArrayList<Phim> listPhims = new ArrayList<>();
	ArrayList<PhongChieu> listPhongChieus = new ArrayList<>();
	public JButton btnThem;
	public JButton btnSua;
	public JButton btnXoa;
	public JButton btnLamMoi;
	static int count;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	boolean flat1 = false;
    boolean flat2 = false;
	private DefaultTableModel model;
	private JTable table_VePhim;
	private JScrollPane scrollPane;
	public JRadioButton rdbtnXem;
	public JRadioButton rdbtnChinhSua;
	private JComponent panel_day;
	private JPanel panel_form;
	private JComboBox comboBoxPhongChieu;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	int size;
	private JTextField textFieldMaSC;
	public JButton btnTim;
	private JPanel panelDay_1;
	private JPanel panelDay_2;
	private JPanel panelDay_3;
	private Container panelDay_4;
	private JPanel panelDay_5;

	/**	
	 * Create the panel.
	 */
	public GUI_SuatChieu() {
		setForeground(new Color(255, 255, 255));
		listSuatChieus = suatChieu_DAO.getDSSuatChieu();
		listPhims = phim_DAO.getDSPhim();
		listPhongChieus = phongChieu_DAO.getDSPhongChieu();
//		count = 
		
		creTable();
		table_VePhim.addMouseListener(this);
		
		setSize(1380, 900);
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		
		timePicker.set24hourMode(true);
		
		JLabel lblNewLabel = new JLabel(" SUẤT CHIẾU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/xuatchieu.png")));
		lblNewLabel.setBounds(575, 25, 183, 41);
		add(lblNewLabel);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(59, 120, 780, 666);
		add(panel_main);
		panel_main.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 90, 780, 576);
		panel_main.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 51, 153));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(102, 51, 153));
		
		panel1.setLayout(new GridLayout(7, 1, 0, 0));
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(102, 51, 153));
//		scrollPane.setViewportView(panel2);
		panel2.setLayout(new GridLayout(7, 1, 0, 0));
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(102, 51, 153));
//		scrollPane.setViewportView(panel3);
		panel3.setLayout(new GridLayout(7, 1, 0, 0));
		
		panel4 = new JPanel();
		panel4.setBackground(new Color(102, 51, 153));
//		scrollPane.setViewportView(panel4);
		panel4.setLayout(new GridLayout(7, 1, 0, 0));
		
		//AddItem
		ArrayList<Phim> dsPSC = getDsPhimSC();
		ArrayList<LocalTime> gioSC = new ArrayList<>();
		ArrayList<LocalDate> ngaySC = new ArrayList<>();
		int co = 2;
		LocalDate dateCurr = LocalDate.parse("30/04/2024", dtf);
		for (Phim phim : dsPSC) {
			ngaySC = getDsNgayChieu(phim);
			for (LocalDate localDate : ngaySC) {
				gioSC = getDsGioChieu(phim, localDate);
				System.out.println(phim.getTenPhim() + localDate + gioSC);
				if(localDate.format(dtf).equals(dateCurr.format(dtf))) {
					crePanelItem(phim.getTenPhim(), ngaySC, gioSC, co, panel);
				}else if(localDate.format(dtf).equals(dateCurr.plusDays(1).format(dtf))) {
					crePanelItem(phim.getTenPhim(), ngaySC, gioSC, co, panel1);
				}else if(localDate.format(dtf).equals(dateCurr.plusDays(2).format(dtf))) {
					crePanelItem(phim.getTenPhim(), ngaySC, gioSC, co, panel2);
				}else if(localDate.format(dtf).equals(dateCurr.plusDays(3).format(dtf))) {
					crePanelItem(phim.getTenPhim(), ngaySC, gioSC, co, panel3);
				}else if(localDate.format(dtf).equals(dateCurr.plusDays(4).format(dtf))) {
					crePanelItem(phim.getTenPhim(), ngaySC, gioSC, co, panel4);
				}
				co++;
			}
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setForeground(new Color(64, 0, 64));
		panel_1.setPreferredSize(new Dimension(700, 250));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPhim_1 = new JLabel("Spirited Away – Vùng đất linh hồn");
		lblPhim_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_1.setBounds(20, 22, 431, 40);
		panel_1.add(lblPhim_1);
		
		JLabel lblXC_1_1 = new JLabel("17:15");
		lblXC_1_1.setOpaque(true);
		lblXC_1_1.setBackground(new Color(0, 255, 128));
		lblXC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_1.setBounds(30, 97, 77, 33);
		panel_1.add(lblXC_1_1);
		
		JLabel lblXC_1_2 = new JLabel("18:15");
		lblXC_1_2.setOpaque(true);
		lblXC_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_2.setBackground(new Color(0, 255, 128));
		lblXC_1_2.setBounds(156, 97, 77, 33);
		panel_1.add(lblXC_1_2);
		
		JLabel lblXC_1_3 = new JLabel("19:20");
		lblXC_1_3.setOpaque(true);
		lblXC_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_3.setBackground(new Color(0, 255, 128));
		lblXC_1_3.setBounds(277, 97, 77, 33);
		panel_1.add(lblXC_1_3);
		
		JLabel lblXC_1_4 = new JLabel("20:20");
		lblXC_1_4.setOpaque(true);
		lblXC_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_4.setBackground(new Color(0, 255, 128));
		lblXC_1_4.setBounds(396, 97, 77, 33);
		panel_1.add(lblXC_1_4);
		
		JLabel lblXC_1_5 = new JLabel("21:25");
		lblXC_1_5.setOpaque(true);
		lblXC_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_5.setBackground(new Color(0, 255, 128));
		lblXC_1_5.setBounds(513, 97, 77, 33);
		panel_1.add(lblXC_1_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(700, 250));
		panel_2.setForeground(new Color(64, 0, 64));
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2);
		
		JLabel lblPhim_2 = new JLabel("Pororo: Hành trình siêu sao");
		lblPhim_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_2.setBounds(20, 22, 431, 40);
		panel_2.add(lblPhim_2);
		
		JLabel lblXC_2_1 = new JLabel("17:15");
		lblXC_2_1.setOpaque(true);
		lblXC_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_1.setBackground(new Color(0, 255, 128));
		lblXC_2_1.setBounds(30, 97, 77, 33);
		panel_2.add(lblXC_2_1);
		
		JLabel lblXC_2_2 = new JLabel("18:15");
		lblXC_2_2.setOpaque(true);
		lblXC_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_2.setBackground(new Color(0, 255, 128));
		lblXC_2_2.setBounds(156, 97, 77, 33);
		panel_2.add(lblXC_2_2);
		
		JLabel lblXC_2_3 = new JLabel("19:20");
		lblXC_2_3.setOpaque(true);
		lblXC_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_3.setBackground(new Color(0, 255, 128));
		lblXC_2_3.setBounds(277, 97, 77, 33);
		panel_2.add(lblXC_2_3);
		
		JLabel lblXC_2_4 = new JLabel("20:20");
		lblXC_2_4.setOpaque(true);
		lblXC_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_4.setBackground(new Color(0, 255, 128));
		lblXC_2_4.setBounds(396, 97, 77, 33);
		panel_2.add(lblXC_2_4);
		
		JLabel lblXC_2_5 = new JLabel("21:25");
		lblXC_2_5.setOpaque(true);
		lblXC_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_5.setBackground(new Color(0, 255, 128));
		lblXC_2_5.setBounds(513, 97, 77, 33);
		panel_2.add(lblXC_2_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(700, 250));
		panel_3.setForeground(new Color(64, 0, 64));
		panel_3.setBackground(SystemColor.menu);
		panel.add(panel_3);
		
		JLabel lblPhim_3 = new JLabel("Spy × Family Code: White");
		lblPhim_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_3.setBounds(20, 22, 431, 40);
		panel_3.add(lblPhim_3);
		
		JLabel lblXC_3_1 = new JLabel("17:15");
		lblXC_3_1.setOpaque(true);
		lblXC_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_1.setBackground(new Color(0, 255, 128));
		lblXC_3_1.setBounds(30, 97, 77, 33);
		panel_3.add(lblXC_3_1);
		
		JLabel lblXC_3_2 = new JLabel("18:15");
		lblXC_3_2.setOpaque(true);
		lblXC_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_2.setBackground(new Color(0, 255, 128));
		lblXC_3_2.setBounds(156, 97, 77, 33);
		panel_3.add(lblXC_3_2);
		
		JLabel lblXC_3_3 = new JLabel("19:20");
		lblXC_3_3.setOpaque(true);
		lblXC_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_3.setBackground(new Color(0, 255, 128));
		lblXC_3_3.setBounds(277, 97, 77, 33);
		panel_3.add(lblXC_3_3);
		
		JLabel lblXC_3_4 = new JLabel("20:20");
		lblXC_3_4.setOpaque(true);
		lblXC_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_4.setBackground(new Color(0, 255, 128));
		lblXC_3_4.setBounds(396, 97, 77, 33);
		panel_3.add(lblXC_3_4);
		
		JLabel lblXC_3_5 = new JLabel("21:25");
		lblXC_3_5.setOpaque(true);
		lblXC_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_5.setBackground(new Color(0, 255, 128));
		lblXC_3_5.setBounds(513, 97, 77, 33);
		panel_3.add(lblXC_3_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(700, 250));
		panel_4.setForeground(new Color(64, 0, 64));
		panel_4.setBackground(new Color(255, 255, 255));
		panel.add(panel_4);
		
		JLabel lblPhim_4 = new JLabel("Katak và sứ mệnh chinh phục đại dương");
		lblPhim_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_4.setBounds(20, 22, 485, 40);
		panel_4.add(lblPhim_4);
		
		JLabel lblXC_4_1 = new JLabel("17:15");
		lblXC_4_1.setOpaque(true);
		lblXC_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_1.setBackground(new Color(0, 255, 128));
		lblXC_4_1.setBounds(30, 97, 77, 33);
		panel_4.add(lblXC_4_1);
		
		JLabel lblXC_4_2 = new JLabel("18:15");
		lblXC_4_2.setOpaque(true);
		lblXC_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_2.setBackground(new Color(0, 255, 128));
		lblXC_4_2.setBounds(156, 97, 77, 33);
		panel_4.add(lblXC_4_2);
		
		JLabel lblXC_4_3 = new JLabel("19:20");
		lblXC_4_3.setOpaque(true);
		lblXC_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_3.setBackground(new Color(0, 255, 128));
		lblXC_4_3.setBounds(277, 97, 77, 33);
		panel_4.add(lblXC_4_3);
		
		JLabel lblXC_4_4 = new JLabel("20:20");
		lblXC_4_4.setOpaque(true);
		lblXC_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_4.setBackground(new Color(0, 255, 128));
		lblXC_4_4.setBounds(396, 97, 77, 33);
		panel_4.add(lblXC_4_4);
		
		JLabel lblXC_4_5 = new JLabel("21:25");
		lblXC_4_5.setOpaque(true);
		lblXC_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_5.setBackground(new Color(0, 255, 128));
		lblXC_4_5.setBounds(513, 97, 77, 33);
		panel_4.add(lblXC_4_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setPreferredSize(new Dimension(700, 250));
		panel_5.setForeground(new Color(64, 0, 64));
		panel_5.setBackground(SystemColor.menu);
		panel.add(panel_5);
		
		JLabel lblPhim_5 = new JLabel("Vòng vây cá mập");
		lblPhim_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_5.setBounds(20, 22, 431, 40);
		panel_5.add(lblPhim_5);
		
		JLabel lblXC_5_1 = new JLabel("17:15");
		lblXC_5_1.setOpaque(true);
		lblXC_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_1.setBackground(new Color(0, 255, 128));
		lblXC_5_1.setBounds(30, 97, 77, 33);
		panel_5.add(lblXC_5_1);
		
		JLabel lblXC_5_2 = new JLabel("18:15");
		lblXC_5_2.setOpaque(true);
		lblXC_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_2.setBackground(new Color(0, 255, 128));
		lblXC_5_2.setBounds(156, 97, 77, 33);
		panel_5.add(lblXC_5_2);
		
		JLabel lblXC_5_3 = new JLabel("19:20");
		lblXC_5_3.setOpaque(true);
		lblXC_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_3.setBackground(new Color(0, 255, 128));
		lblXC_5_3.setBounds(277, 97, 77, 33);
		panel_5.add(lblXC_5_3);
		
		JLabel lblXC_5_4 = new JLabel("20:20");
		lblXC_5_4.setOpaque(true);
		lblXC_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_4.setBackground(new Color(0, 255, 128));
		lblXC_5_4.setBounds(396, 97, 77, 33);
		panel_5.add(lblXC_5_4);
		
		JLabel lblXC_5_5 = new JLabel("21:25");
		lblXC_5_5.setOpaque(true);
		lblXC_5_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_5.setBackground(new Color(0, 255, 128));
		lblXC_5_5.setBounds(513, 97, 77, 33);
		panel_5.add(lblXC_5_5);
		
		
		panel_day = new JPanel();
		panel_day.setBackground(new Color(255, 128, 0));
		panel_day.setBounds(0, 0, 780, 90);
		panel_main.add(panel_day);
		panel_day.setLayout(new GridLayout(1, 5, 0, 0));
		
		panelDay_1 = new JPanel();
		panelDay_1.setBackground(new Color(128, 0, 255));
		panel_day.add(panelDay_1);
		panelDay_1.setLayout(null);
		panelDay_1.addMouseListener(this);
		
		
		LocalDate date = LocalDate.parse("30/04/2024", dtf);
		JLabel lblDay_1 = new JLabel("New label");
		lblDay_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_1.setForeground(new Color(255, 255, 255));
		lblDay_1.setBackground(new Color(255, 255, 255));
		lblDay_1.setBounds(35, 23, 87, 28);
		lblDay_1.setText(date.getDayOfMonth() + "/" + date.getMonthValue());
		panelDay_1.add(lblDay_1);
		
		JLabel lblDayWeek_1 = new JLabel("Hôm nay");
		lblDayWeek_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_1.setForeground(new Color(255, 255, 255));
		lblDayWeek_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_1.setBounds(45, 54, 64, 26);
		panelDay_1.add(lblDayWeek_1);
		
		panelDay_2 = new JPanel();
		panelDay_2.setForeground(new Color(0, 0, 0));
		panelDay_2.setLayout(null);
		panelDay_2.setBackground(new Color(250, 250, 250));
		panelDay_2.addMouseListener(this);
		panel_day.add(panelDay_2);
		
		JLabel lblDay_2 = new JLabel("New label");
		lblDay_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_2.setForeground(new Color(0, 0, 0));
		lblDay_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_2.setBackground(Color.WHITE);
		lblDay_2.setBounds(35, 23, 87, 28);
		lblDay_2.setText(date.plusDays(1).getDayOfMonth() + "/" + date.plusDays(1).getMonthValue());
		panelDay_2.add(lblDay_2);
		
		JLabel lblDayWeek_2 = new JLabel("");
		lblDayWeek_2.setText(getDayWeeks(date.plusDays(1).getDayOfWeek() + ""));
		lblDayWeek_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_2.setForeground(new Color(0, 0, 0));
		lblDayWeek_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_2.setBounds(45, 54, 77, 26);
		panelDay_2.add(lblDayWeek_2);
		
		panelDay_3 = new JPanel();
		panelDay_3.setLayout(null);
		panelDay_3.setBackground(new Color(255, 255, 255));
		panelDay_3.addMouseListener(this);
		panel_day.add(panelDay_3);
		
		JLabel lblDay_3 = new JLabel("New label");
		lblDay_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_3.setForeground(new Color(0, 0, 0));
		lblDay_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_3.setBackground(Color.WHITE);
		lblDay_3.setBounds(35, 23, 87, 28);
		lblDay_3.setText(date.plusDays(2).getDayOfMonth() + "/" + date.plusDays(2).getMonthValue());
		panelDay_3.add(lblDay_3);
		
		JLabel lblDayWeek_3 = new JLabel("Hôm nay");
		lblDayWeek_3.setText(getDayWeeks(date.plusDays(2).getDayOfWeek() + ""));
		lblDayWeek_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_3.setForeground(new Color(0, 0, 0));
		lblDayWeek_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_3.setBounds(45, 54, 64, 26);
		panelDay_3.add(lblDayWeek_3);
		
		panelDay_4 = new JPanel();
		panelDay_4.setLayout(null);
		panelDay_4.setBackground(new Color(250, 250, 250));
		panelDay_4.addMouseListener(this);
		panel_day.add(panelDay_4);
		
		JLabel lblDay_4 = new JLabel("New label");
		lblDay_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_4.setForeground(new Color(0, 0, 0));
		lblDay_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_4.setBackground(Color.WHITE);
		lblDay_4.setBounds(35, 23, 87, 28);
		lblDay_4.setText(date.plusDays(3).getDayOfMonth() + "/" + date.plusDays(3).getMonthValue());
		panelDay_4.add(lblDay_4);
		
		JLabel lblDayWeek_4 = new JLabel("Hôm nay");
		lblDayWeek_4.setText(getDayWeeks(date.plusDays(3).getDayOfWeek() + ""));
		lblDayWeek_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_4.setForeground(new Color(0, 0, 0));
		lblDayWeek_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_4.setBounds(45, 54, 64, 26);
		panelDay_4.add(lblDayWeek_4);
		
		panelDay_5 = new JPanel();
		panelDay_5.setLayout(null);
		panelDay_5.setBackground(new Color(255, 255, 255));
		panelDay_5.addMouseListener(this);
		panel_day.add(panelDay_5);
		
		JLabel lblDay_5 = new JLabel("New label");
		lblDay_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_5.setForeground(new Color(0, 0, 0));
		lblDay_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_5.setBackground(Color.WHITE);
		lblDay_5.setBounds(35, 23, 87, 28);
		lblDay_5.setText(date.plusDays(4).getDayOfMonth() + "/" + date.plusDays(4).getMonthValue());
		panelDay_5.add(lblDay_5);
		
		JLabel lblDayWeek_5 = new JLabel("Hôm nay");
		lblDayWeek_5.setText(getDayWeeks(date.plusDays(4).getDayOfWeek() + ""));
		lblDayWeek_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_5.setForeground(new Color(0, 0, 0));
		lblDayWeek_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_5.setBounds(45, 54, 64, 26);
		panelDay_5.add(lblDayWeek_5);
		
		panel_form = new JPanel();
		panel_form.setBackground(new Color(102, 51, 153));
		panel_form.setBounds(874, 282, 421, 504);
		add(panel_form);
		panel_form.setLayout(null);
		
		JLabel lblPhim = new JLabel("Phim:");
		lblPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhim.setForeground(new Color(255, 255, 255));
		lblPhim.setBackground(new Color(255, 255, 255));
		lblPhim.setBounds(28, 133, 98, 20);
		panel_form.add(lblPhim);
		
		JLabel lblNgayChieu = new JLabel("Ngày chiếu:");
		lblNgayChieu.setForeground(Color.WHITE);
		lblNgayChieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayChieu.setBackground(Color.WHITE);
		lblNgayChieu.setBounds(28, 200, 98, 20);
		panel_form.add(lblNgayChieu);
		
		JLabel lblThoiGian = new JLabel("Thời gian:");
		lblThoiGian.setForeground(Color.WHITE);
		lblThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThoiGian.setBackground(Color.WHITE);
		lblThoiGian.setBounds(28, 255, 98, 20);
		panel_form.add(lblThoiGian);
		
		textFieldNgayChieu = new JTextField();
		textFieldNgayChieu.setBounds(164, 198, 185, 30);
		panel_form.add(textFieldNgayChieu);
		textFieldNgayChieu.setColumns(10);
		
		textFieldPhim = new JTextField();
		textFieldPhim.setColumns(10);
		textFieldPhim.setBounds(164, 131, 223, 30);
		textFieldPhim.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				size = listSuatChieus.size();
				size++;
				String maSC = "SC";
				if(size < 10) {
					maSC+= "0" + size;
				}else {
					maSC+= size + "";
				}
				textFieldMaSC.setText(maSC);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_form.add(textFieldPhim);
		
		textFieldThoiGian = new JTextField();
		textFieldThoiGian.setColumns(10);
		textFieldThoiGian.setBounds(164, 253, 185, 30);
		panel_form.add(textFieldThoiGian);
		
		comboBoxPhongChieu = new JComboBox();
		comboBoxPhongChieu.setBounds(164, 319, 223, 30);
		comboBoxPhongChieu.addItem("");
		
		//addItem
		for (PhongChieu phongChieu : listPhongChieus) {
			comboBoxPhongChieu.addItem(phongChieu.getMaPhongChieu());
		}
		
		panel_form.add(comboBoxPhongChieu);
		
		//Thêm sự kiện
		
		ActionListener ac = new control_XuatChieu(this);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(new Color(255, 165, 0));
		btnThem.setBounds(28, 424, 85, 37);
		btnThem.addActionListener(ac);
		panel_form.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBackground(new Color(255, 165, 0));
		btnSua.setBounds(123, 424, 85, 37);
		btnSua.addActionListener(ac);
		panel_form.add(btnSua);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(new Color(255, 165, 0));
		btnXoa.setBounds(218, 424, 85, 37);
		btnXoa.addActionListener(ac);
		panel_form.add(btnXoa);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(new Color(255, 165, 0));
		btnLamMoi.setBounds(313, 423, 85, 37);
		btnLamMoi.addActionListener(ac);
		panel_form.add(btnLamMoi);
		
		JButton btnDate = new JButton("");
		btnDate.setBackground(new Color(102, 51, 150));
		btnDate.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/icons8-date-26.png")));
		btnDate.setBounds(359, 200, 28, 28);
		btnDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!flat1) { 
					showDate();
					flat1 = true;
				}else {
					dateChooser.hidePopup();
					flat1 = false;
				}
			}
		});
		panel_form.add(btnDate);
		
		JButton btnTime = new JButton("");
		btnTime.setBackground(new Color(102, 51, 150));
		btnTime.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/icons8-time-26.png")));
		btnTime.setBounds(359, 255, 28, 28);
		btnTime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				timePicker.showPopup(this, 100, 100);
				if(!flat2) { 
					showTime();
					flat2 = true;
				}else {
					dateChooser.hidePopup();
					flat2 = false;
				}
			}
		});
		panel_form.add(btnTime);
		
		JLabel lblPhngChieu = new JLabel("Mã Phòng chiếu:");
		lblPhngChieu.setForeground(Color.WHITE);
		lblPhngChieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhngChieu.setBackground(Color.WHITE);
		lblPhngChieu.setBounds(30, 322, 118, 20);
		panel_form.add(lblPhngChieu);
		
		JLabel lblMSutChiu = new JLabel("Mã suất chiếu:");
		lblMSutChiu.setForeground(Color.WHITE);
		lblMSutChiu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSutChiu.setBackground(Color.WHITE);
		lblMSutChiu.setBounds(28, 74, 118, 20);
		panel_form.add(lblMSutChiu);
		
		textFieldMaSC = new JTextField();
		textFieldMaSC.setEditable(false);
		textFieldMaSC.setBackground(new Color(240, 240, 240));
		textFieldMaSC.setColumns(10);
		textFieldMaSC.setBounds(164, 70, 223, 30);
		panel_form.add(textFieldMaSC);
		
		JPanel panel_find = new JPanel();
		panel_find.setBackground(new Color(102, 51, 153));
		panel_find.setBounds(874, 120, 417, 90);
		add(panel_find);
		panel_find.setLayout(null);
		
		JLabel lblFind = new JLabel("Nhập tên phim:");
		lblFind.setForeground(new Color(255, 255, 255));
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFind.setBounds(21, 10, 137, 20);
		panel_find.add(lblFind);
		
		textFieldTim = new JTextField();
		textFieldTim.setBounds(21, 40, 325, 34);
		panel_find.add(textFieldTim);
		textFieldTim.setColumns(10);
		
		btnTim = new JButton("");
		btnTim.setBackground(new Color(102, 51, 120));
		btnTim.setIcon(new ImageIcon(GUI_SuatChieu.class.getResource("/img/icons8-find-30.png")));
		btnTim.setBounds(352, 40, 34, 34);
		btnTim.addActionListener(ac);
		panel_find.add(btnTim);
		
		JPanel panelMode = new JPanel();
		panelMode.setBackground(new Color(102, 51, 153));
		panelMode.setBounds(874, 230, 417, 29);
		add(panelMode);
		panelMode.setLayout(null);
		
		JLabel lblMode = new JLabel("Chế độ:");
		lblMode.setForeground(new Color(255, 255, 255));
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMode.setBounds(35, 0, 58, 29);
		panelMode.add(lblMode);
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		rdbtnXem = new JRadioButton("Xem");
		rdbtnXem.setFocusPainted(false);
		rdbtnXem.setSelected(true);
		rdbtnXem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnXem.setForeground(new Color(255, 255, 255));
		rdbtnXem.setBackground(new Color(102, 51, 153));
		rdbtnXem.setBounds(155, 0, 103, 29);
		rdbtnXem.addActionListener(ac);
		panelMode.add(rdbtnXem);
		btnGroup.add(rdbtnXem);
		
		rdbtnChinhSua = new JRadioButton("Chỉnh sửa");
		rdbtnChinhSua.setFocusPainted(false);
		rdbtnChinhSua.setForeground(Color.WHITE);
		rdbtnChinhSua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnChinhSua.setBackground(new Color(102, 51, 153));
		rdbtnChinhSua.setBounds(274, 0, 103, 29);
		rdbtnChinhSua.addActionListener(ac);
		panelMode.add(rdbtnChinhSua);
		btnGroup.add(rdbtnChinhSua);
		
		panel_day.setVisible(true);
		panel_form.setVisible(false);
		
		
	}
	
	public String getDayWeeks(String day) {
		String s = "Thứ ";
		if(day.equalsIgnoreCase("Monday")) {
			s += "Hai" ;
		}else if(day.equalsIgnoreCase("Tuesday")){
			s += "Ba";
		}else if(day.equalsIgnoreCase("Wednesday")){
			s += "Tư";
		}else if(day.equalsIgnoreCase("Thursday")){
			s += "Năm";
		}else if(day.equalsIgnoreCase("Friday")){
			s += "Sáu";
		}else if(day.equalsIgnoreCase("Saturday")){
			s += "Bảy";
		}else if(day.equalsIgnoreCase("Sunday")){
			s = "Chủ Nhật";
		}
		
		return s;
	}
	
	public void showTime() {
		timePicker.showPopup(this, (getWidth() - timePicker.getPreferredSize().width) / 2, (getHeight() - timePicker.getPreferredSize().height) / 2);
		timePicker.addEventTimePicker(new EventTimePicker() {
			
			@Override
			public void timeSelected(String arg0) {
//				System.out.println(arg0);
				textFieldThoiGian.setText(arg0.substring(0, 5));
			}
		});
	}
	
	public void showDate() {
		dateChooser.showPopup(this, (getWidth() - dateChooser.getPreferredSize().width) / 2, (getHeight() - dateChooser.getPreferredSize().height) / 2);
		if(dateChooser.isFocusable()) {
			dateChooser.setTextRefernce(textFieldNgayChieu);
		}
		
	}
	
	public boolean chkExist(String tenPhim) {
		for (Phim phim : listPhims) {
			if(phim.getTenPhim().equalsIgnoreCase(tenPhim)) {
				for (SuatChieu suatChieu : listSuatChieus) {
					if(suatChieu.getPhim().getTenPhim().equalsIgnoreCase(tenPhim)) {
						JOptionPane.showMessageDialog(this, "label");
						return true;
					}
				}
				JOptionPane.showMessageDialog(this, "panel");
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPhim(String tenPhim) {
		for (Phim phim : listPhims) {
			if(phim.getTenPhim().equals(tenPhim)) {
				return true;
			}
		}
		return false;
	}
	
	public void checkPhong(String maPhong) {
		
	}
	
	public boolean chkRegex() {
		
		//Check phim
		if(textFieldPhim.getText().equals("")) {
			textFieldPhim.requestFocusInWindow();
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}else {
			if(!checkPhim(textFieldPhim.getText())) {
				JOptionPane.showMessageDialog(this, "Phim không tồn tại");
				textFieldPhim.requestFocusInWindow();
				return false;
			}
		}
		
		//check ngay
		if(textFieldNgayChieu.getText().equals("")) {
			textFieldNgayChieu.requestFocusInWindow();
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}else {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			
			try {
				LocalDate date = LocalDate.parse(textFieldNgayChieu.getText(), dtf);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
				textFieldNgayChieu.requestFocusInWindow();
				return false;
			}
		}
		
		//check gio
		if(textFieldThoiGian.getText().equals("")) {
			textFieldThoiGian.requestFocusInWindow();
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}else {
			try {
				LocalTime localTime = LocalTime.parse(textFieldThoiGian.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Giờ không hợp lệ");
				textFieldThoiGian.requestFocusInWindow();
				return false;
			}
		}
		
		if(comboBoxPhongChieu.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng chiếu");
			return false;
		}
		
		return true;
	}
	
	//Thêm vào bảng
	public void addToTable(SuatChieu suatChieu) {
		model.addRow(new String[]
				{
						suatChieu.getMaSuatChieu(), suatChieu.getNgayChieu().format(dtf), suatChieu.getGioChieu() + "",
						suatChieu.getPhim().getTenPhim(), suatChieu.getPhongChieu().getTenPhongChieu()
				});
		System.out.println(suatChieu.toString());
		suatChieu_DAO.themSuatChieu(suatChieu);
	}
	
	public SuatChieu getSuatChieuJTF() {
		String maSuatChieu = textFieldMaSC.getText();
		LocalDate ngayChieu = LocalDate.parse(textFieldNgayChieu.getText(), dtf);
		System.out.println(ngayChieu);
		LocalTime gioChieu = LocalTime.parse(textFieldThoiGian.getText());
		String tenPhim = textFieldPhim.getText();
		Phim phim = null;
		for (Phim p : listPhims) {
			if(p.getTenPhim().endsWith(tenPhim)) {
				phim = p;
				break;
			}
		}
		String maPhongChieu = comboBoxPhongChieu.getSelectedItem().toString();
		PhongChieu phongChieu = null;
		for (PhongChieu phChieu : listPhongChieus) {
			if(phChieu.getMaPhongChieu().equals(maPhongChieu)) {
				phongChieu = phChieu;
				break;
			}
		}
		SuatChieu suatChieu = new SuatChieu(maSuatChieu, ngayChieu, gioChieu, phim, phongChieu);
		return suatChieu;
	}
	
	public void add() {
		if(chkRegex()) {
			size = listSuatChieus.size();
			size++;
			String maSuatChieu = "SC";
			if(size < 10) {
				maSuatChieu+= "0" + size;
			}else {
				maSuatChieu+= size + "";
			}
			
			LocalDate ngayChieu = LocalDate.parse(textFieldNgayChieu.getText(), dtf);
			LocalTime gioChieu = LocalTime.parse(textFieldThoiGian.getText());
			String tenPhim = textFieldPhim.getText();
			Phim phim = null;
			for (Phim p : listPhims) {
				if(p.getTenPhim().endsWith(tenPhim)) {
					phim = p;
					break;
				}
			}
			String maPhongChieu = comboBoxPhongChieu.getSelectedItem().toString();
			PhongChieu phongChieu = null;
			for (PhongChieu phChieu : listPhongChieus) {
				if(phChieu.getMaPhongChieu().equals(maPhongChieu)) {
					phongChieu = phChieu;
					break;
				}
			}
			SuatChieu suatChieu = new SuatChieu(maSuatChieu, ngayChieu, gioChieu, phim, phongChieu);
			addToTable(suatChieu);
			lamMoi();
		}
	}
	
	//Chức năng tìm kiếm
	//*reset tabel
	public void resetTabel() {
		int length_row = model.getRowCount();
		
		for(int i = 0; i < length_row; i++) {
			model.removeRow(0);
		}
		
		for (SuatChieu suatChieu : listSuatChieus) {
			model.addRow(new String[]
					{
							suatChieu.getMaSuatChieu(), suatChieu.getNgayChieu().format(dtf), suatChieu.getGioChieu() + "",
							suatChieu.getPhim().getTenPhim(), suatChieu.getPhongChieu().getMaPhongChieu()
					});
		}
	}
	
	//*Tìm kiếm
	public void timKiem() {
		if(textFieldTim.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập thông tin tìm kiếm!");
		}else {
			if(rdbtnChinhSua.isSelected()) {
				resetTabel();
				
				int length_row = model.getRowCount();
				for(int i = 0; i < length_row; i++) {
					String tenPhim = model.getValueAt(i, 3) + "";
					System.out.println(tenPhim + i);
					if(!tenPhim.equalsIgnoreCase(textFieldTim.getText())) {
						model.removeRow(i);
						i--;
						length_row--;
					}
					
				}
			}else {
				for (SuatChieu suatChieu : listSuatChieus) {
					if(suatChieu.getPhim().getTenPhim().equalsIgnoreCase(textFieldTim.getText())) {
						Phim phim = suatChieu.getPhim();
						ArrayList<LocalDate> localDate = getDsNgayChieu(phim);
						for (LocalDate localDate2 : localDate) {
							ArrayList<LocalTime> localTimes = getDsGioChieu(phim, localDate2);
							JPanel panelTim = new JPanel();
							panelTim.setBackground(new Color(102, 51, 153));
							scrollPane.setViewportView(panelTim);
							panelTim.setLayout(new GridLayout(7, 1, 0, 0));
							crePanelItem(phim.getTenPhim(), localDate, localTimes, 2, panelTim);
						}
					}else {
						
					}
				}
			}
		}
	}
	
	
	
	//Chức năng sửa
	public void thucHienSua() {
		if(textFieldMaSC.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn xuất chiếu cần xoá");
			
		}else {
			suaSuatChieu(textFieldMaSC.getText());
		}
		
		lamMoi();
	}
	
	public boolean suaSuatChieu(String maSC) {
		SuatChieu scFix = getSuatChieuJTF();
		int i_row = -1;
		int lengh_row = model.getRowCount();
		for(int i = 0; i < lengh_row; i++) {
			String maSuatC = model.getValueAt(i, 0) + "";
			if(maSuatC.equals(maSC)) {
				i_row = i;
				break;
			}
		}
		if(i_row != -1) {
			for (SuatChieu suatChieu : listSuatChieus) {
				if(suatChieu.getMaSuatChieu().equals(scFix.getMaSuatChieu())) {
					suatChieu_DAO.capNhatSuatChieu(scFix);
					listSuatChieus.remove(suatChieu);
					listSuatChieus.add(scFix);
					capNhatBang(i_row, scFix);
					return true;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "Suất chiếu không tồn tại");
		return false;
	}
	
	public void capNhatBang(int i_row, SuatChieu suatChieu) {
		model.setValueAt(suatChieu.getMaSuatChieu(), i_row, 0);
		model.setValueAt(suatChieu.getNgayChieu().format(dtf), i_row, 1);
		model.setValueAt(suatChieu.getGioChieu(), i_row, 2);
		model.setValueAt(suatChieu.getPhim().getTenPhim(), i_row, 3);
		model.setValueAt(suatChieu.getPhongChieu().getMaPhongChieu(), i_row, 4);
	}
	
	public SuatChieu laySCTuTabel(int i) {
		String maSC = model.getValueAt(i, 0) + "";
		LocalDate ngayChieu = LocalDate.parse(model.getValueAt(i, 1) + "", dtf);
		LocalTime gioChieu = LocalTime.parse(model.getValueAt(i, 2) + "");
		String tenPhim = model.getValueAt(i, 3) + "";
		Phim phim = null;
		for (Phim p : listPhims) {
			if(p.getTenPhim().endsWith(tenPhim)) {
				phim = p;
				break;
			}
		}
		String maPhong = model.getValueAt(i, 4) + "";
		PhongChieu phongChieu = null;
		for (PhongChieu phChieu : listPhongChieus) {
			if(phChieu.getMaPhongChieu().equals(maPhong)) {
				phongChieu = phChieu;
				break;
			}
		}
		
		SuatChieu suatChieu = new SuatChieu(maSC, ngayChieu, gioChieu, phim, phongChieu);
		return suatChieu;
				
	}
	
	//**Chức năng xoá
	public boolean xoaSuatChieu(String maSC) {
		int length_row = model.getRowCount();
		
		for(int i = 0; i < length_row; i++) {
			String maSuatChieu = model.getValueAt(i, 0) + "";
			if(maSuatChieu.equalsIgnoreCase(maSC)) {
				int select = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá?");
				if(select == JOptionPane.YES_OPTION) {
					SuatChieu suatChieu = laySCTuTabel(i);
					suatChieu_DAO.xoaSuatChieu(maSuatChieu);
					listSuatChieus.remove(suatChieu);
					model.removeRow(i);
					return true;
				}
			}
		}
		
		JOptionPane.showMessageDialog(this, "Suất chiếu không tồn tại!");
		return false;
	}
	
	public void thucHienXoa() {
		if(textFieldMaSC.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn xuất chiếu cần xoá");
			
		}else {
			xoaSuatChieu(textFieldMaSC.getText());
		}
		
		lamMoi();
	}
	
	public void lamMoi() {
		textFieldMaSC.setText("");
		textFieldPhim.setText("");
		textFieldNgayChieu.setText("");
		textFieldThoiGian.setText("");
		comboBoxPhongChieu.setSelectedIndex(-1);
	}
	
	public void crePanelItem(String tenPhim, ArrayList<LocalDate> ngayChieu, ArrayList<LocalTime> gioChieu, int flat, JPanel panel) {
		JPanel panel_1 = new JPanel();
		if(flat % 2 == 0) panel_1.setBackground(new Color(240, 240, 240));
		else panel_1.setBackground(new Color(250, 250, 250));
		panel_1.setForeground(new Color(64, 0, 64));
		panel_1.setPreferredSize(new Dimension(700, 250));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPhim_1 = new JLabel(tenPhim);
		lblPhim_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_1.setBounds(20, 22, 431, 40);
		panel_1.add(lblPhim_1);
		
		int arr[] = new int[] {30, 156, 277, 396, 513};
		
		int i = 0;
		for (LocalTime localTime : gioChieu) {
			JLabel lblXC_1_1 = new JLabel(localTime.toString());
			lblXC_1_1.setOpaque(true);
			lblXC_1_1.setBackground(new Color(0, 255, 128));
			lblXC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblXC_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblXC_1_1.setBounds(arr[i], 97, 77, 33);
			panel_1.add(lblXC_1_1);
			i++;
		}
	}
	
	
	//Tạo bảng
	public void creTable() {
		model = new DefaultTableModel();
		model.addColumn("Mã Suất Chiếu");
		model.addColumn("Ngày Chiếu");
		model.addColumn("Giờ chiếu");
		model.addColumn("Tên phim");
		model.addColumn("Phòng chiếu");
		table_VePhim = new JTable(model);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (SuatChieu suatChieu : listSuatChieus) {
			model.addRow(new String[]
					{
							suatChieu.getMaSuatChieu(), suatChieu.getNgayChieu().format(dtf), suatChieu.getGioChieu() + "",
							suatChieu.getPhim().getTenPhim(), suatChieu.getPhongChieu().getMaPhongChieu()
					});
		}
		
		table_VePhim.getTableHeader().setBackground(new Color(102,51,153));
		table_VePhim.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
		table_VePhim.getTableHeader().setForeground(Color.WHITE);
	}
	
	
	//Chế độ
	public void modeEdit() {
		
		scrollPane.setViewportView(table_VePhim);
		panel_day.setVisible(false);
		panel_form.setVisible(true);
	}
	
	public void modeView() {
		scrollPane.setViewportView(panel);
		panel_day.setVisible(true);
		panel_form.setVisible(false);
	}
	
	public ArrayList<Phim> getDsPhimSC() {
		ArrayList<Phim> dsPhim = listPhims;
		ArrayList<Phim> dsP = new ArrayList<>();
//		dsP.add(listSuatChieus.get(0).getPhim());
		for (SuatChieu suatChieu : listSuatChieus) {
			System.out.println("size: " + dsP.size());
			for (Phim phim : dsPhim) {
				if(phim.equals(suatChieu.getPhim())) {
					dsP.add(phim);
					dsPhim.remove(phim);
					break;
				}
			}
		}
		return dsP;
	}
	
	public ArrayList<LocalTime> getDsGioChieu(Phim phim, LocalDate ngayChieu) {
		ArrayList<LocalTime> n = new ArrayList<>();
		
		int i = 0;
		for (SuatChieu suatChieu : listSuatChieus) {
			if(suatChieu.getPhim().equals(phim) && suatChieu.getNgayChieu().format(dtf).equals(ngayChieu.format(dtf))) {
				n.add(suatChieu.getGioChieu());
			}
		}
		
		return n;
	}
	
	public ArrayList<LocalDate> getDsNgayChieu(Phim phim) {
		ArrayList<LocalDate> n = new ArrayList<>();
		
		
		for (SuatChieu suatChieu : listSuatChieus) {
			int i = 0;
			if(suatChieu.getPhim().equals(phim)) {
				for (LocalDate localDate : n) {
					if(suatChieu.getNgayChieu().format(dtf).equals(localDate.format(dtf))) i++;
				}
				if(i == 0) n.add(suatChieu.getNgayChieu());
			}
		}
		
		return n;
	}
	
	
	//Sự kiện click chuột jtabel
	@Override
	public void mouseClicked(MouseEvent e) {
		Object ac = e.getSource();
		if(ac.equals(panelDay_1)) {
			scrollPane.setViewportView(panel);
		}else if(ac.equals(panelDay_2)) {
			scrollPane.setViewportView(panel1);
		}else if(ac.equals(panelDay_3)) {
			scrollPane.setViewportView(panel2);
		}else if(ac.equals(panelDay_4)) {
			scrollPane.setViewportView(panel3);
		}else if(ac.equals(panelDay_5)) {
			scrollPane.setViewportView(panel4);
		}else {
			int i_row = table_VePhim.getSelectedRow();
			textFieldMaSC.setText(model.getValueAt(i_row, 0) + "");
			textFieldNgayChieu.setText(model.getValueAt(i_row, 1) + "");
			textFieldThoiGian.setText(model.getValueAt(i_row, 2) + "");
			textFieldPhim.setText(model.getValueAt(i_row, 3) + "");
			comboBoxPhongChieu.setSelectedItem(model.getValueAt(i_row, 4));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	 
