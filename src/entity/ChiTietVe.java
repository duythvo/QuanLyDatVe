package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import DAO.ChiTietVe_DAO;


//import java.sql.*;
//import DAO.*;


public class ChiTietVe {
	private Ve ve;
    private HoaDon hoaDon;
    private int soLuongGhe;
    private LocalDateTime ngayGioDat;
	public ChiTietVe(Ve ve, HoaDon hoaDon, int soLuongGhe, LocalDateTime ngayGioDat) {
		super();
		setVe(ve);
		setHoaDon(hoaDon);
		setSoLuongGhe(soLuongGhe);
		setNgayGioDat(ngayGioDat);
	}
    
    public ChiTietVe() {
		// TODO Auto-generated constructor stub
	}
    
    //chua set DAO
    public ChiTietVe(String maVe, String maHD) {
		ChiTietVe_DAO ct_dao = new ChiTietVe_DAO();
		ChiTietVe ctve = ct_dao.getChiTietVe(maVe, maHD);
		setVe(ctve.getVe());
		setHoaDon(ctve.getHoaDon());
		setSoLuongGhe(ctve.getSoLuongVe());
		setNgayGioDat(ctve.getNgayGioDat());
	}
    
    public ChiTietVe(ResultSet rs) throws SQLException {
    	 this.ve = new Ve(rs.getString("MaVe"));
    	 this.hoaDon = new HoaDon(rs.getString("MaHD"));
		 this.soLuongGhe = rs.getInt("SoLuongGhe");
		 this.ngayGioDat= rs.getTimestamp("NgayGioDat").toLocalDateTime();
	}

	public Ve getVe() {
		return ve;
	}

	public void setVe(Ve ve) {
		this.ve = ve;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuongVe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public LocalDateTime getNgayGioDat() {
		return ngayGioDat;
	}

	public void setNgayGioDat(LocalDateTime ngayGioDat) {
		this.ngayGioDat = ngayGioDat;
	}

	@Override
	public String toString() {
		return "ChiTietVe [Ve=" +ve + ", hoaDon=" + hoaDon + ", soLuongGhe=" + soLuongGhe + ", ngayGioDat="
				+ ngayGioDat + "]";
	}


    
    
}
