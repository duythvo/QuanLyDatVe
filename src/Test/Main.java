package Test;

import java.sql.SQLException;


import DAO.Ghe_DAO;

import connectDB.ConnectDB;


public class Main {
    public static void main(String[] args) {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Ghe_DAO ghe_dao = Ghe_DAO.getInstance();
        System.out.println(ghe_dao.getGhe("A1.2"));
    }
}
