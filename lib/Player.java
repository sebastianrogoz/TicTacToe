package TicTacToe.lib;

public enum Player{
    Player1,
    Player2,
    None;

    @Override
    public String toString(){
        switch(this){
            case Player1:
                return "Player1";
            case Player2:
                return "Player2";
            case None:
                return "Draw";
            default: throw new IllegalArgumentException("Error converting Player to string.");
        }
    }
}