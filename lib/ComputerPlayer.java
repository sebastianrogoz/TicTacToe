package TicTacToe.lib;

import java.util.ArrayList;

public class ComputerPlayer{

    public void getWinningMoveCoords(Board board, Player player){
        ArrayList<Board> boardChildren = board.generateChildren(player);

        //for (Board child : boardChildren){
            //if (child.getBoard().assertWin(player)){

            //}
        //}
    }
}