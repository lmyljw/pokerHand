package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class PokerHand {

    public final static String PLAYER_1_WIN = "Player 1 Win";
    public final static String PLAYER_2_WIN = "Player 2 Win";
    public final static String PEACE = "Peace";

    public String play(String cards1, String cards2) {

        int result = 0;
        Map<Integer, Long> player1PokerCardMap = mapCards(cards1);
        Map<Integer, Long> player2PokerCardMap = mapCards(cards2);

        if(player1PokerCardMap.size() < 5 || player2PokerCardMap.size() < 5){
            result = -(Integer.compare(player1PokerCardMap.size(),player2PokerCardMap.size()));
            if(result == 0) {
                result = compareMaxPokerCard(player1PokerCardMap, player2PokerCardMap);
            }
        }

        if(result == 0){
            result = compareHighCard(cards1, cards2);
        }

        return getFinalResult(result);

    }

    public Map<Integer,Long> mapCards(String cards){
        return Arrays.stream(cards.split(" "))
                .map(card -> new PokerCard(card.substring(0, 1), card.substring(1, 2)))
                .collect(Collectors.groupingBy(PokerCard::getNumber,Collectors.counting()));
    }

    public List<PokerCard> sortCards(String cards){
        return (List<PokerCard>) Arrays.stream(cards.split(" "))
                .map(card -> new PokerCard(card.substring(0, 1), card.substring(1, 2)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public int compareHighCard(String cards1, String cards2){
        int result = 0;

        List<PokerCard> player1PokerCard = sortCards(cards1);
        List<PokerCard> player2PokerCard = sortCards(cards2);

        for (int i = 0; i < player1PokerCard.size(); i++) {
            result = player1PokerCard.get(i).compareTo(player2PokerCard.get(i));
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

    public int compareMaxPokerCard(Map<Integer, Long> player1PokerMap, Map<Integer, Long> player2PokerMap){
        int result = 0;

        PokerCard player1MaxPokerCard = getMaxPokerCard(player1PokerMap);
        PokerCard player2MaxPokerCard = getMaxPokerCard(player2PokerMap);

        result = Integer.compare(player1MaxPokerCard.getCount(), player2MaxPokerCard.getCount());
        if(result == 0){
            result = player1MaxPokerCard.compareTo(player2MaxPokerCard);
        }
        return result;
    }

    public PokerCard getMaxPokerCard(Map<Integer, Long> playerPokerMap){

        int playerMaxNumber = 0;
        PokerCard maxPokerCard = new PokerCard();

        for (Integer number : playerPokerMap.keySet()) {
            Long count = playerPokerMap.get(number);
            if (count >= 2) {
                if (number > playerMaxNumber || count > playerPokerMap.get(playerMaxNumber)){
                    maxPokerCard.setNumber(number);
                    maxPokerCard.setCount(count.intValue());
                }
            }
        }
        return maxPokerCard;
    }
}
