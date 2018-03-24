package SqlWork.src.com.webserg.sqlWork;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by sergiy.doroshenko
 * Date: 5/16/11
 */
public class Main {
    public static void main(String[] args) {

    }

    private static Connection getConnection() throws Exception {
        Connection connection = null;
        String url = "jdbc:derby:D:\\devel\\webserg-common\\SqlWork\\db\\sqlWork;";
        connection = DriverManager.getConnection(url);
        return connection;
    }
}
