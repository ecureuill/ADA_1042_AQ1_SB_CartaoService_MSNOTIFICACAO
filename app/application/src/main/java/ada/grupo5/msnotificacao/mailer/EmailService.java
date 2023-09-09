package ada.grupo5.msnotificacao.mailer;

import ada.grupo5.msnotificacao.messages.EmailMessage;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationRequest;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


import java.io.IOException;


@Service
@RequiredArgsConstructor
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender javaMailSender;

    public void sendAccountCreation(AccountNotificationRequest user) {
            try {
                MimeMessage mailMessage = javaMailSender.createMimeMessage();
                mailMessage.setFrom("grupojavabootcamp@gmail.com");
                mailMessage.setRecipients(MimeMessage.RecipientType.TO, user.email());
                mailMessage.setContent(EmailMessage.createAccountActivationEmail(user), "text/html; charset=utf-8");
                mailMessage.setSubject("Conta criada no CardService!!");

                javaMailSender.send(mailMessage);
            } catch (Exception e) {
                throw new Error(e.getMessage());
        }
    }
}
