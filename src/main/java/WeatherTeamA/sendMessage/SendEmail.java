package WeatherTeamA.sendMessage;

import WeatherTeamA.phoneCity.PhoneCityParserService;
import WeatherTeamA.weatherPars.WeatherParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SendEmail {

    @Autowired
    private PhoneCityParserService phoneCityParserService;
    @Autowired
    private WeatherParserService weatherParserService;

    @Autowired
    private MailSender mailSender;

    public void sendMail() throws IOException {

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("zuradik1000@gmail.com");
        msg.setFrom("zuradik1000@gmail.com");
        msg.setSubject("Привет. Это мое первое тестовое сообщение");
        msg.setText("");

        //тут обращаемся к интерфейсам, а не к классам(правда до конца не понял зачем:), но по правилам вроде так)
        System.out.println("Ваш номер "+phoneCityParserService.getTel()+" Ваш город "+phoneCityParserService.getOurCity()
                +" Температура "+weatherParserService.getTemp());
     //   mailSender.send(msg);
    }

}
