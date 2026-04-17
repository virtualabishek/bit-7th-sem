import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * STUDENT REGISTRATION FORM
 * Assignment: Design using GridPane + VBox/HBox layouts
 * 
 * LAYOUT DESIGN JUSTIFICATION:
 * ============================
 * 
 * 1. VBox (Main Container - VERTICAL):
 *    - Used for overall vertical layout structure
 *    - Contains: Title, Form Section, Button Section
 *    - Reason: We need elements stacked vertically from top to bottom
 * 
 * 2. GridPane (Form Fields - ROWS & COLUMNS):
 *    - Used for organizing form fields in 2 columns (Label | Input)
 *    - Reason: Professional form layout with aligned labels and input fields
 *    - Benefits: Easy alignment, automatic spacing, scalable
 * 
 * 3. HBox (Buttons - HORIZONTAL):
 *    - Used for arranging Submit and Reset buttons side-by-side
 *    - Reason: Buttons logically grouped together horizontally
 *    - Easier than VBox for button arrangement
 * 
 * OVERALL STRUCTURE:
 * ==================
 * VBox (Main)
 *  ├─ Label (Title)
 *  ├─ Separator
 *  ├─ GridPane (Form Fields)
 *  │   ├─ Row 0: Roll Number Label | Roll Number TextField
 *  │   ├─ Row 1: Name Label | Name TextField
 *  │   ├─ Row 2: Email Label | Email TextField
 *  │   ├─ Row 3: Mobile Label | Mobile TextField
 *  │   ├─ Row 4: Branch Label | Branch ComboBox
 *  │   ├─ Row 5: Semester Label | Semester ComboBox
 *  │   └─ Row 6: Gender Label | Gender RadioButtons (HBox)
 *  ├─ Separator
 *  └─ HBox (Buttons)
 *      ├─ Submit Button
 *      └─ Reset Button
 */
public class StudentRegistrationForm extends Application {

    private TextField rollNumberField;
    private TextField nameField;
    private TextField emailField;
    private TextField mobileField;
    private ComboBox<String> branchCombo;
    private ComboBox<Integer> semesterCombo;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;

    @Override
    public void start(Stage primaryStage) {
        
        // ═══════════════════════════════════════════════════════════
        // MAIN CONTAINER: VBox (Vertical layout)
        // ═══════════════════════════════════════════════════════════
        VBox mainContainer = new VBox(15);  // 15px spacing between sections
        mainContainer.setPadding(new Insets(20));
        mainContainer.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1;");

        
        // ═══════════════════════════════════════════════════════════
        // SECTION 1: TITLE
        // ═══════════════════════════════════════════════════════════
        Label titleLabel = new Label("Student Registration Form");
        titleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #0066cc;");
        mainContainer.getChildren().add(titleLabel);
        
        mainContainer.getChildren().add(new Separator());

        
        // ═══════════════════════════════════════════════════════════
        // SECTION 2: FORM FIELDS - GridPane (2 columns layout)
        // ═══════════════════════════════════════════════════════════
        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);  // Horizontal gap between columns
        formGrid.setVgap(15);  // Vertical gap between rows
        formGrid.setPadding(new Insets(10));
        formGrid.setStyle("-fx-border-color: #eeeeee; -fx-border-width: 1;");
        
        // ROW 0: Roll Number
        Label rollLabel = new Label("Roll Number:");
        rollLabel.setStyle("-fx-font-weight: bold;");
        rollNumberField = new TextField();
        rollNumberField.setPromptText("E.g., 001");
        rollNumberField.setPrefWidth(200);
        formGrid.add(rollLabel, 0, 0);
        formGrid.add(rollNumberField, 1, 0);
        
        // ROW 1: Name
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold;");
        nameField = new TextField();
        nameField.setPromptText("E.g., John Doe");
        nameField.setPrefWidth(200);
        formGrid.add(nameLabel, 0, 1);
        formGrid.add(nameField, 1, 1);
        
        // ROW 2: Email
        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-weight: bold;");
        emailField = new TextField();
        emailField.setPromptText("E.g., john@example.com");
        emailField.setPrefWidth(200);
        formGrid.add(emailLabel, 0, 2);
        formGrid.add(emailField, 1, 2);
        
        // ROW 3: Mobile
        Label mobileLabel = new Label("Mobile:");
        mobileLabel.setStyle("-fx-font-weight: bold;");
        mobileField = new TextField();
        mobileField.setPromptText("E.g., 9876543210");
        mobileField.setPrefWidth(200);
        formGrid.add(mobileLabel, 0, 3);
        formGrid.add(mobileField, 1, 3);
        
        // ROW 4: Branch (ComboBox)
        Label branchLabel = new Label("Course:");
        branchLabel.setStyle("-fx-font-weight: bold;");
        branchCombo = new ComboBox<>();
        branchCombo.getItems().addAll("BIT", "Bsc. CSIT", "BCA", "BICTE", "BBA");
        branchCombo.setPrefWidth(200);
        formGrid.add(branchLabel, 0, 4);
        formGrid.add(branchCombo, 1, 4);
        
        // ROW 5: Semester (ComboBox)
        Label semesterLabel = new Label("Semester:");
        semesterLabel.setStyle("-fx-font-weight: bold;");
        semesterCombo = new ComboBox<>();
        semesterCombo.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        semesterCombo.setPrefWidth(200);
        formGrid.add(semesterLabel, 0, 5);
        formGrid.add(semesterCombo, 1, 5);
        
        // ROW 6: Gender (RadioButtons in HBox)
        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-weight: bold;");
        
        HBox genderBox = new HBox(15);  // HBox for horizontal radio button layout
        ToggleGroup genderGroup = new ToggleGroup();
        
        maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        
        femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);
        
        genderBox.getChildren().addAll(maleRadio, femaleRadio);
        formGrid.add(genderLabel, 0, 6);
        formGrid.add(genderBox, 1, 6);
        
        mainContainer.getChildren().add(formGrid);
        
        mainContainer.getChildren().add(new Separator());

        
        // ═══════════════════════════════════════════════════════════
        // SECTION 3: BUTTONS - HBox (Horizontal layout)
        // ═══════════════════════════════════════════════════════════
        HBox buttonBox = new HBox(10);  // 10px spacing between buttons
        buttonBox.setPadding(new Insets(10));
        
        Button submitButton = new Button("Submit");
        submitButton.setPrefWidth(100);
        submitButton.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        submitButton.setStyle("-fx-font-size: 12; -fx-padding: 8; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        
        Button resetButton = new Button("Reset");
        resetButton.setPrefWidth(100);
        resetButton.setStyle("-fx-font-size: 12; -fx-padding: 8; -fx-background-color: #f44336; -fx-text-fill: white;");
        
        buttonBox.getChildren().addAll(submitButton, resetButton);
        mainContainer.getChildren().add(buttonBox);

        
        // ═══════════════════════════════════════════════════════════
        // CREATE SCENE AND STAGE
        // ═══════════════════════════════════════════════════════════
        Scene scene = new Scene(mainContainer, 600, 600);
        
        primaryStage.setTitle("Student Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
