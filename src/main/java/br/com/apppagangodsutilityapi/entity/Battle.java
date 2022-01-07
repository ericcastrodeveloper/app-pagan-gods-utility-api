package br.com.apppagangodsutilityapi.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "battle")
public class Battle {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BattleId battleId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field(name = "amount_paw")
    private Long amountPaw;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Field(name = "amount_fur")
    private Long amountFur;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dungeon;
}
