import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MindMapUtils {
    static int nidCounter = 0;

    public MindMapUtils() {
    }

    public static double calculateTextWidth(String text, Font font) {
        Text tempText = new Text(text);
        tempText.setFont(font);
        return tempText.getBoundsInLocal().getWidth();
    }

    public static double calculateTextHeight(Font font) {
        Text tempText = new Text("Text");
        tempText.setFont(font);
        return tempText.getBoundsInLocal().getHeight();
    }

    public static Line createLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(2.0);
        return line;
    }

    public static void handleMouseClicked(MouseEvent event, Pane root) {
        double x = event.getX();
        double y = event.getY();
        if (event.isControlDown()) {
            TreeNode newNode = new TreeNode(0);
            newNode.setX((int)x);
            newNode.setY((int)y);
            createNodeView(newNode, root);
        } else {
            removeNodeAtPosition(x, y, root);
        }

    }

    public static void createNodeView(TreeNode node, Pane root) {
        Rectangle rec = new Rectangle(50.0, 30.0, Color.GRAY);
        rec.setX((double)node.getX());
        rec.setY((double)node.getY());
        Label la = new Label(node.getContent());
        la.setLayoutX((double)(node.getX() + 5));
        la.setLayoutY((double)(node.getY() + 5));
        root.getChildren().add(rec);
        root.getChildren().add(la);
    }

    public static void removeNodeAtPosition(double x, double y, Pane root) {
        root.getChildren().removeIf((node) -> {
            if (node instanceof Rectangle) {
                Rectangle rec = (Rectangle)node;
                double recX = rec.getX();
                double recY = rec.getY();
                double recWidth = rec.getWidth();
                double recHeight = rec.getHeight();
                System.out.println(x + " " + recX + " " + y + " " + recY);
                if (x >= recX && x <= recX + recWidth && y >= recY && y <= recY + recHeight) {
                    root.getChildren().remove(rec);
                    root.getChildren().removeIf((label) -> {
                        return label instanceof Label && root.getChildren().indexOf(label) % 2 == 0;
                    });
                    return true;
                }
            }

            return false;
        });
    }
}
