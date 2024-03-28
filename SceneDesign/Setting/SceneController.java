package Setting;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    TreeView treeView;
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
        treeView.setPrefWidth(rightPane.getWidth());
        treeView.setPrefHeight(rightPane.getHeight());
        label.setLayoutX(rightPane.getWidth()/2-label.getWidth()/2);//不是居中，改
        toolBar.setPrefWidth(leftPane.getWidth());
    }
    //打开文件设置目录
    public void openFilesSetting(){
        Files.setItems(FXCollections.observableArrayList("New Document","Open","Save","Save as"));
        //String[] testing= new String[]{"option1","option2","option3","option4"};
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
}
