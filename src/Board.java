import java.util.LinkedList;

public class Board {
        LinkedList<Figure> myPieces;
        LinkedList<Figure> opponentPieces;
        int heuristicValue = 0;
        boolean beating = false;

        public Board(LinkedList<Figure> myPieces, LinkedList<Figure> opponentPieces){
                this.myPieces = new LinkedList<Figure>();
                for (Figure p: myPieces) {
                        this.myPieces.add(p.clone());
                }
                this.opponentPieces = new LinkedList<Figure>();
                for(Figure p: opponentPieces){
                        this.opponentPieces.add(p.clone());
                }
                setHeuristicValue();
        }

        public Board(Board b){
                this.myPieces = new LinkedList<Figure>();
                for (Figure p: b.myPieces) {
                        this.myPieces.add(p.clone());
                }
                this.opponentPieces = new LinkedList<Figure>();
                for(Figure p: b.opponentPieces){
                        this.opponentPieces.add(p.clone());
                }
                setHeuristicValue();
        }

        public void setHeuristicValue(){
                heuristicValue = myPieces.size() - opponentPieces.size();
                if(myPieces.isEmpty()){
                        heuristicValue = -1000;
                }
                else if(opponentPieces.isEmpty()){
                        heuristicValue = 1000;
                }
        }

        public int getHeuristicValue(){
                return heuristicValue;
        }

