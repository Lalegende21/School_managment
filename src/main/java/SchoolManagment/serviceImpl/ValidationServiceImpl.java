package SchoolManagment.serviceImpl;

import SchoolManagment.entity.User;
import SchoolManagment.entity.Validation;
import SchoolManagment.mails.EmailService;
import SchoolManagment.repository.ValidationRepo;
import SchoolManagment.serviceImpl.service.ValidationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final ValidationRepo validationRepo;

    private final EmailService emailService;

    @Override
    public void save(User user) {
        Validation validation = new Validation();
        validation.setUser(user);

        Instant creation = Instant.now();
        validation.setCreation(creation);

        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExpiration(expiration);

        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepo.save(validation);

        this.emailService.validation(validation);
    }

    public Validation readCode(String code){
        return this.validationRepo.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }


    @Scheduled(cron = "*/30 * * * * *")
    public void removeUselessJwt(){
        Instant now = Instant.now();
        log.info("Suppression des tokens a {}", now);
        this.validationRepo.deleteAllByExpirationBefore(now);
    }
}
