package Setting.resource;

/*
//舞台的基本操作

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("你好");//设置窗口标题
       primaryStage.getIcons().add(new Image("resources/图标.png"));//设置图标，注意这样写路径要放在同源文件夹下
        primaryStage.setResizable(false);//窗口不可缩放大小
        primaryStage.initStyle(StageStyle.DECORATED);//设置舞台样式
        primaryStage.initModality(Modality.NONE);第一种：打开新窗口时其他窗口仍可使用
        primaryStage.initModality(Modality.APPLICATION_MODAL);第二种：打开新窗口时其他窗口不可使用
        primaryStage.initModality(Modality.WINDOW_MODAL);第三种，只有父窗口不可使用，其他窗口均可使用
        primaryStage.show();//展示舞台
        primaryStage.close();//强制关闭窗口，但是程序仍在运行

        //Event事件，展示窗口关闭事件
        Platform.setImplicitExit(false);//关闭系统默认关闭功能
        primaryStage.setOnCloseRequest(event ->{
            event.consume();//关闭窗口默认关闭功能
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);//设置提示框
            alert.setTitle("退出程序");
            alert.setHeaderText(null);
            alert.setContentText("您是否要退出程序？");

            Optional<ButtonType> result =alert.showAndWait();
            if(result.get()== ButtonType.OK){
                Platform.exit();//退出程序
                //primaryStage.close();仅关闭窗口,程序仍在运行
            }
        });
    }
}
*/



//Scene场景
/*
public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
public void start(Stage primaryStage) throws Exception{
        Button button0 = new Button("Hello World!");//新建按钮放置在场景scene中
        button0.setLayoutX(200);
        button0.setLayoutY(200);

        Button button1 = new Button("返回原场景");//设置第二个按钮
        button1.setLayoutY(200);
        button1.setLayoutX(200);

        AnchorPane root = new AnchorPane();//设置第一个场景
        root.getChildren().addAll(button0);
        Scene scene = new Scene(root,500,500);

        Label label =new Label("你好，JavaFx");//新建标签放置在第二个场景
        label.setLayoutX(200);
        label.setLayoutY(200);

        AnchorPane root1 = new AnchorPane();//设置第二个场景
        root1.getChildren().addAll(label, button1);
        Scene scene1 = new Scene(root1,500,500);
        scene1.setCursor(new ImageCursor(new Image("resources/鼠标图标.png")));//设置鼠标图标

        button0.setOnAction(event->{        //点击按钮切换不同场景
            primaryStage.setScene(scene1);
        } );
        button1.setOnAction(event->{
            primaryStage.setScene(scene);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.getIcons().add(new Image("resources/图标.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
*/

/*
//Node UI控件 属性 通用
//*layoutX/layoutY/preWidth/preHeight
//*style/visible//opacity/blendMode
//*TranslateX/TranslateY/rotate/scaleX/scaleY/scaleZ -> 3D移动
//*parent/scene/id

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
public void start(Stage primaryStage) throws Exception{
        Label label = new Label("Hello World!");
        label.setLayoutY(200);
        label.setLayoutX(200);
        label.setStyle("-fx-background-color:#ffffff; -fx-border-color:#000000;-fx-border-width:3px");//设置样式，背景颜色以及边框宽度与颜色
        label.setPrefWidth(200);//设置框的宽度
        label.setPrefHeight(50);//设置框的高度
        label.setAlignment(Pos.CENTER);//设置框内字居中
        //label.setVisible(false);设置该场景是否显示，false为不显示，默认显示
        //label.setBlendMode();设置控件叠加是是否混合
        //label.setOpacity();设置透明度值0-1
        //label.setRotate(90);设置控件旋转角度
        //label.setTranslateX(60);横着移动，改变坐标
        //label.setTranslateY();竖着移动，改变坐标
        AnchorPane root = new AnchorPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
 */

