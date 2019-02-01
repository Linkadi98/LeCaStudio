package UI.Admin;

import Objects.Admin;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public JFXTreeTableView<Admin> adminTreeTable;


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
        admins.add(new Admin("1", "LeCanh", "1234", "Lê Thanh Cảnh", "abc", "123456789", "lecanh", "1"));
        admins.add(new Admin("1", "LeCanh", "1234", "Lê Thanh Cảnh", "abc", "123456789", "lecanh", "1"));

        TreeItem<Admin> treeItemRoot = new RecursiveTreeItem<>(admins, RecursiveTreeObject::getChildren);
        adminTreeTable.getColumns().setAll(idAdmin, loginName, password, fullName, note, email, permission);
        adminTreeTable.setRoot(treeItemRoot);
        adminTreeTable.setShowRoot(false);

    }
}
