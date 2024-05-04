import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FileExport {
    ScrollPane root;
    //输入思维导图所在的pane，主界面scene，截屏参数x，y
    public FileExport(ScrollPane root) {
        this.root = root;
    }




    public void export(){
        //设置可写图像对象
        WritableImage writableImage = new WritableImage((int)root.getWidth(),(int)root.getHeight());
        //设置截图对象
        SnapshotParameters params = new SnapshotParameters();
        //背景设为透明
        params.setFill(Color.TRANSPARENT);
        //截图
        root.snapshot(params,writableImage);
        //保存为图片文件（注意此处路径，后期可修改为具体可更改路径）
        File file = new File("File/image.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage,null),"png",file);
            System.out.println("导出成功！");
        }catch (IOException e){
            System.out.println("导出失败"+e.getMessage());
        }
    }
}
