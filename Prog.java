package TicTacToe;

import java.util.ArrayList;

import TicTacToe.lib.*;

public class Prog{
    public static void main(String[] args){

        FieldState[][] boardState = {
            {FieldState.O,FieldState.empty,FieldState.empty},
            {FieldState.X,FieldState.empty,FieldState.X},
            {FieldState.X,FieldState.X,FieldState.empty}
        };

        Board rootBoard = new Board(boardState);
        Node rootNode = new Node(null, rootBoard, Player.Player2, 0);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.addAll(rootNode.generateChildren());
        for(Node node : nodes){
            System.out.println(node.checkWinning());
            node.getBoard().printBoard();
            System.out.print("\n");
        }

        System.out.println("Children generated: " + nodes.size());
    }
}