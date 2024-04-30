package entity;
//import java.sql.*;
//import DAO.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import DAO.LoaiPhim_DAO;

public class LoaiPhim {
	private String maLoaiPhim;
    private String tenLoaiPhim;
	public LoaiPhim(String maLoaiPhim, String tenLoaiPhim) {
		super();
		setMaLoaiPhim(maLoaiPhim);
		setTenLoaiPhim(tenLoaiPhim);
	}
    
	public LoaiPhim() {
		
	}

	public LoaiPhim(String maLoaiPhim) {
		LoaiPhim_DAO loaiphim_dao = new LoaiPhim_DAO();
		LoaiPhim loaiphim = loaiphim_dao.getLoaiPhimBangMaLoaiPhim(maLoaiPhim);
		this.maLoaiPhim = loaiphim.getMaLoaiPhim();
		this.tenLoaiPhim = loaiphim.getTenLoaiPhim();
	}
	
	public LoaiPhim(ResultSet rs) throws SQLException {
		this.maLoaiPhim = rs.getString("MaLoaiPhim");
		this.tenLoaiPhim = rs.getString("TenLoaiPhim");
	}

	public String getMaLoaiPhim() {
		return maLoaiPhim;
	}

	public void setMaLoaiPhim(String maLoaiPhim) {
		this.maLoaiPhim = maLoaiPhim;
	}

	public String getTenLoaiPhim() {
		return tenLoaiPhim;
	}

	public void setTenLoaiPhim(String tenLoaiPhim) {
		this.tenLoaiPhim = tenLoaiPhim;
	}


	@Override
	public String toString() {
		return "LoaiPhim [maLoaiPhim=" + maLoaiPhim + ", tenLoaiPhim=" + tenLoaiPhim + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhim);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhim other = (LoaiPhim) obj;
		return Objects.equals(maLoaiPhim, other.maLoaiPhim);
	}
	
	
    
}	

