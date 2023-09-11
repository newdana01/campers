package everyCamp.campback.team.dto;

import everyCamp.campback.common.entity.PreferRegion;
import everyCamp.campback.common.entity.PreferType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
@NoArgsConstructor
public abstract class TeamBaseDto {
    private String teamName;
    private int recruitNumber;
    private List<PreferRegion> preferRegions = new ArrayList<>();
    private List<PreferType> preferTypes = new ArrayList<>();
}
