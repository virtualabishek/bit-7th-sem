import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX conversion of SwingFirst.java
 * 
 * Original Swing Version:
 * - Created a JFrame
 * - Added a JButton manually with setBounds()
 * - Set layout to null for manual positioning
 * 
 * JavaFX Version:
 * - Uses Stage and Scene
 * - Uses VBox layout (automatic positioning)
 * - No need for manual setBounds()
 */
public class JavaFxFirstConverted extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ┌─ Major Change #1: Use Stage instead of JFrame
        // |  Stage is passed as parameter to start() method
        
        // ┌─ Create Button (like JButton)
        Button button = new Button("Click Me");
        // └─ No setBounds() needed! VBox handles positioning
        
        // ┌─ Major Change #2: Use VBox layout instead of null layout
        // |  VBox arranges components automatically
        VBox layout = new VBox(10);
        layout.getChildren().add(button);
        
        // ┌─ Major Change #3: Create Scene
        // |  In JavaFX, you need a Scene to hold the layout
        Scene scene = new Scene(layout, 400, 500);
        
        // ┌─ Configure Stage (like JFrame)
        primaryStage.setTitle("JavaFX First");
        primaryStage.setScene(scene);
        // └─ Use show() instead of setVisible(true)
        primaryStage.show();
    }

    public static void main(String[] args) {
        // ┌─ Major Change #4: Use launch() instead of new JFrame()
        launch(args);
        // └─ This starts the JavaFX Application Thread
    }
}

/**
 * KEY DIFFERENCES FROM SWING:
 * 
 * 1. Entry Point:
 *    Swing: extends JFrame, create in main()
 *    JavaFX: extends Application, override start()
 * 
 * 2. Window Container:
 *    Swing: JFrame
 *    JavaFX: Stage + Scene + Layout
 * 
 * 3. Layout Management:
 *    Swing: setLayout(null) + setBounds()
 *    JavaFX: VBox/HBox/BorderPane (automatic)
 * 
 * 4. Visibility:
 *    Swing: setVisible(true)
 *    JavaFX: show()
 * 
 * 5. Threading:
 *    Swing: Event Dispatch Thread (EDT)
 *    JavaFX: JavaFX Application Thread
 */
