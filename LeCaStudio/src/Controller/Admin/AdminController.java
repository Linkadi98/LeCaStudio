package Controller.Admin;

import Models.AdminModel;
import Objects.Admin;
import com.jfoenix.controls.JFXTreeTableView;

public class AdminController {
    public JFXTreeTableView<Admin> adminTreeTable;
    private AdminModel adminModel;

    public JFXTreeTableView<Admin> getAdminTreeTable() {
        return adminTreeTable;
    }

    public void setAdminTreeTable(JFXTreeTableView<Admin> adminTreeTable) {
        this.adminTreeTable = adminTreeTable;
    }

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
        System.out.println("Đã truyền vào admin model");
    }

}
