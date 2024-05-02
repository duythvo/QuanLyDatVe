package Controller;

import entity.HoaDonDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.HoaDon_DAO;
import entity.Collection_HoaDonDTO;

public class control_VePhim {
    
    HoaDon_DAO hdao = new HoaDon_DAO();
    Collection_HoaDonDTO dsHD = new Collection_HoaDonDTO();
    private DefaultTableModel dataModel;
    private JTable table;
    private JButton btn_CapNhat;
    private JButton btn_ThanhToan;
    private JButton btn_XoaHD;
    private JButton btn_InHD;
    private JButton btn_TimVe;
    private JTextField txt_MaVe;

    public control_VePhim(DefaultTableModel model,JTable table, JButton btn_CapNhat, JButton btn_ThanhToan, JButton btn_XoaHD, JButton btn_TimVe, JButton btn_InHD, JTextField txt_MaVe) {
        this.dataModel = model;
        this.table = table;
        this.btn_CapNhat = btn_CapNhat;
        this.btn_ThanhToan = btn_ThanhToan;
        this.btn_XoaHD = btn_XoaHD;
        this.btn_InHD = btn_InHD;
        this.btn_TimVe = btn_TimVe;
        this.txt_MaVe = txt_MaVe;
    }


    public void hienThiDSHoaDon() {
        HoaDon_DAO ds = new HoaDon_DAO();
        List<HoaDonDTO> list = ds.getDSTrangThai();

        for(HoaDonDTO dto : list) {
            dsHD.themHoaDon(dto);
            String trangThai;
            int tt = dto.getTrangThai();
            if(tt == 0) {
                trangThai = "Chưa Thanh Toán";
            } else {
                trangThai = "Đã Thanh Toán";
            }
            String [] rowData = {
                dto.getMaVe(), dto.getTenPhim()
                , dto.getNgayLap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                , dto.getGiaHoaDon() + "", trangThai
            };
            dataModel.addRow(rowData);
        }
        table.setModel(dataModel);
    }


    public void capNhatTrangThai() {
        int row = table.getSelectedRow();
        if(row >= 0) {
            String maVe = (String) table.getValueAt(row, 0);
            if(JOptionPane.showConfirmDialog(btn_CapNhat, "Xác nhận đã thanh toán", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION) {
                hdao.capNhatHoaDon(maVe);
                dsHD.capNhatHoaDon(maVe);
                table.setValueAt("Đã thanh toán", row, 4);
            }
        } else {
            JOptionPane.showMessageDialog(btn_ThanhToan, "Vui lòng chọn dòng cần cập nhật");
        }
    }

    public void locThanhToan() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int rowCount = table.getRowCount();
        for(int i = rowCount - 1; i >= 0; i--) {
            if(table.getValueAt(i, 4).toString().equalsIgnoreCase("Đã Thanh Toán")) {
                String maVe = table.getValueAt(i, 0).toString();
                dsHD.xoaHoaDon(maVe);
dtm.removeRow(i);
            }
        }
    }
    

    public void xoaHoaDon() {
        if(table.getSelectedRow()==-1) {
            JOptionPane.showMessageDialog(btn_XoaHD, "Vui lòng chọn dòng cần xóa");
        } else {
            if(JOptionPane.showConfirmDialog(btn_XoaHD, "Bạn có chắc muốn xóa dòng này?"
            ,"Canh bao",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION) {
                int index = table.getSelectedRow();
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                String maVe = dtm.getValueAt(index, 0).toString();
                dsHD.xoaHoaDon(maVe);
                dtm.removeRow(index);

            }
        }
    }


    public void timMaVe() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        String txtVe = txt_MaVe.getText();
        
        if(!txtVe.trim().equalsIgnoreCase("")) {
            try {
				HoaDonDTO hdDTO = dsHD.timMaVe(txtVe);
				if(hdDTO != null) {
					removeTable();

                    int tt = hdDTO.getTrangThai();
                    String trangThai;
                    if(tt == 0) {
                        trangThai = "Chưa Thanh Toán";
                    } else {
                        trangThai = "Đã Thanh Toán";
                    }

					dtm.addRow(new Object[]{
                        hdDTO.getMaVe(), hdDTO.getTenPhim(), hdDTO.getNgayLap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), hdDTO.getGiaHoaDon()
                        , trangThai
                    });
				}else {
					JOptionPane.showMessageDialog(btn_TimVe, "Không tìm thấy mã vé");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(btn_TimVe, "Dữ liệu không hợp lệ");
			}
        } else {
            removeTable();
            duaDuLieuVaoModel();
            table.setModel(dtm);
        }
    }

    

    private void removeTable() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.getDataVector().removeAllElements();
    }


    private void duaDuLieuVaoModel() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int i = 0 ; i < dsHD.getSize(); i++) {
            HoaDonDTO hdDTO = dsHD.getElement(i);
            int tt = hdDTO.getTrangThai();
            String trangThai;
            if(tt == 0) {
                trangThai = "Chưa Thanh Toán";
            } else {
                trangThai = "Đã Thanh Toán";
            }
            model.addRow(new Object[]{
                hdDTO.getMaVe(), hdDTO.getTenPhim(), hdDTO.getNgayLap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), hdDTO.getGiaHoaDon()
                , trangThai
            });
        }
    }


}