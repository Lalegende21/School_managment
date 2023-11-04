package SchoolManagment.mails;

import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "mail")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        String to = emailRequest.getTo();
        System.out.println(to);

        String subject = emailRequest.getSubject();
        System.out.println(subject);

        String text = emailRequest.getText();
        System.out.println(text);

        this.emailService.sendEmail(to, subject, text);

        return "Mail send successfully!";
    }
}
