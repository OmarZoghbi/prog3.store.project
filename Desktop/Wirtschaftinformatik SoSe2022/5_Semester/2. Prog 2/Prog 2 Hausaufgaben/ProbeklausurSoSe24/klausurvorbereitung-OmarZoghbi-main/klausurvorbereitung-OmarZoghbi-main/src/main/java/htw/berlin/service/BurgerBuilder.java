package htw.berlin.service;

import htw.berlin.domain.Burger;

import java.util.List;

public interface BurgerBuilder {
    boolean addIngredientsById(List<Integer> ids);
    Burger build();
}
