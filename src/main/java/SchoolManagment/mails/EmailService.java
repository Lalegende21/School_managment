package SchoolManagment.mails;

import SchoolManagment.entity.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            javaMailSender.send(message);
            return "Mail sent successfully!";
        } catch (MailException mailException){
            System.out.println(mailException);
            return "Something went wrong!";
        }
    }


    public void validation(Validation validation){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("delfredtene17@gmail.com");
        mailMessage.setTo(validation.getUser().getEmail());
        mailMessage.setSubject("Votre code d'activation!");

        String text = String.format(
                "Bonjour %s, <br/> Votre code d'activation est %s et expire dans 10 minutes, bien vouloir activer" +
                        "votre compte avant la fin de ce delai.",
                validation.getUser().getFullname(),
                validation.getCode()
        );
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }
}
