import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseConnection {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        try (Connection conn = DriverManager.getConnection(url,user,passWord);){
            Class.forName("org.postgresql.Driver");


            String query = "UPDATE product set feedback = 'bad product' where feedback='good product'";
            Statement statement = conn.createStatement();

            statement.execute(query);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
