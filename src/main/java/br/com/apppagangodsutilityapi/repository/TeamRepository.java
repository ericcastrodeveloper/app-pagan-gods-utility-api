package br.com.apppagangodsutilityapi.repository;

import br.com.apppagangodsutilityapi.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team, Long> {
    List<Team> findByIdUser(Long idUser);
}
