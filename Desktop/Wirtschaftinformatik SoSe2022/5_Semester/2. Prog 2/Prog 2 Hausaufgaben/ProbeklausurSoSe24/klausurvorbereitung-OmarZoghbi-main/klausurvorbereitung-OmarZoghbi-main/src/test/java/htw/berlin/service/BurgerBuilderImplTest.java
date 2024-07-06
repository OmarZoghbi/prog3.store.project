package htw.berlin.service;

import htw.berlin.domain.Burger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerBuilderImplTest {

  @Test
  @DisplayName("should build a burger from article ids")
  void testBuildBurger() {
    BurgerBuilder burgerBuilder = new BurgerBuilderImpl();
    List<Integer> ids = List.of(100, 300, 900);
    burgerBuilder.addIngredientsById(ids);
    Burger burger = burgerBuilder.build();

    assertEquals(3, burger.getIngredients().size());
  }
}
