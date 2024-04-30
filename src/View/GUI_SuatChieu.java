package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

public class GUI_XuatChieu extends JPanel {
	private JTextField textField;
	private JTextField textFieldNgayChieu;
	private JTextField textFieldPhim;
	private JTextField textFieldThoiGian;
    private JLabel lblNewLabel;
	private JPanel panel_main;
    private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblPhim_1;
	private JLabel lblXC_1_1;
    private JLabel lblXC_1_2;
	private JLabel lblXC_1_3;
	private JLabel lblXC_1_4;
	private JLabel lblXC_1_5;
	private JPanel panel_2;
	private JLabel lblPhim_2;
	private JLabel lblXC_2_1;
	private JLabel lblXC_2_2;
	private JLabel lblXC_2_3;
	private JLabel lblXC_2_4;
	private JLabel lblXC_2_5;
	private JPanel panel_3;
	private JLabel lblPhim_3;
	private JLabel lblXC_3_1;
	private JLabel lblXC_3_2;
	private JLabel lblXC_3_3;
	private JLabel lblXC_3_4;
	private JLabel lblXC_3_5;
	private JPanel panel_4;
	private JLabel lblPhim_4;
    private JLabel lblXC_4_1;
	private JLabel lblXC_4_2;
    private JLabel lblXC_4_3;
	private JLabel lblXC_4_4;
	private JLabel lblXC_4_5;
	private JPanel panel_5;
    private JLabel lblPhim_5;
    private JLabel lblXC_5_1;
    private JLabel lblXC_5_2;
	private JLabel lblXC_5_3;
    private JLabel lblXC_5_4;
	private JLabel lblXC_5_5;
	private JPanel panel_day;
	private JPanel panelDay_1;
	private LocalDate date;
    private JLabel lblDay_1;
	private JLabel lblDayWeek_1;
	private JPanel panelDay_2;
    private JLabel lblDay_2;
	private JLabel lblDayWeek_2;
	private JPanel panelDay_3;
	private JLabel lblDay_3;
	private JLabel lblDayWeek_3;
	private JPanel panelDay_4;
	private JLabel lblDay_4;
	private JLabel lblDayWeek_4;
	private JPanel panelDay_5;
	private JLabel lblDay_5;
	private JLabel lblDayWeek_5;
	private JPanel panel_form;
    private JLabel lblPhim;
	private JLabel lblNgayChieu;
	private JLabel lblThoiGian;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLamMoi;
	private JButton btnDate;
	private JButton btnTime;
	private JPanel panel_find;
	private JLabel lblFind;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public GUI_XuatChieu() {
		setSize(1380, 900);
		setBackground(new Color(24, 28, 44));
		setLayout(null);
		
		lblNewLabel = new JLabel(" XUẤT CHIẾU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(GUI_XuatChieu.class.getResource("/img/blank-calendar--blank-calendar-date-day-month-empty.png")));
		lblNewLabel.setBounds(575, 25, 183, 41);
		add(lblNewLabel);
		
		panel_main = new JPanel();
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
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setForeground(new Color(64, 0, 64));
		panel_1.setPreferredSize(new Dimension(700, 250));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblPhim_1 = new JLabel("Spirited Away – Vùng đất linh hồn");
		lblPhim_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_1.setBounds(20, 22, 431, 40);
		panel_1.add(lblPhim_1);
		
		lblXC_1_1 = new JLabel("17:15");
		lblXC_1_1.setOpaque(true);
		lblXC_1_1.setBackground(new Color(0, 255, 128));
		lblXC_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_1.setBounds(30, 97, 77, 33);
		panel_1.add(lblXC_1_1);
		
		lblXC_1_2 = new JLabel("18:15");
		lblXC_1_2.setOpaque(true);
		lblXC_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_2.setBackground(new Color(0, 255, 128));
		lblXC_1_2.setBounds(156, 97, 77, 33);
		panel_1.add(lblXC_1_2);
		
		lblXC_1_3 = new JLabel("19:20");
		lblXC_1_3.setOpaque(true);
		lblXC_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_3.setBackground(new Color(0, 255, 128));
		lblXC_1_3.setBounds(277, 97, 77, 33);
		panel_1.add(lblXC_1_3);
		
		lblXC_1_4 = new JLabel("20:20");
		lblXC_1_4.setOpaque(true);
		lblXC_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_4.setBackground(new Color(0, 255, 128));
		lblXC_1_4.setBounds(396, 97, 77, 33);
		panel_1.add(lblXC_1_4);
		
		lblXC_1_5 = new JLabel("21:25");
		lblXC_1_5.setOpaque(true);
		lblXC_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_1_5.setBackground(new Color(0, 255, 128));
		lblXC_1_5.setBounds(513, 97, 77, 33);
		panel_1.add(lblXC_1_5);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(700, 250));
		panel_2.setForeground(new Color(64, 0, 64));
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2);
		
