/**
 * TicTacToe
 * Copyright (C) 2013 Tyler Philbrick
 * Licensed GNU GENERAL PUBLIC LICENSE Version 2
 * See LICENSE.txt for full license
 */

package main.java;

class AI {
    private Board board;
    private Row[] rows;
    private Space[] spaces;

    public AI (Board assocBoard) {
        board = assocBoard;
        rows = board.getRows();
        spaces = board.getSpaces();
    }

    public void AIroutine () {
        int t;
        t = tryWinSave();
        if (t == 0) {
            t = tryForkStop();
            if (t == 0) {
                t = tryTake();
                if (t == 0) {
                    throw new RuntimeException();
                }
            }
        }
        // System.out.println(t);
    }

    private int tryWinSave () {
        for (int i=0; i<8; i++) {  // Step 1: Win
            if (rows[i].state(0) == 2) {
                if (rows[i].getEmptySpace() != null) {
                    rows[i].getEmptySpace().take(0);
                    return 1;
                }
            }
        }
        for (int i=0; i<8; i++) {  // Step 2: Block
            if (rows[i].state(2) == 2) {
                if (rows[i].getEmptySpace() != null) {
                    rows[i].getEmptySpace().take(0);
                    return 2;
                }
            }
        }
        return 0;
    }

    private int tryForkStop () {
        for (int i=0; i<8; i++) {  // Step 3: Fork
            for (int j=0; j<8; j++) {
                if (rows[i].state(0) == 1 && rows[i].state(2) == 0 &&
                        rows[j].state(0) == 1 && rows[j].state(2) == 0 &&
                        rows[i].rowIntersection(rows[j]) != null) {
                    if(rows[i].rowIntersection(rows[j]).getOwner() == 1) {
                        rows[i].rowIntersection(rows[j]).take(0);
                        return 3;
                    }
                }
            }
        }
        for (int i=0; i<8; i++) {  // Step 4, Option 2: Block Fork
            for (int j=0; j<8; j++) {
                if (rows[i].state(0) == 0 && rows[i].state(2) == 1 &&
                        rows[j].state(0) == 0 && rows[j].state(2) == 1 &&
                        rows[i].rowIntersection(rows[j]) != null) {
                    if (rows[i].rowIntersection(rows[j]).getOwner() == 1) {
                        for (int k=1; k<8; k++) {
                            if (rows[k].state(0) == 1 && rows[k].state(2) == 0 &&
                                    rows[k].getEmptySpace().getID() != rows[i].rowIntersection(rows[j]).getID()) {
                                rows[k].getEmptySpace().take(0);
                                return 4; // Remove this return to blow up Eric's head!!  <<<<<<<<<<<<---------------
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<8; i++) {  // Step 4, Option 2: Block Fork
            for (int j=0; j<8; j++) {
                if (rows[i].state(0) == 0 && rows[i].state(2) == 1 &&
                        rows[j].state(0) == 0 && rows[j].state(2) == 1 &&
                        rows[i].rowIntersection(rows[j]) != null) {
                    if(rows[i].rowIntersection(rows[j]).getOwner() == 1) {
                        rows[i].rowIntersection(rows[j]).take(0);
                        return 5;
                    }
                }
            }
        }
        return 0;
    }

    private int tryTake () {
        if (spaces[4].getOwner() == 1) {  // Step 5: Center
            spaces[4].take(0);
            return 6;
        }
        // Step 6: Opposite Corner
        if (spaces[0].getOwner() == 2 && spaces[8].getOwner() == 1) {
            spaces[8].take(0);
            return 7;
        }
        if (spaces[2].getOwner() == 2 && spaces[6].getOwner() == 1) {
            spaces[6].take(0);
            return 8;
        }
        if (spaces[8].getOwner() == 2 && spaces[0].getOwner() == 1) {
            spaces[0].take(0);
            return 9;
        }
        if (spaces[6].getOwner() == 2 && spaces[2].getOwner() == 1) {
            spaces[2].take(0);
            return 10;
        }
        // Step 7: Corner
        if (spaces[0].getOwner() == 1) {
            spaces[0].take(0);
            return 11;
        }
        if (spaces[2].getOwner() == 1) {
            spaces[2].take(0);
            return 12;
        }
        if (spaces[8].getOwner() == 1) {
            spaces[8].take(0);
            return 13;
        }
        if (spaces[6].getOwner() == 1) {
            spaces[6].take(0);
            return 14;
        }
        // Step 8: Side
        if (spaces[1].getOwner() == 1) {
            spaces[1].take(0);
            return 15;
        }
        if (spaces[5].getOwner() == 1) {
            spaces[5].take(0);
            return 16;
        }
        if (spaces[7].getOwner() == 1) {
            spaces[7].take(0);
            return 17;
        }
        if (spaces[3].getOwner() == 1) {
            spaces[3].take(0);
            return 18;
        }
        return 0;
    }
}
