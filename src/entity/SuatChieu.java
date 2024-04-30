package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import DAO.SuatChieu_DAO;

//import java.sql.*;
//import DAO.*;


public class SuatChieu {
	private String maSuatChieu;
	private LocalDate ngayChieu;
	private LocalTime gioChieu;
	private Phim phim;
	private PhongChieu phongChieu;
	 
	 
	 
	public SuatChieu(String maSuatChieu, LocalDate ngayChieu, LocalTime gioChieu, Phim phim, PhongChieu phongChieu) {
		super();
		setMaSuatChieu(maSuatChieu);
		setNgayChieu(ngayChieu);
		setGioChieu(gioChieu);
		setPhim(phim);
		setPhongChieu(phongChieu);
	}
	
	public SuatChieu() {
		// TODO Auto-generated constructor stub
	}
	
	public SuatChieu(String maSuatChieu, Phim phim, PhongChieu phongChieu) {
		this.maSuatChieu = maSuatChieu;
		this.phim = phim;
		this.phongChieu = phongChieu;
	}
	//chua set DAO
	public SuatChieu(String maSuatChieu) {
		SuatChieu_DAO suatchieu_dao = new SuatChieu_DAO();
		SuatChieu suatchieu = suatchieu_dao.getSuatChieuBangMa(maSuatChieu);
		setMaSuatChieu(maSuatChieu);
		setNgayChieu(suatchieu.getNgayChieu());
		setGioChieu(suatchieu.getGioChieu());
		setPhim(suatchieu.getPhim());
		setPhongChieu(suatchieu.getPhongChieu());
	}
	
	public SuatChieu(ResultSet rs) throws SQLException{
		 this.maSuatChieu = rs.getString("MaSuatChieu");
		 this.ngayChieu = rs.getDate("NgayChieu").toLocalDate();
		 this.gioChieu= rs.getTime("GioChieu").toLocalTime();
		 this.phim = new Phim(rs.getString("MaPhim"));
		 this.phongChieu= new PhongChieu(rs.getString("MaPhongChieu"));
	}
	
	public String getMaSuatChieu() {
		return maSuatChieu;
	}
	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}
	public LocalDate getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(LocalDate ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	public LocalTime getGioChieu() {
		return gioChieu;
	}
	public void setGioChieu(LocalTime gioChieu) {
		this.gioChieu = gioChieu;
	}
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}

	@Override
	public String toString() {
		return "SuatChieu [maSuatChieu=" + maSuatChieu + ", ngayChieu=" + ngayChieu + ", gioChieu=" + gioChieu
				+ ", phim=" + phim + ", phongChieu=" + phongChieu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSuatChieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuatChieu other = (SuatChieu) obj;
		return Objects.equals(maSuatChieu, other.maSuatChieu);
	}
	
	
	 
}
