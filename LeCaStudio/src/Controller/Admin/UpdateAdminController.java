package Controller.Admin;

import Connector.ConnectDB;
import Models.AdminModel;
import com.jfoenix.controls.*;

import java.sql.*;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    public JFXSpinner spinner;
    private AdminModel adminModel;
    public String keyString = null;

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
        String [] suggestion = {"abc", "xyz"};
        combobox.getItems().add("id");
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
        spinner.setVisible(false);



    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void continueUpdateOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        getAdminModel().getStage().hide();
    }

    public void comboboxOnAction(ActionEvent actionEvent) {
        keyString = combobox.getSelectionModel().getSelectedItem().toString();
        combobox.setOnKeyPressed((e -> {
            if(e.getCode() == KeyCode.ENTER) {
                searchTask(keyString);
            }
            else if(keyString == null) {

            }
        }));
    }

    public void searchOnKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER && combobox.getSelectionModel().isEmpty()) {
            combobox.show();
        }
        else if(keyEvent.getCode() == KeyCode.ENTER ){
            searchTask(keyString);
        }
    }

    private void searchBy(String chosen) {
        System.out.println("dang tim kiem");
        ConnectDB connectDB = new ConnectDB();
        Connection connection = connectDB.getConnect();
        String sql = "select * from datapa02.nguoidung where " + chosen + " = '" + searchBox.getText() + "'";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                id.setText(rs.getString(1));
                loginName.setText(rs.getString(2));
                password.setText(rs.getString(3));
                fullName.setText(rs.getString(4));
                note.setText(rs.getString(5));
                phoneNumber.setText(rs.getString(6));
                email.setText(rs.getString(7));
                permission.setText(rs.getString(8));
            }
        } catch (SQLException e) {
            System.out.println("Can not find infor");
        }
    }

    private void searchTask (String search) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                spinner.setVisible(true);
                searchBy(search);
                return null;
            }
        };
        new Thread(task).start();
        task.setOnSucceeded((e -> {
            spinner.setVisible(false);
        }));
        task.setOnFailed((e -> {
            spinner.setVisible(false);
            System.out.println("Thất bại");
        }));
        task.setOnRunning((e -> {
            System.out.println("Đang kết nối với server");
        }));
    }
}
