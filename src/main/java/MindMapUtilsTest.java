import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class MindMapUtilsTest {
    public MindMapUtilsTest() {
    }

    public static void main(String[] args) {
        testCalculateTextWidth();
        testCalculateTextHeight();
        testCreateLine();
    }

    public static void testCalculateTextWidth() {
        Font font = new Font("Arial", 12.0);
        String text = "Hello, World!";
        double width = MindMapUtils.calculateTextWidth(text, font);
        System.out.println("Text width: " + width);
    }

    public static void testCalculateTextHeight() {
        Font font = new Font("Arial", 12.0);
        double height = MindMapUtils.calculateTextHeight(font);
        System.out.println("Text height: " + height);
    }

    public static void testCreateLine() {
        double startX = 10.0;
        double startY = 20.0;
        double endX = 30.0;
        double endY = 40.0;
        Line line = MindMapUtils.createLine(startX, startY, endX, endY);
        System.out.println("Line created: " + line);
    }
}
