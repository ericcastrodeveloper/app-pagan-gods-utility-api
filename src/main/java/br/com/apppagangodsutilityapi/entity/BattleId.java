package br.com.apppagangodsutilityapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BattleId {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private Long idTeam;

}
