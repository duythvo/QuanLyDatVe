package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongChieu;

public class PhongChieu_DAO {
private static PhongChieu_DAO instance = new PhongChieu_DAO();
	
	public static PhongChieu_DAO Instance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy danh sách các phòng chiếu
	 * @return Danh sách Phòng chiếu
	 * 
	 */
	public ArrayList<PhongChieu> getDSPhongChieu() {
        ArrayList<PhongChieu> dataList = new ArrayList<PhongChieu>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.PhongChieu";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PhongChieu phong = new PhongChieu(rs);
                dataList.add(phong);
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
	 * <B>Note:</B> Tìm Phòng chiếu khi biết mã Phòng Chiếu
	 * @param maPhong
	 *@return Về 1 đối tượng PhongChieu hoặc null
	 * 
	 */
	public PhongChieu getPhongChieuBangMaPhongChieu(String maPhongChieu) {
        PhongChieu phong = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from PhongChieu where MaPhongChieu = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maPhongChieu);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            phong = new PhongChieu(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phong;
    }
	
	/**
	 * <B>Note:</B> Thêm Phong Chieu khi truyền vào 1 đối tuọng
	 * @param PhongChieu phongChieu
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themPhongChieu(PhongChieu phongChieu) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.PhongChieu (MaPhongChieu, TenPhongChieu, ViTri, SucChua)"
                    + " values (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phongChieu.getMaPhongChieu());
            stmt.setString(2, phongChieu.getTenPhongChieu());
            stmt.setString(3, phongChieu.getViTri());
            stmt.setInt(4, phongChieu.getSucChua());
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
	 *<B>Note:</B> Cập nhật Phòng Chiếu
	 *@param maPhongChieu
	 *@param tenPhongChieu
	 *@return true neu cap nhat duoc 1 dong tro len
	 * 
	 */
	public boolean capNhatTenPhongChieu(String maPhongChieu, String tenPhongChieu) {
		int n = 0;
        PreparedStatement stmt = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String query = "update dbo.PhongChieu set TenPhongChieu = ?"
                + " Where MaPhongChieu = ?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, tenPhongChieu);
            stmt.setString(2, maPhongChieu);
            
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
}
