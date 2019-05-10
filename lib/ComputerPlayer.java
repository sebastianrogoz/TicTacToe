package TicTacToe.lib;

import java.util.ArrayList;
import java.util.stream.*;

public class ComputerPlayer{

    public int[] getBestMove(Node root){
        ArrayList<Node> moves = new ArrayList<>();
        moves.addAll(root.generateChildren());
        return new int[] {1,2};
    }

}