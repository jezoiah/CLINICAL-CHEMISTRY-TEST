import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Patient;
import model.TestResult;
import model.tests.glucose.*;
import model.tests.lipid.*;
import model.tests.kidney.*;
import model.tests.liver.*;
import model.tests.electrolyte.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClinicalChemistryApp extends Application {
    
    // Using HashMap to store checkboxes and text fields I learned this in class
    private TextField nameField;
    private TextField birthDateField;
    private TextField sampleIdField;
    private ComboBox<String> sexComboBox;
    private Map<String, CheckBox> testCheckBoxes = new HashMap<>();
    private Map<String, TextField> testValueFields = new HashMap<>();
    private TableView<TestResult> resultsTable;
    private TextArea patientInfoArea;
    private Patient currentPatient;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Clinical Chemistry Diagnostic System");
        
        // Main layout
        HBox mainLayout = new HBox(10);
        mainLayout.setPadding(new Insets(10));
        
        // Left side - input forms
        VBox leftSide = new VBox(10);
        leftSide.setPrefWidth(450);
        
        // Add sections to left side
        leftSide.getChildren().add(createHeader());
        leftSide.getChildren().add(createPatientInfoSection());
        leftSide.getChildren().add(createTestSelectionSection());
        leftSide.getChildren().add(createButtonSection());
        
        // Right side - results
        VBox rightSide = new VBox(10);
        rightSide.setPrefWidth(550);
        
        // Add sections to right side
        rightSide.getChildren().add(createPatientDisplaySection());
        rightSide.getChildren().add(createResultsSection());
        
        mainLayout.getChildren().add(leftSide);
        mainLayout.getChildren().add(rightSide);
        
        Scene scene = new Scene(mainLayout, 1020, 700);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private VBox createHeader() {
        VBox header = new VBox(5);
        header.setAlignment(Pos.CENTER);
        header.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
        
        Label title = new Label("NUCOMP DIAGNOSTIC CORPORATION");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        Label subtitle = new Label("Clinical Chemistry Laboratory");
        
        header.getChildren().add(title);
        header.getChildren().add(subtitle);
        
        return header;
    }
    
    private VBox createPatientInfoSection() {
        VBox section = new VBox(8);
        section.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
        
        Label sectionLabel = new Label("PATIENT INFORMATION");
        sectionLabel.setStyle("-fx-font-weight: bold;");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        
        // Name
        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        nameField.setPrefWidth(150);
        
        // Birth Date
        Label birthLabel = new Label("Birth Date:");
        birthDateField = new TextField();
        birthDateField.setPromptText("MM/DD/YYYY");
        birthDateField.setPrefWidth(100);
        
        // Sex
        Label sexLabel = new Label("Sex:");
        sexComboBox = new ComboBox<>();
        sexComboBox.getItems().add("M");
        sexComboBox.getItems().add("F");
        sexComboBox.setValue("M");
        sexComboBox.setPrefWidth(60);
        
        // ID
        Label idLabel = new Label("ID:");
        sampleIdField = new TextField();
        sampleIdField.setPrefWidth(80);
        
        // Add to grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(sexLabel, 2, 0);
        grid.add(sexComboBox, 3, 0);
        
        grid.add(birthLabel, 0, 1);
        grid.add(birthDateField, 1, 1);
        grid.add(idLabel, 2, 1);
        grid.add(sampleIdField, 3, 1);
        
        section.getChildren().add(sectionLabel);
        section.getChildren().add(grid);
        
        return section;
    }
    
    private VBox createTestSelectionSection() {
        VBox section = new VBox(8);
        section.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
        
        Label sectionLabel = new Label("SELECT TESTS AND ENTER VALUES");
        sectionLabel.setStyle("-fx-font-weight: bold;");
        
        GridPane testsGrid = new GridPane();
        testsGrid.setHgap(15);
        testsGrid.setVgap(8);
        
        // Left column tests
        String[] leftTests = {
            "FBS", "RBS", "Total Cholesterol", "HDL", 
            "LDL", "Triglycerides", "Creatinine", "Uric Acid"
        };
        
        // Right column tests
        String[] rightTests = {
            "BUN", "AST/SGOT", "ALT/SGPT", "Sodium", 
            "Potassium", "Chloride", "TCalcium", "ICalcium"
        };
        
        // Add left column
        for (int i = 0; i < leftTests.length; i++) {
            CheckBox checkBox = new CheckBox(leftTests[i]);
            testCheckBoxes.put(leftTests[i], checkBox);
            
            TextField valueField = new TextField();
            valueField.setPromptText("Value");
            valueField.setPrefWidth(80);
            valueField.setDisable(true);
            testValueFields.put(leftTests[i], valueField);
            
            // Enable text field when checkbox is selected
            final TextField field = valueField;
            checkBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (checkBox.isSelected()) {
                        field.setDisable(false);
                    } else {
                        field.setDisable(true);
                    }
                }
            });
            
            testsGrid.add(checkBox, 0, i);
            testsGrid.add(valueField, 1, i);
        }
        
        // Add right column
        for (int i = 0; i < rightTests.length; i++) {
            CheckBox checkBox = new CheckBox(rightTests[i]);
            testCheckBoxes.put(rightTests[i], checkBox);
            
            TextField valueField = new TextField();
            valueField.setPromptText("Value");
            valueField.setPrefWidth(80);
            valueField.setDisable(true);
            testValueFields.put(rightTests[i], valueField);
            
            // Enable text field when checkbox is selected
            final TextField field = valueField;
            checkBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (checkBox.isSelected()) {
                        field.setDisable(false);
                    } else {
                        field.setDisable(true);
                    }
                }
            });
            
            testsGrid.add(checkBox, 2, i);
            testsGrid.add(valueField, 3, i);
        }
        
        section.getChildren().add(sectionLabel);
        section.getChildren().add(testsGrid);
        
        return section;
    }
    
    private HBox createButtonSection() {
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));
        
        Button generateButton = new Button("Generate Results");
        generateButton.setPrefWidth(150);
        generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generateResults();
            }
        });
        
        Button clearButton = new Button("Clear All");
        clearButton.setPrefWidth(150);
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearAll();
            }
        });
        
        buttonBox.getChildren().add(generateButton);
        buttonBox.getChildren().add(clearButton);
        
        return buttonBox;
    }
    
    private VBox createPatientDisplaySection() {
        VBox section = new VBox(8);
        section.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
        
        Label sectionLabel = new Label("PATIENT INFORMATION");
        sectionLabel.setStyle("-fx-font-weight: bold;");
        
        patientInfoArea = new TextArea();
        patientInfoArea.setPrefHeight(80);
        patientInfoArea.setEditable(false);
        patientInfoArea.setText("No patient data yet. Fill the form and generate results.");
        
        section.getChildren().add(sectionLabel);
        section.getChildren().add(patientInfoArea);
        
        return section;
    }
    
    private VBox createResultsSection() {
        VBox section = new VBox(8);
        section.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");
        
        Label sectionLabel = new Label("TEST RESULTS");
        sectionLabel.setStyle("-fx-font-weight: bold;");
        
        // Create simple table
        resultsTable = new TableView<>();
        resultsTable.setPrefHeight(550);
        resultsTable.setSortPolicy(null); // Disable sorting - keep it simple
        
        // Test name column
        TableColumn<TestResult, String> testCol = new TableColumn<>("Test Name");
        testCol.setCellValueFactory(new PropertyValueFactory<>("testName"));
        testCol.setPrefWidth(100);
        testCol.setSortable(false);
        
        // Result value column
        TableColumn<TestResult, Double> valueCol = new TableColumn<>("Result");
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        valueCol.setPrefWidth(70);
        valueCol.setSortable(false);
        
        // Unit column
        TableColumn<TestResult, String> unitCol = new TableColumn<>("Unit");
        unitCol.setCellValueFactory(new PropertyValueFactory<>("unit"));
        unitCol.setPrefWidth(70);
        unitCol.setSortable(false);
        
        // Reference range column
        TableColumn<TestResult, String> rangeCol = new TableColumn<>("Reference Range");
        rangeCol.setCellValueFactory(new PropertyValueFactory<>("referenceRange"));
        rangeCol.setPrefWidth(150);
        rangeCol.setSortable(false);
        
        // Interpretation column
        TableColumn<TestResult, String> interpCol = new TableColumn<>("Interpretation");
        interpCol.setCellValueFactory(new PropertyValueFactory<>("interpretation"));
        interpCol.setPrefWidth(110);
        interpCol.setSortable(false);
        
        // Add columns to table
        resultsTable.getColumns().add(testCol);
        resultsTable.getColumns().add(valueCol);
        resultsTable.getColumns().add(unitCol);
        resultsTable.getColumns().add(rangeCol);
        resultsTable.getColumns().add(interpCol);
        
        section.getChildren().add(sectionLabel);
        section.getChildren().add(resultsTable);
        
        return section;
    }
    
    private void generateResults() {
        // Check if name is entered
        if (nameField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter patient name");
            alert.showAndWait();
            return;
        }
        
        // Create patient object
        currentPatient = new Patient(
            nameField.getText(),
            birthDateField.getText(),
            sexComboBox.getValue(),
            sampleIdField.getText(),
            ""
        );
        
        // Display patient information
        String patientInfo = "";
        patientInfo = patientInfo + "Name: " + currentPatient.getName() + "\n";
        patientInfo = patientInfo + "Birth Date: " + currentPatient.getBirthDate() + "\n";
        patientInfo = patientInfo + "Sex: " + currentPatient.getSex() + "\n";
        patientInfo = patientInfo + "ID: " + currentPatient.getSampleId();
        patientInfoArea.setText(patientInfo);
        
        // Process selected tests
        List<TestResult> results = new ArrayList<>();
        String sex = currentPatient.getSex();
        
        // Go through all checkboxes
        for (String testName : testCheckBoxes.keySet()) {
            CheckBox checkBox = testCheckBoxes.get(testName);
            
            if (checkBox.isSelected()) {
                TextField valueField = testValueFields.get(testName);
                
                try {
                    double value = Double.parseDouble(valueField.getText());
                    TestResult result = evaluateTest(testName, value, sex);
                    
                    if (result != null) {
                        results.add(result);
                    }
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid value for " + testName);
                    alert.showAndWait();
                    return;
                }
            }
        }
        
        // Check if at least one test was selected
        if (results.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select at least one test");
            alert.showAndWait();
            return;
        }
        
        // Display results in table
        resultsTable.getItems().clear();
        for (TestResult result : results) {
            resultsTable.getItems().add(result);
        }

        // Show success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Test results generated successfully!\n\n" +
                "Patient: " + currentPatient.getName() + " (" + currentPatient.getSex() + ")\n" +
                "Tests evaluated: " + results.size());
        alert.showAndWait();
    }

    private TestResult evaluateTest(String testName, double value, String sex) {
        // Create test objects and evaluate
        if (testName.equals("FBS")) {
            FastingBloodSugar test = new FastingBloodSugar();
            return test.evaluate(value, sex);
        } else if (testName.equals("RBS")) {
            RandomBloodSugar test = new RandomBloodSugar();
            return test.evaluate(value, sex);
        } else if (testName.equals("Total Cholesterol")) {
            TotalCholesterol test = new TotalCholesterol();
            return test.evaluate(value, sex);
        } else if (testName.equals("HDL")) {
            HDLCholesterol test = new HDLCholesterol();
            return test.evaluate(value, sex);
        } else if (testName.equals("LDL")) {
            LDLCholesterol test = new LDLCholesterol();
            return test.evaluate(value, sex);
        } else if (testName.equals("Triglycerides")) {
            Triglycerides test = new Triglycerides();
            return test.evaluate(value, sex);
        } else if (testName.equals("Creatinine")) {
            Creatinine test = new Creatinine();
            return test.evaluate(value, sex);
        } else if (testName.equals("Uric Acid")) {
            UricAcid test = new UricAcid();
            return test.evaluate(value, sex);
        } else if (testName.equals("BUN")) {
            BloodUreaNitrogen test = new BloodUreaNitrogen();
            return test.evaluate(value, sex);
        } else if (testName.equals("AST/SGOT")) {
            AST test = new AST();
            return test.evaluate(value, sex);
        } else if (testName.equals("ALT/SGPT")) {
            ALT test = new ALT();
            return test.evaluate(value, sex);
        } else if (testName.equals("Sodium")) {
            Sodium test = new Sodium();
            return test.evaluate(value, sex);
        } else if (testName.equals("Potassium")) {
            Potassium test = new Potassium();
            return test.evaluate(value, sex);
        } else if (testName.equals("Chloride")) {
            Chloride test = new Chloride();
            return test.evaluate(value, sex);
        } else if (testName.equals("TCalcium")) {
            TotalCalcium test = new TotalCalcium();
            return test.evaluate(value, sex);
        } else if (testName.equals("ICalcium")) {
            IonizedCalcium test = new IonizedCalcium();
            return test.evaluate(value, sex);
        } else {
            return null;
        }
    }
    
    private void clearAll() {
        // Clear patient info fields
        nameField.clear();
        birthDateField.clear();
        sampleIdField.clear();
        sexComboBox.setValue("M");
        
        // Clear all checkboxes and text fields
        for (String testName : testCheckBoxes.keySet()) {
            CheckBox cb = testCheckBoxes.get(testName);
            cb.setSelected(false);
            
            TextField tf = testValueFields.get(testName);
            tf.clear();
            tf.setDisable(true);
        }
        
        // Clear results
        resultsTable.getItems().clear();
        patientInfoArea.setText("No patient data yet. Fill the form and generate results.");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}