import java.util.*;

class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Player {
    String name;
    Node head;
    Node tail;

     class Node {
        Card card;
        Node next;

        public Node(Card card) {
            this.card = card;
            this.next = null;
        }
    }

    public Player(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
    }

    public void addCard(Card card) {
        Node newNode = new Node(card);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sortCardsByRank() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node index = null;
        Card temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.card.rank.compareTo(index.card.rank) > 0) {
                    temp = current.card;
                    current.card = index.card;
                    index.card = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void printCards() {
        System.out.printf("Player %s's cards:\n", name);
        Node current = head;
        while (current != null) {
            System.out.println(current.card);
            current = current.next;
        }
        System.out.println();
    }
}

public class DeckOfCards2 {
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_PLAYERS = 4;
    private static final int CARDS_PER_PLAYER = 9;

    public static void main(String[] args) {
        Player[] players = new Player[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++) {
            players[i] = new Player(String.valueOf(i + 1));
        }

        Card[] deck = initializeDeck();
        shuffleDeck(deck);

        distributeCards(players, deck);

        for (Player player : players) {
            player.sortCardsByRank();
            player.printCards();
        }
    }

    private static Card[] initializeDeck() {
        Card[] deck = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(rank, suit);
            }
        }
        return deck;
    }

    private static void shuffleDeck(Card[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[j];
            deck[j] = deck[i];
            deck[i] = temp;
        }
    }

    private static void distributeCards(Player[] players, Card[] deck) {
        int index = 0;
        for (int playerIndex = 0; playerIndex < NUM_PLAYERS; playerIndex++) {
            for (int cardIndex = 0; cardIndex < CARDS_PER_PLAYER; cardIndex++) {
                players[playerIndex].addCard(deck[index++]);
            }
        }
    }
}