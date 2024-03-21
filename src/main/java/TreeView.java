import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TreeView {
    public TreeView() {
    }

    public static StackPane ShowView(TreeNode node) {
        String inputText = node.getContent();
        Text text = new Text(inputText);
        double textWidth = text.getLayoutBounds().getWidth();
        double textHight = text.getLayoutBounds().getHeight();
        Label label = new Label(inputText);
        Rectangle rec = new Rectangle(textWidth + 10.0, textHight + 10.0);
        rec.setFill(Color.TRANSPARENT);
        rec.setStroke(Color.BLACK);
        label.setLayoutX(200.0);
        label.setLayoutY(200.0);
        rec.setLayoutX(200.0);
        rec.setLayoutY(200.0);
        StackPane pane = new StackPane();
        pane.getChildren().addAll(new Node[]{label, rec});
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);
        return pane;
    }
}
