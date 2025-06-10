import java.sql.*;

public class BatchExecutionDemo {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, passWord);

            String query = "INSERT into product VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1,9);
            ps.setString(2,"WATCH");
            ps.setDouble(3,14600);
            ps.setString(4,"BEST PRODUCT");

            ps.addBatch();

            ps.setInt(1,8);
            ps.setString(2,"MOBILE");
            ps.setDouble(3,146000);
            ps.setString(4,"AVG PRODUCT");

            ps.addBatch();;

            ps.executeBatch();


            Statement statement = conn.createStatement();

           

            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
