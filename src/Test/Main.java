package Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import DAO.LoaiPhim_DAO;
import DAO.Phim_DAO;
import DAO.SuatChieu_DAO;
import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;

public class Main {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SuatChieu_DAO suatChieu_dao = new SuatChieu_DAO();
        suatChieu_dao.themSuatChieu(new SuatChieu("SC03",LocalDate.now(), LocalTime.now(), new Phim("P01"), new PhongChieu("PC01")));
        //ArrayList<SuatChieu> dsSuatChieu = suatChieu_dao.getDSPhim();
    }
}
