package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5p1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:.\\kata5.db");

        Statement statement = connection.createStatement();
        String query = "Select * from people";
        ResultSet resultset = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData = resultset.getMetaData();

        System.out.println(resultSetMetaData.getColumnName(1) + "\t"
                + resultSetMetaData.getColumnName(2) + "\t\t"
                + resultSetMetaData.getColumnName(3) + "\t"
                + resultSetMetaData.getColumnName(4) + "\t");
        while (resultset.next()) {
            System.out.println(resultset.getInt(1) + "\t"
                    + resultset.getString(2) + "\t\t"
                    + resultset.getString(3) + "\t"
                    + resultset.getString(4));
        }

        query = "CREATE TABLE IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL)";
        statement.execute(query);

        resultset.close();
        statement.close();
        connection.close();
    }
}
