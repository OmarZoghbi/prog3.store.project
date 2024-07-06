package htw.berlin.service;

import java.util.Map;
import java.util.stream.Collectors;

    public class ArticleInfosToMenuAdapter implements IMenu {

        private ArticleInfos infos;

        public ArticleInfosToMenuAdapter(ArticleInfos infos) {
            this.infos = infos;
        }

        @Override
        public Map<String, Integer> getAllArticles() {
            return infos.getAllArticles().entrySet().stream().collect(Collectors.toMap(
                    e -> e.getValue().getName(),
                    e -> e.getKey()));
        }

        @Override
        public String printAllArticles() {
            return getAllArticles().keySet().toString();
        }
    }

