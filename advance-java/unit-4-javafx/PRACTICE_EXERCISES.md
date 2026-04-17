# JavaFX Practice Exercises - Hands-On Learning

## 📌 Level 1: Basic Modifications

### Exercise 1.1: Change Initial Label Text
**Objective**: Modify the initial text displayed in the label.

**Task**: Change `"Hello, JavaFX!"` to `"Welcome to JavaFX!"`

**Solution**:
```java
Label label = new Label("Welcome to JavaFX!");
```

---

### Exercise 1.2: Change Button Text
**Objective**: Modify the button label.

**Task**: Change button text from `"Click Me"` to `"Submit"`

**Solution**:
```java
Button button = new Button("Submit");
```

---

### Exercise 1.3: Change Window Size
**Objective**: Resize the application window.

**Task**: Change window size from 300x200 to 400x300 pixels.

**Solution**:
```java
Scene scene = new Scene(layout, 400, 300);
```

---

### Exercise 1.4: Change Window Title
**Objective**: Modify the window title.

**Task**: Change title from `"JavaFX Example"` to `"My First JavaFX App"`

**Solution**:
```java
primaryStage.setTitle("My First JavaFX App");
```

---

## 📌 Level 2: Event Handling

### Exercise 2.1: Multiple Click Handler
**Objective**: Handle button clicks with different behaviors.

**Task**: 
- First click: Label shows "Button Clicked!"
- Second click: Label shows "Clicked Again!"
- Use a counter to track clicks

**Solution**:
```java
int[] clickCount = {0};
button.setOnAction(e -> {
    clickCount[0]++;
    if (clickCount[0] == 1) {
        label.setText("Button Clicked!");
    } else if (clickCount[0] == 2) {
        label.setText("Clicked Again!");
    }
});
```

---

### Exercise 2.2: Reset Button
**Objective**: Add a reset button to restore initial state.

**Task**:
- Create a new button labeled "Reset"
- When clicked, restore label text to "Hello, JavaFX!"
- Add it to the layout

**Solution**:
```java
Button resetButton = new Button("Reset");
resetButton.setOnAction(e -> label.setText("Hello, JavaFX!"));
layout.getChildren().add(resetButton);
```

---

### Exercise 2.3: Cycling Text
**Objective**: Cycle through multiple messages on each click.

**Task**:
- Messages: "Click 1", "Click 2", "Click 3"
- After "Click 3", restart from "Click 1"

**Solution**:
```java
int[] counter = {0};
button.setOnAction(e -> {
    counter[0] = (counter[0] + 1) % 3;
    String[] messages = {"Click 1", "Click 2", "Click 3"};
    label.setText(messages[counter[0]]);
});
```

---

## 📌 Level 3: Layout & UI Improvements

### Exercise 3.1: Horizontal Layout
**Objective**: Arrange buttons horizontally instead of vertically.

**Task**:
- Replace VBox with HBox
- Display label and button side-by-side

**Solution**:
```java
import javafx.scene.layout.HBox;

// In start() method:
HBox layout = new HBox(10);
layout.getChildren().addAll(label, button);
```

---

### Exercise 3.2: Multiple Buttons
**Objective**: Create an application with 3 buttons.

**Task**:
- Button 1: Changes label to "First Button Clicked"
- Button 2: Changes label to "Second Button Clicked"
- Button 3: Changes label to "Third Button Clicked"

**Solution**:
```java
Button button1 = new Button("Button 1");
Button button2 = new Button("Button 2");
Button button3 = new Button("Button 3");

button1.setOnAction(e -> label.setText("First Button Clicked"));
button2.setOnAction(e -> label.setText("Second Button Clicked"));
button3.setOnAction(e -> label.setText("Third Button Clicked"));

layout.getChildren().addAll(label, button1, button2, button3);
```

---

### Exercise 3.3: Centered Layout
**Objective**: Center components in the window.

**Task**:
- Use BorderPane to center the label and buttons
- Create a professional-looking layout

**Solution**:
```java
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

BorderPane root = new BorderPane();
VBox center = new VBox(10, label, button);
center.setAlignment(Pos.CENTER);
root.setCenter(center);

Scene scene = new Scene(root, 300, 200);
```

---

## 📌 Level 4: Styling

### Exercise 4.1: Color Styling
**Objective**: Apply colors to components.

**Task**:
- Make label text blue
- Make button background green
- Make button text white

**Solution**:
```java
label.setStyle("-fx-text-fill: blue; -fx-font-size: 14;");
button.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 12;");
```

---

