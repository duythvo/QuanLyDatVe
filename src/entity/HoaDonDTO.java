
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HoaDonDTO {

    private String maVe;
    private String tenPhim;
    private LocalDate ngayLap;
    private double giaHoaDon;
    private int trangThai;

    public HoaDonDTO(){
        
    }
    
    public HoaDonDTO(String maVe, String tenPhim, LocalDate ngayLap, double giaHoaDon, int trangThai) {
        this.maVe = maVe;
        this.tenPhim = tenPhim;
        this.ngayLap = ngayLap;
        this.giaHoaDon = giaHoaDon;
        this.trangThai = trangThai;
    }

    	public HoaDonDTO(ResultSet rs) throws SQLException{
		 this.maVe = rs.getString("MaVe");  
		 this.tenPhim = rs.getString("TenPhim");
		 this.ngayLap = rs.getDate("NgayLap").toLocalDate();
		 this.giaHoaDon = rs.getDouble("GiaHoaDon");
		 this.trangThai= rs.getInt("TrangThai");
	}

    public HoaDonDTO(String maVe) {
        this.maVe = maVe;
    }

    
    public String getMaVe() {
        return maVe;
    }
    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }
    public String getTenPhim() {
        return tenPhim;
    }
    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
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
    public int getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonDTO [maVe=" + maVe + ", tenPhim=" + tenPhim + ", ngayLap=" + ngayLap + ", giaHoaDon=" + giaHoaDon
                + ", trangThai=" + trangThai + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maVe == null) ? 0 : maVe.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        HoaDonDTO other = (HoaDonDTO) obj;
        if (maVe == null) {
            if (other.maVe != null)
                return false;
        } else if (!maVe.equals(other.maVe))
            return false;
        return true;
    }

    
    
}