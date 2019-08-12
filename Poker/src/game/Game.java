package game;

import utilities.Card;
import utilities.Deck;

public class Game {
    public Deck deck;
    public Dealer dealer;
    public Hand hand;

    public Game(){
        deck = new Deck();
        dealer = new Dealer();
    }

    public void play(){
        hand = dealer.deal(deck);
        for(Card card :hand.getHand()) {
            System.out.println("Cartas:" + card);
        }
    }
}
