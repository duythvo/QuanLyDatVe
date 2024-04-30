package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import DAO.PhongChieu_DAO;
//import java.sql.*;
//import DAO.*;


public class PhongChieu {
	private String maPhongChieu;
    private String tenPhongChieu;
    private String viTri;
    private int sucChua;
	public PhongChieu(String maPhongChieu, String tenPhongChieu, String viTri, int sucChua) {
		super();
		setMaPhongChieu(maPhongChieu);
		setTenPhongChieu(tenPhongChieu);
		setViTri(viTri);
		setSucChua(sucChua);
	}
    
    public PhongChieu() {
		// TODO Auto-generated constructor stub
	}
   
    public PhongChieu(String maPhongChieu) {
		PhongChieu_DAO phong = new PhongChieu_DAO();
		PhongChieu pc = phong.getPhongChieuBangMaPhongChieu(maPhongChieu);
		setMaPhongChieu(maPhongChieu);
		setTenPhongChieu(pc.getTenPhongChieu());
		setViTri(pc.getViTri());
		setSucChua(pc.getSucChua());
	}
    
    public PhongChieu(ResultSet rs) throws SQLException{
    	this(rs.getString("MaPhongChieu"),rs.getString("TenPhongChieu"),
    			rs.getString("ViTri"),rs.getInt("SucChua"));
    }

	public String getMaPhongChieu() {
		return maPhongChieu;
	}

	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}

	public String getTenPhongChieu() {
		return tenPhongChieu;
	}

	public void setTenPhongChieu(String tenPhongChieu) {
		this.tenPhongChieu = tenPhongChieu;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhongChieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongChieu other = (PhongChieu) obj;
		return Objects.equals(maPhongChieu, other.maPhongChieu);
	}

	@Override
	public String toString() {
		return "PhongChieu [maPhongChieu=" + maPhongChieu + ", tenPhongChieu=" + tenPhongChieu + ", viTri=" + viTri
				+ ", sucChua=" + sucChua + "]";
	}
    
    
}
