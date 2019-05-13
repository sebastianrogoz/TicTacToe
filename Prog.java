package TicTacToe;

import TicTacToe.lib.Board;
import TicTacToe.lib.ComputerPlayer;
import TicTacToe.lib.Player;
import TicTacToe.lib.SinglePlayerGame;

public class Prog{
    public static void main(String[] args){

        Board board = new Board();
        board.makeMove(2, 2, Player.Player1);
        board.makeMove(1, 1, Player.Player1);
        board.makeMove(3, 2, Player.Player2);
        board.makeMove(3, 3, Player.Player2);
        board.makeMove(3, 1, Player.Player1);
        ComputerPlayer opponent = new ComputerPlayer();
        int[] coords = opponent.getWinningMoveCoords(board);
        board.printBoard();
        System.out.println("best coords:" + coords[0] + " " + coords[1]);
        
        //SinglePlayerGame game = new SinglePlayerGame();
    }
}