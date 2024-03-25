public class datatest {
    public datatest() {
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, -1); // 创建根节点

        // 创建第二层节点
        for (int i = 1; i <= 10; ++i) {
            TreeNode child = TreeUtil.addChild(root); // 在根节点下添加子节点

            // 创建第三层节点
            for (int j = 1; j <= 10; ++j) {
                TreeUtil.addChild(child); // 在第二层节点下添加子节点
            }
        }

        // 显示树的结构
        //TreeUtil.showChild(root);
        TreeUtil.showAllNodes(root); // 显示所有节点
    }
}
