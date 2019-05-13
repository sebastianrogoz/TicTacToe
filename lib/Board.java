package TicTacToe.lib;

import java.util.ArrayList;

public class Board{

    private FieldState[][] board = new FieldState[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = FieldState.empty;
            }
        }
    }

    public Board(FieldState[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (FieldState[] row : this.board) {
            for (FieldState element : row) {
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }
    }

    public ActionResult makeMove(int column, int row, Player player) {
        if ((1 <= column && column <= 3) && (1 <= row && row <= 3)) {
            if(this.board[row - 1][column - 1] == FieldState.empty){
                this.board[row - 1][column - 1] = (player == Player.Player1) ? FieldState.O : FieldState.X;
                return ActionResult.success;
            }
        }
        return ActionResult.error;
    }

    public boolean assertWin(Player player) {
        int sum = 0;
        Player winner = Player.None;
        //cols
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == FieldState.O) {
                    sum++;
                } else if (board[i][j] == FieldState.X) {
                    sum--;
                }
            }
            if (sum > 2)
                winner = Player.Player1;
            if (sum < -2)
                winner = Player.Player2;
            sum = 0;
        }
        
        //rows
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == FieldState.O) {
                    sum++;
                } else if (board[j][i] == FieldState.X) {
                    sum--;
                }
            }
            if (sum > 2)
                winner = Player.Player1;
            if (sum < -2)
                winner = Player.Player2;
            sum = 0;
        }

        //diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (board[i][j] == FieldState.O) {
                        sum++;
                    } else if (board[i][j] == FieldState.X) {
                        sum--;
                    }
                }
            }
        }
        if (sum > 2)
            winner = Player.Player1;
        if (sum < -2)
            winner = Player.Player2;
        sum = 0;

        //anti-diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                if (i + j == 2) {
                    if (board[i][j] == FieldState.O) {
                        sum++;
                    } else if (board[i][j] == FieldState.X) {
                        sum--;
                    }
                }
            }
        }
        if (sum > 2)
            winner = Player.Player1;
        if (sum < -2)
            winner = Player.Player2;
        sum = 0;

        if(winner == player){
            return true;
        } else {
            return false;
        
    }
    }

    public FieldState[][] getBoardCopy(){
        FieldState[][] outputBoard = new FieldState[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                outputBoard[i][j] = this.board[i][j];
            }
        }

        return outputBoard;
    }

    public FieldState[][] getBoard(){
        return this.board;
    }

    public ArrayList<Board> generateChildren(Player player){
        ArrayList<Board> children = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                Board childBoard;
                if(this.getBoard()[i][j] == FieldState.empty){
                    switch(player){
                        case Player1:
                            childBoard = new Board(this.getBoardCopy());
                            childBoard.getBoard()[i][j] = FieldState.O;
                            children.add(childBoard);
                            break;
                        case Player2:
                            childBoard = new Board(this.getBoardCopy());
                            childBoard.getBoard()[i][j] = FieldState.X;
                            children.add(childBoard);
                            break;
                        case None:
                            break;
                    }
                }                
            }
        }
        return children;
    }
}