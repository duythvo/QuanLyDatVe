package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LoaiPhim_DAO;
import DAO.Phim_DAO;
import DAO.SuatChieu_DAO;
import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;
import entity.SuatChieu;

public class Main {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        Phim_DAO phim_dao = new Phim_DAO();

       

        if( phim_dao.themPhim(new Phim("P06", "Phim 1", "Dao Dien 1", "Quoc Gia 1", 120, new LoaiPhim("LP01")))){
            System.out.println("Them thanh cong");
        }
        else{
            System.out.println("Them that bai");
        }
        
         ConnectDB.getInstance().disconnect();
    }
}
