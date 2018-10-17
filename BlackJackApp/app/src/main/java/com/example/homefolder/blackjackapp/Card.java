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
    private String[] suits = {"s", "h", "d", "c"}; // you should also look into using java enum for these

    /**
     * values of ranks for printing
     */
    private String[] ranks = {"a", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "j", "q", "k"};

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

    @Override
    public String toString(){
        return ranks[this.rank] + suits[this.suit];
    }

    /**
     * returns the value of the card for scoring
     *
     * @return
     *      the value of the card according to the scoring rules of black jack
     */
    public int value() {
        //face value cards
        if(this.rank >= 9)
            return 10;
        //the ace
        else if(this.rank == 0)
            return 11;
        //other cards
        else
            return this.rank + 1;
    }
}
