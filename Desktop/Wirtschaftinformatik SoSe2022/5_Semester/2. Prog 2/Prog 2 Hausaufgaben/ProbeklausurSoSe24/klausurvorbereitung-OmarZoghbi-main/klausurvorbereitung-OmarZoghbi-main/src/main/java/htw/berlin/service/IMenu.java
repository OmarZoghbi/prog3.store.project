package htw.berlin.service;

import java.util.Map;

public interface IMenu {
    Map<String, Integer> getAllArticles();

    String printAllArticles();
}
