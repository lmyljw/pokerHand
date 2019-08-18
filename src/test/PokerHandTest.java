package test;

import main.java.PokerHand;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {

    private PokerHand pokerHand = new PokerHand();

    @Test
    public void should_return_1th_player_when_input_7C_and_5D() {
        String actual = pokerHand.exec("7C", "5D");
        assertEquals(pokerHand.PLAYER_1_WIN, actual);
    }
}
