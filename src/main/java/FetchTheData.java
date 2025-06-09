import java.sql.*;

public class FetchTheData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,user,passWord);

            String query = "SELECT * from product";
            Statement statement = conn.createStatement();

          ResultSet rs = statement.executeQuery(query);

          while(rs.next()){
              int id = rs.getInt("id");
              String name = rs.getString("name");
              System.out.println("Id : "+id);
              System.out.println("Name : "+name);
            }

            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
