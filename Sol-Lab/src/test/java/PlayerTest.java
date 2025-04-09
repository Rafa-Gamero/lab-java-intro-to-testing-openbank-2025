import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Warrior warrior = new Warrior(100, 20, 3, 15);
        assertEquals(100, warrior.getHealth());
        assertEquals(20, warrior.getStrength());
        assertEquals(3, warrior.getLives());
        assertEquals(15, warrior.getForce());
    }

    @Test
    public void testDecrementLive() {
        Warrior warrior = new Warrior(100, 20, 3, 15);
        warrior.setHealth(30); // Set health to a lower value
        warrior.decrementLive();

        assertEquals(2, warrior.getLives());
        assertEquals(100, warrior.getHealth()); // Health should be restored
    }

    @Test
    public void testDecrementLiveWhenDead() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Warrior warrior = new Warrior(100, 20, 1, 15);
        warrior.decrementLive();

        // Check if the character is dead message is printed
        assertTrue(outContent.toString().contains("This character is dead"));
        assertEquals(0, warrior.getLives());

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    public void testAttack() {
        Warrior attacker = new Warrior(100, 20, 3, 15);
        Elf defender = new Elf(80, 15, 2, 10);

        attacker.attack(defender);
        assertEquals(60, defender.getHealth()); // 80 - 20 = 60
    }

    @Test
    public void testAttackCausingDecrementLive() {
        Warrior attacker = new Warrior(100, 20, 3, 15);
        Elf defender = new Elf(15, 15, 2, 10);

        attacker.attack(defender);
        assertEquals(1, defender.getLives()); // Lives should be decremented
        assertEquals(15, defender.getHealth()); // Health should be restored
    }

    @Test
    public void testConvertWarriorToElf() {
        Warrior warrior = new Warrior(100, 20, 3, 15);
        Elf convertedElf = warrior.convertToElf();

        assertEquals(100, convertedElf.getHealth());
        assertEquals(20, convertedElf.getStrength());
        assertEquals(3, convertedElf.getLives());
        assertEquals(10, convertedElf.getSpeed());
    }

    @Test
    public void testConvertWizardToElf() {
        Wizard wizard = new Wizard(80, 30, 2, "Fireball");
        Elf convertedElf = wizard.convertToElf();

        assertEquals(80, convertedElf.getHealth());
        assertEquals(30, convertedElf.getStrength());
        assertEquals(2, convertedElf.getLives());
        assertEquals(8, convertedElf.getSpeed());
    }

    @Test
    public void testElfProperties() {
        Elf elf = new Elf(90, 15, 3, 25);
        assertEquals(90, elf.getHealth());
        assertEquals(15, elf.getStrength());
        assertEquals(3, elf.getLives());
        assertEquals(25, elf.getSpeed());

        elf.setSpeed(30);
        assertEquals(30, elf.getSpeed());
    }

    @Test
    public void testWizardProperties() {
        Wizard wizard = new Wizard(80, 30, 2, "Fireball");
        assertEquals(80, wizard.getHealth());
        assertEquals(30, wizard.getStrength());
        assertEquals(2, wizard.getLives());
        assertEquals("Fireball", wizard.getSpell());

        wizard.setSpell("Ice Blast");
        assertEquals("Ice Blast", wizard.getSpell());
    }
}
