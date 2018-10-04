package com.example.homefolder.blackjackapp;

/**
 * This is a card class that holds the structure and logic of a Card
 *
 * @author Andy St. Jean
 * @version 1.0 10/4/2018
 **/

public class Card {

    /**
     * the rank of this card
     */
    private int rank;

    /**
     * the suit of this card
     */
    private int suit;

    /**
     * values of suits for printing
     */

    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    /**
     * values of ranks for printing
     */
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    /**
     *  Creates a card with given suit and rank
     *
     * @param rank
     *         the rank of the card value 0 - 12
     * @param suit
     *         the suit of the card value 0-3
     */
    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     *  prints the card in 'rank of suit' format
     */
    public void display() {
        System.out.println(ranks[this.rank] + " of " + suits[this.suit]);
    }

    /**
     * returns the value of the card for scoring
     *
     * @return
     *      the value of the card according to the scoring rules of black jack
     */
    public int value() {
        if(this.rank >= 9)
            return 10;
        else
            return this.rank + 1;
    }
}
