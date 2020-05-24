import java.util.LinkedList;

public class Figure implements PieceInterface{
    int x;
    int y;
    boolean myPiece;

    public Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Figure(int x, int y, boolean myPiece){
        this.x = x;
        this.y = y;
        this.myPiece = myPiece;
    }

    @Override
    public LinkedList<Figure> moveTopLeft() {
        return null;
    }

    @Override
    public LinkedList<Figure> moveTopRight() {
        return null;
    }

    @Override
    public LinkedList<Figure> moveBottomLeft() {
        return null;
    }

    @Override
    public LinkedList<Figure> moveBottomRight() {
        return null;
    }

    @Override
    public LinkedList<Figure> beatTopLeft(LinkedList<Figure> beatFigures) {
        return null;
    }

    @Override
    public LinkedList<Figure> beatTopRight(LinkedList<Figure> beatFigures) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        Figure p = (Figure) obj;
        return p.x == this.x && p.y == this.y && this.myPiece == p.myPiece;
    }

    @Override
    public LinkedList<Figure> beatBottomLeft(LinkedList<Figure> beatFigures) {
        return null;
    }

    @Override
    public LinkedList<Figure> beatBottomRight(LinkedList<Figure> beatFigures) {
        return null;
    }

    @Override
    public Figure clone() {
        return null;
    }
}
