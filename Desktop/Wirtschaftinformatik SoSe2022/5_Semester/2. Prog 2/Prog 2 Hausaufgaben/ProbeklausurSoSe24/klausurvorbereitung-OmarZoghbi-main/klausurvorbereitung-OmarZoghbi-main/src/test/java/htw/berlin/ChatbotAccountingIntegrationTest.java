package htw.berlin;

import htw.berlin.service.BurgerBuilderImpl;
import htw.berlin.service.accounting.Accounting;
import htw.berlin.ui.ChatbotUI;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import htw.berlin.ui.UserInputWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ChatbotAccountingIntegrationTest {
    @Test
    @DisplayName("should notify accounting and state the current revenue")
    void integrationTestRevenue() {
        String orderQuestion = "Willkommen beim Burgerbot! Was moechtest du gerne bestellen?";
        String simpleOrder = "Ich haette gerne einen Burger mit Burgerbrot, Rindfleisch, Eisbergsalat, Tomate und Ketchup";
        String confirmationQuestion = "Willst du die Bestellung abschliessen?";
        UserInputWrapper input = mock(UserInputWrapper.class);
        when(input.ask(eq(orderQuestion))).thenReturn(simpleOrder);
        when(input.ask(contains(confirmationQuestion))).thenReturn("Ja");

        ChatbotUI ui = new ChatbotUI(input, new BurgerBuilderImpl(), new CommaAndWhitespaceSplittingInputParser());
        Accounting acc = new Accounting(ui, input);

        String expectedMessage = "Nettoumsatz in 2021 soweit: 7.35";

        assertEquals("Ja", ui.launch());
        verify(input).state(expectedMessage);
    }
}
