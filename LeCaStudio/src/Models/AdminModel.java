package Models;

import Objects.Admin;
import UI.Admin.AddingAdminController;
import UI.Admin.AdminTableController;
import UI.Main.MainAppController;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.StringProperty;
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

public class AdminModel extends TableModel {
    private JFXTreeTableView<Admin> treeTableView;
    private StackPane stackPaneCenter;
    private AddingAdminController addingAdminController;
    private AdminTableController adminTableController;
    public StackPane getStackPaneCenter() {
        return stackPaneCenter;
    }

    public void setStackPaneCenter(StackPane stackPaneCenter) {
        this.stackPaneCenter = stackPaneCenter;
    }

    public JFXTreeTableView<Admin> getTreeTableView() {
        return treeTableView;
    }

    public void setTreeTableView(JFXTreeTableView<Admin> treeTableView) {
        this.treeTableView = treeTableView;
    }

    public ObservableList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ObservableList<Admin> admins) {
        this.admins = admins;
    }

    ObservableList<Admin> admins;
    public void reloadTable () {
        TreeItem<Admin> treeItemRoot = new RecursiveTreeItem<>(admins, RecursiveTreeObject::getChildren);
        treeTableView.setRoot(treeItemRoot);
        treeTableView.setShowRoot(false);
    }

    public void reloadPage(String nameOfPage) {
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/PAGES/" + nameOfPage + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stackPaneCenter.getChildren().setAll(root);
    }




}
