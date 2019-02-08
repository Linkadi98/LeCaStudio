package UI.Admin;

import Connector.ConnectDB;
import Models.AdminModel;
import Objects.Admin;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminTableController implements Initializable {
    public JFXTreeTableView<Admin> adminTreeTable;
    private AdminModel adminModel;

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareAdminTreeTableView();
    }

    private void prepareAdminTreeTableView() {
        JFXTreeTableColumn<Admin, String> idAdmin = new JFXTreeTableColumn("ID Admin");
        idAdmin.setPrefWidth(100);

        idAdmin.setCellValueFactory(param -> param.getValue().getValue().idAdminProperty());

        JFXTreeTableColumn<Admin, String> loginName = new JFXTreeTableColumn("Login name");
        loginName.setPrefWidth(200);

        loginName.setCellValueFactory(param -> param.getValue().getValue().loginNameProperty());

        JFXTreeTableColumn<Admin, String> password = new JFXTreeTableColumn("Password");
        password.setPrefWidth(200);

        password.setCellValueFactory(param -> param.getValue().getValue().passwordProperty());

        JFXTreeTableColumn<Admin, String> fullName = new JFXTreeTableColumn("Full name");
        fullName.setPrefWidth(200);

        fullName.setCellValueFactory(param -> param.getValue().getValue().fullNameProperty());

        JFXTreeTableColumn<Admin, String> note = new JFXTreeTableColumn("Note");
        note.setPrefWidth(200);

        note.setCellValueFactory(param -> param.getValue().getValue().noteProperty());

        JFXTreeTableColumn<Admin, String> phoneNumber = new JFXTreeTableColumn("Phone Number");
        phoneNumber.setPrefWidth(200);

        phoneNumber.setCellValueFactory(param -> param.getValue().getValue().phoneNumberProperty());

        JFXTreeTableColumn<Admin, String> email = new JFXTreeTableColumn("Email");
        email.setPrefWidth(200);

        email.setCellValueFactory(param -> param.getValue().getValue().emailProperty());

        JFXTreeTableColumn<Admin, String> permission = new JFXTreeTableColumn("Permission");
        permission.setPrefWidth(200);

        permission.setCellValueFactory(param -> param.getValue().getValue().permissionProperty());

        ObservableList<Admin> admins = FXCollections.observableArrayList();
        addAdminsToTable(admins);

        TreeItem<Admin> treeItemRoot = new RecursiveTreeItem<>(admins, RecursiveTreeObject::getChildren);
        adminTreeTable.getColumns().setAll(idAdmin, loginName, password, fullName, note, email, permission);
        adminTreeTable.setRoot(treeItemRoot);
        adminTreeTable.setShowRoot(false);

        adminTreeTable.addEventHandler();
    }

    public void addAdminsToTable(ObservableList<Admin> admins) {
        ConnectDB connectDB = new ConnectDB();
        Connection connection = connectDB.getConnect();

        String sql = "SELECT t.* FROM datapa02.nguoidung t";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                admins.add(new Admin(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Unsucessful");
        }
    }
}
