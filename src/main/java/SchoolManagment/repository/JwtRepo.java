package SchoolManagment.repository;

import SchoolManagment.entity.Jwt;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

public interface JwtRepo extends JpaRepository<Jwt, String> {
    Optional<Jwt> findByValue(String value);


    @Query("FROM Jwt j WHERE j.expired = :expired AND j.desactiver = :desactiver AND j.user.email = :email")
    Optional<Jwt> findUserValideToken(String email, boolean desactiver, boolean expired);

    @Query("FROM Jwt j WHERE j.user.email = :email")
    Stream<Jwt> findUserByEmail(String email);

}
