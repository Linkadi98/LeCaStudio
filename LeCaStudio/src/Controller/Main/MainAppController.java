package Controller.Main;

import Animation.SceneTransitionAnimation;
import Animation.TextChangeAnimation;
import Models.AdminModel;
import Models.TableModel;
import Objects.Admin;
import Controller.Admin.AdminLSPController;
import Controller.Admin.AdminController;
import Controller.Buttons.ButtonBoxController;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
//import Controller.Buttons.*;

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
    public JFXSpinner spinnerStatus;
    public Label status;

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

    private AdminModel adminModel;

    private ObservableList<Admin> admins;

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
        adminModel = new AdminModel();
        spinnerStatus.setVisible(false);

    }


    public void homeOnMousePressed(MouseEvent event) throws IOException {
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/PAGES/Home.fxml"));
        AnchorPane homeRoot = homeLoader.load();
        SceneTransitionAnimation sceneTransitionAnimation = new SceneTransitionAnimation();
        sceneTransitionAnimation.sceneTransition(stackPaneCenter, navigatorBar, "Home", homeRoot);
        leftSidePane.getChildren().remove(leftSidePane.getChildren().size() - 1);
//        leftSidePane.getChildren()
    }

    public void adminOnMousePressed(MouseEvent event) throws IOException {

        adminModel = new AdminModel();
        FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("/PAGES/Admin.fxml"));
        FXMLLoader adminLSPLoader = new FXMLLoader(getClass().getResource("/LEFT_SIDE_PANE/AdminLSP.fxml"));

        AnchorPane root = adminLoader.load();

        SceneTransitionAnimation sceneTransitionAnimation = new SceneTransitionAnimation();
        sceneTransitionAnimation.hideCurrentScene(stackPaneCenter, navigatorBar, "Admin", root);

        leftSidePane.getChildren().add(adminLSPLoader.load());
        AdminController adminController = adminLoader.getController();
        AdminLSPController controller = adminLSPLoader.getController();

        controller.setAdminModel(adminModel);
        adminController.setAdminModel(adminModel);
        adminModel.setTreeTableView(adminController.adminTreeTable);
        adminModel.prepareAdminTreeTableView();

//        admins = FXCollections.observableArrayList();
        preloaderData(adminModel);

    }

    public void preloaderData(AdminModel adminModel) {
        admins = FXCollections.observableArrayList();
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                spinnerStatus.setVisible(true);
                admins = adminModel.addAdminsToTable();
                System.out.println(123445667);
                return null;
            }
        };
//        Platform.setImplicitExit(true);
        new Thread(task).start();
        task.setOnRunning((e -> status.setText("Đang kết nối tới server...")));

        task.setOnFailed((e -> {
            status.setText("Kết nối không thành công!");
            spinnerStatus.setVisible(false);
        }));

        task.setOnSucceeded((e -> {
            status.setText("Đã kết nối");
            status.setTextFill(Paint.valueOf("#41dc0e"));
            spinnerStatus.setVisible(false);
        }));
        adminModel.loadDataToTable(admins);
    }
}


