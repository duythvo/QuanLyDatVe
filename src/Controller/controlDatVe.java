package Controller;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import DAO.SuatChieu_DAO;
import View.GUI_DatVe;
import connectDB.ConnectDB;

public class controlDatVe implements ActionListener{
	private GUI_DatVe viewDatVe;
	private SuatChieu_DAO suatChieu_DAO = new SuatChieu_DAO();
	private double tongTien =0;
	
	public controlDatVe(GUI_DatVe viewDatVe) {
		this.viewDatVe=viewDatVe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
            ConnectDB.getInstance().connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		Object o = e.getSource();

		if(o.equals(viewDatVe.comboBox_NgayChieu)){
			List<String> gioChieu =viewDatVe.getGioChieu(suatChieu_DAO.getdsSuatChieuBangMaPhim(viewDatVe.label_MaPhim.getText()));
			viewDatVe.comboBox_GioChieu.removeAllItems();
			for (String string : gioChieu) {
				viewDatVe.comboBox_GioChieu.addItem(string);
			}
			viewDatVe.label_Time.setText("Ngày/Giờ : "+viewDatVe.comboBox_NgayChieu.getSelectedItem().toString() + " " + viewDatVe.comboBox_GioChieu.getSelectedItem().toString());
		}else{
			if(o.equals(viewDatVe.button_Huy)){
				for(int i=0;i<24;i++){
					if(i<21){
						viewDatVe.btns1[i].setIcon(new ImageIcon("src/img/ghetrong.png"));
					}else{
						viewDatVe.btns2[i-20].setIcon(new ImageIcon("src/img/ghedoitrang.png"));
					}
				}
				viewDatVe.textArea.setText("");
				tongTien = 0;
				viewDatVe.label_TongTien.setText(tongTien + " VNĐ");
			}
		}

		ImageIcon img = new ImageIcon("src/img/ghedangchon.png");
		ImageIcon img1 = new ImageIcon("src/img/ghedoivang.png");
		JButton btn = new JButton(img);
		JButton btn1 = new JButton(img1);

		for(int i = 0 ; i < 24 ; i++){
			String maGhe = viewDatVe.ghes[i].getMaGhe();
			if(i<21){
				if(o.equals(viewDatVe.btns1[i])){
					if(!viewDatVe.checkGhe(maGhe)){
						if(!viewDatVe.btns1[i].getIcon().toString().equals(btn.getIcon().toString())){
							String textGhe = viewDatVe.textArea.getText();
							viewDatVe.btns1[i].setIcon(new ImageIcon("src/img/ghedangchon.png"));
							viewDatVe.textArea.setText(textGhe+" "+maGhe);
							tongTien+=viewDatVe.ghes[i].getLoaiGhe().getGia();
							viewDatVe.label_TongTien.setText(tongTien+" VNĐ");
							viewDatVe.soLuong++;
						}else{
							viewDatVe.btns1[i].setIcon(new ImageIcon("src/img/ghetrong.png"));
							tongTien-=viewDatVe.ghes[i].getLoaiGhe().getGia();
							String text[] = viewDatVe.textArea.getText().split(" ");
							String newText = "";
							for (String string : text) {
								if(!string.equals(maGhe)){
									newText+=string+" ";
								}
							}
							viewDatVe.textArea.setText(newText);
							viewDatVe.label_TongTien.setText(tongTien+" VNĐ");
							viewDatVe.soLuong--;
						}
					}
				}
			}else{
				if(o.equals(viewDatVe.btns2[i-20])){
					if(!viewDatVe.checkGhe(maGhe)){
						if(!viewDatVe.btns2[i-20].getIcon().toString().equals(btn1.getIcon().toString())){
							String textGhe = viewDatVe.textArea.getText();
							viewDatVe.btns2[i-20].setIcon(new ImageIcon("src/img/ghedoivang.png"));
							viewDatVe.textArea.setText(textGhe+" "+maGhe);
							tongTien+=viewDatVe.ghes[i].getLoaiGhe().getGia();
							viewDatVe.label_TongTien.setText(tongTien+" VNĐ");
							viewDatVe.soLuong++;
						}else{
							viewDatVe.btns2[i-20].setIcon(new ImageIcon("src/img/ghedoitrang.png"));
							tongTien-=viewDatVe.ghes[i].getLoaiGhe().getGia();
							String text[] = viewDatVe.textArea.getText().split(" ");
							String newText = "";
							for (String string : text) {
								if(!string.equals(maGhe)){
									newText+=string+" ";
								}
							}
							viewDatVe.textArea.setText(newText);
							viewDatVe.label_TongTien.setText(tongTien+" VNĐ");
							viewDatVe.soLuong--;
						}
					}
				}
			}
		}
	}
}
