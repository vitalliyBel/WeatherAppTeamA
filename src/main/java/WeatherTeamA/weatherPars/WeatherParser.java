package WeatherTeamA.weatherPars;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class WeatherParser implements WeatherParserService {
    @Autowired
    private PhoneCityParserService phoneCityParserService;

    private String temperatura;

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public WeatherParser() {
    }

    public WeatherParser(PhoneCityParser phoneCityParser, String temperatura) {
        this.phoneCityParserService = phoneCityParser;
        this.temperatura = temperatura;
    }

    /**
     * Отправляем гет-запрос c городом на страницу для получения погоды,
     *  получаем html и сразу парсим страницу
     * @return страницу в html
     */
    public Document getPage() throws IOException {

        String url = "https://api.openweathermap.org/data/2.5/weather?q="+phoneCityParserService.getOurCity()+"&appid=b9f50299bf00aed5dfd712d0d11aa976&mode=html";
        Document page = Jsoup.parse(new URL(url), 3000);

        return page;
    }

    /**
     * Получаем из html кода нужный тэг div с тайтлом, где находится температура
     * @return температуру
     */
    public String getTemp() throws IOException {
        Document page = getPage();
        Element tableTemp = page.select("div[title=Current Temperature]").first();
        temperatura = tableTemp.text();

        return temperatura;

    }
}



