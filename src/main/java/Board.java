/**
 * TicTacToe
 * Copyright (C) 2013 Tyler Philbrick
 * Licensed GNU GENERAL PUBLIC LICENSE Version 2
 * See LICENSE.txt for full license
 */

package main.java;

class Board {
    private Space[] spaces = new Space[9];
    private Row[] rows = new Row[8];

    public Board () {
        for (int i=0; i<9; i++) {
            spaces[i] = new Space();
        }
        rows[0] = new Row(spaces[0], spaces[1], spaces[2]);
        rows[1] = new Row(spaces[3], spaces[4], spaces[5]);
        rows[2] = new Row(spaces[6], spaces[7], spaces[8]);
        rows[3] = new Row(spaces[0], spaces[3], spaces[6]);
        rows[4] = new Row(spaces[1], spaces[4], spaces[7]);
        rows[5] = new Row(spaces[2], spaces[5], spaces[8]);
        rows[6] = new Row(spaces[0], spaces[4], spaces[8]);
        rows[7] = new Row(spaces[2], spaces[4], spaces[6]);
        for (int i=0; i<9; i++) {
            spaces[i].setID(i);
        }
        for (int i=0; i<8; i++) {
            rows[i].setID(i);
        }
    }
    
    public int win () {
        for (int i=0; i<8; i++) {
            if (rows[i].isWin() == 0 || rows[i].isWin() == 2) {
                return rows[i].isWin();
            }
        }
        for (int i=0; i<9; i++) {
            if (spaces[i].getOwner() == 1) return -1;
        }
        return 1;
    }

    public Row[] getRows () {
        return rows;
    }

    public Space[] getSpaces () {
        return spaces;
    }

    public void printBoard () {
        String out = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int current = i*3 + j;
                if (spaces[current].getOwner() == 0) {
                    out += "O ";
                } else if (spaces[current].getOwner() == 2){
                    out += "X ";
                } else if (spaces[current].getOwner() == 1) {
                    out += ". ";
                }
            }
            out += "%n";
        }
        System.out.printf(out);
    }


}
