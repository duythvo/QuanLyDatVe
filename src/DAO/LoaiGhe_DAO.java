package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiGhe;

public class LoaiGhe_DAO {
	private static LoaiGhe_DAO instance = new LoaiGhe_DAO();
	public static LoaiGhe_DAO getInstance() {
		return instance;
	}
	/**
	 * <B>Note:</B> Lấy danh sách các loại ghế
	 * @return Danh sách loại ghế
	 * 
	 */
	public ArrayList<LoaiGhe> getDSLoaiGhe() {
        ArrayList<LoaiGhe> dataList = new ArrayList<LoaiGhe>();
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.LoaiGhe";
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LoaiGhe loai = new LoaiGhe(rs);
                dataList.add(loai);
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
	 * <B>Note:</B> Tìm loai ghế khi biết mã loại
	 * @param maLoaiGhe
	 *@return Về 1 đối tượng Loại Ghế hoặc null
	 * 
	 */
	public LoaiGhe getLoaiGheBangMaLoaiGhe(int maLoaiGhe) {
		LoaiGhe loai = null;
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from LoaiGhe where MaLoaiGhe = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, maLoaiGhe);
            ResultSet rs = statement.executeQuery();

            if (!rs.next())
                return null;

            loai = new LoaiGhe(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loai;
    }

}
