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
import entity.HoaDonDTO;
import entity.ThongKe;

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

	public ArrayList<HoaDonDTO> getDSTrangThai() {
		ArrayList<HoaDonDTO> dataList = new ArrayList<>();
		ConnectDB.getInstance();
		Statement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT ctv.MaVe, p.TenPhim, hd.NgayLap, hd.GiaHoaDon, hd.TrangThai " +
						 "FROM HoaDon hd " +
						 "INNER JOIN ChiTietVe ctv ON hd.MaHD = ctv.MaHD " +
						 "INNER JOIN Ve v ON v.MaVe = ctv.MaVe " +
						 "INNER JOIN SuatChieu sc ON v.MaSuatChieu = sc.MaSuatChieu " +
						 "INNER JOIN Phim p ON sc.MaPhim = p.MaPhim";
			stmt = con.createStatement();
	
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
            HoaDonDTO dto = new HoaDonDTO(rs);
				dataList.add(dto);
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
	public boolean capNhatHoaDon(String maVe) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;int n = 0;
		try {
			stmt = con.prepareStatement("update HoaDon set TrangThai = 1 from HoaDon h inner join ChiTietVe ctv on h.MaHD = ctv.MaHD where MaVe = ?");
			stmt.setString(1, maVe);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<ThongKe> thongKeDoanhThu(String tuNgay, String denNgay) {
		ArrayList<ThongKe> dataList = new ArrayList<>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT hd.MaNV, nv.TenNV, COUNT(ctv.MaVe) AS SoVe, SUM(hd.GiaHoaDon) AS tongTien " +
										"FROM NhanVien nv " +
										"INNER JOIN HoaDon hd ON nv.MaNV = hd.MaNV " +
										"INNER JOIN ChiTietVe ctv ON ctv.MaHD = hd.MaHD " +
										"WHERE hd.TrangThai = 1 AND hd.NgayLap > ? AND hd.NgayLap < ? " +
										"GROUP BY hd.MaNV, nv.TenNV");
			stmt.setString(1, tuNgay);
			stmt.setString(2, denNgay);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ThongKe tk = new ThongKe(rs);
				dataList.add(tk);
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
	
	

}