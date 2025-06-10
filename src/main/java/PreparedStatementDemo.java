import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,user,passWord);

            String query = "Insert into product values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,1);
            ps.setString(2,"Pen");
            ps.setDouble(3,200);
            ps.setString(4,"Nice product");

            ps.execute();

            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
