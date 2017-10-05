import java.util.Date;
import java.sql.*;

public class Customer {

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    String forename;
    String surname;
    char gender;
    Date dateOfBirth;
    String address;
    String telNo;

    public Customer(
            String forename,
            String surname,
            char gender,
            Date dateOfBirth,
            String address,
            String telNo
    ){
        this.forename = forename;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telNo = telNo;
    }

    public static void createAccount(String[] args) {
        String password = args[0];
        try {
            Class driver = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbKBank", "root", password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("INSERT INTO ;");
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}