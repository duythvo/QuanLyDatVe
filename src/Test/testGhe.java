package Test;

import java.sql.SQLException;

import DAO.Ghe_DAO;
import connectDB.ConnectDB;


public class testGhe {
public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    Ghe_DAO ghe = new Ghe_DAO();
	    System.out.println(ghe.getGhe("A1.1"));
	    
	    ConnectDB.getInstance().disconnect();
	}
}
