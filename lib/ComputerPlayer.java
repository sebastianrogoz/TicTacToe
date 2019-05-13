package TicTacToe.lib;

import java.util.ArrayList;
import static TicTacToe.lib.Player.*;

public class ComputerPlayer{

    public int[] getWinningMoveCoords(Board board){
        ArrayList<Board> boardChildren = board.generateChildren(Player2);
        int childrenGenerated = 0;

        //check if opponent would win, get blocking move coords
        for (Board child : boardChildren){
            if (child.assertWin(Player1)){
                return board.getDifferenceCoords(child);
            }
        }

        //check if any of next moves wins
        for(Board child : boardChildren)
        {
            if(child.assertWin(Player2)){
                return board.getDifferenceCoords(child);
            }
        }


        //generate children until winning move is found
        ArrayList<Board> tempChildren = new ArrayList<>();

        while(true){
            for(Board child : boardChildren){
                tempChildren.addAll(child.generateChildren(Player1));
            }
            childrenGenerated += tempChildren.size();
            boardChildren = new ArrayList<>();
            for(Board child : tempChildren)
            {
                boardChildren.addAll(child.generateChildren(Player2));
            }
            childrenGenerated += boardChildren.size();
            tempChildren = new ArrayList<>();
            for(Board child : boardChildren){
                if(child.assertWin(Player2)){
                    return new int[] {child.getDifferenceCoords(child.getParent())[0], child.getDifferenceCoords(child.getParent())[1], childrenGenerated};
                }
            }
        }
    }
}