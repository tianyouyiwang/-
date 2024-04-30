import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
public class TreeUtil {

    private static TreeNode root = null;


    public static TreeNode getRoot() {
        return root;
    }

    public static void setRoot(TreeNode root) {
        TreeUtil.root = root;
    }

    public static void showChild(TreeNode p_node){

    }

    public static TreeNode addChild(TreeNode pnode) {
        TreeNode node = new TreeNode(pnode.getId(),pnode);
        //if(root == null) root = node;
        pnode.getChildren().add(node);
        System.out.println("当前添加的节点：" + node.getId());
        return node;
    }
    public static boolean delete(int id) {
        if (root == null) {
            return false; // 根节点为空，无法执行删除操作
        }
        // 判断根节点是否是目标节点
        if (root.getId() == id) {
            root = null; // 直接将根节点置为null
            return true;
        }
        // 遍历根节点的子节点
        Iterator<TreeNode> iterator = root.getChildren().iterator();
        while (iterator.hasNext()) {
            TreeNode child = iterator.next();
            if (child.getId() == id) {
                iterator.remove(); // 找到需要的节点后删除它
                return true; // 返回true表示成功删除节点
            } else {
                // 如果当前子节点不是目标节点，则递归调用delete方法继续查找
                if (delete(id)) {
                    System.out.println("当前删除的节点：" + id);
                    return true; // 如果在子树中找到并删除了节点，则返回true
                }
            }
        }
        return false; // 没有找到目标节点
    }

    public static boolean HavaChild(TreeNode pnode) {
        return !pnode.getChildren().isEmpty();
    }

    public static TreeNode findParent(TreeNode root, int id) {
        if (root==null || !HavaChild(root)) {
            return null;
        } else {
            Iterator<TreeNode> iterator = root.getChildren().iterator();

            TreeNode node;
            do {
                if (!iterator.hasNext()) {
                    return null;
                }

                TreeNode child = iterator.next();
                if (child.getId() == id) {
                    return child;
                }

                node = findParent(child, id);
            } while(node == null);

            return node;
        }
    }
    public static TreeNode findChild(TreeNode pnode,int id){
        Iterator<TreeNode> iterator = pnode.getChildren().iterator();
        TreeNode node;
        do {
            if (!iterator.hasNext()) {
                return null;
            }

            TreeNode child = iterator.next();
            if (child.getId() == id) {
                return child;
            }

            node = findParent(child, id);
        } while(node == null);
        return node;
    }
    public static TreeNode findNodeByClick(double x, double y) {
        //System.out.println(root.toString());
        if (root == null) {
            return null;
        }
        //System.out.println("进来了");
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current);
            System.out.println(current.getRec().getX()+" "+current.getRec().getY());

            System.out.println(x+" "+y);
            if (current.getRec().contains(x, y)) {
                System.out.println("进来了");
                return current;
            }

            for (TreeNode child : current.getChildren()) {
                stack.push(child);
            }
        }

        return null;
    }
    public static void printNodeIds(TreeNode node) {
        if (node != null) {
            // 打印当前节点的 ID
            System.out.println("Node ID: " + node.getId());
            // 遍历当前节点的所有子节点
            for (TreeNode child : node.getChildren()) {
                printNodeIds(child); // 递归调用
            }
        }
    }
}
