package Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.NhanVien_DAO;
import connectDB.ConnectDB;
import entity.NhanVien;

public class testNV {
	
	public static void main(String[] args) {
		
	    try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	    NhanVien_DAO nv = new NhanVien_DAO();
//	    ArrayList<NhanVien> list = nv.getDSNhanVien();
//	    
//	    NhanVien nv2 = nv.getNhanVienBangMaNV("NV02"); 
//	    System.out.println(nv2);
//	    for (NhanVien nv1 : list) {
//	        System.out.println(nv1);
//	    }
	    nv.themNhanVien(new NhanVien("NV03", "ABC", "NV03", LocalDate.now(),"01234567","123"));
	    System.out.println(nv.getMaNVMoiNhat());

	    
	    ConnectDB.getInstance().disconnect();
	}
}
