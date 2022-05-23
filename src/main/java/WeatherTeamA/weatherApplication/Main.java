package WeatherTeamA.weatherApplication;

import WeatherTeamA.sendMessage.AppConfig;
import WeatherTeamA.sendMessage.SendEmail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SendEmail bean = context.getBean(SendEmail.class);

        bean.sendMail();
    }
}
