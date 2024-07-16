import java.util.*;

public class DeckOfCards {
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_PLAYERS = 4;
    private static final int CARDS_PER_PLAYER = 9;

    public static void main(String[] args) {
        List<String> deck = initializeDeck();
        shuffleDeck(deck);
        String[][] playersCards = distributeCards(deck);
        printPlayersCards(playersCards);
    }

    private static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private static void shuffleDeck(List<String> deck) {
        long seed = System.nanoTime(); // Get a unique seed
        Collections.shuffle(deck, new Random(seed));
    }

    private static String[][] distributeCards(List<String> deck) {
        String[][] playersCards = new String[NUM_PLAYERS][CARDS_PER_PLAYER];
        int index = 0;
        for (int player = 0; player < NUM_PLAYERS; player++) {
            for (int card = 0; card < CARDS_PER_PLAYER; card++) {
                playersCards[player][card] = deck.get(index++);
            }
        }
        return playersCards;
    }

    private static void printPlayersCards(String[][] playersCards) {
        for (int player = 0; player < NUM_PLAYERS; player++) {
            System.out.printf("Player %d's cards:%n", player + 1);
            for (int card = 0; card < CARDS_PER_PLAYER; card++) {
                System.out.println(playersCards[player][card]);
            }
            System.out.println();
        }
    }
}

