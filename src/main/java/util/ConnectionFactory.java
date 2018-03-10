package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory = null;
    private static Properties config = new Properties();

    private ConnectionFactory() {
        try {
            Class.forName(config.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getProperty("jdbc.url"), config.getProperty("jdbc.user"), config.getProperty("jdbc.password"));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    static void initDB() {
        loadConfiguration();
        Connection c = getInstance().getConnection();
        PreparedStatement stmt;
        try {
            stmt = c.prepareStatement("CREATE TABLE PRODUCT (ID INT auto_increment PRIMARY KEY, NAME VARCHAR(64), PRICE DECIMAL)");
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void loadConfiguration() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream stream = classLoader.getResourceAsStream("config.properties");
            config.load(stream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    static {
        initDB();
    }

}
