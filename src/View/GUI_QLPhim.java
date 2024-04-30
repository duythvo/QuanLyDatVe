package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
// import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiPhim_DAO;
import DAO.Phim_DAO;
import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;

public class GUI_QLPhim extends JPanel implements ActionListener,MouseListener{
	
	private JTextField jtfMa;
	private JTextField jtfTen;
	private JTextField jtfThoiLuong;
	private JTextField jtfQuocGia;
	private JTextField jtfDaoDien;
	private JButton btnImg;
	private JButton btnAdd;
	private JButton btnReset;
	private JButton btnFix;
	private JButton btnDelete;
	private JLabel jlbImg;
    private JLabel jlbMa;
    private JLabel jlbTen;
    private JLabel jlbThoiLuong;
    private Box A;
	private Box a1;
	private Box a2;
    private Box a3;
	private Box a4;
	private Box a5;
	private Box a6;
    private JLabel jlbQuocGia;
	private JLabel jlbDaoDien;
	private JLabel jlbCate;
	private FlowLayout fl;
	private JPanel jplCate;
	private Box C;
	private Box c1;
	private JPanel jPanel;
	private JPanel jplForm;
    private Box btn;
    private JPanel empty1;
	private Box ct;
    private JScrollPane jScrollPane;
	private DefaultTableModel model;
	private JTable table_Phim;
	private JScrollPane sc;
	private JComboBox<String> jcbType;
	private ArrayList<Phim> dsPhim;
	private ArrayList<LoaiPhim> dsLoaiPhim;

