package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ghe;

public class Ghe_DAO {
	private static Ghe_DAO instance = new Ghe_DAO(); 
	public static  Ghe_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy danh sách các Ghe
	 * @return Danh sách Ghe <ArrayList>
	 * 
	 */
	public ArrayList<Ghe> getDSHoaDon() {
		ArrayList<Ghe> dataList = new ArrayList<Ghe> ();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.Ghe";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Ghe ghe = new Ghe(rs);
                dataList.add(ghe);
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
	 * <B>Note:</B> Tìm Ghe khi biet ma Ghe
	 * @param maGhe
	 *@return Về 1 đối tượng Ghe hoặc null
	 * 
	 */
	public Ghe getGhe(String maGhe) {
		Ghe ghe = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from Ghe where MaGhe = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maGhe);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            ghe = new Ghe(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ghe;
    }
	/**
	 * <B>Note:</B> Thêm Ghe khi truyền vào 1 đối tượng vào Ghe
	 * @param Ghe ghe
	 *@return true (khi thêm thành công)
	 * Có data rồi muốn thêm thì viết
	 */
	public boolean themGhe() {
		return true;
	}
	
	/**
	 *<B>Note:</B> Cập nhật Trang Thai Ghe
	 *@author Khong biet
	 *@param 
	 *@param 
	 *@return 
	 * 
	 */
	public boolean capNhatTrangThaiGhe() {
		int n = 0;

        return n > 0;
	}
}
