package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LoaiPhim_DAO;
import DAO.Phim_DAO;
import DAO.SuatChieu_DAO;
import View.GUI_SplashScreen;
import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;
import entity.SuatChieu;

public class Main {
    public static void main(String[] args) {
        GUI_SplashScreen sc = new GUI_SplashScreen();
        try {
            for(int i=0;i<=100;i++){
                Thread.sleep(30);
                sc.lblNewLabel_1.setText(Integer.toString(i)+"%");
                sc.progressBar.setValue(i);
                if(i==100){
                    Thread.sleep(1000);
                    sc.dispose();
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
