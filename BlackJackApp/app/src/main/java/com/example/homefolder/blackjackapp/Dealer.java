package com.example.homefolder.blackjackapp;


/**
 * This is a Dealer class that holds the structure and logic of the Dealer
 *
 * @author Andy St. Jean
 * @version 1.0 10/4/2018
 **/

public class Dealer extends Player {


    /**
     *  Creates a new dealer, uses super player constructor
     * @param p
     *      the player that is next to the dealer
     */
    public Dealer(Player p) {
        super(p);
    }


    /**
     * Sets the player nex to the dealer
     * @param p the player next to the dealer
     */
    public void setNext(Player p) {
        this.next = p;
    }

    /**
     * checks if the dealer wants another card
     *
     * @return returns true if the dealers score is below 17, else returns true
     */
    public boolean wantCard() {
        if(this.sumHand() >= 17)
            return false;

        return true;
    }

}
