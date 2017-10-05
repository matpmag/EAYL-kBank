import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    //public static String dbPassword;
    public static void main(String[] args) {

        try {
            scanner = new Scanner(System.in);
            //String dbPassword = scanner.nextLine();
            Class driver = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbKBank", "root", "password");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}