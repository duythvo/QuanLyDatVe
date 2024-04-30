package Test;

import java.sql.SQLException;
import java.util.ArrayList;


import DAO.Ve_DAO;
import connectDB.ConnectDB;
import entity.SuatChieu;
import entity.Ve;

public class testVe {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    Ve_DAO ve = new Ve_DAO();
	    
//	    ve.themVe(new Ve("V03", new SuatChieu("SC01")));
//	    
//	    ArrayList<Ve> veds = ve.getDSVe();
//	    for (Ve ve1 : veds) {
//			System.out.println(ve1);
//		}
	    System.out.println(ve.getVeBangMa("V03"));

	    
	    ConnectDB.getInstance().disconnect();
	}
}
