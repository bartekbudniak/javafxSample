package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Stage stage = new Stage();
    List<Control> controls = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

        controls.add(new Control(ControlType.BUTTON, "enables a JavaFX application to have some action executed when the application user clicks the button"));
        controls.add(new Control(ControlType.TEXT_FIELD, "allows the user to enter a line of unformatted text"));
        controls.add(new Control(ControlType.COMBO_BOX, "enables users to choose one of several options"));
        controls.add(new Control(ControlType.DATE_PICKER, "allows to select the date from the popup calendar or type the text manually in the text field of date-picker"));
        controls.add(new Control(ControlType.TABLE_VIEW, " is designed to visualize an unlimited number of rows of data, broken out into columns"));

        GridPane root = new GridPane();
        Scene scene = new Scene(root,800,800);

        stage.setTitle("Controls");
        stage.setScene(scene);
        stage.show();

        controlsLayout(controls);
    }

    public void controlsLayout(List<Control> controls){
        TableView<Control> tableViewControls = new TableView<>();

        TableColumn<Control, ControlType> tableColumnType = new TableColumn<>("Control type");
        tableColumnType.setCellValueFactory(new PropertyValueFactory<>("controlType"));
        tableColumnType.setMinWidth(100);

        TableColumn<Control, String> tableColumnDescription = new TableColumn<>("Description");
        tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableColumnDescription.setMinWidth(400);

        tableViewControls.getColumns().addAll(tableColumnType, tableColumnDescription);
        tableViewControls.getItems().addAll(controls);

        TextField textFieldSearch = new TextField();
        textFieldSearch.setTooltip(new Tooltip("type for search and press enter"));
        textFieldSearch.setPromptText("\uD83D\uDD0D search");
        textFieldSearch.setOnAction(event -> {
            tableViewControls.getItems().clear();
            if (textFieldSearch.getText() == null || textFieldSearch.getText().equals("")){
                tableViewControls.getItems().addAll(controls);
            }
            else {
                tableViewControls.getItems().addAll(Controls.filtered(controls, textFieldSearch.getText()));
            }
        });

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(50);
        root.setHgap(50);
        root.add(textFieldSearch, 0,0);
        root.add(tableViewControls,0,1);

        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
