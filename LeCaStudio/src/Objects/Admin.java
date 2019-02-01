package Objects;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin extends RecursiveTreeObject<Admin> {
    private StringProperty idAdmin;
    private StringProperty loginName;
    private StringProperty password;
    private StringProperty fullName;
    private StringProperty note;
    private StringProperty phoneNumber;
    private StringProperty email;
    private StringProperty permission;

    public String getIdAdmin() {
        return idAdmin.get();
    }

    public StringProperty idAdminProperty() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin.set(idAdmin);
    }

    public String getLoginName() {
        return loginName.get();
    }

    public StringProperty loginNameProperty() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName.set(loginName);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getNote() {
        return note.get();
    }

    public StringProperty noteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPermission() {
        return permission.get();
    }

    public StringProperty permissionProperty() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission.set(permission);
    }



    public Admin(String idAdmin, String loginName, String password, String fullName, String note, String phoneNumber, String email, String permission) {
        this.idAdmin = new SimpleStringProperty(idAdmin);
        this.loginName = new SimpleStringProperty(loginName);
        this.password = new SimpleStringProperty(password);
        this.fullName = new SimpleStringProperty(fullName);
        this.note = new SimpleStringProperty(note);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.permission = new SimpleStringProperty(permission);
    }

}
