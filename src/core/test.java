import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;

public class test extends Application {

    private Pane root;
    private int nidCounter = 0;
    // getmin()

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        root.setPrefSize(600, 400);

        root.setOnMouseClicked(event->MindMapUtils.handleMouseClicked(event,root));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeNode Example");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
