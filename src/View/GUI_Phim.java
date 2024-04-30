package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;


import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class GUI_Phim extends JPanel {

	private static final long serialVersionUID = 1L;
    private JLabel lblNewLabel;
    private JScrollPane scrollPane;
	private JPanel panel;
    private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
    private JLabel lblNewLabel_2_3;
    private JButton btnDat2;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JButton btnDat3;
	private JPanel panel_1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
    private JButton btnDat1;
    private JPanel panel_4;
	private JLabel lblNewLabel_4;
	private JButton btnDat5;
	private JLabel lblNewLabel_5_3;
	private JLabel lblNewLabel_5_2;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_5;
	private JPanel panel_5;
	private JButton btnDat4;
	private JLabel lblNewLabel_4_3;
	private JLabel lblNewLabel_4_2;
	private JLabel lblNewLabel_4_1;

	/**
	 * Create the panel.
	 */
	public GUI_Phim() {
		setBackground(new Color(24, 28, 44));
		setSize(1350,900);
		setLayout(null);

		JPanel panel_Phim = new JPanel();
		panel_Phim.setLayout(null);
		panel_Phim.setSize(1350,900);
		panel_Phim.setBackground(new Color(24, 28, 44));
		add(panel_Phim);

		
		lblNewLabel = new JLabel("  PHIM");
		lblNewLabel.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/film-regular-24_1.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(630, 21, 142, 33);
		panel_Phim.add(lblNewLabel);

		//btnQLVe
		JButton QLVe = new JButton("Quản lý Phim");
		QLVe.setBackground(new Color(255, 165, 0));
		QLVe.setFont(new Font("Arial", Font.PLAIN, 20));
		QLVe.setBounds(1100, 21, 160, 33);
		QLVe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_Phim.removeAll();
				GUI_QLPhim viewQLPhim = new GUI_QLPhim();
				panel_Phim.add(viewQLPhim);
				panel_Phim.repaint();
				panel_Phim.revalidate();
			}
			
		});
		panel_Phim.add(QLVe);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(81, 85, 1216, 717);
		panel_Phim.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(32, 44, 92));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		//panel2
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setPreferredSize(new Dimension(300,280));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/pororo.jpg")));
		lblNewLabel_2.setBounds(50, 29, 181, 217);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("TÊN PHIM: Poporo Hành Trình Siêu Sao");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(278, 103, 317, 24);
		panel_2.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2 = new JLabel("THỂ LOẠI: Hoạt Hình");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(277, 151, 285, 32);
		panel_2.add(lblNewLabel_2_2);
		
		lblNewLabel_2_3 = new JLabel("MÃ PHIM: P001");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(279, 40, 223, 39);
		panel_2.add(lblNewLabel_2_3);
		
		btnDat2 = new JButton("ĐẶT VÉ");
		btnDat2.setBackground(new Color(255, 165, 0));
		btnDat2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDat2.setBounds(278, 195, 134, 39);
		panel_2.add(btnDat2);
		//panel3
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 160));
		panel_3.setPreferredSize(new Dimension(300,280));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/katak.jpg")));
		lblNewLabel_3.setBounds(50, 29, 181, 217);
		panel_3.add(lblNewLabel_3);
		
		lblNewLabel_3_1 = new JLabel("TÊN PHIM: Poporo Hành Trình Siêu Sao");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setBounds(278, 103, 317, 24);
		panel_3.add(lblNewLabel_3_1);
		
		lblNewLabel_3_2 = new JLabel("THỂ LOẠI: Hoạt Hình");
		lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(277, 151, 285, 32);
		panel_3.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3 = new JLabel("MÃ PHIM: P001");
		lblNewLabel_3_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(279, 40, 223, 39);
		panel_3.add(lblNewLabel_3_3);
		
		btnDat3 = new JButton("ĐẶT VÉ");
		btnDat3.setBackground(new Color(255, 165, 0));
		btnDat3.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDat3.setBounds(278, 195, 134, 39);
		panel_3.add(btnDat3);
		
		//panel_1
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setPreferredSize(new Dimension(300,280));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/spyx.jpg")));
		lblNewLabel_1.setBounds(50, 29, 181, 217);
		panel_1.add(lblNewLabel_1);

		
		lblNewLabel_1_1 = new JLabel("TÊN PHIM: Poporo Hành Trình Siêu Sao");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(278, 103, 317, 24);
		panel_1.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("THỂ LOẠI: Hoạt Hình");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(277, 151, 285, 32);
		panel_1.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("MÃ PHIM: P001");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(279, 40, 223, 39);
		panel_1.add(lblNewLabel_1_3);
		
		btnDat1 = new JButton("ĐẶT VÉ");
		btnDat1.setBackground(new Color(255, 165, 0));
		btnDat1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDat1.setBounds(278, 195, 134, 39);
		panel_1.add(btnDat1);
		
		//panel 4
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 160));
		panel_4.setPreferredSize(new Dimension(300,280));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/camap.jpg")));
		lblNewLabel_4.setBounds(50, 29, 181, 217);
		panel_4.add(lblNewLabel_4);
		
		lblNewLabel_4_1 = new JLabel("TÊN PHIM: Poporo Hành Trình Siêu Sao");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setBounds(278, 103, 317, 24);
		panel_4.add(lblNewLabel_4_1);
		
		lblNewLabel_4_2 = new JLabel("THỂ LOẠI: Hoạt Hình");
		lblNewLabel_4_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(277, 151, 285, 32);
		panel_4.add(lblNewLabel_4_2);
		
		lblNewLabel_4_3 = new JLabel("MÃ PHIM: P001");
		lblNewLabel_4_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4_3.setBounds(279, 40, 223, 39);
		panel_4.add(lblNewLabel_4_3);
		
		btnDat4 = new JButton("ĐẶT VÉ");
		btnDat4.setBackground(new Color(255, 165, 0));
		btnDat4.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDat4.setBounds(278, 195, 134, 39);
		panel_4.add(btnDat4);
		
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 128));
		panel_5.setPreferredSize(new Dimension(300,280));
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(GUI_Phim.class.getResource("/img/digimon.jpg")));
		lblNewLabel_5.setBounds(50, 29, 181, 217);
		panel_5.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("TÊN PHIM: Poporo Hành Trình Siêu Sao");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1.setBounds(278, 103, 317, 24);
		panel_5.add(lblNewLabel_5_1);
		
		lblNewLabel_5_2 = new JLabel("THỂ LOẠI: Hoạt Hình");
		lblNewLabel_5_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(277, 151, 285, 32);
		panel_5.add(lblNewLabel_5_2);
		
		lblNewLabel_5_3 = new JLabel("MÃ PHIM: P001");
		lblNewLabel_5_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5_3.setBounds(279, 40, 223, 39);
		panel_5.add(lblNewLabel_5_3);
		
		btnDat5= new JButton("ĐẶT VÉ");
		btnDat5.setBackground(new Color(255, 165, 0));
		btnDat5.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDat5.setBounds(278, 195, 134, 39);
		panel_5.add(btnDat5);
	}
}