		lblPhim_2 = new JLabel("Pororo: Hành trình siêu sao");
		lblPhim_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_2.setBounds(20, 22, 431, 40);
		panel_2.add(lblPhim_2);
		
		lblXC_2_1 = new JLabel("17:15");
		lblXC_2_1.setOpaque(true);
		lblXC_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_1.setBackground(new Color(0, 255, 128));
		lblXC_2_1.setBounds(30, 97, 77, 33);
		panel_2.add(lblXC_2_1);
		
		lblXC_2_2 = new JLabel("18:15");
		lblXC_2_2.setOpaque(true);
		lblXC_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_2.setBackground(new Color(0, 255, 128));
		lblXC_2_2.setBounds(156, 97, 77, 33);
		panel_2.add(lblXC_2_2);
		
		lblXC_2_3 = new JLabel("19:20");
		lblXC_2_3.setOpaque(true);
		lblXC_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_3.setBackground(new Color(0, 255, 128));
		lblXC_2_3.setBounds(277, 97, 77, 33);
		panel_2.add(lblXC_2_3);
		
		lblXC_2_4 = new JLabel("20:20");
		lblXC_2_4.setOpaque(true);
		lblXC_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_4.setBackground(new Color(0, 255, 128));
		lblXC_2_4.setBounds(396, 97, 77, 33);
		panel_2.add(lblXC_2_4);
		
