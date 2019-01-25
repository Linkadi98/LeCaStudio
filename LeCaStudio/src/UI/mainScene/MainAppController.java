package UI.mainScene;

import Animation.TextChangeAnimation;
import UI.tablesButton.ButtonBoxController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
//import UI.tablesButton.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.Color.*;


public class MainAppController implements Initializable {
    public final String NAVIGATOR = "Navigator bar";
    public final String MENU = "Menu";

    public Boolean isPressed = false;
    @FXML
    public StackPane stackPane;

    @FXML
    public VBox buttonBox;

    @FXML
    public Label navigatorBar;

    public JFXTabPane tabPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

    @FXML
    private ButtonBoxController buttonBoxController;

    private Model model;

    public void setModel(Model model) {
        //to make sure that only one model can be initialized
        if(this.model != null) {
            throw new IllegalStateException("abc");
        }

        navigatorBar.textProperty().unbind();
        this.model = model;
        navigatorBar.textProperty().bindBidirectional(model.navigatorProperty());
    }



    public void hamburgerMousePressed(javafx.scene.input.MouseEvent mouseEvent) {

        if(drawer.isOpened()) {
            drawer.close();
            hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate() * -1);
            hamburgerBackArrowBasicTransition.play();
            TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
            textChangeAnimation.textChange(navigatorBar, NAVIGATOR);
            isPressed = false;
        }
        else {
            drawer.open();
            hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate() * -1);
            hamburgerBackArrowBasicTransition.play();
            TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
            textChangeAnimation.textChange(navigatorBar, MENU);
            isPressed = false;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition = new HamburgerBackArrowBasicTransition(hamburger);
        hamburgerBackArrowBasicTransition.setRate(-1);

        stackPane = new StackPane();
        drawer.setSidePane(stackPane);
        drawer.setDefaultDrawerSize(250);
        drawer.setResizeContent(true);
        drawer.setOverLayVisible(false);
        drawer.setResizableOnDrag(true);
        hamburgerBackArrowBasicTransition.setRate(-1);
        drawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
        drawer.setOpacity(0.5);
        drawer.setDefaultDrawerSize(150.0);
    }

    public void tabPaneMousePressed(MouseEvent event) {
        if(drawer.isOpened()) {
            drawer.close();
            hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate() * -1);
            hamburgerBackArrowBasicTransition.play();
        }

        SingleSelectionModel<Tab> selection = tabPane.getSelectionModel();
        if(!isPressed) {
            TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
            textChangeAnimation.textChange(navigatorBar, selection.getSelectedItem().getText());
            isPressed = true;
        }

        selection.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(isPressed) {
                TextChangeAnimation textChangeAnimation2 = new TextChangeAnimation();
                textChangeAnimation2.textChange(navigatorBar, newValue.getText());
            }
        });
    }
}


