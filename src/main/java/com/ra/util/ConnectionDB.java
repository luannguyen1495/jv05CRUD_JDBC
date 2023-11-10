package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    // khai báo thuộc tính Driver kêt noi vs mysql
    private static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";

    // Khai báo thuc tính url kết nối
    private  static  final String URL = "jdbc:mysql://localhost:3306/demo_jsp";
    // khai báo thuôc tính USER
    private  static  final  String USER = "root";
    // khai báo thuoc tinh PASSWORD
    private  static  final  String PASSWORD = "123456";
    // phương thức get connection (lay ve ket noi)
    public static Connection getConnection()  {
        Connection connection = null;


        try {
            // đăng ký  driver
            Class.forName(DRIVER_JDBC);
            // thuc hiện mo ket noi
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException ec) {
            throw new RuntimeException(ec);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  connection;
    }

    // phuong thu đóng kết nối
    public static  void  closeConnection(Connection connection) throws SQLException {

        if(connection != null){
            connection.close();
        }
    }

}
