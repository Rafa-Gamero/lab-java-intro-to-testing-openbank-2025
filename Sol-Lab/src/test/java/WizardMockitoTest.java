import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WizardMockitoTest {

    @Test
    public void testCastRandomSpell() {
        // Crear un mock de SpellLibrary
        SpellLibrary mockSpellLibrary = mock(SpellLibrary.class);

        // Configurar el comportamiento del mock para devolver "Fireball"
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Fireball");

        // Crear un mago con la biblioteca de hechizos simulada
        Wizard wizard = new Wizard(100, 20, 3, "Ice Blast", mockSpellLibrary);

        // Llamar al método que queremos probar
        String result = wizard.castRandomSpell();

        // Verificar que getRandomSpell fue llamado exactamente una vez
        verify(mockSpellLibrary, times(1)).getRandomSpell();

        // Verificar que el resultado es el esperado
        assertEquals("Casting Fireball", result);
    }

    @Test
    public void testCastRandomSpellWithNoLibrary() {
        // Crear un mago sin biblioteca de hechizos
        Wizard wizard = new Wizard(100, 20, 3, "Ice Blast");

        // Verificar que se lanza la excepción esperada
        assertThrows(IllegalStateException.class, () -> {
            wizard.castRandomSpell();
        });
    }

    @Test
    public void testSetSpellLibrary() {
        // Crear un mock de SpellLibrary
        SpellLibrary mockSpellLibrary = mock(SpellLibrary.class);

        // Configurar el comportamiento del mock
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Lightning Bolt");

        // Crear un mago sin biblioteca de hechizos
        Wizard wizard = new Wizard(100, 20, 3, "Ice Blast");

        // Establecer la biblioteca de hechizos
        wizard.setSpellLibrary(mockSpellLibrary);

        // Llamar al método que queremos probar
        String result = wizard.castRandomSpell();

        // Verificar que getRandomSpell fue llamado exactamente una vez
        verify(mockSpellLibrary, times(1)).getRandomSpell();

        // Verificar que el resultado es el esperado
        assertEquals("Casting Lightning Bolt", result);
    }
}