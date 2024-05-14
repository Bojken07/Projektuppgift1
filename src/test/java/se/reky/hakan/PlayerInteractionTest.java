package se.reky.hakan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import se.reky.hakan.model.Player;
import java.util.Scanner;

class PlayerInteractionTest {

    private PlayerInteraction playerInteraction (String dataForScanner) {
        PlayerInteraction playerInteraction;
        playerInteraction = new SimplePlayerInteraction(new IOHandler(new Scanner(dataForScanner)));
        return playerInteraction;
    }
    private Player player;

    @BeforeEach
    public void init () {
        player = new Player();
    }
    @Test
    public void testPlayerName () {
        // Konfigurera en spelare interaktion med spelare namn Player1
        playerInteraction("Player1").setupPlayer(player);
        // Kontrollerar att spelarens namn är satt korrekt.
        Assertions.assertEquals("Player1", player.getName());
    }
    @Test
    public void testUpdatePlayerHealth () {
        // Uppdaterar spelarens hälsa med värdet 2.
        playerInteraction("Player2").updatePlayerHealth(player,2);
        // Kontrollerar att spelarens hälsa har uppdaterat korrekt.
        Assertions.assertEquals(2, player.getHp());
    }
}
