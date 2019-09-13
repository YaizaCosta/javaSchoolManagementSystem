package View;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import Controller.DatabaseInsertRemove;
import javafx.scene.text.Font;
import Controller.Database;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class SchoolView {

    /**
     * This is the design part of the GUI
     * Creation of VBox, GridPanes, TilePane
     * to hold labels, txtfield, txtarea and buttons
     */

    /**
     * Specifications of the layout of the application
     * @param primaryStage
     */
    public static void layoutApplication(Stage primaryStage) {

        //General layout
        VBox layout = new VBox();

        Scene layoutApp = new Scene(layout, 1100, 550);

        //Grid pane where student details is
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);  // Override default
        grid.setHgap(20);
        grid.setVgap(20);


       //List of students, teachers will be displayed
       // TextArea listDetails = new TextArea("");
        ScrollPane listDetails = new ScrollPane();
        VBox vb2 = new VBox(listDetails);

        ScrollPane listDetails2 = new ScrollPane();
        VBox vb23 = new VBox(listDetails2);

        ScrollPane listDetails3 = new ScrollPane();
        VBox vb24 = new VBox(listDetails3);
        

        //Extra buttons
        TilePane b1 = new TilePane(Orientation.HORIZONTAL);
        b1.setPadding(new Insets(5, 0, 5, 0));
        b1.setAlignment(Pos.CENTER);
        b1.setHgap(10.0);
        b1.setVgap(8.0);

 /**
 * Labels
 */

        Label emptyLbl1 = new Label("");
        Label moduleLbl = new Label("Choose Modules");
        moduleLbl.setFont(new Font("Verdana", 12));

        Label studentIDLbl = new Label("Student ID");
        studentIDLbl.setFont(new Font("Verdana", 12));

        Label firstLbl = new Label("First Name");
        firstLbl.setFont(new Font("Verdana", 12));

        Label middleLbl = new Label("Middle Name");
        middleLbl.setFont(new Font("Verdana", 12));

        Label lastLbl = new Label("Last Name");
        lastLbl.setFont(new Font("Verdana", 12));

        Label dOBLbl = new Label("Date of Birth");
        dOBLbl.setFont(new Font("Verdana", 12));

        Label  emailLbl = new Label("Email");
        emailLbl.setFont(new Font("Verdana", 12));

        Label phoneLbl = new Label("Phone Number");
        phoneLbl.setFont(new Font("Verdana", 12));

        Label classStLbl = new Label ("Enter your class");
        classStLbl.setFont(new Font("Verdana", 12));


        Label pickLbl = new Label("Enter a class");
        pickLbl.setFont(new Font("Verdana", 12));

        ComboBox moduleCB = new ComboBox();
        moduleCB.getItems().addAll("Java", "Python", "Maths", "Art", "Databases", "Design");
        moduleCB.setValue("Java");
        ComboBox moduleCB1 = new ComboBox();
        moduleCB1.getItems().addAll("Java", "Python", "Maths", "Art", "Databases", "Design");
        moduleCB1.setValue("Python");
        ComboBox moduleCB2 = new ComboBox();
        moduleCB2.getItems().addAll("Java", "Python", "Maths", "Art", "Databases", "Design");
        moduleCB2.setValue("Art");
        Label emptyLbl = new Label("");
        //pickLbl.setFont(new Font("Verdana", 12));

/**
 * Texfields
 */
        //Text inside textfields

        TextField studentIDTxt = new TextField();
        studentIDTxt.setPromptText("Enter Student ID");

        TextField firstTxt = new TextField();
        firstTxt.setPromptText("Enter first name");

        TextField middleTxt = new TextField();
        middleTxt.setPromptText("Enter middle name");

        TextField lastTxt = new TextField();
        lastTxt.setPromptText("Enter last name");

        TextField  dOBTxt = new TextField();
        dOBTxt.setPromptText("Enter DOB");

        TextField emailTxt = new TextField();
        emailTxt.setPromptText("Enter email");

        TextField phoneTxt = new TextField();
        phoneTxt.setPromptText("Enter phone number");

        TextField classStTxt = new TextField();
        classStTxt.setPromptText("Enter your class");

        //For the modules marks
        TextField javaMarkTxt = new TextField();
        javaMarkTxt.setPromptText("Mark");
       // javaMarkTxt.setMaxWidth(60);

        TextField phytonMarkTxt = new TextField();
        phytonMarkTxt.setPromptText("Mark");
        //phytonMarkTxt.setMaxWidth(60);

        TextField mathsMarkTxt = new TextField();
        mathsMarkTxt.setPromptText("Mark");
       // mathsMarkTxt.setMaxWidth(60);
        TextField pickTxt = new TextField();
        pickTxt.setPrefWidth(130);
        pickTxt.setPrefHeight(35);
        pickTxt.setPromptText("Enter a class");
        pickTxt.setMaxWidth(90);


        CheckBox javaCb = new CheckBox();
        javaCb.setFont(new Font("Verdana", 12));
        CheckBox phytonCb = new CheckBox();
        phytonCb.setFont(new Font("Verdana", 12));
        CheckBox mathsCb = new CheckBox();
        mathsCb.setFont(new Font("Verdana", 12));

        //Middle section


        // listCars = new TextArea();

        /**
         * Add, remove, update button design specifications
         */

        Button addBtn = new Button("Add Student");
        addBtn.setStyle("-fx-color:#4169E1");
        addBtn.setMaxWidth(Double.MAX_VALUE);
        addBtn.setPrefHeight(25);
        addBtn.setFont(new Font("Verdana", 12));

        Button addModuleBtn = new Button("Add Module");
        //Button addStudent_Clear  = new Button("Clear");
        addModuleBtn.setStyle("-fx-color:#4169E1");
        addModuleBtn.setMaxWidth(Double.MAX_VALUE);
        addModuleBtn.setPrefHeight(25);
        addModuleBtn.setFont(new Font("Verdana", 12));


        Button removeBtn = new Button("Remove");
        removeBtn.setStyle("-fx-color:#113370");
        removeBtn.setMaxWidth(100);
        removeBtn.setPrefHeight(25);
        removeBtn.setFont(new Font("Verdana", 12));

        Button updateBtn = new Button("Update Module");
        updateBtn.setStyle("-fx-color:#4169E1");
        updateBtn.setMaxWidth(Double.MAX_VALUE);
        updateBtn.setPrefHeight(25);
        updateBtn.setFont(new Font("Verdana", 12));



/**
 * Display students, teachers, add class, exit the application design specifications
 */
        Button studentsClassBtn = new Button("Students in class");
        studentsClassBtn.setStyle("-fx-color:#319820");
        studentsClassBtn.setPrefHeight(35);


        Button studentsBtn = new Button("Students");
        studentsBtn.setStyle("-fx-color:#319820");
        studentsBtn.setPrefHeight(35);
        //studentsBtn.new Image("@/toolbarButtonGraphics/general/Open16.gif");


        studentsBtn.setFont(new Font("Verdana", 12));

        Button add2Btn = new Button("Add a Class");
        add2Btn.setStyle("-fx-color:#319820");
        add2Btn.setPrefHeight(35);
        add2Btn.setFont(new Font("Verdana", 12));


        Button remove2Btn = new Button("Remove a Class");
        remove2Btn.setStyle("-fx-color:#319820");
        remove2Btn.setPrefHeight(35);
        remove2Btn.setFont(new Font("Verdana", 12));


        Button teachersBtn = new Button("Teachers");
        teachersBtn.setStyle("-fx-color:#319820");
        teachersBtn.setPrefHeight(35);
        teachersBtn.setFont(new Font("Verdana", 12));


        Button exitBtn = new Button("Exit");
        exitBtn.setStyle("-fx-color:#CF3717");
        exitBtn.setPrefHeight(35);
        exitBtn.setFont(new Font("Verdana", 12));

/**
 * Add to the grid labels and textfields related to the student personal details
 */
       // emptyLbl1

        grid.add(studentIDLbl, 0, 0);
        grid.add(studentIDTxt, 1, 0);

        grid.add(firstLbl, 0,1);
        grid.add(firstTxt, 1, 1);


        grid.add(middleLbl, 2, 1);
        grid.add(middleTxt, 3, 1);

        grid.add(lastLbl, 0, 2);
        grid.add(lastTxt, 1, 2);

        grid.add(dOBLbl, 2, 2);
        grid.add(dOBTxt, 3, 2);

        grid.add(phoneLbl, 2, 3);
        grid.add(phoneTxt, 3, 3);

        grid.add(emailLbl, 0, 3);
        grid.add(emailTxt, 1, 3);

        grid.add(classStLbl,5,4);
        grid.add(classStTxt,6,4);

        grid.add(emptyLbl,0,4);
        grid.add(moduleLbl,5,0);


/**
 * Checkboxes of the modules, labels and textfields where to input the mark value
 */

grid.add(moduleCB,5,1);
        grid.add(moduleCB1,5,2);
        grid.add(moduleCB2,5,3);

        grid.add(javaMarkTxt, 6, 1);
        grid.add(phytonMarkTxt, 6, 2);
        grid.add(mathsMarkTxt, 6, 3);

/**
 * Add, remove and update student buttons location in the grid
 */

        grid.add(addBtn, 8, 1);
        grid.add(removeBtn, 2, 0); //Remove student by index
        grid.add(addModuleBtn,8,2);
        grid.add(updateBtn, 8, 3);
        grid.setPadding(new Insets(10, 20, 20, 20));
/**
 * Sets the colour of the grid
 */
        grid.setStyle("-fx-background-color: LightSteelBlue	");

        studentsClassBtn.setMaxWidth(Double.MAX_VALUE);
        studentsBtn.setMaxWidth(Double.MAX_VALUE);
        add2Btn.setMaxWidth(Double.MAX_VALUE);
        remove2Btn.setMaxWidth(Double.MAX_VALUE);
        teachersBtn.setMaxWidth(Double.MAX_VALUE);
        exitBtn.setMaxWidth(Double.MAX_VALUE);


        b1.getChildren().addAll(pickLbl,pickTxt, studentsClassBtn, studentsBtn, add2Btn, remove2Btn, teachersBtn,exitBtn);



/**
 * Layout getting the children from the grid, tile pane, and vBox
 */

        layout.getChildren().addAll( grid, b1,vb2,vb23, vb24); //pane too


        primaryStage.setScene(layoutApp);
        primaryStage.setTitle("School Management System");

        primaryStage.setMaxWidth(1100);
        primaryStage.setMinWidth(1100);

        primaryStage.setMaxHeight(550);
        primaryStage.setMinHeight(550);

        primaryStage.show();


        /**
         * Display a student from an specific class
         */

        studentsClassBtn.setOnAction(event ->{

            try {
                String pickClass = pickTxt.getText();
                Database.displaySpecificStudents(pickClass, listDetails3);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });

/**
 * Add a Student Button set on action
 */

        addBtn.setOnAction(e-> {

/**
 *Getting values from the GUI - parts of Name - first name, middle name, last name
 */
                    String firstName = firstTxt.getText();
                    String middleName = middleTxt.getText();
                    String lastName = lastTxt.getText();

/**
 * Getting values from the GUI - date of birth, email and phone number
 */
                    String dateOfBirth = dOBTxt.getText();
                    String email = emailTxt.getText();
                    String phoneNumber = phoneTxt.getText();
                    String classSName = classStTxt.getText();

            /**
             * DatabaseInsertRemoveClass to the method savestudent
             */
            DatabaseInsertRemove.saveStudent(firstName, middleName, lastName, dateOfBirth, email, phoneNumber, classSName);
                    /**
                     * Once the add button is clicked clear and uncheck all the textboxes and checkboxes
                     */

                    studentIDTxt.clear();
                    firstTxt.clear();
                    middleTxt.clear();
                    lastTxt.clear();
                    dOBTxt.clear();
                    emailTxt.clear();
                    phoneTxt.clear();
                    classStTxt.clear();
                    javaMarkTxt.clear();
                    phytonMarkTxt.clear();
                    mathsMarkTxt.clear();

    });

/**
 * Remove a student
 *
 */
        removeBtn.setOnAction(e-> {
            String idstudent = studentIDTxt.getText();
            DatabaseInsertRemove.removeStudent(Integer.parseInt(idstudent));
            studentIDTxt.clear();

        });

        /**
         * Add a Class into the class table
         *
         */

        add2Btn.setOnAction(event -> {
          String classC = pickTxt.getText();
          DatabaseInsertRemove.saveClass(classC);
          pickTxt.clear();
      });

/**
 * Button on action remove a class
 */

        remove2Btn.setOnAction(e-> {
            String classN = pickTxt.getText();
            DatabaseInsertRemove.removeClass(classN);

        });


        addModuleBtn.setOnAction(event -> {
          //  String module = moduleCB1.getItems().addAll();
        });
/**
 *
 */
        teachersBtn.setOnAction(event -> {
            try {
                Database.displayTeachersDegrees(listDetails);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        /**
         * Students
         */

        studentsBtn.setOnAction(event -> {
            try {
                Database.displayStudents(listDetails2);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });


        /**
         * Sets on action the exit button that closes the application
         */
        exitBtn.setOnAction(e->{ primaryStage.close();                                                 // closes program

        });


    }
}
