import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClickPositionExample extends Application {
    private Pane root;

    public void start(Stage stage) {
        root = new Pane();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);

        Button button = new Button("Click me");
        button.setLayoutX(50);
        button.setLayoutY(50);
        root.getChildren().add(button);

        button.setOnMouseClicked((MouseEvent event) -> {
            StackPane clickedPane = (StackPane) button.getParent(); // 获取按钮的父节点
            System.out.println("Clicked on StackPane at x: " + clickedPane.getLayoutX() + ", y: " + clickedPane.getLayoutY());
        });

        stage.setTitle("Click Position Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
