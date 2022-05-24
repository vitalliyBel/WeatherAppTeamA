package WeatherTeamA.weatherApplication;

import WeatherTeamA.sendMessage.AppConfig;
import WeatherTeamA.sendMessage.SendEmail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SendEmail bean = context.getBean(SendEmail.class);

        bean.sendMail();
    }
}
