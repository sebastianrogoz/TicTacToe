package TicTacToe.lib;

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

    public ActionResult makeMove(int column, int row, FieldState move) {
        if ((1 <= column && column <= 3) && (1 <= row && row <= 3)) {
            if(this.board[row - 1][column - 1] == FieldState.empty){
                this.board[row - 1][column - 1] = move;
                return ActionResult.success;
            }
        }
        return ActionResult.error;
    }

    public Player assertWin() {
        int sum = 0;

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
                return Player.Player1;
            if (sum < -2)
                return Player.Player2;
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
                return Player.Player1;
            if (sum < -2)
                return Player.Player2;
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
            return Player.Player1;
        if (sum < -2)
            return Player.Player2;
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
            return Player.Player1;
        if (sum < -2)
            return Player.Player2;
        sum = 0;

        return Player.None;
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
}