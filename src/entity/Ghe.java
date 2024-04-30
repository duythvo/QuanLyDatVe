package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
//import java.sql.*;
//import DAO.*;

import DAO.Ghe_DAO;

public class Ghe {
	private String maGhe;
    private PhongChieu phongChieu;
    private Ve ve;
    private LoaiGhe loaiGhe;
    private boolean trangThai;
	public Ghe(String maGhe, PhongChieu phongChieu, Ve ve, LoaiGhe loaiGhe, boolean trangThai) {
		super();
		setMaGhe(maGhe);
		setPhongChieu(phongChieu);
		setVe(ve);
		setLoaiGhe(loaiGhe);
		setTrangThai(trangThai);
	}
	public Ghe() {
		// TODO Auto-generated constructor stub
	}
	//Tao đối tượng nếu truyền vào 1 mã Ghế(Tìm các thông tin khác trong data gan vo)
	public Ghe(String maGhe) {
		// TODO Auto-generated constructor stub
		Ghe_DAO ghe_dao = new Ghe_DAO();
		Ghe ghe = ghe_dao.getGhe(maGhe);
		setPhongChieu(ghe.getPhongChieu());
		setVe(ghe.getVe());
		setLoaiGhe(ghe.getLoaiGhe());
		setTrangThai(ghe.isTrangThai());
	}
	
	public Ghe(ResultSet rs) throws SQLException {
		 this.maGhe= rs.getString("MaGhe");
		 this.phongChieu = new PhongChieu(rs.getString("MaPhongChieu"));
		 // Null do Ghế chưa có Đặt bởi 1 vé nào cả
		 if(rs.getString("MaVe") == null) {
			 this.ve = new Ve();
		 }else {
			 this.ve = new Ve(rs.getString("MaVe"));
		 }
		 
		 this.loaiGhe = new LoaiGhe(rs.getInt("MaLoaiGhe"));
		 this.trangThai = rs.getBoolean("trangthai");
	}
	
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
	public Ve getVe() {
		return ve;
	}
	public void setVe(Ve ve) {
		this.ve = ve;
	}
	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "Ghe [maGhe=" + maGhe + ", phongChieu=" + phongChieu + ", ve=" + ve + ", loaiGhe=" + loaiGhe
				+ ", trangThai=" + trangThai + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maGhe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ghe other = (Ghe) obj;
		return Objects.equals(maGhe, other.maGhe);
	}
    
    
}
