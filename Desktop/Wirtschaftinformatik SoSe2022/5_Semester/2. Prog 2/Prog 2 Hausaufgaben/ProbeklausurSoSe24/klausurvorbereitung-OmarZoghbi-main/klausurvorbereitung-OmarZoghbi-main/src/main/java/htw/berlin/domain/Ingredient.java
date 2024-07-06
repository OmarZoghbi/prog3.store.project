package htw.berlin.domain;

import java.math.BigDecimal;

public interface Ingredient {
  String getName();
  BigDecimal getPrice();
  double getCalories();
}
