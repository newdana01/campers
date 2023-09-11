package everyCamp.campback.team.dto;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@SuperBuilder
public class TeamCreateDto extends TeamBaseDto{
    private String userId;
    private String intro;
//    private Set<String> preferAgeRange;
//    private Set<String> preferSex;

}
