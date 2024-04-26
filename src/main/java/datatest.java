import java.util.Objects;

public class datatest {
    public datatest() {
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        for(int i = 1; i <= 10; ++i) {
            TreeUtil.addChild(root);

            for(int j = 1; j <= 10; ++j) {
                TreeNode pnode = TreeUtil.findChild(root, i);
                if(pnode!=null)TreeUtil.addChild(pnode);
            }
        }

        TreeNode n = TreeUtil.findParent(root, 30);
        System.out.println(n.getContent());
    }
}

