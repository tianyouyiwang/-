import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

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
    @FXML
    public void addNode(ActionEvent event) {
        // 清除旧的节点
        leftPane.getChildren().removeIf(node -> node instanceof Group);

        // 添加新的节点
        if(current_node == null){
            TreeNode r_node = new TreeNode(0,null);
            TreeUtil.setRoot(r_node);
            current_node = r_node;
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
        // 为 Group 添加鼠标点击事件处理程序
        leftPane.setOnMouseClicked(event -> {
            if (event.getTarget() instanceof Group) {
                // 如果点击事件发生在 Group 上，则输出 "Yes"
                System.out.println("Yes");
            }
            else {
                System.out.println("no");
            }
        });
    }
    public void handleTreeViewClick(MouseEvent mouseEvent) {
        TreeNode node = MouseUtils.MC_getNode(mouseEvent);
        if(node!=null)
            current_node = node; // 获取点击的节点
//        if (current_node != null) {
//            System.out.println("当前点击的节点：" + current_node.getId());
//        }
        else {
            System.out.println("null");
        }

        if (current_node!=null&&mouseEvent.getClickCount() == 2) {
            //新建一个文本编辑提示框
            Pane editPane = new Pane();
            //设置提示框的宽高以及输出位置
            editPane.setPrefWidth(274);
            editPane.setPrefHeight(119);
            //设置动态输出于左场景中央位置
            editPane.setLayoutX(leftPane.getPrefWidth()/2-editPane.getWidth()/2);
            editPane.setLayoutY(leftPane.getPrefHeight()/2-editPane.getHeight()/2);
//            //设置边框样式于editname.css文件中
//            editPane.getStylesheets().add("border-editpane-style");
            // 设置边框宽度
            BorderWidths borderWidths = new BorderWidths(3);
            CornerRadii cornerRadii = new CornerRadii(10);
            // 设置边框颜色
            BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cornerRadii, borderWidths);

            // 创建边框
            Border border = new Border(borderStroke);
            editPane.setBorder(border);
            //设置提示框里面所需控件：文本编辑框，标签，按钮
            Label alart = new Label();
            alart.setText("更改文本内容");
            //设置字体大小
            alart.setFont(new Font(24));
            //设置输出位置
            alart.setLayoutX(8);
            alart.setLayoutY(7);
            //设置文本编辑框
            TextField editbox = new TextField();
            editbox.setPrefWidth(160);
            editbox.setPrefHeight(23);
            editbox.setLayoutX(57);
            editbox.setLayoutY(48);
            editbox.setPromptText("请输入新的文本内容");
            //设置点击按钮
            //确定
            Button button_yes = new Button();
            button_yes.setText("确定");
            button_yes.setLayoutX(57);
            button_yes.setLayoutY(82);
            //取消
            Button button_no = new Button();
            button_no.setText("取消");
            button_no.setLayoutX(178);
            button_no.setLayoutY(82);
//            text.setText("Editable text");
            editPane.getChildren().addAll(alart,editbox,button_yes,button_no);
            leftPane.getChildren().add(editPane);
            //添加点击“确定”按钮事件
            button_yes.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String content = editbox.getText();
                    TreeNode.UpdateNode(current_node, content);
                    // 移除编辑面板
                    leftPane.getChildren().remove(editPane);
                    // 清除 leftPane 中的所有 Group，准备重新绘制树
                    leftPane.getChildren().removeIf(node -> node instanceof Group);
                    // 重新绘制整个树
                    Group treeScene = TreeDrawer.drawTree(TreeUtil.getRoot());
                    // 将新的树场景图添加到 leftPane
                    leftPane.getChildren().add(treeScene);
                }
            });
            //添加点击“取消”按钮事件
            button_no.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    leftPane.getChildren().remove(editPane);
                }
            });
        }
    }

    @FXML
    private void deleteNode(ActionEvent event) {
        if(current_node == null){
            System.out.println("当前没有节点");
            return;
        }
        TreeNode next_node;

        next_node = current_node.getParent();
        TreeUtil.delete(current_node.getId());
        current_node = next_node;

        if(current_node == null) {
            for (Node node : leftPane.getChildren()) {
                if (node instanceof Group) {
                    leftPane.getChildren().remove(node);
                }
            }
        }

        // 重新绘制整个树
        Group treeScene = TreeDrawer.drawTree(TreeUtil.getRoot());
        leftPane.getChildren().removeIf(node -> node instanceof Group);
        leftPane.getChildren().add(treeScene);
        // 打印树
        System.out.println("删除后：");
        TreeUtil.printNodeIds(TreeUtil.getRoot());
    }
    //文件操作
    @FXML
    private  void saveFile(){
        Files.setOnAction(event -> {
            //获取当前值
            System.out.println(Files.getValue());
            String value = (String) Files.getValue();
            switch (value){
                //导出文件
                case "Export":
                    System.out.println("正在导出思维导图为图片");
                    FileExport fileSave = new FileExport(scrollPane);
                    fileSave.export();
                    break;
            }
        });
    }

    public void showNode(ActionEvent actionEvent) {
        System.out.println(current_node);
    }
}
