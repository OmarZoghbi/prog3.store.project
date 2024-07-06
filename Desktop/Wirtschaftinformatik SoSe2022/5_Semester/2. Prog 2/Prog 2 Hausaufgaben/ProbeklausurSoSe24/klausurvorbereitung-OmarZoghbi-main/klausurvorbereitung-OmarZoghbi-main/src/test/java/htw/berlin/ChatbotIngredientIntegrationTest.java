package htw.berlin;

import htw.berlin.domain.BurgerImpl;
import htw.berlin.service.BurgerBuilder;
import htw.berlin.service.BurgerBuilderImpl;
import htw.berlin.ui.ChatbotUI;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import htw.berlin.ui.UserInputWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ChatbotIngredientIntegrationTest {
    @Test
    @DisplayName("should understand a simple order and list the burger's individual ingredients and it's price")
    void integrationTestSimpleOrder() {
        String orderQuestion = "Willkommen beim Burgerbot! Was moechtest du gerne bestellen?";
        String simpleOrder = "Ich haette gerne einen Burger mit Burgerbrot, Rindfleisch, Eisbergsalat, Tomate und Ketchup";
        String confirmationQuestion = "Willst du die Bestellung abschliessen?";
        String orderConfirmation = "Bestellung abschliessen";
        UserInputWrapper input = mock(UserInputWrapper.class);
        when(input.ask(eq(orderQuestion))).thenReturn(simpleOrder);
        when(input.ask(contains(confirmationQuestion))).thenReturn(orderConfirmation);

        ChatbotUI ui = new ChatbotUI(input, new BurgerBuilderImpl(), new CommaAndWhitespaceSplittingInputParser());

        String expectedMessage =  "In Ordnung. Dein Burger mit " +
            "[Burgerbrot, Rindfleisch, Eisbergsalat, Tomate, Ketchup] " +
            "kostet 7.35 Euro. " +
            "Willst du die Bestellung abschliessen?";

        assertEquals("Bestellung abschliessen", ui.launch());
        verify(input).ask(expectedMessage);
    }

    @Test
    @DisplayName("should understand a special order and list the burger's individual ingredients and it's price")
    void integrationTestSpecialOrder() {
        String orderQuestion = "Willkommen beim Burgerbot! Was moechtest du gerne bestellen?";
        String simpleOrder = "Ich haette gerne ein Ciabatta mit Falafel, Rucolasalat, Tomate, Gurke und Mayo";
        String confirmationQuestion = "Willst du die Bestellung abschliessen?";
        String orderConfirmation = "Bestellung abschliessen";
        UserInputWrapper input = mock(UserInputWrapper.class);
        when(input.ask(eq(orderQuestion))).thenReturn(simpleOrder);
        when(input.ask(contains(confirmationQuestion))).thenReturn(orderConfirmation);

        ChatbotUI ui = new ChatbotUI(input, new BurgerBuilderImpl(), new CommaAndWhitespaceSplittingInputParser());

        String expectedMessage =  "In Ordnung. Dein Burger mit " +
            "[Ciabatta, Falafel, Rucolasalat, Tomate, Gurke, Mayo] " +
            "kostet 7.65 Euro. " +
            "Willst du die Bestellung abschliessen?";

        assertEquals("Bestellung abschliessen", ui.launch());
        verify(input).ask(expectedMessage);
    }
}
