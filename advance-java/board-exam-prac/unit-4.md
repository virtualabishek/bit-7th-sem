For a **5-mark exam question**, write the answer in points:

## Steps of Writing a JavaFX Program

1. **Import JavaFX Packages**

   * Import the required JavaFX classes such as `Application`, `Stage`, `Scene`, and controls.

   ```java
   import javafx.application.Application;
   import javafx.stage.Stage;
   ```

2. **Extend the Application Class**

   * Create a class that extends the `Application` class.

   ```java
   public class MyApp extends Application
   ```

3. **Override the `start()` Method**

   * Implement the `start(Stage stage)` method, which is the entry point for JavaFX applications.

   ```java
   public void start(Stage stage)
   ```

4. **Create GUI Components and Scene**

   * Create controls (Button, Label, TextField, etc.).
   * Add them to a layout pane.
   * Create a `Scene` object.

   ```java
   Button btn = new Button("Click");
   Scene scene = new Scene(btn, 300, 200);
   ```

5. **Set Stage Properties and Display**

   * Set the scene on the stage, give a title, and display it.

   ```java
   stage.setTitle("JavaFX Program");
   stage.setScene(scene);
   stage.show();
   ```

6. **Launch the Application**

   * Call the `launch()` method from the `main()` method.

   ```java
   public static void main(String[] args) {
       launch(args);
   }
   ```

### JavaFX Program Structure

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyApp extends Application {

    public void start(Stage stage) {
        Button btn = new Button("Hello");

        Scene scene = new Scene(btn, 300, 200);

        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

### Memory Trick

Remember the sequence:

**Import → Extend → Start → Create Components → Create Scene → Set Stage → Show → Launch**

This covers almost every basic JavaFX program.
