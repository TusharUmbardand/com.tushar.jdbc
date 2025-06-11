import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetaDataDemo {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        try(Connection connection = DriverManager.getConnection(user,user,passWord)){
            DatabaseMetaData md = connection.getMetaData();
            System.out.println(md.getDriverName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
