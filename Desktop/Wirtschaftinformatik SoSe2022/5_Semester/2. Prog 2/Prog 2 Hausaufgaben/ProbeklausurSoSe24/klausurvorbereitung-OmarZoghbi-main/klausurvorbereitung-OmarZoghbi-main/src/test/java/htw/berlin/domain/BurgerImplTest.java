package htw.berlin.domain;

import htw.berlin.service.ArticleInfos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerImplTest {

    private final ArticleInfos infos = ArticleInfos.getInstance();

    private final Burger sut = new BurgerImpl(List.of(
            infos.buns.get(100),
            infos.patties.get(300),
            infos.salads.get(500),
            infos.veggies.get(700),
            infos.sauces.get(900)
    ));

    @Test
    @DisplayName("should calculate the price of a burger based on its ingredients")
    void canCalculatePrice() {
        BigDecimal expected = new BigDecimal("7.35");
        BigDecimal actual = sut.calculatePrice();
        assertEquals(expected, actual);
    }

}