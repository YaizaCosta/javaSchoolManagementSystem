package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInsertRemove {


    /**
     * Save student to the database. Open the connection and if connection is succesfull query the database with an insert, then close the connection
     */
    public static void saveStudent( String sfirstName,String smiddleName, String slastName, String sdateOfBirth, String semail,String sphoneNumber, String sclassName) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found: Please import");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console"); // Print if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {   //checks that the connection is not null(there is a connection)
            PreparedStatement saveCustomer;
            try {
                saveCustomer = connection.prepareCall("INSERT INTO school_database.student( sfirstName, smiddleName, slastName, sdateOfBirth, semail, sphoneNumber, sclassName ) VALUES(?,?,?,?,?,?,?)");
                saveCustomer.setString(1, sfirstName);
                saveCustomer.setString(2, smiddleName);
                saveCustomer.setString(3, slastName);
                saveCustomer.setString(4, sdateOfBirth);
                saveCustomer.setString(5, semail);
                saveCustomer.setString(6, sphoneNumber);
                saveCustomer.setString(7,sclassName);



                int i = saveCustomer.executeUpdate();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Remove a student by id. First we check the database connection. Then we query with delete and close the connection to the database
     */
    public static void removeStudent(int idstudent)  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found: Please import");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", // Connect to DB
                            "root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {

            PreparedStatement removeStudent;
        try{
            removeStudent = connection.prepareCall("DELETE FROM school_database.student where idstudent = ?");
            removeStudent.setInt(1, idstudent);

            int i = removeStudent.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
    /**
     * Save a class inside the class database. Checks connection, open it and insert values passed.
     */

    public static void saveClass( String className) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) { //Test the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            PreparedStatement  saveClass;
            try {
                saveClass = connection.prepareCall("INSERT INTO school_database.class( className) VALUES(?)");
                saveClass.setString(1, className);


                int i =  saveClass.executeUpdate();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Remove a class. Checks the connection then open it, then query it with a delete, so we can remove from the class table
     *
     */

    public static void removeClass(String className)  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found: Please import");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                            "root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {

            PreparedStatement removeClass;
            try{
            removeClass = connection.prepareCall("DELETE FROM school_database.class where className = ?");
            removeClass.setString(1, className);

            int i = removeClass.executeUpdate();


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
