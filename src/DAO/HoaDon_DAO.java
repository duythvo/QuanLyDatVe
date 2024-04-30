package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;

public class HoaDon_DAO {
	private static HoaDon_DAO instance = new HoaDon_DAO(); 
	public static  HoaDon_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy danh sách các Hóa Đơn
	 * @return Danh sách Hóa Đơn <ArrayList>
	 * 
	 */
	public ArrayList<HoaDon> getDSHoaDon() {
		ArrayList<HoaDon> dataList = new ArrayList<HoaDon> ();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.HoaDon";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	HoaDon hd = new HoaDon(rs);
                dataList.add(hd);
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
	 * <B>Note:</B> Tìm Hóa đơn khi biết mã HD
	 * @param maHD
	 *@return Về 1 đối tượng Hóa đơn hoặc null
	 * 
	 */
	public HoaDon getHoaDonBangMa(String maHD) {
		HoaDon hd = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from HoaDon where MaHD = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maHD);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            hd = new HoaDon(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hd;
    }
	/**
	 * <B>Note:</B> Thêm Hoa Don khi truyền vào 1 đối tượng vào Hóa Đơn
	 * @param HoaDon hd
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.HoaDon (MaHD, MaNV, TrangThai, NgayLap, GiaHoaDon)"
                    + " values (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, hd.getMaHD());
            stmt.setString(2, hd.getNhanVien().getMaNV());
            stmt.setInt(3, hd.getTrangThai());
            stmt.setDate(4, java.sql.Date.valueOf(hd.getNgayLap()));
            //sử dụng bigDecimal để đổi từ double sang decimal đưa vào database
            stmt.setBigDecimal(5, BigDecimal.valueOf(hd.getGiaHoaDon()));
           
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
	 *<B>Note:</B> Cập nhật HoaDon
	 *@author Khong biet
	 *@param 
	 *@param 
	 *@return 
	 * 
	 */
	public boolean capNhatHoaDon(String maHD, String trangThai) {
		int n = 0;

        return n > 0;
	}
}
