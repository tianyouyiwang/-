import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
    @FXML
    private TreeView<?> treeView;

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
        // 在这里编写添加节点的逻辑
        if(current_node == null){
            TreeNode r_node = new TreeNode(0);
            TreeUtil.setRoot(r_node);
            AnchorPane Pane = r_node.getPane();
            current_node = r_node;
            leftPane.getChildren().add(Pane);
        }
        else {
            TreeNode node = TreeUtil.addChild(current_node);
            // 获取子节点的 pane，并将其添加到 leftPane 中
            AnchorPane childPane = node.getPane();
            current_node = node;
            leftPane.getChildren().add(childPane);
        }
        System.out.println("添加节点按钮被点击了！");
    }
    @FXML
    public void initialize() {
        // 为TreeView添加鼠标点击事件处理程序
        System.out.println("fseh");
        treeView.setOnMouseClicked(event -> {
            // 获取鼠标点击的TreeItem
            handleTreeViewClick(event);
        });
    }
    public void handleTreeViewClick(MouseEvent mouseEvent) {
        System.out.println("fseh");
        current_node = MouseUtils.MC_getNode(mouseEvent); // 获取点击的节点

        if (current_node != null) {
            System.out.println("当前点击的节点：" + current_node.getContent());
        }

        // 添加文本
        Text text = new Text("Double click to edit");
        text.setLayoutX(mouseEvent.getX() + 10);
        text.setLayoutY(mouseEvent.getY() + 10);
        if (mouseEvent.getClickCount() == 2) {
            // 在这里打开一个文本编辑框或弹出一个对话框来编辑文本
            text.setText("Editable text");
        }
    }

    @FXML
    private void deleteNode(ActionEvent event) {
        // 获取当前选中的TreeItem
        TreeItem<String> selectedItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        // 如果选中的节点不为空，则从TreeView中删除它
        if (selectedItem != null) {
            selectedItem.getParent().getChildren().remove(selectedItem);
        }
    }
}
