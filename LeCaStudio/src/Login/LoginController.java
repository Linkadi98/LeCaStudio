package Login;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class LoginController {

    @FXML
    public AnchorPane achorPane;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField adminName;

    @FXML
    private JFXPasswordField password;

    @FXML
    void adminNameKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            if (adminName.getText() == "") {
                return;
            } else {
                password.requestFocus();
            }
        }

    }

    @FXML
    void cancel(ActionEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), achorPane);
        fadeTransition.setFromValue(2.0);
        fadeTransition.setToValue(0.3);
        fadeTransition.play();
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert adminName != null : "fx:id=\"adminName\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";

    }
    @FXML
    public void passwordKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            if(adminName.getText().equals("LeCanh") && password.getText().equals("1234")) {
                System.out.println("Thành công");
            }
            else {
                adminName.setText("");
                password.setText("");
                adminName.setFocusColor(Color.RED);
                password.setFocusColor(Color.RED);

            }
        }
    }

    private boolean isCorrect(String name, String password) {
        //kết nối với cơ sở dữ liệu
        // check tên và mật khẩu của người dùng
        return false;
    }


}
