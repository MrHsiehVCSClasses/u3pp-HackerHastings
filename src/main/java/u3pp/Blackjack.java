package u3pp;
import java.util.Scanner;

public class Blackjack {
    private Deck myDeck = new Deck();
    private Card[] userHand;
    private Card[] dealerHand;
    private boolean runPlay;

            //This should instantiate any instance variables you have, especially your `Deck`.
    public Blackjack(){
        myDeck.shuffle();
        userHand = new Card[8];
        dealerHand = new Card[8];
        runPlay = false;
    }

            //The method to be called to actually runPlay a game. This is where you implement the flow of the **GamerunPlay**. The output should clearly communicate what is happening - cards dealt, comparisons made, etc.
    public void play(Scanner scanner){
        int userHandCount = 2;
        int dealerHandCount = 2;


        System.out.println("Good morning Choom, We headin to Night City or what? (Y)es / (N)o");
        String answer = scanner.nextLine();
        if(answer.equals("y") || answer.equals("Y")){
            System.out.println("Alright Welles, we made it to The Afterlife. Don't lose everything! Be back in an hour. Also, don't fall for the Cyber-Women, ");
            System.out.println("their affection is simply a program.");
            runPlay = true;
        } else if (answer.equals("n") || answer.equals("N")){
            System.out.println("Tf you wanna do then? U got no hoes! Man I'm goin without you. Meet me at The Afterlife.");
            runPlay = true;
        } else{
            System.out.println("You don't have to be an asshole");
            runPlay = false;
        }


        // while loop for core gamerunPlay loop
        while(runPlay == true){
            userHandCount = 2;
            dealerHandCount = 2;
            for(int i = 0; i < userHand.length; i++){
                userHand[i] = null;
                dealerHand[i] = null;
            }
            userHand[0] = myDeck.deal();
            dealerHand[0] = myDeck.deal();
            userHand[1] = myDeck.deal();
            dealerHand[1] = myDeck.deal();
            System.out.println("Your Hand: " + userHand[0] + " " + userHand[1]);
            System.out.println("Dealer's Hand: " + dealerHand[0] + " " + dealerHand[1]);
            
            // first case if both runPlayers got blackjack
            if(isBlackjack(userHand) == true && isBlackjack(dealerHand) == true){
                System.out.println("It's a tie, choom.");
                System.out.println("User Pushes");
                // This segment is used multiple times; it loops to first question if user inputs a bugged input
                // It also allows user to exit the game or to runPlay again
                boolean question = true;
                while(question == true){
                    System.out.println("Alright choom, another round? (Y)es / (N)o");
                    String answer1 = scanner.nextLine();
                    if(answer1.equals("y") || answer1.equals("Y") || answer1.equals("yes") || answer1.equals("Yes")){
                        question = false;
                        runPlay = true;
                    } else if (answer1.equals("n") || answer1.equals("N") || answer1.equals("no") || answer.equals("No")){
                        System.out.println("Okay then, goodbye Eric Hsieh");
                        question = false;
                        runPlay = false;
                    } else {
                        System.out.println("You're speaking in tongues, choom! Gimme something!");
                    }
                }
                //second case where only user has blackjack
            } else if(isBlackjack(userHand) == true && isBlackjack(dealerHand) == false) {
                System.out.println("You Blackjacked choom!");
                System.out.println("User Wins");
                boolean question = true;
                while(question == true){
                    System.out.println("Alright choom, another round? (Y)es / (N)o");
                    String answer1 = scanner.nextLine();
                    if(answer1.equals("y") || answer1.equals("Y") || answer1.equals("yes") || answer1.equals("Yes")){
                        question = false;
                        runPlay = true;
                    } else if (answer1.equals("n") || answer1.equals("N") || answer1.equals("no") || answer.equals("No")){
                        System.out.println("Okay then, goodbye Eric Hsieh");
                        question = false;
                        runPlay = false;
                    } else {
                        System.out.println("You're speaking in tongues, choom! Gimme something!");
                    }
                }
                // Third case where only dealer has blackjack
            } else if(isBlackjack(dealerHand) == true && isBlackjack(userHand) == false) {
                System.out.println("I Blackjacked you, choom.");
                System.out.println("User Loses");
                boolean question = true;
                while(question == true){
                    System.out.println("Alright choom, another round? (Y)es / (N)o");
                    String answer1 = scanner.nextLine();
                    if(answer1.equals("y") || answer1.equals("Y") || answer1.equals("yes") || answer1.equals("Yes")){
                        question = false;
                        runPlay = true;
                    } else if (answer1.equals("n") || answer1.equals("N") || answer1.equals("no") || answer1.equals("No")){
                        System.out.println("Okay then, goodbye Eric Hsieh");
                        question = false;
                        runPlay = false;
                    } else {
                        System.out.println("You're speaking in tongues, choom! Gimme something!");
                    }
                }
                // Fourth and most often case where neither have blackjack
            } else if(isBlackjack(userHand) == false && isBlackjack(dealerHand) == false) {
                        
                        boolean question = true;
                        String answer1 = "";
                        while(question == true){
                            System.out.println("We hittin'(H)it or stayin'? (S)tay");
                                answer1 = scanner.nextLine();
                            
                            if(answer1.equals("h") || answer1.equals("H") || answer1.equals("hit") || answer1.equals("Hit")){
                                question = false;
                            } else if (answer1.equals("s") || answer1.equals("S") || answer1.equals("stay") || answer1.equals("Stay")){
                                question = false;
                            } else {
                                System.out.println("You're speaking in tongues, choom! Gimme something!");
                            }
                        }
                        // Loop that runs to allow user to keep hitting to their heart's desire
                        while(answer1.equals("h") || answer1.equals("H") || answer1.equals("hit") || answer1.equals("Hit")){
                            userHandCount ++;
                            for(int i = 0; i<userHand.length; i++){
                                if(userHand[i] == null){
                                    userHand[i] = myDeck.deal();
                                    break;
                                }
                            }
                            
                            
         
                            if(isBust(userHand)){
                                System.out.println("Your Hand: ");
                            for(int i = 0; i < userHandCount; i++){
                                System.out.print(userHand[i] + " ");
                            }
                                System.out.println("You busted choom! Get good.");
                                System.out.println("User Loses");
                                boolean question1 = true;
                                while(question1 == true){
                                    System.out.println("Alright choom, another round? (Y)es / (N)o");
                                    String answer2 = scanner.nextLine();
                                    if(answer2.equals("y") || answer2.equals("Y") || answer2.equals("yes") || answer2.equals("Yes")){
                                        runPlay = true;
                                        question1 = false;
                                        answer1 = "pebis";
                                    } else if (answer2.equals("n") || answer2.equals("N") || answer2.equals("no") || answer2.equals("No")){
                                        System.out.println("Okay then, goodbye Eric Hsieh");
                                        question1 = false;
                                        runPlay = false;
                                    } else {
                                        System.out.println("You're speaking in tongues, choom! Gimme something!");
                                    }
                                }
                            } else { // If user doesn't bust, prints hand and asks if they want to hit again 
                                System.out.println("Your Hand: ");
                            for(int i = 0; i < userHandCount; i++){
                                System.out.print(userHand[i] + " ");
                            }
                            boolean question7 = true;
                            while(question7 == true){
                                System.out.println("We hittin'(H)it or stayin'? (S)tay");
                                    answer1 = scanner.nextLine();
                                
                                if(answer1.equals("h") || answer1.equals("H") || answer1.equals("hit") || answer1.equals("Hit")){
                                    question7 = false;
                                } else if (answer1.equals("s") || answer1.equals("S") || answer1.equals("stay") || answer1.equals("Stay")){
                                    question7 = false;

                                } else {
                                    System.out.println("You're speaking in tongues, choom! Gimme something!");
                                }
                              }
                            }
                        } 
                    //If user doesn't bust while hitting, this will run. 
            while(answer1.equals("s") || answer1.equals("S") || answer1.equals("stay") || answer.equals("Stay")){
                while(calcPoints(dealerHand) < 17){
                        dealerHandCount ++;
                        for(int i = 0; i<dealerHand.length; i++){
                            if(dealerHand[i] == null){
                                
                                dealerHand[i] = myDeck.deal();
                                break;
                            }
                        }
                        if(isBust(dealerHand)){
                            System.out.println ("\n" + "Dealer's Hand: ");
                            for(int i = 0; i < dealerHandCount; i++){
                                System.out.print(dealerHand[i] + " ");
                            }
                            System.out.println("I busted! Damn cards.");
                            System.out.println("User Wins");
                            boolean question2 = true;
                            while(question2 == true){
                                System.out.println("Alright choom, another round? (Y)es / (N)o");
                                String answer3 = scanner.nextLine();
                                if(answer3.equals("y") || answer3.equals("Y") || answer3.equals("yes") || answer3.equals("Yes")){
                                    question2 = false;
                                    runPlay = true;
                                    answer1 = "shid";
                                } else if (answer3.equals("n") || answer3.equals("N") || answer3.equals("no") || answer3.equals("No")){
                                    System.out.println("Okay then, goodbye Eric Hsieh");
                                    question2 = false;
                                    runPlay = false;
                                } else {
                                    System.out.println("You're speaking in tongues, choom! Gimme something!");
                                }
                            }
                        }
                }
                // If the dealer busts, and the runPlayer wants to runPlay again, this if statement makes it so that it doesn't run 
                // unless the dealer didn't bust.
                if(answer1.equals("s") || answer1.equals("S") || answer1.equals("stay") || answer.equals("Stay")){
                System.out.println("Your Hand: ");
                    for(int i = 0; i < userHandCount; i++){
                        System.out.print(userHand[i] + " ");
                    }
                System.out.println ("\n" + "Dealer's Hand: ");
                    for(int i = 0; i < dealerHandCount; i++){
                        System.out.print(dealerHand[i] + " ");
                    }
                System.out.println(determineResult(userHand, dealerHand));
                boolean question3 = true;
                while(question3 == true){
                    System.out.println("Alright choom, another round? (Y)es / (N)o");
                    String answer4 = scanner.nextLine();
                    if(answer4.equals("y") || answer4.equals("Y") || answer4.equals("yes") || answer4.equals("Yes")){
                        question3 = false;
                        runPlay = true;
                        answer1 = "shid";
                    } else if (answer4.equals("n") || answer4.equals("N") || answer4.equals("no") || answer4.equals("No")){
                        System.out.println("Okay then, goodbye Eric Hsieh");
                        question3 = false;
                        runPlay = false;
                    } else {
                        System.out.println("You're speaking in tongues, choom! Gimme something!");
                    }
                  }
                }
            }


        }

        }
    }

