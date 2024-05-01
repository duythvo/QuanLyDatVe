package Test;

import java.sql.SQLException;

import DAO.SuatChieu_DAO;
import DAO.TrangThaiGhe_DAO;
import View.GUI_DatVe;
import connectDB.ConnectDB;
import entity.SuatChieu;
import entity.TrangThaiGhe;

public class duytest {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TrangThaiGhe_DAO a = new TrangThaiGhe_DAO();
        SuatChieu_DAO b = new SuatChieu_DAO();
        SuatChieu d = b.getSuatChieuBangMa("SC01");

        TrangThaiGhe t = a.getTrangThaiGhe("A1.2", "SC01");
        System.out.println(t);
    }
}
