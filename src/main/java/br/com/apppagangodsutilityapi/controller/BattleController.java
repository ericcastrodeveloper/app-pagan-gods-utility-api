package br.com.apppagangodsutilityapi.controller;

import br.com.apppagangodsutilityapi.entity.Battle;
import br.com.apppagangodsutilityapi.service.BattleService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pagan-gods/battle")
@AllArgsConstructor
public class BattleController {

    private BattleService service;

    @GetMapping
    public ResponseEntity<List<Battle>> getAllBattle(){
        return ResponseEntity.ok(service.getAllBattle());
    }

    @GetMapping("/date/{date}/idTeam/{idTeam}")
    public ResponseEntity<Optional<Battle>> getAllBattleByIdTeam(@PathVariable(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime date, @PathVariable(name = "idTeam") Long idTeam){
        return ResponseEntity.ok(service.getAllBattleByBattleId(date, idTeam));
    }

    @GetMapping("/{idTeam}")
    public ResponseEntity<List<Battle>> getBattleByBattleId(@PathVariable(name = "idTeam") Long idTeam){
        return ResponseEntity.ok(service.getAllBattleByIdTeam(idTeam));
    }

    @PostMapping
    public ResponseEntity<Battle> saveBattle(@RequestBody Battle battle){
        return new ResponseEntity(service.saveBattle(battle), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Battle> updateBattle(@RequestBody Battle battle){
        return new ResponseEntity(service.update(battle), HttpStatus.OK);
    }

    @DeleteMapping("/date/{date}/idTeam/{idTeam}")
    public void deleteBattle(@PathVariable(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime date, @PathVariable(name = "idTeam") Long idTeam){
        service.delete(date, idTeam);
    }

    @GetMapping("/totalFur/numberDays/{numberDays}/idTeam/{idTeam}")
    public ResponseEntity<Battle> getFurByAmountDaysAndTeam(@PathVariable Long numberDays, @PathVariable Long idTeam){
        return ResponseEntity.ok(service.getFurByAmountDaysAndTeam(numberDays, idTeam));
    }

}
