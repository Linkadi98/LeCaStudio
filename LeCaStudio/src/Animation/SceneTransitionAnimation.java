package Animation;

import UI.Main.MainAppController;
import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class SceneTransitionAnimation {
    public FXMLLoader loader;

    public void sceneTransition (StackPane stackPaneCenter, Label navigatorBar, String nameOfPage, FXMLLoader loader, AnchorPane root) throws IOException {

        TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
        textChangeAnimation.textChange(navigatorBar, nameOfPage);

        root.translateXProperty().set(stackPaneCenter.getWidth());
        stackPaneCenter.getChildren().setAll(root);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(), 0, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void hideCurrentScene(StackPane stackPaneCenter, Label navigatorBar, String nameOfPage, FXMLLoader loader, AnchorPane root) {
        for(Node node: stackPaneCenter.getChildren()){
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), node);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(.1);
            fadeTransition.play();
            fadeTransition.setOnFinished((e -> {
                try {
                    sceneTransition(stackPaneCenter, navigatorBar, nameOfPage, loader, root);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }));
        }





//        Timeline timeline = new Timeline();
//        KeyValue keyValue = new KeyValue(currentScene.getRoot().translateXProperty(), Integer.MIN_VALUE, Interpolator.LINEAR);
//        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
//        timeline.getKeyFrames().add(keyFrame);
//        timeline.play();

    }


}
