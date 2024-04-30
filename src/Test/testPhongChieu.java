package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Phim_DAO;
import DAO.PhongChieu_DAO;
import connectDB.ConnectDB;
import entity.PhongChieu;

public class testPhongChieu {
	public static void main(String[] args) {
		 try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 PhongChieu_DAO phong = new PhongChieu_DAO();
		 
		 //phong.themPhongChieu(new PhongChieu("PC03", "A", "B", 1));
		 phong.capNhatTenPhongChieu("PC03", "hhiiiii");
		 ArrayList<PhongChieu> pc = phong.getDSPhongChieu();
		 for (PhongChieu phongChieu : pc) {
			System.out.println(phongChieu);
		}
				 
		 ConnectDB.getInstance().disconnect();
	}
}
