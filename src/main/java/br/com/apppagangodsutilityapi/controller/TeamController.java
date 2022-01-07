package br.com.apppagangodsutilityapi.controller;

import br.com.apppagangodsutilityapi.entity.Battle;
import br.com.apppagangodsutilityapi.entity.Team;
import br.com.apppagangodsutilityapi.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pagan-gods/teams")
@AllArgsConstructor
public class TeamController {

    private TeamService service;

    @GetMapping
    public List<Team> getAllTeam(){
        return service.getAllTeam();
    }

    @GetMapping("/user/{idUser}")
    public List<Team> getTeamsByIdUser(@PathVariable Long idUser){
        return service.getTeamsByIdUser(idUser);
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team){
        return service.saveTeam(team);
    }

    @DeleteMapping("/{idTeam}")
    public void deleteBattle(@PathVariable Long idTeam){
        service.delete(idTeam);
    }

    @PutMapping
    public ResponseEntity<Team> updateBattle(@RequestBody Team team){
        return new ResponseEntity(service.update(team), HttpStatus.OK);
    }



}
