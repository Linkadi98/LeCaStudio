package UI.tablesButton;

import Animation.TextChangeAnimation;
import UI.mainScene.Model;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventType;
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
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

