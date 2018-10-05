package com.example.homefolder.blackjackapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameActivity extends AppCompatActivity {

    int index = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        //create the user and dealer and set them next to each other
        final Dealer dealer = new Dealer(null);
        final User user = new User(dealer);
        dealer.setNext(user);

        //create the deck
        final Deck deck = new Deck();

        //Initialize User and Dealer Hand lists
        final ArrayList<ImageView> dealerHand = new ArrayList<>();
        final ArrayList<ImageView> userHand = new ArrayList<>();

        //Dealer Hand Image views
        dealerHand.add((ImageView) findViewById(R.id.dealerCard1));
        dealerHand.add((ImageView) findViewById(R.id.dealerCard2));
        dealerHand.add((ImageView) findViewById(R.id.dealerCard3));
        dealerHand.add((ImageView) findViewById(R.id.dealerCard4));
        dealerHand.add((ImageView) findViewById(R.id.dealerCard5));

        //User Hand Image views
        userHand.add((ImageView) findViewById(R.id.userCard1));
        userHand.add((ImageView) findViewById(R.id.userCard2));
        userHand.add((ImageView) findViewById(R.id.userCard3));
        userHand.add((ImageView) findViewById(R.id.userCard4));
        userHand.add((ImageView) findViewById(R.id.userCard5));

        // set to transparent
        for(ImageView v: dealerHand) {
            v.setAlpha(0f);
        }
        for(ImageView v: userHand) {
            v.setAlpha(0f);
        }

        //New Game Button
        Button newGameBtn = (Button) findViewById(R.id.newGameBtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(ImageView c: dealerHand) {
                    c.setAlpha(0f);
                }
                for(ImageView c: userHand) {
                    c.setAlpha(0f);
                }

                //clear user and dealer hands
                if(dealer.hand.size() > 0 || user.hand.size() > 0) {
                    dealer.hand.clear();
                    user.hand.clear();
                }

                //deal first two cards
                for(int i = 0; i < 2; i++) {
                    user.hit(deck);
                    dealer.hit(deck);
                    String userCard = user.hand.get(i).toString();
                    String dealerCard = dealer.hand.get(i).toString();
                    userHand.get(i).setImageResource(getResources().getIdentifier(userCard, "drawable", getPackageName()));
                    dealerHand.get(i).setImageResource(getResources().getIdentifier(dealerCard, "drawable", getPackageName()));
                    userHand.get(i).setAlpha(1f);
                    dealerHand.get(i).setAlpha(1f);
                }

                dealerHand.get(1).setImageResource(R.drawable.red_back);

                user.hitCount = 0;
                index = 2;
            }
        });

        //Hit button
        Button hitBtn = (Button) findViewById(R.id.hitBtn);
        hitBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if(user.hitCount < 3) {
                    user.hit(deck);
                    String userCard = user.hand.get(index).toString();
                    userHand.get(index).setImageResource(getResources().getIdentifier(userCard, "drawable", getPackageName()));
                    userHand.get(index).setAlpha(1f);
                    index++;
                    user.hitCount++;

                }
            }
        });

        //Stay button
        Button stayBtn = (Button) findViewById(R.id.stayBtn);
        stayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dealerCard = dealer.hand.get(1).toString();
                dealerHand.get(1).setImageResource(getResources().getIdentifier(dealerCard, "drawable", getPackageName()));


            }
        });
    }
}
