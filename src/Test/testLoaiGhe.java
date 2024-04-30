package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LoaiGhe_DAO;

import connectDB.ConnectDB;
import entity.LoaiGhe;


public class testLoaiGhe {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    LoaiGhe_DAO loaiGhe = new LoaiGhe_DAO();
	    
	    ArrayList<LoaiGhe> loaighe1 = loaiGhe.getDSLoaiGhe();
	    for (LoaiGhe loaiGhe2 : loaighe1) {
			System.out.println(loaiGhe2);
		}

	    
	    ConnectDB.getInstance().disconnect();
	}
}
