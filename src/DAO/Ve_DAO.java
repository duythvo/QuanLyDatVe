package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ve;

public class Ve_DAO {
	private static Ve_DAO instance = new Ve_DAO(); 
	public static  Ve_DAO getInstance() {
		return instance;
	}
	
	/**
	 * <B>Note:</B> Lấy danh sách các Ve
	 * @return Danh sách Vé <ArrayList>
	 * 
	 */
	public ArrayList<Ve> getDSVe() {
        ArrayList<Ve> dataList = new ArrayList<Ve>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.Ve";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Ve ve= new Ve(rs);
                dataList.add(ve);
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
	 * <B>Note:</B> Tìm Ve khi biết mã vé
	 * @param maVe
	 *@return Về 1 đối tượng Ve hoặc null
	 * 
	 */
	public Ve getVeBangMa(String maVe) {
		Ve ve = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from Ve where MaVe = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maVe);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            ve = new Ve(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ve;
    }
	/**
	 * <B>Note:</B> Thêm Ve khi truyền vào 1 đối tượng Ve
	 * @param Ve
	 *@return true (khi thêm thành công)
	 * 
	 */
	public boolean themVe(Ve ve) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "insert into dbo.Ve (MaVe, MaSuatChieu)"
                    + " values (?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ve.getMaVe());
            stmt.setString(2, ve.getSuatChieu().getMaSuatChieu());
           
           
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
	 *<B>Note:</B> Cập nhật Ve
	 *@author Khong biet
	 *@param 
	 *@param 
	 *@return 
	 * 
	 */
	public boolean capNhatVe() {
		int n = 0;

        return n > 0;
	}
}
