
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

    public TreeNode(int id, int pid) {
        super(id, pid);
        this.borderStyle = BorderStyle.SOLID;
        this.wordColor = WordColor.BLACK;
        this.status = Status.LOW;
    }

    public TreeNode() {
        this.borderStyle = BorderStyle.SOLID;
        this.wordColor = WordColor.BLACK;
        this.status = Status.LOW;
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
