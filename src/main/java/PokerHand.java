package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {

    public final static String PLAYER_1_WIN = "Player 1 Win";
    public final static String PLAYER_2_WIN = "Player 2 Win";
    public final static String PEACE = "Peace";

    public String play(String cards1, String cards2) {

        List<Poker> player1Poker = sortCards(cards1);
        List<Poker> player2Poker = sortCards(cards2);

        int result = player1Poker.get(0).compareTo(player2Poker.get(0));

        if (result > 0) {
            return PLAYER_1_WIN;
        } else if (result < 0) {
            return PLAYER_2_WIN;
        } else {
            return PEACE;
        }

    }

    public List<Poker> sortCards(String cards){
        return (List<Poker>) Arrays.stream(cards.split(" "))
                .map(card -> new Poker(card.substring(0, 1), card.substring(1, 2)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
