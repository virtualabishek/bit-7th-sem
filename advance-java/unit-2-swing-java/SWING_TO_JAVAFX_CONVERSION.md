# Swing to JavaFX Conversion Guide

## 📌 Assignment: Convert Swing GUI to JavaFX

**Objective**: Understand how to migrate from Swing to JavaFX and recognize the major architectural changes between the two frameworks.

---

## 🎯 Quick Comparison

| Aspect | Swing | JavaFX |
|--------|-------|--------|
| **Architecture** | AWT-based (older) | Modern, GPU-accelerated |
| **Entry Point** | `JFrame` | `Stage` + `Scene` |
| **Layout** | Layout managers | Scene graph |
| **Styling** | L&F classes | CSS |
| **Components** | `JButton`, `JLabel` | `Button`, `Label` |
| **Event Handling** | Listeners | Lambda expressions |
| **Graphics** | Limited | Advanced (2D, 3D, effects) |
| **Performance** | Slower | Faster (hardware acceleration) |
| **Threading Model** | EDT (Event Dispatch Thread) | JavaFX Application Thread |

---

## 📝 Example 1: Simple Button Form

### **Swing Version**

```java
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingButtonForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Swing Button Form");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create components
        JLabel label = new JLabel("Hello, Swing!");
        JButton button = new JButton("Click Me");
        JTextField textField = new JTextField("Enter text");
        
        // Set layout manually (without layout manager)
        frame.setLayout(null);
        label.setBounds(50, 30, 300, 30);
        button.setBounds(50, 80, 100, 40);
        textField.setBounds(50, 130, 300, 30);
        
        // Add event listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });
        
        // Add components
        frame.add(label);
        frame.add(button);
        frame.add(textField);
        
        // Display
        frame.setVisible(true);
    }
}
```

