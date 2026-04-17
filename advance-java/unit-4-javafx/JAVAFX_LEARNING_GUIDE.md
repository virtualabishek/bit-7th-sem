# JavaFX Learning Guide - Button & Label Application

## 📚 Overview
This guide explains the JavaFX program that creates a simple window with a Label and a Button. When the button is clicked, the label text changes.

---

## 🎯 Problem Statement
**Write a JavaFX program to create a simple window with a Label and a Button. When the button is clicked, the label text should change.**

---

## 💡 Key Concepts to Understand

### 1. **JavaFX Application Structure**
```
Application (Base Class)
    ├── Stage (Window)
    ├── Scene (Content Container)
    └── Nodes (UI Components)
         ├── Label
         ├── Button
         ├── VBox (Layout Manager)
         └── etc.
```

### 2. **Core Components**

#### **Application Class**
- JavaFX applications extend the `Application` class
- The `start(Stage primaryStage)` method is the entry point
- Must implement the `start()` method to create the UI

#### **Stage**
- Represents the main window
- You set the title, size, and scene on it
- Controls the lifecycle of the window (show(), hide())

#### **Scene**
- Container for all UI nodes
- Attached to a Stage
- Contains a root layout node (like VBox, HBox, etc.)

#### **Layout Managers**
- **VBox**: Arranges children vertically
- **HBox**: Arranges children horizontally
- **StackPane**: Overlays children on top of each other
- **BorderPane**: Five-region layout (Top, Bottom, Left, Right, Center)

#### **Label & Button**
- **Label**: Display-only text component (no user interaction)
- **Button**: Interactive component that triggers actions when clicked

---

## 🔍 Detailed Code Explanation

### **Imports**
```java
import javafx.application.Application;  // Base class for JavaFX apps
import javafx.scene.Scene;               // Container for content
import javafx.scene.control.Button;      // Button component
import javafx.scene.control.Label;       // Label component
import javafx.scene.layout.VBox;         // Vertical box layout
import javafx.stage.Stage;               // Window
```

### **Class Declaration**
```java
public class JavaFxFirst extends Application {
```
- Extends `Application` to make it a JavaFX application
- `Application` class provides lifecycle methods

### **start() Method (Main Entry Point)**
```java
@Override
public void start(Stage primaryStage) {
    // 1. Create a Label with initial text
    Label label = new Label("Hello, JavaFX!");
    
    // 2. Create a Button with text "Click Me"
    Button button = new Button("Click Me");
    
    // 3. Set an action listener on the button
    button.setOnAction(e -> label.setText("Button Clicked!"));
    
    // 4. Create a VBox layout with 10px spacing
    VBox layout = new VBox(10);
    
    // 5. Add label and button to the layout
    layout.getChildren().addAll(label, button);
    
    // 6. Create a Scene with the layout (300x200 pixels)
    Scene scene = new Scene(layout, 300, 200);
    
    // 7. Configure the Stage
    primaryStage.setTitle("JavaFX Example");
    primaryStage.setScene(scene);
    
    // 8. Display the window
    primaryStage.show();
}
```

#### **Step-by-Step Breakdown**

**Step 1-2: Create Components**
```java
Label label = new Label("Hello, JavaFX!");
Button button = new Button("Click Me");
```
- Creates a label with initial text
- Creates a button with text "Click Me"

**Step 3: Event Handler - The Heart of Interactivity**
```java
button.setOnAction(e -> label.setText("Button Clicked!"));
```
- `setOnAction()`: Registers an event listener for button clicks
- **Lambda Expression** `e -> label.setText("Button Clicked!")`:
  - `e`: The event object (ActionEvent)
  - `->`: Lambda operator
  - `label.setText("Button Clicked!")`: Action to perform on click
- This is the KEY part that makes the label text change!

**Step 4-5: Create Layout**
```java
VBox layout = new VBox(10);  // 10px spacing between children
layout.getChildren().addAll(label, button);
```
- **VBox**: Arranges components vertically
- The parameter `10` is the spacing between elements
- `getChildren().addAll()`: Adds both label and button to the layout

**Step 6: Create Scene**
```java
Scene scene = new Scene(layout, 300, 200);
```
- **Scene**: Container for the layout
- Parameters:
  - `layout`: The root node (VBox in this case)
  - `300`: Width in pixels
  - `200`: Height in pixels

**Step 7-8: Configure Stage and Show**
```java
primaryStage.setTitle("JavaFX Example");
primaryStage.setScene(scene);
primaryStage.show();
```
- `setTitle()`: Sets window title
- `setScene()`: Attaches the scene to the stage
- `show()`: Displays the window

### **main() Method**
```java
public static void main(String[] args) {
    launch(args);
}
```
- Entry point for the JVM
- `launch()`: Initializes the JavaFX runtime and calls `start()`

