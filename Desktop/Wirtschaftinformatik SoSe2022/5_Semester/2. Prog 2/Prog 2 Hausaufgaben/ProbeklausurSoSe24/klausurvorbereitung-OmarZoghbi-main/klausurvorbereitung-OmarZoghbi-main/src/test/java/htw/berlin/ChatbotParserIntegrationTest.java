package htw.berlin;

import htw.berlin.domain.BurgerImpl;
import htw.berlin.service.BurgerBuilder;
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

public class ChatbotParserIntegrationTest {
    @Test
    @DisplayName("should understand an order and trigger a burger build with the right article ids")
    void integrationTestSimpleOrderWithInputParser() {
        String orderQuestion = "Willkommen beim Burgerbot! Was moechtest du gerne bestellen?";
        String simpleOrder = "Ich haette gerne einen Burger mit Burgerbrot, Rindfleisch, Eisbergsalat, Tomate und Ketchup";
        String confirmationQuestion = "Willst du die Bestellung abschliessen?";
        String orderConfirmation = "Bestellung abschliessen";
        UserInputWrapper input = mock(UserInputWrapper.class);
        when(input.ask(eq(orderQuestion))).thenReturn(simpleOrder);
        when(input.ask(contains(confirmationQuestion))).thenReturn(orderConfirmation);

        BurgerBuilder builder = mock(BurgerBuilder.class);
        when(builder.addIngredientsById(anyList())).thenReturn(true);
        when(builder.build()).thenReturn(new BurgerImpl(Collections.emptyList()));

        ChatbotUI ui = new ChatbotUI(input, builder, new CommaAndWhitespaceSplittingInputParser());

        assertEquals("Bestellung abschliessen", ui.launch());
        verify(builder).addIngredientsById(Arrays.asList(100, 300, 500, 700, 900));
    }
}
