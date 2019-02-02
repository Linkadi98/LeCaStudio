package UI.Admin;

import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateAdminController implements Initializable {
    public JFXTextField searchBox;
    JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
    public void searchOnAction(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [] suggestion = {"abc", "def", "Minh", "Phạm văn tiến", "Phạm ngọc minh", "Đặng thị thụy"};
        autoCompletePopup.getSuggestions().addAll(suggestion);
        autoCompletePopup.setSelectionHandler((event -> {
            searchBox.setText(event.getObject());
        }));
        searchBox.textProperty().addListener((e -> {
            autoCompletePopup.filter(item -> item.toLowerCase().contains(searchBox.getText().toLowerCase()));
            if(autoCompletePopup.getFilteredSuggestions().isEmpty()) {
                autoCompletePopup.hide();
            }
            else {
                autoCompletePopup.show(searchBox);
            }
        }));
    }
}
