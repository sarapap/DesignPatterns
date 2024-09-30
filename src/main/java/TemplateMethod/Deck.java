package TemplateMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Integer> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        shuffle();
    }

    private void createDeck() {
        for (int i = 1; i <= 52; i++) {
            cards.add(i);
        }
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Integer drawCard() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}

