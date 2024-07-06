package htw.berlin.service;

import htw.berlin.domain.Burger;
import htw.berlin.domain.BurgerImpl;
import htw.berlin.domain.Ingredient;
import htw.berlin.domain.IngredientImpl;

import java.util.ArrayList;
import java.util.List;

public class BurgerBuilderImpl implements BurgerBuilder {

  private final List<Ingredient> ingredients;

  public BurgerBuilderImpl() {
    this.ingredients = new ArrayList<>();
  }

  @Override
  public boolean addIngredientsById(List<Integer> ids) {
    for (Integer id : ids) {
      var info = ArticleInfos.getInstance().getAllArticles().get(id);
      ingredients.add(new IngredientImpl(info.getName(), info.getPrice(), info.getCalories()));
    }
    return true;
  }

  @Override
  public Burger build() {
    return new BurgerImpl(ingredients);
  }
}
