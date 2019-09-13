package Controller;

import javafx.geometry.Insets;
import java.sql.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Database {
    /**
     * Connection to the database - checks the connection
     */
    public static String databaseConnection() throws SQLException {

        String connectionMessage = "The database connection has failed";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Testing the JDBC
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found");
            e.printStackTrace();
            return connectionMessage;
        }
        Connection dbconnection = null;


        try {
            dbconnection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");                                           //

            connectionMessage = "Connected Successfully";

        } catch (SQLException e) {
            System.out.println("The database connection has failed");
            e.printStackTrace();
            return connectionMessage;
        }


        return connectionMessage;
    }
    /**
     * Display Students of an specific class
     */

    public static void displaySpecificStudents(String classSName,ScrollPane pane) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found");
            e.printStackTrace();
            return;
        }
        Connection connection;


        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        pane.setContent(null);

        PreparedStatement  stringQuery;

        stringQuery = connection.prepareCall("SELECT e.idstudent, e.sfirstName, e.smiddleName, e.slastName, e.sdateOfBirth, e.semail, e.sphoneNumber, e.sclassName  FROM school_database.student e WHERE e.sclassName = ?");
        stringQuery.setString(1, classSName);
        // create the java statement

        ResultSet rsStudentDetails = stringQuery.executeQuery(); // execute the query, and get a java resultset

        VBox listStudentsVBox = new VBox();

        int i = 0;

        while (rsStudentDetails.next())// iterate through the java resultset
        {

            Label Student = new Label("Students in class " + rsStudentDetails.getString(1));
            Label StudentID = new Label("ID:" + rsStudentDetails.getString(1));
            Label FirstName = new Label("First Name: " + rsStudentDetails.getString(2));
            Label MiddleName = new Label("Middle Name: " + rsStudentDetails.getString(3));
            Label LastName = new Label("Last Name: " + rsStudentDetails.getString(4));
            Label StudentDOB = new Label("DOB: " + rsStudentDetails.getString(5));
            Label StudentEmail = new Label("Email: " + rsStudentDetails.getString(6));
            Label StudentPhone = new Label("Phone: " + rsStudentDetails.getString(7));
            Label ClassSName = new Label("Class: " + rsStudentDetails.getString(8));


            //This is so the display looks better
            Student.setMinWidth(20);
            StudentID.setMinWidth(10);
            FirstName.setMinWidth(90);
            MiddleName.setMinWidth(90);
            LastName.setMinWidth(90);
            StudentDOB.setMinWidth(60);
            StudentEmail.setMinWidth(140);
            StudentPhone.setMinWidth(60);
            ClassSName.setMinWidth(70);

            HBox StudentDetailsB = new HBox();
            StudentDetailsB.setSpacing(30);
            StudentDetailsB.setAlignment(Pos.CENTER_LEFT);
            StudentDetailsB.setPadding(new Insets(5, 0, 5, 150));
            StudentDetailsB.getChildren().addAll(Student, StudentID, FirstName, MiddleName, LastName, StudentDOB, StudentEmail, StudentPhone, ClassSName);

            listStudentsVBox.getChildren().add(StudentDetailsB);

        }
        pane.setContent(listStudentsVBox);
        stringQuery.close();
    }




    /**
     * Display Students - connect to database, open it and select from the students table then pass them to the pane to be displayed in the GUI
     */

    public static void displayStudents(ScrollPane pane) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found");
            e.printStackTrace();
            return;
        }
        Connection connection;


        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        pane.setContent(null);
        String query = ("SELECT e.idstudent, e.sfirstName, e.smiddleName, e.slastName, e.sdateOfBirth, e.semail, e.sphoneNumber, e.sclassName FROM school_database.student e");
        Statement st = connection.createStatement(); // create the java statement

        ResultSet rsStudentDetails = st.executeQuery(query); // execute the query, and get a java resultset

        VBox listStudentsVBox = new VBox();

        int i = 0;

        while (rsStudentDetails.next())// iterate through the java resultset
        {

            Label Student = new Label("Student " + rsStudentDetails.getString(1));
            Label StudentID = new Label("ID: " + rsStudentDetails.getString(1));
            Label FirstName = new Label("First Name: " + rsStudentDetails.getString(2));
            Label MiddleName = new Label("Middle Name: " + rsStudentDetails.getString(3));
            Label LastName = new Label("Last Name: " + rsStudentDetails.getString(4));
            Label StudentDOB = new Label("DOB: " + rsStudentDetails.getString(5));
            Label StudentEmail = new Label("Email: " + rsStudentDetails.getString(6));
            Label StudentPhone = new Label("Phone: " + rsStudentDetails.getString(7));
            Label ClassSName = new Label("Class: " + rsStudentDetails.getString(8));


            //This is so the display looks better
            Student.setMinWidth(20);
            StudentID.setMinWidth(10);
            FirstName.setMinWidth(90);
            MiddleName.setMinWidth(90);
            LastName.setMinWidth(90);
            StudentDOB.setMinWidth(60);
            StudentEmail.setMinWidth(140);
            StudentPhone.setMinWidth(60);
            ClassSName.setMinWidth(60);

            HBox StudentDetails = new HBox();
            StudentDetails.setSpacing(30);
            StudentDetails.setAlignment(Pos.CENTER_LEFT);
            StudentDetails.setPadding(new Insets(5, 0, 5, 150));
            StudentDetails.getChildren().addAll(Student, StudentID, FirstName, MiddleName, LastName, StudentDOB, StudentEmail, StudentPhone, ClassSName);

            listStudentsVBox.getChildren().add(StudentDetails);

        }
        pane.setContent(listStudentsVBox);
        st.close();
    }


    /**
     * Display Teachers. Ohecks database, open it and then select fields from the table teachers
     */
    public static void displayTeachersDegrees(ScrollPane pane) throws SQLException {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not found");
            e.printStackTrace();
            return;
        }
        Connection connection;


        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        pane.setContent(null);
        String query = ("SELECT c.idTeacher, c.firstName, c.middleName, c.lastName, c.degreeName FROM school_database.teacher c");
        Statement st = connection.createStatement();// create  java statement

        ResultSet rsDetails = st.executeQuery(query);// execute the query, and get a java result set

        VBox detailsBox = new VBox();
        int i = 0;

        while (rsDetails.next()) // iterate through the java result set
        {
            Label Teacher = new Label("Teacher " + rsDetails.getString(1));
            Label TeacherID = new Label("ID: " + rsDetails.getString(1));
            Label FirstName = new Label("First Name: " + rsDetails.getString(2));
            Label MiddleName = new Label("Middle Name: " + rsDetails.getString(3));
            Label LastName = new Label("Last Name: " + rsDetails.getString(4));
            Label DegreeName = new Label("Degree: " + rsDetails.getString(5));


            //Display looks better
            Teacher.setMinWidth(50);
            TeacherID.setMinWidth(20);
            FirstName.setMinWidth(100);
            MiddleName.setMinWidth(100);
            LastName.setMinWidth(100);
            DegreeName.setMinWidth(70);



            HBox details = new HBox();
            details.setSpacing(30);
            details.setAlignment(Pos.CENTER_LEFT);
            details.setPadding(new Insets(5, 0, 5, 150));

            details.getChildren().addAll(Teacher, TeacherID, FirstName, MiddleName, LastName, DegreeName);

            detailsBox.getChildren().add(details);

        }

        pane.setContent(detailsBox); //Display in the pane the detailsbox
        st.close();
    }
}







