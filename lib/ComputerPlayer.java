package TicTacToe.lib;

import java.util.ArrayList;

public class ComputerPlayer{

    private Node winningNode;

    public int[] getBestMove(Node root){
        ArrayList<Node> moves = new ArrayList<>();
        ArrayList<Node> jaggedMoves = new ArrayList();
        int childrenGenerated = 0;
        int[] output = new int[3];

        moves.addAll(root.generateChildren());
        childrenGenerated += moves.size();
        while(true){

            for(Node move : moves){
                if (move.getIsWinningNode() == true){
                    output[0] = move.getMoveCoords()[0];
                    output[1] = move.getMoveCoords()[1];
                    output[2] = childrenGenerated;
                    return output;
                }
                jaggedMoves.addAll(move.generateChildren());
                childrenGenerated += jaggedMoves.size();
            }
            moves = jaggedMoves;
            jaggedMoves = new ArrayList<>();

        }
    }
}