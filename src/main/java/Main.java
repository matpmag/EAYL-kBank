import java.sql.*;
import java.util.*;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Date;
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
        welcome(args);
    }

    private void findAccountBalance(int accountNo) {
        String password = "password";
        try {
            Class driver = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbKBank", "root", password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT a.accountNumber, a.currentBalance, c.firstName, c.lastName FROM tableAccount AS a\n" +
                    "        INNER JOIN tableCustomer AS c\n" +
                    "        ON a.customerID = c.customerID;\n" +
                    "        WHERE a.accountNumber = " + accountNo + ";");
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void welcome(String[] args) {
        System.out.println("=== Welcome to kBank! ===");
        menu();
    }

    public static void menu() {
        boolean active = true;
        while (active) {
            System.out.print("\n" +
                    "========= Menu ==========\n" +
                    "0 - Exit the kBank App\n" +
                    "1 - Create a new account\n" +
                    "========= Menu ==========\n\n" +
                    "Please enter an option:");

            Scanner scan = new Scanner(System.in);
            int optionNo;
            boolean optionActive = true;
            while (optionActive)
                try {
                    optionNo = scan.nextInt();
                        optionActive = false;
                        switch (optionNo) {
                            case 0:
                                System.exit(0);
                            case 1:
                                createAccount();
                                break;
                            case 2:
                                new Customer(
                                        "Matthew",
                                        "Maguire",
                                        'm',
                                        "1998-05-02",
                                        "363 Upper Newtownards Road",
                                        "07763285190"
                                );
                                break;
                            default:
                                System.out.print("\nPlease enter a valid option:");
                                break;
                        }
                } catch (InputMismatchException e) {
                    System.out.print("\nPlease enter a valid option:");
                }


        }
    }

    public static Customer createAccount() {
        boolean activeOne = true;
        String forename = "", surname = "", address = "", telNo = "", dateOfBirth;
        char gender = '0';
        System.out.print("Please enter your first name:");
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                forename = scanTwo.nextLine();
                if (isLetters(forename)) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid name:");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid name:");
            }
        }
        System.out.print("Please enter your second name:");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                surname = scanTwo.nextLine();
                if (isLetters(surname)) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid surname:");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid surname:");
            }
        }
        System.out.print("Please enter your address:");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                address = scanTwo.nextLine();
                if (address.length() > 10) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid address:");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid address:");
            }
        }
        System.out.print("Please enter your gender(m or f):");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                char[] genderString = scanTwo.nextLine().toLowerCase().toCharArray();
                if (genderString.length == 1 && (genderString[0] == 'm' || genderString[0] == 'f')) {
                    gender = genderString[0];
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid gender(m or f):");
                }

            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid gender(m or f):");
            }
        }
        System.out.print("Please enter your phone number:");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                telNo = scanTwo.nextLine();
                if (isNumbers(telNo)) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid phone number:");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid phone number:");
            }
        }

        int year = 1900, month = 12, day = 31;
        System.out.print("Please enter your year of birth(YYYY):");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                year = scanTwo.nextInt();
                if (year > 1850 && year < 2015) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid year(YYYY):");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid year(YYYY):");
            }
        }
        System.out.print("Please enter your month of birth(MM):");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                month = scanTwo.nextInt();
                if (month > 0 && month < 13) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid month(MM):");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid month(MM):");
            }
        }
        System.out.print("Please enter your day of birth(DD):");
        activeOne = true;
        while (activeOne) {
            try {
                Scanner scanTwo = new Scanner(System.in);
                day = scanTwo.nextInt();
                if (day > 0 && day < 32) {
                    activeOne = false;
                } else {
                    System.out.print("Please enter a valid day(DD):");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid day(DD):");
            }
        }
        dateOfBirth = String.format("%s-%s-%s",year, month, day);

        return new Customer(
            forename,
            surname,
            gender,
            dateOfBirth,
            address,
            telNo
        );

    }

    public static boolean isLetters(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static boolean isNumbers(String input) {
        return input.matches("[0-9]+");
    }
}