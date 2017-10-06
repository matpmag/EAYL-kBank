import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
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
    String dateOfBirth;
    String address;
    String telNo;

    public Customer(
            String forename,
            String surname,
            char gender,
            String dateOfBirth,
            String address,
            String telNo
    ){
        this.forename = forename;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telNo = telNo;
        createAccount();
    }

    public void createAccount() {
        String password = "password";
        try {
            Class driver = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbKBank", "root", "password");
            Statement statement = connection.createStatement();
            statement.execute(
                    String.format("INSERT INTO tableCustomer(firstName, lastName, gender, dateOfBirth, address, telephone) VALUES(\"%s\", \"%s\", \'%s\', \"%s\", \"%s\", \"%s\");", getForename(), getSurname(), String.valueOf(getGender()), getDateOfBirth().toString(), getAddress(), getTelNo()));
            System.out.println("Account added successfully");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}