	public GUI_QLPhim() {
		this.setBackground(new Color(25, 28, 44));
		this.setLayout(null);
		setSize(1350,900);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		A = Box.createVerticalBox();
		
		a1 = Box.createVerticalBox();
		a2 = Box.createVerticalBox();
		a3 = Box.createHorizontalBox();
		a4 = Box.createVerticalBox();
		a5 = Box.createVerticalBox();
		a6 = Box.createVerticalBox();
		
		//Label Mã
		jlbMa = new JLabel("Mã phim:");
		jlbMa.setForeground(Color.WHITE);
		jlbMa.setFont(new Font("Arial", Font.BOLD, 16));	
		jtfMa = new JTextField();
		jtfMa.setSize(230,30);

		//Label Tên
		jlbTen = new JLabel("Tên phim:");
		jtfTen = new JTextField();
		jlbTen.setForeground(Color.WHITE);
		jlbTen.setFont(new Font("Arial", Font.BOLD, 16));
		jtfTen.setSize(230,30);

		//Label Thời lượng
		jlbThoiLuong = new JLabel("Thời lượng:");
		jtfThoiLuong = new JTextField();
		jlbThoiLuong.setForeground(Color.WHITE);
		jlbThoiLuong.setFont(new Font("Arial", Font.BOLD, 16));
		jtfThoiLuong.setSize(230,30);
		
		a1.add(jlbMa);
		a1.add(Box.createVerticalStrut(45));
		a1.add(jlbTen);
		a1.add(Box.createVerticalStrut(45));
		a1.add(jlbThoiLuong);
		a1.add(Box.createVerticalStrut(5));
		a2.add(Box.createVerticalStrut(30));
		a2.add(jtfMa);
		a2.add(Box.createVerticalStrut(30));
		a2.add(jtfTen);
		a2.add(Box.createVerticalStrut(30));
		a2.add(jtfThoiLuong);
		a2.add(Box.createVerticalStrut(30));
		a3.add(a1);
		a3.add(Box.createHorizontalStrut(15));
		a3.add(a2);
		
		//Label Quốc gia
		jlbQuocGia = new JLabel("Quốc gia:");
		jlbQuocGia.setForeground(Color.WHITE);
		jlbQuocGia.setFont(new Font("Arial", Font.BOLD, 16));
		jtfQuocGia = new JTextField();
		jtfQuocGia.setSize(230,30);

		//Label Đao diễn
		jlbDaoDien = new JLabel("Đạo diễn:");
		jlbDaoDien.setForeground(Color.WHITE);
		jlbDaoDien.setFont(new Font("Arial", Font.BOLD, 16));
		jtfDaoDien = new JTextField();
		jtfDaoDien.setSize(230, 30);


		// jlbNgayKT = new JLabel("Ngày kết thúc:");
		// jtfNgayKT = new JTextField();
		// jtfNgayKT.setSize(230,30);
		
		a4.add(jlbQuocGia);
		a4.add(Box.createVerticalStrut(45));
		a4.add(jlbDaoDien);
		a4.add(Box.createVerticalStrut(45));
		a4.add(Box.createVerticalStrut(45));
		// a4.add(jlbNgayKT);
		a4.add(Box.createVerticalStrut(5));
		a5.add(Box.createVerticalStrut(30));
		a5.add(jtfQuocGia);
		a5.add(Box.createVerticalStrut(30));
		a5.add(jtfDaoDien);
		a5.add(Box.createVerticalStrut(30));
		a5.add(Box.createVerticalStrut(30));
		// a5.add(jtfNgayKT);
		a5.add(Box.createVerticalStrut(30));
		a3.add(Box.createHorizontalStrut(80));
		a3.add(a4);
		a3.add(Box.createHorizontalStrut(15));
		a3.add(a5);
		
		jlbImg = new JLabel();
		jlbImg.setForeground(Color.WHITE);
		jlbImg.setFont(new Font("Arial", Font.BOLD, 16));
		jlbImg.setSize(181,217);
		jlbImg.setMaximumSize(new Dimension(181, 217));
		jlbImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlbImg.setBackground(Color.WHITE);
		btnImg = new JButton("Chọn ảnh");
		btnImg.setBackground(new Color(255, 165, 0));
		btnImg.addActionListener(this);
		
		a6.add(Box.createVerticalStrut(20));
		a6.add(jlbImg);
		a6.add(Box.createVerticalStrut(15));
		a6.add(btnImg);
		a3.add(Box.createHorizontalStrut(20));
		a3.add(a6);
		
		jlbCate = new JLabel("Thể loại");
		fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		jplCate = new JPanel();
		jplCate.setLayout(fl);
		C = Box.createVerticalBox();
		c1 = Box.createHorizontalBox();
		
		

		// lấy tên thể loại phim từ database
		
		LoaiPhim_DAO loaiPhim_DAO = new LoaiPhim_DAO();
		dsLoaiPhim = loaiPhim_DAO.getDSLoaiPhim();
		

		String[] cate = new String[dsLoaiPhim.size()];
		for(int i = 0; i < dsLoaiPhim.size(); i++) {
			cate[i] = dsLoaiPhim.get(i).getTenLoaiPhim();
		}
		// tạo jcombobox để chọn thể loại phim
		jcbType = new JComboBox<String>(cate);
		jcbType.setSize(250,40);
		jcbType.setBounds(200, 100, 250, 40);
		//jcbType.setMaximumSize(new Dimension(230, 30));
		jcbType.setBackground(new Color(32, 44, 92));
		jcbType.setForeground(Color.WHITE);
		jcbType.setFont(new Font("Arial", Font.BOLD, 16));
		jcbType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jcbType.setSelectedIndex(0);
		jcbType.addActionListener(this);
		
		
		jPanel = new JPanel(new GridLayout(1, 1));
		jPanel.setBackground(new Color(32, 44, 92));
		
		
		c1.add(Box.createHorizontalStrut(100));
		c1.add(jcbType);
		
		 jPanel.add(c1);

		
		jplCate.add(jPanel);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thể loại");
		titledBorder.setTitleColor(Color.WHITE);
		jplCate.setBorder(titledBorder);

		jplCate.setSize(340,120);
		jplCate.setMaximumSize(new Dimension(350, 120));
		jplCate.setBackground(new Color(32, 44, 92));
		
		jplForm = new JPanel();
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(255, 165, 0));
		btnAdd.addActionListener(this);

