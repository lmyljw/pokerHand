package main.java;

import java.util.*;
import java.util.stream.Collectors;

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
                result = compareMaxPoker(player1PokerMap, player2PokerMap);
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

    public int compareMaxPoker(Map<Integer, Long> player1PokerMap, Map<Integer, Long> player2PokerMap){
        int result = 0;

        Poker player1MaxPoker = getMaxPoker(player1PokerMap);
        Poker player2MaxPoker = getMaxPoker(player2PokerMap);

        result = Integer.compare(player1MaxPoker.getCount(), player2MaxPoker.getCount());
        if(result == 0){
            result = player1MaxPoker.compareTo(player2MaxPoker);
        }
        return result;
    }

    public Poker getMaxPoker(Map<Integer, Long> playerPokerMap){

        int playerPairNumber = 0;
        Poker maxPoker = new Poker();

        for (Integer number : playerPokerMap.keySet()) {
            Long count = playerPokerMap.get(number);
            if (count >= 2) {
                if (number > playerPairNumber || count > playerPokerMap.get(playerPairNumber)){
                    maxPoker.setNumber(number);
                    maxPoker.setCount(count.intValue());
                }
            }
        }
        return maxPoker;
    }
}
