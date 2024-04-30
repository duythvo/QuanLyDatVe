package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhim;

public class LoaiPhim_DAO {
	private static LoaiPhim_DAO instance = new LoaiPhim_DAO();

    public static LoaiPhim_DAO getInstance() {
        return instance;
    }
    
    /**
	 *<B>Note:</B> Lấy danh sách loại phim
	 *@return dsphim
	 * 
	 */
    public ArrayList<LoaiPhim> getDSLoaiPhim() {
        ArrayList<LoaiPhim> dsloaiphim = new ArrayList<LoaiPhim>();
        try {
            ConnectDB.getInstance();
            Connection conn = ConnectDB.getConnection();

            String sql = "Select * from LoaiPhim";
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                LoaiPhim loaiPhim = new LoaiPhim(rs);
                dsloaiphim.add(loaiPhim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsloaiphim;
    }
    
    public LoaiPhim getLoaiPhimBangMaLoaiPhim(String maLoaiPhim) {
    	LoaiPhim loaiPhim = null;
    	
    	 try {
             ConnectDB.getInstance();
             Connection conn = ConnectDB.getConnection();

             String sql = "Select * from LoaiPhim where MaLoaiPhim = ?";
             PreparedStatement statement = conn.prepareStatement(sql);
             statement.setString(1, maLoaiPhim);
             ResultSet rs = statement.executeQuery();

             if (!rs.next())
                 return null;

             loaiPhim = new LoaiPhim(rs);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return loaiPhim;
    }
}
