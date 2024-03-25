import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TreeView {

    public TreeView() {
        // 无参构造方法
    }

    // 创建并显示树节点的视图
    public static StackPane ShowView(TreeNode node) {
        String inputText = node.getContent(); // 获取树节点内容
        Text text = new Text(inputText); // 创建文本对象
        double textWidth = text.getLayoutBounds().getWidth(); // 获取文本宽度
        double textHight = text.getLayoutBounds().getHeight(); // 获取文本高度
        Label label = new Label(inputText); // 创建标签对象
        Rectangle rec = new Rectangle(textWidth + 10.0, textHight + 10.0); // 创建矩形对象
        rec.setFill(Color.TRANSPARENT); // 设置矩形填充颜色为透明
        rec.setStroke(Color.BLACK); // 设置矩形边框颜色为黑色
//        label.setLayoutX(300.0); // 设置标签水平布局位置
//        label.setLayoutY(300.0); // 设置标签垂直布局位置
//        rec.setLayoutX(300.0); // 设置矩形水平布局位置
//        rec.setLayoutY(300.0); // 设置矩形垂直布局位置
        StackPane pane = new StackPane(); // 创建堆栈面板对象
        pane.getChildren().addAll(new Node[]{label, rec}); // 将标签和矩形添加到堆栈面板中
        text.setTextAlignment(TextAlignment.CENTER); // 设置文本居中对齐
        text.setTextOrigin(VPos.CENTER); // 设置文本垂直对齐方式
        return pane; // 返回堆栈面板对象
    }
    // 删除指定节点的视图
    public static void DeleteNodeView(StackPane pane) {
        pane.getChildren().clear(); // 清空面板中的所有子节点
    }
}
