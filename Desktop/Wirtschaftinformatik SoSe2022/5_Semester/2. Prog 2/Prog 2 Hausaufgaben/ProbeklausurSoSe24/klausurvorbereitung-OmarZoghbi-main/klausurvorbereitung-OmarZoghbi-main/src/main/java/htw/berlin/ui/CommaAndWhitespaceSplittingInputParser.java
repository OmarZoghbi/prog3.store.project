package htw.berlin.ui;

import java.util.*;

public class CommaAndWhitespaceSplittingInputParser implements InputParser {

    @Override
    public Map<String, Integer> countKeywords(String line, Set<String> keywords) {
        Map<String, Integer> keywordCount = new HashMap<>();
        List<String> splitInput = line != null ? Arrays.asList(line.split("[\\s,]+")) : Collections.emptyList();

        for (String keyword : keywords) {
            keywordCount.put(keyword, Collections.frequency(splitInput, keyword));
        }

        return keywordCount;
    }
}
