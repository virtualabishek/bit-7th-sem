import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Labels
        Label userLabel = new Label("Username:");
        Label passLabel = new Label("Password:");

        // Input fields
        TextField userField = new TextField();
        PasswordField passField = new PasswordField();

        // Button
        Button loginButton = new Button("Login");

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);

        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);

        grid.add(loginButton, 1, 2);

        // Button action
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            String validUser = System.getenv("LOGIN_USER");
            String validPass = System.getenv("LOGIN_PASS");
            if (username.equals(validUser) && password.equals(validPass)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Credentials");
            }
        });

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
