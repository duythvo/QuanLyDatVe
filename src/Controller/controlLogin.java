package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GUI_Login;
import View.GUI_Main;

public class controlLogin implements ActionListener{
	GUI_Login gui_Login;
	
	public controlLogin(GUI_Login gl) {
		gui_Login = gl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gui_Login.checkUser()) { 
			gui_Login.dispose();
			GUI_Main gui_Main = new GUI_Main();
			gui_Main.setVisible(true);
		}
		
		
	}
    
}
