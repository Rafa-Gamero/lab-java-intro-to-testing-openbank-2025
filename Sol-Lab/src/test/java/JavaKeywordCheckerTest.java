import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JavaKeywordCheckerTest {

    @Test
    public void testNullString() {
        assertFalse(JavaKeywordChecker.containsJavaKeyword(null));
    }

    @Test
    public void testEmptyString() {
        assertFalse(JavaKeywordChecker.containsJavaKeyword(""));
    }

    @Test
    public void testStringWithNoKeywords() {
        assertFalse(JavaKeywordChecker.containsJavaKeyword("Hello world"));
    }

    @Test
    public void testStringWithKeywordAsCompleteWord() {
        assertTrue(JavaKeywordChecker.containsJavaKeyword("break"));
    }

    @Test
    public void testStringWithKeywordAsPartOfSentence() {
        assertTrue(JavaKeywordChecker.containsJavaKeyword("Don't break my heart"));
    }

    @Test
    public void testStringWithKeywordAsPartOfWord() {
        assertFalse(JavaKeywordChecker.containsJavaKeyword("I love to breakdance"));
    }

    @Test
    public void testStringWithMultipleKeywords() {
        assertTrue(JavaKeywordChecker.containsJavaKeyword("if you continue to break the rules, you will face a final consequence"));
    }

    @Test
    public void testCaseSensitivity() {
        // Java keywords are case sensitive
        assertFalse(JavaKeywordChecker.containsJavaKeyword("BREAK"));
        assertTrue(JavaKeywordChecker.containsJavaKeyword("break"));
    }
}
