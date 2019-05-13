package TicTacToe.lib;

import java.util.*;

import TicTacToe.lib.Player;

public class MultiplayerGame{
    private Board board;

    public MultiplayerGame(){
        this.board = new Board();
        Scanner reader = new Scanner(System.in);
        int column, row;
        ActionResult playerOneAction, playerTwoAction;
        boolean end;

        while(true){
            do{
                System.out.print("\n\n\n");  
                board.printBoard();
                System.out.println("PLAYER1:");
                System.out.print("Column: ");
                column = Integer.parseInt(reader.nextLine());
                System.out.print("Row: ");
                row = Integer.parseInt(reader.nextLine());
                playerOneAction = board.makeMove(column, row, FieldState.O);
            } while (playerOneAction == ActionResult.error);


            end = board.assertWin(Player.Player1);
            if (end){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("Player 1 WINS! ");
                break;
            }

            do{
                System.out.print("\n\n\n");    
                board.printBoard();
                System.out.println("PLAYER2:");
                System.out.print("Column: ");
                column = Integer.parseInt(reader.nextLine());
                System.out.print("Row: ");
                row = Integer.parseInt(reader.nextLine());
                playerTwoAction = board.makeMove(column, row, FieldState.X);
            } while (playerTwoAction == ActionResult.error);

            
            end = board.assertWin(Player.Player2);
            if (end){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("Player 2 WINS!");
                break;
            }
        }
        reader.close();
    }
}