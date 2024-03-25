import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeList 类用于管理树结构的节点列表
 */
public class TreeList {
    // 存储节点的列表
    private static List<TreeNode> list = new ArrayList<>();
    // 记录树的高度
    private static int height = 0;

    /**
     * 向节点列表中添加节点
     * @param node 要添加的节点
     */
    public static void add(TreeNode node){
        list.add(node);
    }

    /**
     * 获取根节点
     * @return 根节点
     */
    public static TreeNode getRoot(){
        TreeNode root = new TreeNode();
        for(int i = 0 ; i < TreeList.list.size(); i++){
            if(TreeList.list.get(i).getPid() == 0){
                root = TreeList.list.get(i);
            }
        }
        return root;
    }

    /**
     * 获取父节点
     * @param node 要获取父节点的节点
     * @return 父节点
     */
    public static TreeNode getParent(TreeNode node){
        TreeNode p_node = new TreeNode();
        for(int i = 0; i < TreeList.list.size(); i++){
            if(TreeList.list.get(i).getPid() == node.getPid()){
                p_node = TreeList.list.get(i);
                return p_node;
            }
        }
        return p_node;
    }

    /**
     * 判断节点是否是父节点的第一个子节点或第二个子节点
     * @param node 要判断的节点
     * @return 是否是第一个子节点或第二个子节点
     */
    public static boolean isFirstChild(TreeNode node){
        TreeNode p_node = TreeList.getParent(node);
        TreeNode l_node = new TreeNode();
        TreeNode r_node = new TreeNode();
        for(int i = 0; i < p_node.getChildren().size(); i++){
            if(p_node.getChildren().get(i).getOrder() == 0){
                l_node  = p_node.getChildren().get(i);
                break;
            }
        }
        for(int i = 0; i < p_node.getChildren().size(); i++){
            if(p_node.getChildren().get(i).getOrder() == 1){
                r_node  = p_node.getChildren().get(i);
                break;
            }
        }
        if(node.getId() == l_node.getId() || node.getId() == r_node.getId()){
            return true;
        }
        return false;
    }

    /**
     * 获取节点的前一个子节点
     * @param node 要获取前一个子节点的节点
     * @return 前一个子节点
     */
    public static TreeNode getPreChild(TreeNode node) {
        TreeNode p_node = TreeList.getParent(node);
        TreeNode pre_node = p_node.getChildren().get(0);
        for(int i = 1; i < p_node.getChildren().size(); i++){
            if(node.getId() == p_node.getChildren().get(i).getId()){
                break;
            }
            if(node.getOrder() == p_node.getChildren().get(i).getOrder()){
                pre_node = p_node.getChildren().get(i);
            }
        }
        return pre_node;
    }

    /**
     * 获取子节点的高度
     * @param p_node 父节点
     * @param order 子节点的顺序
     * @return 子节点的高度
     */
    public static double getChildHeight(TreeNode p_node, int order){
        height = 0;
        if(p_node.getId() == 0){
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0; i < p_node.getChildren().size(); i++){
                if(p_node.getChildren().get(i).getOrder() == order){
                    list.add(p_node.getChildren().get(i));
                }
            }
            for(int i = 0; i < list.size(); i++){
                TreeHeight(list.get(i));
                if(i < list.size() - 1){
                    //height +=  NodeLocater.marginY;  需要位置分配函数
                }
            }
        }
        else {
            TreeHeight(p_node);
        }
        return height;
    }

    /**
     * 递归计算节点的高度
     * @param p_node 要计算高度的节点
     */
    private static void TreeHeight(TreeNode p_node){
        for(int i = 0; i < p_node.getChildren().size(); i++){
            new TreeNode();
            TreeNode node = p_node.getChildren().get(i);
            if(!node.getChildren().isEmpty()){
                TreeHeight(node);
            }
            else {
                // 待完成
            }
        }
    }
}