### **JavaFX Equivalent**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxButtonForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create components
        Label label = new Label("Hello, JavaFX!");
        Button button = new Button("Click Me");
        TextField textField = new TextField("Enter text");
        
        // Set event handler (lambda)
        button.setOnAction(e -> label.setText("Button Clicked!"));
        
        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button, textField);
        
        // Create scene
        Scene scene = new Scene(layout, 400, 200);
        
        // Configure stage
        primaryStage.setTitle("JavaFX Button Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

---

## 🔄 Major Changes & Explanations

### **1. Entry Point - Frame vs Stage**

**Swing:**
```java
JFrame frame = new JFrame("Title");
frame.setSize(400, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
```

**JavaFX:**
```java
Stage primaryStage = new Stage();  // Passed as parameter
primaryStage.setTitle("Title");
primaryStage.setScene(scene);
primaryStage.show();
```

| Aspect | Swing | JavaFX |
|--------|-------|--------|
| **Window Class** | `JFrame` | `Stage` |
| **Container** | Direct component addition | Scene (which holds layout) |
| **Visibility** | `setVisible(true)` | `show()` |
| **Sizing** | `setSize()` | Set on Scene constructor |

---

### **2. Component Creation - JButton vs Button**

**Swing:**
```java
JButton button = new JButton("Click");
button.setBounds(50, 80, 100, 40);  // Manual positioning
frame.add(button);
```

**JavaFX:**
```java
Button button = new Button("Click");
layout.getChildren().add(button);  // Automatic positioning via layout
```

**Key Differences:**
- JavaFX buttons don't need manual positioning
- Layout managers handle all positioning automatically
- No `setBounds()` needed in JavaFX

---

### **3. Layout Management**

**Swing (Manual Layout):**
```java
frame.setLayout(null);  // No layout manager
label.setBounds(50, 30, 300, 30);      // x, y, width, height
button.setBounds(50, 80, 100, 40);
textField.setBounds(50, 130, 300, 30);
```

**JavaFX (Automatic Layout):**
```java
VBox layout = new VBox(10);  // 10px spacing
layout.getChildren().addAll(label, button, textField);
// Components arranged automatically!
```

| Swing Layout | JavaFX Equivalent |
|--------------|-------------------|
| `null` (manual) | N/A (not recommended) |
| `BorderLayout` | `BorderPane` |
| `GridLayout(5,5)` | `GridPane` |
| `FlowLayout` | `HBox` or `VBox` |
| `BoxLayout` | `VBox` or `HBox` |
| `GridBagLayout` | `GridPane` |

---

### **4. Event Handling**

**Swing (Anonymous Class):**
```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Button Clicked!");
    }
});
```

**JavaFX (Lambda Expression):**
```java
button.setOnAction(e -> label.setText("Button Clicked!"));
```

**Comparison:**
| Aspect | Swing | JavaFX |
|--------|-------|--------|
| **Listener Type** | `ActionListener` interface | Method reference / Lambda |
| **Method** | `actionPerformed()` | `setOnAction()` |
| **Code Length** | ~6 lines | 1 line |
| **Readability** | Verbose | Concise |

---

### **5. Component Hierarchy**

**Swing Structure:**
```
JFrame (Window)
├── JLabel
├── JButton
├── JTextField
└── (Components added directly)
```

**JavaFX Structure:**
```
Stage (Window)
├── Scene
│   └── VBox (Layout)
│       ├── Label
│       ├── Button
│       └── TextField
```

**Key Difference:** JavaFX requires a `Scene` which contains a layout manager, which contains components.

---

### **6. Styling**

**Swing (Programmatic):**
```java
label.setFont(new Font("Arial", Font.BOLD, 14));
label.setForeground(Color.BLUE);
button.setBackground(Color.GREEN);
button.setForeground(Color.WHITE);
```

**JavaFX (CSS):**
```java
label.setStyle("-fx-font-size: 14; -fx-text-fill: blue; -fx-font-weight: bold;");
button.setStyle("-fx-background-color: green; -fx-text-fill: white;");
```

Or use external CSS file (JavaFX only):
```java
scene.getStylesheets().add("style.css");
```

---

### **7. Text Components**

**Swing vs JavaFX:**

| Swing | JavaFX | Purpose |
|-------|--------|---------|
| `JLabel` | `Label` | Static text |
| `JTextField` | `TextField` | Single-line input |
| `JTextArea` | `TextArea` | Multi-line input |
| `JButton` | `Button` | Clickable button |
| `JCheckBox` | `CheckBox` | Boolean selection |
| `JRadioButton` | `RadioButton` | Single selection |
| `JComboBox` | `ComboBox` | Dropdown list |
| `JScrollPane` | `ScrollPane` | Scrollable container |

---

## 📊 Complete Conversion Example: SwingSecond → JavaFX

### **Original Swing Code (SwingSecond.java)**

```java
import java.awt.GridLayout;
import javax.swing.*;

public class SwingSecond extends JFrame {
    SwingSecond() {
        setSize(500, 500);
        setTitle("JFrame Demo");
        setLayout(new GridLayout(5, 5));
        
        JLabel myJLabel = new JLabel("JLabel..");
        add(myJLabel);
        
        JButton myButton = new JButton("Submit");
        myButton.setBounds(150, 100, 50, 20);
        add(myButton);
        
        JTextField myTextField = new JTextField("Default Value");
        add(myTextField);
        
        setVisible(true);
        
        JTextArea myTextArea = new JTextArea("JTextArea");
        JScrollPane myScrollPane = new JScrollPane(myTextArea);
        add(myScrollPane);
        
        JCheckBox myCheckBox = new JCheckBox("JCheckBox");
        add(myCheckBox);
    }

    public static void main(String[] args) {
        new SwingSecond();
    }
}
```

### **Converted JavaFX Code**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class JavaFxSecond extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create components
        Label myLabel = new Label("JLabel..");
        Button myButton = new Button("Submit");
        TextField myTextField = new TextField("Default Value");
        TextArea myTextArea = new TextArea("JTextArea");
        myTextArea.setWrapText(true);
        CheckBox myCheckBox = new CheckBox("JCheckBox");
        
        // Create layout (GridPane is like GridLayout)
        GridPane layout = new GridPane();
        layout.setHgap(10);  // Horizontal gap
        layout.setVgap(10);  // Vertical gap
        layout.setPadding(new Insets(10));  // Padding around edges
        
        // Add components to grid
        layout.add(myLabel, 0, 0);
        layout.add(myButton, 0, 1);
        layout.add(myTextField, 0, 2);
        layout.add(myTextArea, 0, 3);
        layout.add(myCheckBox, 0, 4);
        
        // Create scene
        Scene scene = new Scene(layout, 500, 500);
        
        // Configure stage
        primaryStage.setTitle("JFrame Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### **Changes Summary:**

| Component | Swing | JavaFX | Changes |
|-----------|-------|--------|---------|
| **Container** | `JFrame` extending | `Application` with `start()` | Different entry point |
| **Layout** | `GridLayout(5,5)` | `GridPane` with gaps | More explicit gap setting |
| **Label** | `JLabel` | `Label` | Simple rename |
| **Button** | `JButton` | `Button` | Simple rename |
| **TextField** | `JTextField` | `TextField` | Simple rename |
| **TextArea** | `JTextArea` + `JScrollPane` | `TextArea` | Scrolling built-in |
| **CheckBox** | `JCheckBox` | `CheckBox` | Simple rename |
| **Scene** | N/A | `Scene` required | JavaFX requires Scene |
| **Sizing** | `setSize()` | Scene constructor | Different approach |

---

## 🔑 Key Architectural Differences

### **1. Application Lifecycle**

**Swing:**
```
JFrame created
    ↓
Components added
    ↓
setVisible(true)
    ↓
Event loop runs (EDT)
```

**JavaFX:**
```
Application.start() called by launcher
    ↓
Stage and Scene created
    ↓
Components added to layout
    ↓
show() called
    ↓
JavaFX Application Thread handles events
```

---

### **2. Threading Model**

**Swing (EDT - Event Dispatch Thread):**
```java
SwingUtilities.invokeLater(() -> {
    // UI updates must happen on EDT
    label.setText("Updated");
});
```

**JavaFX (JavaFX Application Thread):**
```java
Platform.runLater(() -> {
    // UI updates must happen on JavaFX thread
    label.setText("Updated");
});
```

---

### **3. Module System**

**Swing:**
- Part of standard JDK
- No module path needed

**JavaFX:**
- Separate from JDK (since Java 11)
- Requires module path or Maven/Gradle
- Must import from `javafx.*` packages

---

## 🧠 Why Migrate from Swing to JavaFX?

### **Advantages of JavaFX:**

| Feature | Swing | JavaFX |
|---------|-------|--------|
| **Modern Look & Feel** | Outdated | Professional |
| **GPU Acceleration** | ❌ | ✅ |
| **CSS Styling** | ❌ | ✅ |
| **Animations** | Complex | Easy |
| **2D/3D Graphics** | Limited | Powerful |
| **Media Support** | Limited | Good |
| **Performance** | Slower | Faster |
| **Development Time** | Longer | Shorter |
| **Code Readability** | Verbose | Concise |

---

## 🔄 Migration Checklist

### **Step 1: Replace Components**

```java
// Swing → JavaFX
JFrame → Stage (in start() method)
JPanel → VBox / HBox / BorderPane
JLabel → Label
JButton → Button
JTextField → TextField
JTextArea → TextArea
JCheckBox → CheckBox
JComboBox → ComboBox
JTable → TableView
JList → ListView
```

### **Step 2: Replace Layouts**

```java
// Swing → JavaFX
null (manual) → VBox / HBox / BorderPane
BorderLayout → BorderPane
GridLayout → GridPane
FlowLayout → HBox
BoxLayout → VBox / HBox
GridBagLayout → GridPane (complex)
```

### **Step 3: Replace Event Handlers**

```java
// Swing → JavaFX
addActionListener() → setOnAction()
addMouseListener() → setOnMouseClicked()
addKeyListener() → setOnKeyPressed()
```

### **Step 4: Add Scene & Stage**

```java
// Always required in JavaFX
Stage stage = new Stage();  // or use primaryStage parameter
Scene scene = new Scene(layout, width, height);
stage.setScene(scene);
stage.show();
```

### **Step 5: Update Entry Point**

```java
// Swing
public static void main(String[] args) {
    new SwingFrame();
}

// JavaFX
public static void main(String[] args) {
    launch(args);
}
```

---

## 💡 Best Practices for Migration

### **1. Use Layout Managers (Don't use `null` layout)**

❌ **Bad (Swing style):**
```java
frame.setLayout(null);
button.setBounds(50, 50, 100, 30);
```

✅ **Good (JavaFX style):**
```java
VBox layout = new VBox(10);
layout.getChildren().add(button);
Scene scene = new Scene(layout, 300, 300);
```

### **2. Use Lambda for Events**

❌ **Verbose:**
```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        doSomething();
    }
});
```

✅ **Concise:**
```java
button.setOnAction(e -> doSomething());
```

### **3. Use CSS for Styling**

❌ **Programmatic:**
```java
button.setBackground(Color.BLUE);
button.setForeground(Color.WHITE);
label.setFont(new Font("Arial", Font.BOLD, 14));
```

✅ **CSS:**
```java
button.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
label.setStyle("-fx-font: 14 bold Arial;");
```

### **4. Proper Scene Graph Structure**

✅ **Good:**
```
Stage
└── Scene
    └── BorderPane (or VBox, HBox, etc.)
        ├── Components
        └── More Components
```

❌ **Bad:**
```
Stage
└── Component (no Scene/Layout)
```

---

## 📚 Quick Reference: Component Mapping

### **Text Display**

| Purpose | Swing | JavaFX |
|---------|-------|--------|
| Static text | `JLabel` | `Label` |
| Single-line input | `JTextField` | `TextField` |
| Multi-line input | `JTextArea` | `TextArea` |
| Password input | `JPasswordField` | `PasswordField` |

### **Selection Components**

| Purpose | Swing | JavaFX |
|---------|-------|--------|
| Boolean choice | `JCheckBox` | `CheckBox` |
| Single selection | `JRadioButton` | `RadioButton` |
| Dropdown list | `JComboBox` | `ComboBox` |
| List selection | `JList` | `ListView` |
| Table | `JTable` | `TableView` |
| Tree | `JTree` | `TreeView` |

### **Buttons**

| Purpose | Swing | JavaFX |
|---------|-------|--------|
| Simple button | `JButton` | `Button` |
| Grouped buttons | `ButtonGroup` | `ToggleGroup` |
| Toggle button | `JToggleButton` | `ToggleButton` |

### **Containers**

| Purpose | Swing | JavaFX |
|---------|-------|--------|
| Top-level window | `JFrame` | `Stage` |
| Panel | `JPanel` | `Pane` or `VBox`/`HBox` |
| Tab container | `JTabbedPane` | `TabPane` |
| Scroll container | `JScrollPane` | `ScrollPane` |
| Split container | `JSplitPane` | `SplitPane` |

---

## 🎓 Summary

### **Swing Paradigm:**
- Imperative: manually position everything
- Use layout managers with coordinate-based positioning
- Listeners with anonymous classes
- Programmatic styling
- Legacy framework

### **JavaFX Paradigm:**
- Declarative: describe what you want
- Use layout managers that handle positioning
- Lambdas for concise event handling
- CSS styling
- Modern framework

### **Migration Path:**
```
Understand Swing structure
    ↓
Learn JavaFX concepts
    ↓
Replace components (Swing → JavaFX)
    ↓
Replace layouts
    ↓
Replace event handlers
    ↓
Add Scene & Stage
    ↓
Update entry point
    ↓
Test thoroughly
```

---

## 🚀 Next Steps

1. **Identify your Swing components** - List all JButton, JLabel, etc.
2. **Choose JavaFX equivalents** - Use the mapping table
3. **Redesign layout** - Don't use `null` layout in JavaFX
4. **Rewrite event handlers** - Use lambda expressions
5. **Add Scene & Stage** - Required in JavaFX
6. **Test functionality** - Ensure all features work
7. **Enhance styling** - Use CSS for professional look

---

**Remember: While migrating, focus on learning JavaFX's philosophy of declarative UI design and automatic layout management!**
