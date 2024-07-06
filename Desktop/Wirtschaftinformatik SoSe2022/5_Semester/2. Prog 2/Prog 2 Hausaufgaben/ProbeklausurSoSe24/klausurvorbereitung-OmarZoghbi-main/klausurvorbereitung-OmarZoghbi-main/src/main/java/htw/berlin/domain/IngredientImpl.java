package htw.berlin.domain;

import java.math.BigDecimal;

public class IngredientImpl implements Ingredient {

    private String name;
    private BigDecimal price;
    private double calories;

    public IngredientImpl(String name, BigDecimal price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name;
    }
}
