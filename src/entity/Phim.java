package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import DAO.Phim_DAO;
//import java.sql.*;
//import DAO.*;


public class Phim {
	private String maPhim;
	private String tenPhim;
	private String daoDien;
	private String quocGia;
	private int thoiLuongPhim;
	private LoaiPhim loaiPhim;
	
	
	
	public Phim(String maPhim, String tenPhim, String daoDien, String quocGia, int thoiLuongPhim,LoaiPhim loaiPhim) {
		super();
		setMaPhim(maPhim);
		setTenPhim(tenPhim);
		setDaoDien(daoDien);
		setQuocGia(quocGia);
		setThoiLuongPhim(thoiLuongPhim);
		setLoaiPhim(loaiPhim);
	}
	
	public Phim(String maPhim) {
		Phim_DAO phim_dao = new Phim_DAO();
		Phim phim = phim_dao.getPhimBangMaPhim(maPhim);
		setMaPhim(maPhim);
		setTenPhim(phim.getTenPhim());
		setDaoDien(phim.getDaoDien());
		setQuocGia(phim.getQuocGia());
		setThoiLuongPhim(phim.getThoiLuongPhim());
		setLoaiPhim(phim.getLoaiPhim());
	}
	
	public Phim(String maPhim, LoaiPhim loaiPhim) {
		this.maPhim = maPhim;
		this.loaiPhim = loaiPhim;
	}
	
	
	public Phim(ResultSet rs) throws SQLException{
		 this.maPhim = rs.getString("MaPhim");
		 this.tenPhim = rs.getString("TenPhim");
		 this.daoDien = rs.getString("DaoDien");
		 this.quocGia = rs.getString("QuocGia");
		 this.thoiLuongPhim = rs.getInt("ThoiLuongPhim");
		 this.loaiPhim = new LoaiPhim(rs.getString("MaLoaiPhim"));
	}
	
	
	
	
	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	
	public LoaiPhim getLoaiPhim() {
		return loaiPhim;
	}
	public void setLoaiPhim(LoaiPhim loaiPhim) {
		this.loaiPhim = loaiPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public int getThoiLuongPhim() {
		return thoiLuongPhim;
	}
	public void setThoiLuongPhim(int thoiLuongPhim) {
		this.thoiLuongPhim = thoiLuongPhim;
	}
	
	
	
	@Override
	public String toString() {
		return "Phim [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", daoDien=" + daoDien + ", quocGia=" + quocGia
				+ ", thoiLuongPhim=" + thoiLuongPhim + ", loaiPhim=" + loaiPhim + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhim, tenPhim, thoiLuongPhim);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phim other = (Phim) obj;
		return Objects.equals(maPhim, other.maPhim) && Objects.equals(tenPhim, other.tenPhim)
				&& thoiLuongPhim == other.thoiLuongPhim;
	}

	
	

}
