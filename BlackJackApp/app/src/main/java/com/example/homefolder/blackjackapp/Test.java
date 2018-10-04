package com.example.homefolder.blackjackapp;

public class Test {
    public static void main(String[] args) {

        Player p1 = new Player(null);

        Deck deck = new Deck();

        for(int i = 0; i < 2; i++){
            p1.hit(deck);
        }

        p1.dumpHand();
        System.out.println(p1.sumHand());








 
    }
}
