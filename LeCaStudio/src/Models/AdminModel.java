package Models;

import Connector.ConnectDB;
import Objects.Admin;
import UI.Admin.AddingAdminController;
import UI.Admin.AdminTableController;
import UI.Main.MainAppController;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminModel extends TableModel {
    private JFXTreeTableView<Admin> adminTreeTableView;
    private StackPane stackPaneCenter;
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public StackPane getStackPaneCenter() {
        return stackPaneCenter;
    }

    public void setStackPaneCenter(StackPane stackPaneCenter) {
        this.stackPaneCenter = stackPaneCenter;
    }

    public JFXTreeTableView<Admin> getTreeTableView() {
        return adminTreeTableView;
    }

    public void setTreeTableView(JFXTreeTableView<Admin> treeTableView) {
        this.adminTreeTableView = treeTableView;
    }

    public void reloadTable () {
        adminTreeTableView.setRoot(null);
        loadDataFromServer();
    }

    public void prepareAdminTreeTableView() {
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

        adminTreeTableView.getColumns().setAll(idAdmin, loginName, password, fullName, note, email, permission);

    }

    public void loadDataFromServer() {
        TreeItem<Admin> treeItemRoot = new RecursiveTreeItem<>(addAdminsToTable(), RecursiveTreeObject::getChildren);
        adminTreeTableView.setRoot(treeItemRoot);
        adminTreeTableView.setShowRoot(false);
    }
    public ObservableList<Admin> addAdminsToTable() {
        ObservableList<Admin> admins = FXCollections.observableArrayList();
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
        return admins;
    }





}
