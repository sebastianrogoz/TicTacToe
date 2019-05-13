package TicTacToe;

import java.util.ArrayList;

import TicTacToe.lib.*;

public class Prog{
    public static void main(String[] args){

        Board root = new Board();
        root.makeMove(1, 1, Player.Player1);

        ArrayList<Board> boards = root.generateChildren(Player.Player2);

        for(Board board : boards){
            board.printBoard();
            System.out.print("\n");
        }
    }
}