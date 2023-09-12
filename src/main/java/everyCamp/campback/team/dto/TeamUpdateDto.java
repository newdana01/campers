package everyCamp.campback.team.dto;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import lombok.Builder;
import lombok.Getter;
import java.util.Set;

@Getter
@Builder
public class TeamUpdateDto {
    private String teamName;
    private Set<PreferRegion> preferRegions;
    private Set<PreferType> preferTypes;
    private String intro;
    private int recruitNumber;
    //    private Set<String> preferAgeRange;
    //    private Set<String> preferSex;
}
