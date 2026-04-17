# JavaFX Project Setup & Quick Reference

## 📁 Project Structure

```
unit-4-javafx/
├── pom.xml                          # Maven configuration file
├── src/
│   └── main/
│       └── java/
│           └── JavaFxFirst.java     # Main application code
├── target/
│   ├── classes/
│   │   └── JavaFxFirst.class        # Compiled bytecode
│   └── ...                          # Build artifacts
├── JAVAFX_LEARNING_GUIDE.md         # Comprehensive learning guide
├── PRACTICE_EXERCISES.md            # Hands-on practice problems
└── PROJECT_SETUP.md                 # This file
```

---

## 🚀 Quick Start Commands

### **1. Compile the Project**
```bash
cd unit-4-javafx
mvn clean compile
```
**Expected Output**: `BUILD SUCCESS` and `JavaFxFirst.class` in `target/classes/`

### **2. Run the Application**
```bash
mvn javafx:run
```
**Expected Behavior**: A window appears with:
- Label: "Hello, JavaFX!"
- Button: "Click Me"
- Clicking the button changes label to "Button Clicked!"

### **3. Clean Build Files**
```bash
mvn clean
```
**Effect**: Removes `target/` directory

---

## 🔧 Maven Configuration Explained

### **pom.xml Overview**
The `pom.xml` file configures:

1. **Project Metadata**
   ```xml
   <groupId>com.learning</groupId>
   <artifactId>javafx-tutorial</artifactId>
   <version>1.0</version>
   ```

2. **Java Version & Encoding**
   ```xml
   <maven.compiler.source>17</maven.compiler.source>
   <maven.compiler.target>17</maven.compiler.target>
   ```

3. **JavaFX Dependencies**
   ```xml
   <dependency>
       <groupId>org.openjfx</groupId>
       <artifactId>javafx-controls</artifactId>
       <version>21.0.2</version>
   </dependency>
   ```
   - `javafx-controls`: Buttons, Labels, ComboBox, etc.
   - `javafx-fxml`: XML-based UI design
   - `javafx-graphics`: Graphics and shapes
   - `javafx-base`: Base classes

4. **Build Plugins**
   - `maven-compiler-plugin`: Compiles Java source code
   - `javafx-maven-plugin`: Runs JavaFX applications

---

## 📚 Key Classes & Methods

### **Application Class**
```java
public class JavaFxFirst extends Application {
    @Override
    public void start(Stage primaryStage) { }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### **Label Class**
```java
Label label = new Label("Text");
label.setText("New Text");      // Change text
label.getText();                // Get text
label.setStyle("-fx-font-size: 16;");  // Style
```

### **Button Class**
```java
Button button = new Button("Click");
button.setOnAction(e -> {       // Event handler
    // Action code here
});
button.setText("New Text");     // Change text
button.setDisable(true);        // Disable button
```

### **VBox Layout**
```java
VBox vbox = new VBox(spacing);
vbox.getChildren().add(node);           // Add single node
vbox.getChildren().addAll(node1, node2); // Add multiple nodes
vbox.setStyle("-fx-padding: 10;");      // Add padding
```

### **Scene Class**
```java
Scene scene = new Scene(root, width, height);
primaryStage.setScene(scene);
```

### **Stage Class**
```java
primaryStage.setTitle("Window Title");
primaryStage.setScene(scene);
primaryStage.show();            // Display window
primaryStage.setWidth(500);     // Set width
primaryStage.setHeight(400);    // Set height
```

---

## 🎯 Common JavaFX Components

| Component | Purpose | Example |
|-----------|---------|---------|
| **Label** | Display text (read-only) | `new Label("Hello")` |
| **Button** | Clickable button | `new Button("Click")` |
| **TextField** | Single-line text input | `new TextField()` |
| **TextArea** | Multi-line text input | `new TextArea()` |
| **CheckBox** | Boolean toggle | `new CheckBox("Option")` |
| **RadioButton** | Single selection in group | `new RadioButton("Option")` |
| **ComboBox** | Dropdown list | `new ComboBox<>()` |
| **ListView** | List selection | `new ListView<>()` |
| **Image** | Display images | `new Image("path")` |

---

## 🎨 Common CSS Styles

```java
// Font styling
"-fx-font-size: 16;"
"-fx-font-weight: bold;"
"-fx-font-style: italic;"
"-fx-font-family: 'Arial';"

