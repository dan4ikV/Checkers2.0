import java.util.LinkedList;

public class Node {
    Board board;
    int iteration;
    boolean myTurn;
    boolean beating = false;
    LinkedList<Node> nodes = new LinkedList<Node>();

    public Node(Board board, int iteration, boolean myTurn) {
        this.board = board;
        this.iteration = iteration;
        this.myTurn = myTurn;
    }

    public Node(Node n) {
        this.board =  new Board(n.board);
        this.iteration = n.iteration;
        this.myTurn = n.myTurn;
    }

    public void moveAllFigures(){
        if(myTurn == true){
            for(Figure fig: this.board.myPieces){
                for(Board b: this.board.tryAllMoves(fig)){
                    if(b.myPieces.contains(new Piece(6, 2, true)) &&  b.myPieces.contains(new Piece(5, 1, true))){
                        System.out.println();
                    }
                    if(b.beating == true){
                        if(this.beating == false){
                            nodes.clear();
                            this.beating = true;
                        }
                    }
                    //else if(this.beating == false && b.beating == false){
                        nodes.add(new Node(b, this.iteration + 1, !this.myTurn));
                    //}
                }
            }
        }
        else{
            for(Figure fig: this.board.opponentPieces){
                for(Board b: this.board.tryAllMoves(fig)){
                    if(b.myPieces.contains(new Piece(7, 7, true)) &&  b.myPieces.contains(new Piece(5, 1, true))){
                        System.out.println();
                    }
                    if(b.beating == true){
                        if(this.beating == false){
                            nodes.clear();
                            this.beating = true;
                        }
                        //nodes.add(new Node(b, this.iteration, this.myTurn));
                    }
                    //else {
                        nodes.add(new Node(b, this.iteration + 1, !this.myTurn));
                    //}
                }
            }
        }
    }
}
