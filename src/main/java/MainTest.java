import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainTest extends Application {
    public MainTest() {
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void init() throws Exception {
        super.init();
    }

    public void start(Stage stage) throws Exception {
        // 创建标签
        Label label = new Label("请选择布局模式！");
        label.setStyle("-fx-background-color: yellow; -fx-border-color: blue; -fx-border-width: 3px");
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(200.0);
        label.setPrefHeight(50.0);
        label.setOpacity(0.5);
        label.setRotate(90.0);
        label.setLayoutX(200.0);
        label.setLayoutY(200.0);

        // 创建圆形
        Circle circle = new Circle();
        circle.setCenterX(250.0);
        circle.setCenterY(250.0);
        circle.setRadius(100.0);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.GREY);

        // 创建按钮
        Button button_left = new Button("左侧布局");
        Button button_middle = new Button("默认布局");
        Button button_right = new Button("右侧布局");
        button_left.setLayoutX(150.0);
        button_left.setLayoutY(250.0);
        button_left.setPrefWidth(100.0);
        button_left.setPrefHeight(50.0);
        button_middle.setLayoutX(250.0);
        button_middle.setLayoutY(250.0);
        button_right.setLayoutX(350.0);
        button_right.setLayoutY(250.0);

        // 创建面板并添加子节点
        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(new Node[]{circle, label, button_left, button_middle, button_right});

        // 创建场景
        Scene scene = new Scene(pane, 600.0, 500.0);
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));

        // 监听圆形x轴中心值变化
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x轴中心改变了，原来是：" + oldValue);
            }
        });

        // 按钮事件处理
        button_left.setOnAction((event) -> {
            // 关闭当前窗口
            stage.close();

            // 创建新窗口
            Stage stage_left = new Stage();
            stage_left.setHeight(700.0);
            stage_left.setWidth(900.0);
            stage_left.initModality(Modality.APPLICATION_MODAL);

            // 创建按钮
            Button button_new_point = new Button("创建新节点");
            button_new_point.setLayoutX(150.0);
            button_new_point.setLayoutY(100.0);
            button_new_point.setPrefWidth(100.0);
            button_new_point.setPrefHeight(50.0);

            // 创建面板并添加子节点
            AnchorPane pane_left = new AnchorPane();
            pane_left.getChildren().addAll(new Node[]{button_new_point});
            Scene scene_left = new Scene(pane_left);
            stage_left.setScene(scene_left);

            // 处理按钮点击事件
            button_new_point.setOnMouseClicked((event1) -> {
                TreeNode node = new TreeNode();
                StackPane pane1 = TreeView.ShowView(node);
                // 创建新结点
            });

            button_new_point.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Rectangle point = new Rectangle();
                    point.setHeight(50.0);
                    point.setWidth(100.0);
                    point.setLayoutX(150.0);
                    point.setLayoutY(200.0);
                }
            });

            stage_left.show();
            Platform.setImplicitExit(false);

            // 监听窗口关闭事件
            stage_left.setOnCloseRequest((event1) -> {
                event1.consume();
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("退出程序");
                alert.setHeaderText((String)null);
                alert.setContentText("当前文件尚未保存，您是否要退出程序？");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            });
        });

        // 设置舞台
        stage.setScene(scene);
        stage.setTitle("ybj的测试窗口");
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    public void stop() throws Exception {
        super.stop();
    }
}
