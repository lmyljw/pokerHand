package test;

import main.java.PokerHand;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {

    private PokerHand pokerHand = new PokerHand();

    @Test
    public void should_return_player_1_win_when_input_7C_and_5D() {
        String actual = pokerHand.play("7C", "5D");
        assertEquals(pokerHand.PLAYER_1_WIN, actual);
    }
    @Test
    public void should_return_peace_when_input_7C_and_7D() {
        String actual = pokerHand.play("7C", "7D");
        assertEquals(pokerHand.PEACE, actual);
    }
    @Test
    public void should_return_player_2_win_when_input_7C_and_TD() {
        String actual = pokerHand.play("7C", "TD");
        assertEquals(pokerHand.PLAYER_2_WIN, actual);
    }
    @Test
    public void should_return_player_1_win_when_input_3S_9H_KC_5D_1S_and_5S_JH_9C_3H_1H() {
        String actual = pokerHand.play("3S 9H KC 5D 1S", "5S JH 9C 3H 1H");
        assertEquals(PokerHand.PLAYER_1_WIN, actual);
    }
    @Test
    public void should_return_player_2_win_when_input_3S_9H_KC_5D_1S_and_5S_5H_9C_3H_1H() {
        String actual = pokerHand.play("3S 9H KC 5D 1S", "5S 5H 9C 3H 1H");
        assertEquals(PokerHand.PLAYER_2_WIN, actual);
    }
    @Test
    public void should_return_player_1_win_when_input_7S_7C_8C_5D_1S_and_5S_5H_9C_3H_1H() {
        String actual = pokerHand.play("7S 7C 8C 5D 1S", "5S 5H 9C 3H 1H");
        assertEquals(PokerHand.PLAYER_1_WIN, actual);
    }
    @Test
    public void should_return_peace_when_input_3S_9H_KC_5D_1S_and_3C_9C_KD_5H_1H() {
        String actual = pokerHand.play("3S 9H KC 5D 1S", "3C 9C KD 5H 1H");
        assertEquals(PokerHand.PEACE, actual);
    }
}
