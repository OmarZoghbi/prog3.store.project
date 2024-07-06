package htw.berlin.ui;

import htw.berlin.domain.Burger;
import htw.berlin.service.*;
import htw.berlin.service.Observer;

import java.util.*;

public class ChatbotUI implements Observable {
    private final UserInputWrapper input;
    private final BurgerBuilder builder;
    private final InputParser parser;

    public ChatbotUI(UserInputWrapper uiw, BurgerBuilder bb, InputParser ip) {
        input = uiw;
        builder = bb;
        parser = ip;
    }

    private final List<Burger> orders = new ArrayList<>();

    public Burger getLatestOrder() {
        return orders.get(orders.size()-1);
    }

    private final Set<Observer> observers = new HashSet<>();

    @Override
    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Burgerbot! Was moechtest du gerne bestellen?");
        while (!(inputLine.contains("Bestellung abschliessen") || inputLine.contains("Auf Wiedersehen"))) {
            List<Integer> articles = articleIdsFromOrder(inputLine);
            if(articles.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Waehle aus folgenden Zutaten: "
                        + (new ArticleInfosToMenuAdapter(ArticleInfos.getInstance())).printAllArticles());
            } else {
                builder.addIngredientsById(articles);
                Burger burger = builder.build();
                inputLine = input.ask("In Ordnung. Dein Burger mit " + burger.getIngredients() +
                        " kostet " + burger.calculatePrice() + " Euro. Willst du die Bestellung abschliessen?");

                if(inputLine.contains("Ja")) {
                    orders.add(burger);
                    this.notifyObservers();
                    break;
                }
            }
        }
        return inputLine;
    }

    // nur public zum einfacheren Testen
    public List<Integer> articleIdsFromOrder(String inputLine) {
        IMenu menu = new ArticleInfosToMenuAdapter(ArticleInfos.getInstance());
        Set<String> articles = menu.getAllArticles().keySet();
        Map<String, Integer> articleCount = parser.countKeywords(inputLine, articles);
        Map<String, Integer> articleMap = menu.getAllArticles();
        List<Integer> ids = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : articleCount.entrySet()) {
            String articleName = entry.getKey();
            int articleId = articleMap.get(articleName);
            int count = entry.getValue();

            for (int frequency = 0; frequency < count; frequency++) {
                ids.add(articleId);
            }
        }

        Collections.sort(ids);
        return ids;
    }
}
