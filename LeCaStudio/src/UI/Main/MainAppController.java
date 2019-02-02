package UI.Main;

import Animation.SceneTransitionAnimation;
import Animation.TextChangeAnimation;
import Models.TableModel;
import UI.Admin.AddingAdminController;
import UI.Buttons.ButtonBoxController;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
//import UI.Buttons.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {
    public final String NAVIGATOR = "Navigator";
    public final String MENU = "Menu";

    public Boolean isPressed = false;
    @FXML
    public StackPane stackPane;

    @FXML
    public VBox buttonBox;

    @FXML
    public Label navigatorBar;

    public JFXTabPane tabPane;

    public Tab adminTab;

    public AnchorPane anchorPane;
    public MenuButton home;
    public MenuButton admin;
    public MenuButton customer;
    public MenuButton order;
    public MenuButton photo;
    public MenuButton search;
    public MenuButton employee;
    public StackPane stackPaneCenter;
    public Pane leftSidePane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

    @FXML
    private ButtonBoxController buttonBoxController;

    private Model model;

    private TableModel tableModel;

    private String selection;

    public void setTableModel(TableModel tableModel) {
        if(this.tableModel != null) {
            throw new IllegalStateException("Only one table model can be initiallized");
        }

        this.tableModel = tableModel;
        System.out.println("Đã truyền vào");
    }

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
        drawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
        drawer.setOpacity(0.5);
        drawer.setDefaultDrawerSize(150.0);
        if(tableModel == null) {
            System.out.println("Đoạn này nó bị null");
        }


    }


    public void homeOnMousePressed(MouseEvent event) throws IOException {
        SceneTransitionAnimation sceneTransitionAnimation = new SceneTransitionAnimation();
        sceneTransitionAnimation.sceneTransition(stackPaneCenter, navigatorBar, "Home");
//        leftSidePane.getChildren().remove();
    }

    public void adminOnMousePressed(MouseEvent event) throws IOException {
        SceneTransitionAnimation sceneTransitionAnimation = new SceneTransitionAnimation();
//        sceneTransitionAnimation.hideCurrentScene(stackPaneCenter);
        sceneTransitionAnimation.sceneTransition(stackPaneCenter, navigatorBar, "Admin");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LEFT_SIDE_PANE/AdminLSP.fxml"));
        leftSidePane.getChildren().add(loader.load());



    }
}


