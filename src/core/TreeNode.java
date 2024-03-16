import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode {
    private int pid;  // 父节点标识符
    private int nid;  // 节点标识符
    private String content;  // 文本内容
    private int x;  // x坐标
    private int y;  // y坐标
    private int parentId;  // 父节点id
    private List<TreeNode> children = new ArrayList<>(); // 孩子节点
    private int order;  // 顺序
    private Shape shape;   // 形状
    private BorderStyle borderStyle = BorderStyle.SOLID;  // 边框样式
    private WordColor wordColor = WordColor.BLACK;  // 文字颜色
    private Status status = Status.LOW;  // 地位（是否重要）

    // 构造函数
    public TreeNode(int pid, int nid, String content) {
        this.pid = pid;
        this.nid = nid;
        this.content = content;
    }

    // 根据节点标识符添加子节点
    public void addChild(int nid) {
        TreeNode node = new TreeNode(this.pid,nid,"");
        this.children.add(node);
    }

    // 根据节点标识符删除子节点
    public void deleteChildByNid(int nid) {
        Iterator<TreeNode> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            TreeNode child = iterator.next();
            if (child.getNid() == nid) {
                iterator.remove();
                break;
            }
        }
    }

    // equals 方法重写
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TreeNode treeNode = (TreeNode) obj;
        return nid == treeNode.nid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public BorderStyle getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle = borderStyle;
    }

    public WordColor getWordColor() {
        return wordColor;
    }

    public void setWordColor(WordColor wordColor) {
        this.wordColor = wordColor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

// 枚举类型表示节点的形状
enum Shape{
    CIRCLE,  // 圆形
    RECTANGLE, //矩形
}

// 枚举类型表示节点的边框样式
enum BorderStyle {
    SOLID,    // 实线
    DASHED,   // 虚线
    DOTTED,   // 点线
    ARROW,    // 箭头
}

// 该节点相对于其他节点的关系

// 字体颜色
enum WordColor{
    BLACK,  //  黑色
    RED,    //  红色
    BLUE,   //  蓝色
    YELLOW, //  黄色
}
// 地位，即重要性
enum Status{
    LOW,    // 低
    MEDIUM, // 中
    HIGH    // 高
}



