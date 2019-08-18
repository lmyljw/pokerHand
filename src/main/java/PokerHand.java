package main.java;

public class PokerHand {

    public final static String PLAYER_1_WIN = "Player 1 Win";
    public final static String PLAYER_2_WIN = "Player 2 Win";
    public final static String PEACE = "Peace";

    public String play(String card1, String card2) {

        Poker player1Poker = new Poker(card1.substring(0,1),card1.substring(1,2));
        Poker player2Poker = new Poker(card2.substring(0,1),card2.substring(1,2));
        int result = player1Poker.compareTo(player2Poker);

        if (result > 0) {
            return PLAYER_1_WIN;
        } else if (result < 0) {
            return PLAYER_2_WIN;
        } else {
            return PEACE;
        }

    }
}
