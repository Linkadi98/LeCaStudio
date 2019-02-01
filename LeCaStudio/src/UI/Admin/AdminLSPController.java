package UI.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.HiddenSidesPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLSPController implements Initializable {

    public HiddenSidesPane connectStatus;
    public AnchorPane adminLSP;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label status = new Label("Connected");
        connectStatus.setBottom(status);

    }
}
