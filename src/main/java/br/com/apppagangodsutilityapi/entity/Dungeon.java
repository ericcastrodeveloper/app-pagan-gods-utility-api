package br.com.apppagangodsutilityapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Dungeon {
    @Id
    private Long id;
    private String name;
    private String description;
}
