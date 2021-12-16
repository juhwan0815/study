package study.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NaverMovieCrawling {

    public static void main(String[] args) {

        String url = "https://movie.naver.com/movie/running/current.naver";
        Connection connection = Jsoup.connect(url);

        try {
            Document document = connection.get();
            Elements liElements = document.select("div.thumb > a > img");
            for (Element liElement : liElements) {
                System.out.println(liElement.attr("abs:src"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
