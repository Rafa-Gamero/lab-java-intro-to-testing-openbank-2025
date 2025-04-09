public class NumberUtils {


    public static int[] oddIntegers(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int count = (n + 1) / 2; // Número de números enteros impares de 1 a n
        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            result[i] = 2 * i + 1;
        }

        return result;
    }
}
