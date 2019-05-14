package TicTacToe.lib;

import java.util.Scanner;

public class SinglePlayerGame{
    private Board board;

    public SinglePlayerGame(){
        this.board = new Board();
        Scanner reader = new Scanner(System.in);
        int column, row;
        ActionResult playerOneAction, playerTwoAction;
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

            if (board.assertWin(Player.Player1)){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("Player 1 WINS! ");
                break;
            }

            if(this.board.isFull()){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("DRAW! ");
                break;
            }

            do{
                coords = opponent.getWinningMoveCoords(board);
                System.out.println( coords[0] + " " + coords[1]);
                playerTwoAction = board.makeMove(coords[0], coords[1], Player.Player2);
            } while (playerTwoAction == ActionResult.error);
            
            if (board.assertWin(Player.Player2)){
                System.out.print("\n\n\n");
                board.printBoard();
                System.out.print("Player 2 WINS!");
                break;
            }
        }

        reader.close();
    }
}