import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class MindMapUtilsTest {

    public static void main(String[] args) {
        testCalculateTextWidth();
        testCalculateTextHeight();
        testCreateLine();
    }

    // 测试计算文本宽度
    public static void testCalculateTextWidth() {
        Font font = new Font("Arial", 12);
        String text = "Hello, World!";
        double width = MindMapUtils.calculateTextWidth(text, font);
        System.out.println("Text width: " + width);
    }

    // 测试计算文本高度
    public static void testCalculateTextHeight() {
        Font font = new Font("Arial", 12);
        double height = MindMapUtils.calculateTextHeight(font);
        System.out.println("Text height: " + height);
    }

    // 测试创建连接线
    public static void testCreateLine() {
        double startX = 10;
        double startY = 20;
        double endX = 30;
        double endY = 40;
        Line line = MindMapUtils.createLine(startX, startY, endX, endY);
        System.out.println("Line created: " + line);
    }
}
