package utils;

import org.apache.commons.dbcp2.BasicDataSource;


import java.sql.Connection;
import java.sql.SQLException;

public final class Database {

    private static final BasicDataSource dataSource = new BasicDataSource();

    private static final String USERNAME        = "imageseller";
    private static final String PASSWORD        = "imageseller";
    private static final String DRIVER_CLASS    = "com.mysql.jdbc.Driver";
    private static final String HOST            = "jdbc:mysql://localhost:3306/imageseller";

    static {
        dataSource.setDriverClassName(DRIVER_CLASS);
        dataSource.setUrl(HOST);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    private Database() {
        //Ignore
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