            //This helper method takes an array of `Card`s and returns the amount of points that hand is worth. Post condition: the parameter should remain unaltered.
    public static int calcPoints(Card[] hand){
        int handValue = 0;
        for(int i=0; i<hand.length; i++){
            if(hand[i] == null){
                return handValue;
            }
            if(hand[i].getValue().equals("1") ||hand[i].getValue().equals("2") ||hand[i].getValue().equals("3") ||hand[i].getValue().equals("4") ||hand[i].getValue().equals("5") ||hand[i].getValue().equals("6") ||hand[i].getValue().equals("7") ||hand[i].getValue().equals("8") ||hand[i].getValue().equals("9") ||hand[i].getValue().equals("10")){
            handValue += Integer.valueOf(hand[i].getValue());
            } else if(hand[i].getValue().equals("Jack") ||hand[i].getValue().equals("Queen") ||hand[i].getValue().equals("King")){
                handValue += 10;
            }  else if(hand[i].getValue().equals("Ace")){
                handValue += 11;
            }
        }
        return handValue;        
    }

            //Returns a `String` in one of the following formats: `"User Wins"`, `"User Loses"`, or `"User Pushes"`. Does not alter parameters.
    public static String determineResult(Card[] userHand, Card[] dealerHand){
        int userHandCurrent = getHandValue(userHand);
        int dealerHandCurrent = getHandValue(dealerHand);

        if(dealerHandCurrent == userHandCurrent){
            return "User Pushes";
        } else if(21-userHandCurrent < 21-dealerHandCurrent){
            return "User Wins";
        } else if(21-userHandCurrent > 21-dealerHandCurrent){
            return "User Loses";
        } else{
            return null;
        }
    }

