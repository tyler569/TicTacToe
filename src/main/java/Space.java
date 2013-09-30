/**
 * TicTacToe
 * Copyright (C) 2013 Tyler Philbrick
 * Licensed GNU GENERAL PUBLIC LICENSE Version 2
 * See LICENSE.txt for full license
 */

package main.java;

class Space {
    private int owner = 1;
    private int spaceID = -1;

    public void setID (int ID) {
        spaceID = ID;
    }

    public int getID () {
        return spaceID;
    }

    public int take (int newOwner) {
        if ((newOwner == 0 || newOwner == 2) && owner == 1) {
            owner = newOwner;
            return 1;
        }
        return 0;
    }

    public int getOwner () {
        return owner;
    }
}
