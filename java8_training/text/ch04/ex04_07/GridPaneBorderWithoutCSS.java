package ch04.ex04_07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPaneBorderWithoutCSS extends Application{
  public void start(Stage stage) {
    final double rem = new Text("").getLayoutBounds().getHeight();

    GridPane pane = new GridPane();
    // pane.setGridLinesVisible(true);

    pane.setHgap(0.8 * rem);
    pane.setVgap(0.8 * rem);
    pane.setPadding(new Insets(0.8 * rem));
    Label usernameLabel = new Label("User name:");
    Label passwordLabel = new Label("Password:");
    TextField username = new TextField();
    PasswordField password = new PasswordField();

    Button okButton = new Button("Ok");
    Button cancelButton = new Button("Cancel");

    HBox buttons = new HBox(0.8 * rem);
    buttons.getChildren().addAll(okButton, cancelButton);
    buttons.setAlignment(Pos.CENTER);

    // CSS version
    // buttons.setStyle("-fx-border-color: red;");

    // Without CSS version
    buttons.borderProperty().setValue(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));

    pane.add(usernameLabel, 0, 0);
    pane.add(username, 1, 0);
    pane.add(passwordLabel, 0, 1);
    pane.add(password, 1, 1);
    pane.add(buttons, 0, 2, 2, 1);

    GridPane.setHalignment(usernameLabel, HPos.RIGHT);
    GridPane.setHalignment(passwordLabel, HPos.RIGHT);
    stage.setScene(new Scene(pane));
    stage.show();
 }
  public static void main(String[] args) {
    launch(args);
  }

}
