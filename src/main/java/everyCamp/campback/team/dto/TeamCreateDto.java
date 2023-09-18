package everyCamp.campback.team.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeamCreateDto extends TeamBaseDto{
    private String userId;
    private String intro;
    private Boolean isPosted;
//    private Set<String> preferAgeRange;
//    private Set<String> preferSex;

}
