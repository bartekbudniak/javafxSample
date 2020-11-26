package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Stage stage = new Stage();
    List<Control> controls = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();

        controls.add(new Control(ControlType.BUTTON, "sample"));

        Scene scene = new Scene(root,800,800);

        stage.setScene(scene);
        stage.show();

        controlsLayout(controls);
    }

    public void controlsLayout(List<Control> controls){
        GridPane root = new GridPane();
        stage.setTitle("Controls");
        root.setAlignment(Pos.CENTER);
        root.setVgap(50);
        root.setHgap(50);


        TableView<Control> tableViewControls = new TableView<>();

        TableColumn<Control, ControlType> tableColumnType = new TableColumn<>("Control type");
        tableColumnType.setCellValueFactory(new PropertyValueFactory<>("controlType"));
        tableColumnType.setMinWidth(100);

        TableColumn<Control, ControlType> tableColumnDescription = new TableColumn<>("Description");
        tableColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableColumnDescription.setMinWidth(100);

        tableViewControls.getColumns().addAll(tableColumnType, tableColumnDescription);
        root.add(tableViewControls,0,1);

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
        root.add(textFieldSearch, 0,0);

        stage.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
