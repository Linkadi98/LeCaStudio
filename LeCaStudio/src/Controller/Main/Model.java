package Controller.Main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private final StringProperty navigator = new SimpleStringProperty("Your position");

    public Model() {}

    public String getNavigator() {
        return navigator.get();
    }

    public StringProperty navigatorProperty() {
        return navigator;
    }

    public void setNavigator(String navigator) {
        navigatorProperty().set(navigator);
    }

}
