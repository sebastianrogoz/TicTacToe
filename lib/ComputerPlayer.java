package TicTacToe.lib;

import java.util.ArrayList;

public class ComputerPlayer{

    private Node winningNode;

    public int[] getBestMove(Node root){
        ArrayList<Node> moves = new ArrayList<>();

        moves.addAll(root.generateChildren());
        do{

            for(Node move : moves){
                if (move.getIsWinningNode() == true){
                    return move.getMoveCoords();
                }
                moves.addAll(move.generateChildren());
            }

        } while(this.winningNode == null);

        
        return null;
    }
}