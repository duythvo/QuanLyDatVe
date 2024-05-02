package Controller;


import entity.*;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.HoaDon_DAO;

public class control_ThongKe {


    HoaDon_DAO hdao = new HoaDon_DAO();
    Collection_ThongKe dsTK = new Collection_ThongKe();
    private JTable table;
    private JButton btn_ThongKe;
    private JButton btn_TimNV;
    private JButton btn_LamMoi;
	private JTextField txtTuNgay;
	private JTextField txt_DenNgay;
	private JTextField txt_NhanVien;


    public control_ThongKe( JTable table, JButton btn_ThongKe, JButton btn_TimNV, JButton btn_LamMoi,JTextField txtTuNgay,JTextField txt_DenNgay,JTextField txt_NhanVien) {
        this.table = table;
        this.btn_ThongKe = btn_ThongKe;
        this.btn_TimNV = btn_TimNV;
        this.btn_TimNV = btn_LamMoi;
        this.txtTuNgay = txtTuNgay;
        this.txt_DenNgay = txt_DenNgay;
        this.txt_NhanVien = txt_NhanVien;
    }

    public boolean checkRegexDay(String ngay) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return ngay.matches(regex);
    }

    public boolean checkRegexNV(String maNV) {
        String regex = "NV\\d{2}";
        return maNV.matches(regex);
    }


    public void layDanhSachThongKe() {
        HoaDon_DAO ds = new HoaDon_DAO();
        String tuNgay = txtTuNgay.getText().toString();
        String denNgay = txt_DenNgay.getText().toString();
        DefaultTableModel dataModel = (DefaultTableModel) table.getModel();
        List<ThongKe> list = ds.thongKeDoanhThu(tuNgay,denNgay);
        if(!checkRegexDay(denNgay)||!checkRegexDay(tuNgay)) {
            JOptionPane.showMessageDialog(btn_ThongKe, "Vui lòng nhập đúng định dạng YYYY-MM-DD");
            return;
        }
        for(ThongKe tk : list) {
            if(!dsTK.themThongKe(tk)) {
                JOptionPane.showMessageDialog(btn_ThongKe, "Đã thêm vào rồi");
                return;
            }
            String [] rowData = {
                tk.getMaNV(), tk.getTenNV(), tuNgay+" --> "+denNgay, tk.getSoVe()+"", tk.getTongTien()+""
            };
            dataModel.addRow(rowData);
        }
        table.setModel(dataModel);
    }

    public void timNhanVien() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        String txt_MaNV = txt_NhanVien.getText();
        String tuNgay = txtTuNgay.getText().toString();
        String denNgay = txt_DenNgay.getText().toString();

        if(tuNgay.equals("") || denNgay.equals("")) {
            JOptionPane.showMessageDialog(btn_TimNV, "Không được để rỗng các ô ngày");
            return;
        }else {
            if(!txt_MaNV.trim().equalsIgnoreCase("")) {
                if(!checkRegexNV(txt_MaNV)) {
                    JOptionPane.showMessageDialog(btn_TimNV, "Vui lòng nhập đúng định dạng NVXX");
                    return;
                }
                try {
                    ThongKe tk = dsTK.timNV(txt_MaNV);
                    if(tk != null) {
                        removeAllElements();
                        dtm.addRow(new Object[] {
                            tk.getMaNV(), tk.getTenNV(), tuNgay+" --> "+denNgay, tk.getSoVe()+"", tk.getTongTien()+""
                        });
                    } else {
                        JOptionPane.showMessageDialog(btn_TimNV, "Không tìm thấy nhân viên");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(btn_TimNV, "Dữ liệu không hợp lệ");
                }
            } else {
                removeAllElements();
                duaDuLieuVaoModel();
                table.setModel(dtm);
            }
        }
    }

    private void removeAllElements() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.getDataVector().removeAllElements();
    }

    private void duaDuLieuVaoModel() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int i = 0 ; i < dsTK.getSize() ; i++) {
            ThongKe tk = dsTK.getElement(i);
            String tuNgay = txtTuNgay.getText().toString();
            String denNgay = txt_DenNgay.getText().toString();

            model.addRow(new Object[] {
                tk.getMaNV(), tk.getTenNV(), tuNgay+" --> "+denNgay, tk.getSoVe()+"", tk.getTongTien()+""
            });
        }
    }


    public void lamMoi() {

        if(JOptionPane.showConfirmDialog(btn_LamMoi, "Bạn có chắc muốn làm mới?"
            ,"Canh bao",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION) {
                txtTuNgay.setText("");
                txt_DenNgay.setText("");
                txt_NhanVien.setText("");
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            dsTK.clearAll();
        }
    }
}
