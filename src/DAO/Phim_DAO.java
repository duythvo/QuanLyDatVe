package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phim;

public class Phim_DAO {
	private static Phim_DAO instance = new Phim_DAO(); 
	public static Phim_DAO getInstance() {
		return instance;
	}
	/**
	 * <B>Note:</B> Lấy danh sách các bộ phim
	 * @return Danh sách phim <ArrayList>
	 * 
	 */
	public ArrayList<Phim> getDSPhim() {
        ArrayList<Phim> dataList = new ArrayList<Phim>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.Phim";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Phim phim = new Phim(rs);
                dataList.add(phim);
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
	 * <B>Note:</B> Tìm phim khi biết mã phim
	 * @param maPhim
	 *@return Về 1 đối tượng phim hoặc null
	 * 
	 */
	public Phim getPhimBangMaPhim(String maPhim) {
        Phim phim = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from Phim where MaPhim = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maPhim);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            phim = new Phim(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phim;
    }
	/**
	 * <B>Note:</B> Thêm phim khi truyền 1 đối tượng vào Phim
	 * @param Phim phim
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themPhim(Phim phim) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.Phim (MaPhim, TenPhim, DaoDien, QuocGia, ThoiLuongPhim,MaLoaiPhim)"
                    + " values (?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phim.getMaPhim());
            stmt.setString(2, phim.getTenPhim());
            stmt.setString(3, phim.getDaoDien());
            stmt.setString(4, phim.getQuocGia());
            stmt.setInt(5, phim.getThoiLuongPhim());
            stmt.setString(6, phim.getLoaiPhim().getMaLoaiPhim());
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
	 *<B>Note:</B> Cập nhật tên Phim
	 *@param maPhim
	 *@param tenPhim
	 *@return true neu cap nhat duoc 1 dong tro len
	 * 
	 */
	public boolean capNhatTenPhim(String maPhim, String tenPhim) {
		int n = 0;
        PreparedStatement stmt = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String query = "update dbo.Phim set TenPhim = ?"
                + " Where MaPhim = ?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1, tenPhim);
            stmt.setString(2, maPhim);
            
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
