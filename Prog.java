package TicTacToe;

import TicTacToe.lib.Board;
import TicTacToe.lib.ComputerPlayer;
import TicTacToe.lib.Player;
import TicTacToe.lib.SinglePlayerGame;

public class Prog{
    public static void main(String[] args){

        /*Board board = new Board();
        board.makeMove(1, 3, Player.Player2);
        board.makeMove(2, 3, Player.Player2);
        board.makeMove(2, 1, Player.Player1);
        board.makeMove(1, 1, Player.Player1);
        board.printBoard();
        ComputerPlayer opponent = new ComputerPlayer();
        int[] coords = opponent.getWinningMoveCoords(board);
        System.out.println("best coords:" + coords[0] + " " + coords[1]);*/
        
        SinglePlayerGame game = new SinglePlayerGame();
    }
}