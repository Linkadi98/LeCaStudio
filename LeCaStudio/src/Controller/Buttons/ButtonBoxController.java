package Controller.Buttons;

import Animation.TextChangeAnimation;
import Models.AdminModel;
import Models.PhotoPackageModel;
import Models.TableModel;
import Controller.Main.Model;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ButtonBoxController {

    @FXML
    public JFXButton addItem;

    public JFXButton getAddItem() {
        return addItem;
    }

    private Label label = new Label();

    private Model model;

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    private TableModel tableModel;

    @FXML
    private VBox buttonBox;

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void addItemOnAction(ActionEvent actionEvent) {
    }

    public void addItemMousePressed(MouseEvent event) {
        TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
        textChangeAnimation.textChange(label, "Now adding item");
        model.setNavigator(label.getText());
        if(tableModel.model == null) {
            System.out.println("null");
        }
        if(tableModel.model instanceof AdminModel) {
            AdminModel adminModel = (AdminModel) tableModel.model;
//            adminModel.print();
//            adminModel.show();
        }
        else if(tableModel.model instanceof PhotoPackageModel) {
            System.out.println("Day la tab photo");
        }
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

