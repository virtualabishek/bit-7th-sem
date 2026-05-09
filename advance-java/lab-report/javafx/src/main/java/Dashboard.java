    import javafx.application.Application;
    import javafx.geometry.*;
    import javafx.scene.*;
    import javafx.scene.control.*;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
    import javafx.scene.text.*;
    import javafx.stage.Stage;

    public class Dashboard extends Application {

        @Override
        public void start(Stage stage) {

            Label appTitle = new Label("📚 Student Dashboard");
            appTitle.setTextFill(Color.WHITE);

            Label userInfo = new Label("Logged in: Admin");
            userInfo.setTextFill(Color.LIGHTGRAY);

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            HBox navBar = new HBox(15, appTitle, spacer, userInfo);
            navBar.setPadding(new Insets(15, 20, 15, 20));
            navBar.setAlignment(Pos.CENTER_LEFT);
            navBar.setStyle("-fx-background-color: #1a237e;"); 

            VBox sidebar = new VBox(8);
            sidebar.setPadding(new Insets(20, 10, 20, 10));
            sidebar.setPrefWidth(160);
            sidebar.setStyle("-fx-background-color: #283593;");

            String[] menuItems = {"Home", "Students", "Courses", "Reports", "Settings"};
            for (String item : menuItems) {
                Button menuBtn = new Button(item);
                menuBtn.setPrefWidth(140);
                menuBtn.setAlignment(Pos.CENTER_LEFT);
                menuBtn.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 8 12 8 12;"
                );
                menuBtn.setOnMouseEntered(e ->
                    menuBtn.setStyle(
                        "-fx-background-color: #3949ab;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 8 12 8 12;"
                    )
                );
                menuBtn.setOnMouseExited(e ->
                    menuBtn.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 8 12 8 12;"
                    )
                );
                sidebar.getChildren().add(menuBtn);
            }
            GridPane statsGrid = new GridPane();
            statsGrid.setHgap(15); 
            statsGrid.setVgap(15);
            statsGrid.setPadding(new Insets(0, 0, 20, 0));
            statsGrid.add(makeCard("👨Total Students", "400", "#1565c0"), 0, 0);
            statsGrid.add(makeCard("Available Courses",   "4",    "#2e7d32"), 1, 0);
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            statsGrid.getColumnConstraints().addAll(col, col);
            Label tableTitle = new Label("Recent Students");

            GridPane table = new GridPane();
            table.setHgap(0);
            table.setVgap(0);
            table.setStyle("-fx-border-color: #ddd; -fx-border-width: 1;");
            String[] headers = {"ID", "Name", "Course", "Marks", "Status"};
            for (int i = 0; i < headers.length; i++) {
                Label h = new Label(headers[i]);
                h.setTextFill(Color.WHITE);
                h.setPadding(new Insets(8, 15, 8, 15));
                h.setMaxWidth(Double.MAX_VALUE);
                h.setStyle("-fx-background-color: #3949ab;");
                table.add(h, i, 0);
            }
            String[][] data = {
                {"1", "Abishek Neupane",  "BIT",  "88", "✔ Pass"},
                {"2", "Robin Thapa",     "BIT",  "74", "✔ Pass"},
                {"3", "Aashik Pandey",     "BSc CSIT",  "91", "✔ Pass"},
                {"4", "Hari Thapa",      "BCA",  "45", "✘ Fail"},
                {"5", "Ram Magar",     "BIT",  "67", "✔ Pass"},
            };

            for (int row = 0; row < data.length; row++) {
                String rowBg = (row % 2 == 0) ? "#f9f9f9" : "#ffffff";
                for (int col2 = 0; col2 < data[row].length; col2++) {
                    Label cell = new Label(data[row][col2]);
                    cell.setPadding(new Insets(8, 15, 8, 15));
                    cell.setMaxWidth(Double.MAX_VALUE);
                    cell.setStyle(
                        "-fx-background-color: " + rowBg + ";" +
                        "-fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;"
                    );
                    // Color the status column
                    if (col2 == 4) {
                        cell.setTextFill(data[row][col2].contains("Pass") ? Color.GREEN : Color.RED);
                    }
                    table.add(cell, col2, row + 1);
                }
            }

            // ════════════════════════════════════════
            //  MAIN CONTENT  (VBox — stats + table)
            // ════════════════════════════════════════
            Label welcomeLabel = new Label("Welcome back, Admin 👋");
            welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

            VBox mainContent = new VBox(18);
            mainContent.setPadding(new Insets(25));
            mainContent.setStyle("-fx-background-color: #f0f2f5;");
            mainContent.getChildren().addAll(
                welcomeLabel,
                statsGrid,
                tableTitle,
                table
            );
            BorderPane root = new BorderPane();
            root.setTop(navBar);
            root.setLeft(sidebar);
            root.setCenter(mainContent);
            Scene scene = new Scene(root, 820, 560);
            stage.setTitle("Q23 - Student Dashboard");
            stage.setScene(scene);
            stage.show();
        }
        private VBox makeCard(String title, String value, String color) {
            Label valueLabel = new Label(value);
            valueLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
            valueLabel.setTextFill(Color.WHITE);

            Label titleLabel = new Label(title);
            titleLabel.setFont(Font.font("Arial", 13));
            titleLabel.setTextFill(Color.rgb(255, 255, 255, 0.85));

            VBox card = new VBox(6, valueLabel, titleLabel);
            card.setPadding(new Insets(20));
            card.setPrefSize(180, 100);
            card.setStyle(
                "-fx-background-color: " + color + ";" +
                "-fx-background-radius: 8;"
            );
            return card;
        }

        public static void main(String[] args) {
            launch(args);
        }
    }