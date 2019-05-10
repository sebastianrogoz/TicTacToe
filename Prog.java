package TicTacToe;

import TicTacToe.lib.*;

public class Prog{
    public static void main(String[] args){

        FieldState[][] boardState = {
            {FieldState.O,FieldState.empty,FieldState.empty},
            {FieldState.X,FieldState.empty,FieldState.X},
            {FieldState.X,FieldState.X,FieldState.empty}
        };

        Board rootBoard = new Board(boardState);
        Node rootNode = new Node(null, rootBoard, Player.Player2, 0, null);

        ComputerPlayer opponent = new ComputerPlayer();

        int[] coords = opponent.getBestMove(rootNode);

        System.out.println("Best move: " + coords[0] + " " + coords[1]);
    }
}