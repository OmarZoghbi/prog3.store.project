package htw.berlin.ui;

import java.util.Map;
import java.util.Set;

public interface InputParser {
    Map<String, Integer> countKeywords(String line, Set<String> keywords);
}
