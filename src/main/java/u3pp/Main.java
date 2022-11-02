package u3pp;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) {
        
        // String myPenis = "penis";
        // String myBallab = "Ballab";
        // PalindromeTester myPalindromeTester = new PalindromeTester();
        Deck myDeck = new Deck();
        Card[] hand2 = { new Card("Clubs", "Ace"), new Card("Spades", "Jack") };
        Scanner myScanner = new Scanner(System.in);  
        Blackjack myBlackjack = new Blackjack();
        myBlackjack.Play(myScanner);
        // Use this space to test your code, or actually run your project
        
        
       
        
    }

}
