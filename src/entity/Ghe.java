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
    private LoaiGhe loaiGhe;
	public Ghe(String maGhe, PhongChieu phongChieu, LoaiGhe loaiGhe) {
		super();
		setMaGhe(maGhe);
		setPhongChieu(phongChieu);
		setLoaiGhe(loaiGhe);
	}
	public Ghe() {
		// TODO Auto-generated constructor stub
	}
	//Tao đối tượng nếu truyền vào 1 mã Ghế(Tìm các thông tin khác trong data gan vo)
	public Ghe(String maGhe) {
		// TODO Auto-generated constructor stub
		Ghe_DAO ghe_dao = new Ghe_DAO();
		Ghe ghe = ghe_dao.getGhe(maGhe);
		setMaGhe(ghe.getMaGhe());
		setPhongChieu(ghe.getPhongChieu());
		setLoaiGhe(ghe.getLoaiGhe());
	}
	
	public Ghe(ResultSet rs) throws SQLException {
		 this.maGhe= rs.getString("MaGhe");
		 this.phongChieu = new PhongChieu(rs.getString("MaPhongChieu"));
		 // Null do Ghế chưa có Đặt bởi 1 vé nào cả
		//  if(rs.getString("MaVe") == null) {
		// 	 this.ve = new Ve();
		//  }else {
		// 	 this.ve = new Ve(rs.getString("MaVe"));
		//  }
		 
		 this.loaiGhe = new LoaiGhe(rs.getInt("MaLoaiGhe"));
		
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

	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}
	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}
	
	
	@Override
	public String toString() {
		return "Ghe [maGhe=" + maGhe + ", phongChieu=" + phongChieu + ", loaiGhe=" + loaiGhe + "]";
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