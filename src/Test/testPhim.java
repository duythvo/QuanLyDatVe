package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Phim_DAO;
import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;

public class testPhim {
	public static void main(String[] args) {
		 try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Phim_DAO phim = new Phim_DAO();
		 phim.themPhim(new Phim("P05", "abc", "abc", "abc", 1,new LoaiPhim("LP04")));
		 //phim.capNhatTenPhim("P03","hihihihi");
		 
		 ArrayList<Phim> list = phim.getDSPhim();
		 
		 for (Phim phim2 : list) {
			System.out.println(phim2);
		}
		 //System.out.println(phim.getPhimBangMaPhim("P03"));
		 ConnectDB.getInstance().disconnect();
	}
}