            //returns `true` if the hand is a *Bust*, `false` otherwise. Does not alter parameters.
    public static boolean isBust(Card[] hand){
        if(getHandValue(hand)>21){
            return true;
        } else {
            return false;
        }
        
    }

            //returns `true` if the hand is a *Blackjack*, `false` otherwise. Remember, it is only a blackjack in the opening hand (2 card hand). Does not alter parameters.
    public static boolean isBlackjack(Card[] hand){
    if(hand.length >2){
        if(hand[2] != null){
        return false;
        }
    }
        if(getHandValue(hand)==21){
            return true;
        } else{
            return false;
        }
    }

            //return `true` if the dealer should keep hitting (score of hand is 16 or less), `false` otherwise. Does  not alter parameters.
    public static boolean shouldDealerKeepHitting(Card[] hand){
        if(getHandValue(hand)<=16){
            return true;
        } else{
            return false;
        }
    }

            //Duplicate of calcPoints made by accident but used somewhere before I realized I should have used calcPoints instead.
    public static int getHandValue(Card[] hand){
        int handValue = 0;
        for(int i=0; i<hand.length; i++){
            if(hand[i] == null){
                return handValue;
            }
            if(hand[i].getValue().equals("1") ||hand[i].getValue().equals("2") ||hand[i].getValue().equals("3") ||hand[i].getValue().equals("4") ||hand[i].getValue().equals("5") ||hand[i].getValue().equals("6") ||hand[i].getValue().equals("7") ||hand[i].getValue().equals("8") ||hand[i].getValue().equals("9") ||hand[i].getValue().equals("10")){
            handValue += Integer.valueOf(hand[i].getValue());
            } else if(hand[i].getValue().equals("Jack") ||hand[i].getValue().equals("Queen") ||hand[i].getValue().equals("King")){
                handValue += 10;
            }  else if(hand[i].getValue().equals("Ace")){
                handValue += 11;
            }
        }
        return handValue;       
    }
}

