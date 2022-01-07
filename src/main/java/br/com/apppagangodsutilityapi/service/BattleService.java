package br.com.apppagangodsutilityapi.service;

import br.com.apppagangodsutilityapi.entity.Battle;
import br.com.apppagangodsutilityapi.entity.BattleId;
import br.com.apppagangodsutilityapi.repository.BattleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BattleService {
    private BattleRepository repository;

    public List<Battle> getAllBattle() {
        return repository.findAll();
    }

    public Battle saveBattle(Battle battle) {
        return repository.save(battle);
    }

    public Battle update(Battle battle) {
        return repository.save(battle);
    }

    public Battle getFurByAmountDaysAndTeam(Long numberDays, Long teamId) {
        LocalDate date = LocalDate.now().minusDays(numberDays);
        List<Battle> battles = repository.findByBattleIdIdTeamAndBattleIdDateGreaterThanEqual(teamId, date);
        Long amountFur = battles.stream().mapToLong(Battle::getAmountFur).sum();
        Battle battle = new Battle();
        battle.setAmountFur(amountFur);
        return battle;
    }

    public void delete(LocalDateTime date, Long idTeam) {
        repository.deleteById(new BattleId(date, idTeam));
    }

    public List<Battle> getAllBattleByIdTeam(Long idTeam) {
        return repository.findByBattleIdIdTeamOrderByBattleIdDateAsc(idTeam);
    }

    public Optional<Battle> getAllBattleByBattleId(LocalDateTime date, Long idTeam) {
        return repository.findById(new BattleId(date, idTeam));
    }
}
