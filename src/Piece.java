import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Piece extends Figure {

    public Piece(int x, int y, boolean myPiece) {
        super(x, y, myPiece);
    }

    public LinkedList<Figure> moveTopLeft() {
        if (this.myPiece == true) {
            LinkedList<Figure> nextPiece = new LinkedList<Figure>();
            if (x == 1 || y == 8) {
                return nextPiece;
            }
            if (y + 1 == 8) {
                nextPiece.add(new Queen(x - 1, y + 1, this.myPiece));
            } else {
                nextPiece.add(new Piece(x - 1, y + 1, this.myPiece));
            }
            return nextPiece;
        } else {
            return moveBottomRight();
        }
    }

    public LinkedList<Figure> moveTopRight() {
        if (this.myPiece == true) {
            LinkedList<Figure> nextPiece = new LinkedList<Figure>();
            if (x == 8 || y == 8) {
                return nextPiece;
            }
            if (y + 1 == 8) {
                nextPiece.add(new Queen(x + 1, y + 1, this.myPiece));
            } else {
                nextPiece.add(new Piece(x + 1, y + 1, this.myPiece));
            }
            return nextPiece;
        } else {
            return moveBottomLeft();
        }
    }

    public LinkedList<Figure> moveBottomLeft() {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x == 1 || y == 1) {
            return nextPiece;
        }
        if (y - 1 == 1) {
            nextPiece.add(new Queen(x - 1, y - 1, this.myPiece));
        } else {
            nextPiece.add(new Piece(x - 1, y - 1, this.myPiece));
        }
        return nextPiece;
    }

    public LinkedList<Figure> moveBottomRight() {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x == 8 || y == 1) {
            return nextPiece;
        }
        if (y - 1 == 1) {
            nextPiece.add(new Queen(x + 1, y - 1, this.myPiece));
        } else {
            nextPiece.add(new Piece(x + 1, y - 1, this.myPiece));
        }
        return nextPiece;
    }

    public LinkedList<Figure> beatTopLeft(LinkedList<Figure> beatFigure) {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x <= 2 || y >= 7) {
            return nextPiece;
        }
        if (beatFigure.isEmpty()) {
            return nextPiece;
        }
        if (beatFigure.contains(new Piece(this.x - 1, this.y + 1, !this.myPiece)) && !isBlocked(x - 2, y + 2, beatFigure)) {
            nextPiece.add(new Piece(this.x - 1, this.y + 1, !this.myPiece));
            if (y + 2 == 8) {
                nextPiece.add(new Queen(x - 2, y + 2, this.myPiece));
            } else {
                nextPiece.add(new Piece(x - 2, y + 2, this.myPiece));
            }
        }
        return nextPiece;
    }


    public LinkedList<Figure> beatTopRight(LinkedList<Figure> beatFigure) {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x >= 7 || y >= 7) {
            return nextPiece;
        }
        if (beatFigure.isEmpty()) {
            return nextPiece;
        }
        if (beatFigure.contains(new Piece(this.x + 1, this.y + 1, !this.myPiece)) && !isBlocked(x + 2, y + 2, beatFigure)) {
            nextPiece.add(new Piece(this.x + 1, this.y + 1, !this.myPiece));
            if (y + 2 == 8) {
                nextPiece.add(new Queen(this.x + 2, this.y + 2, this.myPiece));
            } else {
                nextPiece.add(new Piece(this.x + 2, this.y + 2, this.myPiece));
            }
        }
        return nextPiece;
    }

    public LinkedList<Figure> beatBottomLeft(LinkedList<Figure> beatFigure) {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x <= 2 || y <= 2) {
            return nextPiece;
        }
        if (beatFigure.isEmpty()) {
            return nextPiece;
        }
        if (beatFigure.contains(new Piece(this.x - 1, this.y - 1, !this.myPiece)) && !isBlocked(x - 2, y - 2, beatFigure)) {
            nextPiece.add(new Piece(this.x - 1, this.y - 1, !this.myPiece));
            if (y - 2 == 1) {
                nextPiece.add(new Queen(x - 2, y - 2, this.myPiece));
            } else {
                nextPiece.add(new Piece(x - 2, y - 2, this.myPiece));
            }
        }
        return nextPiece;
    }

    public LinkedList<Figure> beatBottomRight(LinkedList<Figure> beatFigure) {
        LinkedList<Figure> nextPiece = new LinkedList<Figure>();
        if (x >= 7 || y <= 2) {
            return nextPiece;
        }
        if (beatFigure.isEmpty()) {
            return nextPiece;
        }
        if (beatFigure.contains(new Piece(this.x + 1, this.y - 1, !this.myPiece)) && !isBlocked(x + 2, y - 2, beatFigure)) {
            nextPiece.add(new Piece(this.x + 1, this.y - 1, !this.myPiece));
            if (y - 2 == 1) {
                nextPiece.add(new Queen(x + 2, y - 2, this.myPiece));
            } else {
                nextPiece.add(new Piece(x + 2, y - 2, this.myPiece));
            }        }
        return nextPiece;
    }

    private boolean isBlocked(int x, int y, LinkedList<Figure> figures) {
        return figures.contains(new Piece(x, y, true)) || figures.contains(new Piece(x, y, false));
    }


    public Piece clone() {
        return new Piece(this.x, this.y, this.myPiece);
    }

    @Override
    public String toString() {
        return "x: " + x + ",  y: " + y + "\n";
    }
}
