package UI.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.HiddenSidesPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLSPController implements Initializable {

    public HiddenSidesPane connectStatus;
    public AnchorPane adminLSP;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label status = new Label("Connected");
        connectStatus.setBottom(status);

    }


    public void addOnAction(ActionEvent actionEvent) throws IOException {
        showNewStage("AddingAdmin");

    }

    public void updateOnAction(ActionEvent actionEvent) throws IOException {
        showNewStage("UpdateAdmin");
    }

    public void showNewStage(String window) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/LEFT_SIDE_PANE/" + window + ".fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(parent);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
    }
}
