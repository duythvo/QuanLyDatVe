package entity;
//import java.sql.*;
//import DAO.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import DAO.Ve_DAO;

public class Ve {
	private String maVe;
	private SuatChieu suatChieu;
	public Ve(String maVe, SuatChieu suatChieu) {
		super();
		setMaVe(maVe);
		setSuatChieu(suatChieu);
	}
	
	public Ve() {
		
	}
	
	public Ve(String maVe) {
		Ve_DAO ve_dao = new Ve_DAO();
		Ve ve = ve_dao.getVeBangMa(maVe);
		setMaVe(ve.getMaVe());
		setSuatChieu(ve.getSuatChieu());
	}
	
	public Ve(ResultSet rs) throws SQLException {
		this.maVe = rs.getString("MaVe");
		this.suatChieu = new SuatChieu(rs.getString("MaSuatChieu"));
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public SuatChieu getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}

	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", suatChieu=" + suatChieu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		return Objects.equals(maVe, other.maVe);
	}
	
	
}
