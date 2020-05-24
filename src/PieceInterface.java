import java.util.LinkedList;

public interface PieceInterface {
    LinkedList<Figure> moveTopLeft();
    LinkedList<Figure> moveTopRight();
    LinkedList<Figure> moveBottomLeft();
    LinkedList<Figure> moveBottomRight();

    LinkedList<Figure> beatTopLeft(LinkedList<Figure> beatFigures);
    LinkedList<Figure> beatTopRight(LinkedList<Figure> beatFigures);
    LinkedList<Figure> beatBottomLeft(LinkedList<Figure> beatFigures);
    LinkedList<Figure> beatBottomRight(LinkedList<Figure> beatFigures);

    Figure clone();
}
