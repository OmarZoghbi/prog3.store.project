package htw.berlin.service;

import htw.berlin.domain.Ingredient;
import htw.berlin.domain.IngredientImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ArticleInfos {

  private ArticleInfos() {}

  private static ArticleInfos theInstance = null;

  public static ArticleInfos getInstance() {
    if(theInstance == null) theInstance = new ArticleInfos();
    return theInstance;
  }

  public Map<Integer, Ingredient> buns = Map.of(
      100, new IngredientImpl("Burgerbrot", new BigDecimal("1.50"), 300),
      200, new IngredientImpl("Ciabatta", new BigDecimal("1.90"), 250));
  public Map<Integer, Ingredient> patties  = Map.of(
      300, new IngredientImpl("Rindfleisch", new BigDecimal("4.50"), 200),
      400, new IngredientImpl("Falafel", new BigDecimal("3.50"), 150));
  public Map<Integer, Ingredient> salads = Map.of(
      500, new IngredientImpl("Eisbergsalat", new BigDecimal("0.40"), 20),
      600, new IngredientImpl("Rucolasalat", new BigDecimal("0.60"), 25));
  public Map<Integer, Ingredient> veggies = Map.of(
      700, new IngredientImpl("Tomate", new BigDecimal("0.70"), 15),
      800, new IngredientImpl("Gurke", new BigDecimal("0.65"), 12));
  public Map<Integer, Ingredient> sauces = Map.of(
      900, new IngredientImpl("Ketchup", new BigDecimal("0.25"), 30),
      1000, new IngredientImpl("Mayo", new BigDecimal("0.30"), 40));

  public Map<Integer, Ingredient> getAllArticles() {
    Map<Integer, Ingredient> articles = new HashMap<>();
    articles.putAll(buns);
    articles.putAll(patties);
    articles.putAll(salads);
    articles.putAll(veggies);
    articles.putAll(sauces);
    return articles;
  }
}
