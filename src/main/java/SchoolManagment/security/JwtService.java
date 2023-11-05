package SchoolManagment.security;

import SchoolManagment.entity.Jwt;
import SchoolManagment.entity.User;
import SchoolManagment.repository.JwtRepo;
import SchoolManagment.serviceImpl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Transactional
@Slf4j
@Service
@AllArgsConstructor
public class JwtService {

    public static final String BEARER = "bearer";
    private final String ENCRYPTION_KEY = "9eedff3d8a220f99409c1eaecc87fdd8bfd5ba4693aebb77b2ebbdbdeafec6ca";

    private UserServiceImpl userService;
    private JwtRepo jwtRepo;

    public Map<String, String> generate(String username){
        User user = (User) this.userService.loadUserByUsername(username);

        Map<String, String> jwtMap = this.generateJwt(user);

        Jwt jwt = Jwt
                .builder()
                .value(jwtMap.get(BEARER))
                .desactiver(false)
                .expired(false)
                .user(user)
                .build();
        this.jwtRepo.save(jwt);
        return jwtMap;
    }



    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Map<String, String> generateJwt(User user){
        final long currentTime = System.currentTimeMillis();
        final long expirationTime = currentTime + 30 * 60 * 1000;

        Map<String, Object> claims = Map.of(
                "nom", user.getFullname(),
                Claims.EXPIRATION, new Date(expirationTime),
                Claims.SUBJECT, user.getEmail()
        );


        String bearer = Jwts.builder()
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(expirationTime))
                .setSubject(user.getEmail())
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of(BEARER, bearer);
    }

    public Key getKey() {
        byte[] decoder = Decoders.BASE64.decode(ENCRYPTION_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }


    public String extractUsername(String token){
        return this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationFromToken(token);
        return expirationDate.before(new Date());
    }

    private Date getExpirationFromToken(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    private <T> T getClaim(String token, Function<Claims, T> function){
        Claims claims = getAllClaims(token);
        return function.apply(claims);
    }

    public Jwt tokenByValue(String value) {
        return this.jwtRepo.findByValue(value).orElseThrow(() -> new RuntimeException("Token inconnu!"));
    }

    public void deconnexion() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Jwt jwt = this.jwtRepo.findUserValideToken(
                user.getEmail(),
                false,
                false
        ).orElseThrow(() -> new RuntimeException("Token invalide!"));
        jwt.setExpired(true);
        jwt.setDesactiver(true);
        this.jwtRepo.save(jwt);
    }


    //Pour nettoyer les jwt de la bd
//    @Scheduled(cron = "0 */1 * * * *")
//    public void removeUselessJwt(){
//        log.info("Suppression des tokens a {}", Instant.now());
//        this.jwtRepo.deleteAllByExpiredAndDesactive(true, true);
//    }
}
