package entity;

import java.util.ArrayList;

public class Collection_HoaDonDTO {
    private ArrayList<HoaDonDTO> list;

    public Collection_HoaDonDTO() {
        list = new ArrayList<HoaDonDTO>();
    }

    public boolean themHoaDon(HoaDonDTO hd) {
		if(list.contains(hd)) {
			return false;
		}
		list.add(hd);
		return true;
	}
    
    public HoaDonDTO timMaVe(String maVe) {	
        for(HoaDonDTO dto : list) {
            if(dto.getMaVe().equalsIgnoreCase(maVe)) {
                return dto;
            }
        }
		return null;
	}

    public boolean capNhatHoaDon(String maVe) {
        HoaDonDTO hd = new HoaDonDTO(maVe);
        for(HoaDonDTO dto : list) {
            if(dto.getMaVe().equalsIgnoreCase(maVe)) {
                dto.setTrangThai(1);
                return true;
            }
        }
        return false;
    }

	public boolean xoaHoaDon(String maVe) {
		HoaDonDTO hd = new HoaDonDTO(maVe);
		if(list.contains(hd)) {
			list.remove(hd);
			return true;
		}
		return false;
	}



    public HoaDonDTO getElement(int index) {
		if(index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}
	

	
	public int getSize() {
		return list.size();
	}
}
