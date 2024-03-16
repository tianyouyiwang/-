import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class MainTest extends Application{
    public static void main(String[]args){
        Application.launch(args);
    }

    // 首先出现，可以做一段开场动画
    @Override
    public void init() throws Exception{
        super.init();
    }

    // 其次出现，为程序主要展示部分
    @Override
    public void start(Stage stage) throws Exception{
        // 定义标签
        Label label = new Label("请选择布局模式！");
        label.setStyle("-fx-background-color: yellow; -fx-border-color: blue; -fx-border-width: 3px");
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(200);
        label.setPrefHeight(50);
        // 使组件不显示
//        label.setVisible(false);
        // 设置透明度
        label.setOpacity(0.5);
        // 设置旋转
        label.setRotate(90);
        // 移动
//        label.setTranslateX(6);

        label.setLayoutX(200);
        label.setLayoutY(200);

        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.GREY);

        //定义按钮
        Button button_left = new Button("左侧布局");
        Button button_middle = new Button("默认布局");
        Button button_right = new Button("右侧布局");
        button_left.setLayoutX(150);
        button_left.setLayoutY(250);
        button_left.setPrefWidth(100);
        button_left.setPrefHeight(50);
        button_middle.setLayoutX(250);
        button_middle.setLayoutY(250);
        button_right.setLayoutX(350);
        button_right.setLayoutY(250);

        // 设置组件
        //BorderPane pane = new BorderPane();
        AnchorPane pane = new AnchorPane();
        //pane.setTop(label);
        pane.getChildren().addAll(circle,label,button_left,button_middle,button_right);
        // 设置场景
        Scene scene = new Scene(pane, 600, 500);

        // 利用属性绑定使组件随窗口大小变化而变化
//        label.centerShapeProperty().bind(sce)
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));

        // 设置监听器
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x轴中心改变了，原来是："+oldValue);
            }
        });


//        //设置按钮事件
//        button.setOnAction(e->{
//            getHostServices().showDocument("www.caiguang.cc");
//        });

        button_left.setOnAction(
                event -> {
                    stage.close();
                    Stage stage_left = new Stage();
                    stage_left.setHeight(700);
                    stage_left.setWidth(900);
                    stage_left.initModality(Modality.APPLICATION_MODAL);
                    // None 非模态
                    // WINDOW_MODAL 仅不能使用父窗口
                    // stage.initOwner(stage); // 设置父窗口
                    // APPLICATION_MODAL 全局模态（只能用当前窗口）
                    Button button_new_point = new Button("创建新节点");
                    button_new_point.setLayoutX(150);
                    button_new_point.setLayoutY(100);
                    button_new_point.setPrefWidth(100);
                    button_new_point.setPrefHeight(50);
                    AnchorPane pane_left = new AnchorPane();
                    pane_left.getChildren().addAll(button_new_point);
                    Scene scene_left = new Scene(pane_left);
                    stage_left.setScene(scene_left);
                    button_new_point.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Rectangle point = new Rectangle();
                            point.setHeight(50);
                            point.setWidth(100);
                            point.setLayoutX(150);
                            point.setLayoutY(200);
                        }
                    });
                    stage_left.show();
                    // 取消操作系统默认退出事件
                    Platform.setImplicitExit(false);
                    // 取消关闭窗口动作（即无法退出）
                    stage_left.setOnCloseRequest(event1 -> {
                        event1.consume();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("退出程序");
                        alert.setHeaderText(null);
                        alert.setContentText("当前文件尚未保存，您是否要退出程序？");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK){
                            Platform.exit();
                        }

                    });
                }
        );




        // 设置鼠标光标
//        scene.setCursor(new ImageCursor(new Image("src/a.jpeg")));

        // 将场景放入舞台
        stage.setScene(scene);

        stage.setTitle("ybj的测试窗口");
//        stage.getIcons().add(new Image("src/main/resources/a.jpeg"));

        // 取消自由缩放
//        stage.setResizable(false);

        // 窗口样式
        stage.initStyle((StageStyle.DECORATED));
        // UNDECORATE 无装饰
        // TRANSPARENT 透明装饰
        // UTILITY 简单装饰
        stage.show();
    }

    // 最后出现，可以做出收尾动画或自动保存
    @Override
    public void stop()throws Exception{
        super.stop();
    }

}

