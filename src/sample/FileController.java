package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {

    public static List <Control> readFromFile(){
        List<Control> controls = new ArrayList <>();
        try {
            Scanner scanner = new Scanner(new File("data.csv"));
            while(scanner.hasNext()) {
                String[] record = scanner.nextLine().split(";");
                try {
                    ControlType controlType = ControlType.valueOf(record[0]);
                    controls.add(new Control(controlType, (record[1])));
                }
                catch (IllegalArgumentException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(), ButtonType.CLOSE);
                    alert.show();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return controls;
    }

}
