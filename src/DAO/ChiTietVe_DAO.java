package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietVe;
import entity.SuatChieu;

public class ChiTietVe_DAO {
	private static ChiTietVe_DAO instance = new ChiTietVe_DAO(); 
	public static  ChiTietVe_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy bảng ChiTietVe
	 * @return  <ArrayList>
	 * 
	 */
	public ArrayList<ChiTietVe> getDSChiTietVe() {
        ArrayList<ChiTietVe> dataList = new ArrayList<ChiTietVe>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.ChiTietVe";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	ChiTietVe ctVe = new ChiTietVe(rs);
                dataList.add(ctVe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
 		        if (stmt != null) {
 		            stmt.close();
 		        }
 		    } catch (SQLException e) {
 		        e.printStackTrace();
 		    }
        }
        return dataList;
    }
	
	/**
	 * <B>Note:</B> Tìm Chi tiet voi maVe va maSuatChieu
	 * @param maVe va maSuatChieu
	 *@return Về 1 đối tượng Chitiet hoặc null
	 * 
	 */
	public ChiTietVe getChiTietVe(String maVe, String maHD) {
		ChiTietVe ct = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from ChiTietVe where MaVe = ? and MaHD = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maVe);
            statement.setString(2, maHD);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            ct = new ChiTietVe(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }
	/**
	 * <B>Note:</B> Thêm ChiTietVe
	 * @param ChiTietVe
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themChiTietVe(ChiTietVe ctVe) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.ChiTietVe (MaVe, MaHD, SoLuongVe, NgayGioDat)"
                    + " values (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ctVe.getVe().getMaVe());
            stmt.setString(2, ctVe.getHoaDon().getMaHD());
            stmt.setInt(3, ctVe.getSoLuongVe());
            //set date time sql
            stmt.setTimestamp(4, Timestamp.valueOf(ctVe.getNgayGioDat()));
           
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
 		        if (stmt != null) {
 		            stmt.close();
 		        }
 		    } catch (SQLException e) {
 		        e.printStackTrace();
 		    }
        }
        return n > 0;
	}
	
	/**
	 *<B>Note:</B> Cập nhật ChiTietVe
	 *@author Khong Biet
	 *@param 
	 *@param 
	 *@return 
	 * 
	 */
	public boolean capNhatChiTietVe() {
		int n = 0;

        return n > 0;
	}
}
