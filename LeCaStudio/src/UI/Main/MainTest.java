package UI.Main;

import Models.TableModel;
import UI.Buttons.ButtonBoxController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class MainTest extends Application {
    private final Model model = new Model();
    private TableModel tableModel = new TableModel();
    private TableModel tableModel2 = new TableModel();
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/LeCaApp.fxml"));
        Parent root = mainLoader.load();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Test hiệu ứng");
        Scene scene = new Scene(root);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.show();

        MainAppController mainAppController = mainLoader.getController();
        mainAppController.setModel(model);

        FXMLLoader buttonLoader = new FXMLLoader(getClass().getResource("/Buttons.fxml"));
        mainAppController.stackPane.getChildren().add(buttonLoader.load());

        ButtonBoxController buttonBoxController = buttonLoader.getController();
        buttonBoxController.setModel(model);

        mainAppController.navigatorBar.setText(model.getNavigator());
        buttonBoxController.setLabel(mainAppController.navigatorBar);

        tableModel.model = new TableModel();
        mainAppController.setTableModel(tableModel.model);
        buttonBoxController.setTableModel(tableModel.model);

    }


    public static void main(String[] args) {
        Application.launch(MainTest.class, new String[0]);
    }
}