		btnReset = new JButton("Làm mới");
		btnReset.setBackground(new Color(255, 165, 0));
		btnReset.addActionListener(this);

		btnFix = new JButton("Sửa");
		btnFix.setBackground(new Color(255, 165, 0));
		btnFix.addActionListener(this);

		btnDelete = new JButton("Xoá");
		btnDelete.setBackground(new Color(255, 165, 0));
		btnDelete.addActionListener(this);
		
		btn = Box.createHorizontalBox();
		btn.add(btnAdd);
		btn.add(Box.createHorizontalStrut(8));
		btn.add(btnReset);
		btn.add(Box.createHorizontalStrut(8));
		btn.add(btnFix);
		btn.add(Box.createHorizontalStrut(8));
		btn.add(btnDelete);
		btn.add(Box.createHorizontalStrut(600));
		
		empty1 = new JPanel();
		empty1.setSize(1900,200);
		
		ct = Box.createHorizontalBox();
		ct.add(jplCate);
		ct.add(Box.createHorizontalStrut(600));
		
		A.add(a3);
		A.add(Box.createVerticalStrut(15));
		A.add(ct);
		A.add(Box.createVerticalStrut(15));
		A.add(btn);
		
		jplForm.add(A);
		jplForm.setBounds(100, 40, 1180, 400);
		jplForm.setPreferredSize(new Dimension(1180,300));
		jplForm.setBackground(new Color(32, 44, 92));
		//btn_Phim.setBackground(new Color(32, 44, 92));

		model = new DefaultTableModel();
		model.addColumn("Mã Phim");
		model.addColumn("Tên Phim");
		model.addColumn("Đạo Diễn");
		model.addColumn("Quốc Gia");
		model.addColumn("Thời lượng Phim");
		model.addColumn("Loại Phim");
		table_Phim = new JTable(model);
		sc = new JScrollPane(table_Phim);
		sc.setBounds(100, 480, 1180, 348);
		table_Phim.getTableHeader().setBackground(new Color(102,51,153));
		table_Phim.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
		table_Phim.getTableHeader().setForeground(Color.WHITE);
		table_Phim.addMouseListener(this);

		add(sc);
		sc.setPreferredSize(new Dimension(1180,300));
		
		Phim_DAO phim_DAO = new Phim_DAO();
		dsPhim = phim_DAO.getDSPhim();
		for (Phim phim : dsPhim) {
			model.addRow(new Object[] {phim.getMaPhim(), phim.getTenPhim(), phim.getDaoDien(), phim.getQuocGia(), phim.getThoiLuongPhim(), phim.getLoaiPhim().getTenLoaiPhim()});
		} 

		
		
		
		this.add(jplForm);
		this.add(sc);

		ConnectDB.getInstance().disconnect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ac = e.getSource();
		
