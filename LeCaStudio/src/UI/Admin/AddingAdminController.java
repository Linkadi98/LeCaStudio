package UI.Admin;

import Connector.ConnectDB;
import Objects.Admin;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddingAdminController implements Initializable {
    public JFXTextField id;
    public JFXTextField loginName;
    public JFXTextField password;
    public JFXTextField fullName;
    public JFXTextField note;
    public JFXTextField phoneNumber;
    public JFXTextField email;
    public JFXTextField permision;
    public Connection connection;

    public JFXTreeTableView<Admin> tableView;

    public JFXTreeTableView getTableView() {
        return tableView;
    }

    public void setTableView(JFXTreeTableView<Admin> tableView) {
        this.tableView = tableView;
    }

    public JFXTextField getId() {
        return id;
    }

    public void setId(JFXTextField id) {
        this.id = id;
    }

    public JFXTextField getLoginName() {
        return loginName;
    }

    public void setLoginName(JFXTextField loginName) {
        this.loginName = loginName;
    }

    public JFXTextField getPassword() {
        return password;
    }

    public void setPassword(JFXTextField password) {
        this.password = password;
    }

    public JFXTextField getFullName() {
        return fullName;
    }

    public void setFullName(JFXTextField fullName) {
        this.fullName = fullName;
    }

    public JFXTextField getNote() {
        return note;
    }

    public void setNote(JFXTextField note) {
        this.note = note;
    }

    public JFXTextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(JFXTextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JFXTextField getEmail() {
        return email;
    }

    public void setEmail(JFXTextField email) {
        this.email = email;
    }

    public JFXTextField getPermision() {
        return permision;
    }

    public void setPermision(JFXTextField permision) {
        this.permision = permision;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    private Admin admin;

    public void addOnAction(ActionEvent actionEvent) {
        try {
            insertAdmin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void continueAddOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {

    }

    public void setDefault(String blank) {

    }

    public void insertAdmin() throws SQLException {
        String sql = "insert into datapa02.nguoidung values (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,getId().getText());
        pst.setString(2,getLoginName().getText());
        pst.setString(3,getPassword().getText());
        pst.setString(4,getFullName().getText());
        pst.setString(5,getNote().getText());
        pst.setString(6,getPhoneNumber().getText());
        pst.setString(7,getEmail().getText());
        pst.setString(8,getPermision().getText());
        pst.addBatch();
        pst.executeUpdate();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.getConnect();
    }
}
