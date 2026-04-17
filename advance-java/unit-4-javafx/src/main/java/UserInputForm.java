import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * SIMPLE USER INPUT FORM
 * 
 * Takes input:
 * - Name (TextField)
 * - Gender (RadioButton)
 * - Hobbies (CheckBox)
 * 
 * Displays result when Button is clicked
 */
public class UserInputForm extends Application {

    private TextField nameField;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;
    private CheckBox codingCheckBox;
    private CheckBox designingCheckBox;
    private CheckBox fineTuningCheckBox;
    private CheckBox playingcsCheckBox;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1;");
        
        // Title
        Label titleLabel = new Label("User Input Form");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        root.getChildren().add(titleLabel);
        
        root.getChildren().add(new Separator());
        
        // ═══════════════════════════════════════════════════════════
        // NAME INPUT
        // ═══════════════════════════════════════════════════════════
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold;");
        nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setPrefWidth(250);
        
        root.getChildren().addAll(nameLabel, nameField);
        
        // ═══════════════════════════════════════════════════════════
        // GENDER SELECTION (RadioButton)
        // ═══════════════════════════════════════════════════════════
        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-weight: bold;");
        
        ToggleGroup genderGroup = new ToggleGroup();
        
        maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        
        femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);
        
        VBox genderBox = new VBox(8);
        genderBox.getChildren().addAll(maleRadio, femaleRadio);
        
        root.getChildren().addAll(genderLabel, genderBox);
        
        // ═══════════════════════════════════════════════════════════
        // HOBBIES SELECTION (CheckBox)
        // ═══════════════════════════════════════════════════════════
        Label hobbiesLabel = new Label("Hobbies:");
        hobbiesLabel.setStyle("-fx-font-weight: bold;");
        
        codingCheckBox = new CheckBox("Coding");
        designingCheckBox = new CheckBox("Designing");
        fineTuningCheckBox = new CheckBox("Fine Tuning");
        playingcsCheckBox = new CheckBox("Playing with cs");
        
        VBox hobbiesBox = new VBox(8);
        hobbiesBox.getChildren().addAll(codingCheckBox, designingCheckBox, fineTuningCheckBox, playingcsCheckBox);
        
        root.getChildren().addAll(hobbiesLabel, hobbiesBox);
        
        root.getChildren().add(new Separator());
        
        // ═══════════════════════════════════════════════════════════
        // SUBMIT BUTTON
        // ═══════════════════════════════════════════════════════════
        Button submitButton = new Button("Submit");
        submitButton.setPrefWidth(100);
        submitButton.setStyle("-fx-font-size: 12; -fx-padding: 8; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        submitButton.setOnAction(e -> handleSubmit());
        
        root.getChildren().add(submitButton);
        
        // ═══════════════════════════════════════════════════════════
        // RESULT DISPLAY
        // ═══════════════════════════════════════════════════════════
        resultLabel = new Label("Click Submit to see the result...");
        resultLabel.setStyle("-fx-font-size: 12; -fx-text-fill: blue;");
        resultLabel.setWrapText(true);
        
        root.getChildren().add(resultLabel);
        
        // ═══════════════════════════════════════════════════════════
        // CREATE SCENE AND STAGE
        // ═══════════════════════════════════════════════════════════
        Scene scene = new Scene(root, 400, 500);
        
        primaryStage.setTitle("User Input Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ═══════════════════════════════════════════════════════════
    // HANDLE SUBMIT BUTTON
    // ═══════════════════════════════════════════════════════════
    private void handleSubmit() {
        String name = nameField.getText();
        
        // Get selected gender
        String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "Not selected");
        
        // Get selected hobbies
        StringBuilder hobbies = new StringBuilder();
        if (codingCheckBox.isSelected()) hobbies.append("Coding, ");
        if (designingCheckBox.isSelected()) hobbies.append("Designing, ");
        if (fineTuningCheckBox.isSelected()) hobbies.append("Fine Tuning, ");
        if (playingcsCheckBox.isSelected()) hobbies.append("Playing with cs, ");
        
        // Remove trailing comma and space
        String hobbiesText = hobbies.length() > 0 ? hobbies.substring(0, hobbies.length() - 2) : "No hobbies selected";
        
        // Validation
        if (name.isEmpty()) {
            resultLabel.setText("⚠️ Please enter your name!");
            resultLabel.setStyle("-fx-font-size: 12; -fx-text-fill: red;");
            return;
        }
        
        // Display result
        String result =
                       "Name: " + name + "\n" +
                       "Gender: " + gender + "\n" +
                       "Hobbies: " + hobbiesText + "\n\n";
        
        resultLabel.setText(result);
        resultLabel.setStyle("-fx-font-size: 12; -fx-text-fill: green;");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
