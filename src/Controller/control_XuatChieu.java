package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI_SuatChieu;

public class control_XuatChieu implements ActionListener{
	GUI_SuatChieu gui;
	
	public control_XuatChieu(GUI_SuatChieu gsc) {
		gui = gsc;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ac = e.getSource();
		
		if(ac.equals(gui.btnThem)) {
			gui.add();
		}else if(ac.equals(gui.btnSua)) {
			gui.thucHienSua();
		}else if(ac.equals(gui.btnXoa)) {
			gui.thucHienXoa();
		}else if(ac.equals(gui.btnLamMoi)) {
			gui.lamMoi();
		}else if(ac.equals(gui.rdbtnChinhSua)) {
			gui.modeEdit();
		}else if(ac.equals(gui.rdbtnXem)) {
			gui.modeView();
		}else if(ac.equals(gui.btnTim)) {
			gui.timKiem();
		}
		
	}
    
}
