import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginJavaFx extends Application {
    String user = System.getenv("LOGIN_USER");
    String pwd = System.getenv("LOGIN_PASS");
    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Student Login");
        Label userLabel = new Label("Username:");
        userLabel.setMinWidth(80);
        TextField userField = new TextField();
        userField.setPromptText("Enter username");  
        userField.setPrefWidth(220);

        HBox userRow = new HBox(10, userLabel, userField);
        userRow.setAlignment(Pos.CENTER_LEFT);

        Label passLabel = new Label("Password:");
        passLabel.setMinWidth(80);
        PasswordField passField = new PasswordField();  
        passField.setPromptText("Enter password");
        passField.setPrefWidth(220);

        HBox passRow = new HBox(10, passLabel, passField);
        passRow.setAlignment(Pos.CENTER_LEFT);

        Label messageLabel = new Label("");

        Button loginBtn = new Button("Login");
        loginBtn.setPrefWidth(100);
        loginBtn.setStyle(
            "-fx-background-color: #2c6fcc;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );

        Button clearBtn = new Button("Clear");
        clearBtn.setPrefWidth(100);
        clearBtn.setStyle("-fx-cursor: hand;");

        HBox buttonRow = new HBox(15, loginBtn, clearBtn);
        buttonRow.setAlignment(Pos.CENTER);

        // ── EVENT HANDLING ────────────────────────────────────

        loginBtn.setOnAction(event -> {
            String username = userField.getText().trim();
            String password = passField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText(" Please fill in all fields.");
                messageLabel.setTextFill(Color.ORANGE);
                return;
            }
            if (username.equals(user) && password.equals(pwd)) {
                messageLabel.setText("Login successful! Welcome, " + username + "!");
                messageLabel.setTextFill(Color.GREEN);
                loginBtn.setDisable(true); 
            } else {
                messageLabel.setText("Invalid username or password.");
                messageLabel.setTextFill(Color.RED);
                passField.clear(); 
            }
        });

        clearBtn.setOnAction(event -> {
            userField.clear();
            passField.clear();
            messageLabel.setText("");
            loginBtn.setDisable(false);
        });

        passField.setOnAction(event -> loginBtn.fire());

        VBox root = new VBox(18);   
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f4f6fb;");
        root.getChildren().addAll(
            titleLabel,
            new Separator(),
            userRow,
            passRow,
            messageLabel,
            buttonRow
        );

        Scene scene = new Scene(root, 420, 320);
        stage.setTitle("Login App");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}