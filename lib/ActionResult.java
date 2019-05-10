package TicTacToe.lib;

public enum ActionResult{
    success,
    error;

    @Override
    public String toString(){
        switch(this){
            case success: return "Success";
            case error: return "Error";
            default: throw new IllegalArgumentException("Error converting ActionResult to string.");
        }
    }
}