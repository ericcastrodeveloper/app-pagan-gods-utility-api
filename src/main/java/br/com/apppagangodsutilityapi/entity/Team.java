package br.com.apppagangodsutilityapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "team")
public class Team {
    @Id
    private Long id;
    private String name;
    private String description;
    private Long strength;
    private Long idUser;

}
