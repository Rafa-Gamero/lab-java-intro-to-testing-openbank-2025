import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {
    @Test
    public void testOddIntegersWithNegativeInput() {
        int[] result = NumberUtils.oddIntegers(-5);
        assertEquals(0, result.length);
    }

    @Test
    public void testOddIntegersWithZero() {
        int[] result = NumberUtils.oddIntegers(0);
        assertEquals(0, result.length);
    }

    @Test
    public void testOddIntegersWithOne() {
        int[] result = NumberUtils.oddIntegers(1);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void testOddIntegersWithSmallNumber() {
        int[] result = NumberUtils.oddIntegers(5);
        assertArrayEquals(new int[]{1, 3, 5}, result);
    }

    @Test
    public void testOddIntegersWithLargerNumber() {
        int[] result = NumberUtils.oddIntegers(10);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, result);
    }
}
