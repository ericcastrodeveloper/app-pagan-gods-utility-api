package br.com.apppagangodsutilityapi.repository;

import br.com.apppagangodsutilityapi.entity.Battle;
import br.com.apppagangodsutilityapi.entity.BattleId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface BattleRepository extends MongoRepository<Battle, BattleId> {
    List<Battle> findByBattleIdIdTeamAndBattleIdDateGreaterThanEqual(Long idTeam, LocalDate date);
    List<Battle> findByBattleIdIdTeamOrderByBattleIdDateAsc(Long battleId);
}
