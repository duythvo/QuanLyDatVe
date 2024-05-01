package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.TrangThaiGhe_DAO;

public class TrangThaiGhe {
    private Ghe ghe;
    private SuatChieu suatChieu;
    private Ve ve;
    private boolean trangThai;

    public TrangThaiGhe(Ghe ghe, SuatChieu suatChieu, Ve ve, boolean trangThai) {
        this.ghe = ghe;
        this.suatChieu = suatChieu;
        this.ve = ve;
        this.trangThai = trangThai;
    }

    public TrangThaiGhe() {
    }

    public TrangThaiGhe(String maGhe, String maSuatChieu) {
        TrangThaiGhe_DAO ghe_dao = new TrangThaiGhe_DAO();
		TrangThaiGhe ghe = ghe_dao.getTrangThaiGhe(maGhe, maSuatChieu);
		setGhe(ghe.getGhe());
        setSuatChieu(ghe.getSuatChieu());
        setVe(ghe.getVe());
        setTrangThai(ghe.isTrangThai());
    }

    public TrangThaiGhe(ResultSet rs) throws SQLException {
        this.ghe = new Ghe(rs.getString("MaGhe"));
        this.suatChieu = new SuatChieu(rs.getString("MaSuatChieu"));
        if(rs.getString("MaVe") == null) {
            this.ve = new Ve();
        }else {
            this.ve = new Ve(rs.getString("MaVe"));
        }
        this.trangThai = rs.getBoolean("TrangThai");
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public SuatChieu getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public Ve getVe() {
        return ve;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TrangThaiGhe [ghe=" + ghe + ", suatChieu=" + suatChieu + ", ve=" + ve + ", trangThai=" + trangThai
                + "]";
    }

    

}