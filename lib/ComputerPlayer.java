package TicTacToe.lib;

import java.util.ArrayList;
import static TicTacToe.lib.Player.*;

public class ComputerPlayer{

    public int[] getWinningMoveCoords(Board board){        


        //check if any of next moves wins
        ArrayList<Board> boardChildren = board.generateChildren(Player2);
        for(Board child : boardChildren)
        {
            if(child.assertWin(Player2)){
                return board.getDifferenceCoords(child);
            }
        }

        //check if opponent would win, get blocking move coords
        boardChildren = board.generateChildren(Player1);
        for (Board child : boardChildren){
            if (child.assertWin(Player1)){
                return board.getDifferenceCoords(child);
            }
        }

        //generate children until winning move is found
        ArrayList<Board> tempChildren = new ArrayList<>();
        int tries = 0;
        while(tries < 10){
            for(Board child : boardChildren){
                tempChildren.addAll(child.generateChildren(Player1));
            }
            boardChildren = new ArrayList<>();
            for(Board child : tempChildren)
            {
                boardChildren.addAll(child.generateChildren(Player2));
            }
            tempChildren = new ArrayList<>();
            for(Board child : boardChildren){
                if(child.assertWin(Player2)){
                    return new int[] {child.getDifferenceCoords(child.getParent())[0], child.getDifferenceCoords(child.getParent())[1]};
                }
            }
            tries++;
        }

        //if no block && no win = return first empty field move
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                if(board.getBoard()[i][j] == FieldState.empty){
                    return new int[] {j + 1, i + 1};
                }
            }
        }
        
        return null;
    }
}