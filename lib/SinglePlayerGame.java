package TicTacToe.lib;

import java.util.Scanner;

public class SinglePlayerGame{
    private Board board;

    public SinglePlayerGame(){
        this.board = new Board();
        Scanner reader = new Scanner(System.in);
        int column, row;
        ActionResult playerOneAction, playerTwoAction;
        Player end;
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
                playerOneAction = board.makeMove(column, row, FieldState.O);
            } while (playerOneAction == ActionResult.error);


            end = board.assertWin();
            if (end != Player.None){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print(end + " WINS! ");
                break;
            }

            do{
                coords = opponent.getBestMove(new Node(null, this.board, Player.Player2, 0, null));
                System.out.println("Children generated: " + coords[2]);
                playerTwoAction = board.makeMove(coords[0], coords[1], FieldState.X);
            } while (playerTwoAction == ActionResult.error);

            
            end = board.assertWin();
            if (end != Player.None){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print(end + " WINS!");
                break;
            }
        }
        reader.close();
    }
}