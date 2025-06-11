import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static List<Connection> connnectionPool = new ArrayList<>();
    static String driverPath ="org.postgresql.Driver";
   static  String url = "jdbc:postgresql://localhost:5432/shop";
    static String user = "postgres";
    static String password = "1234";
    private static final int POOL_SIZE =10;
    String passWord = "1234";
    static {
         for(int i = 1 ; i<=POOL_SIZE;i++){
            connnectionPool.add(createConnection());
         }
    }
    private static  Connection createConnection(){
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public  static Connection getConnection(){
        if (!connnectionPool.isEmpty())
            return connnectionPool.remove(0);
        else return createConnection();
    }
    public static void reciveConnection(Connection connection){
        if (connnectionPool.size()<POOL_SIZE){
            connnectionPool.add(connection);
        }
        else {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }
    }


}
