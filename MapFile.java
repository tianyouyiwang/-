import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;



public class MapFile extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();

        //打开文件
        Button load=new Button("打开文件");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser load = new FileChooser();
                FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("MindMap","*.dt");
                load.getExtensionFilters().add(extensionFilter);
                File file= load.showOpenDialog(stage);
                if(file==null){
                    Alert fail= new Alert((Alert.AlertType.INFORMATION));
                    fail.setTitle(("提示"));
                    fail.setHeaderText(null);
                    fail.setContentText("空文件");
                    fail.show();
                    return;
                }

//                loadfile(file);
            }
        });


        //保存文件
        Button save=new Button("保存文件");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //若思维导图为空 提示+返回
//                if(Tree.empty()){
//                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
//                    fail.setTitle("提示");
//                    fail.setHeaderText(null);
//                    fail.setContentText("文件不存在");
//                    fail.show();
//                    return;
//                }
                FileChooser save = new FileChooser();
                FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("MindMap","*,dt");
                save.getExtensionFilters().add(extensionFilter);
                File file=save.showSaveDialog(stage);
                if (file==null){
                    Alert fail= new Alert((Alert.AlertType.INFORMATION));
                    fail.setTitle(("提示"));
                    fail.setHeaderText(null);
                    fail.setContentText("未选择有效路径");
                    fail.show();
                    return;
                }
               savefile(file,stage);
            }
        });


        //png导出
        Button png = new Button("png");
        png.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //若思维导图为空 提示+返回
//                if(Tree.empty()){
//                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
//                    fail.setTitle("提示");
//                    fail.setHeaderText(null);
//                    fail.setContentText("文件不存在");
//                    fail.show();
//                    return;
//                }
                FileChooser png= new FileChooser();
                FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("png","*.png");
                png.getExtensionFilters().add(extensionFilter);
                File file=png.showSaveDialog(stage);
                if (file==null){
                    Alert fail= new Alert((Alert.AlertType.INFORMATION));
                    fail.setTitle(("提示"));
                    fail.setHeaderText(null);
                    fail.setContentText("请选择有效路径");
                    fail.show();
                    return;
                }
//                picture(file);
            }
        });


        //jpg导出
        Button jpg=new Button("jpg");
        jpg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //若思维导图为空 提示+返回
//                if(Tree.empty()){
//                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
//                    fail.setTitle("提示");
//                    fail.setHeaderText(null);
//                    fail.setContentText("文件不存在");
//                    fail.show();
//                    return;
//                }
                FileChooser jpg= new FileChooser();
                FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("jpg","*.jpg");
                jpg.getExtensionFilters().add(extensionFilter);
                File file=jpg.showSaveDialog(stage);
                if (file==null){
                    Alert fail= new Alert((Alert.AlertType.INFORMATION));
                    fail.setTitle(("提示"));
                    fail.setHeaderText(null);
                    fail.setContentText("请选择有效路径");
                    fail.show();
                    return;
                }
//                picture(file);
            }
        });


        VBox vBox=new VBox();
        vBox.getChildren().addAll(load,save,png,jpg);
        root.getChildren().add(vBox);

        stage.setScene(new Scene(root,500,400));
        stage.show();
    }

    //保存文件
    public void savefile (File  file , Stage stage)  {
        ObjectOutputStream save = null;
        try {
            save=new ObjectOutputStream(new FileOutputStream(file));
            //save.writeObject(Tree);//写入思维导图信息
            save.flush();//缓存区写入

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //非空文件关闭
            if (save!=null){
                try {
                    save.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        String title=file.getName();
        stage.setTitle(title);

    }


    public static void main(String[] args) {
        launch();
    }
}
