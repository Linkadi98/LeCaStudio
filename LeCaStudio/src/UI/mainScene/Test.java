package UI.mainScene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(new Tab("tab 1"),
                new Tab("tab 2"),
                new Tab("tab 3"));
        Button btn = new Button();
        btn.setText("Which tab?");
        Label label = new Label();
        btn.setOnAction((evt)-> {
            label.setText(tabPane.getSelectionModel().getSelectedItem().getText());
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(tabPane, btn, label);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        //you can also watch the selectedItemProperty
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
            primaryStage.setTitle(nv.getText());
        });

    }

    public static void main(String[] args) { launch(args); }

}