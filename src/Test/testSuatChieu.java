package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.SuatChieu_DAO;
import connectDB.ConnectDB;
import entity.SuatChieu;

public class testSuatChieu {
	public static void main(String[] args) {
			
		    try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		  
		    SuatChieu_DAO suatchieu = new SuatChieu_DAO();
		    
		    System.out.println(suatchieu.getSuatChieuBangMa("SC01"));
		    
//		    ArrayList<SuatChieu> sc = suatchieu.getDSSuatChieu();
//		    for (SuatChieu sc1 : sc) {
//				System.out.println(sc1);
//			}
	
		    
		    ConnectDB.getInstance().disconnect();
		}
}
