package UI.mainScene;

import UI.tablesButton.ButtonBoxController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainTest extends Application {
    private final Model model = new Model();
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
        FXMLLoader buttonLoader = new FXMLLoader(getClass().getResource("/tablesButton.fxml"));
        mainAppController.stackPane.getChildren().add(buttonLoader.load());
        ButtonBoxController buttonBoxController = buttonLoader.getController();
        buttonBoxController.setModel(model);
        mainAppController.navigatorBar.setText(model.getNavigator());
        buttonBoxController.setLabel(mainAppController.navigatorBar);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
