import org.example.PaymentStatus;

import java.sql.*;

public class TransactionManagementDemo {

    public static void main(String[] args) {
        Connection connection = ConnectionPool.getConnection();
        String book_info = "INSERT INTO booking_info VALUES (2,'AIR-IND-696','PUNE','BLR')";
        String passenger_info1="INSERT INTO passenger_info VALUES (4,'riya',22,'female')";
        String passenger_info2="INSERT INTO passenger_info VALUES (5,'tushar',22,'female')";
        String passenger_info3="INSERT INTO passenger_info VALUES (6,'miya',52,'female')";

        String payment_info = "INSERT INTO payment_info VALUES (1,1,250000,7000,true)";


        try {
            connection.setAutoCommit(false);
            Statement stm = connection.createStatement();
            stm.addBatch(book_info);
            stm.executeBatch();

            Savepoint savepoint1 = connection.setSavepoint();
            stm.addBatch(passenger_info1);
            stm.executeBatch();
            stm.addBatch(passenger_info2);
            stm.executeBatch();
            stm.addBatch(passenger_info3);
            stm.executeBatch();
            stm.addBatch(payment_info);

            if(PaymentStatus.paymentStatus()){

                stm.executeBatch();
                connection.commit();
                System.out.println("booking confirm");
            }else {
                connection.rollback(savepoint1);
                connection.commit();
                System.out.println("payment failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool.reciveConnection(connection);

    }

}
