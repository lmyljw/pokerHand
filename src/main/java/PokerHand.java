package main.java;

public class PokerHand {

    public final static String PLAYER_1_WIN = "Player 1 Win";
    public final static String PLAYER_2_WIN = "Player 2 Win";

    public String exec(String card1, String card2) {

        int card1Number = Integer.parseInt(card1.substring(0, 1));
        int card2Number = Integer.parseInt(card2.substring(0, 1));

        String result=card1Number > card2Number?PLAYER_1_WIN:PLAYER_2_WIN;

        return result;
    }
}
