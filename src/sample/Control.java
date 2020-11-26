package sample;

public class Control {
    private ControlType controlType;
    private String description;

    public Control(ControlType controlType, String description) {
        this.controlType = controlType;
        this.description = description;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