// Color styling
"-fx-text-fill: blue;"
"-fx-background-color: #CCCCCC;"
"-fx-border-color: black;"
"-fx-border-width: 1;"

// Spacing & sizing
"-fx-padding: 10;"              // All sides
"-fx-padding: 10 20 10 20;"     // Top Right Bottom Left
"-fx-margin: 10;"
"-fx-min-width: 100;"
"-fx-max-width: 500;"

// Effects
"-fx-opacity: 0.8;"
"-fx-scale-x: 1.2;"
"-fx-scale-y: 1.2;"
```

---

## 💾 File Locations

| Item | Path |
|------|------|
| Main Source | `src/main/java/JavaFxFirst.java` |
| Compiled Class | `target/classes/JavaFxFirst.class` |
| Maven Config | `pom.xml` |
| Learning Guide | `JAVAFX_LEARNING_GUIDE.md` |
| Practice Exercises | `PRACTICE_EXERCISES.md` |

---

## 🐛 Troubleshooting

### **Problem: "package javafx not found"**
```
Solution: Run `mvn clean compile` to download dependencies
```

### **Problem: "Cannot find symbol: class Stage"**
```
Solution: Ensure all imports are present
```

### **Problem: Window doesn't appear**
```
Solution: Check that primaryStage.show() is called
```

### **Problem: Button doesn't respond**
```
Solution: Verify setOnAction() is called with proper lambda
```

### **Problem: Changes not reflected**
```
Solution: Run `mvn clean compile` to rebuild
```

---

## 📖 Learning Pathway

### **Day 1: Fundamentals**
- [ ] Understand Application structure
- [ ] Create basic Label and Button
- [ ] Set up Maven project
- [ ] Complete Level 1 exercises

### **Day 2: Event Handling**
- [ ] Learn lambda expressions
- [ ] Implement button click handlers
- [ ] Complete Level 2 exercises

### **Day 3: UI Design**
- [ ] Learn layout managers (VBox, HBox)
- [ ] Create multi-component layouts
- [ ] Complete Level 3 exercises

### **Day 4: Styling & Polish**
- [ ] Apply CSS styles
- [ ] Improve visual appearance
- [ ] Complete Level 4 exercises

### **Day 5: Advanced Concepts**
- [ ] Dynamic component creation
- [ ] Complex event handling
- [ ] Complete Level 5 exercises

### **Day 6: Project Building**
- [ ] Solve challenge problems
- [ ] Build your own project
- [ ] Integrate with other concepts

---

## ✨ Tips for Success

1. **Run Often**: Compile and run after each change
2. **Use IDE**: VS Code, IntelliJ, or Eclipse for better experience
3. **Read Error Messages**: They usually tell you what's wrong
4. **Experiment**: Try modifying code to see effects
5. **Reference Documentation**: JavaFX official docs are comprehensive
6. **Start Simple**: Build on basics before trying advanced features
7. **Debug Strategically**: Use print statements to track execution

---

## 🔗 Useful Links

- **JavaFX Official**: https://gluonhq.com/products/javafx/
- **JavaFX Documentation**: https://openjfx.io/
- **Maven Guide**: https://maven.apache.org/
- **CSS Reference**: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html

---

## 📝 Notes

- JavaFX uses the **FXML** format for XML-based UI design (advanced)
- The **scenebuilder** tool helps create FXML UIs visually
- **Gradle** is an alternative to Maven for dependency management
- JavaFX runs on **JDK 11+** (we're using JDK 17)

---

**You're ready to start learning JavaFX! 🎉**
