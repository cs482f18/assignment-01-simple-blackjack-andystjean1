package com.example.homefolder.blackjackapp;

/**
 * This is the User class that holds the structure and logic of the User
 *
 * @author Andy St. Jean
 * @version 1.0 10/4/2018
 **/
public class User extends Player {

    /**
     * the number of times the user has hit in a turn (Max: 3)
     */
    private int hitCount;

    /**
     *  Creates a new User
     * @param p
     *      The player next to the user
     */
    public User(Player p) {
        super(p);
        hitCount = 0;
    }
}
