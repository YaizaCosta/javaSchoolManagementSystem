package View;

import javafx.application.Application;
import javafx.stage.Stage;
import View.SchoolView;


/**
 * Main class where the application starts - load & show the display
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
   SchoolView.layoutApplication(primaryStage);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
