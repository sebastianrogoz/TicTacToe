package TicTacToe.lib;

public enum FieldState{
    O,
    X,
    empty;

    @Override
    public String toString(){
        switch(this){
            case O: return "O";
            case X: return "X";
            case empty: return "_";
            default: throw new IllegalArgumentException("Error converting FieldState to string.");
        }
    }

    
}