package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Ghe_DAO;
import DAO.TrangThaiGhe_DAO;
import connectDB.ConnectDB;
import entity.TrangThaiGhe;


public class Main {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TrangThaiGhe_DAO ghe_dao = new TrangThaiGhe_DAO();
        // System.out.println(ghe_dao.getTrangThaiGhe("A1.1", "SC01"));
        ArrayList<TrangThaiGhe> list = ghe_dao.getDSTrangThaiGhe();
        for (TrangThaiGhe ghe : list) {
            System.out.println(ghe.getGhe().getMaGhe()+ ghe.isTrangThai());
        }
    }
}
