import java.util.Iterator;

public class TreeUtil {
    private static int max_id = 1;

    public static void showChild(TreeNode p_node){

    }

    public static void addChild(TreeNode pnode) {
        ++max_id;
        int id = max_id;
        TreeNode node = new TreeNode(id, pnode.getId());
        pnode.getChildren().add(node);
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
}
