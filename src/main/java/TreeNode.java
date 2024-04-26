
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode extends TreeData {
    private static TreeNode root;
    private List<TreeNode> children = new ArrayList();
    private int x;
    private int y;
    private int order;
    private Shape shape;
    private float left;
    private float top;
    private boolean click = false;
    private BorderStyle borderStyle;
    private WordColor wordColor;
    private Status status;
    private Text text;
    private Label label;
    private Rectangle rec;
    private AnchorPane pane;
    private static int node_id = 0;

    public TreeNode(int pid) {
        super(node_id, pid);
        node_id++;
        this.borderStyle = BorderStyle.SOLID;
        this.wordColor = WordColor.BLACK;
        this.status = Status.LOW;
        this.text = new Text(this.getContent());
        this.label = new Label(this.getContent());
        this.pane = new AnchorPane();
        double textWidth = text.getLayoutBounds().getWidth();//
        double textHight = text.getLayoutBounds().getHeight();//
        this.rec = new Rectangle(textWidth + 10.0, textHight + 10.0);
        rec.setFill(Color.TRANSPARENT);
        rec.setStroke(Color.BLACK);
        label.setLayoutX(100.0);
        label.setLayoutY(100.0);
        rec.setLayoutX(100.0);
        rec.setLayoutY(100.0);
        pane.getChildren().addAll(label, rec);
    }


    public static TreeNode getRoot() {
        return root;
    }

    public static void setRoot(TreeNode root) {
        TreeNode.root = root;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public BorderStyle getBorderStyle() {
        return this.borderStyle;
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle = borderStyle;
    }

    public WordColor getWordColor() {
        return this.wordColor;
    }

    public void setWordColor(WordColor wordColor) {
        this.wordColor = wordColor;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getLeft() {
        return this.left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getTop() {
        return this.top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public boolean isClick() {
        return this.click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }

    public List<TreeNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public AnchorPane getPane() {
        return pane;
    }

    public void setPane(AnchorPane pane) {
        this.pane = pane;
    }

    public static int getNode_id() {
        return node_id;
    }

    public static void setNode_id(int node_id) {
        TreeNode.node_id = node_id;
    }
}
enum WordColor {
    BLACK,
    RED,
    BLUE,
    YELLOW;

}
enum Status {
    LOW,
    MEDIUM,
    HIGH;


}

enum Shape {
    CIRCLE,
    RECTANGLE;

}

enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED,
    ARROW;

}
