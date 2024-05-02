package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.SuatChieu;

public class SuatChieu_DAO {
	private static SuatChieu_DAO instance = new SuatChieu_DAO(); 
	public static  SuatChieu_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy danh sách các Suât Chiếu
	 * @return Danh sách suất chiếu <ArrayList>
	 * 
	 */
	public ArrayList<SuatChieu> getDSSuatChieu() {
        ArrayList<SuatChieu> dataList = new ArrayList<SuatChieu>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.SuatChieu";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	SuatChieu suatchieu = new SuatChieu(rs);
                dataList.add(suatchieu);
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
	 * <B>Note:</B> Tìm Suât chiếu khi biết mã suất chiếu
	 * @param maSuatChieu
	 *@return Về 1 đối tượng suất chiếu hoặc null
	 * 
	 */
	public SuatChieu getSuatChieuBangMa(String maSuatChieu) {
        SuatChieu suatchieu = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from SuatChieu where MaSuatChieu = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maSuatChieu);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            suatchieu = new SuatChieu(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suatchieu;
    }

    public ArrayList<SuatChieu> getdsSuatChieuBangMaPhim(String maPhim){
        ArrayList<SuatChieu> dataList = new ArrayList<SuatChieu>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.SuatChieu WHERE MaPhim = ?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maPhim);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	SuatChieu suatchieu = new SuatChieu(rs);
                dataList.add(suatchieu);
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
	 * <B>Note:</B> Thêm Suất chiếu khi truyền vào 1 đối tượng Suất Chiếu
	 * @param SuatChieu suatchieu
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themSuatChieu(SuatChieu suatChieu) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.SuatChieu (MaSuatChieu, NgayChieu, GioChieu, MaPhim, MaPhongChieu)"
                    + " values (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, suatChieu.getMaSuatChieu());
            stmt.setDate(2, java.sql.Date.valueOf(suatChieu.getNgayChieu()));
            stmt.setTime(3, java.sql.Time.valueOf(suatChieu.getGioChieu()));
            stmt.setString(4, suatChieu.getPhim().getMaPhim());
            stmt.setString(5, suatChieu.getPhongChieu().getMaPhongChieu());
           
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
	 *<B>Note:</B> Cập nhật Suất Chiếu
	 *@author Khoa
	 *@param 
	 *@param 
	 *@return 
	 * 
	 */
	public boolean capNhatSuatChieu(String maPhim, String tenPhim) {
		int n = 0;

        return n > 0;
	}
}
