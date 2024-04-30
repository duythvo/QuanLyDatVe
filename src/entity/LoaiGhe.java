package entity;
//import java.sql.*;
//import DAO.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import DAO.LoaiGhe_DAO;

public class LoaiGhe {
	 private int maLoaiGhe;
	 private double gia;
	 private String tenLoaiGhe;
	public LoaiGhe(int maLoaiGhe, double gia, String tenLoaiGhe) {
		super();
		setMaLoaiGhe(maLoaiGhe);
		setGia(gia);
		setTenLoaiGhe(tenLoaiGhe);
	}
	 
	public LoaiGhe() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LoaiGhe(int maLoaiGhe) {
		LoaiGhe_DAO loaighe_dao = new LoaiGhe_DAO();
		LoaiGhe loaighe = loaighe_dao.getLoaiGheBangMaLoaiGhe(maLoaiGhe);
		setMaLoaiGhe(loaighe.getMaLoaiGhe());
		setGia(loaighe.getGia());
		setTenLoaiGhe(loaighe.getTenLoaiGhe());
	}
	
	public LoaiGhe(ResultSet rs) throws SQLException{
		this(rs.getInt("MaLoaiGhe"), rs.getDouble("Gia"), rs.getString("TenLoaiGhe"));
	}

	public int getMaLoaiGhe() {
		return maLoaiGhe;
	}

	public void setMaLoaiGhe(int maLoaiGhe) {
		this.maLoaiGhe = maLoaiGhe;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTenLoaiGhe() {
		return tenLoaiGhe;
	}

	public void setTenLoaiGhe(String tenLoaiGhe) {
		this.tenLoaiGhe = tenLoaiGhe;
	}

	@Override
	public String toString() {
		return "LoaiGhe [maLoaiGhe=" + maLoaiGhe + ", gia=" + gia + ", tenLoaiGhe=" + tenLoaiGhe + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiGhe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiGhe other = (LoaiGhe) obj;
		return maLoaiGhe == other.maLoaiGhe;
	}
	
	
}
