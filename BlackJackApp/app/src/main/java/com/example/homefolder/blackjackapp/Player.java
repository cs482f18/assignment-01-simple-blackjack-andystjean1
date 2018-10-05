package com.example.homefolder.blackjackapp;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This is a Player class that holds the structure and logic of a Player
 *
 * @author Andy St. Jean
 * @version 1.0 10/4/2018
 **/

public class Player {

    /**
     * the players hand
     */
    protected ArrayList<Card> hand;

    /**
     * the player whose turn is next
     */
    protected Player next;

    /**
     * creates a new player
     *
     * @param p
     *       the player to be set as next
     */
    public Player(Player p) {
        hand = new ArrayList<>();
        next = p;
    }

    /**
     * the score of the player's hand
     */
    protected int score;

    /**
     * Deals another card to the player
     *
     * @param d
     *      the deck to deal from
     */
    public void hit(Deck d) {
        Card c = d.deal();
        this.hand.add(c);
    }

    /**
     * @return the player whose turn is next
     */
    public Player stay() {
        return this.next;
    }


    /**
     *  prints out the hand for debugging
     */
    public void dumpHand(){
        for(Card c: hand) {
            c.toString();
        }
    }


    /**
     *  Calculates the total number of points in a players hand
     * @return
     *      the number of points in the players hand
     */
    protected int sumHand(){
        int total = 0;
        boolean has_ace = false;

        for(Card c: hand) {
            total += c.value();
            if(c.toString().charAt(0) == 'a')
                has_ace = true;
        }

        if(total > 21 && has_ace)
            total-=10;

        //add logic for ace to be 1 or 11

        return total;
    }
}