		lblXC_2_5 = new JLabel("21:25");
		lblXC_2_5.setOpaque(true);
		lblXC_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_2_5.setBackground(new Color(0, 255, 128));
		lblXC_2_5.setBounds(513, 97, 77, 33);
		panel_2.add(lblXC_2_5);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(700, 250));
		panel_3.setForeground(new Color(64, 0, 64));
		panel_3.setBackground(SystemColor.menu);
		panel.add(panel_3);
		
		lblPhim_3 = new JLabel("Spy × Family Code: White");
		lblPhim_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_3.setBounds(20, 22, 431, 40);
		panel_3.add(lblPhim_3);
		
		lblXC_3_1 = new JLabel("17:15");
		lblXC_3_1.setOpaque(true);
		lblXC_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_1.setBackground(new Color(0, 255, 128));
		lblXC_3_1.setBounds(30, 97, 77, 33);
		panel_3.add(lblXC_3_1);
		
		lblXC_3_2 = new JLabel("18:15");
		lblXC_3_2.setOpaque(true);
		lblXC_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_2.setBackground(new Color(0, 255, 128));
		lblXC_3_2.setBounds(156, 97, 77, 33);
		panel_3.add(lblXC_3_2);
		
		lblXC_3_3 = new JLabel("19:20");
		lblXC_3_3.setOpaque(true);
		lblXC_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_3.setBackground(new Color(0, 255, 128));
		lblXC_3_3.setBounds(277, 97, 77, 33);
		panel_3.add(lblXC_3_3);
		
		lblXC_3_4 = new JLabel("20:20");
		lblXC_3_4.setOpaque(true);
		lblXC_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_4.setBackground(new Color(0, 255, 128));
		lblXC_3_4.setBounds(396, 97, 77, 33);
		panel_3.add(lblXC_3_4);
		
		lblXC_3_5 = new JLabel("21:25");
		lblXC_3_5.setOpaque(true);
		lblXC_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_3_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_3_5.setBackground(new Color(0, 255, 128));
		lblXC_3_5.setBounds(513, 97, 77, 33);
		panel_3.add(lblXC_3_5);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(700, 250));
		panel_4.setForeground(new Color(64, 0, 64));
		panel_4.setBackground(new Color(255, 255, 255));
		panel.add(panel_4);
		
		lblPhim_4 = new JLabel("Katak và sứ mệnh chinh phục đại dương");
		lblPhim_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_4.setBounds(20, 22, 485, 40);
		panel_4.add(lblPhim_4);
		
		lblXC_4_1 = new JLabel("17:15");
		lblXC_4_1.setOpaque(true);
		lblXC_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_1.setBackground(new Color(0, 255, 128));
		lblXC_4_1.setBounds(30, 97, 77, 33);
		panel_4.add(lblXC_4_1);
		
		lblXC_4_2 = new JLabel("18:15");
		lblXC_4_2.setOpaque(true);
		lblXC_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_2.setBackground(new Color(0, 255, 128));
		lblXC_4_2.setBounds(156, 97, 77, 33);
		panel_4.add(lblXC_4_2);
		
		lblXC_4_3 = new JLabel("19:20");
		lblXC_4_3.setOpaque(true);
		lblXC_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_3.setBackground(new Color(0, 255, 128));
		lblXC_4_3.setBounds(277, 97, 77, 33);
		panel_4.add(lblXC_4_3);
		
		lblXC_4_4 = new JLabel("20:20");
		lblXC_4_4.setOpaque(true);
		lblXC_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_4.setBackground(new Color(0, 255, 128));
		lblXC_4_4.setBounds(396, 97, 77, 33);
		panel_4.add(lblXC_4_4);
		
		lblXC_4_5 = new JLabel("21:25");
		lblXC_4_5.setOpaque(true);
		lblXC_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_4_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_4_5.setBackground(new Color(0, 255, 128));
		lblXC_4_5.setBounds(513, 97, 77, 33);
		panel_4.add(lblXC_4_5);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setPreferredSize(new Dimension(700, 250));
		panel_5.setForeground(new Color(64, 0, 64));
		panel_5.setBackground(SystemColor.menu);
		panel.add(panel_5);
		
		lblPhim_5 = new JLabel("Vòng vây cá mập");
		lblPhim_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhim_5.setBounds(20, 22, 431, 40);
		panel_5.add(lblPhim_5);
		
		lblXC_5_1 = new JLabel("17:15");
		lblXC_5_1.setOpaque(true);
		lblXC_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_1.setBackground(new Color(0, 255, 128));
		lblXC_5_1.setBounds(30, 97, 77, 33);
		panel_5.add(lblXC_5_1);
		
		lblXC_5_2 = new JLabel("18:15");
		lblXC_5_2.setOpaque(true);
		lblXC_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_2.setBackground(new Color(0, 255, 128));
		lblXC_5_2.setBounds(156, 97, 77, 33);
		panel_5.add(lblXC_5_2);
		
		lblXC_5_3 = new JLabel("19:20");
		lblXC_5_3.setOpaque(true);
		lblXC_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_3.setBackground(new Color(0, 255, 128));
		lblXC_5_3.setBounds(277, 97, 77, 33);
		panel_5.add(lblXC_5_3);
		
		lblXC_5_4 = new JLabel("20:20");
		lblXC_5_4.setOpaque(true);
		lblXC_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXC_5_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXC_5_4.setBackground(new Color(0, 255, 128));
		lblXC_5_4.setBounds(396, 97, 77, 33);
		panel_5.add(lblXC_5_4);
		
		lblXC_5_5 = new JLabel("21:25");
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
		
		date = LocalDate.now();
		lblDay_1 = new JLabel("New label");
		lblDay_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_1.setForeground(new Color(255, 255, 255));
		lblDay_1.setBackground(new Color(255, 255, 255));
		lblDay_1.setBounds(35, 23, 87, 28);
		lblDay_1.setText(date.getDayOfMonth() + "/" + date.getMonthValue());
		panelDay_1.add(lblDay_1);
		
		lblDayWeek_1 = new JLabel("Hôm nay");
		lblDayWeek_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_1.setForeground(new Color(255, 255, 255));
		lblDayWeek_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_1.setBounds(45, 54, 64, 26);
		panelDay_1.add(lblDayWeek_1);
		
		panelDay_2 = new JPanel();
		panelDay_2.setForeground(new Color(0, 0, 0));
		panelDay_2.setLayout(null);
		panelDay_2.setBackground(new Color(250, 250, 250));
		panel_day.add(panelDay_2);
		
		lblDay_2 = new JLabel("New label");
		lblDay_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_2.setForeground(new Color(0, 0, 0));
		lblDay_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_2.setBackground(Color.WHITE);
		lblDay_2.setBounds(35, 23, 87, 28);
		lblDay_2.setText(date.plusDays(1).getDayOfMonth() + "/" + date.plusDays(1).getMonthValue());
		panelDay_2.add(lblDay_2);
		
		lblDayWeek_2 = new JLabel("");
		lblDayWeek_2.setText(getDayWeeks(date.plusDays(1).getDayOfWeek() + ""));
		lblDayWeek_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_2.setForeground(new Color(0, 0, 0));
		lblDayWeek_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_2.setBounds(45, 54, 77, 26);
		panelDay_2.add(lblDayWeek_2);
		
		panelDay_3 = new JPanel();
		panelDay_3.setLayout(null);
		panelDay_3.setBackground(new Color(255, 255, 255));
		panel_day.add(panelDay_3);
		
		lblDay_3 = new JLabel("New label");
		lblDay_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_3.setForeground(new Color(0, 0, 0));
		lblDay_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_3.setBackground(Color.WHITE);
		lblDay_3.setBounds(35, 23, 87, 28);
		lblDay_3.setText(date.plusDays(2).getDayOfMonth() + "/" + date.plusDays(2).getMonthValue());
		panelDay_3.add(lblDay_3);
		
		lblDayWeek_3 = new JLabel("Hôm nay");
		lblDayWeek_3.setText(getDayWeeks(date.plusDays(2).getDayOfWeek() + ""));
		lblDayWeek_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_3.setForeground(new Color(0, 0, 0));
		lblDayWeek_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_3.setBounds(45, 54, 64, 26);
		panelDay_3.add(lblDayWeek_3);
		
		panelDay_4 = new JPanel();
		panelDay_4.setLayout(null);
		panelDay_4.setBackground(new Color(250, 250, 250));
		panel_day.add(panelDay_4);
		
		lblDay_4 = new JLabel("New label");
		lblDay_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_4.setForeground(new Color(0, 0, 0));
		lblDay_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_4.setBackground(Color.WHITE);
		lblDay_4.setBounds(35, 23, 87, 28);
		lblDay_4.setText(date.plusDays(3).getDayOfMonth() + "/" + date.plusDays(3).getMonthValue());
		panelDay_4.add(lblDay_4);
		
		lblDayWeek_4 = new JLabel("Hôm nay");
		lblDayWeek_4.setText(getDayWeeks(date.plusDays(3).getDayOfWeek() + ""));
		lblDayWeek_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayWeek_4.setForeground(new Color(0, 0, 0));
		lblDayWeek_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDayWeek_4.setBounds(45, 54, 64, 26);
		panelDay_4.add(lblDayWeek_4);
		
		panelDay_5 = new JPanel();
		panelDay_5.setLayout(null);
		panelDay_5.setBackground(new Color(255, 255, 255));
		panel_day.add(panelDay_5);
		
		lblDay_5 = new JLabel("New label");
		lblDay_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay_5.setForeground(new Color(0, 0, 0));
		lblDay_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDay_5.setBackground(Color.WHITE);
		lblDay_5.setBounds(35, 23, 87, 28);
		lblDay_5.setText(date.plusDays(4).getDayOfMonth() + "/" + date.plusDays(4).getMonthValue());
		panelDay_5.add(lblDay_5);
		
		lblDayWeek_5 = new JLabel("Hôm nay");
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
		
		lblPhim = new JLabel("Phim:");
		lblPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhim.setForeground(new Color(255, 255, 255));
		lblPhim.setBackground(new Color(255, 255, 255));
		lblPhim.setBounds(36, 59, 98, 20);
		panel_form.add(lblPhim);
		
		lblNgayChieu = new JLabel("Ngày chiếu:");
		lblNgayChieu.setForeground(Color.WHITE);
		lblNgayChieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayChieu.setBackground(Color.WHITE);
		lblNgayChieu.setBounds(36, 133, 98, 20);
		panel_form.add(lblNgayChieu);
		
		lblThoiGian = new JLabel("Thời gian:");
		lblThoiGian.setForeground(Color.WHITE);
		lblThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThoiGian.setBackground(Color.WHITE);
		lblThoiGian.setBounds(36, 208, 98, 20);
		panel_form.add(lblThoiGian);
		
		textFieldNgayChieu = new JTextField();
		textFieldNgayChieu.setBounds(154, 131, 185, 30);
		panel_form.add(textFieldNgayChieu);
		textFieldNgayChieu.setColumns(10);
		
		textFieldPhim = new JTextField();
		textFieldPhim.setColumns(10);
		textFieldPhim.setBounds(154, 57, 223, 30);
		panel_form.add(textFieldPhim);
		
		textFieldThoiGian = new JTextField();
		textFieldThoiGian.setColumns(10);
		textFieldThoiGian.setBounds(154, 206, 185, 30);
		panel_form.add(textFieldThoiGian);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBackground(new Color(255, 165, 0));
		btnThem.setBounds(28, 424, 85, 37);
		panel_form.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBackground(new Color(255, 165, 0));
		btnSua.setBounds(123, 424, 85, 37);
		panel_form.add(btnSua);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(new Color(255, 165, 0));
		btnXoa.setBounds(218, 424, 85, 37);
		panel_form.add(btnXoa);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(new Color(255, 165, 0));
		btnLamMoi.setBounds(313, 423, 85, 37);
		panel_form.add(btnLamMoi);
		
		btnDate = new JButton("");
		btnDate.setBackground(new Color(102, 51, 150));
		btnDate.setIcon(new ImageIcon(GUI_XuatChieu.class.getResource("/img/icons8-date-26.png")));
		btnDate.setBounds(349, 133, 28, 28);
		panel_form.add(btnDate);
		
		btnTime = new JButton("");
		btnTime.setBackground(new Color(102, 51, 150));
		btnTime.setIcon(new ImageIcon(GUI_XuatChieu.class.getResource("/img/icons8-time-26.png")));
		btnTime.setBounds(349, 206, 28, 28);
		panel_form.add(btnTime);
		
		panel_find = new JPanel();
		panel_find.setBackground(new Color(102, 51, 153));
		panel_find.setBounds(874, 120, 417, 90);
		add(panel_find);
		panel_find.setLayout(null);
		
		lblFind = new JLabel("Nhập tên phim:");
		lblFind.setForeground(new Color(255, 255, 255));
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFind.setBounds(21, 10, 137, 20);
		panel_find.add(lblFind);
		
		textField = new JTextField();
		textField.setBounds(21, 40, 325, 34);
		panel_find.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(102, 51, 120));
		btnNewButton.setIcon(new ImageIcon(GUI_XuatChieu.class.getResource("/img/icons8-find-30.png")));
		btnNewButton.setBounds(352, 40, 34, 34);
		panel_find.add(btnNewButton);
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
		}else if(day.equalsIgnoreCase("Sartuday")){
			s += "Bảy";
		}else if(day.equalsIgnoreCase("Sunday")){
			s = "Chủ Nhật";
		}
		
		return s;
	}
}