package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ToggleGroup;
public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;
    private ToggleGroup toolGroup;

    @FXML
    public void initialize() {
        toolGroup = new ToggleGroup();
        pen.setToggleGroup(toolGroup);
        eraser.setToggleGroup(toolGroup);
        pen.setSelected(true);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = eraser.isSelected() ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().removeIf(node -> node instanceof Circle);
    }

}