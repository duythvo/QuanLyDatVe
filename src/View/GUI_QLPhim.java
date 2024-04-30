package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
// import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class GUI_QLPhim extends JPanel implements ActionListener{
	
	private JTextField jtfMa;
	private JTextField jtfTen;
	private JTextField jtfThoiLuong;
	private JTextField jtfQuocGia;
	private JTextField jtfNgayKC;
	private JTextField jtfNgayKT;
	private JButton btnImg;
	private JCheckBox[] cbCate;
	private JLabel[] jlbType;
	private JButton btnAdd;
	private JButton btnReset;
	private JButton btnFix;
	private JButton btnDelete;
	private JTable jTable;
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
	private JLabel jlbNgayKC;
	private JLabel jlbNgayKT;
    private JLabel jlbCate;
	private FlowLayout fl;
	private JPanel jplCate;
	private Box C;
	private Box c1;
    private Box c2;
	private Box c3;
    private Box c4;
    private Box c5;
	private Box c6;
    private Box c7;
	private Box c8;
	private JPanel jPanel;
	private JPanel jplForm;
    private Box btn;
    private JPanel empty1;
	private Box ct;
    private JScrollPane jScrollPane;

	public GUI_QLPhim() {
		this.setBackground(new Color(24, 28, 44));
		this.setLayout(null);
		setSize(1350,900);
		
		
		A = Box.createVerticalBox();
		
		a1 = Box.createVerticalBox();
		a2 = Box.createVerticalBox();
		a3 = Box.createHorizontalBox();
		a4 = Box.createVerticalBox();
		a5 = Box.createVerticalBox();
		a6 = Box.createVerticalBox();
		
		jlbMa = new JLabel("Mã phim:");
		jtfMa = new JTextField();
		jtfMa.setSize(230,30);
		jlbTen = new JLabel("Tên phim:");
		jtfTen = new JTextField();
		jtfTen.setSize(230,30);
		jlbThoiLuong = new JLabel("Thời lượng:");
		jtfThoiLuong = new JTextField();
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
		
		jlbQuocGia = new JLabel("Quốc gia:");
		jtfQuocGia = new JTextField();
		jtfQuocGia.setSize(230,30);
		jlbNgayKC = new JLabel("Ngày Khởi chiếu:");
		jtfNgayKC = new JTextField();
		jtfNgayKC.setSize(230, 30);
		jlbNgayKT = new JLabel("Ngày kết thúc:");
		jtfNgayKT = new JTextField();
		jtfNgayKT.setSize(230,30);
		
		a4.add(jlbQuocGia);
		a4.add(Box.createVerticalStrut(45));
		a4.add(jlbNgayKC);
		a4.add(Box.createVerticalStrut(45));
		a4.add(jlbNgayKT);
		a4.add(Box.createVerticalStrut(5));
		a5.add(Box.createVerticalStrut(30));
		a5.add(jtfQuocGia);
		a5.add(Box.createVerticalStrut(30));
		a5.add(jtfNgayKC);
		a5.add(Box.createVerticalStrut(30));
		a5.add(jtfNgayKT);
		a5.add(Box.createVerticalStrut(30));
		a3.add(Box.createHorizontalStrut(80));
		a3.add(a4);
		a3.add(Box.createHorizontalStrut(15));
		a3.add(a5);
		
		jlbImg = new JLabel();
		jlbImg.setSize(125,150);
		jlbImg.setMaximumSize(new Dimension(130, 150));
		jlbImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlbImg.setBackground(Color.CYAN);
		btnImg = new JButton("Chọn ảnh");
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
		c2 = Box.createHorizontalBox();
		c3 = Box.createHorizontalBox();
		c4 = Box.createHorizontalBox();
		c5 = Box.createHorizontalBox();
		c6 = Box.createHorizontalBox();
		c7 = Box.createHorizontalBox();
		c8 = Box.createHorizontalBox();
		
		
		cbCate = new JCheckBox[8];
		
		String[] cate = new String[]{"Chính kịch", "Tình yêu" , "Kinh dị", "Hoạt hình", "Hài", "Sinh tồn", "Phiêu lưu", "Siêu anh hùng"};
		jlbType = new JLabel[8];
		
		jPanel = new JPanel(new GridLayout(4, 2));
		for(int i = 0; i < 8; i++) {
			cbCate[i] = new JCheckBox();
			jlbType[i] = new JLabel(cate[i]);
		}
		c1.add(Box.createHorizontalStrut(30));
		c1.add(cbCate[0]);
		c1.add(Box.createHorizontalStrut(5));
		c1.add(jlbType[0]);
		c2.add(Box.createHorizontalStrut(30));
		c2.add(cbCate[1]);
		c2.add(Box.createHorizontalStrut(5));
		c2.add(jlbType[1]);
		c3.add(Box.createHorizontalStrut(30));
		c3.add(cbCate[2]);
		c3.add(Box.createHorizontalStrut(5));
		c3.add(jlbType[2]);
		c4.add(Box.createHorizontalStrut(30));
		c4.add(cbCate[3]);
		c4.add(Box.createHorizontalStrut(5));
		c4.add(jlbType[3]);
		c5.add(Box.createHorizontalStrut(30));
		c5.add(cbCate[4]);
		c5.add(Box.createHorizontalStrut(5));
		c5.add(jlbType[4]);
		c6.add(Box.createHorizontalStrut(30));
		c6.add(cbCate[5]);
		c6.add(Box.createHorizontalStrut(5));
		c6.add(jlbType[5]);
		c7.add(Box.createHorizontalStrut(30));
		c7.add(cbCate[6]);
		c7.add(Box.createHorizontalStrut(5));
		c7.add(jlbType[6]);
		c8.add(Box.createHorizontalStrut(30));
		c8.add(cbCate[7]);
		c8.add(Box.createHorizontalStrut(5));
		c8.add(jlbType[7]);
		
		jPanel.add(c1);
		jPanel.add(c2);
		jPanel.add(c3);
		jPanel.add(c4);
		jPanel.add(c5);
		jPanel.add(c6);
		jPanel.add(c7);
		jPanel.add(c8);
		
		jplCate.add(jPanel);
		jplCate.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.CYAN), "Thể loại"));
		jplCate.setSize(340,120);
		jplCate.setMaximumSize(new Dimension(350, 120));
		
		jplForm = new JPanel();
		
		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(this);
		btnReset = new JButton("Làm mới");
		btnReset.addActionListener(this);
		btnFix = new JButton("Sửa");
		btnFix.addActionListener(this);
		btnDelete = new JButton("Xoá");
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
		jplForm.setSize(1000,400);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Mã Phim");
		dtm.addColumn("Tên Phim");
		dtm.addColumn("Thời Lượng");
		dtm.addColumn("Quốc Gia");
		dtm.addColumn("Ngày KC");
		dtm.addColumn("Ngày KT");
		jTable = new JTable(dtm);
		jTable.setBackground(new Color(0, 0, 0));
		
		
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 900));
		jScrollPane.setBounds(0, 479, 1000, 352);
		
		this.add(jplForm);
		this.add(jScrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ac = e.getSource();
		
		if(ac.equals(btnAdd)) {
			
		}else if(ac.equals(btnDelete)) {
			
		}else if(ac.equals(btnFix)) {
			
		}else if(ac.equals(btnImg)) {
			getImg();
		}else if(ac.equals(btnReset)) {
			
		}
		
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
}