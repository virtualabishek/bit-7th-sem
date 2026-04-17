import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX conversion of SwingSecond.java
 * 
 * Original Swing Version:
 * - Extended JFrame
 * - Used GridLayout(5,5)
 * - Added JLabel, JButton, JTextField, JTextArea, JCheckBox
 * 
 * JavaFX Version:
 * - Extends Application
 * - Uses GridPane instead of GridLayout
 * - All components have JavaFX equivalents
 * - Shows major architectural differences
 */
public class JavaFxSecondConverted extends Application {

    @Override
    public void start(Stage primaryStage) {
        // ┌─ Create Components (renamed from Swing)
        Label myLabel = new Label("JLabel..");
        Button myButton = new Button("Submit");
        TextField myTextField = new TextField("Default Value");
        TextArea myTextArea = new TextArea("JTextArea");
        CheckBox myCheckBox = new CheckBox("JCheckBox");
        
        // ┌─ Configure TextArea properties
        // |  In Swing, you needed JScrollPane wrapper
        // |  In JavaFX, TextArea has scrolling built-in
        myTextArea.setWrapText(true);
        myTextArea.setPrefRowCount(5);
        myTextArea.setStyle("-fx-control-inner-background: #f0f0f0;");
        
        // ┌─ Major Change: Use GridPane instead of GridLayout
        // |  GridPane is more powerful and flexible
        GridPane layout = new GridPane();
        
        // ┌─ Set gaps (spacing between cells)
        // |  GridLayout didn't have this level of control
        layout.setHgap(10);  // Horizontal gap
        layout.setVgap(10);  // Vertical gap
        
        // ┌─ Set padding (space around edges)
        // |  GridLayout didn't have this feature
        layout.setPadding(new Insets(15));
        
        // ┌─ Add components to grid
        // |  Format: add(component, column, row)
        // |  Much clearer than Swing's add() with automatic positioning
        layout.add(myLabel,     0, 0);
        layout.add(myButton,    0, 1);
        layout.add(myTextField, 0, 2);
        layout.add(myTextArea,  0, 3);
        layout.add(myCheckBox,  0, 4);
        
        // ┌─ Major Change: Create Scene
        // |  JavaFX requires Scene as intermediate between Stage and Layout
        Scene scene = new Scene(layout, 500, 500);
        
        // ┌─ Configure Stage (like JFrame)
        primaryStage.setTitle("JFrame Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * DETAILED CONVERSION NOTES:
 * 
 * ┌─────────────────────────────────────────────────────────┐
 * │ Component Conversion                                    │
 * ├─────────────────────────────────────────────────────────┤
 * │ Swing: JLabel        →  JavaFX: Label                  │
 * │ Swing: JButton       →  JavaFX: Button                 │
 * │ Swing: JTextField    →  JavaFX: TextField              │
 * │ Swing: JTextArea     →  JavaFX: TextArea               │
 * │ Swing: JCheckBox     →  JavaFX: CheckBox               │
 * │ Swing: JFrame        →  JavaFX: Stage                  │
 * │ Swing: GridLayout    →  JavaFX: GridPane               │
 * └─────────────────────────────────────────────────────────┘
 * 
 * ┌─────────────────────────────────────────────────────────┐
 * │ Layout Differences                                      │
 * ├─────────────────────────────────────────────────────────┤
 * │ Swing GridLayout:                                       │
 * │   new GridLayout(5, 5)                                  │
 * │   - All cells same size                                 │
 * │   - No gaps control                                     │
 * │   - Limited flexibility                                 │
 * │                                                         │
 * │ JavaFX GridPane:                                        │
 * │   new GridPane()                                        │
 * │   - Flexible cell sizing                                │
 * │   - Explicit hgap, vgap control                         │
 * │   - Padding support                                     │
 * │   - Column/Row constraints                              │
 * │   - Much more powerful!                                 │
 * └─────────────────────────────────────────────────────────┘
 * 
 * ┌─────────────────────────────────────────────────────────┐
 * │ TextArea Differences                                    │
 * ├─────────────────────────────────────────────────────────┤
 * │ Swing:                                                  │
 * │   JTextArea myTextArea = new JTextArea();              │
 * │   JScrollPane myScrollPane = new JScrollPane(myTextArea);
 * │   add(myScrollPane);                                    │
 * │   (Two components: TextArea + ScrollPane)              │
 * │                                                         │
 * │ JavaFX:                                                 │
 * │   TextArea myTextArea = new TextArea();                │
 * │   myTextArea.setWrapText(true);                        │
 * │   add(myTextArea);                                      │
 * │   (One component: TextArea with built-in scrolling)    │
 * └─────────────────────────────────────────────────────────┘
 * 
 * ┌─────────────────────────────────────────────────────────┐
 * │ Architectural Differences                               │
 * ├─────────────────────────────────────────────────────────┤
 * │ Swing Entry Point:                                      │
 * │   public SwingSecond() { ... }  // Constructor          │
 * │   new SwingSecond();             // In main()           │
 * │                                                         │
 * │ JavaFX Entry Point:                                     │
 * │   public void start(Stage stage) { ... }               │
 * │   launch(args);                  // In main()           │
 * │   (Framework calls start() automatically)              │
 * └─────────────────────────────────────────────────────────┘
 * 
 * MAJOR ARCHITECTURAL CHANGES:
 * 
 * 1. ENTRY POINT STRUCTURE
 *    - Swing: Constructor-based, manual frame creation
 *    - JavaFX: Method-based, framework calls start()
 * 
 * 2. COMPONENT HIERARCHY
 *    - Swing: JFrame → Components (flat)
 *    - JavaFX: Stage → Scene → Layout → Components (nested)
 * 
 * 3. LAYOUT MANAGEMENT
 *    - Swing: Separate layout managers + manual bounds
 *    - JavaFX: Integrated layout with automatic sizing
 * 
 * 4. SCROLLING
 *    - Swing: Separate JScrollPane wrapper needed
 *    - JavaFX: Built-in to most components
 * 
 * 5. THREADING
 *    - Swing: Event Dispatch Thread (EDT)
 *    - JavaFX: JavaFX Application Thread
 * 
 * 6. STYLING
 *    - Swing: Programmatic (setFont, setBackground)
 *    - JavaFX: CSS-based or programmatic
 * 
 * WHY JAVAFX IS BETTER:
 * ✅ Cleaner syntax
 * ✅ More powerful layouts
 * ✅ Better performance (GPU acceleration)
 * ✅ Modern UI capabilities
 * ✅ CSS support
 * ✅ 2D/3D graphics
 * ✅ Animation support
 */
