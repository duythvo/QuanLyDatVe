package Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DAO.ChiTietVe_DAO;
import DAO.LoaiPhim_DAO;
import connectDB.ConnectDB;
import entity.ChiTietVe;
import entity.HoaDon;
import entity.NhanVien;
import entity.Ve;

public class testCTVe {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    ChiTietVe_DAO ctVe = new ChiTietVe_DAO();
	    //System.out.println(ctVe.getChiTietVe("V01", "HD01"));
	    
	    //them duoc khi da tao hoa don va Ve
	    ctVe.themChiTietVe(new ChiTietVe(new Ve("V01"), new HoaDon("HD01", new NhanVien("NV01")),1,LocalDateTime.now()));
	    ArrayList<ChiTietVe> ds = ctVe.getDSChiTietVe();
	    
	   
	    for (ChiTietVe chiTietVe : ds) {
			System.out.println(chiTietVe);
		}

	    
	    ConnectDB.getInstance().disconnect();
	}
}
