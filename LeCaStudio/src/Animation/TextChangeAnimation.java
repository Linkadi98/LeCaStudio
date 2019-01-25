package Animation;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class TextChangeAnimation {

    public TextChangeAnimation() {

    }

    public void textChange(Label label, String content) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), label);
        fadeTransition.setFromValue(0.8);
        fadeTransition.setToValue(0.02);
        fadeTransition.play();
        fadeTransition.setOnFinished(e -> {
            label.setTextFill(Color.GOLD);
            label.setText(content);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.5), label);
            fadeTransition2.setFromValue(0.2);
            fadeTransition2.setToValue(0.7);
            fadeTransition2.play();
        });
    }
}
