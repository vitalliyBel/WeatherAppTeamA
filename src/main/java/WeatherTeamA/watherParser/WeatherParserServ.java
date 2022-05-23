package WeatherTeamA.watherParser;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface WeatherParserServ {


        Document getPage() throws IOException;

        String getTemp() throws IOException;
}
