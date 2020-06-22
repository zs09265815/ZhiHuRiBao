import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Text {
    public static void main(String[] args) {

    A();
    }

    private static void A() {
        try {
            Document document = Jsoup.connect("https://www.v2ex.com/").get();

            Element tabs = document.getElementById("Tabs");//<div>
            Elements aList = tabs.getElementsByTag("a");
            for (Element element : aList) {
                String href = element.attr("href");
                String text = element.text();

                System.out.println(href + ":" + text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
