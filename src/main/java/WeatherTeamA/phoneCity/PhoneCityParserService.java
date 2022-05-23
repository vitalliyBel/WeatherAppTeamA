package WeatherTeamA.phoneCity;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface PhoneCityParserService {

    public Document getPage() throws IOException;

    public String getOurCity() throws IOException;

    public String getTel();
}
