package com.hemalpatel.datastructure.Stack;

/**
 * Test functionality for different implementation of {@link IStack}
 *
 */
public class StackExecutor {

    private IStack<String> cardStack = new ListStackDataStructure<>();

    public static void main(String[] args) {
        StackExecutor executor = new StackExecutor();

        // Stack all cards
        executor.stackCards();

        // Check the size
        executor.stackSize();

        // Unstack all cards
        executor.unstackAllCards();

        // Check the size
        executor.stackSize();

        // Restack all cards
        executor.stackCards();

        // See if deck has "Ace of Diamonds"
        executor.containsCard("Ace of Diamonds");

        // Validate the negative scenario
        executor.containsCard("Joker");

        // Find "Ace of Clubs"
        executor.getACard("Ace of Clubs");

        // Check final size
        executor.stackSize();
    }

    // Lets complete the deck by adding all cards to stack
    public void stackCards() {

        // Push spades suit
        cardStack.push("Ace of Spades");
        cardStack.push("2 of Spades");
        cardStack.push("3 of Spades");
        cardStack.push("4 of Spades");
        cardStack.push("5 of Spades");
        cardStack.push("6 of Spades");
        cardStack.push("7 of Spades");
        cardStack.push("8 of Spades");
        cardStack.push("9 of Spades");
        cardStack.push("10 of Spades");
        cardStack.push("Jack of Spades");
        cardStack.push("Queen of Spades");
        cardStack.push("King of Spades");

        // Push Hearts suit
        cardStack.push("Ace of Hearts");
        cardStack.push("2 of Hearts");
        cardStack.push("3 of Hearts");
        cardStack.push("4 of Hearts");
        cardStack.push("5 of Hearts");
        cardStack.push("6 of Hearts");
        cardStack.push("7 of Hearts");
        cardStack.push("8 of Hearts");
        cardStack.push("9 of Hearts");
        cardStack.push("10 of Hearts");
        cardStack.push("Jack of Hearts");
        cardStack.push("Queen of Hearts");
        cardStack.push("King of Hearts");

        // Push Diamonds suit
        cardStack.push("Ace of Diamonds");
        cardStack.push("2 of Diamonds");
        cardStack.push("3 of Diamonds");
        cardStack.push("4 of Diamonds");
        cardStack.push("5 of Diamonds");
        cardStack.push("6 of Diamonds");
        cardStack.push("7 of Diamonds");
        cardStack.push("8 of Diamonds");
        cardStack.push("9 of Diamonds");
        cardStack.push("10 of Diamonds");
        cardStack.push("Jack of Diamonds");
        cardStack.push("Queen of Diamonds");
        cardStack.push("King of Diamonds");


        // Push Clubs suit
        cardStack.push("Ace of Clubs");
        cardStack.push("2 of Clubs");
        cardStack.push("3 of Clubs");
        cardStack.push("4 of Clubs");
        cardStack.push("5 of Clubs");
        cardStack.push("6 of Clubs");
        cardStack.push("7 of Clubs");
        cardStack.push("8 of Clubs");
        cardStack.push("9 of Clubs");
        cardStack.push("10 of Clubs");
        cardStack.push("Jack of Clubs");
        cardStack.push("Queen of Clubs");
        cardStack.push("King of Clubs");
    }

    public void unstackAllCards() {
        System.out.println("Unstacked cards: ");
        while(cardStack.size() > 0) {
            System.out.println(cardStack.pop());
        }
    }

    public void containsCard(String cardName) {
        System.out.println("Does stack has \"" + cardName + "\"? " + cardStack.contains(cardName));
    }

    public void getACard(String cardName) {
        System.out.println(cardStack.access(cardName));
    }

    public void stackSize() {
        System.out.println(cardStack.size());
    }
}
