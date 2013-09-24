package main.java;

import java.util.Scanner;

/**
 * TicTacToe
 * Copyright Tyler Philbrick; 2013
 * Created: 9/22/13
 */

class UI {
    private Board board;
    private Space[] spaces;
    Scanner input = new Scanner(System.in);

    public UI (Board assocBoard) {
        board = assocBoard;
        spaces = board.getSpaces();
    }

    public void UIroutine () {
        int takeSpace;
        board.printBoard();
        System.out.println("Choose a space to take");
        while (true) {
            takeSpace = input.nextInt() - 1;
            if (spaces[takeSpace].getOwner() == 1) {
                spaces[takeSpace].take(2);
                return;
            }
            System.out.println("That space is taken");
        }
    }

    public void winCase (int winner) {
        board.printBoard();
        switch (winner) {
            case 0 : System.out.println("Computer wins!");
                     break;
            case 1 : System.out.println("(Unsurprisingly) A tie!");
                     break;
            case 2 : System.out.println("You win!");
                     break;
        }
    }
}
