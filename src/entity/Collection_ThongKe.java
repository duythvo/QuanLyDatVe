package entity;


import java.util.ArrayList;

public class Collection_ThongKe {
    private ArrayList<ThongKe> list;

    public Collection_ThongKe() {
        list = new ArrayList<ThongKe>();
    }

    public boolean themThongKe(ThongKe tk) {
		if(list.contains(tk)) {
			return false;
		}
		list.add(tk);
		return true;
	}
    
	public void clearAll() {
		list.clear();
	}
	

    public ThongKe timNV(String maNV) {	
        for(ThongKe tk : list) {
            if(tk.getMaNV().equalsIgnoreCase(maNV)) {
                return tk;
            }
        }
		return null;
	}


    public ThongKe getElement(int index) {
		if(index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}
	
	public int getSize() {
		return list.size();
	}
}