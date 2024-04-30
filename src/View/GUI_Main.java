package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Container;

public class GUI_Main extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Container panel_6;
    private JLabel lblTiKhon;
	private JButton btn_VePhim_1_1;
    private JLabel labe12;
    private JButton btn_VePhim_1;
    private JLabel lblVPhim;
    private JLabel lblSuatChieu;
    private JButton btn_VePhim;
    private JButton btn_SuatChieu;
    private JLabel lblPhim;
    private JButton btn_Phim;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Main frame = new GUI_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUI_Main() {
		//setExtendedState(MAXIMIZED_BOTH);
		setSize(1600,900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(24, 28, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		getContentPane().add(contentPane);
		
		
		
		 panel_6 = new JPanel();
		panel_6.setBackground(new Color(32, 44, 92));
		panel_6.setBounds(0, 2, 219, 898);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/logo-removebg-preview.png")));
		lblNewLabel.setBounds(38, 47, 123, 93);
		panel_6.add(lblNewLabel);
		
		btn_Phim = new JButton("");
		btn_Phim.setBackground(new Color(32, 44, 92));
		btn_Phim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				GUI_Phim viewPhim = new GUI_Phim();
				panel.add(viewPhim);
				panel.repaint();
				panel.revalidate();	
			}
		});
		
		btn_Phim.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Phim.setBackground(new Color(255,165,0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Phim.setBackground(new Color(32, 44, 92));
				
			}
			
		});
		
		btn_Phim.setBorderPainted(false);
		btn_Phim.setBounds(0, 217, 219, 64);
		lblPhim = new JLabel();
		lblPhim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhim.setText("PHIM");
		lblPhim.setForeground(Color.WHITE);
		lblPhim.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/film-regular-24_1.png")));
		btn_Phim.add(lblPhim);
		btn_Phim.setFont(new Font("Arial",Font.BOLD,20));
		panel_6.add(btn_Phim);
		
		btn_SuatChieu = new JButton("");
		btn_SuatChieu.setForeground(new Color(255, 255, 255));
		btn_SuatChieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				GUI_SuatChieu viewXuatChieu = new GUI_SuatChieu();
				panel.add(viewXuatChieu);
				panel.repaint();
				panel.revalidate();
			}
		});
		btn_SuatChieu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				btn_SuatChieu.setBackground(new Color(255,165,0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_SuatChieu.setBackground(new Color(32, 44, 92));
				
			}
			
		});
		btn_SuatChieu.setFont(new Font("Arial", Font.BOLD, 20));
		btn_SuatChieu.setBorderPainted(false);
		btn_SuatChieu.setBackground(new Color(32, 44, 92));
		btn_SuatChieu.setBounds(0, 291, 219, 64);
		lblSuatChieu = new JLabel();
		lblSuatChieu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSuatChieu.setText(" SUẤT CHIẾU");
		lblSuatChieu.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/blank-calendar--blank-calendar-date-day-month-empty.png")));
		lblSuatChieu.setForeground(Color.WHITE);
		btn_SuatChieu.add(lblSuatChieu);
		panel_6.add(btn_SuatChieu);
		
		btn_VePhim = new JButton("");
		btn_VePhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				GUI_VePhim viewVePhim = new GUI_VePhim();
				panel.add(viewVePhim);
				panel.repaint();
				panel.revalidate();
			}
		});
		
		btn_VePhim.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				btn_VePhim.setBackground(new Color(255,165,0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_VePhim.setBackground(new Color(32, 44, 92));
				
			}
			
		});
		btn_VePhim.setForeground(Color.WHITE);
		btn_VePhim.setFont(new Font("Arial", Font.BOLD, 20));
		btn_VePhim.setBorderPainted(false);
		btn_VePhim.setBackground(new Color(32, 44, 92));
		btn_VePhim.setBounds(0, 365, 219, 64);
		lblVPhim = new JLabel();
		lblVPhim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVPhim.setText(" VÉ PHIM");
		lblVPhim.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/ticket-1--hobby-ticket-event-entertainment-stub-theater-entertainment-culture_3.png")));
		lblVPhim.setForeground(Color.WHITE);
		btn_VePhim.add(lblVPhim);
		panel_6.add(btn_VePhim);
		
		btn_VePhim_1 = new JButton("");
		btn_VePhim_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				GUI_ThongKe viewThongKe = new GUI_ThongKe();
				panel.add(viewThongKe);
				panel.repaint();
				panel.revalidate();
			}
		});
		btn_VePhim_1.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				btn_VePhim_1.setBackground(new Color(255,165,0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_VePhim_1.setBackground(new Color(32, 44, 92));
				
			}
			
		});
		btn_VePhim_1.setForeground(Color.WHITE);
		btn_VePhim_1.setFont(new Font("Arial", Font.BOLD, 20));
		btn_VePhim_1.setBorderPainted(false);
		btn_VePhim_1.setBackground(new Color(32, 44, 92));
		btn_VePhim_1.setBounds(0, 447, 219, 64);
		labe12 = new JLabel();
		labe12.setForeground(new Color(255, 255, 255));
		labe12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labe12.setText("THỐNG KÊ");
		labe12.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/graph-bar-increase--up-product-performance-increase-arrow-graph-business-chart.png")));
		btn_VePhim_1.add(labe12);
		panel_6.add(btn_VePhim_1);
		
		btn_VePhim_1_1 = new JButton("");
		btn_VePhim_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btn_VePhim_1_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				btn_VePhim_1_1.setBackground(new Color(255,165,0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_VePhim_1_1.setBackground(new Color(32, 44, 92));
				
			}
			
		});
		btn_VePhim_1_1.setForeground(Color.WHITE);
		btn_VePhim_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btn_VePhim_1_1.setBorderPainted(false);
		btn_VePhim_1_1.setBackground(new Color(32, 44, 92));
		btn_VePhim_1_1.setBounds(0, 532, 219, 64);
		btn_VePhim_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				GUI_TaiKhoan viewTaiKhoan = new GUI_TaiKhoan();
				panel.add(viewTaiKhoan);
				panel.repaint();
				panel.revalidate();
				
			}
		});
		lblTiKhon = new JLabel();
		lblTiKhon.setForeground(new Color(255, 255, 255));
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiKhon.setText("TÀI KHOẢN");
		lblTiKhon.setIcon(new ImageIcon(GUI_Main.class.getResource("/img/user-multiple-group--close-geometric-human-multiple-person-up-user.png")));
		btn_VePhim_1_1.add(lblTiKhon);
		panel_6.add(btn_VePhim_1_1);
		
		panel = new JPanel();
		panel.setBounds(218, 2, 1322, 861);
		contentPane.add(panel);
		panel.setLayout(null);
		
	}
}