        public LinkedList<Board> tryBeating(Figure fig){
                LinkedList<Board> moves = new LinkedList<Board>();
                if(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).size() >= 1){
                        for(int i = 1; i < fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).size(); i++){
                                Board move = new Board(this);
                                if(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).get(0).myPiece == true){
                                        move.myPieces.remove(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).get(0));
                                        move.opponentPieces.remove(fig);
                                        move.opponentPieces.add(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.opponentPieces.get(move.opponentPieces.size() - 1)));
                                }
                                else{
                                        move.opponentPieces.remove(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).get(0));
                                        move.myPieces.remove(fig);
                                        move.myPieces.add(fig.beatTopLeft(findFiguresOnTopLeftDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.myPieces.get(move.myPieces.size() - 1)));
                                }
                        }
                }
                if(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).size() > 1){
                        for(int i = 1; i < fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).size(); i++){
                                Board move = new Board(this);
                                if(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).get(0).myPiece == true){
                                        move.myPieces.remove(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).get(0));
                                        move.opponentPieces.remove(fig);
                                        move.opponentPieces.add(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.opponentPieces.get(move.opponentPieces.size() - 1)));
                                }
                                else{
                                        move.opponentPieces.remove(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).get(0));
                                        move.myPieces.remove(fig);
                                        move.myPieces.add(fig.beatTopRight(findFiguresOnTopRightDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.myPieces.get(move.myPieces.size() - 1)));
                                }
                        }
                }
                if(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).size() > 1){
                        for(int i = 1; i < fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).size(); i++){
                                Board move = new Board(this);
                                if(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).get(0).myPiece == true){
                                        move.myPieces.remove(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).get(0));
                                        move.opponentPieces.remove(fig);
                                        move.opponentPieces.add(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.opponentPieces.get(move.opponentPieces.size() - 1)));
                                }
                                else{
                                        move.opponentPieces.remove(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).get(0));
                                        move.myPieces.remove(fig);
                                        move.myPieces.add(fig.beatBottomLeft(findFiguresOnBottomLeftDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.myPieces.get(move.myPieces.size() - 1)));
                                }
                        }
                }
                if(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).size() > 1){
                        for(int i = 1; i < fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).size(); i++){
                                Board move = new Board(this);
                                if(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).get(0).myPiece == true){
                                        move.myPieces.remove(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).get(0));
                                        move.opponentPieces.remove(fig);
                                        move.opponentPieces.add(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.opponentPieces.get(move.opponentPieces.size() - 1)));
                                }
                                else{
                                        move.opponentPieces.remove(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).get(0));
                                        move.myPieces.remove(fig);
                                        move.myPieces.add(fig.beatBottomRight(findFiguresOnBottomRightDiagonal(fig)).get(i));
                                        move.beating = true;
                                        moves.addAll(move.tryBeating(move.myPieces.get(move.myPieces.size() - 1)));
                                }
                        }
                }
                if(moves.isEmpty() && this.beating == true){
                        moves.add(this);
                        return moves;
                }
                return moves;
        }


        public LinkedList<Board> tryAllMoves(Figure fig){
                LinkedList<Board> moves = new LinkedList<Board>();
                moves.addAll(tryBeating(fig));
                if(moves.isEmpty() && this.beating == false){
                        if(!fig.moveTopLeft().isEmpty()){
                                for(Figure tempFig: fig.moveTopLeft()) {
                                        if (this.isFree(tempFig)) {
                                                Board move = new Board(this);
                                                if(move.myPieces.contains(fig)){
                                                        move.myPieces.remove(fig);
                                                        move.myPieces.add(tempFig);
                                                        moves.add(move);

                                                }
                                                else {
                                                        move.opponentPieces.remove(fig);
                                                        move.opponentPieces.add(tempFig);
                                                        moves.add(move);

                                                }
                                        }
                                        else {
                                                break;
                                        }
                                }
                        }
                        if(!fig.moveTopRight().isEmpty()){
                                for(Figure tempFig: fig.moveTopRight()) {
                                        if (this.isFree(tempFig)) {
                                                Board move = new Board(this);
                                                if(move.myPieces.contains(fig)){
                                                        move.myPieces.remove(fig);
                                                        move.myPieces.add(tempFig);
                                                        moves.add(move);

                                                }
                                                else {
                                                        move.opponentPieces.remove(fig);
                                                        move.opponentPieces.add(tempFig);
                                                        moves.add(move);

                                                }
                                        }
                                        else {
                                                break;
                                        }
                                }
                        }
                }
                return moves;
        }

        public boolean isFree(Figure f){
                return !myPieces.contains(f) && !opponentPieces.contains(f) && !myPieces.contains(new Figure(f.x, f.y, !f.myPiece)) && !opponentPieces.contains(new Figure(f.x, f.y, !f.myPiece));
        }

        public LinkedList<Figure> findFiguresOnTopRightDiagonal(Figure fig){
                LinkedList<Figure> found = new LinkedList<Figure>();
                for(Figure temp: myPieces){
                        if(temp.x - temp.y == fig.x - fig.y && temp.x > fig.x){
                                found.add(temp);
                        }
                }
                for(Figure temp: opponentPieces){
                        if(temp.x - temp.y == fig.x - fig.y && temp.x > fig.x){
                                found.add(temp);
                        }
                }
                return found;
        }

        public LinkedList<Figure> findFiguresOnBottomLeftDiagonal(Figure fig){
                LinkedList<Figure> found = new LinkedList<Figure>();
                for(Figure temp: myPieces){
                        if(temp.x - temp.y == fig.x - fig.y && temp.x < fig.x){
                                found.add(temp);
                        }
                }
                for(Figure temp: opponentPieces){
                        if(temp.x - temp.y == fig.x - fig.y && temp.x < fig.x){
                                found.add(temp);
                        }
                }
                return found;
        }

        public LinkedList<Figure> findFiguresOnTopLeftDiagonal(Figure fig){
                LinkedList<Figure> found = new LinkedList<Figure>();
                for(Figure temp: myPieces){
                        if(temp.x + temp.y == fig.x + fig.y && temp.x < fig.x){
                                found.add(temp);
                        }
                }
                for(Figure temp: opponentPieces){
                        if(temp.x + temp.y == fig.x + fig.y && temp.x < fig.x){
                                found.add(temp);
                        }
                }
                return found;
        }

        public LinkedList<Figure> findFiguresOnBottomRightDiagonal(Figure fig){
                LinkedList<Figure> found = new LinkedList<Figure>();
                for(Figure temp: myPieces){
                        if(temp.x + temp.y == fig.x + fig.y && temp.x > fig.x){
                                found.add(temp);
                        }
                }
                for(Figure temp: opponentPieces){
                        if(temp.x + temp.y == fig.x + fig.y && temp.x > fig.x){
                                found.add(temp);
                        }
                }
                return found;
        }

