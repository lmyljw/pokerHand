package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class PokerHand {

    public final static String PLAYER_1_WIN = "Player 1 Win";
    public final static String PLAYER_2_WIN = "Player 2 Win";
    public final static String PEACE = "Peace";

    public String play(String cards1, String cards2) {

        int result = 0;
        Map<Integer, Long> player1PokerMap = mapCards(cards1);
        Map<Integer, Long> player2PokerMap = mapCards(cards2);

        if(player1PokerMap.size() < 5 || player2PokerMap.size() < 5){
            result = -(Integer.compare(player1PokerMap.size(),player2PokerMap.size()));
            if(result == 0) {
                result = comparePair(player1PokerMap, player2PokerMap);
            }
        }
        if(result == 0){
            result = compareHighCard(cards1, cards2);
        }

        return getFinalResult(result);

    }

    public Map<Integer,Long> mapCards(String cards){
        return Arrays.stream(cards.split(" "))
                .map(card -> new Poker(card.substring(0, 1), card.substring(1, 2)))
                .collect(Collectors.groupingBy(Poker::getNumber,Collectors.counting()));
    }

    public List<Poker> sortCards(String cards){
        return (List<Poker>) Arrays.stream(cards.split(" "))
                .map(card -> new Poker(card.substring(0, 1), card.substring(1, 2)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public int compareHighCard(String cards1, String cards2){
        int result = 0;

        List<Poker> player1Poker = sortCards(cards1);
        List<Poker> player2Poker = sortCards(cards2);

        for (int i = 0; i < player1Poker.size(); i++) {
            result = player1Poker.get(i).compareTo(player2Poker.get(i));
            if(result!=0)break;
        }
        return result;
    }

    public String getFinalResult(int result){
        if (result > 0) {
            return PLAYER_1_WIN;
        } else if (result < 0) {
            return PLAYER_2_WIN;
        } else {
            return PEACE;
        }
    }

    public int comparePair(Map<Integer, Long> player1PokerMap,Map<Integer, Long> player2PokerMap){
        int player1PairNumber = 0;
        int player2PairNumber = 0;

        for (Integer number : player1PokerMap.keySet()) {
            Long count = player1PokerMap.get(number);
            if (count == 2) player1PairNumber = number;
        }

        for (Integer number : player2PokerMap.keySet()) {
            Long count = player2PokerMap.get(number);
            if (count == 2) player2PairNumber = number;
        }

        return Integer.compare(player1PairNumber, player2PairNumber);
    }
}
