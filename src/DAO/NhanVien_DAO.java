package DAO;
import java.util.*;

import connectDB.ConnectDB;

import java.sql.*;

import entity.NhanVien;
public class NhanVien_DAO {
	private static NhanVien_DAO instance = new NhanVien_DAO();
	
	public static NhanVien_DAO getInstance() {
		return instance;
	}
	/**
	 *<B>Note:</B> Lấy danh sách nhân viên
	 *@return danhSachNV
	 * 
	 */
	public ArrayList<NhanVien> getDSNhanVien(){
		ArrayList<NhanVien> danhSachNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Statement stmt = null;
		
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.NhanVien";
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs);
				danhSachNV.add(nv);
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
		return danhSachNV;
	}
	
	/**
	 *<B>Note:</B> lấy 1 nhân viên bằng mã
	 *@param maNV
	 *@return 1 đối tượng NhanVien
	 * 
	 */
	public NhanVien getNhanVienBangMaNV(String maNV) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
			
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * FROM dbo.NhanVien where MaNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			
			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
				return null;
			
			nv = new NhanVien(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}
	
	/**
	 *<B>Note:</B> Lấy mã nhân viên vừa mới thêm
	 *@return mã Phim
	 */
	public String getMaNVMoiNhat() {
		String maNV = "";
		ConnectDB.getInstance();
		Statement stmt = null;
		
		try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.NhanVien";
            //chi cho phep doc du lieu khi duyet qua cac dong
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            maNV = rs.getString("MaNV");
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
        return maNV;
	}
	/**
	 *<B>Note:</B> Thêm 1 nhân viên
	 *@param NhanVien nv
	 *@return true nếu thêm thành công
	 * 
	 */
	public boolean themNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "Insert into dbo.NhanVien (MaNV, TenNV, MatKhau, NgaySinh, SDT, CCCD)"
                    + " values (?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setString(3, nv.getMatKhau());
            stmt.setDate(4, java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setString(5, nv.getSdt());
            stmt.setString(6, nv.getCccd());
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
