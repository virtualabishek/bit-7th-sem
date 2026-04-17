import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxFirst extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Label
        Label label = new Label("Hello, JavaFX!");

        // Create a Button
        Button button = new Button("Click Me");

        // Set an action for the button
        button.setOnAction(e -> label.setText("Button Clicked!"));

        // Create a layout and add the Label and Button
        VBox layout = new VBox(10); // 10 is the spacing between elements
        layout.getChildren().addAll(label, button);

        // Create a Scene
        Scene scene = new Scene(layout, 300, 200);

        // Set up the Stage
        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

