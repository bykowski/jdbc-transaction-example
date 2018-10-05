package transaction;

import config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPreparedStatement {

    private static String SQL_OWNER = "INSERT INTO Owner(Id, Name) VALUES (?,?)";
    private static String SQL_DOG = "INSERT INTO `Dog`(`Id`, `Name`, `Owner_id`) VALUES (?,?,?)";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementOwner = null;
        PreparedStatement preparedStatementDog = null;
        try {
            // creating database connection
            connection = DriverManager.getConnection(
                    DBConfig.INSTANCE.getUrl(),
                    DBConfig.INSTANCE.getUser(),
                    DBConfig.INSTANCE.getPass());

            System.out.println("!!!!!!!!!!!!!!!!!!");

            // disabling the option of automatically sending changes to the database
            connection.setAutoCommit(false);

            preparedStatementOwner = connection.prepareStatement(SQL_OWNER);
            preparedStatementDog = connection.prepareStatement(SQL_DOG);

            //parameterization of queries
            preparedStatementOwner.setInt(1, 1);
            preparedStatementOwner.setString(2, "Tom");

            preparedStatementDog.setInt(1, 1);
            preparedStatementDog.setString(2, "VeryLongDogName----------------------------------------------------------------------------------------");
            preparedStatementDog.setInt(3, 1);

            // execution of queries without saving them in the database
            preparedStatementOwner.execute();
            preparedStatementDog.execute();

            // sending changes to the database
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            // always remember to release connections!
            if (preparedStatementOwner != null) {
                preparedStatementOwner.close();
            }
            if (preparedStatementDog != null) {
                preparedStatementDog.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}