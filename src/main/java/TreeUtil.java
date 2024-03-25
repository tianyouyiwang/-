import java.util.Iterator;

public class TreeUtil {
    private static int max_id = 1;

    // 打印该节点的所有子节点信息
    public static void showChild(TreeNode node){
        Iterator<TreeNode> iterator = node.getChildren().iterator();

        while(iterator.hasNext()) {
            TreeNode child = iterator.next();
            System.out.println("父节点 ID: " + child.getPid() + ", 节点 ID: " + child.getId() );
        }
    }

    // 递归打印该节点及其所有子节点信息
    public static void showAllNodes(TreeNode node) {
        System.out.println("父节点 ID: " + node.getPid() + ", 节点 ID: " + node.getId() );

        for (TreeNode child : node.getChildren()) {
            showAllNodes(child);
        }
    }

    // 在父节点下添加一个新的子节点
    public static TreeNode addChild(TreeNode pnode) {
        ++max_id;
        int id = max_id;
        TreeNode node = new TreeNode(id, pnode.getId());
        pnode.getChildren().add(node);
        return node;
    }

    // 删除父节点下指定 ID 的子节点
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

    // 判断父节点是否有子节点
    public static boolean HaveChild(TreeNode pnode) {
        return !pnode.getChildren().isEmpty();
    }

    // 在树中查找指定节点的父节点
    public static TreeNode findParent(TreeNode root, int id) {
        if (root==null || !HaveChild(root)) {
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

    // 在父节点下查找指定 ID 的子节点
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

            node = findChild(child, id);
        } while(node == null);
        return node;
    }
}
