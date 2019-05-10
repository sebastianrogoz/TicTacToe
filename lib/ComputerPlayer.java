package TicTacToe.lib;

import java.util.ArrayList;

public class ComputerPlayer{

    private Node winningNode;

    public int[] getBestMove(Node root){
        ArrayList<Node> moves = new ArrayList<>();
        ArrayList<Node> jaggedMoves = new ArrayList();

        moves.addAll(root.generateChildren());
        while(true){

            for(Node move : moves){
                if (move.getIsWinningNode() == true){
                    return move.getMoveCoords();
                }
                jaggedMoves.addAll(move.generateChildren());
            }
            moves = jaggedMoves;
            jaggedMoves = new ArrayList<>();

        }
    }
}