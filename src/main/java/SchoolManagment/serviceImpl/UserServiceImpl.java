package SchoolManagment.serviceImpl;

import SchoolManagment.entity.User;
import SchoolManagment.entity.Validation;
import SchoolManagment.repository.UserRepo;
import SchoolManagment.serviceImpl.service.UserClass;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserClass, UserDetailsService {


    private UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder;

    private ValidationServiceImpl validationService;


    //Creation du compte
    @Override
    public void createUser(User user) {
        if (!user.getEmail().contains("@")){
            throw new RuntimeException("Votre email est invalide!");
        }
        if (!user.getEmail().contains(".")){
            throw new RuntimeException("Votre email est invalide!");
        }

        String mdp = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(mdp);

        user = this.userRepo.save(user);
        this.validationService.save(user);
    }


    //Activation du compte
    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.readCode(activation.get("code"));
        if (Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("Votre code a expire!");
        }
        User userActivation = this.userRepo.findById(validation.getUser().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu!"));
        userActivation.setActif(true);
        this.userRepo.save(userActivation);
    }


    //CHERCHER UN UTILISATEUR DANS LA BD EN FONCTION DES INFOS SAISIES
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur inconnu!"));
    }

    public void resetPassword(Map<String, String> parametres) {
        User user = (User) this.loadUserByUsername(parametres.get("email"));
        this.validationService.save(user);
    }

    public void newPassword(Map<String, String> parametres) {
        User user = (User) this.loadUserByUsername(parametres.get("email"));
        Validation validation = validationService.readCode(parametres.get("code"));
        if (validation.getUser().getEmail().equals(user.getEmail())) {
            String mdp = this.passwordEncoder.encode(parametres.get("password"));
            user.setPassword(mdp);
            this.userRepo.save(user);
        }
    }


}
