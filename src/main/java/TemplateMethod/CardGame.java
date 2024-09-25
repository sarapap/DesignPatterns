package TemplateMethod;

public class CardGame extends Game {
    private Deck cards;
    private int player1;
    private int player2;
    private int player1Wins;
    private int player2Wins;
    private int rounds;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Tässä pelissä voittaja on se, joka nostaa isomman kortin.");
        cards = new Deck();
        player1Wins = 0;
        player2Wins = 0;
        rounds = 0;
    }

    @Override
    public boolean endOfGame() {
        return cards.isEmpty();
    }

    @Override
    public void playSingleTurn(int player) {
        if (endOfGame()) {
            System.out.println("Peli päättyi!");
        }

        player1 = cards.drawCard();
        System.out.println("Pelaaja 1 nosti kortin: " + player1);
        player2 = cards.drawCard();
        System.out.println("Pelaaja 2 nosti kortin: " + player2);

        rounds++;
        if (player1 > player2) {
            player1Wins++;
            System.out.println("Pelaaja 1 voitti kierroksen!");
        } else if (player1 < player2) {
            player2Wins++;
            System.out.println("Pelaaja 2 voitti kierroksen!");
        } else {
            System.out.println("Tasapeli!");
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Peli on päättynyt.");

        if (player1 > player2) {
            System.out.println("Pelaaja 1 voitti pelin! Tämä pelaaja voitti enemmän kierroksia.");
        } else if (player2 > player1) {
            System.out.println("Pelaaja 2 voitti pelin! Tämä pelaaja voitti enemmän kierroksia.");
        } else {
            System.out.println("Peli päättyi tasapeliin! Pelaajat voittivat yhtä monta kierrosta.");
        }
    }
}