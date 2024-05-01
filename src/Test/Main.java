package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ChiTietVe_DAO;
import DAO.Ghe_DAO;
import DAO.TrangThaiGhe_DAO;
import connectDB.ConnectDB;
import entity.ChiTietVe;
import entity.TrangThaiGhe;


public class Main {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ChiTietVe_DAO ctv_dao = new ChiTietVe_DAO();
        // System.out.println(ghe_dao.getTrangThaiGhe("A1.1", "SC01"));
        ArrayList<ChiTietVe> list = ctv_dao.getDSChiTietVe();
        for (ChiTietVe t : list) {
            System.out.println(t.getSoLuongGhe());
        }
    }
}
