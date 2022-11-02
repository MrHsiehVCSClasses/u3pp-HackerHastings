package u3pp;
import java.util.Random;

public class Deck {
   
    Random rand = new Random();
    Card[] deck = new Card[52];
    private int deckIndex = 0;
    private int cardsLeft=52;

    public Deck(){
        int k = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                
                deck[k] = new Card(Card.SUITS[i], Card.VALUES[j]);
                
                //deck[k].setSuit(SUITS[i]);
                //deck[k].setValue(VALUES[j]);
                k += 1;
            }
        }
        for(int i=0; i<deck.length; i++){
            System.out.println(deck[i]);
        }
    }

    public int numLeft(){
       
        return cardsLeft;
    }

    public Card deal(){
        if(cardsLeft > 0){
        deckIndex += 1;
        cardsLeft -= 1;
        return deck[deckIndex-1];
        } else {
            shuffle();
            deckIndex += 1;
            cardsLeft -= 1;
            return deck[deckIndex-1];
        } 
    }

    public void shuffle(){
        deckIndex = 0;
        cardsLeft = 52;
        for(int i = 0; i < deck.length; i++){
            Card Temporary = deck[i];
            int newSwap = rand.nextInt(52);
            deck[i] = deck[newSwap];
            deck[newSwap] = Temporary;
        }
    }
    
}
