package de.htwberlin.webtech.webtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import de.htwberlin.webtech.webtech.Article;

@RestController
public class Controller {
    @GetMapping("/Articles")
    public List<Article> testRoute() {
        return List.of(
                new Article("Test Article 1", "This is a test Article price 10."),
                new Article("Test Article 2", "This is a test Article price 20."),
                new Article("Test Article 3", "This is a test Article price 30.")
        );
    }
}
