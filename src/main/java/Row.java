package main.java;

/**
 * TicTacToe
 * Copyright Tyler Philbrick; 2013
 * Created: 9/22/13
 */

class Row {
    private Space[] spaces = new Space[3];
    private int rowID = -1;

    public Row (Space space0, Space space1, Space space2) {
        spaces[0] = space0;
        spaces[1] = space1;
        spaces[2] = space2;
    }

    public void setID (int ID) {
        rowID = ID;
    }

    public int getID () {
        return rowID;
    }

    public Space[] getSpaces () {
        return spaces;
    }

    public int isWin () {
        if (spaces[0].getOwner() == spaces[1].getOwner() && spaces[1].getOwner() == spaces[2].getOwner()) {
            return spaces[0].getOwner();
        } else {
            return -1;
        }
    }

    public int state (int player) {
        int x = 0;
        int o = 0;

        for (int i=0; i<3; i++) {
            if (spaces[i].getOwner() == 2) {
                x++;
            } else if (spaces[i].getOwner() == 0) {
                o++;
            }
        }
        if (player == 0) return o;
        if (player == 2) return x;
        return -1;
    }

    public Space rowIntersection (Row otherRow) {
        if(rowID == otherRow.getID()) return null;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (spaces[i].getID() == otherRow.getSpaces()[j].getID()){
                    if (this.getID() != otherRow.getID()) return spaces[i];
                }
            }
        }
        return null;
    }

    public Space getEmptySpace () {
        for (int i=1; i<3; i++) {
            if (spaces[i].getOwner() == 1) return spaces[i];
        }
        return null;
    }
}
