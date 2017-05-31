package id.doublesinlove.view;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * doublesinlove © 2017.
 */
public class WarningDialog extends JFXDialogLayout {
    public WarningDialog(String type) {
        this.setHeading(new Text("WARNING"));
        this.setBody(new Text("Please make sure you have typed your " + type + "."));
    }

    public void showDialog(StackPane pane) {
        JFXDialog dialog = new JFXDialog();
        dialog.setContent(this);
        dialog.show(pane);
    }
}
