package sample;

import java.util.ArrayList;
import java.util.List;

public class Controls {

    public static List<Control> filtered(List<Control> controls, String search){
        List<Control> filtered = new ArrayList<>();

        for (int i = 0; i < controls.size(); i++) {
            if(controls.get(i).getControlType().toString().toLowerCase().contains(search.toLowerCase())){
                filtered.add(controls.get(i));
            }
        }
        return filtered;
    }

    public static List<Control> filtered(List<Control> controls, ControlType search) {
        List<Control> filtered = new ArrayList<>();

        for (int i = 0; i < controls.size(); i++) {
            if (controls.get(i).getControlType() == search) {
                filtered.add(controls.get(i));
            }
        }
        return filtered;
    }
}
