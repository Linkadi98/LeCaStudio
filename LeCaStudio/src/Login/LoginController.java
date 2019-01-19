package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
