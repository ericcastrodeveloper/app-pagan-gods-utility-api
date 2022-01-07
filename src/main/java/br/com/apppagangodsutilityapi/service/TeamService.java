package br.com.apppagangodsutilityapi.service;

import br.com.apppagangodsutilityapi.entity.Team;
import br.com.apppagangodsutilityapi.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository repository;

    public List<Team> getAllTeam() {
        return repository.findAll();
    }

    public List<Team> getTeamsByIdUser(Long idUser) {
        return repository.findByIdUser(idUser);
    }

    public Team saveTeam(Team team) {
        Long id = getNextId();
        team.setId(id);
        return repository.save(team);
    }

    public Team update(Team team) {
        return repository.save(team);
    }

    public void delete(Long idTeam) {
        repository.deleteById(idTeam);
    }

    private Long getNextId() {
        return repository.count() + 1;
    }

}
