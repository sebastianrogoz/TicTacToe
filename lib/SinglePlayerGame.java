package TicTacToe.lib;

import java.util.Scanner;

public class SinglePlayerGame{
    private Board board;

    public SinglePlayerGame(){
        this.board = new Board();
        Scanner reader = new Scanner(System.in);
        int column, row;
        ActionResult playerOneAction, playerTwoAction;
        boolean end;
        ComputerPlayer opponent = new ComputerPlayer();
        int[] coords;
    
        while(true){
            do{
                System.out.print("\n\n\n");  
                board.printBoard();
                System.out.println("PLAYER1:");
                System.out.print("Column: ");
                column = Integer.parseInt(reader.nextLine());
                System.out.print("Row: ");
                row = Integer.parseInt(reader.nextLine());
                playerOneAction = board.makeMove(column, row, Player.Player1);
            } while (playerOneAction == ActionResult.error);


            end = board.assertWin(Player.Player1);
            if (end){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("Player 1 WINS! ");
                break;
            }

            do{
                coords = null;
                System.out.println("Children generated: " + coords[2]);
                playerTwoAction = board.makeMove(coords[0], coords[1], Player.Player2);
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