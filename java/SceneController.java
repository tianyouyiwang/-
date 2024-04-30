import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicReference;

public class SceneController {
   //绑定属性
    @FXML
    SplitPane AncestorPane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    AnchorPane leftPane;
    @FXML
    AnchorPane rightPane;
    @FXML
    Pane treestructure;
    @FXML
    Label label;
    @FXML
    ToolBar toolBar;
    @FXML
    ChoiceBox Files;
    @FXML
    ChoiceBox setNodes;
    @FXML
    Label exportFiles,New,saveFiles,openFiles;


    //将子场景大小绑定于父场景，自适应窗口大小
    public void bingPane(){
        scrollPane.setPrefWidth(leftPane.getWidth());
        scrollPane.setPrefHeight(leftPane.getHeight());
        treestructure.setPrefWidth(rightPane.getWidth());
        treestructure.setPrefHeight(rightPane.getHeight());
        label.setLayoutX(rightPane.getWidth()/2-label.getWidth()/2);//不是居中，改
        toolBar.setPrefWidth(leftPane.getWidth());
    }
    //打开文件设置目录
    public void openFilesSetting(){
        Files.setItems(FXCollections.observableArrayList("New Document","Open","Save","Save as"));
        String[] testing= new String[]{"option1","option2","option3","option4"};
        Files.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
               // label.setText(testing[t1.intValue()]);
                //设置不同选项的方法接口
                switch (t1.intValue())
                {
                    //新建文件
                    case 0:
                    //打开文件
                    case 1:
                    //保存文件
                    case 2:
                    //保存文件到
                    case  3:

                }
            }
        });
    }

    //打开设置节点样式选项目录
    public void openNodeSetting(){
        setNodes.setItems(FXCollections.observableArrayList("添加节点","删除节点","标签","撤销","历史记录","筛选节点"));
    }
    private TreeNode current_node;
    public void addNode(ActionEvent event) {
        // 添加节点
        if(current_node == null){
            TreeNode r_node = new TreeNode(0,null);
            TreeUtil.setRoot(r_node);
            current_node = r_node;
            TreeUtil.setRoot(r_node);
            //System.out.println("111");
        }
        else {
            TreeNode node = TreeUtil.addChild(current_node);
            current_node = node;
        }
        Group treeScene = TreeDrawer.drawTree(TreeUtil.getRoot());
        leftPane.getChildren().add(treeScene); // 将 treeScene 添加到 leftPane 中
        //System.out.println("当前添加的节点：" + current_node.getId());
        System.out.println("添加后：");
        TreeUtil.printNodeIds(TreeUtil.getRoot());
    }
    @FXML
    public void initialize() {
        // 为TreeView添加鼠标点击事件处理程序
        System.out.println("fseh");
        treestructure.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());//

        leftPane.setOnMouseClicked(event -> {
            // 获取鼠标点击的TreeItem
            handleTreeViewClick(event);
        });
    }
    public void handleTreeViewClick(MouseEvent mouseEvent) {
        //System.out.println("fnhh");
        if(MouseUtils.MC_getNode(mouseEvent)!=null)
            current_node = MouseUtils.MC_getNode(mouseEvent); // 获取点击的节点

//        if (current_node != null) {
//            System.out.println("当前点击的节点：" + current_node.getId());
//        }
        else {
            System.out.println("null");
        }

        // 添加文本
    }

    @FXML
    private void deleteNode(ActionEvent event) {
        if(current_node == null){
            System.out.println("当前没有节点");
            return;
        }
        TreeNode next_node = null;
        // 清除当前节点的 Pane 显示
//        if (current_node != null) {
//            leftPane.getChildren().remove(current_node.getPane());
//        }

        next_node = current_node.getParent();
        TreeUtil.delete(current_node.getId());
        current_node = next_node;
        // 清除 leftPane 中的所有子节点
        //leftPane.getChildren().removeIf(node -> node instanceof Group);
        // leftPane.getChildren().clear();
        if(current_node == null) {
            for (Node node : leftPane.getChildren()) {
                if (node instanceof Group) {
                    leftPane.getChildren().remove(node);
                }
            }
        }
        // 重新绘制整个树
        Group treeScene = TreeDrawer.drawTree(TreeUtil.getRoot());
        leftPane.getChildren().add(treeScene);
        // 打印树
        System.out.println("删除后：");
        TreeUtil.printNodeIds(TreeUtil.getRoot());
    }
}
