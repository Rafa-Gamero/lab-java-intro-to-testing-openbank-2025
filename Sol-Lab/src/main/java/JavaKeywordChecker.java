import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class JavaKeywordChecker {

    // Lista completa de palabras clave en Java (hasta Java 17)
    private static final Set<String> JAVA_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum",
            "extends", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while", "true", "false", "null", "var", "yield", "record", "sealed",
            "permits", "non-sealed"
    ));

    /**
     * Checks if a string contains any Java keyword as a complete word
     *
     * @param input The string to check
     * @return true if the string contains any Java keyword as a complete word, false otherwise
     */
    public static boolean containsJavaKeyword(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Split the input string into words
        String[] words = input.split("\\W+");

        // Check if any word is a Java keyword
        for (String word : words) {
            if (JAVA_KEYWORDS.contains(word)) {
                return true;
            }
        }

        return false;
    }
}
