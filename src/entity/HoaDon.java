package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.sql.*;
//import DAO.*;
import java.util.Objects;

import DAO.HoaDon_DAO;
import DAO.SuatChieu_DAO;


public class HoaDon {
	private String maHD;
    private NhanVien nhanVien;
    private int trangThai;
    private LocalDate ngayLap;
    private double giaHoaDon;
    
    
    public HoaDon(String maHD, NhanVien nhanVien, int trangThai, LocalDate ngayLap, double giaHoaDon) {
		super();
		setMaHD(maHD);
		setNhanVien(nhanVien);
		setTrangThai(trangThai);
		setNgayLap(ngayLap);
		setGiaHoaDon(giaHoaDon);
	}

	public HoaDon(String maHD, NhanVien nv) {
		this.maHD = maHD;
		this.nhanVien = nv;
		this.trangThai = 0;
		this.ngayLap = LocalDate.now();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(ResultSet rs) throws SQLException{
		 this.maHD = rs.getString("MaHD");
		 this.nhanVien = new NhanVien(rs.getString("MaNV"));
		 this.trangThai= rs.getInt("TrangThai");
		 this.ngayLap = rs.getDate("NgayLap").toLocalDate();
		 this.giaHoaDon = rs.getDouble("GiaHoaDon");
	}
    
    public HoaDon(String maHD) {
    	HoaDon_DAO hd_dao = new HoaDon_DAO();
		HoaDon hd = hd_dao.getHoaDonBangMa(maHD);
		setMaHD(maHD);
		setNhanVien(hd.getNhanVien());
		setTrangThai(hd.getTrangThai());
		setNgayLap(hd.getNgayLap());
		setGiaHoaDon(hd.getGiaHoaDon());
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getGiaHoaDon() {
		return giaHoaDon;
	}

	public void setGiaHoaDon(double giaHoaDon) {
		this.giaHoaDon = giaHoaDon;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", nhanVien=" + nhanVien + ", trangThai=" + trangThai + ", ngayLap=" + ngayLap
				+ ", giaHoaDon=" + giaHoaDon + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
    
    
}