/*        public LinkedList<Board> canBeat(Piece p){
                LinkedList<Board> boards = new LinkedList<Board>();
                if(myPieces.contains(p)){
                        if(opponentPieces.contains(new Piece(p.x - 1, p.y +1)) && isFree(p.x - 2, p.y + 2)){
                                Board board = new Board(this);
                                if(board.myPieces.get(board.myPieces.indexOf(p)).beatTopLeft()){
                                        board.opponentPieces.remove(new Piece(p.x - 1, p.y + 1));
                                        boards.add(board);
                                }
                        }
                        else if(opponentPieces.contains(new Piece(p.x + 1, p.y + 1)) && isFree(p.x + 2, p.y + 2)){
                                Board board = new Board(this);
                                if(board.myPieces.get(board.myPieces.indexOf(p)).beatTopRight()){
                                        board.opponentPieces.remove(new Piece(p.x + 1, p.y + 1));
                                        boards.add(board);
                                }
                        }
                        else if(opponentPieces.contains(new Piece(p.x + 1, p.y - 1)) && isFree(p.x + 2, p.y - 2)){
                                Board board = new Board(this);
                                if(board.myPieces.get(board.myPieces.indexOf(p)).beatBottomRight()){
                                        board.opponentPieces.remove(new Piece(p.x + 1, p.y - 1));
                                        boards.add(board);
                                }
                        }
                        else if(opponentPieces.contains(new Piece(p.x - 1, p.y - 1)) && isFree(p.x - 2, p.y - 2)){
                                Board board = new Board(this);
                                if(board.myPieces.get(board.myPieces.indexOf(p)).beatBottomLeft()){
                                        board.opponentPieces.remove(new Piece(p.x - 1, p.y - 1));
                                        boards.add(board);
                                }
                        }
                }
                else if(opponentPieces.contains(p)){
                        if(myPieces.contains(new Piece(p.x - 1, p.y +1)) && isFree(p.x - 2, p.y + 2)){
                                Board board = new Board(this);
                                if(board.opponentPieces.get(board.opponentPieces.indexOf(p)).beatTopLeft()){
                                        board.myPieces.remove(new Piece(p.x - 1, p.y + 1));
                                        boards.add(board);
                                }
                        }
                        else if(myPieces.contains(new Piece(p.x + 1, p.y +1)) && isFree(p.x + 2, p.y + 2)){
                                Board board = new Board(this);
                                if(board.opponentPieces.get(board.opponentPieces.indexOf(p)).beatTopRight()){
                                        board.myPieces.remove(new Piece(p.x + 1, p.y + 1));
                                        boards.add(board);
                                }
                        }
                        else if(myPieces.contains(new Piece(p.x + 1, p.y - 1)) && isFree(p.x + 2, p.y - 2)){
                                Board board = new Board(this);
                                if(board.opponentPieces.get(board.opponentPieces.indexOf(p)).beatBottomRight()){
                                        board.myPieces.remove(new Piece(p.x + 1, p.y - 1));
                                        boards.add(board);
                                }
                        }
                        else if(myPieces.contains(new Piece(p.x - 1, p.y - 1)) && isFree(p.x + 2, p.y - 2)){
                                Board board = new Board(this);
                                if(board.opponentPieces.get(board.opponentPieces.indexOf(p)).beatBottomLeft()){
                                        board.myPieces.remove(new Piece(p.x - 1, p.y - 1));
                                        boards.add(board);
                                }
                        }
                }
                return boards;
        }*/
}
