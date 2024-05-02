package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;


import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;

import DAO.Phim_DAO;
import connectDB.ConnectDB;
import entity.Phim;

import javax.swing.JButton;

public class GUI_Phim extends JPanel {

	private static final long serialVersionUID = 1L;
    private JLabel lblNewLabel;
    private JScrollPane scrollPane;
	private JPanel panel;


	/**
	 * Create the panel.
	 */
	public GUI_Phim() {
		setBackground(new Color(24, 28, 44));
		setSize(1350,900);
		setLayout(null);

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		// GUI_QLPhim viewQLPhim = new GUI_QLPhim();
		

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
		JButton QLPhim = new JButton("Quản lý Phim");
		QLPhim.setBackground(new Color(255, 165, 0));
		QLPhim.setFont(new Font("Arial", Font.PLAIN, 20));
		QLPhim.setBounds(100, 21, 160, 33);
		QLPhim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_Phim.removeAll();
				GUI_QLPhim viewQLPhim = new GUI_QLPhim();
				panel_Phim.add(viewQLPhim);
				panel_Phim.repaint();
				panel_Phim.revalidate();
			}
			
		});
		panel_Phim.add(QLPhim);

		//btnTimKiem
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 165, 0));
		btnTimKiem.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTimKiem.setBounds(1150, 21, 150, 33);
		

		//jtfTimKiem
		JTextField jtfTimKiem = new JTextField();
		jtfTimKiem.setFont(new Font("Arial", Font.PLAIN, 16));
		jtfTimKiem.setBounds(850, 21, 250, 33);
		panel_Phim.add(jtfTimKiem);

		panel_Phim.add(btnTimKiem);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(81, 85, 1216, 717);
		panel_Phim.add(scrollPane);


		
		panel = new JPanel();
		panel.setBackground(new Color(32, 44, 92));
		scrollPane.setViewportView(panel);

		Phim_DAO phim_DAO = new Phim_DAO();
		ArrayList<Phim> listPhim = phim_DAO.getDSPhim();

		panel.setLayout(new GridLayout(listPhim.size()/2+1, 2, 0, 0));
		//panel2

		for (Phim phim : listPhim) {
			JPanel panelPhim = new JPanel();
			panelPhim.setBackground(new Color(0, 0, 128));
			panelPhim.setPreferredSize(new Dimension(300,280));
			panel.add(panelPhim);
			panelPhim.setLayout(null);

			JLabel lblNewLabelPhim = new JLabel("");
			lblNewLabelPhim.setIcon(new ImageIcon(new ImageIcon(GUI_Phim.class.getResource(phim.getLinkPhim())).getImage()));
			lblNewLabelPhim.setBounds(50, 29, 181, 217);
			panelPhim.add(lblNewLabelPhim);

			JLabel lblNewLabelPhim_1 = new JLabel("TÊN PHIM: " + phim.getTenPhim());
			lblNewLabelPhim_1.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabelPhim_1.setForeground(new Color(255, 255, 255));
			lblNewLabelPhim_1.setBounds(278, 103, 317, 24);
			panelPhim.add(lblNewLabelPhim_1);

			JLabel lblNewLabelPhim_2 = new JLabel("THỂ LOẠI: " + phim.getLoaiPhim().getTenLoaiPhim());
			lblNewLabelPhim_2.setForeground(new Color(255, 255, 255));
			lblNewLabelPhim_2.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabelPhim_2.setBounds(277, 151, 285, 32);
			panelPhim.add(lblNewLabelPhim_2);

			JLabel lblNewLabelPhim_3 = new JLabel("MÃ PHIM: " + phim.getMaPhim());
			lblNewLabelPhim_3.setForeground(new Color(255, 255, 255));
			lblNewLabelPhim_3.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabelPhim_3.setBounds(279, 40, 223, 39);
			panelPhim.add(lblNewLabelPhim_3);

			JButton btnDat = new JButton("ĐẶT VÉ");
			btnDat.setBackground(new Color(255, 165, 0));
			btnDat.setFont(new Font("Arial", Font.PLAIN, 16));
			btnDat.setBounds(278, 195, 134, 39);
			panelPhim.add(btnDat);
			btnDat.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					panel_Phim.removeAll();
					GUI_DatVe viewDatVe = new GUI_DatVe(phim);
					panel_Phim.add(viewDatVe);
					panel_Phim.repaint();
					panel_Phim.revalidate();
				}
				
			});

		}

		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtfTimKiem.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Nhập tên phim cần tìm");
			} else {
				scrollPane.getVerticalScrollBar().setValue(0);
				boolean found = false;
				panel.removeAll();
				panel.setLayout(new GridLayout(listPhim.size()/2+1, 2, 0, 0));
				for (Phim phim2 : listPhim) {
					if (phim2.getTenPhim().toLowerCase().indexOf(jtfTimKiem.getText().toLowerCase()) != -1) {
						found = true;
						JPanel panelPhim = new JPanel();
						panelPhim.setBackground(new Color(0, 0, 128));
						panelPhim.setPreferredSize(new Dimension(300,280));
						panel.add(panelPhim);
						panel.repaint();
						panel.revalidate();
						panelPhim.setLayout(null);

						JLabel lblNewLabelPhim = new JLabel("");
						lblNewLabelPhim.setIcon(new ImageIcon(new ImageIcon(GUI_Phim.class.getResource(phim2.getLinkPhim())).getImage()));
						lblNewLabelPhim.setBounds(50, 29, 181, 217);
						panelPhim.add(lblNewLabelPhim);

						JLabel lblNewLabelPhim_1 = new JLabel("TÊN PHIM: " + phim2.getTenPhim());
						lblNewLabelPhim_1.setFont(new Font("Arial", Font.PLAIN, 16));
						lblNewLabelPhim_1.setForeground(new Color(255, 255, 255));
						lblNewLabelPhim_1.setBounds(278, 103, 317, 24);
						panelPhim.add(lblNewLabelPhim_1);

						JLabel lblNewLabelPhim_2 = new JLabel("THỂ LOẠI: " + phim2.getLoaiPhim().getTenLoaiPhim());
						lblNewLabelPhim_2.setForeground(new Color(255, 255, 255));
						lblNewLabelPhim_2.setFont(new Font("Arial", Font.PLAIN, 16));
						lblNewLabelPhim_2.setBounds(277, 151, 285, 32);
						panelPhim.add(lblNewLabelPhim_2);

						JLabel lblNewLabelPhim_3 = new JLabel("MÃ PHIM: " + phim2.getMaPhim());
						lblNewLabelPhim_3.setForeground(new Color(255, 255, 255));
						lblNewLabelPhim_3.setFont(new Font("Arial", Font.PLAIN, 16));
						lblNewLabelPhim_3.setBounds(279, 40, 223, 39);
						panelPhim.add(lblNewLabelPhim_3);

						

						JButton btnDat = new JButton("ĐẶT VÉ");
						btnDat.setBackground(new Color(255, 165, 0));
						btnDat.setFont(new Font("Arial", Font.PLAIN, 16));
						btnDat.setBounds(278, 195, 134, 39);
						panelPhim.add(btnDat);
						btnDat.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								panel_Phim.removeAll();
								GUI_DatVe viewDatVe = new GUI_DatVe(phim2);
								panel_Phim.add(viewDatVe);
								panel_Phim.repaint();
								panel_Phim.revalidate();
							}
							
						});
						
					}
				}
			if (!found) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy phim");
			}
		}
		}
		});


		ConnectDB.getInstance().disconnect();
	}
}