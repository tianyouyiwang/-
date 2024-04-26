import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.concurrent.atomic.AtomicReference;

public class MouseUtils extends Application {

    public static double[] getMouseClickLocation(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        return new double[]{x, y};
    }

    public static void passTextClickToRectangle(Text text, Rectangle rec) {
        text.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            rec.fireEvent(event);
        });
    }

    public static TreeNode isMouseInsideRectangle(MouseEvent event, TreeNode node) {
        double[] mouse_location = getMouseClickLocation(event);
        if (node != null && node.getRec().contains(mouse_location[0], mouse_location[1])) {
            System.out.println("鼠标点击在矩形内部");
            return node;
        } else {
            System.out.println("鼠标点击在矩形外部");
            return null;
        }
    }

    public static TreeNode MC_getNode(MouseEvent mouseEvent){
        // 获取鼠标点击位置的坐标
        TreeNode node = TreeUtil.findNodeByClick(mouseEvent.getX(), mouseEvent.getY());
        if(node!=null)
            System.out.println("找到了");
        return node;
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        // 创建幕布
        AnchorPane canvas = new AnchorPane();
        canvas.setStyle("-fx-background-color: rgba(0, 0, 0, 0.2);");
        canvas.setPrefSize(400, 400);

        // 创建矩形
        TreeNode node = new TreeNode(0);

        // 创建一个 AtomicReference 用于保存点击到的节点
        AtomicReference<TreeNode> current_node = new AtomicReference<>(null);

        //在canvas中加入node.pane，这样鼠标点击节点时可以进行对应事件
        canvas.getChildren().add(node.getPane());//

        // 添加鼠标点击事件处理器
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            current_node.set(isMouseInsideRectangle(event, node));
            if (current_node.get() != null) {
                System.out.println("当前点击的节点：" + current_node.get().getContent());
            }
        });

//      ！修改：把node.pane加入到canvas之中即可，只需要canvas加入根画布即可
//      root.getChildren().addAll(canvas, node.getPane());
        root.getChildren().addAll(canvas);

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Click Detection");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
