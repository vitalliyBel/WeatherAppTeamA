package WeatherTeamA.sendMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

    @Autowired
    private MailSender mailSender;

    public void sendMail(){

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("zuradik1000@gmail.com");
        msg.setFrom("zuradik1000@gmail.com");
        msg.setSubject("Привет. Это мое первое тестовое сообщение");
        msg.setText("Привет. Это тело моего певрого сообщения");

        mailSender.send(msg);
    }

}
