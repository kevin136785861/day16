package mvc.demo.common.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String psw;
    private static String driver;
    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("until/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            psw = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,psw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection con, PreparedStatement sta, ResultSet rs) throws Exception {
        if(con != null){
            con.close();
        }
        if(sta != null){
            sta.close();
        }
        if(rs != null){
            rs.close();
        }
    }
}
