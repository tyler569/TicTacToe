/**
 * TicTacToe
 * Copyright (C) 2013 Tyler Philbrick
 * Licensed GNU GENERAL PUBLIC LICENSE Version 2
 * See LICENSE.txt for full license
 */

package main.java;

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
