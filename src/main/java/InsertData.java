import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/shop";
        String user = "postgres";
        String passWord = "1234";
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,user,passWord);
            System.out.println("Enter Product id");
            int id = sc.nextInt();
            System.out.println("Enter Product price");
            double price = sc.nextDouble();
            System.out.println("Entre product name");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter product feedback");
            String feedBack = sc.nextLine();
            String query = "Insert into product values("+id+","+name+","+price+","+feedBack+")";
            Statement statement = conn.createStatement();

            statement.execute(query);

            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
