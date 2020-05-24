import java.util.LinkedList;

    public class Main {
        public static void main(String[] args) {
            LinkedList<Figure> myPieces = new LinkedList<>();
            LinkedList<Figure> opponentsPieces = new LinkedList<>();

            myPieces.add(new Queen(7, 1, true));
            Board b = new Board(myPieces, opponentsPieces);
            Node n = new Node(b, 1, true);
            Minimax min = new Minimax();
            n = min.minimax(n, 1);
            System.out.println("a");
        }
    }
