package com.example.homefolder.blackjackapp;


import java.util.Collections;
import java.util.LinkedList;

/**
 * This is a deck class that holds the structure and logic of a Deck
 *
 * @author Andy St. Jean
 * @version 1.0 10/4/2018
 **/

public class Deck {

    /**
     * the deck of cards
     */
    private LinkedList<Card> cards;

    /**
     * Creates a new deck
     */
    public Deck() {

        this.cards = new LinkedList<>();
        this.cards = shuffle();
    }

    /**
     *  creates and shuffles a new deck of cards
     *
     * @return a new, shuffled list of cards
     */
    static LinkedList<Card> shuffle() {
        LinkedList<Card> list = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                Card temp = new Card(j ,i);
                list.add(temp);
            }
        }

        Collections.shuffle(list);

        return list;
    }

    /**
     * prints out the whole deck
     */
    public void dump() {
        for(Card c: cards) {
            c.toString();
        }
    }

    /**
     * Returns the top card off the deack. Used to deal cards
     *
     * @return the front card from the deck
     */
    public Card deal() {

        if(this.cards.isEmpty())
            this.cards = shuffle();

        return this.cards.pop();

    }
}
