package htw.berlin;

import htw.berlin.service.accounting.Accounting;
import htw.berlin.service.BurgerBuilderImpl;
import htw.berlin.service.kitchen.Kitchen;
import htw.berlin.ui.ChatbotUI;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import htw.berlin.ui.UserInputWrapper;

public class BurgerApplication {

    public static void main(String[] args) {
        var parser = new CommaAndWhitespaceSplittingInputParser();
        var builder = new BurgerBuilderImpl();
        var input = new UserInputWrapper(System.in, System.out);
        var ui = new ChatbotUI(input, builder, parser);
        var kitchen = new Kitchen(ui);
        var accounting = new Accounting(ui, input);
        ui.launch();
    }
}

