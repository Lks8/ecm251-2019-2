package utilities;

public class Card {
    private CardsNaipes naipe;
    private CardsValues value;

    public Card(CardsNaipes naipe, CardsValues value){
        this.naipe=naipe;
        this.value=value;
    }

    @Override
    public String toString(){
        return " " + value + " " + naipe;
    }
}
