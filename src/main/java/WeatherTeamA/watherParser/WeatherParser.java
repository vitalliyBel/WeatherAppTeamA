package WeatherTeamA.watherParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.net.URL;

public class WeatherParser  {

    private static Document getPage() throws IOException {
        String city = "Самара";
        String url="https://api.openweathermap.org/data/2.5/weather?q=+city+&appid=b9f50299bf00aed5dfd712d0d11aa976&mode=html";
        Document page = Jsoup.parse(new URL(url), 8000 );
        return page;
    }

    public static void main(String[] args) throws Exception {

        Document page = getPage();
        Element tableTemp = page.select("div[title=Current Temperature]").first();
        String temperatura = tableTemp.text();
        System.out.println(temperatura);

    }
}


