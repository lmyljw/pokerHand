package test;

import main.java.PokerHand;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {

    private PokerHand pokerHand = new PokerHand();

    @Test
    public void should_return_player_1_win_when_input_7C_and_5D() {
        String actual = pokerHand.exec("7C", "5D");
        assertEquals(pokerHand.PLAYER_1_WIN, actual);
    }
    @Test
    public void should_return_peace_when_input_7C_and_7D() {
        String actual = pokerHand.exec("7C", "7D");
        assertEquals(pokerHand.PEACE, actual);
    }
    @Test
    public void should_return_player_2_win_when_input_7C_and_TD() {
        String actual = pokerHand.exec("7C", "TD");
        assertEquals(pokerHand.PEACE, actual);
    }
}
