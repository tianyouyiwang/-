import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class test extends Application {
    private Pane root;

    public test() {
    }

    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane(); // 创建根节点Pane
        FlowPane rp = new FlowPane();
        Scene scene = new Scene(rp, 600.0, 400.0); // 创建Scene

        stage.setScene(scene);
        Button button = new Button("新建节点"); // 创建一个按钮
        button.setLayoutX(50);
        button.setLayoutY(50);
        Button button1 = new Button("删除节点"); // 删除节点
        button1.setLayoutX(100);
        button1.setLayoutY(50);
        AtomicReference<StackPane> cur_pane = new AtomicReference<>();

        rp.getChildren().addAll(button,button1); // 将按钮添加到根节点中
        button.setOnMouseClicked((event) -> { // 当按钮被点击时触发事件
            TreeNode node = new TreeNode(); // 创建一个新的节点
            StackPane pane = TreeView.ShowView(node); // 在TreeView中展示该节点
            cur_pane.set(pane);
            rp.getChildren().add(pane); // 将展示的节点添加为根节点的子节点
        });

        button1.setOnMouseClicked((event) -> { // 当按钮被点击时触发事件
            StackPane pane = cur_pane.get();
            //cur_pane.set();
            TreeView.DeleteNodeView(pane);

        });
        stage.setTitle("TreeNode Example"); // 设置舞台标题
        stage.show(); // 显示舞台

    }

    public static void main(String[] args) {
        launch(args); // 启动JavaFX应用程序
    }
}
