package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Goblin;
import se.reky.hakan.model.Guard;

public class ActorTest {

    Guard guard = new Guard();
    Goblin goblin = new Goblin();

    @Test
    public void testAttack () {
        // Skriver ut Goblins hälsa innan attacken och att Guard attackerar Goblin.
        System.out.println("Goblin health " + goblin.getHp() + " guard attacks goblin");
        guard.attack(goblin);
        // Skriver ut Goblins hälsa efter att Guard attackerat och goblin attackerar Guarden.
        System.out.println("Goblin health " + goblin.getHp() + " goblin attacks guard");
        goblin.attack(guard);
        // Skriver ut Guard hälsa efter attacker.
        System.out.println("Guard health " + guard.getHp());
        // Kontrollerar att Goblins hälsa är 0 efter attacker.
        Assertions.assertEquals(0, goblin.getHp());
        // Kontrollerar att Guards hälsa är 17 efter att den har attackerat av Goblin.
        Assertions.assertEquals(17, guard.getHp());
    }
}
