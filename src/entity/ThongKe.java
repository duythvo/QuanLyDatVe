package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKe {
    private String maNV;
    private String tenNV;
    private int soVe;
    private double tongTien;


    public ThongKe(String maNV, String tenNV, int soVe, double tongTien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soVe = soVe;
        this.tongTien = tongTien;
    }

    public ThongKe(String maNV) {
        this.maNV = maNV;
    }

    public ThongKe(ResultSet rs) throws SQLException {
        this.maNV = rs.getString("MaNV");
        this.tenNV = rs.getString("TenNV");
        this.soVe = rs.getInt("SoVe");
        this.tongTien = rs.getDouble("tongTien");
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


    public int getSoVe() {
        return soVe;
    }


    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }


    public double getTongTien() {
        return tongTien;
    }


    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "ThongKe [maNV=" + maNV + ", tenNV=" + tenNV + ", soVe=" + soVe + ", tongTien=" + tongTien + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        ThongKe other = (ThongKe) obj;
        if (maNV == null) {
            if (other.maNV != null)
                return false;
        } else if (!maNV.equals(other.maNV))
            return false;
        return true;
    }

    
    
}