---

## 🚀 How to Run

### **Option 1: Using Maven (Recommended)**
```bash
cd unit-4-javafx
mvn clean compile
mvn javafx:run
```

### **Option 2: Manual Compilation & Execution**
```bash
# Compile
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls JavaFxFirst.java

# Run
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls JavaFxFirst
```

### **Option 3: Using IDE (IntelliJ IDEA or Eclipse)**
1. Right-click on the project
2. Select "Run"
3. The application window will open automatically

---

## 🎨 What You'll See When Running

1. **Initial State**:
   - A window titled "JavaFX Example"
   - A label displaying "Hello, JavaFX!"
   - A button labeled "Click Me"

2. **After Clicking the Button**:
   - The label text changes to "Button Clicked!"
   - You can click again, and the text remains "Button Clicked!"

---

## 📝 Hands-On Exercises to Deepen Understanding

### **Exercise 1: Change Button Text**
Modify the button click handler to also change the button text:
```java
button.setOnAction(e -> {
    label.setText("Button Clicked!");
    button.setText("Clicked!");
});
```

### **Exercise 2: Cycle Through Multiple Texts**
Use a counter to cycle through different messages:
```java
int[] counter = {0};
button.setOnAction(e -> {
    if (counter[0] % 2 == 0) {
        label.setText("First Click!");
    } else {
        label.setText("Second Click!");
    }
    counter[0]++;
});
```

### **Exercise 3: Add More Buttons**
Create multiple buttons with different actions:
```java
Button button2 = new Button("Reset");
button2.setOnAction(e -> label.setText("Hello, JavaFX!"));
layout.getChildren().add(button2);
```

### **Exercise 4: Use HBox Layout**
Arrange buttons horizontally instead of vertically:
```java
HBox layout = new HBox(10);
layout.getChildren().addAll(label, button);
```

### **Exercise 5: Styling with CSS**
Add CSS styling to components:
```java
label.setStyle("-fx-font-size: 16; -fx-text-fill: blue;");
button.setStyle("-fx-font-size: 14; -fx-padding: 10;");
```

---

## 🔑 Important Concepts

### **Event Handling**
- Buttons, Labels, and other components can trigger events
- Event handlers are registered using methods like `setOnAction()`, `setOnMouseClicked()`, etc.
- Lambda expressions make event handling concise and readable

### **Lambda Expressions (Java 8+)**
- Simplified anonymous function syntax
- Used extensively in JavaFX for event handling
- Format: `(parameters) -> { body }`

### **Layout Managers**
- Automatically position and size child nodes
- **VBox**: Vertical arrangement
- **HBox**: Horizontal arrangement
- **StackPane**: Overlapping arrangement
- Spacing parameter controls distance between children

### **Scene & Stage Relationship**
- **Stage** = Window (one per application)
- **Scene** = Content inside window (can have multiple scenes, switch between them)
- **Nodes** = Individual UI components (buttons, labels, etc.)

---

## 🎓 Real-World Applications

1. **Calculator GUI**: Buttons for numbers and operations, label for display
2. **Login Form**: Text fields for input, button to submit, label for status
3. **Settings Panel**: Buttons and labels to configure application options
4. **Game UI**: Buttons for controls, labels for score/health display

---

## 📚 Further Learning

1. **Event Handling**: Learn about `MouseEvent`, `KeyEvent`, `ScrollEvent`, etc.
2. **Layout Managers**: Explore `BorderPane`, `GridPane`, `FlowPane`
3. **Styling**: Master CSS styling for JavaFX components
4. **FXML**: Learn XML-based UI design with FXML files
5. **Controls**: Explore `TextField`, `CheckBox`, `ComboBox`, `ListView`, etc.
6. **Animation**: Learn `Timeline`, `Transition` for animations

---

## 🐛 Common Issues & Solutions

| Issue | Cause | Solution |
|-------|-------|----------|
| "Package javafx not found" | JavaFX not in classpath | Use Maven or add module path |
| Window doesn't appear | Missing `show()` call | Ensure `primaryStage.show()` is called |
| Button doesn't respond | Event handler not set | Use `setOnAction()` to register handler |
| No module named javafx | JVM not configured for modules | Use `--add-modules` flag |

---

## ✅ Summary

This JavaFX application demonstrates:
- ✅ Application structure (extending Application class)
- ✅ Component creation (Label, Button)
- ✅ Layout management (VBox)
- ✅ Event handling (setOnAction with lambda)
- ✅ Scene and Stage configuration
- ✅ Window display and interaction

By understanding this simple example, you're building the foundation for complex JavaFX applications!

---

**Happy Learning! 🚀**
