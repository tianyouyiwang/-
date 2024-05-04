import javafx.scene.Group;
import javafx.scene.shape.Line;

public class TreeDrawer {
    private static int drawType = 0;
    private static Group group = new Group();

    // 绘制整个树
    public static Group drawTree(TreeNode root) {
        if (root != null) {
            // 清除原有的 pane
            group.getChildren().clear();
            drawNode(root,200, 200); // 设置根节点的初始位置
        }
        return group;
    }

    // 递归绘制节点及其子节点
    private static void drawNode(TreeNode node, double x, double y) {
        // 设置节点的位置
        node.setLeft(x);
        node.setTop(y);

        // 设置节点的布局位置
        node.getPane().setLayoutX(x);
        node.getPane().setLayoutY(y);


        // 将节点的 pane 添加到父组中
        node.getPane().setVisible(true); // 设置节点的可见性为 true
        group.getChildren().add(node.getPane());

        // 将节点的 Pane 移动到 Group 的顶部
        node.getPane().toFront();
        // 计算子节点的布局位置
        double childX = x + 200; // 子节点的 x 坐标相对于父节点的 x 坐标向右偏移 200 个单位
        double childY = y - (100 * (node.getChildren().size() - 1) / 2); // 子节点的 y 坐标相对于父节点的 y 坐标向下偏移 100 个单位

        // 绘制节点的子节点并绘制连线
        for (TreeNode child : node.getChildren()) {
            double childCenterX = childX + 40; // 子节点中心的 x 坐标
            double childCenterY = childY + 40; // 子节点中心的 y 坐标

            drawNode(child, childX, childY);
            childY += 100; // 每个子节点的 y 坐标相对于前一个子节点向右偏移 100 个单位

            // 绘制父节点到子节点的连线
            double startX = x + node.getRec().getWidth() ; // 连线起始点 x 坐标
            double startY = y + node.getRec().getHeight()/2 ; // 连线起始点 y 坐标
            double endX = childCenterX - child.getRec().getWidth()/1.5; // 连线终止点 x 坐标
            double endY = childCenterY - child.getRec().getHeight(); // 连线终止点 y 坐标

            Line line = new Line(startX,startY,endX,endY);
            System.out.println("startX="+startX+", startY="+startY+", x="+x+", y="+y);
            group.getChildren().add(line);
        }
    }

    public static int getDrawType() {
        return drawType;
    }

    public static void setDrawType(int drawType) {
        TreeDrawer.drawType = drawType;
    }

    public static Group getGroup() {
        return group;
    }

    public static void setGroup(Group group) {
        TreeDrawer.group = group;
    }
}
