import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TreeDrawingExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建根节点
        TreeNode root = new TreeNode(0, null);

        // 添加一些子节点
        TreeNode child1 = new TreeNode(1, root);
        TreeNode child2 = new TreeNode(1, root);
        TreeNode child3 = new TreeNode(1, root);
        TreeNode child4 = new TreeNode(2, child1);
        TreeNode child5 = new TreeNode(3, child2);
        TreeNode child6 = new TreeNode(4, child3);

        // 将子节点连接到根节点
        root.getChildren().add(child1);
        root.getChildren().add(child2);
        root.getChildren().add(child3);
        child1.getChildren().add(child4); // 注意这里将子节点添加到 child1 的子节点列表中
        child2.getChildren().add(child5); // 注意这里将子节点添加到 child2 的子节点列表中
        child3.getChildren().add(child6); // 注意这里将子节点添加到 child3 的子节点列表中

        // 设置每个子节点的父节点
        child1.setParent(root);
        child2.setParent(root);
        child3.setParent(root);
        child4.setParent(child1);
        child5.setParent(child2);
        child6.setParent(child3);

        // 创建树的场景
        Group treeScene = TreeDrawer.drawTree(root);

        // 创建删除按钮
        Button deleteButton = new Button("Delete Node");
        deleteButton.setLayoutX(10);
        deleteButton.setLayoutY(10);

        // 创建主场景
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(treeScene, deleteButton);
        Scene scene = new Scene(anchorPane, 800, 600);

        // 添加按钮的点击事件处理程序
        deleteButton.setOnAction(event -> {
            // 从根节点中删除一个子节点（这里以删除第一个子节点为例）
            root.getChildren().remove(0);
            // 重新绘制树
            Group newTreeScene = TreeDrawer.drawTree(root);
            // 将新的树的场景添加到 AnchorPane 中
            anchorPane.getChildren().set(0, newTreeScene);
        });

        // 设置舞台
        primaryStage.setTitle("Tree Drawing Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // 添加鼠标点击事件处理器到 AnchorPane
        anchorPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // 打印鼠标点击的坐标
            System.out.println("Mouse Clicked at X: " + event.getX() + ", Y: " + event.getY());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
