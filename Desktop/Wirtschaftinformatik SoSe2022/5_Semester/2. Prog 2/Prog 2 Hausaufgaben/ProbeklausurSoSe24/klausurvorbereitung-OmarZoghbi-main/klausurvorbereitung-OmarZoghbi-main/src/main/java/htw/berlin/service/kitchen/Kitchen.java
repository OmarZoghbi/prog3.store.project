package htw.berlin.service.kitchen;

import htw.berlin.domain.Burger;
import htw.berlin.service.Observer;
import htw.berlin.ui.ChatbotUI;

public class Kitchen implements Observer {

    private ChatbotUI ui;

    public Kitchen(ChatbotUI ui) {
        this.ui = ui;
        ui.addObserver(this);
    }

    @Override
    public void update() {
        Burger order = ui.getLatestOrder();
        System.out.println("Preparing order ... " + order);
    }

    public void prepare(Burger order) {
        System.out.println("Preparing order ... " + order);
    }
}
