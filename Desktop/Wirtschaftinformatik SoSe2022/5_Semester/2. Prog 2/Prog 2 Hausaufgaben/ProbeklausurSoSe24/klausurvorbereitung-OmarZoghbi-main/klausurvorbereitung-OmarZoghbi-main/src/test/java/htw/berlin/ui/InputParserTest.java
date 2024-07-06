package htw.berlin.ui;

import htw.berlin.ui.InputParser;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    @Test
    @DisplayName("should count how often specified keywords occur")
    void canCountKeywords() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new HashSet<>(Arrays.asList("Burgerbrot", "Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = "Ich haette gerne einen Burger mit Burgerbrot, Rindfleisch, Eisbergsalat, Tomate, und Ketchup";
        var expected = Map.of(
                "Burgerbrot", 1,
                "Rindfleisch", 1,
                "Eisbergsalat", 1,
                "Tomate", 1,
                "Ketchup", 1,
                "Mayo", 0,
                "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }

    @Test
    @DisplayName("should be able to count multiple occurrences of a keyword")
    void canCountMultipleKeywordOccurrences() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new HashSet<>(Arrays.asList("Burgerbrot", "Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = "Ich haette gerne einen Burger mit Burgerbrot, Rindfleisch, Rindfleisch, Rindfleisch und Tomate";
        var expected = Map.of(
            "Burgerbrot", 1,
            "Rindfleisch", 3,
            "Eisbergsalat", 0,
            "Tomate", 1,
            "Ketchup", 0,
            "Mayo", 0,
            "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }

    @Test
    @DisplayName("should be able to handle null input")
    void canHandleNullInput() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new HashSet<>(Arrays.asList("Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = null;
        var expected = Map.of(
            "Rindfleisch", 0,
            "Eisbergsalat", 0,
            "Tomate", 0,
            "Ketchup", 0,
            "Mayo", 0,
            "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }
}
