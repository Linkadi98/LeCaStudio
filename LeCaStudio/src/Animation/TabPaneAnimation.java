package Animation;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;

public class TabPaneAnimation {
    public TabPaneAnimation () {}

    public void tabSelection(Label navigatorBar, JFXTabPane tabPane, JFXDrawer drawer, boolean isPressed, HamburgerBackArrowBasicTransition backArrow) {
        if(drawer.isOpened()) {
            drawer.close();
            backArrow.setRate(backArrow.getRate() * -1);
            backArrow.play();
        }

        SingleSelectionModel<Tab> selection = tabPane.getSelectionModel();
        if(!isPressed) {
            TextChangeAnimation textChangeAnimation = new TextChangeAnimation();
            textChangeAnimation.textChange(navigatorBar, selection.getSelectedItem().getText());
            isPressed = true;
        }

        selection.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TextChangeAnimation textChangeAnimation2 = new TextChangeAnimation();
            textChangeAnimation2.textChange(navigatorBar, newValue.getText());
        });
    }
}
