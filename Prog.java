package TicTacToe;

import TicTacToe.lib.*;

public class Prog{
    public static void main(String[] args){

        FieldState[][] boardState = {
            {FieldState.O,FieldState.empty,FieldState.O},
            {FieldState.empty,FieldState.X,FieldState.X},
            {FieldState.X,FieldState.X,FieldState.empty}
        };

        SinglePlayerGame game = new SinglePlayerGame();
    }
}