/*
//UI控件的属性绑定及属性监听
public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
public  void start(Stage primaryStage) throws Exception{
        AnchorPane root= new AnchorPane();//创建场景类
        Scene scene = new Scene(root,500,500);
        Circle circle = new Circle();//设置一个圆及其属性
       // circle.setCenterX(250);
       // circle.setCenterY(250);
        circle.setRadius(100);
       // circle.setStroke(BLACK);
        //circle.setFill(WHITE);
        //属性绑定
        circle.centerXProperty().bind(scene.widthProperty().divide(2));//圆的x坐标永远对齐框的宽度的一半位置，divide表示除
        circle.centerYProperty().bind(scene.heightProperty().divide(2));//即圆会随着框改变而改变
        //属性监听器的设置
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number old_value, Number new_value) {
                System.out.println("x轴中心点改变了，原来是"+old_value+"现在是"+new_value);//当x坐标改变，打印输出语句
            }
        });
        root.getChildren().add(circle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
*/


/*
//事件驱动编程
public class Main extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public  void start(Stage primaryStage) throws Exception{
        AnchorPane root = new AnchorPane();             //设置场景
        Scene scene = new Scene(root,500,500);

//        Label label = new Label("Hello World!");    //设置标签
//        label.setLayoutX(200);
//        label.setLayoutY(200);
//        Button button = new Button("向上移动");      //设置按钮
//        button.setLayoutX(300);
//        button.setLayoutY(200);
//        root.getChildren().addAll(label,button);

//        button.setOnAction(new EventHandler<ActionEvent>() {    //设置按钮事件，点击按钮时label标签上移
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                label.setLayoutY(label.getLayoutY()-5);
//            }
//        });

//        scene.setOnKeyReleased(keyEvent -> {                    //设置键盘事件，当键盘按下下键时，label标签下移
//            KeyCode keyCode = keyEvent.getCode();
//            if(keyCode.equals(KeyCode.DOWN)){
//                label.setLayoutY(label.getLayoutY()+5);
//            }
//        });

        TextField textField= new TextField();
        textField.setLocation(150,200);
        textField.add(event->{                  //拖拽事件有误，查
            event.acc
        })
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

 */

/*
//Color Font Image
public class Main extends Application{
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    //Color 属性
//        Circle circle = new Circle();
//        circle.setCenterY(250);
//        circle.setCenterX(250);
//        circle.setRadius(100);
//        circle.setFill(Color.rgb(255,0,0));//设置填充色,还可使用Color.web("#f66a08")表示
//        circle.setStrokeWidth(10);//设置边框宽度
//        circle.setStroke(Color.BLUE);//设置边框颜色
//  Font(字体 属性
//        Label label = new Label("你好！世界");
//        label.setLayoutY(200);
//        label.setLayoutX(150);
//        label.setFont(Font.font("楷体", FontWeight.NORMAL,30));//设置字体样式，字体宽度，字体大小，若该样式系统没有需要使用函数导入文件


        //Image 属性
//        ImageView imageView = new ImageView(new Image("resources/图标.png"));
//        //或者以下用法也可
////        ImageView imageView = new ImageView();
////        Image image = new Image("resources/图标.png");
////        imageView.setImage(image);
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(100);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

 */

/*
//FXML布局文件使用 demo.fxml，编辑组件按钮 DemoController 编辑事件
public class Main extends Application{

    static  private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("界面设计测试版.fxml"));
        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

 */



/*
//在主线程中使用controller控制控件
public class Main extends Application{

    public static  void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader();
       fxmlLoader.setLocation(getClass().getResource("demo.fxml"));
       Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        DemoController controller = fxmlLoader.getController();
        controller.circleLocationBind(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

 */

/*
//JavaFx 多线程
//新建线程
Thread thread = new Thread(()->{
    String newValue =  "你好";

    label.setText(newValue);//错误，不可以在非FX application线程中更新UI控件
    //使用FX application 提供的方法来更新UI控件,如下
    Platform.runLater(()->{
        label.setText(newValue);
    });
}

 */

/*
//Canvas画布控件
public class Main extends Application{
    public static final int WIDTH = 800,HEIGHT = 600;
    private Canvas canvas = new Canvas();
    private Graphics graphics = canvas.getGraphics();


    public static  void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception{
        canvas.setBounds(0,0,WIDTH,HEIGHT);

        AnchorPane root = new AnchorPane(canvas);
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
        primarystage.show();
    }
}

 */


//media多媒体元素

