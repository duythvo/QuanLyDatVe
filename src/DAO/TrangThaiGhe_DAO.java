package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TrangThaiGhe;

public class TrangThaiGhe_DAO {
    private static TrangThaiGhe_DAO instance = new TrangThaiGhe_DAO(); 
	public static  TrangThaiGhe_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy bảng ChiTietVe
	 * @return  <ArrayList>
	 * 
	 */
	public ArrayList<TrangThaiGhe> getDSTrangThaiGhe() {
        ArrayList<TrangThaiGhe> dataList = new ArrayList<TrangThaiGhe>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.TrangThaiGhe";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	TrangThaiGhe ctVe = new TrangThaiGhe(rs);
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
	public TrangThaiGhe getTrangThaiGhe(String maGhe, String maSuatChieu) {
		TrangThaiGhe ttg = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from TrangThaiGhe where MaGhe = ? and MaSuatChieu = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maGhe);
            statement.setString(2, maSuatChieu);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            ttg = new TrangThaiGhe(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttg;
    }
	
}