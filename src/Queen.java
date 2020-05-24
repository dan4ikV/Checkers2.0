import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Queen extends Figure {
    public Queen(int x, int y, boolean myPiece) {
        super(x, y, myPiece);
    }

    public Queen(Piece p) {
        super(p.x, p.y);
    }

    @Override
    public LinkedList<Figure> moveTopLeft() {
        LinkedList<Figure> steps = new LinkedList<Figure>();
        int tempX = x - 1;
        int tempY = y + 1;
        while (tempX > 1 || tempY < 8) {
            steps.add(new Queen(tempX, tempY, this.myPiece));
            tempX--;
            tempY++;
        }
        return steps;
    }

    @Override
    public LinkedList<Figure> moveTopRight() {
        LinkedList<Figure> steps = new LinkedList<Figure>();
        int tempX = x + 1;
        int tempY = y + 1;
        while (tempX < 8 || tempY < 8) {
            steps.add(new Queen(tempX, tempY, this.myPiece));
            tempX++;
            tempY++;
        }
        return steps;
    }

    @Override
    public LinkedList<Figure> moveBottomLeft() {
        LinkedList<Figure> steps = new LinkedList<Figure>();
        int tempX = x - 1;
        int tempY = y - 1;
        while (tempX > 1 || tempY > 1) {
            steps.add(new Queen(tempX, tempY, this.myPiece));
            tempX--;
            tempY--;
        }
        return steps;
    }

    @Override
    public LinkedList<Figure> moveBottomRight() {
        LinkedList<Figure> steps = new LinkedList<Figure>();
        int tempX = x + 1;
        int tempY = y - 1;
        while (tempX < 8 || tempY > 1) {
            steps.add(new Queen(tempX, tempY, this.myPiece));
            tempX++;
            tempY--;
        }
        return steps;
    }

    @Override
    public LinkedList<Figure> beatTopLeft(LinkedList<Figure> beatFigures) {
        LinkedList<Figure> positions = new LinkedList<>();
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Comparator<Figure> comparator = new Comparator<>() {
            @Override
            public int compare(Figure f1, Figure f2) {
                if (f1.x > f2.x) {
                    return 1;
                } else if (f1.x < f2.x) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Iterator<Figure> iter = beatFigures.iterator();
        while (iter.hasNext()){
            if(iter.next().x > x){
                iter.remove();
            }
        }

        if (beatFigures.isEmpty()) {
            return positions;
        }
        Collections.sort(beatFigures, comparator);
        if (beatFigures.isEmpty()) {
            return positions;
        }
        if (beatFigures.get(0).myPiece == this.myPiece) {
            return positions;
        } else {
            positions.add(beatFigures.get(0));
        }
        int tempX = beatFigures.get(0).x;
        int tempY = beatFigures.get(0).y;
        if (beatFigures.size() == 1) {
            Queen queen = new Queen(tempX, tempY, myPiece);
            positions.addAll(queen.moveTopLeft());
            return positions;
        } else {
            tempX--;
            tempY++;
            positions.add(beatFigures.get(0));
            while (tempX > this.x) {
                positions.add(new Queen(tempX, tempY, myPiece));
                tempX--;
                tempY++;
            }
        }
        return positions;
    }

    @Override
    public LinkedList<Figure> beatTopRight(LinkedList<Figure> beatFigures) {
        LinkedList<Figure> positions = new LinkedList<>();
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Comparator<Figure> comparator = new Comparator<>() {
            @Override
            public int compare(Figure f1, Figure f2) {
                if (f1.x < f2.x) {
                    return 1;
                } else if (f1.x > f2.x) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Iterator<Figure> iter = beatFigures.iterator();
        while (iter.hasNext()){
            if(iter.next().x < x){
                iter.remove();
            }
        }
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Collections.sort(beatFigures, comparator);

        if (beatFigures.get(0).myPiece == this.myPiece) {
            return positions;
        } else {
            positions.add(beatFigures.get(0));
        }
        int tempX = beatFigures.get(0).x;
        int tempY = beatFigures.get(0).y;
        if (beatFigures.size() == 1) {
            Queen queen = new Queen(tempX, tempY, myPiece);
            positions.addAll(queen.moveTopRight());
            return positions;
        } else {
            tempX++;
            tempY++;
            positions.add(beatFigures.get(0));
            while (tempX < this.x) {
                positions.add(new Queen(tempX, tempY, myPiece));
                tempX++;
                tempY++;
            }
        }
        return positions;
    }

    @Override
    public LinkedList<Figure> beatBottomLeft(LinkedList<Figure> beatFigures) {
        LinkedList<Figure> positions = new LinkedList<>();
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Comparator<Figure> comparator = new Comparator<>() {
            @Override
            public int compare(Figure f1, Figure f2) {
                if (f1.x > f2.x) {
                    return 1;
                } else if (f1.x < f2.x) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Iterator<Figure> iter = beatFigures.iterator();
        while (iter.hasNext()){
            if(iter.next().x > x){
                iter.remove();
            }
        }
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Collections.sort(beatFigures, comparator);
        if (beatFigures.get(0).myPiece == this.myPiece) {
            return positions;
        } else {
            positions.add(beatFigures.get(0));
        }
        int tempX = beatFigures.get(0).x;
        int tempY = beatFigures.get(0).y;
        if (beatFigures.size() == 1) {
            Queen queen = new Queen(tempX, tempY, myPiece);
            positions.addAll(queen.moveBottomLeft());
            return positions;
        } else {
            tempX--;
            tempY--;
            positions.add(beatFigures.get(0));
            while (tempX > this.x) {
                positions.add(new Queen(tempX, tempY, myPiece));
                tempX--;
                tempY--;
            }
        }
        return positions;
    }

    @Override
    public LinkedList<Figure> beatBottomRight(LinkedList<Figure> beatFigures) {
        LinkedList<Figure> positions = new LinkedList<>();
        if (beatFigures.isEmpty()) {
            return positions;
        }
        Comparator<Figure> comparator = new Comparator<>() {
            @Override
            public int compare(Figure f1, Figure f2) {
                if (f1.x < f2.x) {
                    return 1;
                } else if (f1.x > f2.x) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Iterator<Figure> iter = beatFigures.iterator();
        while (iter.hasNext()){
            if(iter.next().x < x){
                iter.remove();
            }
        }

        if (beatFigures.isEmpty()) {
            return positions;
        }

        Collections.sort(beatFigures, comparator);
        if (beatFigures.isEmpty()) {
            return positions;
        }
        if (beatFigures.get(0).myPiece == this.myPiece) {
            return positions;
        } else {
            positions.add(beatFigures.get(0));
        }
        int tempX = beatFigures.get(0).x;
        int tempY = beatFigures.get(0).y;
        if (beatFigures.size() == 1) {
            Queen queen = new Queen(tempX, tempY, myPiece);
            positions.addAll(queen.moveBottomRight());
            return positions;
        } else {
            tempX++;
            tempY--;
            positions.add(beatFigures.get(0));
            while (tempX < this.x) {
                positions.add(new Queen(tempX, tempY, myPiece));
                tempX++;
                tempY--;
            }
        }
        return positions;
    }

    @Override
    public Figure clone() {
        return new Queen(this.x, this.y, this.myPiece);
    }
}
