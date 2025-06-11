import java.sql.Connection;
import java.util.Collections;

public class ConnectionPoolCheck {
    public static void main(String[] args) {
        Connection conn = ConnectionPool.getConnection();
        System.out.println(conn);
        ConnectionPool.reciveConnection(conn);
    }
}
