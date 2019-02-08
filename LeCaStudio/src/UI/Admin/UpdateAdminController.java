package UI.Admin;

import Models.AdminModel;
import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateAdminController implements Initializable {
    public JFXTextField searchBox;
    public JFXTextField id;
    public JFXTextField loginName;
    public JFXTextField password;
    public JFXTextField fullName;
    public JFXTextField note;
    public JFXTextField phoneNumber;
    public JFXTextField email;
    public JFXTextField permission;
    public JFXComboBox combobox;
    private AdminModel adminModel;

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
    public void searchOnAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [] comboBoxItems = {"Item1", "Item2"};
        combobox.getItems().addAll(comboBoxItems);
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

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void continueUpdateOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        getAdminModel().getStage().hide();
    }

    public void comboboxOnAction(ActionEvent actionEvent) {
    }

    public void searchOnKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            combobox.show();
        }
        else {
            combobox.hide();
        }
    }
}
