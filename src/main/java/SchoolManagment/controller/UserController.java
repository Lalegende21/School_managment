package SchoolManagment.controller;

import SchoolManagment.dto.AuthenticationDTO;
import SchoolManagment.entity.User;
import SchoolManagment.security.JwtService;
import SchoolManagment.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    //Creation du compte
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "inscription")
    public String register(@RequestBody User user) {
        try {
            this.userService.createUser(user);
            return "Register successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }



    //Activation du compte
    @PostMapping(path = "activation")
    public String activation(@RequestBody Map<String, String> activation) {
        try {
            this.userService.activation(activation);
            return "Account activate successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }



    //Reset password
    @PostMapping(path = "modifier-mot-de-passe")
    public String resetPassword(@RequestBody Map<String, String> activation) {
        try {
            this.userService.resetPassword(activation);
            return "Password reset successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }



    //New password
    @PostMapping(path = "nouveau-mot-de-passe")
    public String newPassword(@RequestBody Map<String, String> activation) {
        try {
            this.userService.newPassword(activation);
            return "Password done successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }



    //Deconnexion du compte
    @PostMapping(path = "deconnexion")
    public String deconnexion() {
        try {
            this.jwtService.deconnexion();
            return "Deconnexion successfully!";
        }catch (Exception e){
            System.out.println(e);
            return "Something went wrong!";
        }
    }


    //Connexion du compte
    @PostMapping(path = "connexion")
    public Map<String, String> connexion(@RequestBody AuthenticationDTO authenticationDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password())
            );

            if (authenticate.isAuthenticated()){
                return this.jwtService.generate(authenticationDTO.username());
            }
            return null;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
