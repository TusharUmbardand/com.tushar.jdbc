import javax.sql.DataSource;
import java.sql.*;
import java.util.concurrent.Callable;

public class CallSQLFunction {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String pass = "1234";
        try (Connection connection = DriverManager.getConnection(url,user,pass)) {
            CallableStatement statement = connection.prepareCall("select get_count_of_product(?)");
            statement.setString(1,"AVG PRODUCT");
            ResultSet rs = statement.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            System.out.println("Total count of  product : "+count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

}


