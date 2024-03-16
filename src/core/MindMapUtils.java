import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MindMapUtils {

    static int nidCounter = 0;
    // 计算节点文本的宽度
    public static double calculateTextWidth(String text, Font font) {
        Text tempText = new Text(text);
        tempText.setFont(font);
        return tempText.getBoundsInLocal().getWidth();
    }

    // 计算节点文本的高度
    public static double calculateTextHeight(Font font) {
        Text tempText = new Text("Text");
        tempText.setFont(font);
        return tempText.getBoundsInLocal().getHeight();
    }

    // 创建连接线
    public static Line createLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(2); // 设置线条宽度
        return line;
    }
    public static void handleMouseClicked(MouseEvent event, Pane root) {
        double x = event.getX();
        double y = event.getY();
        if (event.isControlDown()) {
            // 创建节点
            TreeNode newNode = new TreeNode(nidCounter, nidCounter++,"sda");
            newNode.setX((int) x);
            newNode.setY((int) y);
            createNodeView(newNode,root);
        } else {
            // 删除节点
            removeNodeAtPosition(x, y, root);
        }
    }

    public static void createNodeView(TreeNode node, Pane root) {
        Rectangle rec = new Rectangle(50,30, Color.GRAY); // 创建一个长方形
        rec.setX(node.getX());
        rec.setY(node.getY());
        Label la = new Label(node.getContent());

        la.setLayoutX(node.getX()+5);
        la.setLayoutY(node.getY()+5);

        root.getChildren().add(rec);
        root.getChildren().add(la);
    }

    public static void removeNodeAtPosition(double x, double y, Pane root) {
        root.getChildren().removeIf(node -> {
            if (node instanceof Rectangle) {
                Rectangle rec = (Rectangle) node;
                double recX = rec.getX();
                double recY = rec.getY();
                double recWidth = rec.getWidth();
                double recHeight = rec.getHeight();

                // 检查鼠标点击位置是否在矩形范围内
                System.out.println(x+" "+recX+" "+y+" "+recY);
                if (x >= recX && x <= recX + recWidth && y >= recY && y <= recY + recHeight) {
                    // 如果鼠标点击位置在长方形内部，则从root中移除该矩形和对应的标签
                    root.getChildren().remove(rec); // 移除矩形
                    // 找到对应的标签并移除
                    root.getChildren().removeIf(label -> label instanceof Label && root.getChildren().indexOf(label) % 2 == 0);
                    return true; // 如果鼠标点击位置在长方形内部，则删除该节点
                }
            }
            return false; // 否则保留该节点
        });
    }
}
