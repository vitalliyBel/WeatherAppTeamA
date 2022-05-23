package WeatherTeamA.weatherPars;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface WeatherParserService {


        public Document getPage() throws IOException;

        public String getTemp() throws IOException;
}
