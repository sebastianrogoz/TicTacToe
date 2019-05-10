package TicTacToe.lib;

import java.util.ArrayList;

public class Node{

    private Board board;
    private Node parent;
    private Player player;
    private int depth;
    private boolean isWinningNode;
    private int[] moveCoords;

    public Node(Node parent, Board board, Player player, int depth, int[] moveCoords){
        this.parent = parent;
        this.board = board;
        this.player = player;
        this.depth = depth;
        this.moveCoords = moveCoords;
        
        if(this.parent != null){
            if(this.board.assertWin() == this.parent.player){
                this.isWinningNode = true;
            }
            else{
                this.isWinningNode = false;
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
                            children.add(new Node(this, childBoard, Player.Player2, this.depth + 1, new int[] {i+1,j+1}));
                            break;
                        case Player2:
                            childBoard = new Board(this.board.getBoardCopy());
                            childBoard.getBoard()[i][j] = FieldState.X;
                            children.add(new Node(this, childBoard, Player.Player1, this.depth + 1, new int[] {i+1,j+1}));
                            break;
                        case None:
                            break;
                    }
                }                
            }
        }
        return children;
    }

    public Board getBoard(){
        return this.board;
    }

    public Player getPlayer(){
        return this.player;
    }

    public int[] getMoveCoords(){
        return this.moveCoords;
    }

    public boolean getIsWinningNode(){
        return this.isWinningNode;
    }

}