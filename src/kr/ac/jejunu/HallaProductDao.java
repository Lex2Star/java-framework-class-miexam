package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hyunki on 2017. 4. 21..
 */
public class HallaProductDao implements ConnectionMaker {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://117.17.102.106/jeju?characterEncoding=utf-8", "root", "1234");
    }
}
