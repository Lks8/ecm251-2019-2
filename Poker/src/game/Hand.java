package game;

import utilities.Card;

import java.util.List;

public class Hand {
    public List<Card> cards;

    public Hand(List<Card> cardList){
        cards=cardList;
    }

    public List<Card> getHand() {
        return cards;
    }
}
