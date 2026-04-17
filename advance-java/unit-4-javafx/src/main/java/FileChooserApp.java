import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FILE CHOOSER APPLICATION
 * 
 * Features:
 * - MenuBar with "Open File" option
 * - FileChooser to select a file
 * - Display selected file path in TextField
 * - Tooltip on menu items
 */
public class FileChooserApp extends Application {

    private TextField filePathField;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        
        // ═══════════════════════════════════════════════════════════
        // CREATE MENU BAR
        // ═══════════════════════════════════════════════════════════
        MenuBar menuBar = createMenuBar();
        root.getChildren().add(menuBar);
        
        root.getChildren().add(new Separator());
        
        // ═══════════════════════════════════════════════════════════
        // TOOLBAR WITH BUTTON (WITH TOOLTIP)
        // ═══════════════════════════════════════════════════════════
        HBox toolbar = new HBox(10);
        toolbar.setPadding(new Insets(10));
        
        Button openButton = new Button("📁 Open File");
        openButton.setStyle("-fx-font-size: 11; -fx-padding: 8;");
        openButton.setOnAction(e -> handleOpenFile());
        
        // Add Tooltip to Button
        Tooltip buttonTooltip = new Tooltip("Click to select a file from your computer");
        buttonTooltip.setStyle("-fx-font-size: 11;");
        Tooltip.install(openButton, buttonTooltip);
        
        toolbar.getChildren().add(openButton);
        root.getChildren().add(toolbar);
        
        root.getChildren().add(new Separator());
        Label fileLabel = new Label("Selected File Path:");
        fileLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12;");
        
        filePathField = new TextField();
        filePathField.setEditable(false);
        filePathField.setPromptText("No file selected yet...");
        filePathField.setPrefHeight(40);
        filePathField.setStyle("-fx-font-size: 11;");
        
        root.getChildren().addAll(fileLabel, filePathField);
        
        // ═══════════════════════════════════════════════════════════
        // CREATE SCENE AND STAGE
        // ═══════════════════════════════════════════════════════════
        Scene scene = new Scene(root, 600, 250);
        
        primaryStage.setTitle("File Chooser Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ═══════════════════════════════════════════════════════════
    // CREATE MENU BAR WITH FILE MENU
    // ═══════════════════════════════════════════════════════════
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        
        // Create File Menu
        Menu fileMenu = new Menu("File");
        
        // Create Open File MenuItem
        MenuItem openFileItem = new MenuItem("Open File");
        openFileItem.setOnAction(e -> handleOpenFile());
        
        // Add separator
        SeparatorMenuItem separator = new SeparatorMenuItem();
        
        // Create Exit MenuItem
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> primaryStage.close());
        
        // Add items to File menu
        fileMenu.getItems().addAll(openFileItem, separator, exitItem);
        
        // Add File menu to MenuBar
        menuBar.getMenus().add(fileMenu);
        
        return menuBar;
    }

    // ═══════════════════════════════════════════════════════════
    // HANDLE OPEN FILE
    // ═══════════════════════════════════════════════════════════
    private void handleOpenFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.setInitialDirectory(new java.io.File(System.getProperty("user.home")));
        
        // Add file filters
        FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
        FileChooser.ExtensionFilter textFilesFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter javaFilesFilter = new FileChooser.ExtensionFilter("Java Files (*.java)", "*.java");
        
        fileChooser.getExtensionFilters().addAll(allFilesFilter, textFilesFilter, javaFilesFilter);
        fileChooser.setSelectedExtensionFilter(allFilesFilter);
        
        // Show file chooser
        java.io.File selectedFile = fileChooser.showOpenDialog(primaryStage);
        
        if (selectedFile != null) {
            // Display file path
            filePathField.setText(selectedFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
