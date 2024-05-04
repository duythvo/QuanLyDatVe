package Test;

import java.util.ArrayList;

import DAO.Ghe_DAO;
import connectDB.ConnectDB;
import entity.Ghe;

public class test1{
    public static void main(String[] args) {
        ConnectDB.getInstance();
        Ghe_DAO ghe_dao = new Ghe_DAO();
       ArrayList<Ghe> list = ghe_dao.getDSGheTheoMaPhong("P01");
         for(Ghe ghe : list){
              System.out.println(ghe.getMaGhe());
         }
    }
}