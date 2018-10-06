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
     */
    public Dealer() {
        super();
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
