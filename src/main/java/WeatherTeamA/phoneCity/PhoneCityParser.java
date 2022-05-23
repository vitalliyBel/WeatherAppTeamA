package WeatherTeamA.phoneCity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;



@Component
public class PhoneCityParser implements PhoneCityParserService{
    private String tel = "+78462600829";

    private String city;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PhoneCityParser() {
    }

    public PhoneCityParser(String tel, String city) {
        this.tel = tel;
        this.city = city;
    }

    /**
     * Отправляем гет-запрос c телефоном на страницу для получения города,
     * получаем html и сразу парсим страницу
     * @return страницу в html
     * @throws IOException наверно если не найдены данные
     */
    public Document getPage() throws IOException {

        String url="http://htmlweb.ru/geo/api.php?html&telcod="+tel+"";
        Document page = Jsoup.parse(new URL(url), 3000 );

        return page;
    }

    /**
     * Получаем из html кода нужный тэг с классом, где находится название города
     * @return город
     * @throws IOException наверно если не найдены данные
     */
    public String getOurCity() throws IOException {

        Document page = getPage();
        Element tableTemp = page.select("a[class=b]").first();
        city = tableTemp.text();

        return city;
    }
}