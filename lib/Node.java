package TicTacToe.lib;

import java.util.ArrayList;

public class Node{

    private Node parent;
    private Board board;
    private ArrayList<Node> children;
    private Player player;
    private int score;
    private int depth;
    private boolean isWinningNode;

    public Node(Node parent, Board board, Player player, int depth){
        this.parent = parent;
        this.board = board;
        this.player = player;
        this.children = new ArrayList<>();
        this.score = 0;
        this.depth = depth;
        
        if(this.parent != null){
            if(this.board.assertWin() == this.parent.player){
                this.isWinningNode = true;
            }
        }
    }

    public ArrayList<Node> generateChildren(){
        ArrayList<Node> children = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                Board childBoard;
                if(this.board.getBoard()[i][j] == FieldState.empty){
                    switch(this.player){
                        case Player1:
                            childBoard = new Board(this.board.getBoardCopy());
                            childBoard.getBoard()[i][j] = FieldState.O;
                            children.add(new Node(this, childBoard, Player.Player2, this.depth + 1));
                            break;
                        case Player2:
                            childBoard = new Board(this.board.getBoardCopy());
                            childBoard.getBoard()[i][j] = FieldState.X;
                            children.add(new Node(this, childBoard, Player.Player1, this.depth + 1));
                            break;
                        case None:
                            break;
                    }
                }                
            }
        }
        return children;
    }

    public ArrayList<Node> getChildren(){
        return this.children;
    }

    public Board getBoard(){
        return this.board;
    }

    public boolean checkWinning(){
        return this.isWinningNode;
    }

}