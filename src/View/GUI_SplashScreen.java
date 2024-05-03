package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JProgressBar;

public class GUI_SplashScreen extends JFrame {

	private JPanel contentPane;
	public JLabel lblNewLabel_1;
	public JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
	 	EventQueue.invokeLater(new Runnable() {
	 		public void run() {
	 			try {
	 				GUI_SplashScreen frame = new GUI_SplashScreen();
	 				frame.setVisible(true);
	 			} catch (Exception e) {
	 				e.printStackTrace();
	 			}
	 		}
	 	});
	 }

	/**
	 * Create the frame.
	 */
	public GUI_SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1288, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(28, 24, 44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI_SplashScreen.class.getResource("/img/logo-removebg-preview.png")));
		lblNewLabel.setBounds(400, 175, 122, 103);
		contentPane.add(lblNewLabel);
		
		JLabel lblKdhd = new JLabel("KDHD SOFT");
		lblKdhd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblKdhd.setForeground(new Color(255, 255, 255));
		lblKdhd.setBounds(550, 175, 184, 103);
		contentPane.add(lblKdhd);
		
		JLabel lblMovieMngement = new JLabel("MOVIE MANAGEMENT");
		lblMovieMngement.setForeground(Color.WHITE);
		lblMovieMngement.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMovieMngement.setBounds(400, 288, 362, 103);
		contentPane.add(lblMovieMngement);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(102, 51, 153));
		progressBar.setBounds(0, 585, 1288, 38);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(501, 510, 122, 38);
		contentPane.add(lblNewLabel_1);
		setVisible(true);
	}
}
