package Test;

import java.sql.SQLException;
//import java.util.ArrayList;

import DAO.LoaiPhim_DAO;
import connectDB.ConnectDB;
//import entity.LoaiPhim;

public class testLoaiPhim {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    LoaiPhim_DAO loaiPhim = new LoaiPhim_DAO();
	    System.out.println(loaiPhim.getLoaiPhimBangMaLoaiPhim("LP03"));
//	    ArrayList<LoaiPhim> loaiphim1 = loaiPhim.getDSLoaiPhim();
//	    for (LoaiPhim phim : loaiphim1) {
//	    	if(phim.getPhim().getMaPhim().equals("P01")) {
//	    		System.out.println(phim);
//	    	}
//			
//		}

	    
	    ConnectDB.getInstance().disconnect();
	}
}
