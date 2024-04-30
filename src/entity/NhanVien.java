package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import DAO.NhanVien_DAO;


public class NhanVien {
	private String maNV;
    private String tenNV;
    private String matKhau;
    private LocalDate ngaySinh;
    private String sdt;
    private String cccd;
    
    
    
	public NhanVien(String maNV, String tenNV, String matKhau, LocalDate ngaySinh, String sdt, String cccd) {
		super();
		setMaNV(maNV);
		setTenNV(tenNV);
		setMatKhau(matKhau);
		setNgaySinh(ngaySinh);
		setSdt(sdt);
		setCccd(cccd);
	}
	
	public NhanVien() {
		
	}
	//Set Nhan Vien khi Select 1 Nhan Vien bang ma
	public NhanVien(String maNV) {
		NhanVien_DAO nv_DAO = new NhanVien_DAO();
		NhanVien nv = nv_DAO.getNhanVienBangMaNV(maNV);
		setMaNV(maNV);
		setTenNV(nv.getTenNV());
		setMatKhau(nv.getMatKhau());
		setNgaySinh(nv.getNgaySinh());
		setSdt(nv.getSdt());
		setCccd(nv.getCccd());
	}
	
	public NhanVien(ResultSet rs) throws SQLException{
		this(rs.getString("MaNV"),rs.getString("TenNV"),rs.getString("MatKhau"),
				rs.getDate("NgaySinh").toLocalDate(),rs.getString("SDT"),rs.getString("CCCD"));
	}
	
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", matKhau=" + matKhau + ", ngaySinh=" + ngaySinh
				+ ", sdt=" + sdt + ", cccd=" + cccd + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
	
    
    
}
