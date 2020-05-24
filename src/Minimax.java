import java.util.LinkedList;

public class Minimax {

    public Node minimax(Node n, int iteration) {
        /*if (n.iteration < 7){
            n.moveA0llFigures();
            if(n.myTurn == true) {
                try {
                    Node returnNode = minimax(n.nodes.get(0));
                    for (Node tempNode : n.nodes) {
                        if (minimax(tempNode).board.getHeuristicValue() > returnNode.board.getHeuristicValue()) {
                            returnNode = tempNode;
                        }
                    }
                    System.out.println("b");
                    return returnNode;
                }
                catch (NullPointerException e){
                    System.out.println("loose");
                    return null;
                }
            }
            else {
                try {
                    Node returnNode = minimax(n.nodes.get(0));
                    for(Node tempNode: n.nodes){
                        if(minimax(tempNode).board.getHeuristicValue() < returnNode.board.getHeuristicValue()){
                            returnNode = tempNode;
                        }
                    }
                    System.out.println("a");
                    return returnNode;
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("win");
                    return null;
                }
            }
        }
        return n;*/
        if (iteration < 6) {
            try {
                n.moveAllFigures();
                n.board.setHeuristicValue();
                if(n.board.heuristicValue == Integer.MIN_VALUE){
                    return n;
                }
                else if(n.board.heuristicValue == Integer.MAX_VALUE){
                    return n;
                }
                if (n.myTurn == true) {
                    if (!n.nodes.isEmpty()) {
                        Node retNode = n.nodes.get(0);
                        //retNode.board.heuristicValue = minimax(n.nodes.get(0), n.nodes.get(0).iteration).board.heuristicValue;
                        retNode.board.heuristicValue = Integer.MIN_VALUE;
                    for (Node temp : n.nodes) {
                            if (minimax(temp, temp.iteration).board.heuristicValue >= retNode.board.heuristicValue) {
                                temp.board.heuristicValue = minimax(temp, temp.iteration).board.heuristicValue;
                                retNode = temp;
                            }
                        }
                    if(iteration == 1){
                        return retNode;
                    }
                        return retNode;
                    } else {
                        n.board.heuristicValue = Integer.MIN_VALUE;
                        return n;
                    }
                } else {
                    if (!n.nodes.isEmpty()) {

                        Node retNode = n.nodes.get(0);
                        //retNode.board.heuristicValue = minimax(n.nodes.get(0), n.nodes.get(0).iteration).board.heuristicValue;
                        retNode.board.heuristicValue = Integer.MAX_VALUE;
                        n.board.heuristicValue = retNode.board.heuristicValue;
                        for (Node temp : n.nodes) {
                            if (minimax(temp, temp.iteration).board.heuristicValue <= retNode.board.heuristicValue) {
                                temp.board.heuristicValue = minimax(temp, temp.iteration).board.heuristicValue;
                                retNode = temp;
                            }
                        }
                        return retNode;
                    } else {
                        n.board.heuristicValue = Integer.MAX_VALUE;
                        return n;
                    }
                }
            } catch (NullPointerException e) {
                return null;
            }
        } else {
            n.board.setHeuristicValue();
            return n;
        }
    }
}