### Exercise 4.2: Font Styling
**Objective**: Apply font styles.

**Task**:
- Make label text bold and larger (size 18)
- Make button text italic and slightly larger

**Solution**:
```java
label.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
button.setStyle("-fx-font-size: 14; -fx-font-style: italic;");
```

---

### Exercise 4.3: Border & Padding
**Objective**: Add visual separation using borders and padding.

**Task**:
- Add padding to VBox (10px on all sides)
- Add border to label
- Improve spacing

**Solution**:
```java
layout.setStyle("-fx-padding: 10;");
label.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 5;");
```

---

## 📌 Level 5: Advanced Features

### Exercise 5.1: Dynamic Button Creation
**Objective**: Create buttons programmatically.

**Task**:
- Create 5 buttons dynamically in a loop
- Each button changes the label to show its number

**Solution**:
```java
for (int i = 1; i <= 5; i++) {
    Button btn = new Button("Button " + i);
    final int buttonNumber = i;
    btn.setOnAction(e -> label.setText("Button " + buttonNumber + " Clicked"));
    layout.getChildren().add(btn);
}
```

---

### Exercise 5.2: Text Counter
**Objective**: Count button clicks and display the count.

**Task**:
- Display "Clicks: 0" initially
- Increment and display count on each click

**Solution**:
```java
int[] clicks = {0};
button.setOnAction(e -> {
    clicks[0]++;
    label.setText("Clicks: " + clicks[0]);
});
```

---

### Exercise 5.3: Conditional Button Disabling
**Objective**: Disable button based on conditions.

**Task**:
- Count clicks
- After 5 clicks, disable the button
- Show "Button Disabled" in label

**Solution**:
```java
int[] clicks = {0};
button.setOnAction(e -> {
    clicks[0]++;
    label.setText("Clicks: " + clicks[0]);
    if (clicks[0] >= 5) {
        button.setDisable(true);
        label.setText("Button Disabled - Max clicks reached!");
    }
});
```

---

## 🎯 Challenge Problems

### Challenge 1: Calculator-Like Interface
**Description**: Create buttons for numbers 0-9 and a display label that shows the pressed numbers.

**Hint**: Use GridPane layout with 10 buttons arranged in rows and columns.

---

### Challenge 2: Color Picker
**Description**: Create 5 buttons (Red, Green, Blue, Yellow, White) that change the label background color when clicked.

**Hint**: Use `label.setStyle("-fx-background-color: red;");`

---

### Challenge 3: Text Formatter
**Description**: Create buttons to manipulate label text:
- UPPERCASE button
- lowercase button
- Capitalize First Letter button
- Clear button

**Hint**: Use `String.toUpperCase()`, `toLowerCase()`, etc.

---

### Challenge 4: Toggle Button
**Description**: Create a button that toggles between two states:
- State 1: Label shows "ON", Button text is "Turn OFF"
- State 2: Label shows "OFF", Button text is "Turn ON"

**Hint**: Use a boolean flag to track state.

---

### Challenge 5: Simple To-Do List
**Description**: Create a simple todo list with:
- Text input field for new items
- Add button to add items
- Display area (Label or ListView) showing items

**Hint**: Use TextField for input and TextArea for display.

---

## 📊 Exercise Difficulty Progression

```
Level 1: Basic ────> Level 2: Events ────> Level 3: Layout
  ↓                      ↓                      ↓
(5-10 min)            (10-15 min)             (15-20 min)
  ↓                      ↓                      ↓
Level 4: Styling ──> Level 5: Advanced ──> Challenges
  ↓                      ↓                      ↓
(10-15 min)            (20-30 min)            (30+ min)
```

---

## ✅ Completion Checklist

After completing these exercises, you should understand:

- [ ] Basic JavaFX application structure
- [ ] Creating Labels and Buttons
- [ ] Event handling with lambda expressions
- [ ] Layout managers (VBox, HBox, BorderPane)
- [ ] Styling components with CSS
- [ ] Dynamic UI manipulation
- [ ] State management in JavaFX applications
- [ ] User interaction patterns

---

## 🚀 Next Steps

1. **Try all Level 1 & 2 exercises** - Build confidence with basics
2. **Experiment with Level 3 & 4** - Improve UI design skills
3. **Tackle Level 5** - Practice advanced concepts
4. **Solve the Challenges** - Apply combined knowledge
5. **Build Your Own Project** - Create a unique JavaFX application

**Remember**: The best way to learn is by doing! Try modifying the code and experimenting with different combinations.

---

**Happy Coding! 🎉**