		if(ac.equals(btnAdd)) {
			themPhim();
		}else if(ac.equals(btnDelete)) {
			xoaPhim();
		}else if(ac.equals(btnFix)) {
			suaPhim();
		}else if(ac.equals(btnImg)) {
			getImg();
		}else if(ac.equals(btnReset)) {
			lamRong();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clickChonDong();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
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

	public void themPhim(){
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Phim_DAO phim_DAO = new Phim_DAO();
		Phim phim = new Phim();
		phim.setMaPhim(jtfMa.getText());
		phim.setTenPhim(jtfTen.getText());
		phim.setDaoDien(jtfDaoDien.getText());
		phim.setQuocGia(jtfQuocGia.getText());
		phim.setThoiLuongPhim(Integer.parseInt(jtfThoiLuong.getText()));
		phim.setLoaiPhim(dsLoaiPhim.get(jcbType.getSelectedIndex()));
		if(phim_DAO.themPhim(phim)){
			dsPhim.add(phim);
			model.addRow(new Object[] {phim.getMaPhim(), phim.getTenPhim(), phim.getDaoDien(), phim.getQuocGia(), phim.getThoiLuongPhim(), phim.getLoaiPhim().getTenLoaiPhim()});
			lamRong();
			//System.out.println(dsLoaiPhim.get(jcbType.getSelectedIndex()));
		}else{
			JOptionPane.showMessageDialog(null, "Thêm phim thất bại");
			//System.out.println(dsLoaiPhim.get(jcbType.getSelectedIndex()));
		}
		ConnectDB.getInstance().disconnect();
	}

	public void lamRong(){
		jtfMa.setText("");
		jtfTen.setText("");
		jtfThoiLuong.setText("");
		jtfQuocGia.setText("");
		jtfDaoDien.setText("");
		jcbType.setSelectedIndex(0);
		jtfMa.requestFocus();
	}

	public void suaPhim(){
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Phim_DAO phim_DAO = new Phim_DAO();
		int row = table_Phim.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa");
		}else{
			Phim phim = new Phim();
			phim.setMaPhim(jtfMa.getText());
			phim.setTenPhim(jtfTen.getText());
			phim.setDaoDien(jtfDaoDien.getText());
			phim.setQuocGia(jtfQuocGia.getText());
			phim.setThoiLuongPhim(Integer.parseInt(jtfThoiLuong.getText()));
			phim.setLoaiPhim(dsLoaiPhim.get(jcbType.getSelectedIndex()));
			if(phim_DAO.suaPhim(phim)){
				model.setValueAt(phim.getMaPhim(), row, 0);
				model.setValueAt(phim.getTenPhim(), row, 1);
				model.setValueAt(phim.getDaoDien(), row, 2);
				model.setValueAt(phim.getQuocGia(), row, 3);
				model.setValueAt(phim.getThoiLuongPhim(), row, 4);
				model.setValueAt(phim.getLoaiPhim().getTenLoaiPhim(), row, 5);
				JOptionPane.showMessageDialog(null, "Sửa thành công");
			}else{
				JOptionPane.showMessageDialog(null, "Sửa thất bại");
			}
		}
		ConnectDB.getInstance().disconnect();
	}

	public void xoaPhim(){
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Phim_DAO phim_DAO = new Phim_DAO();
		int row = table_Phim.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa");
		}else{
			String maPhim = model.getValueAt(row, 0).toString();
			if(phim_DAO.xoaPhim(maPhim)){
				model.removeRow(row);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			}else{
				JOptionPane.showMessageDialog(null, "Xóa thất bại");
			}
		}
		ConnectDB.getInstance().disconnect();
	}

	public void clickChonDong(){
		int row = table_Phim.getSelectedRow();
		jtfMa.setText(model.getValueAt(row, 0).toString());
		jtfTen.setText(model.getValueAt(row, 1).toString());
		jtfDaoDien.setText(model.getValueAt(row, 2).toString());
		jtfQuocGia.setText(model.getValueAt(row, 3).toString());
		jtfThoiLuong.setText(model.getValueAt(row, 4).toString());
		jcbType.setSelectedItem(model.getValueAt(row, 5).toString());
	}

	public void getImg() {
		File file;
		JFileChooser c = new JFileChooser();
		
		javax.swing.filechooser.FileFilter imgFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		c.setFileFilter(imgFilter);
		int rVal = c.showOpenDialog(new JPanel());
		
		if(rVal == JFileChooser.APPROVE_OPTION) {
			file = c.getSelectedFile();
//			System.out.println(file);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.toString()).getImage().getScaledInstance(125, 150, Image.SCALE_DEFAULT));
			jlbImg.setIcon(imageIcon);
		}
	}

	public ArrayList<Phim> getDSPhim() {
		return dsPhim;
	}

	public ArrayList<LoaiPhim> getDSLoaiPhim() {
		return dsLoaiPhim;
	}
}