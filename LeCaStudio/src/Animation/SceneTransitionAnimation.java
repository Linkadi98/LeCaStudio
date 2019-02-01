package Animation;

import UI.Main.MainAppController;
import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class SceneTransitionAnimation {
    public void sceneTransition (StackPane stackPaneCenter, Label navigatorBar, String nameOfPage) throws IOException {
        TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
        textChangeAnimation.textChange(navigatorBar, nameOfPage);

        AnchorPane root = FXMLLoader.load(MainAppController.class.getResource("/PAGES/" + nameOfPage + ".fxml"));
        root.translateXProperty().set(stackPaneCenter.getWidth());
        stackPaneCenter.getChildren().setAll(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(), 0, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void hideCurrentScene(StackPane stackPane) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), stackPane);
        transition.setFromX(0);
        transition.setToX(-stackPane.getWidth());
        transition.play();



//        Timeline timeline = new Timeline();
//        KeyValue keyValue = new KeyValue(currentScene.getRoot().translateXProperty(), Integer.MIN_VALUE, Interpolator.LINEAR);
//        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
//        timeline.getKeyFrames().add(keyFrame);
//        timeline.play();

    }


}
