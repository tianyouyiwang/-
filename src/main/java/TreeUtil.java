import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
public class TreeUtil {
    private static int max_id = 1;

    private static TreeNode root = null;

    public static int getMax_id() {
        return max_id;
    }

    public static void setMax_id(int max_id) {
        TreeUtil.max_id = max_id;
    }

    public static TreeNode getRoot() {
        return root;
    }

    public static void setRoot(TreeNode root) {
        TreeUtil.root = root;
    }

    public static void showChild(TreeNode p_node){

    }

    public static TreeNode addChild(TreeNode pnode) {
        ++max_id;
        int id = max_id;
        TreeNode node = new TreeNode(pnode.getId());
        pnode.getChildren().add(node);
        return node;
    }
    public static void delete(TreeNode pnode, int nid) {
        Iterator<TreeNode> iterator = pnode.getChildren().iterator();

        while(iterator.hasNext()) {
            TreeNode child = iterator.next();
            if (child.getId() == nid) {
                iterator.remove();
                break;
            }
        }
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
        if (root == null) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.getRec().contains(x, y)) {
                return current;
            }

            for (TreeNode child : current.getChildren()) {
                stack.push(child);
            }
        }

        return null;
    }
}
