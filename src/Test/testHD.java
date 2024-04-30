package Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.HoaDon_DAO;
import DAO.LoaiGhe_DAO;
import connectDB.ConnectDB;
import entity.HoaDon;
import entity.LoaiGhe;
import entity.NhanVien;

public class testHD {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    HoaDon_DAO hd = new HoaDon_DAO();
	    
	    hd.themHoaDon(new HoaDon("HD03", new NhanVien("NV03"), 0, LocalDate.now(),10));
	    ArrayList<HoaDon> list = hd.getDSHoaDon();
	    for (HoaDon hd1 : list) {
			System.out.println(hd1);
		}

	    
	    ConnectDB.getInstance().disconnect();
	}
}
