package sample;

public enum ControlType {
    BUTTON("enables a JavaFX application to have some action executed when the application user clicks the button"),
    TEXT_FIELD("allows the user to enter a line of unformatted text"),
    COMBO_BOX("enables users to choose one of several options"),
    DATE_PICKER("allows to select the date from the popup calendar or type the text manually in the text field of date-picker"),
    TABLE_VIEW(" is designed to visualize an unlimited number of rows of data, broken out into columns");

    final String description;

    ControlType(String description) {
        this.description = description;
    }
}
