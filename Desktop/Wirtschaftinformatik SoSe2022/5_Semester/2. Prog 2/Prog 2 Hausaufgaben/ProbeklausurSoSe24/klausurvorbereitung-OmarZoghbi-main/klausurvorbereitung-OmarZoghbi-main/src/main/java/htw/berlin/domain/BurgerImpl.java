package htw.berlin.domain;

import java.math.BigDecimal;
import java.util.List;

public class BurgerImpl implements Burger {

  private final List<Ingredient> ingredients;

  public BurgerImpl(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public BigDecimal calculatePrice() {
    var result = new BigDecimal("0.00");
    for (Ingredient ingredient : ingredients) {
      result = result.add(ingredient.getPrice());
    }
    return result;
  }

  @Override
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  @Override
  public String toString() {
    return ingredients.toString();
  }
}
