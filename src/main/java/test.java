import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {
    private Pane root;
    private int nidCounter = 0;

    public test() {
    }

    public void start(Stage stage) throws Exception {
        Button button = new Button("新建节点");
        button.setLayoutX(150.0);
        button.setLayoutY(150.0);
        button.setOnMouseClicked((event) -> {
            TreeNode node = new TreeNode();
            StackPane pane = TreeView.ShowView(node);
            Scene scene = new Scene(pane, 600.0, 400.0);
            stage.setScene(scene);
        });
        StackPane root = new StackPane(new Node[]{button});
        Scene scene1 = new Scene(root, 300.0, 200.0);
        stage.setScene(scene1);
        stage.setTitle("TreeNode Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
