package htw.berlin.domain;

import java.math.BigDecimal;
import java.util.List;

public interface Burger {
    BigDecimal calculatePrice();
    List<Ingredient> getIngredients();
}
