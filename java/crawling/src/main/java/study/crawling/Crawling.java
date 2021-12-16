package study.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class Crawling {

    public static void main(String[] args) {

        // 페이징이 있으면 순회
        String url = "https://www.inflearn.com/courses/it-programming";

        Connection connection = Jsoup.connect(url);

        try {
            Document document = connection.get();


//            // 강의자, 강의 부가 설명, 기술 스택
//            Elements instructorElements = document.getElementsByClass("instructor");
//            Elements descriptionElements = document.select("p.course_description");
//            Elements skillElements = document.select("div.course_skills > span");
//
//            for (int i = 0; i < instructorElements.size() ; i++){
//                String instructor = instructorElements.get(i).text();
//                String description = descriptionElements.get(i).text();
//                String skills = removeWhiteSpace(skillElements.get(i).text());
//
//                System.out.println("강의자: " + instructor);
//                System.out.println("강의 부가설명: " + description);
//                System.out.println("기술 스택: " + skills);
//            }

//             강의 링크
            Elements linkElements = document.select("a.course_card_front");

            for (Element linkElement : linkElements) {
                String linkUrl = linkElement.attr("abs:href");
                System.out.println(linkUrl);


                // 강의 평점
                Connection innerConnection = Jsoup.connect(linkUrl);
                Document innerDocument = innerConnection.get();
                Elements ratingElement = innerDocument.select("div.dashboard-star__num");
                Element listenerElement = innerDocument.selectFirst("div.cd-header__info-cover");
                String sugang = innerDocument.select("div.dashboard-star__text").text();
                System.out.println(sugang);
                String listener = Objects.isNull(listenerElement) ? innerDocument.selectFirst("span > strong").text() : innerDocument.select("div.cd-header__info-cover > span > strong").get(1).text();
                System.out.println(listener);
                float rating = (ratingElement.size() == 0) ? toFloat("0") : toFloat(ratingElement.text());
                System.out.println(rating);
            }


//             가격 _ 할인 가격
//            Elements priceElements = document.getElementsByClass("price");
//            for (Element priceElement : priceElements) {
//                String price = priceElement.text();
//                String realPrice = getRealPrice(price);
//                String salePrice = getSalePrice(price);
//                String realIntPrice = removeNotNumeric(realPrice);
//                String saleIntPrice = removeNotNumeric(salePrice);
//
//                System.out.println("가격: " + realIntPrice);
//                System.out.println("할인 가격: " + saleIntPrice);
//            }

            // 강의 제목
//            Elements titleElements = document.select("div.card-content > div.course_title");
//            for (Element titleElement : titleElements) {
//                String title = titleElement.text();
//                System.out.println("강의제목:" + title);
//            }

//             강의 이미지
//            Elements imageUrlElements = document.getElementsByClass("swiper-lazy");
//
//            for (Element element : imageUrlElements) {
//                System.out.println(element); // html 태그
//                System.out.println(element.attr("abs:src")); // src 부분만 가져온다
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeWhiteSpace(String str) {
        return str.replaceAll("\\s", "");
    }

    private static float toFloat(String str) {
        return Float.parseFloat(str);
    }

    private static String removeNotNumeric(String price) {
        return price.replaceAll("\\₩", "");
    }

    private static String getSalePrice(String price) {
        String[] pricesArray = price.split(" ");
        return (pricesArray.length == 1) ? price : pricesArray[1];
    }

    private static String getRealPrice(String price) {
        String[] pricesArray = price.split(" ");
        return pricesArray[0];
    }
}
