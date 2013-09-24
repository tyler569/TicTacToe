package main.java;

/**
 * TicTacToe
 * Copyright Tyler Philbrick; 2013
 * Created: 9/22/13
 */

public class Main {
    public static void main (String[] args) {
        Board board = new Board();
        UI ui = new UI(board);
        AI ai = new AI(board);

        while (true) {
            ui.UIroutine();
            if (board.win() != -1) {
                ui.winCase(board.win());
                break;
            }
            ai.AIroutine();
            if (board.win() != -1) {
                ui.winCase(board.win());
                break;
            }
        }
    }
}
